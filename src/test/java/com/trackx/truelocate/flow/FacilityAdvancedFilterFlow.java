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
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class FacilityAdvancedFilterFlow extends GeneralActions{
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	FacilityElements facilityElements;
	CommonElements commonElements;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();
	
	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "ie");
		truelocatelogin = PageFactory.initElements(driver, Truelocatelogin.class);
		facilityElements = PageFactory.initElements(driver, FacilityElements.class);
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
	 * Facility Advanced Filter Search
	 */
	@Test(priority = 2, dataProvider = "filterData")
	public void facilityAdvancedFilterFlow(String sCode, String sName, String sFacilityType, 
			String sTimeZone, String sSystemofMeasurement, String sCity, String sState,
			String sVerifiedAddress, String sShipFrom, String sShipTo)throws Exception {
		try {
			//facilityElements.adminMenuClick();
			facilityElements.menuClick();
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickAdvancedFilterOpen(driver);
			ReusableActions.takeSnapshot(driver, className);
			facilityElements.enterAdvancedFilterInfo(sCode, sName, sFacilityType, sTimeZone, 
					sSystemofMeasurement, sCity, sState, sVerifiedAddress, sShipFrom, sShipTo);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickAdvancedSearch(driver);
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			if(commonElements.filtetResultValidation(sCode)){
				TestNGResults.put("26", new Object[] { "Facility Advance Filter",
						"Facility Advance Filter successful", "Pass" });
			} else {
				TestNGResults.put("26", new Object[] { "Facility Advance Filter",
						"Facility Advance Filter", "Fail" });
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
		return GeneralActions.getData("FacilityAdvancedFilter");
	}
}
