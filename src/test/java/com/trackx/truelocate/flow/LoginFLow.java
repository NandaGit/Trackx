package com.trackx.truelocate.flow;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class LoginFLow extends GeneralActions {
	static WebDriver driver;
	Truelocatelogin truelocatelogin;

	@BeforeClass
	public void setUp() throws IOException {
		driver = launchBrowser(driver, "Chrome");
		truelocatelogin = PageFactory.initElements(driver,
				Truelocatelogin.class);
		ReusableActions.loadPropFileValues();
		ReusableActions.openUrl(driver,
				ReusableActions.getPropFileValues("Url"));
	}

	/**
	 * Login Checkout Flow Test Script
	 */

	@Test(priority=1,dataProviderClass=Truelocatelogin.class, dataProvider="getData")
	public void LoginFlow(String sUsername,String sPassword) throws Exception {
		try{
			 truelocatelogin.enterUsernamepassword(sUsername, sPassword);
		     Thread.sleep(1000);	
			if (truelocatelogin.pageTitleValidation()) {
				TestNGResults.put("2", new Object[] { "Login screen",
						"Login successful", "Pass" });
			}else {
				TestNGResults.put("2", new Object[] { "Login screen",
						"Login Failed", "Fail" });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void quitDriver() {
		try {
			Thread.sleep(5000);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	


