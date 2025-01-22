package com.utkarshbank.tests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utkarshbank.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest extends BaseTest {

	private LoginPage loginPage = null;

	private static final Logger logger = Logger.getLogger(LoginTest.class.getName());

	@BeforeMethod
	@Parameters({ "siteURL", "browser" })
	public void initDriver(@Optional("defaultSiteURL")String siteURL, String browser) throws InterruptedException {

		logger.info("Starting of initDriver method in LoginTest");
		if (driver == null) {

			initWebDriver(siteURL, browser);
		}
		loginPage = new LoginPage(driver);

		logger.info("Ending of initDriver method in LoginTest");

	}

	@Test(priority = 1, description = "Login functionality", enabled = true)
	@Description("Verify the login functionality with valid credentials")
	@Severity(SeverityLevel.BLOCKER)

	public void testverifyLoginFunctionality() throws InterruptedException {

		logger.info("Starting of testverifyLoginFunctionality method in LoginTest");

		try {

			// Verifying Login URL

			Assert.assertEquals(loginPage.getLoginURL(), expectedAssertionsProp.getProperty("login.url"));

			// Performing login action

			this.loginPage.setEmail(testDataProp.getProperty("email"));
			this.loginPage.setPassword(testDataProp.getProperty("password"));
			this.loginPage.clickonLogin();

			// Verifying the Dashboard page after log-in

			assertEquals(this.loginPage.getDashboardTitle(), expectedAssertionsProp.getProperty("dashboard.title"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the LoginTest" + e.getMessage());
			logger.error("Error occured while testing the LoginTest", e);
		}

		logger.info("Ending of testverifyLoginFunctionality method in LoginTest");

	}

	@AfterMethod
	public void quitDriver() {
		logger.info("Ending of quitDriver method in LoginTest");

		quitWebDriver();

		logger.info("Ending of quitDriver method in LoginTest");
	}

}
