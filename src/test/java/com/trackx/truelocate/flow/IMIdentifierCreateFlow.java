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
import com.trackx.truelocate.pagecomponents.CommonElements;
import com.trackx.truelocate.pagecomponents.IMIdentifierTypeElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class IMIdentifierCreateFlow extends GeneralActions {
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	IMIdentifierTypeElements identifierTypeElements;
	CommonElements commonElements;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();
	
	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "chrome");
		truelocatelogin = PageFactory.initElements(driver, Truelocatelogin.class);
		identifierTypeElements = PageFactory.initElements(driver, IMIdentifierTypeElements.class);
		commonElements = PageFactory.initElements(driver, CommonElements.class);
		ReusableActions.loadPropFileValues();
		ReusableActions.openUrl(driver, ReusableActions.getPropFileValues("Url"));
	}

	/**
	 * Login Script
     */
	@Test(priority = 1, dataProviderClass = Truelocatelogin.class, dataProvider = "getData")
	public void userLogin(String sUsername, String sPassword)
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

	/*
	 * Item Class Create
	 */
	@Test(priority = 2, dataProvider = "createData")
	public void identifierTypeCreateFlow(String sCode, String sName, String sRFID, String sProtocol)throws Exception {
	
		try {
			identifierTypeElements.menuClick();
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickCreatebutton(driver);
			identifierTypeElements.enterIdentifierTypeInfo(sCode, sName, sRFID, sProtocol);
			commonElements.clickCreateOrUpdatebutton(driver);
			ReusableActions.takeSnapshot(driver, className);
			String alertMessage = commonElements.alertMessage(driver);
			if (alertMessage.equalsIgnoreCase(constants.add_identifier_type_successmsg)) {
				TestNGResults.put("8", new Object[] { "Item Type screen",
						"Item Type added successfully", "Pass" });
				Assert.assertEquals(alertMessage, constants.add_identifier_type_successmsg);
			} else {
				TestNGResults.put("8", new Object[] { "Item Type screen",
						"Item Type not created", "Fail" });
				Assert.assertEquals(alertMessage, constants.add_identifier_type_successmsg);
			}
		}
		catch (Exception e) {
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
	
	@DataProvider
	public static Object[][] createData() {
		return GeneralActions.getData("IdentifierType");
	}

}
