package com.expedia.airways;

import org.openqa.selenium.WebDriver;

public class BrowserClass {
	public WebDriver driver;
	public BaseClass base;
	public Configuration config;
	
	public BrowserClass(BaseClass base) {
		this.base = base;
		config = base.getConfig();
		driver = base.getDriver();
	}

	public void open() {

		driver.get(config.getUrl());

	}

	public void close() {
		driver.close();
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void fullscreen() {
		driver.manage().window().fullscreen();
	}

	public String getTitle() {
		return driver.getTitle();
	}

}



