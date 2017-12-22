package com.trackx.truelocate.flow;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;
import com.trackx.truelocate.pagecomponents.UserCreationElements;


public class IMUserEditFlow extends GeneralActions{
	WebDriver driver;

	Truelocatelogin truelocatelogin;
	UserCreationElements rbCreateUser;

	// Logger log4jlogger =Logger.getLogger("devpinoyLogger");

	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "chrome");
		truelocatelogin = PageFactory.initElements(driver, Truelocatelogin.class);
		rbCreateUser = PageFactory.initElements(driver, UserCreationElements.class);
		ReusableActions.loadPropFileValues();
		ReusableActions.openUrl(driver, ReusableActions.getPropFileValues("Url"));
	}

	/**
	 * Login Script
     */
	@Test(priority = 1, dataProviderClass = Truelocatelogin.class, dataProvider = "getData")
	public void userclickflow(String sUsername, String sPassword)
			throws Exception {
		try {

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

	/*
	 * User Edit
	 */
	@Test(priority = 2, dataProvider = "Updatedata")
	public void userEditFlow(String sEmail, String sFirstName, String sLastName)throws Exception {
		try {
			//rbCreateUser.userMenuClick();
			rbCreateUser.globalSearch(sEmail);
			Thread.sleep(10000);
			rbCreateUser.clickUser(sEmail);
			Thread.sleep(1000);
			rbCreateUser.EditUser();
			Thread.sleep(10000);
			rbCreateUser.editcode(sFirstName, sLastName);
			Thread.sleep(1000);
			boolean result = rbCreateUser.validation();
			if (result) {
				TestNGResults.put("3", new Object[] { "User screen",
						"User updated successfully", "Pass" });
				Assert.assertTrue(true);
			} else {
				TestNGResults.put("3", new Object[] { "User screen",
						"User not updated", "Fail" });
				Assert.assertTrue(false);
			}
		}
		catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	@DataProvider
	public static Object[][] Updatedata() {
		return GeneralActions.getData("UpdateUser");
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
