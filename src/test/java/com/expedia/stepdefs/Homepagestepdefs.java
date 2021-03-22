package com.expedia.stepdefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.expedia.airways.BaseClass;
import com.expedia.airways.WaitHandler;
import com.google.inject.Inject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Homepagestepdefs {
	
	BaseClass base;
	WebDriver driver;
	WaitHandler wait;
	Actions actions;
	JavascriptExecutor js;

	@Inject
	public Homepagestepdefs(BaseClass base) {
		this.base = base;
		driver = base.getDriver();
		wait = base.getWaitHandler();
		actions = base.getActionsClass();
		js = (JavascriptExecutor) driver;

	}
	@Given("user launches the Expedia URL")
	public void user_launches_the_expedia_url() {
		base.getBrowser();
		base.getDriver().navigate().to("https://www.expedia.com/");
	}

	@When("validating Tthe Title of Expedia")
	public void validating_tthe_title_of_expedia() {
		System.out.println(base.getDriver().getTitle());
		Assert.assertTrue(base.getDriver().getTitle().contains("Expedia"), "Title matching failed");
	}

	@When("getting the Required fields to available get Flight details")
	public void getting_the_required_fields_to_available_get_flight_details() {
		System.out.println("The list of services available under Expedia Website:");
		List<WebElement> services=driver.findElements(By.xpath("//span[@class='uitk-tab-text']"));
		for(WebElement s:services) {
			System.out.println(s.getText());
		}
//		driver.findElement(By.xpath("//span[text()='Flights']")).click();
//		driver.findElement(By.xpath("//span[text()='Roundtrip']")).click();
		
	}

	@Then("Goto to Download the Expedia app Field")
	public void goto_to_download_the_expedia_app_field() {
		WebElement ma = driver.findElement(By.xpath("//button[text()='Get the app']"));
		js.executeScript("arguments[0].scrollIntoView(true);",ma);
//		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		System.out.println("Bharat:" + js);
	}

	@Then("user enters the Phone number to get Mobile App")
	public void user_enters_the_phone_number_to_get_mobile_app() {
			driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("1234568954");
			driver.findElement(By.id("submitBtn")).click();
	}

}
