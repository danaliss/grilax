package com.techelevator.controller.response;

public class RegisterError extends ResponseError {
	private String column;
	private String value;
	
	public RegisterError(String column, String value, String error) {
		super(error);
		this.column = column;
		this.value = value;
	}
	
	public String getColumn() { return column; }
	public String getValue() { return value; }
}