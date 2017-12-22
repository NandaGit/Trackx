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
import com.trackx.truelocate.pagecomponents.IMProvisionElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class ProvisionAdvancedFilterFlow extends GeneralActions{
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	IMProvisionElements improvisionelements;
	CommonElements commonElements;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();
	
	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "firefox");
		truelocatelogin = PageFactory.initElements(driver, Truelocatelogin.class);
		improvisionelements = PageFactory.initElements(driver, IMProvisionElements.class);
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
	public void facilityAdvancedFilterFlow(String sFilterItem, String sFilterItemdropdown,
			String sFilterFacility,String sFilterFacilitydropdown,
			String sFilterLoactiontype,String sFilterLocationTypedropdown,String sFromDate,String sToDate)throws Exception {
		try {
			improvisionelements.menuClick();
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickAdvancedFilterOpen(driver);
			ReusableActions.takeSnapshot(driver, className);
			improvisionelements.enterProvisionAdvancedFilterInfo(sFilterItem, sFilterItemdropdown, 
					sFilterFacility, sFilterFacilitydropdown,
					sFilterLoactiontype,sFilterLocationTypedropdown,sFromDate,sToDate);
			//commonElements.calendar(driver,sValue);
			commonElements.clickAdvancedSearch(driver);
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			if(commonElements.filtetResultValidation(sFilterItem)){
				TestNGResults.put("25", new Object[] { "Provision Advanced Filter",
						"Provision Advanced Filter successful", "Pass" });
			} else {
				TestNGResults.put("25", new Object[] { "Provision Advanced Filter",
						"Provision Advanced Filter", "Fail" });
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
		return GeneralActions.getData("ProvisionAdvanceFilter");
	}
}
