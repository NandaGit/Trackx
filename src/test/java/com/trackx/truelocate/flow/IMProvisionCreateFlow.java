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
import com.trackx.truelocate.pagecomponents.IMProvisionElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class IMProvisionCreateFlow extends GeneralActions {
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	IMProvisionElements improvisionlements ;
	CommonElements commonElements;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();
	
	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "chrome");
		truelocatelogin = PageFactory.initElements(driver, Truelocatelogin.class);
		improvisionlements = PageFactory.initElements(driver, IMProvisionElements.class);
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
	 * Provision Create
	 */
	@Test(priority = 2, dataProvider = "createData")
	public void provisionCreateFlow(String sItem, String sItemdropdown, String sFacilitytype,String sFacilitydropdown,String sLoactiontype, String sLocationTypedropdown,String sStocknumber)throws Exception {
	
		try {
			improvisionlements.menuClick();
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickCreatebutton(driver);
			improvisionlements.enterProvisionListInfo(sItem, sItemdropdown, sFacilitytype, sFacilitydropdown, sLoactiontype, sLocationTypedropdown, sStocknumber);
			commonElements.clickCreateOrUpdatebutton(driver);
			ReusableActions.takeSnapshot(driver, className);
			String alertMessage = commonElements.alertMessage(driver);
			if (alertMessage.equalsIgnoreCase(constants.add_provision_successmsg)) {
				TestNGResults.put("10", new Object[] { "Provision  screen",
						"Provision added successfully", "Pass" });
				Assert.assertEquals(alertMessage, constants.add_provision_successmsg);
			} else {
				TestNGResults.put("10", new Object[] { "Provision screen",
						"Provision not created", "Fail" });
				Assert.assertEquals(alertMessage, constants.add_provision_successmsg);
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
		return GeneralActions.getData("Provision");
	}

}
