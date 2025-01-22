package com.utkarshbank.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

	// Instance of WebDriver to perform actions on the browser.
	WebDriver driver = null;

	// Logger instance to log messages for debugging and tracking.
	private static final Logger logger = Logger.getLogger(BasePage.class.getName());

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void explicitWait(WebElement element) {
		
		logger.info("Starting of explicitWait method in BasePage");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		logger.info("Ending of explicitWait method in BasePage");
	}

	public void explicitWaitList(List<WebElement> categoryOptions) {
		logger.info("Starting of explicitWait method");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(categoryOptions));
		logger.info("Ending of explicitWait method");
	}

	public void clickOnWebElement(WebElement element) {
		logger.info("Starting of clickOnWebElement method in BasePage");
		element.click();
		logger.info("Ending of clickOnWebElement method in BasePage");
	}

	public void scrollDown(int scroll) {
		logger.info("Starting of scrollDown methods");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + scroll + ")");
		logger.info("Ending of scrollDown method");
	}

	public void selectOptions(WebElement element, String value) {
		logger.info("Starting of selectOptions method");
		Select select = new Select(element);
		select.selectByIndex(1); // Hardcoded to select index 1; modify if needed for dynamic selection.
		logger.info("Ending of selectOptions method");
	}
}
