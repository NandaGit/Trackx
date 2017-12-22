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
import com.trackx.truelocate.pagecomponents.IMLocationListElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class IMLocationListEditFlow extends GeneralActions {
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	IMLocationListElements  imLocationlistelements;
	CommonElements commonElements;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();
	
	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "chrome");
		truelocatelogin = PageFactory.initElements(driver, Truelocatelogin.class);
		imLocationlistelements = PageFactory.initElements(driver, IMLocationListElements.class);
		commonElements = PageFactory.initElements(driver, CommonElements.class);
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

	/*
	 * Location List Edit
	 */
	
	@Test(priority = 2, dataProvider = "createData")
	public void locationListEditFlow(String sValue,String sCode,String sName,
			String sDescription,String sFacility,String sFacilitydropdown,
			String sLoactiontype,String sLocationTypedropdown)throws Exception {
		try {
			imLocationlistelements.menuClick();
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.globalSearch(sValue);
			commonElements.clickValue(driver, sValue);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickEditButton(driver);
			imLocationlistelements.enterLocationListInfo(sCode, sName,sDescription, 
					sFacility, sFacilitydropdown, sLoactiontype, sLocationTypedropdown);
			//commonElements.clickCreateOrUpdatebutton(driver);
			commonElements.clickUpdatebutton(driver);
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			String alertMessage = commonElements.alertMessage(driver);
			if (alertMessage.equalsIgnoreCase(constants.edit_locationlist_successmsg)) {
				TestNGResults.put("13", new Object[] { "LocationList edit screen",
						"LocationList edited successfully", "Pass" });	
				Assert.assertEquals(alertMessage, constants.edit_locationlist_successmsg);
			} else {
				TestNGResults.put("13", new Object[] { "LocationList edit screen",
						"LocationList not edited", "Fail" });
				Assert.assertEquals(alertMessage, constants.edit_locationlist_successmsg);
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
		return GeneralActions.getData("EditLocationlist");
	}

}
