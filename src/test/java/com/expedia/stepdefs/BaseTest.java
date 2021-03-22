package com.expedia.stepdefs;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.expedia.airways.BaseClass;
import com.google.inject.Inject;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

@ScenarioScoped
public class BaseTest {
	
		public BaseClass base;
		public WebDriver driver;
		public Scenario scenario;
		
		@Inject
		public BaseTest(BaseClass base) {
			this.base = base;
			driver = base.getDriver();
			
		}
		
		@Before
		public void beforeScenario(Scenario scenario) {
			System.out.println("this block is executed for every scenario");
			base.setScenario(scenario);
			this.scenario = scenario;
		}
		
		@After
		public void captureScreen() {
			if(scenario.isFailed()) {
			System.out.println("this block is executed after every scenario");
			try {
			byte[] scrShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			File file = new File("Screenshot/screenshot.png");
			scenario.log("my test is completed");
			scenario.attach(scrShot, "image/png", "screenshot");
			}
			catch(Exception e) {
				
				System.out.println("unable to take screenshot");
			}
			}
			 
		}

	}



