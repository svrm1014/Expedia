package com.expedia.airways;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHandler {

	WebDriver driver;
	WebDriverWait wait;
	Configuration config;

	public WaitHandler(BaseClass base) {
		driver = base.getDriver();
		config = base.getConfig();
		wait = new WebDriverWait(driver, config.getGlobalTimeout());
		driver.manage().timeouts().implicitlyWait(config.getGlobalTimeout(), TimeUnit.SECONDS);
	}

	public boolean waitForVisibilityOfElement(WebElement webElement) {
		boolean isVisible = true;
		try {
			wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			isVisible = false;
		}
		return isVisible;
	}

	public boolean waitForElementToBeClickable(WebElement webElement) {
		boolean isClickable = true;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			isClickable = false;
		}
		return isClickable;
	}

	public boolean waitForPresenceOfElement(By by) {
		boolean isPresent = true;
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			isPresent = false;
		}
		return isPresent;
	}

}

