package com.utkarshbank.tests;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {

	/** WebDriver instance used to interact with web browsers. */
	public WebDriver driver;

	/** Logger instance for logging information and debugging details. */
	private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

	/** Properties object to store test data. */
	protected static Properties testDataProp = null;

	/** Properties object to store expected assertion values. */
	protected static Properties expectedAssertionsProp = null;

	/**
	 * Initializes the test data and expected assertions properties by loading them
	 * from external property files.
	 * 
	 * <p>
	 * This method is synchronized to ensure thread safety during property
	 * initialization.
	 */
	@BeforeSuite
	public synchronized void initTestData() {

		logger.info("Starting of initTestData Method in BaseTest");

		if (testDataProp == null) {

			FileReader testDataReader = null;
			FileReader assertionsReader = null;

			try {
				testDataReader = new FileReader("src/test/resources/testdata.properties");
				assertionsReader = new FileReader("src/test/resources/expectedassertions.properties");

				testDataProp = new Properties();
				testDataProp.load(testDataReader);

				expectedAssertionsProp = new Properties();
				expectedAssertionsProp.load(assertionsReader);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (testDataReader != null) {
						testDataReader.close();
					}
					if (assertionsReader != null) {
						assertionsReader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		logger.info("Ending of initTestData Method in BaseTest ");
	}

	/**
	 * Initializes the WebDriver instance and navigates to the specified URL.
	 * 
	 * @param siteUrl the URL of the website to navigate to
	 * @param browser the type of browser to use (e.g., Chrome, Firefox)
	 */
	@Parameters({ "siteURL", "browser" })
	public void initWebDriver(String siteUrl, String browser) {

		logger.info("Starting of initWebDriver Method in BaseTest");

		driver = DriverSetupPage.invokeDrivers(browser);
		driver.manage().deleteAllCookies();
		driver.get(siteUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		System.err.println("Running on -->> " + browser + "  browser");

		logger.info("Ending of initWebDriver Method in BaseTest");
	}

	/**
	 * Performs login operation using credentials from the test data properties.
	 * 
	 * @throws InterruptedException if the thread is interrupted during execution
	 */

	/**
	 * Closes the WebDriver instance and releases browser resources.
	 */

	public void quitWebDriver() {
		logger.info("Starting of quitWebDriver Method in BaseTest ");

		if (driver != null) {
			driver.quit();
			System.err.println("Driver closed.");
			System.gc();
			driver = null; // Ensure the driver is reset after quitting
		}

		logger.info("Starting of quitWebDriver Method in BaseTest");

	}

	public WebDriver getDriver() {
		logger.info("Starting of getDriver Method in BaseTest ");
		logger.info("Ending of getDriver Method in BaseTest ");
		return null;
	}
}
