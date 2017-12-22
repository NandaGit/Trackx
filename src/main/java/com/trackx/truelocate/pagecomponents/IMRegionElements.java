package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class IMRegionElements {
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
	@FindBy(xpath = "//*[@id='menuField']/ul[11]/li/a/span") 
	WebElement menu_administration;
	
	@FindBy(xpath = "//*[contains(text(),' Administration')]")
	 WebElement menu_administration1;

	@FindBy(linkText ="Region")
	WebElement menu_region;
	
	/**
	 * Edit Elements
	 */
	
	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[4]")
	WebElement btn_pageNext;
	
	@FindBy(className = "pageNo")
	WebElement pageCount;
	
	public IMRegionElements(WebDriver driver) {
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
	
	/**
	 * This method used to click Region menu
	 */
	public void menuClick() {
		try {
			//inAction.waitForVisibilityOfElement(driver, menu_administration);
			inAction.buttonClick(driver, menu_administration,
					"Click button : menu_administration");
		    inAction.waitForVisibilityOfElement(driver, menu_region);
			inAction.linkClick(driver, menu_region,
					"Click link : menu_region");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to create/edit Region
	 * 
	 * @param sCode
	 * @param sName 
	 */
	public void enterRegionInfo(String sCode, String sName) {
		try {
			//inAction.waitForVisibilityOfElement(driver, txt_code);
			inAction.inputText(driver, txt_code, sCode,
					"Enter sCode : " + sCode);
			//inAction.waitForVisibilityOfElement(driver, txt_name);
			inAction.inputText(driver, txt_name, sName,
					"Enter sFirstname : " + sName);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to pass filter values
	 * 
	 * @param sFiltercode
	 * @param sFiltername 
	 */
	public void enterAdvancedFilterInfo(String sFiltercode, String sFiltername) {
		try {
			//inAction.waitForVisibilityOfElement(driver, sFiltercode);
			inAction.inputText(driver, txt_filtercode, sFiltercode,
					"Enter sCode : " + sFiltercode);
			//inAction.waitForVisibilityOfElement(driver, sFiltername);
			inAction.inputText(driver, txt_filtername, sFiltername,
					"Enter sFirstname : " + sFiltername);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

