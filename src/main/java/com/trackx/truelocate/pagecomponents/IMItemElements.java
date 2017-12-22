package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class IMItemElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	CommonElements commonElements = new CommonElements();

	/**
	 * Create screen Elements
	 */
	@FindBy(id = "createItemNumber")
	WebElement txt_item;

	@FindBy(id = "createNumber")
	WebElement txt_name;

	@FindBy(id = "createDescription")
	WebElement txt_description;

	@FindBy(id = "select2-chosen-3")
	WebElement dropdown_itemclass;

	@FindBy(id = "s2id_autogen3_search")
	WebElement txt_itemclass;

	@FindBy(xpath = "//*[@id=\"select2-results-3\"]/li")
	List<WebElement> list_itemclass;

	@FindBy(id = "select2-chosen-5")
	WebElement dropdown_itemtype;

	@FindBy(id = "s2id_autogen5_search")
	WebElement txt_itemtype;

	@FindBy(xpath = "//*[@id=\"select2-results-5\"]/li")
	List<WebElement> list_itemtype;

	@FindBy(id = "createMinQty")
	WebElement txt_minqty;

	@FindBy(id = "createMaxQty")
	WebElement txt_maxqty;

	@FindBy(id = "select2-chosen-6")
	WebElement dropdown_inventorytype;

	@FindBy(id = "s2id_autogen6_search")
	WebElement txt_inventorytype;

	@FindBy(xpath = "//*[@id=\"select2-results-6\"]/li")
	List<WebElement> list_inventorytype;

	@FindBy(id = "inventoryTracked")
    WebElement toggleselection_inventory;
	
	@FindBy(xpath = "//*[@id='edit-form']/fieldset[1]/div[2]/section[2]/span/label/span[2]")
	WebElement togglebutton_inventory;

	@FindBy(id = "active")
    WebElement toggleselection_active;
	
	@FindBy(xpath = "//*[@id='edit-form']/fieldset[1]/div[2]/section[3]/span/label/span[2]")
	WebElement togglebutton_active;
	@FindBy(id = "consumable")
    WebElement toggleselection_consumable;
	
	@FindBy(xpath = "//*[@id='edit-form']/fieldset[1]/div[2]/section[4]/span/label/span[2]")
	WebElement togglebutton_consumable;

	/**
	 * Identification Elements
	 */

	/*
	 * @FindBy(xpath = "//*[@id='s2id_identifierType']/ul") WebElement
	 * txt_identifiertype;
	 */

	@FindBy(id = "s2id_autogen7")
	WebElement btn_identifiertype;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li")
	List<WebElement> list_identifiertype;

	@FindBy(id = "createItemUPC")
	WebElement txt_UPC;

	@FindBy(id = "createCaseUpc")
	WebElement txt_caseUPC;

	@FindBy(id = "conveyance-checkbox")
    WebElement toggleselection_conveyance;
	
	@FindBy(xpath = "//*[@id='Identification_detailsCreate']/div[2]/section[2]/span/label/span[2]")
	WebElement togglebutton_conveyance;

	@FindBy(id = "trackedByBatch")
    WebElement toggleselection_batchcode;
	
	@FindBy(xpath = "//*[@id='Identification_detailsCreate']/div[2]/section[3]/span/label/span[2]")
	WebElement togglebutton_batchcode;

	@FindBy(id = "select2-chosen-11")
	WebElement dropdown_uom;

	@FindBy(id = "s2id_autogen11_search")
	WebElement txt_uom;

	@FindBy(xpath = "//*[@id=\"select2-results-11\"]/li")
	List<WebElement> list_uom;

	/**
	 * Measurement Elements
	 */

	@FindBy(linkText = "Measurement Details")
	WebElement tab_eachmeasurement;

	@FindBy(id = "createEachWeight")
	WebElement txt_eachweight;

	@FindBy(id = "createEachHeight")
	WebElement txt_eachheight;

	@FindBy(id = "createEachlength")
	WebElement txt_eachlength;

	@FindBy(id = "createEachWidth")
	WebElement txt_eachwidth;

	@FindBy(id = "createCaseWeight")
	WebElement txt_caseweight;

	@FindBy(id = "createCaseHeight")
	WebElement txt_caseheight;

	@FindBy(id = "createCaselength")
	WebElement txt_caselength;

	@FindBy(id = "createCaseWidth")
	WebElement txt_caseWidth;

	@FindBy(id = "createCaseQuantity")
	WebElement txt_qty;

	@FindBy(id = "createCaseQuantityPerlayer")
	WebElement txt_qtylayer;

	@FindBy(id = "createLayerQtyPerpallet")
	WebElement txt_pallet;

	@FindBy(id = "createConveyanceType")
	WebElement txt_conveyancetype;

	/**
	 * Manufacture Elements
	 */

	@FindBy(xpath = "//*[@id='edit-form']/fieldset[1]/div[3]/div/ul/li[3]/a")
	WebElement tab_manufacture;

	@FindBy(id = "createManufactureName")
	WebElement txt_manufacturename;

	@FindBy(id = "createManufactureItemNumber")
	WebElement txt_itemnumber;

	@FindBy(id = "createMake")
	WebElement txt_make;

	@FindBy(id = "createModel")
	WebElement txt_model;

	@FindBy(id = "createSupplier")
	WebElement txt_supplier;

	@FindBy(id = "createSupplierItemNumber")
	WebElement txt_suppliernumber;

	/**
	 * View Screen Elements
	 */

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[1]/label[2]")
	WebElement label_item;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[2]/label[2]")
	WebElement label_code;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[3]/label[2]")
	WebElement label_description;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[4]/label[2]")
	WebElement label_itemclass;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[5]/label[2]")
	WebElement label_itemType;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[1]/label[2]")
	WebElement label_minqty;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[2]/label[2]")
	WebElement label_maxqty;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div[1]/section[3]/label[2]")
	WebElement label_inventorytype;

	/**
	 * Menu Elements
	 */
	@FindBy(xpath = "//*[@id=\"menuField\"]/ul[2]/li/a/span")
	WebElement menu_inventory;

	@FindBy(linkText = "Item")
	WebElement menu_item;

	/**
	 * Advanced Filter Elements
	 */
	@FindBy(id = "filterItemName")
	WebElement txt_filterItem;

	@FindBy(id = "filterName")
	WebElement txt_filterName;

	@FindBy(id = "filterManufacturer")
	WebElement txt_filterManufacture;

	@FindBy(id = "filterManufactureItemNumber")
	WebElement txt_filterManufactureItem;

	@FindBy(id = "s2id_filterInventoryType")
	WebElement adv_filterInventoryType;

	@FindBy(xpath = "//*[@id='select2-results-16']/li")
	List<WebElement> adv_inventoryTypelList;

	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[10]/div/label[1]/span")
	WebElement adv_vaBoth;

	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[10]/div/label[1]/input")
	WebElement adv_vaBothChecked;

	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[10]/div/label[2]/span")
	WebElement adv_vaYes;

	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[10]/div/label[2]/input")
	WebElement adv_vaYesChecked;

	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[10]/div/label[3]/span")
	WebElement adv_vaNo;

	@FindBy(xpath = "//*[@id='advFilter']/fieldset[1]/div/section[10]/div/label[3]/input")
	WebElement adv_vaNoChecked;

	@FindBy(id = "s2id_autogen12")
	WebElement adv_itemClassDropdown;
	
	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li")
	List<WebElement> adv_itemClassOrTypeList;
	
	@FindBy(id = "s2id_autogen14")
	WebElement adv_itemTypeDropdown;
	
	public IMItemElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method used to click Region menu
	 */
	public void menuClick() {
		try {
			inAction.buttonClick(driver, menu_inventory,
					"Click button : menu_inventory");
			inAction.linkClick(driver, menu_item,
					"Click button : menu_masterData");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to create Item
	 * 
	 * @param sCode
	 * @param sName
	 * @param sDescription
	 * @param sItemclass
	 * @param sItemclassdropdown
	 * @param sItemtype
	 * @param sItemtypedropdown
	 * @param sLoactiontype
	 *            sLocationTypedropdown
	 */

	public void enterItemListInfo(String sItem, String sName,
			String sDescription, String sItemclass, String sItemclassdropdown,
			String sItemtype, String sItemTypedropdown, String sMinqty,
			String sMaxqty, String sInventorytype, String sInventorydropdown,
			String sInventory, String sActive, String sConsumable) {
		try {
			inAction.waitForVisibilityOfElement(driver, txt_item);
			inAction.inputText(driver, txt_item, sItem, "Enter sItem : "
					+ sItem);
			inAction.waitForVisibilityOfElement(driver, txt_name);
			inAction.inputText(driver, txt_name, sName, "Enter sFirstname : "
					+ sName);
			inAction.waitForVisibilityOfElement(driver, txt_description);
			inAction.inputText(driver, txt_description, sDescription,
					"Enter sDescription : " + sDescription);
			selectItemclass(sItemclass, sItemclassdropdown);
			selectItemType(sItemtype, sItemTypedropdown);
			inAction.inputText(driver, txt_minqty, sMinqty, "Enter sMinqty : "
					+ sMinqty);
			inAction.inputText(driver, txt_maxqty, sMaxqty, "Enter sMaxqty : "
					+ sMaxqty);
			selectInventoryType(sInventorytype, sInventorydropdown);
			clickInventory(sInventory);
			clickActive(sActive);
			clickConsumable(sConsumable);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to fill identifications
	 * 
	 * 
	 * @param sIdentifierdropdown
	 * @param sUPC
	 * @param sCaseUPC
	 * @param sConveyance
	 * @param sBatchcode
	 * @param sUOM
	 * @param sUOMdropdown
	 */

	public void enterIdentificationListInfo(String sIdentifierdropdown,
			String sUPC, String sCaseUPC, String sConveyance,
			String sBatchcode, String sUOM, String sUOMdropdown) {

		try {

			/*
			 * inAction.waitForVisibilityOfElement(driver, btn_identifiertype);
			 * inAction.buttonClick(driver, btn_identifiertype,
			 * "Click button : btn_identifiertype"); Thread.sleep(1000);
			 * inAction.selectByTextInDropdown(driver, list_identifiertype,
			 * sIdentifierdropdown);
			 */
			Thread.sleep(1000);
			selectIdentifierType(sIdentifierdropdown);
			Thread.sleep(2000);
			inAction.inputText(driver, txt_UPC, sUPC, "Enter sUPC : " + sUPC);
			inAction.inputText(driver, txt_caseUPC, sCaseUPC,
					"Enter sCaseUPC : " + sCaseUPC);
			clickConveyance(sConveyance);
			clickBatchcode(sBatchcode);
			selectUOM(sUOM, sUOMdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to fill Measurement info
	 * 
	 * @param sEachweight
	 * @param sEachheight
	 * @param sEachlength
	 * @param sEachwidth
	 * @param sCaseweight
	 * @param sUsCaseheightOM
	 * @param sCaselength
	 * @param sCasewidth
	 * @param sQty
	 * @param sQtylayer
	 * @param sPallet
	 * @param sConveyancetype
	 */
	public void enterMeasurementListInfo(String sEachweight,
			String sEachheight, String sEachlength, String sEachwidth,
			String sCaseweight, String sCaseheight, String sCaselength,
			String sCasewidth, String sQty, String sQtylayer, String sPallet,
			String sConveyancetype) {

		try {

			inAction.buttonClick(driver, tab_eachmeasurement,
					"Click button : tab_measurement");
			// inAction.waitForVisibilityOfElement(driver, btn_identifiertype);
			inAction.inputText(driver, txt_eachweight, sEachweight,
					"Enter sEachweight : " + sEachweight);
			inAction.inputText(driver, txt_eachheight, sEachheight,
					"Enter sEachheight : " + sEachheight);
			inAction.inputText(driver, txt_eachlength, sEachlength,
					"Enter sEachlength : " + sEachlength);
			inAction.inputText(driver, txt_eachwidth, sEachwidth,
					"Enter sEachwidth : " + sEachwidth);
			inAction.inputText(driver, txt_caseweight, sCaseweight,
					"Enter sCaseweight : " + sCaseweight);
			inAction.inputText(driver, txt_caseheight, sCaseheight,
					"Enter sCashheight : " + sCaseheight);
			inAction.inputText(driver, txt_caselength, sCaselength,
					"Enter sCaselength : " + sCaselength);
			inAction.inputText(driver, txt_caseWidth, sCasewidth,
					"Enter sCasewidth : " + sCasewidth);
			inAction.inputText(driver, txt_qty, sQty, "Enter sQty : " + sQty);
			inAction.inputText(driver, txt_qtylayer, sQtylayer,
					"Enter sQtylayer : " + sQtylayer);
			inAction.inputText(driver, txt_pallet, sPallet, "Enter sPallet : "
					+ sPallet);
			inAction.inputText(driver, txt_conveyancetype, sConveyancetype,
					"Enter sConveyance : " + sConveyancetype);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to fill Manufacture info
	 * 
	 * @param sManufacturename
	 * @param sItemnumber
	 * @param sMake
	 * @param sModel
	 * @param sSupplier
	 * @param sSuppliernumber
	 */
	public void enterManufactureInfo(String sManufacturename,
			String sItemnumber, String sMake, String sModel, String sSupplier,
			String sSuppliernumber) {

		try {

			inAction.buttonClick(driver, tab_manufacture,
					"Click button : tab_manufacture");
			inAction.inputText(driver, txt_manufacturename, sManufacturename,
					"Enter sManufacturename : " + sManufacturename);
			inAction.inputText(driver, txt_itemnumber, sItemnumber,
					"Enter sItemnumber : " + sItemnumber);
			inAction.inputText(driver, txt_make, sMake, "Enter sMake : "
					+ sMake);
			inAction.inputText(driver, txt_model, sModel, "Enter sModel : "
					+ sModel);
			inAction.inputText(driver, txt_supplier, sSupplier,
					"Enter sSupplier : " + sSupplier);
			inAction.inputText(driver, txt_suppliernumber, sSuppliernumber,
					"Enter sSuppliernumber : " + sSuppliernumber);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Identifiertype
	 * 
	 * @param sIdentifierdropdown
	 */

	public void selectIdentifierType(String sIdentifierdropdown) {
		try {
			inAction.waitForElementToBeClickable(driver, btn_identifiertype);
			inAction.buttonClick(driver, btn_identifiertype,
					"Click protocol dropdown : " + btn_identifiertype);
			Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, list_identifiertype,
					sIdentifierdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Itemclass
	 * 
	 * @param sItemclass
	 * @param sItemclassdropdown
	 */

	public void selectItemclass(String sItemclass, String sItemclassdropdown) {
		try {

			inAction.waitForVisibilityOfElement(driver, dropdown_itemclass);
			inAction.buttonClick(driver, dropdown_itemclass,
					"Click button : dropdown_itemclass");
			inAction.waitForVisibilityOfElement(driver, txt_itemclass);
			inAction.inputText(driver, txt_itemclass, sItemclass,
					"Enter sItemclass : " + sItemclass);
			inAction.selectByTextInDropdown(driver, list_itemclass,
					sItemclassdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Itemtype
	 * 
	 * @param sItemclass
	 * @param sItemclassdropdown
	 */

	public void selectItemType(String sItemtype, String sItemTypedropdown) {
		try {

			inAction.buttonClick(driver, dropdown_itemtype,
					"Click button : dropdown_itemtype");
			inAction.inputText(driver, txt_itemtype, sItemtype,
					"Enter sItemtype : " + sItemtype);
			inAction.selectByTextInDropdown(driver, list_itemtype,
					sItemTypedropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Inventorytype
	 * 
	 * @param sItemclass
	 * @param sItemclassdropdown
	 */

	public void selectInventoryType(String sInventorytype,
			String sInventorydropdown) {
		try {
			inAction.buttonClick(driver, dropdown_inventorytype,
					"Click button : dropdown_inventorytype");
			inAction.inputText(driver, txt_inventorytype, sInventorytype,
					"Enter sInventorytype : " + sInventorytype);
			inAction.selectByTextInDropdown(driver, list_inventorytype,
					sInventorydropdown);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select UOM
	 * 
	 * @param sItemclass
	 * @param sItemclassdropdown
	 */

	public void selectUOM(String sUOM, String sUOMdropdown) {
		try {
			inAction.buttonClick(driver, dropdown_uom,
					"Click button : dropdown_uom");
			inAction.inputText(driver, txt_uom, sUOM, "Enter sUOM : " + sUOM);
			inAction.selectByTextInDropdown(driver, list_uom, sUOMdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
public void clickInventory(String sVerifiedAddress) {
	boolean boovar = ReusableActions
			.isElementSelected(toggleselection_inventory);
	String str = String.valueOf(boovar);
	if (!sVerifiedAddress.equalsIgnoreCase(str) & StringUtils.isNotBlank(sVerifiedAddress)) {
		inAction.waitForVisibilityOfElement(driver, togglebutton_inventory);
		ReusableActions.selectedRadioButton(driver, togglebutton_inventory,
				"click toggle button: togglebutton_inventory");
	}
}
	/**
	 * This method used to click the Active toggle button
	 * 
	 * @param sActive
	 */

public void clickActive(String sActive){
	boolean boovar = ReusableActions
			.isElementSelected(toggleselection_active);
	String str = String.valueOf(boovar);
	if (!sActive.equalsIgnoreCase(str) & StringUtils.isNotBlank(sActive)) {
		inAction.waitForVisibilityOfElement(driver, togglebutton_active);
		ReusableActions.selectedRadioButton(driver, togglebutton_active,
				"click toggle button: togglebutton_active");
	}
}
	/**
	 * This method used to click the Consumable toggle button
	 * 
	 * @param sConsumable
	 */

public void clickConsumable(String sConsumable){
	boolean boovar = ReusableActions
			.isElementSelected(toggleselection_consumable);
	String str = String.valueOf(boovar);
	if (!sConsumable.equalsIgnoreCase(str) & StringUtils.isNotBlank(sConsumable)) {
		inAction.waitForVisibilityOfElement(driver, togglebutton_consumable);
		ReusableActions.selectedRadioButton(driver, togglebutton_consumable,
				"click toggle button: togglebutton_consumable");
	}
}
	/**
	 * This method used to click the Conveyance toggle button
	 * 
	 * @param sConveyance
	 */

public void clickConveyance(String sConveyance){
	boolean boovar = ReusableActions
			.isElementSelected(toggleselection_conveyance);
	String str = String.valueOf(boovar);
	if (!sConveyance.equalsIgnoreCase(str) & StringUtils.isNotBlank(sConveyance)) {
		inAction.waitForVisibilityOfElement(driver, togglebutton_conveyance);
		ReusableActions.selectedRadioButton(driver, togglebutton_conveyance,
				"click toggle button: togglebutton_conveyance");
	}
}

public void clickBatchcode(String sBatchcode){
	boolean boovar = ReusableActions
			.isElementSelected(toggleselection_batchcode);
	String str = String.valueOf(boovar);
	if (!sBatchcode.equalsIgnoreCase(str) & StringUtils.isNotBlank(sBatchcode)) {
		inAction.waitForVisibilityOfElement(driver, togglebutton_batchcode);
		ReusableActions.selectedRadioButton(driver, togglebutton_batchcode,
				"click toggle button: togglebutton_batchcode");

	}

	}

	/**
	 * This method used to click the inventory radio button
	 * 
	 * @param sInventory
	 */
	public void clickAdvInventory(String sInventory) {
		if (sInventory.equalsIgnoreCase("Both")
				&& !ReusableActions.isElementSelected(adv_vaBothChecked)) {
			inAction.waitForVisibilityOfElement(driver, adv_vaBoth);
			ReusableActions.selectedRadioButton(driver, adv_vaBoth,
					"click toggle button: adv_vaBoth");
		} else if (sInventory.equalsIgnoreCase("Yes")
				&& !ReusableActions.isElementSelected(adv_vaYesChecked)) {
			inAction.waitForVisibilityOfElement(driver, adv_vaYes);
			ReusableActions.selectedRadioButton(driver, adv_vaYes,
					"click toggle button: adv_vaYes");
		} else if (sInventory.equalsIgnoreCase("No")
				&& !ReusableActions.isElementSelected(adv_vaNoChecked)) {
			inAction.waitForVisibilityOfElement(driver, adv_vaNo);
			ReusableActions.selectedRadioButton(driver, adv_vaNo,
					"click toggle button: adv_vaNo");
		}
	}

	/**
	 * This method used to select the facility in the advanced filter section
	 * 
	 * @param sInventoryType
	 */
	public void selectAdvInventoryType(String sInventoryType) {
		try {
			inAction.waitForElementToBeClickable(driver, adv_filterInventoryType);
			inAction.buttonClick(driver, adv_filterInventoryType,
					"Click protocol dropdown : adv_filterInventoryType");
			Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, adv_inventoryTypelList, sInventoryType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to select the Item Class in the advanced filter section
	 * 
	 * @param sItemClass
	 */
	public void selectAdvItemClass(String sItemClass) {
		try {
			inAction.waitForElementToBeClickable(driver, adv_itemClassDropdown);
			inAction.buttonClick(driver, adv_itemClassDropdown,
					"Click item class dropdown : adv_itemClassDropdown");
			Thread.sleep(10000);
			inAction.selectByTextInDropdown(driver, adv_itemClassOrTypeList,
					sItemClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to select the Item Type in the advanced filter section
	 * 
	 * @param sItemType
	 */
	public void selectAdvItemType(String sItemType) {
		try {
			inAction.waitForElementToBeClickable(driver, adv_itemTypeDropdown);
			inAction.buttonClick(driver, adv_itemTypeDropdown,
					"Click item type dropdown : adv_itemTypeDropdown");
			Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, adv_itemClassOrTypeList,
					sItemType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method used to enter the advanced filter value
	 * 
	 * @param sItem
	 * @param sName
	 * @param sItemClass
	 * @param sItemType
	 * @param sManufacture
	 * @param sManufactureItem
	 * @param sInventory
	 * @param sInventoryType
	 */
	public void enterAdvancedFilterInfo(String sItem, String sName,
			String sItemClass, String sItemType, String sManufacture,
			String sManufactureItem, String sInventory, String sInventoryType) {
		try {
			inAction.waitForVisibilityOfElement(driver, txt_filterItem);
			inAction.inputText(driver, txt_filterItem, sItem, "Enter sItem : "
					+ sItem);
			inAction.waitForVisibilityOfElement(driver, txt_filterName);
			inAction.inputText(driver, txt_filterName, sName, "Enter sName : "
					+ sName);
			selectAdvItemClass(sItemClass);
			selectAdvItemType(sItemType);
			inAction.waitForVisibilityOfElement(driver, txt_filterManufacture);
			inAction.inputText(driver, txt_filterManufacture, sManufacture, "Enter sManufacture : "
					+ sManufacture);
			inAction.waitForVisibilityOfElement(driver, txt_filterManufactureItem);
			inAction.inputText(driver, txt_filterManufactureItem, sManufactureItem, "Enter sManufactureItem : "
					+ sManufactureItem);
			clickAdvInventory(sInventory);
			selectAdvInventoryType(sInventoryType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
