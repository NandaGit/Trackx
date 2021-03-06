package com.trackx.truelocate.testreport;


import org.testng.Reporter;

/**
 * This class is used for test methods to log messages that will be included 
 * in the HTML reports generated by TestNG.
 */
public class ReporterLog {
	
	public static final String SEPERATOR = "|";

	 /**
	   * Log the passed string to the HTML reports
	   * @param s The message to log
	   */
	synchronized public static void log(String s) {
		
		StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
		
		int cnt=0;
		String[] testScriptDetails = new String[2];
		
		for(StackTraceElement stack : stackTraceElement){
			String cn = stack.getClassName();

			if(cn.trim().equalsIgnoreCase("com.truex.truelocate.testreport.ReporterLog")){
				testScriptDetails[0] = stackTraceElement[cnt+1].getClassName();
				testScriptDetails[1] = stackTraceElement[cnt+1].getMethodName();
				break;
			}
			cnt++;
		}
		Reporter.log("Testscript Name = " + testScriptDetails[0] + SEPERATOR + " Testcase Name = " + testScriptDetails[1] + SEPERATOR + " Msg = " + s);
	}

}
