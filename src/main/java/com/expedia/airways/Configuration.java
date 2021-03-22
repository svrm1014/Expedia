package com.expedia.airways;

import java.io.FileReader;
import java.util.Properties;

//import org.apache.tools.ant.property.GetProperty;

public class Configuration {
	Properties prop = new Properties();
	public Configuration() {
		try {
			FileReader file=new FileReader("C:\\Users\\bagan\\eclipse-workspaceforamazon\\SeleniumOnExpedia\\src\\main\\resources\\Configuration\\config.properties");
			prop.load(file);
		}catch(Exception e){
			System.out.println("Something went wrong in configuration of driver");
		}
		
	}
	public String getBrowserName() {
		String browser = prop.getProperty("browser");
		return browser;
	}
	public String getUrl() {
		String url = prop.getProperty("url");
		return url;
	}
	public String getUserName() {
		String username = prop.getProperty("username");
		return username;
	}
	public int getGlobalTimeout() {
		int global_timeout = Integer.valueOf(prop.getProperty("Global_timeout"));
		return global_timeout;
	}

}
