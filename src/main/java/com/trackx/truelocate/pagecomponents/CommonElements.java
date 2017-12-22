package com.trackx.truelocate.pagecomponents;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class CommonElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	// public Logger log4jlogger = Logger.getLogger("devpinoyLogger");

	@FindBy(xpath = "//*[@id=\"filterSlider\"]/header/button")
	WebElement btn_create;

	/**
	 * Create screen button
	 */
	@FindBy(xpath= "//*[@id=\"edit-form\"]/fieldset[2]/div/section[1]/div/button[1]")
	WebElement btn_createorupdate;

	@FindBy(xpath = "//*[@id=\"edit-form\"]/fieldset[2]/div/section[1]/div/button[2]")
	WebElement btn_cancel;
	
	@FindBy(xpath= "//*[@id='edit-form']/fieldset[2]/div/section[2]/div/button[1]")
	WebElement btn_update;
	
	/**
	 * View Screen button
	 */
	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[2]/div/section/button[1]")
	WebElement btn_viewedit;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[2]/div/section/button[2]")
	WebElement btn_viewdelete;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[2]/div/section/button[3]")
	WebElement btn_viewcancel;

	/**
	 * Table elements
	 */
	@FindBy(className = "pageNo")
	WebElement pageCount;

	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[1]")
	WebElement btn_pageFirst;

	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[2]")
	WebElement btn_pagePrevious;

	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[4]")
	WebElement btn_pageNext;

	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[5]")
	WebElement btn_pageLast;

	@FindBy(id = "listingsPerPage")
	WebElement listPerPage;

	@FindBy(id = "bot2-Msg1")
	WebElement btn_accpetAlertMsg;

	@FindBy(id = "errorContent")
	WebElement txt_alertmsg;

	/**
	 * Global Search
	 */
	@FindBy(xpath = "//*[@id=\"filter-form\"]/fieldset/div/section[1]/label[2]/input")
	WebElement txt_globalSearch;

	@FindBy(xpath = "//*[@id=\"filter-form\"]/fieldset/div/section[2]/div/button[1]")
	WebElement btn_go;
	
	@FindBy(xpath="//*[@id=\"filter-form\"]/fieldset/div/section[2]/div/button[2]")
	WebElement btn_advopenclose;

	/**
	 * Advanced Search
	 */
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[2]/div/section/button[1]")
	WebElement btn_search;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[2]/div/section/button[2]")
	WebElement btn_clear;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[2]/div/section/button[3]")
	WebElement btn_advcancel;

	
	@FindBy(xpath = "//*[@id='filterSlider']/div/div/form[3]/div/div/div/div[2]/table/tbody/tr/td[1]")
	WebElement btn_tablecode;
	
	/**
	 * This method used to click create button
	 * 
	 * @param driver
	 */
	public void clickCreatebutton(WebDriver driver) {
		try {
			inAction.waitForElementToBeClickable(driver, btn_create);
			inAction.buttonClick(driver, btn_create,
					"Click button : btn_create");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click create button
	 * 
	 * @param driver
	 */
	public void clickCreateOrUpdatebutton(WebDriver driver) {
		try {
			inAction.waitForElementToBeClickable(driver, btn_createorupdate);
			inAction.buttonClick(driver, btn_createorupdate,
					"Click button : btn_createorupdate");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click update button
	 * 
	 * @param driver
	 */
	public void clickUpdatebutton(WebDriver driver) {
		try {
			inAction.waitForElementToBeClickable(driver, btn_update);
			inAction.buttonClick(driver, btn_update, 
					"Click button : btn_update");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * This method used to get the total no of pages in the table
	 * 
	 * @return integer value
	 */
	public int getTotalNumberOfPages() {
		inAction.waitForVisibilityOfElement(driver, pageCount);
		String number = pageCount.getText().replaceAll("/", "").trim();
		int result = Integer.parseInt(number);
		return result;
	}


	/**
	 * This method used to return the alert message
	 * @param driver
	 * @return alertMessage
	 */
	public String alertMessage(WebDriver driver) {
		inAction.waitForVisibilityOfElement(driver, txt_alertmsg);
		String alertMessage = txt_alertmsg.getText();
		return alertMessage;
	}

	/**
	 * This method used to click the delete button in the view screen
	 * 
	 * @param driver
	 */
	public void clickDeleteButton(WebDriver driver) {
		try {
			inAction.waitForElementToBeClickable(driver, btn_viewdelete);
			inAction.buttonClick(driver, btn_viewdelete,
					"Click button : btn_deleteclick");
			inAction.waitForElementToBeClickable(driver, btn_viewdelete);
			inAction.buttonClick(driver, btn_accpetAlertMsg,
					"Click Yes button : btn_accpetAlertMsg");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click the edit button in the view screen
	 * 
	 * @param driver
	 */
	public void clickEditButton(WebDriver driver) {
		try {
			inAction.waitForElementToBeClickable(driver, btn_viewedit);
			inAction.buttonClick(driver, btn_viewedit,
					"Click button : btn_viewedit");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click the entered value in the table
	 * 
	 * @param driver
	 * @param sValue
	 */
	public void clickValue(WebDriver driver, String sValue) {
		try {
			System.out.println("#@@@@@@@@@@@@@@@@$" + getTotalNumberOfPages());
			aa:
			for (int i = 1; i <= getTotalNumberOfPages(); i++) {

				WebElement htmltable = driver.findElement(By
					.xpath("//*[@id='filterSlider']/div/div/form[3]/div/div/div/div[2]/table/tbody"));
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOf(htmltable));
				List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
				Thread.sleep(4000);
				for (WebElement rowElement : rows){
					Thread.sleep(4000);
					List<WebElement> columns = rowElement.findElements(By
						.tagName("td"));
					Thread.sleep(4000);
			
					for (WebElement colElement : columns){
						System.out.println("%%%%%%%%%%%%%%%%%%" + colElement.getText());
						Thread.sleep(1000);
						if (colElement.getText().equalsIgnoreCase(sValue)) {
							Thread.sleep(1000);
							rowElement.click();
							break aa;
						}
					}
					btn_pageNext.click();
					Thread.sleep(5000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click next button in the table
	 */
	public void clickNextButton() {
		try {
			inAction.waitForElementToBeClickable(driver, btn_pageNext);
			inAction.buttonClick(driver, btn_pageNext,
					"Click Yes button : btn_pageNext");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click previous button in the table
	 */
	public void clickPreviousButton() {
		try {
			inAction.waitForElementToBeClickable(driver, btn_pagePrevious);
			inAction.buttonClick(driver, btn_pagePrevious,
					"Click Yes button : btn_pagePrevious");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click Last button in the table
	 */
	public void clickLastButton() {
		try {
			inAction.waitForElementToBeClickable(driver, btn_pageLast);
			inAction.buttonClick(driver, btn_pageLast,
					"Click Yes button : btn_pageLast");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click first button in the table
	 */
	public void clickFirstButton() {
		try {
			inAction.waitForElementToBeClickable(driver, btn_pageFirst);
			inAction.buttonClick(driver, btn_pageFirst,
					"Click Yes button : btn_pageFirst");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select the list page count
	 * 
	 * @param sListCount
	 */
	public void selectPerPageCount(String sListCount) {
		try {
			inAction.selectItemFromDropdown(driver, listPerPage, sListCount,
					"Select list per page count : listPerPage");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to perform global search
	 * 
	 * @param sValue
	 */
	public void globalSearch(String sValue) {
		try {

			inAction.waitForVisibilityOfElement(driver, txt_globalSearch);
			inAction.inputText(driver, txt_globalSearch, sValue,
					"Enter sValue:  + sValue");
			inAction.waitForElementToBeClickable(driver, btn_go);
			inAction.buttonClick(driver, btn_go, "Click button : btn_go");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click the advanced filter search button
	 * 
	 * @param driver
	 * @param sValue
	 */
	public void clickAdvancedSearch(WebDriver driver) {
		try {
			inAction.waitForVisibilityOfElement(driver, btn_search);
			inAction.buttonClick(driver, btn_search,
					"Click button : btn_search");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click the advanced filter clear button
	 * 
	 * @param driver
	 * @param sValue
	 */
	public void clickAdvancedClear(WebDriver driver) {
		try {
			inAction.waitForVisibilityOfElement(driver, btn_clear);
			inAction.buttonClick(driver, btn_clear, "Click button : btn_clear");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to click the advanced filter cancel button
	 * 
	 * @param driver
	 * @param sValue
	 */
	public void clickAdvancedCancel(WebDriver driver) {
		try {
			inAction.waitForVisibilityOfElement(driver, btn_cancel);
			inAction.buttonClick(driver, btn_cancel, "Click button : btn_cancel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to click the advanced filter open button
	 * 
	 * @param driver
	 * @param sValue
	 */
	public void clickAdvancedFilterOpen(WebDriver driver) {
		try {
			inAction.waitForVisibilityOfElement(driver, btn_advopenclose);
			inAction.buttonClick(driver, btn_advopenclose, "Click button : btn_advopenclose");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method used to validate global search/advance search filter results
	 * 
	 * @param sValue
	 */
	public boolean filtetResultValidation(String sValue) throws InterruptedException {
		System.out.println("Msg:" + btn_tablecode.getText());
		Thread.sleep(1000);
		String searchresult = btn_tablecode.getText();
		if (searchresult.equalsIgnoreCase(sValue)) {
			Assert.assertEquals(searchresult, sValue);
			return true;
		} else {
			Assert.assertNotEquals(searchresult, sValue);
			return false;
		}
	}
	
	/**
	 * This method used to click the menu in all the screen
	 * 
	 * @param driver
	 * @param sMenu
	 */
	public void clickMenu(WebDriver driver, String sMenu) {
		try {
			List<WebElement> rows =	driver.findElements(By.xpath("//*[@id=\"menuField\"]/ul"));
			Thread.sleep(5000);
			for (int i = 1; i <= rows.size(); i++) {
				String idValue = "//*[@id='menuField']/ul[" + i +"]/li/a/span";
				Thread.sleep(5000);
				String menuName = driver.findElement(By.xpath(idValue))
						.getText();
				Thread.sleep(5000);
				if (menuName.equalsIgnoreCase(sMenu)) {
					/*JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", element);*/
					driver.findElement(By.xpath(idValue)).click();
					Thread.sleep(5000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to select the date
	 * 
	 * @param driver
	 * @param sDate
	 */
	public void selectDate(WebDriver driver, String sDate) {
		try {
			String date = (sDate.split(" ")[0]).split("-")[0];
			/*
			   String month = (sDate.split(" ")[0]).split("-")[1]; 
			   String Year = (sDate.split(" ")[0]).split("-")[2]; 
			   WebElement dateWidgetMonth = driver.findElement(By.className("ui-datepicker-month"));
			   WebElement dateWidgetYear = driver.findElement(By.className("ui-datepicker-year"));
			   WebElement dateWidget = driver.findElement(By.className("ui-datepicker-calendar"));
			   List<WebElement> rows = dateWidget.findElements(By.tagName("tr")); 
			   List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
			 */

			Date startDate = new SimpleDateFormat("dd-MM-yyyy").parse(sDate);
			Date today = new Date();
			Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(startDate);
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(today);

			int diffYear = endCalendar.get(Calendar.YEAR)
					- startCalendar.get(Calendar.YEAR);
			int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH)
					- startCalendar.get(Calendar.MONTH);
			for (int i = 1; i <= diffMonth; i++) {
				driver.findElement(By.className("ui-datepicker-prev")).click();
			}
			List<WebElement> allDates = driver.findElements(By
					.xpath("//table[@class='ui-datepicker-calendar']//td"));

			for (WebElement cell : allDates) {
				if (cell.getText().equals(date)) {
					cell.findElement(By.linkText(date)).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to click calendar date
	 * 
	 * @param sValue
	 */
	public void calendar(WebDriver driver,String sValue){
		try {
	         driver.findElement(By.id("fromDate")).click();
			 List<WebElement> allDates=driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody"));
			 for(WebElement calendar:allDates)
			 {
				String date=calendar.getText();
				System.out.println("result"+calendar.getText() );
				if(date.equalsIgnoreCase("sValue")){
					System.out.println("clicked");
					Thread.sleep(2000);
					calendar.click();
					driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
					System.out.println("success");
					break ;
				}
			 }
		 }
			 catch (Exception e) {
					e.printStackTrace();
				}
		}	
	  /**
     * This method used to click create button
     * 
     * @param driver
     */
    public void clickCancelbutton(WebDriver driver) {
	      try {
		       inAction.waitForElementToBeClickable(driver, btn_cancel);
		       inAction.buttonClick(driver, btn_cancel,
				           "Click button : btn_cancel");
	      } catch (Exception e) {
		e.printStackTrace();
	      }
        }
    }
     

     