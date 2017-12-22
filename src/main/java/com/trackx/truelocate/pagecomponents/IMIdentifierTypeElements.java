package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class IMIdentifierTypeElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	CommonElements commonElements = new CommonElements();

	/**
	 * Create screen Elements
	 */
	@FindBy(id = "createCode")
	WebElement txt_code;

	@FindBy(id = "createName")
	WebElement txt_name;

	@FindBy(id="isRfid-checkbox")
	WebElement toggselection_RFID;
	
	@FindBy(className="onoffswitch-switch")
	WebElement togglebutton_RFID;

	@FindBy(id = "select2-chosen-2")
	WebElement dropdown_protocol;

	@FindBy(xpath = "//*[@id=\"select2-results-2\"]/li")
	List<WebElement> list_protocol;

	/**
	 * View Screen Elements
	 */
	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div/section[1]/label[2]")
	WebElement label_code;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div/section[2]/label[2]")
	WebElement label_name;

	@FindBy(id = "viewDescription")
	WebElement label_description;

	/**
	 * Menu Elements
	 */
	@FindBy(xpath = "//*[@id=\"menuField\"]/ul[2]/li/a/span")
	WebElement menu_inventory;

	@FindBy(linkText = "Master Data")
	WebElement menu_masterData;

	@FindBy(linkText = "Identifier Type")
	WebElement menu_identifierType;

	/**
	 * Advanced Filter Elements
	 */
	@FindBy(id = "filtercode")
	WebElement txt_filterCode;

	@FindBy(id = "filtername")
	WebElement txt_filterName;

	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[3]/div/label[1]/span")
	WebElement adv_vaBoth;

	@FindBy(xpath = "//*[@id='filterisRfidBoth']")
	WebElement adv_vaBothChecked;

	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[3]/div/label[2]/span")
	WebElement adv_vaYes;

	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[3]/div/label[2]/input")
	WebElement adv_vaYesChecked;

	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[3]/div/label[3]/span")
	WebElement adv_vaNo;

	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[3]/div/label[3]/input")
	WebElement adv_vaNoChecked;

	@FindBy(id = "s2id_filterProtocol")
	WebElement adv_filterProtocol;

	@FindBy(xpath = "//*[@id='select2-results-3']/li")
	List<WebElement> adv_protocolList;

	@FindBy(id = "fromDate")
	WebElement adv_fromDate;

	@FindBy(id = "toDate")
	WebElement adv_toDate;

	public IMIdentifierTypeElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method used to click the item class menu
	 */
	public void menuClick() {
		try {
			inAction.buttonClick(driver, menu_inventory,
					"Click button : menu_inventory");
			inAction.linkClick(driver, menu_masterData,
					"Click link:menu_masterData");
			inAction.linkClick(driver, menu_identifierType,
					"Click link: menu_identifierType");

			/*
			 * inAction.buttonClick(driver, menu_masterData,
			 * "Click button : menu_masterData"); inAction.buttonClick(driver,
			 * menu_identifierType, "Click button : menu_identifierType");
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to create Identifier Type
	 * 
	 * @param sCode
	 * @param sName
	 * @param sRFID
	 * @param sProtocol
	 */
	public void enterIdentifierTypeInfo(String sCode, String sName,
			String sRFID, String sProtocol) {
		try {
			inAction.waitForVisibilityOfElement(driver,txt_code);
			inAction.inputText(driver, txt_code, sCode,
					"Enter sCode : " + sCode);
			inAction.waitForVisibilityOfElement(driver,txt_name);
			inAction.inputText(driver, txt_name, sName,
					"Enter sFirstname : " + sName);	
			clickRFID(sRFID);
		    selectProtocol(sProtocol);
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * This method used to click RFID toggle button
	 * 
	 * @param sRFID
	 */
	public void clickRFID(String sRFID) {
		boolean boovar = ReusableActions
				.isElementSelected(toggselection_RFID);
		String str = String.valueOf(boovar);
		if (!sRFID.equalsIgnoreCase(str)
				& StringUtils.isNotBlank(sRFID)) {
			inAction.waitForVisibilityOfElement(driver, togglebutton_RFID);
			ReusableActions.selectedRadioButton(driver, togglebutton_RFID,
					"click toggle button: togglebutton_RFID");
		}
	}

	/**
	 * This method used to select the protocol
	 * 
	 * @param protocol
	 */
	public void selectProtocol(String protocol) {
		try {
			inAction.waitForElementToBeClickable(driver, dropdown_protocol);
			inAction.buttonClick(driver, dropdown_protocol,
					"Click protocol dropdown : " + protocol);
			Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, list_protocol, protocol);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click the Verified Address toggle button
	 * 
	 * @param sVerifiedAddress
	 */
	public void clickAdvIsRFID(String sRFIDValue) {
		if (sRFIDValue.equalsIgnoreCase("Both")
				&& !ReusableActions.isElementSelected(adv_vaBothChecked)) {
			inAction.waitForVisibilityOfElement(driver, adv_vaBoth);
			ReusableActions.selectedRadioButton(driver, adv_vaBoth,
					"click toggle button: adv_vaBoth");
		} else if (sRFIDValue.equalsIgnoreCase("Yes")
				&& !ReusableActions.isElementSelected(adv_vaYesChecked)) {
			inAction.waitForVisibilityOfElement(driver, adv_vaYes);
			ReusableActions.selectedRadioButton(driver, adv_vaYes,
					"click toggle button: adv_vaYes");
		} else if (sRFIDValue.equalsIgnoreCase("No")
				&& !ReusableActions.isElementSelected(adv_vaNoChecked)) {
			inAction.waitForVisibilityOfElement(driver, adv_vaNo);
			ReusableActions.selectedRadioButton(driver, adv_vaNo,
					"click toggle button: adv_vaNo");
		}
	}

	/**
	 * This method used to select the facility in the advanced filter section
	 * 
	 * @param sFacilityType
	 */
	public void selectAdvProtocol(String sProtocol) {
		try {
			inAction.waitForElementToBeClickable(driver, adv_filterProtocol);
			inAction.buttonClick(driver, adv_filterProtocol,
					"Click protocol dropdown : adv_filterProtocol");
			Thread.sleep(10000);
			inAction.selectByTextInDropdown(driver, adv_protocolList, sProtocol);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to enter the value in the advanced filter screen
	 * 
	 * @param sCode
	 * @param sName
	 * @param sIsRFID
	 * @param sProtocol
	 */
	public void enterAdvancedFilterInfo(String sCode, String sName,
			String sIsRFID, String sProtocol, String sFromDate, String sToDate) {
		try {
			inAction.waitForVisibilityOfElement(driver, txt_filterCode);
			inAction.inputText(driver, txt_filterCode, sCode, "Enter sCode : "
					+ sCode);
			inAction.waitForVisibilityOfElement(driver, txt_filterName);
			inAction.inputText(driver, txt_filterName, sName, "Enter sName : "
					+ sName);
			clickAdvIsRFID(sIsRFID);
			selectAdvProtocol(sProtocol);
			inAction.waitForElementToBeClickable(driver, adv_fromDate);
			inAction.buttonClick(driver, adv_fromDate, "Click from date field");
			commonElements.selectDate(driver, sFromDate);
			inAction.waitForElementToBeClickable(driver, adv_toDate);
			inAction.buttonClick(driver, adv_toDate, "Click from date field");
			commonElements.selectDate(driver, sToDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
