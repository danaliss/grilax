package com.techelevator.controller.response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=ResponseSerializer.class)
public class Response {
	private String status;
	private Object object;
	private List<ResponseError> errors = null;
	
	private final String FAILED = "failed";
	private final String SUCCESS = "success";
	
	public Response() {
		this.status = SUCCESS;
	}
	public Response(List<ResponseError> errors) {
		this.status = FAILED;
		this.errors = errors;
	}
	public Response(ResponseError error) {
		this.status = FAILED;
		this.errors = new ArrayList<>();
		errors.add(error);
	}
	public Response(Object object) {
		this.status = SUCCESS;
		this.object = object;
	}
	
	public String getStatus() { return status; }
	public List<ResponseError> getErrors() { return errors; }
	public Object getObject() { return object; }
}

class ResponseSerializer extends JsonSerializer<Response> {
	@Override
	public void serialize(Response value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException {
		jgen.writeStartObject();
		jgen.writeStringField("status", value.getStatus());
		if(value.getObject() != null ) {
			jgen.writeObjectField("object", value.getObject());
		}
		if(value.getErrors() != null ) {
			jgen.writeObjectField("errors", value.getErrors());
		}
		jgen.writeEndObject();
	}
}