package com.trackx.truelocate.common.exception;

import org.openqa.selenium.WebDriverException;

public class ElementNotVisible extends WebDriverException{
	
	private static final long serialVersionUID = -7873853822431102430L;

	public ElementNotVisible() {
		super();}
	
	public ElementNotVisible(String message){
		super(message);}
	
	public ElementNotVisible(String message, Throwable thr){
		super(message, thr);}
}
