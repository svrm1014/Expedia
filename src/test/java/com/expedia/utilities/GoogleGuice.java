package com.expedia.utilities;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;

	

	public class GoogleGuice implements InjectorSource {
		@Override
	    public Injector getInjector() {
	        //return Guice.createInjector(Stage.PRODUCTION, CucumberModules.SCENARIO, new TestEnvInjector());
	        return Guice.createInjector(Stage.PRODUCTION, CucumberModules.createScenarioModule(), new TestEnvInjector());
	    }
	}



