package com.trackx.truelocate.flow;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
import com.trackx.truelocate.pagecomponents.UserCreationElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class IMUserCreateFlow extends GeneralActions {
	static WebDriver driver;
	Truelocatelogin truelocatelogin;
	UserCreationElements usercreationelements;
	Constants constants;

	Logger log4jlogger = Logger.getLogger("devpinoyLogger");

	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "Chrome");
		truelocatelogin = PageFactory.initElements(driver,
				Truelocatelogin.class);
		usercreationelements = PageFactory.initElements(driver, UserCreationElements.class);
		ReusableActions.loadPropFileValues();
		ReusableActions.openUrl(driver,
				ReusableActions.getPropFileValues("Url"));
	}

	/**
	 * Login Script
	 */
	@Test(priority = 1, dataProviderClass = Truelocatelogin.class, dataProvider = "getData")
	public void siteclickflow(String sUsername, String sPassword)
			throws Exception {
		try {
			truelocatelogin.enterUsernamepassword(sUsername, sPassword);
			Thread.sleep(1000);
			if (truelocatelogin.pageTitleValidation()) {
				TestNGResults.put("2", new Object[] { "Login screen",
						"Login successful", "Pass" });
			} else {
				TestNGResults.put("2", new Object[] { "Login screen",
						"Login Failed", "Fail" });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * User creation script
	 */
	@Test(priority = 2, dataProviderClass = UserCreationElements.class, dataProvider = "getData")
	public void userCreationFlow(String sEmail, String sFirstname,
			String sLastname, String sMobile, String sLanguage,
			String sPassword, String sConfirmpassword, String sPortal,
			String sRole) throws Exception {
		try {
			//usercreationelements.userMenuClick();
			usercreationelements.clickCreateButton1();
			usercreationelements.enterUserInfo(sEmail, sFirstname, sLastname, sMobile,
					sLanguage, sPassword, sConfirmpassword, sPortal, sRole);
			usercreationelements.clickCreateButton();
			if (usercreationelements.alertMessageValidation()) {
				TestNGResults.put("3", new Object[] { "User screen",
						"User created successfully", "Pass" });
			} else {
				TestNGResults.put("2", new Object[] { "Login screen",
						"User created failed" });
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
