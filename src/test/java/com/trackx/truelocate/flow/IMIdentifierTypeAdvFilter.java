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
import com.trackx.truelocate.pagecomponents.IMIdentifierTypeElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class IMIdentifierTypeAdvFilter extends GeneralActions {
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	CommonElements commonElements;
	IMIdentifierTypeElements imIdentifierTypeElements;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();

	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "chrome");
		truelocatelogin = PageFactory.initElements(driver,
				Truelocatelogin.class);
		imIdentifierTypeElements = PageFactory.initElements(driver,
				IMIdentifierTypeElements.class);
		commonElements = PageFactory.initElements(driver, CommonElements.class);
		ReusableActions.loadPropFileValues();
		ReusableActions.openUrl(driver,
				ReusableActions.getPropFileValues("Url"));
	}

	/**
	 * Login Script
	 */
	@Test(priority = 1, dataProviderClass = Truelocatelogin.class, dataProvider = "getData")
	public void userLogin(String sUsername, String sPassword) throws Exception {
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

	/**
	 * Identifier Type Advanced Filter Functionality
	 * 
	 * @param sCode
	 * @param sName
	 * @param sDescription
	 * @param sIsRFID
	 * @param sProtocol
	 * @throws Exception
	 */
	@Test(priority = 2, dataProvider = "filterData")
	public void identifierTypeAdvFilterFlow(String sCode, String sName,
			String sIsRFID, String sProtocol, String sFromDate, String
			sToDate) throws Exception {
		try {
			imIdentifierTypeElements.menuClick();
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickAdvancedFilterOpen(driver);
			ReusableActions.takeSnapshot(driver, className);
			imIdentifierTypeElements.enterAdvancedFilterInfo(sCode, sName,
					sIsRFID, sProtocol, sFromDate, sToDate);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickAdvancedSearch(driver);
			ReusableActions.takeSnapshot(driver, className);
			if (commonElements.filtetResultValidation(sCode)) {
				TestNGResults.put("24", new Object[] {
						"Identifier Type Advance Filter",
						"Identifier Type Advance Filter successful", "Pass" });
			} else {
				TestNGResults.put("24", new Object[] {
						"Identifier Type Advance Filter",
						"Identifier Type Advance Filter", "Fail" });
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
		return GeneralActions.getData("IdentifierTypeAdvFilter");
	}
}
