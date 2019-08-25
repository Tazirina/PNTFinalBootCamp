package com.multicart.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.multicart.qa.base.TestBase;

public class SmokeTest {
	// Global Variable for the Test Application 
		TestBase mytestapp; 

		
		
		@BeforeMethod
		public void initApplication() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Tazirina.Awwal\\Documents\\PNT\\SELENIUM\\Driver\\chromedriver.exe");
			mytestapp = new TestBase();
			mytestapp.gotoapp();
		}
		

		@Test
		public void loginwithValidIDPassword() {
			
			// And I enter valid credentials 
			mytestapp.loginWith("user","pass");
			
			// Then I see my profile name  as James Williams
			assertEquals(mytestapp.validateProfileNameas("James Williams-X"), true, "Profile Name not Matched!!!");
			
			// Close 
			mytestapp.ApplicationClose();
		}
		
		@Test
		public void validRegistraion() {

			String randomName;
			randomName = "X" +  Math.random();
			
			// And start the Registration Process
			mytestapp.startRegistraion();

			// And I Complete the Registration 
			mytestapp.completeRegistrationFormWith(randomName+"@gmail.com","Mr"+randomName, "MR", randomName);

			// Then I see my profile name  as MR X
			assertEquals(mytestapp.validateProfileNameas("MR "+ randomName), true, "Registraion Failed !!!");


		}
		

		
		@AfterMethod
		public void tearDown() {
			mytestapp.ApplicationClose();
		}
		
}
