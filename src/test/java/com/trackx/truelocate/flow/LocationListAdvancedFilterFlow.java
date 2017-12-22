package com.trackx.truelocate.flow;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
import com.trackx.truelocate.pagecomponents.CommonElements;
import com.trackx.truelocate.pagecomponents.FacilityElements;
import com.trackx.truelocate.pagecomponents.IMLocationListElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class LocationListAdvancedFilterFlow extends GeneralActions{
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	IMLocationListElements imLocationlistelements;
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
	
	/**
	 * LocationList Advanced Filter Search
	 */
	@Test(priority = 2, dataProvider = "filterData")
	public void facilityAdvancedFilterFlow(String sFilterCode, String sFilterName, String sFilterDescription,
			String sFilterLoactiontype,String sFilterLocationTypedropdown,
			String sFilterFacility,String sFilterFacilitydropdown)throws Exception {
		try {
			imLocationlistelements.menuClick();
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickAdvancedFilterOpen(driver);
			ReusableActions.takeSnapshot(driver, className);
			imLocationlistelements.enterLocationListAdvancedFilterInfo(sFilterCode, sFilterName, sFilterDescription, 
					sFilterLoactiontype, sFilterLocationTypedropdown,
					sFilterFacility, sFilterFacilitydropdown);
			commonElements.clickAdvancedSearch(driver);
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			if(commonElements.filtetResultValidation(sFilterCode)){
				TestNGResults.put("25", new Object[] { "LocationList Advanced Filter",
						"LocationList Advanced Filter successful", "Pass" });
			} else {
				TestNGResults.put("25", new Object[] { "LocationList Advanced Filter",
						"LocationList Advanced Filter", "Fail" });
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
	
	@DataProvider
	public static Object[][] filterData() {
		return GeneralActions.getData("LoactionListAdvanceFilter");
	}
}
