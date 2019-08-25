package com.multicart.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestUtil {

	//Parameter definitions
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	WebDriver driver;
	
	public WebDriver launchwith(String browserType, String URL) {
		
		// Create the Driver 
		if (browserType.equals("chrome")){
			driver = new ChromeDriver();
		} else if(browserType.equals("mozilla")) {
			driver = new FirefoxDriver();
		} else if(browserType.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("Not A valid Driver !!!!");
		}
		
		// go to the application
		driver.get(URL);
		
		return driver;
		
	}
}
