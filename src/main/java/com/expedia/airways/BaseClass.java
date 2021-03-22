package com.expedia.airways;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.Scenario;
@ScenarioScoped
public class BaseClass {
	private WebDriver driver;
	private BrowserClass browser = null;
	private Scenario scenario;
	
	public BaseClass() {
		initializeDriver();
	}

	public void initializeDriver() {
		if(getConfig().getBrowserName().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		if(getConfig().getBrowserName().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
	}
	}
	public BrowserClass getBrowser() {
		if (browser == null) {
			browser = new BrowserClass(this);
		}
		return browser;
	}
	public Configuration getConfig() {
		Configuration config = new Configuration();
		return config;
	}
	public WebDriver getDriver() {
		return driver;
	}
	 
	public WaitHandler getWaitHandler() {
		return new WaitHandler(this);
	}
	
	public JavascriptExecutor getScriptExecutor() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		return executor;
	}
	
	public Actions getActionsClass() {
		Actions actions = new Actions(driver);
		return actions;
		
	}
	public void setScenario(Scenario scenario) {
		this.scenario= scenario;
	}
	
	public Scenario getSCenario() {
		return scenario;
	}
}
	
