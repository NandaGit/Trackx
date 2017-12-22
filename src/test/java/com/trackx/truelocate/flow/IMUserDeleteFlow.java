package com.trackx.truelocate.flow;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
import com.trackx.truelocate.pagecomponents.UserCreationElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class IMUserDeleteFlow extends GeneralActions{
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	UserCreationElements rbCreateUser;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();
	

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
			ReusableActions.takeSnapshot(driver, className);
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

	/**
	 * User Edit
	 */
	@Test(priority = 2, dataProvider = "deletedata")
	public void userEditFlow(String sEmail)throws Exception {
		try {
			//rbCreateUser.userMenuClick();
			Thread.sleep(10000);
			ReusableActions.takeSnapshot(driver, className);
			rbCreateUser.globalSearch(sEmail);
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			Thread.sleep(10000);
			rbCreateUser.clickUser(sEmail);
			Thread.sleep(10000);
			ReusableActions.takeSnapshot(driver, className);
			rbCreateUser.deleteUser();
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			String alertMessage = rbCreateUser.alertMessage();
			Assert.assertEquals(alertMessage, constants.delete_user_successmsg);
			if (alertMessage.equalsIgnoreCase(constants.delete_user_successmsg)) {
				TestNGResults.put("3", new Object[] { "User screen",
						"User deleted successfully", "Pass" });
				Assert.assertTrue(true);
			} else {
				TestNGResults.put("3", new Object[] { "User screen",
						"User not deleted", "Fail" });
				Assert.assertTrue(false);
			}
		}
		catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	@DataProvider
	public static Object[][] deletedata() {
		return GeneralActions.getData("DeleteUser");
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
