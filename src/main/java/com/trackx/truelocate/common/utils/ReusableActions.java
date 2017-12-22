package com.trackx.truelocate.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.trackx.truelocate.common.exception.ElementNotEditable;
import com.trackx.truelocate.common.exception.ElementNotVisible;

public class ReusableActions {
	public static Properties propConfigFile;
	public static WebDriver driver;
	public static WebElement element;
	public static int timeoutsec = 10;
	public static Random rand;
	public static Logger log4jlogger = Logger.getLogger("devpinoyLogger");
	public static GeneralActions gActions = new GeneralActions();
	public static String msgText;
	public static String fsep = System.getProperty("file.separator");
	private static final Exception NullPointerException = null;

	 
	/**
	 * MouseHover Action
	 * 
	 */

	public static void mousehover(WebElement e) {

		try {

			Actions builder = new Actions(driver);

			builder.moveToElement(e).build().perform();

		} catch (StaleElementReferenceException excep) {
		}

	}

	/**
	 * Get the current system time
	 * 
	 */ 

	public static String getCurrentTimeStamp() {
		SimpleDateFormat CurrentDate = new SimpleDateFormat("MM-dd-yyyy" + "_"
				+ "HH-mm-ss");
		Date now = new Date();
		String CDate = CurrentDate.format(now);
		return CDate;
	}

	public void waitForElementToBeClickable(WebDriver driver,
			WebElement e) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutsec);
			wait.until(ExpectedConditions.elementToBeClickable(e));

			Reporter.log("Success : Element is  Clickable");
		} catch (Throwable t) {
			// Assert.fail();
			Reporter.log("Failed : Element is not Clickable");
		}
	}

	public static boolean displayElement(WebDriver driver, WebElement e) {
		try {
			if (e.isDisplayed()) {
				return true;
			}

			Reporter.log("Success : Element is  displayed");
		} catch (Throwable t) {
			// t.printStackTrace();
			// Assert.fail();
			Reporter.log("Failed : Element is not displayed");
		}
		return false;
	}

	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	 * Description: This function clicks a button element.
	 * 
	 * @param Webdriver
	 *            , WebElement, msg
	 * 
	 * 
	 */
	
	public void buttonClick(WebDriver driver, WebElement element, String msg) {
		log4jlogger.debug(msg);
		try {
			if (element.getText() != null) {
				msgText = element.getText();
			} else {
				msgText = element.getTagName();
			}

			if (element.isDisplayed() && element.isEnabled()) {
				try {
					element.click();
					log4jlogger.debug("	Clicked on " + msgText + " button");
				} catch (WebDriverException webex) {
					String message = webex.getMessage();
					if (message.toLowerCase().contains(
							"unknown error".toLowerCase())) {
						element.click();
					} else {
						log4jlogger.debug("Button can't be Clicked ");
						throw webex;
					}
				}
			} else {

				throw new ElementNotEditable(
						"Button[WebElement] is non Editable : ");
			}
			log4jlogger.debug("In " + driver.getTitle() + " page, Clicked on :"
					+ msgText + " button field.");
		} catch (Throwable thr) {
			if (thr instanceof ElementNotVisible) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " button field is not visible.";
				log4jlogger.debug(message, thr);
				throw new ElementNotVisible(message, thr);
			} else if (thr instanceof ElementNotEditable) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " button field is not editable.";
				log4jlogger.debug(message, thr);
				throw new ElementNotEditable(message, thr);

			}
		}
	}

	/**
	 * Description:This function sets the value passed in an edit/text box
	 * object.
	 * 
	 * @param Webdriver
	 *            , WebElement, Value, msg
	 */

	public static void dropdownSelectByText(WebDriver driver,
			List<WebElement> WebElemList, String dropdownValue) {

		List<WebElement> dropdownvalues = WebElemList;
		try {
			for (int i = 0; i < dropdownvalues.size(); i++) {
				if (dropdownvalues.get(i).getText().contains(dropdownValue)) {
					dropdownvalues.get(i).click();
					dropdownvalues.get(i).click();
					Reporter.log("Success : DropdownSelection");
					break;
				}
			}
		} catch (Throwable t) {
			// Assert.fail();
			Reporter.log("Failure : DropdownSelection");
		}
	}
	
	/**
	 * Description:This function sets the value pass in text box
	 * object.
	 * 
	 * @param Webdriver
	 *            , WebElement, Value, msg
	 */
	public void inputText(WebDriver driver, WebElement element,
			CharSequence value, String msg) {
		log4jlogger.debug(msg);
		try {
			if (element.getText() != null) {
				msgText = element.getText();
			} else {
				msgText = element.getTagName();
			}
			element.clear();
			element.sendKeys(value);
			log4jlogger.debug("In " + driver.getTitle()
					+ " page, entered the value : " + value + " for " + msgText
					+ " textbox field.");
		} catch (NoSuchElementException nex) {
			String message = "In " + driver.getTitle() + " page, " + msgText
					+ " is not present.";
			log4jlogger.debug(message, nex);

			throw new NoSuchElementException(message, nex);
		} catch (Throwable thr) {
			if (thr instanceof ElementNotVisible) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " textbox field is not visible.";
				log4jlogger.debug(message, thr);
				throw new ElementNotVisible(message, thr);
			} else if (thr instanceof ElementNotEditable) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " textbox field is not editable.";
				log4jlogger.debug(message, thr);
				throw new ElementNotEditable(message, thr);
			} else {
				// String message = "In " + driver.getTitle() +
				// " page, Got some exception while performing action " +
				// msgText + " textbox field.";
				/*
				 * log4jlogger.debug(message, thr);
				 * 
				 * throw new RuntimeException(message, thr);
				 */
			}
		}
	}

	/**
	 * Description:This function Selects Item from dropdown list box with
	 * Options.
	 * 
	 * @param Webdriver
	 *            , WebElement, valToBeSelected, msg
	 */

	public void selectItemFromDropdown(WebDriver driver,
			WebElement element, String valToBeSelected, String msg) {
		log4jlogger.debug(msg);
		try {
			if (element.getText() != null) {
				msgText = element.getText();
			} else {
				msgText = element.getTagName();
			}
			List<WebElement> options = driver
					.findElements(By.tagName("option"));
			Select selectOption = new Select(element);

			if (options != null) {
				for (WebElement option : options) {
					if (valToBeSelected.equalsIgnoreCase(option.getText())) {
						selectOption.selectByVisibleText(valToBeSelected);
					}
				}
				log4jlogger.debug("In " + driver.getTitle()
						+ " page, Select : " + valToBeSelected + " for "
						+ msgText + " from dropdown field field.");
			} else {
				log4jlogger.error("In " + driver.getTitle()
						+ " page, No Options are available in the dropdowns");
				throw NullPointerException;
			}
		} catch (NoSuchElementException nex) {
			String message = "In " + driver.getTitle() + " page, " + msgText
					+ " is not present.";
			log4jlogger.error(message, nex);

			throw new NoSuchElementException(message, nex);
		} catch (Throwable thr) {
			if (thr instanceof ElementNotVisible) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " textbox field is not visible.";
				log4jlogger.error(message, thr);
				throw new ElementNotVisible(message, thr);
			} else if (thr instanceof ElementNotEditable) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " textbox field is not editable.";
				log4jlogger.debug(message, thr);
				throw new ElementNotEditable(message, thr);
			} else {
				String message = "In " + driver.getTitle()
						+ " page, Got some exception while performing action "
						+ msgText + " textbox field.";
				log4jlogger.error(message, thr);

				throw new RuntimeException(message, thr);
			}
		}
	}

	public static void selectValueFromDropdown(WebDriver driver,
			WebElement element, String valToBeSelected, String msg) {
		log4jlogger.debug(msg);
		try {
			if (element.getText() != null) {
				msgText = element.getText();
			} else {
				msgText = element.getTagName();
			}
			List<WebElement> options = driver
					.findElements(By.tagName("option"));
			Select selectOption = new Select(element);
			selectOption.selectByValue(valToBeSelected);
		} catch (NoSuchElementException nex) {
			String message = "In " + driver.getTitle() + " page, " + msgText
					+ " is not present.";
			log4jlogger.error(message, nex);

			throw new NoSuchElementException(message, nex);
		} catch (Throwable thr) {
			if (thr instanceof ElementNotVisible) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " textbox field is not visible.";
				log4jlogger.error(message, thr);
				throw new ElementNotVisible(message, thr);
			} else if (thr instanceof ElementNotEditable) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " textbox field is not editable.";
				log4jlogger.debug(message, thr);
				throw new ElementNotEditable(message, thr);
			} else {
				String message = "In " + driver.getTitle()
						+ " page, Got some exception while performing action "
						+ msgText + " textbox field.";
				log4jlogger.error(message, thr);

				throw new RuntimeException(message, thr);
			}
		}
	}

	/**
	 * Description: This function selects check box element is it's not
	 * selected.
	 * 
	 * @param Webdriver
	 *            , WebElement, msg
	 */

	public void selectCheckbox(WebDriver driver, WebElement element, String msg) {
		log4jlogger.debug(msg);
		try {
			if (element.getText() != null) {
				msgText = element.getText();
			} else {
				msgText = element.getTagName();
			}
			if (element.isDisplayed() && element.isEnabled()
					&& !element.isSelected()) {
				try {
					element.click();
					log4jlogger.debug("	Clicked on " + msgText + " CheckBox");
				} catch (WebDriverException webex) {
					String message = webex.getMessage();
					if (message.toLowerCase().contains(
							"unknown error".toLowerCase())) {
						element.click();
					} else {
						log4jlogger.debug("CheckBox can't be Selected ");
						throw webex;
					}
				}
			} else if (element.isDisplayed() && element.isEnabled()
					&& element.isSelected()) {
				log4jlogger.debug("CheckBox is already Selected ");
			} else {

				throw new ElementNotEditable(
						"CheckBox[WebElement] is non Editable : ");
			}
			log4jlogger.debug("In " + driver.getTitle() + " page, Clicked on :"
					+ msgText + " CheckBox field.");
		} catch (Throwable thr) {
			if (thr instanceof ElementNotVisible) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " CheckBox field is not visible.";
				log4jlogger.debug(message, thr);
				throw new ElementNotVisible(message, thr);
			} else if (thr instanceof ElementNotEditable) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " CheckBox field is not editable.";
				log4jlogger.debug(message, thr);
				throw new ElementNotEditable(message, thr);
			}
		}
	}

	/**
	 * Description: This function clicks a link element.
	 * 
	 * @param Webdriver
	 *            , WebElement, msg
	 */

	public void linkClick(WebDriver driver, WebElement element, String msg) {
		log4jlogger.debug(msg);
		try {
			if (element.getText() != null) {
				msgText = element.getText();
			} else {
				msgText = element.getTagName();
			}

			if (element.isDisplayed() && element.isEnabled()) {
				try {
					element.click();
					log4jlogger.debug("	Clicked on " + msgText + " link");
				} catch (WebDriverException webex) {
					String message = webex.getMessage();
					if (message.toLowerCase().contains(
							"unknown error".toLowerCase())) {
						element.click();
					} else {
						log4jlogger.debug("link can't be Clicked ");
						throw webex;
					}
				}
			} else {

				throw new ElementNotEditable(
						"Link[WebElement] is non Clickable : ");
			}
			log4jlogger.debug("In " + driver.getTitle() + " page, Clicked on :"
					+ msgText + " Web Link.");
		} catch (Throwable thr) {
			if (thr instanceof ElementNotVisible) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " Link is not visible.";
				log4jlogger.debug(message, thr);
				throw new ElementNotVisible(message, thr);
			} else if (thr instanceof ElementNotEditable) {
				String message = "In " + driver.getTitle() + " page, "
						+ msgText + " Link is not Clickable.";
				log4jlogger.debug(message, thr);
				throw new ElementNotEditable(message, thr);

			}
		}
	}

	/**
	 * This Method overs mouse on a desired Webelement
	 * 
	 * @param driver
	 * @param by
	 * @throws InterruptedException
	 */
	public static void mouseHover(WebDriver driver, WebElement element)
			throws InterruptedException {
		try {

			Actions builder = new Actions(driver);

			builder.moveToElement(element);
			builder.build();
			builder.perform();

			log4jlogger.debug("Success : Mouse Over");
			Reporter.log("Success : Mouse Over");

		} catch (Throwable thr) {
			System.out.println("*****"+thr);
			Thread.sleep(2000);

			log4jlogger.debug("Failed : Mouse Over", thr);
			Reporter.log("Failed : Mouse Over");
		}
	}

	public static void openUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().window().maximize();

	}

	// Random Selection of Variable Types
	public static int randomSelection(List<WebElement> elements)
			throws InterruptedException {
		System.out.println("*****size" + elements.size());
		rand = new Random();
		int elesize = elements.size();
		int randNumber = rand.nextInt(elements.size());
		System.out.println("**********randomSelection" + randNumber
				+ "**********");
		if (elesize == 12 && randNumber == 0) {
			System.out.println("**********randomSelection" + randNumber
					+ "**********");
			randNumber = 1;
			System.out.println("**********randomSelection" + randNumber
					+ "**********");
		}

		return randNumber;

		/*
		 * rand=new Random(); int index =
		 * rand.nextInt((elements.size()-1)-0+1)+0; // int index = r.nextInt(max
		 * - min + 1) + min; String id =
		 * elements.get(index).getAttribute(Value); System.out.println(id);
		 */

	}

	// Generates a Random Number From a range
	/*
	 * public static int getRandomNumber(int size) throws InterruptedException {
	 * //
	 * 
	 * int minimum = 5; rand = new Random(); int randNumber = minimum +
	 * rand.nextInt(size); return randNumber; }
	 */

	public static int getRandomNumber(int min, int max) {

		return ThreadLocalRandom.current().nextInt(min, max);

	}

	/**
	 * This Method waits until the page loads.
	 * 
	 * @param driver
	 */

	public static void waitForpageToLoad(WebDriver driver) {
		try {
			driver.manage().timeouts()
					.pageLoadTimeout(timeoutsec, TimeUnit.SECONDS);
		} catch (Throwable t) {
			Assert.fail();

		}
	}

	public static void loadPropFileValues() throws IOException {
		String configFilePath = System.getProperty("user.dir") + File.separator
				+ "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "Config.properties";
		System.out.println("configpath::::::::" + configFilePath);
		propConfigFile = new Properties();
		InputStream inputStream = null;
		inputStream = new FileInputStream(configFilePath);
		propConfigFile.load(inputStream);
	}

	/**
	 * Get value from Configuration property file
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getPropFileValues(String key) throws IOException {
		String value = propConfigFile.getProperty(key);
		return value;
	}

	/**
	 * This Method waits until the Web element is visible.
	 * 
	 * @param driver
	 * @param by
	 */

	public void waitForVisibilityOfElement(WebDriver driver, WebElement e) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutsec);
			wait.until(ExpectedConditions.visibilityOf(e));
			//System.out.println("*%^$%#$@#!@!#$@%$^$%$" + ExpectedConditions.visibilityOf(e));
			//Thread.sleep(5000);
			Reporter.log("Success : Element is  visible");
		} catch (Throwable t) {
			//Assert.fail();
			Reporter.log("Failed : Element is not visible");
		}
	}

	/**
	 * Select Radio button
	 */
	public static void selectedRadioButton(WebDriver driver,
			WebElement element, String msg) {
		log4jlogger.info(msg);
		try {
			if (element.isSelected() && element.isEnabled()) {
				Reporter.log("Button is already Selected");
				log4jlogger.info("Button is already Selected");
			} else {
				Reporter.log("Select the respective element");
				log4jlogger.info("Select the respective element");
				element.click();
			}
		} catch (Exception e) {
			Reporter.log("Exception encountered while selecting Radio button");

			log4jlogger
					.error("Exception encountered while selecting Radio button");
			e.printStackTrace();
		}
	}

	/**
	 * @return Returns true if element is visible, else false.
	 */
	public static boolean isElementVisible(WebElement element, String msg)
			throws ElementNotVisibleException {
		log4jlogger.debug(msg);
		return element.isDisplayed();
	}

	/**
	 * @return Returns Attribute value of given element.
	 */
	public String getAttributeValues(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	/**
	 * Wait for given time: Implicit wait for Given time in config.properties
	 * file.
	 */

	/**
	 * Wait for Page load : Wait Until given element is visible on the page
	 */
	public void waitForPagetoLoad(WebDriver driver, WebElement element,
			String msg) {
		log4jlogger.debug(msg);
		log4jlogger.debug("Wait Until expected element is visible on the page");
		new WebDriverWait(driver, 20);
		// until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	/**
	 * Description:This function sets the value passed in an edit/text box
	 * object.
	 * 
	 * @param Webdriver, WebElement, Value, msg
	 * @throws InterruptedException 
	 */

	public void selectByTextInDropdown(WebDriver driver,
			List<WebElement> WebElemList, String dropdownValue) throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> dropdownvalues = WebElemList;
		Thread.sleep(1000);
		try {
	        for (WebElement option : dropdownvalues) {
	    		Thread.sleep(1000);
	    		System.out.println(option.getText()+"=========dropdown values");
	            if (option.getText().equalsIgnoreCase(dropdownValue)) {
	            	option.click();
	                Reporter.log("Success : DropdownSelection");
	                break;
	            }
			}
		} catch (Throwable t) {
			Reporter.log("Failure : DropdownSelection");
		}
	}
	public static void takeSnapshot(WebDriver driver, String name){
		try {
			String fileName = "E:\\SeleniumWorkspace_IM\\TrackXtrueLocate\\test-output\\Screenshot\\" + name + "\\";
			File file = new File(fileName);
			  if (!file.exists())
			   file.mkdirs();
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(fileName + System.currentTimeMillis() +".png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * @return Returns true if element is visible, else false.
	 */
	public static boolean isElementSelected(WebElement element)
			throws ElementNotVisibleException {
		return element.isSelected();
	}
}