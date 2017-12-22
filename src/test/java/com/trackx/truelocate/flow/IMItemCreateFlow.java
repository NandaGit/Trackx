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
import com.trackx.truelocate.pagecomponents.IMItemElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class IMItemCreateFlow extends GeneralActions {
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	IMItemElements imitemelements;
	CommonElements commonElements;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();
	
	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "chrome");
		truelocatelogin = PageFactory.initElements(driver, Truelocatelogin.class);
		imitemelements = PageFactory.initElements(driver, IMItemElements.class);
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
	 * Item Create
	 */
	@Test(priority = 2, dataProvider = "createData")
	public void itemCreateFlow(String sItem, String sName,String sDescription, String sItemclass,
			String sItemclassdropdown,String sItemtype, String sItemTypedropdown,String sMinqty,
			String sMaxqty,String sInventorytype,String sInventorydropdown,String sInventory,String sActive,
			String sConsumable,String sIdentifierdropdown,String sUPC,String sCaseUPC,
			String sConveyance,String sBatchcode,String sUOM, String sUOMdropdown,
			String sEachweight,String sEachheight,String sEachlength,
			String sEachwidth,String sCaseweight,String sCaseheight, String sCaselength,
			String sCasewidth,String sQty,String sQtylayer,String sPallet, String sConveyancetype,
			String sManufacturename,String sItemnumber,String sMake,
			String sModel,String sSupplier, String sSuppliernumber)throws Exception {
		try {
			imitemelements.menuClick();
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickCreatebutton(driver);
			imitemelements.enterItemListInfo(sItem, sName, sDescription, sItemclass, sItemclassdropdown, sItemtype, sItemTypedropdown, sMinqty, sMaxqty, sInventorytype, sInventorydropdown, sInventory, sActive, sConsumable);
			imitemelements.enterIdentificationListInfo(sIdentifierdropdown, sUPC,sCaseUPC, sConveyance, sBatchcode, sUOM, sUOMdropdown);
			imitemelements.enterMeasurementListInfo(sEachweight, sEachheight, sEachlength, sEachwidth, sCaseweight, sCaseheight, sCaselength, sCasewidth, sQty, sQtylayer, sPallet, sConveyancetype);
			imitemelements.enterManufactureInfo(sManufacturename, sItemnumber, sMake, sModel, sSupplier, sSuppliernumber);
			commonElements.clickCreateOrUpdatebutton(driver);
			ReusableActions.takeSnapshot(driver, className);
			String alertMessage = commonElements.alertMessage(driver);
			
			if (alertMessage.equalsIgnoreCase(constants.add_item_successmsg)) {
				TestNGResults.put("9", new Object[] { "Item screen",
						"Item added successfully", "Pass" });
				Assert.assertEquals(alertMessage, constants.add_item_successmsg);
			} else {
				TestNGResults.put("9", new Object[] { "Item screen",
						"Item not created", "Fail" });
				Assert.assertEquals(alertMessage, constants.add_item_successmsg);
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
		return GeneralActions.getData("Item");
	}
}
