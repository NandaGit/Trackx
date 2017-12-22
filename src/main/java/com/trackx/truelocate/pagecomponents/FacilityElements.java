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

public class FacilityElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	CommonElements commonElements = new CommonElements();
	public Logger log4jlogger = Logger.getLogger("devpinoyLogger");

	/**
	 * Create screen Elements
	 */
	@FindBy(id = "createCode")
	WebElement txt_code;

	@FindBy(xpath = "//*[@id=\"edit-form\"]/fieldset[1]/div[1]/section[2]/label[2]/input")
	WebElement txt_name;

	@FindBy(id = "createDescription")
	WebElement txt_description;

	@FindBy(id = "s2id_createEntityLocation")
	WebElement dropdown_region;

	@FindBy(xpath = "//*[@id=\"select2-results-2\"]/li")
	List<WebElement> list_region;

	@FindBy(id = "s2id_facilityType")
	WebElement dropdown_facilityType;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li")
	List<WebElement> list_facilityType;

	@FindBy(id = "s2id_applicationType")
	WebElement dropdown_applicationType;

	@FindBy(xpath = "//*[@id=\"select2-results-4\"]/li")
	List<WebElement> list_applicationType;

	@FindBy(linkText = "Address")
	WebElement tab_address;

	@FindBy(linkText = "Configuration")
	WebElement tab_configuration;

	/**
	 * Address section
	 */

	@FindBy(id = "createAddress1")
	WebElement txt_addressLine1;

	@FindBy(id = "createAddress2")
	WebElement txt_addressLine2;

	@FindBy(id = "createCity")
	WebElement txt_city;

	@FindBy(id = "createState")
	WebElement txt_state;

	@FindBy(xpath = "//*[@id=\"address_detailsCreate\"]/div[1]/section[5]/label[2]/input")
	WebElement txt_zipcode;

	@FindBy(id = "createCountry")
	WebElement txt_country;

	@FindBy(xpath = "//*[@id=\"address_detailsCreate\"]/div[1]/section[7]/label[2]/input")
	WebElement txt_contactName;

	@FindBy(xpath = "//*[@id=\"address_detailsCreate\"]/div[1]/section[8]/label[2]/input")
	WebElement txt_contact;

	@FindBy(xpath = "//*[@id=\"address_detailsCreate\"]/div[1]/section[9]/label[2]/input")
	WebElement txt_email;

	@FindBy(xpath = "//*[@id=\"address_detailsCreate\"]/div[2]/div[1]/div[1]/section[1]/label[2]/input")
	WebElement txt_latitude;

	@FindBy(xpath = "//*[@id=\"address_detailsCreate\"]/div[2]/div[1]/div[1]/section[2]/label[2]/input")
	WebElement txt_longitude;

	@FindBy(xpath = "//*[@id=\"address_detailsCreate\"]/div[2]/div[1]/div[2]/section/label[2]/textarea")
	WebElement txt_geoFence;

	@FindBy(xpath = "//*[@id=\"address_detailsCreate\"]/div[2]/div[1]/div[3]/section/span/label/span[2]")
	WebElement togglebtn_verifiedAddress;

	/**
	 * Configuration Section
	 */
	@FindBy(xpath = "//*[@id=\"configuration_detailsCreate\"]/div/section[1]/span/label/span[2]")
	WebElement togglebtn_inventoryMgd;

	@FindBy(xpath = "//*[@id=\"configuration_detailsCreate\"]/div/section[2]/span/label/span[2]")
	WebElement togglebtn_billTo;

	@FindBy(xpath = "//*[@id=\"configuration_detailsCreate\"]/div/section[4]/span/label/span[2]")
	WebElement togglebtn_shipTo;

	@FindBy(xpath = "//*[@id=\"configuration_detailsCreate\"]/div/section[5]/span/label/span[2]")
	WebElement togglebtn_shipFrom;

	@FindBy(xpath = "//*[@id=\"configuration_detailsCreate\"]/div/section[6]/span/label/span[2]")
	WebElement togglebtn_crossDock;

	@FindBy(id = "select2-chosen-6")
	WebElement dropdown_billToFacility;

	@FindBy(xpath = "//*[@id=\"select2-results-6\"]/li")
	List<WebElement> list_billToFacility;

	@FindBy(id = "select2-chosen-8")
	WebElement dropdown_timeZone;

	@FindBy(xpath = "//*[@id=\"select2-results-8\"]/li")
	List<WebElement> list_timeZone;

	@FindBy(id = "select2-chosen-10")
	WebElement dropdown_systemOfMeasurement;

	@FindBy(xpath = "//*[@id=\"select2-results-10\"]/li")
	List<WebElement> list_systemOfMeasurement;
	
	/**
	 * View Screen Elements
	 */
	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[1]/label[2]")
	WebElement label_code;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[2]/label[2]")
	WebElement label_name;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[3]/label[2]")
	WebElement label_description;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[4]/label[2]")
	WebElement label_region;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[5]/label[2]")
	WebElement label_facilityType;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[6]/label[2]")
	WebElement label_applicationType;
	
	
	/**
	 * View Address Section
	 */
	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[1]/section[1]/label[2]")
	WebElement label_addressLine1;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[1]/section[2]/label[2]")
	WebElement label_addressLine2;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[1]/section[3]/label[2]")
	WebElement label_city;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[1]/section[4]/label[2]")
	WebElement label_state;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[1]/section[5]/label[2]")
	WebElement label_zipcode;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[1]/section[6]/label[2]")
	WebElement label_country;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[1]/section[7]/label[2]")
	WebElement label_contactName;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[1]/section[8]/label[2]")
	WebElement label_contact;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[1]/section[9]/label[2]")
	WebElement label_email;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[2]/div[1]/section[1]/label[2]")
	WebElement label_latitude;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[2]/div[1]/section[2]/label[2]")
	WebElement label_longitude;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[2]/div[1]/section[3]/label[2]")
	WebElement label_geoFence;

	@FindBy(xpath = "//*[@id=\"address_details\"]/div/div/div[2]/div[1]/section[4]/label[2]")
	WebElement label_verifiedAddress;

	/**
	 * View Configuration Section
	 */
	@FindBy(xpath = "//*[@id=\"configuration_details\"]/div/div/div/section[1]/label[2]")
	WebElement label_inventoryManaged;

	@FindBy(xpath = "//*[@id=\"configuration_details\"]/div/div/div/section[2]/label[2]")
	WebElement label_billTo;

	@FindBy(xpath = "//*[@id=\"configuration_details\"]/div/div/div/section[4]/label[2]")
	WebElement label_shipTo;

	@FindBy(xpath = "//*[@id=\"configuration_details\"]/div/div/div/section[5]/label[2]")
	WebElement label_shipFrom;

	@FindBy(xpath = "//*[@id=\"configuration_details\"]/div/div/div/section[6]/label[2]")
	WebElement label_crossDock;

	@FindBy(xpath = "//*[@id=\"configuration_details\"]/div/div/div/section[7]/label[2]")
	WebElement label_timeZone;

	@FindBy(xpath = "//*[@id=\"configuration_details\"]/div/div/div/section[8]/label[2]")
	WebElement label_systemofMeasurement;

	/**
	 * Menu Elements
	 */
	@FindBy(xpath = "//*[contains(text(),' Administration')]")
	WebElement menu_administration;

	@FindBy(linkText = "Site")
	WebElement menu_site;
	
	/**
	 * toggle button
	 */
	@FindBy(id = "verifiedAddress")
	WebElement toggleselection_verifiedAddress;
	
	@FindBy(id = "inventoryManaged")
	WebElement toggleselection_inventory;

	@FindBy(id = "billTo")
	WebElement toggleselection_billTo;

	@FindBy(id = "shipTo")
	WebElement toggleselection_shipTo;

	@FindBy(id = "shipFrom")
	WebElement toggleselection_shipFrom;

	@FindBy(id = "crossDock")
	WebElement toggleselection_crossDock;

	/**
	 * Advanced Filter Elements
	 */
	@FindBy(xpath = "//input[@ng-model=\"filter.code\"]")
	WebElement adv_code;

	@FindBy(xpath = "//input[@ng-model=\"filter.name\"]")
	WebElement adv_name;

	@FindBy(id = "s2id_autogen12")
	WebElement adv_facilitydropdown;
	
	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li")
	List<WebElement> adv_failityList;

	@FindBy(id = "select2-chosen-14")
	WebElement adv_timeZonedropdown;

	@FindBy(xpath = "//*[@id=\"select2-results-14\"]/li")
	List<WebElement> adv_timeZoneList;

	
	@FindBy(id = "select2-chosen-16")
	WebElement adv_somdropdown;

	@FindBy(xpath = "//*[@id=\"select2-results-16\"]/li")
	List<WebElement> adv_somList;

	@FindBy(xpath = "//input[@ng-model=\"filter.city\"]")
	WebElement adv_city;

	@FindBy(xpath = "//input[@ng-model=\"filter.stateOrProvince\"]")
	WebElement adv_stateOrProvince;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[8]/div/label[1]/span")
	WebElement adv_vaBoth;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[8]/div/label[1]/input")
	WebElement adv_vaBothChecked;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[8]/div/label[2]/span")
	WebElement adv_vaYes;
	
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[8]/div/label[2]/input")
	WebElement adv_vaYesChecked;
	
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[8]/div/label[3]/span")
	WebElement adv_vaNo;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[8]/div/label[3]/input")
	WebElement adv_vaNoChecked;
	
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[9]/div/label[1]/span")
	WebElement adv_sfBoth;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[9]/div/label[1]/input")
	WebElement adv_sfBothChecked;
	
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[9]/div/label[2]/span")
	WebElement adv_sfYes;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[9]/div/label[2]/input")
	WebElement adv_sfYesChecked;
	
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[9]/div/label[3]/span")
	WebElement adv_sfNo;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[9]/div/label[3]/input")
	WebElement adv_sfNoChecked;
	
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[10]/div/label[1]/span")
	WebElement adv_stBoth;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[10]/div/label[1]/input")
	WebElement adv_stBothChecked;
	
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[10]/div/label[2]/span")
	WebElement adv_stYes;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[10]/div/label[2]/input")
	WebElement adv_stYesChecked;
	
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[10]/div/label[3]/span")
	WebElement adv_stNo;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[10]/div/label[3]/input")
	WebElement adv_stNoChecked;
	
	/**
	 * Constructor for this class
	 * 
	 * @param driver
	 */
	public FacilityElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method used to click the item class menu
	 */
	public void menuClick() {
		try {
			inAction.buttonClick(driver, menu_administration,
					"Click button : menu_administration");
			inAction.linkClick(driver, menu_site, 
					"Click link: menu_site");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adminMenuClick() {
		try {
			commonElements.clickMenu(driver, "Administration");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method used to click the facility info
	 * 
	 * @param sCode
	 * @param sName
	 * @param sDescription
	 * @param sRegion
	 * @param sFacilityType
	 * @param sApplicationType
	 */
	public void enterFacilityInfo(String sCode, String sName,
			String sDescription, String sRegion, String sFacilityType,
			String sApplicationType) {
		try {
			inAction.waitForVisibilityOfElement(driver, txt_code);
			inAction.inputText(driver, txt_code, sCode, "Enter sCode : "
					+ sCode);
			inAction.waitForVisibilityOfElement(driver, txt_name);
			inAction.inputText(driver, txt_name, sName, "Enter sName : "
					+ sName);
			inAction.waitForVisibilityOfElement(driver, txt_description);
			inAction.inputText(driver, txt_description, sDescription,
					"Enter sDescription : " + sDescription);
			selectRegion(sRegion);
			selectFacilityType(sFacilityType);
			selectApplicationType(sApplicationType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to enter the address info
	 * 
	 * @param sAddressLine1
	 * @param sAddressLine2
	 * @param sCity
	 * @param sState
	 * @param sZipCode
	 * @param sCountry
	 * @param sContactName
	 * @param sContact
	 * @param sEmail
	 * @param sLatitude
	 * @param sLongitude
	 * @param sGeoFence
	 * @param sVerifiedAddress
	 */
	public void enterAddressInfo(String sAddressLine1, String sAddressLine2,
			String sCity, String sState, String sZipCode, String sCountry,
			String sContactName, String sContact, String sEmail,
			String sLatitude, String sLongitude, String sGeoFence,
			String sVerifiedAddress) {
		try {
			inAction.waitForVisibilityOfElement(driver, txt_addressLine1);
			inAction.inputText(driver, txt_addressLine1, sAddressLine1,
					"Enter sAddressLine1 : " + sAddressLine1);

			inAction.waitForVisibilityOfElement(driver, txt_addressLine2);
			inAction.inputText(driver, txt_addressLine2, sAddressLine2,
					"Enter sAddressLine2 : " + sAddressLine2);

			inAction.waitForVisibilityOfElement(driver, txt_city);
			inAction.inputText(driver, txt_city, sCity, "Enter sCity : "
					+ sCity);

			inAction.waitForVisibilityOfElement(driver, txt_state);
			inAction.inputText(driver, txt_state, sState, "Enter sState : "
					+ sState);

			inAction.waitForVisibilityOfElement(driver, txt_zipcode);
			inAction.inputText(driver, txt_zipcode, sZipCode,
					"Enter sZipCode : " + sZipCode);

			inAction.waitForVisibilityOfElement(driver, txt_country);
			inAction.inputText(driver, txt_country, sCountry,
					"Enter sCountry : " + sCountry);

			inAction.waitForVisibilityOfElement(driver, txt_contactName);
			inAction.inputText(driver, txt_contactName, sContactName,
					"Enter sContactName : " + sContactName);

			inAction.waitForVisibilityOfElement(driver, txt_contact);
			inAction.inputText(driver, txt_contact, sContact,
					"Enter sContact : " + sContact);

			inAction.waitForVisibilityOfElement(driver, txt_email);
			inAction.inputText(driver, txt_email, sEmail,
					"Enter sEmail : " + sEmail);
			
			/*inAction.waitForVisibilityOfElement(driver, txt_latitude);
					"Enter sLongitude : " + sLongitude);

					"Enter sLongitude : " + sLongitude);*/
			
			inAction.waitForVisibilityOfElement(driver, txt_geoFence);
			inAction.inputText(driver, txt_geoFence, sGeoFence,
					"Enter sGeoFence : " + sGeoFence);
			clickVerifiedAddress(sVerifiedAddress);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to enter the configuration info
	 * 
	 * @param sInventoryManaged
	 * @param sBillTo
	 * @param sBillToFacility
	 * @param sShipTo
	 * @param sShipFrom
	 * @param sCrossDock
	 * @param sTimeZone
	 * @param sSystemofMeasurement
	 */
	public void enterConfigurationInfo(String sInventoryManaged,
			String sBillTo, String sBillToFacility, String sShipTo,
			String sShipFrom, String sCrossDock, String sTimeZone,
			String sSystemofMeasurement) {
		try {
			inAction.linkClick(driver, tab_configuration, "Click link: "
					+ tab_configuration);
			clickInventoryManaged(sInventoryManaged);
			clickBillTo(sBillTo);
			if (sBillTo.equalsIgnoreCase("false")) {
				selectBillToFacility(sBillToFacility);
			}
			clickShipTo(sShipTo);
			clickShipFrom(sShipFrom);
			clickCrossDock(sCrossDock);
			selectTimeZone(sTimeZone);
			selectSystemOfMeasurement(sSystemofMeasurement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click the verified address toggle button
	 * 
	 * @param sVerifiedAddress
	 */
	public void clickVerifiedAddress(String sVerifiedAddress) {
		boolean boovar = ReusableActions
				.isElementSelected(toggleselection_verifiedAddress);
		String str = String.valueOf(boovar);
		if (!sVerifiedAddress.equalsIgnoreCase(str)
				& StringUtils.isNotBlank(sVerifiedAddress)) {
			inAction.waitForVisibilityOfElement(driver, togglebtn_verifiedAddress);
			ReusableActions.selectedRadioButton(driver, togglebtn_verifiedAddress,
					"click toggle button: sVerifiedAddress");
		}
	}

	/**
	 * This method used to click the Inventory Managed toggle button
	 * 
	 * @param sInventoryManaged
	 */
	public void clickInventoryManaged(String sInventoryManaged) {
		boolean boovar = ReusableActions
				.isElementSelected(toggleselection_inventory);
		String str = String.valueOf(boovar);
		if (!sInventoryManaged.equalsIgnoreCase(str)
				& StringUtils.isNotBlank(sInventoryManaged)) {
			inAction.waitForVisibilityOfElement(driver, togglebtn_inventoryMgd);
			ReusableActions.selectedRadioButton(driver, togglebtn_inventoryMgd,
					"click toggle button: sInventoryManaged");
		}
	}

	/**
	 * This method used to click the Bill To toggle button
	 * 
	 * @param sInventoryManaged
	 * @param sBillToFacility
	 */
	public void clickBillTo(String sBillTo) {
		boolean boovar = ReusableActions
				.isElementSelected(toggleselection_billTo);
		String str = String.valueOf(boovar);
		if (!sBillTo.equalsIgnoreCase(str) & StringUtils.isNotBlank(sBillTo)) {
			inAction.waitForVisibilityOfElement(driver, togglebtn_billTo);
			ReusableActions.selectedRadioButton(driver, togglebtn_billTo,
					"click toggle button: togglebtn_billTo");
		}
	}

	/**
	 * This method used to click the Ship To toggle button
	 * 
	 * @param sShipTo
	 */
	public void clickShipTo(String sShipTo) {
		boolean boovar = ReusableActions
				.isElementSelected(toggleselection_shipTo);
		String str = String.valueOf(boovar);
		if (!sShipTo.equalsIgnoreCase(str) & StringUtils.isNotBlank(sShipTo)) {
			inAction.waitForVisibilityOfElement(driver, togglebtn_shipTo);
			ReusableActions.selectedRadioButton(driver, togglebtn_shipTo,
					"click toggle button: togglebtn_shipTo");
		}
	}

	/**
	 * This method used to click the Ship From toggle button
	 * 
	 * @param sShipFrom
	 */
	public void clickShipFrom(String sShipFrom) {
		boolean boovar = ReusableActions
				.isElementSelected(toggleselection_shipFrom);
		String str = String.valueOf(boovar);
		if (!sShipFrom.equalsIgnoreCase(str)
				& StringUtils.isNotBlank(sShipFrom)) {
			inAction.waitForVisibilityOfElement(driver, togglebtn_shipFrom);
			ReusableActions.selectedRadioButton(driver, togglebtn_shipFrom,
					"click toggle button: togglebtn_shipFrom");
		}
	}

	/**
	 * This method used to click the Cross Dock toggle button
	 * 
	 * @param sCrossDock
	 */
	public void clickCrossDock(String sCrossDock) {
		boolean boovar = ReusableActions
				.isElementSelected(toggleselection_crossDock);
		String str = String.valueOf(boovar);
		if (!sCrossDock.equalsIgnoreCase(str)
				& StringUtils.isNotBlank(sCrossDock)) {
			inAction.waitForVisibilityOfElement(driver, togglebtn_crossDock);
			ReusableActions.selectedRadioButton(driver, togglebtn_crossDock,
					"click toggle button: togglebtn_crossDock");
		}
	}

	/**
	 * This method used to select the region
	 * 
	 * @param region
	 */
	public void selectRegion(String region) {
		try {
			inAction.waitForElementToBeClickable(driver, dropdown_region);
			inAction.buttonClick(driver, dropdown_region,
					"Click protocol dropdown : " + region);
			Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, list_region, region);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select the facility type
	 * 
	 * @param facility_type
	 */
	public void selectFacilityType(String facility_type) {
		try {
			inAction.waitForElementToBeClickable(driver, dropdown_facilityType);
			inAction.buttonClick(driver, dropdown_facilityType,
					"Click protocol dropdown : " + facility_type);
			Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, list_facilityType,
					facility_type);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select the application type
	 * 
	 * @param application_type
	 */
	public void selectApplicationType(String application_type) {
		try {
			inAction.waitForElementToBeClickable(driver,
					dropdown_applicationType);
			inAction.buttonClick(driver, dropdown_applicationType,
					"Click protocol dropdown : " + application_type);
			Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, list_applicationType,
					application_type);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select the Bill To Facility
	 * 
	 * @param bill_to_facility
	 */
	public void selectBillToFacility(String bill_to_facility) {
		try {
			inAction.waitForElementToBeClickable(driver,
					dropdown_billToFacility);
			inAction.buttonClick(driver, dropdown_billToFacility,
					"Click protocol dropdown : " + bill_to_facility);
			Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, list_billToFacility,
					bill_to_facility);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select the Time Zone
	 * 
	 * @param timeZone
	 */
	public void selectTimeZone(String timeZone) {
		try {
			inAction.waitForElementToBeClickable(driver, dropdown_timeZone);
			inAction.buttonClick(driver, dropdown_timeZone,
					"Click protocol dropdown : " + timeZone);
			Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, list_timeZone, timeZone);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select the System of Measurement
	 * 
	 * @param sysMs
	 */
	public void selectSystemOfMeasurement(String sysMs) {
		try {
			inAction.waitForElementToBeClickable(driver,
					dropdown_systemOfMeasurement);
			inAction.buttonClick(driver, dropdown_systemOfMeasurement,
					"Click protocol dropdown : " + sysMs);
			Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, list_systemOfMeasurement,
					sysMs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select the facility in the advanced filter section
	 * 
	 * @param sFacilityType
	 */
	public void selectAdvFacility(String sFacilityType) {
		try {
			inAction.waitForElementToBeClickable(driver, adv_facilitydropdown);
			inAction.buttonClick(driver, adv_facilitydropdown,
					"Click protocol dropdown : adv_facilitydropdown");
			Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, adv_failityList,
					sFacilityType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select the time zone in the advanced filter section
	 * 
	 * @param sTimeZone
	 */
	public void selectAdvTimeZone(String sTimeZone) {
		try {
			inAction.waitForElementToBeClickable(driver, adv_timeZonedropdown);
			inAction.buttonClick(driver, adv_timeZonedropdown,
					"Click protocol dropdown : adv_timeZonedropdown");
			Thread.sleep(10000);
			inAction.selectByTextInDropdown(driver, adv_timeZoneList,
					sTimeZone);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to select the time zone in the advanced filter section
	 * 
	 * @param sTimeZone
	 */
	public void selectAdvSystemOfMeasurement(String sSystemofMeasurement) {
		try {
			inAction.waitForElementToBeClickable(driver, adv_somdropdown);
			inAction.buttonClick(driver, adv_somdropdown,
					"Click protocol dropdown : adv_somdropdown");
			Thread.sleep(10000);
			inAction.selectByTextInDropdown(driver, adv_somList,
					sSystemofMeasurement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method used to click the Verified Address toggle button
	 * 
	 * @param sVerifiedAddress
	 */
	public void clickAdvVerifiedAddress(String sVerifiedAddress) {
		if(sVerifiedAddress.equalsIgnoreCase("Both") && 
				!ReusableActions.isElementSelected(adv_vaBothChecked)){
			inAction.waitForVisibilityOfElement(driver, adv_vaBoth);
			ReusableActions.selectedRadioButton(driver, adv_vaBoth,
					"click toggle button: adv_vaBoth");
		} else if(sVerifiedAddress.equalsIgnoreCase("Yes") && 
				!ReusableActions.isElementSelected(adv_vaYesChecked)){
			inAction.waitForVisibilityOfElement(driver, adv_vaYes);
			ReusableActions.selectedRadioButton(driver, adv_vaYes,
					"click toggle button: adv_vaYes");
		} else if(sVerifiedAddress.equalsIgnoreCase("No") && 
				!ReusableActions.isElementSelected(adv_vaNoChecked)){
			inAction.waitForVisibilityOfElement(driver, adv_vaNo);
			ReusableActions.selectedRadioButton(driver, adv_vaNo,
					"click toggle button: adv_vaNo");
		}
	}
	
	/**
	 * This method used to click the ship From toggle button
	 * 
	 * @param sShipFrom
	 */
	public void clickAdvShipFrom(String sShipFrom) {
		if(sShipFrom.equalsIgnoreCase("Both") && !ReusableActions.isElementSelected(adv_sfBothChecked)){
			inAction.waitForVisibilityOfElement(driver, adv_sfBoth);
			ReusableActions.selectedRadioButton(driver, adv_sfBoth,
					"click toggle button: adv_sfBoth");
		} else if(sShipFrom.equalsIgnoreCase("Yes") && !ReusableActions.isElementSelected(adv_sfYesChecked)){
			inAction.waitForVisibilityOfElement(driver, adv_sfYes);
			ReusableActions.selectedRadioButton(driver, adv_sfYes,
					"click toggle button: adv_sfYes");
		} else if(sShipFrom.equalsIgnoreCase("No") && !ReusableActions.isElementSelected(adv_sfNoChecked)){
			inAction.waitForVisibilityOfElement(driver, adv_sfNo);
			ReusableActions.selectedRadioButton(driver, adv_sfNo,
					"click toggle button: adv_sfNo");
		}
	}
	
	/**
	 * This method used to click the ship From toggle button
	 * 
	 * @param sShipTo
	 */
	public void clickAdvShipTo(String sShipTo) {
		if(sShipTo.equalsIgnoreCase("Both") && !ReusableActions.isElementSelected(adv_stBothChecked)){
			inAction.waitForVisibilityOfElement(driver, adv_stBoth);
			ReusableActions.selectedRadioButton(driver, adv_stBoth,
					"click toggle button: adv_stBoth");
		} else if(sShipTo.equalsIgnoreCase("Yes") && !ReusableActions.isElementSelected(adv_stYesChecked)){
			inAction.waitForVisibilityOfElement(driver, adv_stYes);
			ReusableActions.selectedRadioButton(driver, adv_stYes,
					"click toggle button: adv_stYes");
		} else if(sShipTo.equalsIgnoreCase("No") && !ReusableActions.isElementSelected(adv_stNoChecked)){
			inAction.waitForVisibilityOfElement(driver, adv_stNo);
			ReusableActions.selectedRadioButton(driver, adv_stNo,
					"click toggle button: adv_stNo");
		}
	}
	
	/**
	 * This method used to enter advanced filter value
	 * 
	 * @param sCode
	 * @param sName
	 * @param sFacilityType
	 * @param sTimeZone
	 * @param sSystemofMeasurement
	 * @param sCity
	 * @param sState
	 * @param sVerifiedAddress
	 * @param sShipFrom
	 * @param sShipTo
	 */
	public void enterAdvancedFilterInfo(String sCode, String sName,
			String sFacilityType, String sTimeZone,
			String sSystemofMeasurement, String sCity, String sState,
			String sVerifiedAddress, String sShipFrom, String sShipTo) {
		try {
			inAction.waitForVisibilityOfElement(driver, adv_code);
			inAction.inputText(driver, adv_code, sCode, "Enter sCode : "
					+ sCode);
			inAction.waitForVisibilityOfElement(driver, adv_name);
			inAction.inputText(driver, adv_name, sName, "Enter sName : "
					+ sName);
			selectAdvFacility(sFacilityType);
			selectAdvTimeZone(sTimeZone);
			selectAdvSystemOfMeasurement(sSystemofMeasurement);
			inAction.waitForVisibilityOfElement(driver, adv_city);
			inAction.inputText(driver, adv_city, sCity, "Enter sCity : "
					+ sCity);
			inAction.waitForVisibilityOfElement(driver, adv_stateOrProvince);
			inAction.inputText(driver, adv_stateOrProvince, sState, "Enter sName : "
					+ sState);
			clickAdvVerifiedAddress(sVerifiedAddress);
			clickAdvShipFrom(sShipFrom);
			clickAdvShipTo(sShipTo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
