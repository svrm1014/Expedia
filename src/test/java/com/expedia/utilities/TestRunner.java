package com.expedia.utilities;
import org.testng.annotations.DataProvider;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;
	
	@CucumberOptions(features = "src\\test\\java\\com\\expedia\\fetures",glue= {"com.expedia.stepdefs"},tags= "@Expedia", plugin = { "pretty","html:target/cucumber-htmlreport.html","json:target/cucumber-report.json"})
	public class TestRunner extends AbstractTestNGCucumberTests {
		@DataProvider(parallel = false)
	    @Override
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
	}




