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
import com.trackx.truelocate.pagecomponents.IMRegionElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class IMRegionCreateFlow extends GeneralActions {
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	IMRegionElements imregionelements;
	CommonElements commonElements;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();

	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "chrome");
		truelocatelogin = PageFactory.initElements(driver,
				Truelocatelogin.class);
		imregionelements = PageFactory.initElements(driver,
				IMRegionElements.class);
		commonElements = PageFactory.initElements(driver, CommonElements.class);
		ReusableActions.loadPropFileValues();
		ReusableActions.openUrl(driver,
				ReusableActions.getPropFileValues("Url"));
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
			} else {
				TestNGResults.put("2", new Object[] { "Login screen",
						"Login Failed", "Fail" });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Region Create
	 */
	@Test(priority = 2, dataProvider = "createData")
	public void regionCreateFlow(String sCode, String sName) throws Exception {
		try {
			System.out.println("First Priority *************");
			imregionelements.menuClick();
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickCreatebutton(driver);
			imregionelements.enterRegionInfo(sCode, sName);
			commonElements.clickCreateOrUpdatebutton(driver);
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			String alertMessage = commonElements.alertMessage(driver);
			if (alertMessage.equalsIgnoreCase(constants.add_region_successmsg)) {
				TestNGResults.put("3", new Object[] { "Region screen",
						"Region added successfully", "Pass" });
				Assert.assertEquals(alertMessage,
						constants.add_region_successmsg);
			} else {
				TestNGResults.put("3", new Object[] { "Region screen",
						"Region not created", "Fail" });
				Assert.assertEquals(alertMessage,
						constants.add_region_successmsg);
			}
		}
	    catch (Exception e) {
			e.printStackTrace();
			
		}
    }
	
	@Test(priority = 3, dataProvider = "createData")
	public void regionUniqueValidationFlow(String sCode, String sName) throws Exception {
		try {
			System.out.println("second Priority *************");
			Thread.sleep(1000);
			commonElements.clickCreatebutton(driver);
			imregionelements.enterRegionInfo(sCode, sName);
			commonElements.clickCreateOrUpdatebutton(driver);
			ReusableActions.takeSnapshot(driver, className);
			String alertMessage = commonElements.alertMessage(driver);
			if (alertMessage.equalsIgnoreCase(constants.add_region_uniquevalidation)) {
				TestNGResults.put("4", new Object[] { "Region screen",
						"Region feilds should be Unique", "Pass" });
				Assert.assertEquals(alertMessage,
						constants.add_region_uniquevalidation);
			} else {
				TestNGResults.put("4", new Object[] { "Region screen",
						"Region should be Unique", "Fail" });
				Assert.assertEquals(alertMessage,
						constants.add_region_uniquevalidation);
			}
			commonElements.clickCancelbutton(driver);
		}
	    catch (Exception e) {
			e.printStackTrace();
			
		}
    }
	@Test(priority = 4)
	public void regionMissingFeildFlow() throws Exception {
		try {
			System.out.println("Third Priority *************");
			Thread.sleep(1000);
			commonElements.clickCreatebutton(driver);
			commonElements.clickCreateOrUpdatebutton(driver);
			ReusableActions.takeSnapshot(driver, className);
			String alertMessage = commonElements.alertMessage(driver);
			if (alertMessage.equalsIgnoreCase(constants.add_region_missingfeildvalidation)) {
				TestNGResults.put("5", new Object[] { "Region screen",
						"Region feilds Should not be empty", "Pass" });
				Assert.assertEquals(alertMessage,
						constants.add_region_missingfeildvalidation);
			} else {
				TestNGResults.put("5", new Object[] { "Region screen",
						"Region feilds should not be empty", "Fail" });
				Assert.assertEquals(alertMessage,
						constants.add_region_missingfeildvalidation);
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
		return GeneralActions.getData("Region");
	}
}
