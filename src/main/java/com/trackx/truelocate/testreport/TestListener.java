package com.trackx.truelocate.testreport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.trackx.truelocate.common.utils.GeneralActions;


public class TestListener extends TestListenerAdapter {
WebDriver driver;
private static String fileSeperator = System.getProperty("file.separator");
public static String testClassName,  testMethodName,  screenShotName;
private static String dir = System.getProperty("user.dir");

// @Override
public static String getCurrentTimeStamp() {
	SimpleDateFormat CurrentDate = new SimpleDateFormat("MM-dd-yyyy" + "_"
			+ "HH-mm-ss");
	Date now = new Date();
	String CDate = CurrentDate.format(now);
	return CDate;
}

public void onTestFailure(ITestResult result) {
	Reporter.log("***** Error " + result.getName()
			+ " test has failed *****", true);

	driver = GeneralActions.getDriver();

	String testClassName = getTestClassName(result.getName()).trim();

	String testMethodName = result.getName().toString().trim();
	String screenShotName = testMethodName + getCurrentTimeStamp() + ".png";

	if (driver != null) {
		String imagePath = fileSeperator + "Screenshots" + fileSeperator
				+ "Results" + fileSeperator + testClassName + fileSeperator
				+ takeScreenShot(driver, screenShotName, testClassName);

		Reporter.log(
				"<a href="
						+ dir
						+ imagePath
						+ "><img src="
						+ dir
						+ imagePath
						+ " style=width:100px;height:100px;/> screenshot </a><br/>",
				true);
	}
}

public static String takeScreenShot(WebDriver driver,
		String screenShotName, String testClassName) {
	try {
		File file = new File("Screenshots" + fileSeperator + "Results");
		if (!file.exists()) {
			Reporter.log("File created " + file, true);
			file.mkdir();
		}

		File screenshotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("Screenshots" + fileSeperator
				+ "Results" + fileSeperator + testClassName, screenShotName);
		FileUtils.copyFile(screenshotFile, targetFile);

		return screenShotName;
	} catch (Exception e) {
		Reporter.log(
				"An exception occured while taking screenshot "
						+ e.getCause(), true);
		return null;
	}
}

public void onTestSuccess(ITestResult result) {

	Reporter.log("***** " + result.getName() + " test has Passed *****",
			true);

	driver = GeneralActions.getDriver();

	String testClassName = getTestClassName(result.getName()).trim();

	String testMethodName = result.getName().toString().trim();
	String screenShotName = testMethodName + getCurrentTimeStamp() + ".png";

	if (driver != null) {
		String imagePath = fileSeperator + "Screenshots" + fileSeperator
				+ "Results" + fileSeperator + testClassName + fileSeperator
				+ takeScreenShot(driver, screenShotName, testClassName);
		// + getCurrentTimeStamp());
		Reporter.log(
				"<a href="
						+ dir
						+ imagePath
						+ "><img src="
						+ dir
						+ imagePath
						+ " style=width:100px;height:100px;/> screenshot </a><br/>",
				true);
	}

}

public void onTestSkipped(ITestResult result) {

	Reporter.log("***** Error " + result.getName()
			+ " test has Skipped *****", true);

}

public String getTestClassName(String testName) {
	String[] reqTestClassname = testName.split("\\.");
	int i = reqTestClassname.length - 1;
	Reporter.log("Test Name : " + reqTestClassname[i], true);
	return reqTestClassname[i];
}
}