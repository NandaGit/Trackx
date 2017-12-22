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
import com.trackx.truelocate.pagecomponents.IMItemClassElements;
import com.trackx.truelocate.pagecomponents.IMItemTypeElements;
import com.trackx.truelocate.pagecomponents.IMLocationListElements;
import com.trackx.truelocate.pagecomponents.IMRegionElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class IMItemTypeDeleteFlow extends GeneralActions {
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	IMItemTypeElements itemTypeElements;
	CommonElements commonElements;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();
	
	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "chrome");
		truelocatelogin = PageFactory.initElements(driver, Truelocatelogin.class);
		itemTypeElements = PageFactory.initElements(driver, IMItemTypeElements.class);
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
	 * ItemType Delete
	 */
	
	@Test(priority = 2, dataProvider = "createData")
	public void itemTypeDeleteFlow(String sValue)throws Exception {
		try {
			itemTypeElements.menuClick();
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.globalSearch(sValue);
			commonElements.clickValue(driver,sValue);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickDeleteButton(driver);
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			String alertMessage = commonElements.alertMessage(driver);
			if (alertMessage.equalsIgnoreCase(constants.delete_itemtype_successmsg)) {
				TestNGResults.put("21", new Object[] { "Item type delete screen",
						"Item type delete successfully", "Pass" });	
				Assert.assertEquals(alertMessage, constants.delete_itemtype_successmsg);
			} else {
				TestNGResults.put("21", new Object[] { "Item type delete screen",
						"Item type not deleted", "Fail" });
				Assert.assertEquals(alertMessage, constants.delete_itemtype_successmsg);
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
		return GeneralActions.getData("DeleteItemtype");
	}

}
