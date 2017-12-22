package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class IMLocationListElements {
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

	@FindBy(id = "createDescription")
	WebElement txt_description;

	@FindBy(id = "select2-chosen-2")
	WebElement dropdown_facility;
	
	@FindBy(id = "s2id_autogen2_search")
	WebElement txt_faciltiy;

	@FindBy(xpath = "//*[@id=\"select2-results-2\"]/li")
	List<WebElement> list_facility;

	@FindBy(id = "select2-chosen-3")
	WebElement dropdown_locationtype;

	@FindBy(id = "s2id_autogen3_search")
	WebElement txt_locationtype;
	
	@FindBy(xpath = "//*[@id=\"select2-results-3\"]/li")
	List<WebElement> list_locationtype;

	/**
	 * View Screen Elements
	 */

	@FindBy(xpath = "//*[@id='view-form']/fieldset[1]/div/section[1]/label[2]")
	WebElement label_code;

	@FindBy(xpath = "//*[@id='view-form']/fieldset[1]/div/section[2]/label[2]")
	WebElement label_name;

	/**
	 * Menu Elements
	 */
	@FindBy(xpath = "//*[@id='menuField']/ul[6]/li/a/span")
	WebElement menu_location;

	@FindBy(linkText = "Location List")
	WebElement menu_locationlist;

	public IMLocationListElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/**
	 * Advance Filter Elements
	 */
	
	@FindBy(id = "filtercode")
	WebElement txt_filtercode;

	@FindBy(id = "filtername")
	WebElement txt_filtername;
	
	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[3]/label[2]/input")
	WebElement txt_filterdesc;
	
	@FindBy(id = "select2-chosen-4")
	WebElement dropdown_fliterlocationtype;

	@FindBy(id = "s2id_autogen4_search")
	WebElement txt_filterlocationtype;
	
	@FindBy(xpath = "//*[@id=\"select2-results-4\"]/li")
	List<WebElement> list_filterlocationtype;
	
	@FindBy(id = "select2-chosen-5")
	WebElement dropdown_filterfacility;
	
	@FindBy(id = "s2id_autogen5_search")
	WebElement txt_filterfaciltiy;

	@FindBy(xpath = "//*[@id=\"select2-results-5\"]/li")
	List<WebElement> list_filterfacility;

	

	/**
	 * This method used to click LocationList menu
	 */
	public void menuClick() {
		try {
			inAction.buttonClick(driver, menu_location,
					"Click button : menu_location");
			inAction.linkClick(driver, menu_locationlist,
					"Click button : menu_locationlist");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to create Locationlist
	 * 
	 * @param sCode
	 * @param sName
	 * @param sDescription
	 * @param sFacility
	 * @param sFacility
	 * @param sDescription
	 * @param sLoactiontype
	 * @param sLoactiontype
	 * sLocationTypedropdown
	 */

	public void enterLocationListInfo(String sCode, String sName,String sDescription,
			String sFacility, String sFacilitydropdown, String sLoactiontype,
			String sLocationTypedropdown) {
		try {
			// inAction.waitForVisibilityOfElement(driver, txt_code);
			inAction.inputText(driver, txt_code, sCode, "Enter sCode : "
					+ sCode);
			// inAction.waitForVisibilityOfElement(driver, txt_name);
			inAction.inputText(driver, txt_name, sName, "Enter sFirstname : "
					+ sName);
			inAction.inputText(driver, txt_description, sName, "Enter sFirstname : "
					+ txt_description);
			sFacilitytype(sFacility,sFacilitydropdown);
			sLocationtype(sLoactiontype,sLocationTypedropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sFacilitytype(String sFacility,String sFacilitydropdown) {
		try {
			inAction.waitForElementToBeClickable(driver, dropdown_facility);
			inAction.buttonClick(driver, dropdown_facility,
					"Click button : dropdown_faciltiy");
			inAction.inputText(driver, txt_faciltiy, sFacility,
					"Enter sFacilityanme : " + sFacility);
			inAction.selectByTextInDropdown(driver, list_facility,
					sFacilitydropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sLocationtype(String sLoactiontype,String sLocationTypedropdown) {
		try {
			inAction.waitForElementToBeClickable(driver, dropdown_locationtype);
			inAction.buttonClick(driver, dropdown_locationtype,
					"Click button : dropdown_locationtype");
			inAction.inputText(driver, txt_locationtype, sLoactiontype,
					"Enter sLocationtype : " + sLoactiontype);
			inAction.selectByTextInDropdown(driver, list_locationtype,
					sLocationTypedropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	
	}
	public void enterLocationListAdvancedFilterInfo(String sFilterCode, String sFilterName,String sFilterDescription,
			String sFilterLoactiontype,String sFilterLocationTypedropdown,
			String sFilterFacility, String sFilterFacilitydropdown ) {
		try {
			// inAction.waitForVisibilityOfElement(driver, txt_filtercode);
			inAction.inputText(driver, txt_filtercode, sFilterCode, "Enter sCode : "
					+ sFilterCode);
			// inAction.waitForVisibilityOfElement(driver, txt_name);
			inAction.inputText(driver, txt_filtername, sFilterName, "Enter sFirstname : "
					+ sFilterName);
			inAction.inputText(driver, txt_filterdesc, sFilterDescription, "Enter sFirstname : "
					+ sFilterDescription);
			sFilterLocationtype(sFilterLoactiontype,sFilterLocationTypedropdown);
			sFilterFacilitytype(sFilterFacility,sFilterFacilitydropdown);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	public void sFilterFacilitytype(String sFilterFacility,String sFilterFacilitydropdown) {
		try {
			inAction.waitForElementToBeClickable(driver, dropdown_filterfacility);
			inAction.buttonClick(driver, dropdown_filterfacility,
					"Click button : dropdown_filterfacility");
			inAction.inputText(driver, txt_filterfaciltiy, sFilterFacility,
					"Enter sFacilityanme : " + sFilterFacility);
			inAction.selectByTextInDropdown(driver, list_filterfacility,
					sFilterFacilitydropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sFilterLocationtype(String sFilterLoactiontype,String sFilterLocationTypedropdown) {
		try {
			inAction.waitForElementToBeClickable(driver, dropdown_fliterlocationtype);
			inAction.buttonClick(driver, dropdown_fliterlocationtype,
					"Click button : dropdown_fliterlocationtype");
			inAction.inputText(driver, txt_filterlocationtype, sFilterLoactiontype,
					"Enter sLocationtype : " + sFilterLoactiontype);
			inAction.selectByTextInDropdown(driver, list_filterlocationtype,
					sFilterLocationTypedropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	
	}
}
