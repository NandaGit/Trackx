package com.trackx.truelocate.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class Truelocatelogin {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	

	@FindBy(id="email")
	WebElement txt_username;

	@FindBy(id= "password")
	WebElement txt_password;

	@FindBy(xpath = "//*[@id='login']/div[2]/div[1]/div[3]/div/form/div[2]/button")
	WebElement btn_login;

	@FindBy(xpath = "//*[@id='logout']/span/a")
	WebElement btn_logout;

	@FindBy(xpath = "//*[@id='bot2-Msg1']")
	WebElement btn_logout1;

	public Truelocatelogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Enter Username/password
	public void enterUsernamepassword(String sUsername, String sPassword) {
		try {
			inAction.waitForVisibilityOfElement(driver, txt_username);
			inAction.inputText(driver, txt_username, sUsername,
					"Enter sUsername : " + sUsername);
			inAction.waitForVisibilityOfElement(driver, txt_password);
			inAction.inputText(driver, txt_password, sPassword,
					"Enter sPasswordsCompDate : " + sPassword);
			inAction.waitForElementToBeClickable(driver, btn_login);
			inAction.buttonClick(driver, btn_login, 
					"Click button : btn_login");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public boolean pageTitleValidation() throws InterruptedException {
		System.out.println("Msg:" + driver.getTitle());
		Thread.sleep(1000);
		String pageTitle = driver.getTitle();
		if (pageTitle.equalsIgnoreCase(constants.home_pageTitle)) {
			Assert.assertEquals(pageTitle, constants.home_pageTitle);
			return true;
		} else {
			Assert.assertNotEquals(pageTitle, constants.home_pageTitle);
			return false;
		}
	}

@DataProvider
public static Object[][] getData() {
	return GeneralActions.getData("Login");
}
}
	