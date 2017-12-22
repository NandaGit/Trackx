package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class UserCreationElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	
	@FindBy(xpath = "//*[@id='left-panel']/nav/ul[5]/li/a")
	WebElement menu_security;

	@FindBy(xpath = "//*[@id='left-panel']/nav/ul[5]/li/ul/li[1]/a")
	WebElement menu_user;

	@FindBy(xpath ="//*[@id=\"filterSlider\"]/header/button")
	WebElement btn_createuser;

	@FindBy(id="email") 
	WebElement txt_email;

	@FindBy(id="firstName") 
	WebElement txt_firstName;

	@FindBy(id="lastName") 
	WebElement txt_lastName;

	@FindBy(id="mobile") 
	WebElement txt_mobile;

	@FindBy(id="select2-chosen-2") 
	WebElement dropdown_language;

	@FindBy(xpath="//*[@id=\"select2-results-2\"]/li")
	List<WebElement> list_language;

	@FindBy(id="enabledEdit")
	WebElement togglebtn_enabled;

	@FindBy(id="userPassword")
	WebElement txt_password;

	@FindBy(id="confirmPassword")
	WebElement txt_confirmpwd;

	@FindBy(id="pwdChange")
	WebElement togglebtn_pwdChange;

	@FindBy(id="pwdExpire")
	WebElement togglebtn_expiredPassword;

	@FindBy(xpath ="//*[@id=\"edit-form\"]/fieldset[2]/div/section[1]/div/button[1]")
	WebElement btn_usercreate;

	@FindBy(className ="btnCancel")
	WebElement btn_usercreatecancel;
	
	@FindBy(className = "nav nav-tabs")
	WebElement tab_portals;

	@FindBy(id = "select2-chosen-4")
	WebElement dropdown_corprole;

	@FindBy(xpath = "//ul[@id='select2-results-4']/li")
	List<WebElement> list_corprole;

	@FindBy(id = "select2-chosen-16")
	WebElement dropdown_growerrole;

	@FindBy(xpath = "//ul[@id='select2-results-16']/li")
	List<WebElement> list_growerrole;
	
	@FindBy(id = "select2-chosen-27")
	WebElement dropdown_warehouserole;

	@FindBy(xpath = "//ul[@id='select2-results-4']/li")
	List<WebElement> list_warehouserole;

	@FindBy(id = "select2-chosen-10")
	WebElement dropdown_partnerrole;

	@FindBy(xpath = "//ul[@id='select2-results-10']/li")
	List<WebElement> list_partnerrole;
	
	@FindBy(id="errorContent")
	WebElement txt_alertmsg;
	
	@FindBy(xpath = "//*[@id='view-form']/fieldset[2]/div/section/button[1]")
	WebElement btn_editclick;
	
	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[2]/div/section/button[2]")
	WebElement btn_deleteclick;
	
	@FindBy(xpath = "//*[@id='edit-form']/fieldset[2]/div/section[2]/div/button[1]")
	WebElement btn_updateclick;
	
	@FindBy(className = "pageNo")
	WebElement pageCount;
	
	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[4]")
	WebElement pageNext;
	
	@FindBy(id = "errorContent")
	WebElement txt_validate;
	
	@FindBy(xpath = "//*[@id=\"filter-form\"]/fieldset/div/section[1]/label[2]/input")
	WebElement txt_globalSearch;
	
	@FindBy(xpath = "//*[@id=\"filter-form\"]/fieldset/div/section[2]/div/button[1]")
	WebElement btn_go;
	
	@FindBy(id = "bot2-Msg1")
	WebElement btn_accpetAlertMsg;
	
	public UserCreationElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method used to click User menu
	 */
	public void menuClick() {
		try {
			inAction.waitForVisibilityOfElement(driver, menu_security);
			inAction.buttonClick(driver, menu_security,
					"Click button : menu_administration");
		    inAction.waitForVisibilityOfElement(driver, menu_user);
			inAction.linkClick(driver, menu_user,
					"Click link : menu_region");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Method used for selecting the role based on portal
	 * 
	 * @param portal
	 * @param role
	 */
	public void selectPortalRole(String portal, String role) {
		try {
			if(portal.equalsIgnoreCase("Corporate Portal")){
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_corprole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_corprole, role);
			} else if (portal.equalsIgnoreCase("Grower Portal")) {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_growerrole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_growerrole, role);
			}else if (portal.equalsIgnoreCase("Warehouse Portal")) {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_warehouserole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_warehouserole, role);
			}else {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_partnerrole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_partnerrole, role);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	

	/**
	 * Method used for selecting the language
	 * 
	 * @param language
	 */
	public void selectLanguage(String language) {
		try {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_language,
						"Click language dropdown : " + language);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_language, language);
				Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	/**
	 * This method used to enter the values in the text field.
	 * 
	 * @param sEmail
	 * @param sFirstname
	 * @param sLastname
	 * @param sMobile
	 * @param sLanguage
	 * @param sPassword
	 * @param sConfirmpassword
	 * @param sPortal
	 * @param sRole
	 */
	public void enterUserInfo(String sEmail, String sFirstname,
			String sLastname, String sMobile, String sLanguage, String sPassword,
			String sConfirmpassword, String sPortal, String sRole) {
		try {

			inAction.inputText(driver, txt_email, sEmail,
					"Enter sEmail : " + sEmail);
			inAction.inputText(driver, txt_firstName, sFirstname,
					"Enter sFirstname : " + sFirstname);
			inAction.inputText(driver, txt_lastName, sLastname,
					"Enter sLastname : " + sLastname);
			inAction.inputText(driver, txt_mobile, sMobile,
					"Enter sMobile : " + sMobile);
			Thread.sleep(1000);
			selectLanguage(sLanguage);
			Thread.sleep(1000);
			inAction.inputText(driver, txt_password, sPassword,
					"Enter sPassword : " + sPassword);
			inAction.inputText(driver, txt_confirmpwd, sConfirmpassword,
					"Enter sConfirmpassword : " + sConfirmpassword);
			selectPortalRole(sPortal, sRole);
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void clickCreateButton1() {
		try {
			inAction.buttonClick(driver, btn_createuser, "Click button : btn_usercreate");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public void clickCreateButton() {
		try {
			inAction.buttonClick(driver, btn_usercreate, "Click button : btn_usercreate");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public boolean alertMessageValidation() throws InterruptedException {
		System.out.println("Msg:" + txt_alertmsg.getText());

		Thread.sleep(1000);
		String alertMessage = txt_alertmsg.getText();
		Thread.sleep(1000);
		if (alertMessage.equalsIgnoreCase(constants.User_Success_Type)) {
			Assert.assertEquals(alertMessage, constants.User_Success_Type);
			return true;
		} else {
			Assert.assertNotEquals(alertMessage, constants.User_Success_Type);
			return false;
		}
	}
	
	/**
	 * This method used get the alert message text
	 * 
	 * @return alert message
	 */
	public String alertMessage() {
		inAction.waitForElementToBeClickable(driver, txt_alertmsg);
		String alertMessage = txt_alertmsg.getText();
		return alertMessage;
	}
	/**
	 * This method used to click the entered value in the table 
	 * @param sEmail
	 */
	public void clickUser(String sEmail) {
		try {
			System.out.println("#@@@@@@@@@@@@@@@@$" + getTotalNumberOfPages());
			aa:
			for (int i = 1; i <= getTotalNumberOfPages(); i++) {
				WebElement htmltable = driver.findElement(By
					.xpath("//*[@id='filterSlider']/div/div/form[3]/div/div/div/div[2]/table/tbody"));
				List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
				Thread.sleep(10000);
		
				for (WebElement rowElement : rows){
					Thread.sleep(10000);
					List<WebElement> columns = rowElement.findElements(By
						.tagName("td"));
					Thread.sleep(10000);
			
					for (WebElement colElement : columns){
						System.out.println("%%%%%%%%%%%%%%%%%%" + colElement.getText());
						Thread.sleep(1000);
						if (colElement.getText().equalsIgnoreCase(sEmail)){
							Thread.sleep(1000);
							rowElement.click();
							break aa;
						}
					}
					pageNext.click();
					Thread.sleep(5000);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to enter the firtsname and lastname values
	 * 
	 * @param sFirstName
	 * @param sLastName
	 */
	public void editcode(String sFirstName, String sLastName) {
		try {
			Thread.sleep(1000);
			inAction.inputText(driver, txt_firstName, sFirstName,
					"Enter sFirstName:  + sFirstName");
			inAction.inputText(driver, txt_lastName, sLastName,
					"Enter sLastName:  + sLastName");
			btn_updateclick.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validation() throws InterruptedException {

		System.out.println("Msg:" + txt_validate.getText());
		Thread.sleep(1000);
		if (txt_validate.getText().equalsIgnoreCase(constants.success_usermsg)) {
			// Thread.sleep(1000);
			// Assert.assertEquals(txt_validate.getText(),constants.success_sitemsg);
			return true;
		}
		else {
			Reporter.log("Fail");
			return false;
		}
	}
	
	/**
	 * This method used to get the total no of pages in the table
	 * 
	 * @return integer value
	 */
	public int getTotalNumberOfPages(){
		String number = pageCount.getText().replaceAll("/", "").trim();
		int result = Integer.parseInt(number);
		return result;
	}
	
	/**
	 * This method used to perform global search
	 * 
	 */
	public void globalSearch(String sValue) {
		try {
			Thread.sleep(1000);
			inAction.inputText(driver, txt_globalSearch, sValue,
					"Enter sValue:  + sValue");
			inAction.buttonClick(driver, btn_go,
					"Click button : btn_go");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to click the edit button
	 */
	public void EditUser(){
		try {
			Thread.sleep(1000);
			inAction.buttonClick(driver, btn_editclick,
					"Click button : menu_securityclick");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method used to click the delete button and 
	 * accept the alert message
	 */
	
	public void deleteUser(){
		try {
			Thread.sleep(1000);
			inAction.buttonClick(driver, btn_deleteclick,
					"Click button : btn_deleteclick");
			Thread.sleep(1000);
			inAction.buttonClick(driver, btn_accpetAlertMsg, 
					"Click Yes button : btn_accpetAlertMsg");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public static Object[][] getData() {
		return GeneralActions.getData("User");
	}
}
