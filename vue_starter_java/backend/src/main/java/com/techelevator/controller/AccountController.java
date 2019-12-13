package com.techelevator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.JwtTokenHandler;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.authentication.UserCreationException;
import com.techelevator.model.User;

/**
 * AccountController
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AuthProvider auth;

    @Autowired
    private JwtTokenHandler tokenHandler;

    @PostMapping(path = "/user/login")
    public String login(@RequestBody User user, RedirectAttributes flash) throws UnauthorizedException {
        if (auth.signIn(user.getUsername(), user.getPassword())) {
            User currentUser = auth.getCurrentUser();
            return tokenHandler.createToken(user.getUsername(), user.getRole(), currentUser.getEmail());
        } else {
            throw new UnauthorizedException();
        }
    }

    @PostMapping(path = "/user/register")
    public Object register(@Valid @RequestBody User user, BindingResult result, HttpServletResponse response) throws UserCreationException {
        if (result.hasErrors()) {
        	// Form validation failed
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            
            List<RegisterError> registerErrors = new ArrayList<>();
            
            for( ObjectError objError : result.getAllErrors() ) {
            	FieldError error = (FieldError)objError;
            	registerErrors.add(new RegisterError(error.getField(), error.getRejectedValue().toString(), error.getDefaultMessage()));
            }
            
            return new RegisterStatus(registerErrors);
        }
        
        try {
        	// try to add user
        	auth.register(user.getUsername(), user.getPassword(), user.getRole(), user.getEmail());
        } catch( DuplicateKeyException e ) {
        	// failed to add user: duplicate key
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            
            String[] split = e.getRootCause().getMessage().split("Detail: Key \\(");
            split = split[1].split("\\)=\\(");
            String column = split[0];
            String value = split[1].split("\\)")[0];
            
            return new RegisterStatus(new RegisterError(column, value, String.format("%s already exists", value)));
        }
        return new RegisterStatus(); // success
    }
    
    private class RegisterError {
    	private String column;
    	private String value;
    	private String error;
    	
    	public RegisterError(String column, String value, String error) {
    		this.column = column;
    		this.value = value;
    		this.error = error;
    	}
    	
    	public String getColumn() { return column; }
    	public String getValue() { return value; }
    	public String getError() { return error; }
    }
    
    private class RegisterStatus {
    	private String status;
    	private List<RegisterError> errors = null;
    	
    	private final String FAILED = "failed";
    	private final String SUCCESS = "success";
    	
    	public RegisterStatus() {
    		this.status = SUCCESS;
    	}
    	public RegisterStatus(List<RegisterError> errors) {
    		this.status = FAILED;
    		this.errors = errors;
    	}
    	public RegisterStatus(RegisterError error) {
    		this.status = FAILED;
    		this.errors = new ArrayList<>();
    		errors.add(error);
    	}
    	
    	public String getStatus() { return status; }
    	public List<RegisterError> getErrors() { return errors; }
    }
    
    private class RegisterStatusSerializer extends JsonSerializer<RegisterStatus> {
		@Override
		public void serialize(RegisterStatus value, JsonGenerator gen, SerializerProvider serializers)
				throws IOException, JsonProcessingException {
			gen.writeStartObject();
			gen.writeStringField("status", value.getStatus());
			if(value.getErrors() != null ) {
				gen.writeObjectField("errors", value.getErrors());
			}
		}
    }

    @PutMapping(path="/user/update")
    public void update() {
    	
    }
}