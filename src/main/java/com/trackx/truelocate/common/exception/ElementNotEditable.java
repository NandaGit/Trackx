package com.trackx.truelocate.common.exception;
import org.openqa.selenium.WebDriverException;

public class ElementNotEditable extends WebDriverException{

		private static final long serialVersionUID = 8715153063354345519L;

		public ElementNotEditable() {
			super();}
		
		public ElementNotEditable(String message){
			super(message);}
		
		public ElementNotEditable(String message, Throwable thr){
			super(message, thr);}
}
