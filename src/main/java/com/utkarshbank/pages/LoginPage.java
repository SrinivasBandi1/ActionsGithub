package com.utkarshbank.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//div[@class='login-btn']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//div[@class='page-heading']")
	private WebElement headerDashboard;
	

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public String getLoginURL() {
		logger.info("Staring of getLoginURL method");
		String loginURL = this.driver.getCurrentUrl();
		logger.info("Ending of getLoginURL method");
		return loginURL;
	}

	public void setEmail(String email) {

		logger.info("Staring of setEmail method");
		explicitWait(txtEmail);
		this.txtEmail.sendKeys(email);
		logger.info("Ending of setEmail method");

	}

	public void setPassword(String password) {

		logger.info("Staring of setPassword method");
		explicitWait(txtPassword);
		this.txtPassword.sendKeys(password);
		logger.info("Ending of setPassword method");

	}

	public void clickonLogin() {

		clickOnWebElement(btnLogin);

	}
	
	public String getDashboardTitle() {
		
		return this.headerDashboard.getText();
	}

}
