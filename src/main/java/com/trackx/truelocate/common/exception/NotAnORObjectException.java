package com.trackx.truelocate.common.exception;

public class NotAnORObjectException extends RuntimeException{
	
	private static final long serialVersionUID = -2322683908333292143L;

	public NotAnORObjectException(){
		super();
	}

	public NotAnORObjectException(String message){
		super(message);
	}
	
	public NotAnORObjectException(String message, Throwable cause){
		super(message, cause);
	}
}