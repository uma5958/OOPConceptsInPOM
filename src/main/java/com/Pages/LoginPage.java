package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// Page Locators 
	private By emailId = By.id("username");
	private By passWord = By.id("password");
	private By loginButton = By.id("loginBtn");
	private By header = By.xpath("//i18n-string[contains(@data-key,'login.signupLink.text')]");
	
	// Page Actions
	/**
	 * @return the emailId
	 */
	public WebElement getEmailId() {
		return getElement(emailId);
	}
	/**
	 * @return the passWord
	 */
	public WebElement getPassWord() {
		return getElement(passWord);
	}
	/**
	 * @return the loginButton
	 */
	public WebElement getLoginButton() {
		return getElement(loginButton);
	}
	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public String getLoginPageHeader() {
		return getPageHeader(header);
	}
	
	public HomePage doLogin(String username, String pwd) {
		getEmailId().sendKeys(username);
		getPassWord().sendKeys(pwd);
		getLoginButton().click();
		return getInstance(HomePage.class);
	}
	
	public void doLogin() {
		getEmailId().sendKeys("");
		getPassWord().sendKeys("");
		getLoginButton().click();
	}
	
	// username : naveen@gmail.com
	public void doLogin(String userCred) {
		if (userCred.contains("username")) {
			getEmailId().sendKeys(userCred.split(":")[1].trim());
		} else if (userCred.contains("password")) {
			getEmailId().sendKeys(userCred.split(":")[1].trim());
		}
		getLoginButton();
	}
}
