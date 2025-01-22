package com.utkarshbank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetupPage {

	private static WebDriver driver = null;

	private static final Logger logger = Logger.getLogger(DriverSetupPage.class.getName());

	public static WebDriver setupChromeDriver() {

		logger.info("Starting of setupChromeDriver method");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		logger.info("Ending of setupChromeDriver method");
		return driver;
	}

	public static WebDriver setupFirefoxDriver() {

		logger.info("Starting of setupFirefoxDriver method");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		logger.info("Starting of setupFirefoxDriver method");
		return driver;
	}

	public static WebDriver setupIEDriver() {

		logger.info("Starting of setupIEDriver method");
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		logger.info("Starting of setupIEDriver method");
		return driver;
	}

	public static WebDriver invokeDrivers(String browser) {
		logger.info("Starting of invokeDrivers method ");
		logger.info("Ending of invokeDrivers method");
		switch (browser.toLowerCase()) {
		case "firefox":
			return setupFirefoxDriver();
		case "chrome":
			return setupChromeDriver();

		case "ie":
			return setupIEDriver();

		default:
			return setupChromeDriver();

		}
	}

}
