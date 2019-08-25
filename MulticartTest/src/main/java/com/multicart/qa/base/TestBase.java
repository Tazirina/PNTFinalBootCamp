package com.multicart.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.multicart.qa.util.TestUtil;

public class TestBase {


	// == Locators Variables 
	String LoginLink = "//*[@id=\"dLabellogin\"]";
	String userIdTextBox = "//*[@id=\"username\"]";		
	String passwordTextBox = "//*[@id=\"password\"]";			
	String loginButton = "//*[@id=\"jqLogin\"]";
	String profileNameLabel = "//*[@id=\"dLabel\"]/span";

	
	// == Registration 
	String signupButton = "//*[@id=\"jqSignup\"]";
	String emailTextBox = "//*[@id=\"txtEmail\"]";
	String usernameTextBox = "//*[@id=\"txtUserName\"]";
	String registrationPasswordTextBox = "//*[@id=\"txtPassword\"]";
	String confirmPasswordTextBox = "//*[@id=\"txtCnfPassword\"]";
	String firstNameTextBox = "//*[@id=\"txtFirstName\"]";
	String lastnameTextBox = "//*[@id=\"txtLastName\"]";
	
	String addressTextBox = "//input[@placeholder=\"Address *\"]";
	String notificationChektBox = "//input[@name='check_news']";
	
	String createAccountButton = "//*[@id=\"btnRegister\"]";

	
	
	WebDriver testdriver;

	
	public void gotoapp() {
		System.out.println("going to multicart application");
		TestUtil driver = new TestUtil();
		testdriver = driver.launchwith("chrome","https://www.demo.iscripts.com/multicart/demo/index.php");
	
		//Maximize Window, Delete Cookies and Call Timeouts
			testdriver.manage().window().maximize();
			testdriver.manage().deleteAllCookies();
			testdriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			testdriver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
	}
				
	public void loginWith(String username, String password) {
		System.out.println("Login With " + username + " password");
		// Click Login Link 
		testdriver.findElement(By.xpath(LoginLink)).click();
		
		// Enter ID & Password 
		testdriver.findElement(By.xpath(userIdTextBox)).sendKeys(username);
		testdriver.findElement(By.xpath(passwordTextBox)).sendKeys(password);

		// Click the Login Button 
		testdriver.findElement(By.xpath(loginButton)).click();
		ApplicationWaitfor(3000);
		
	}

	public boolean validateProfileNameas(String profileName) {
		System.out.println("Validating Profile Name as " + profileName);
		return isvalidate(profileName, profileNameLabel);
	}

	public void startRegistraion() {
		// Click Login Link 
		testdriver.findElement(By.xpath(LoginLink)).click();
		// Click Signup Button
		testdriver.findElement(By.xpath(signupButton)).click();

	}
	
	public void completeRegistrationFormWith(String email, String username, String fname, String Lname) {
		//Complete Registration Form 
		testdriver.findElement(By.xpath(emailTextBox)).sendKeys(email);
		testdriver.findElement(By.xpath(usernameTextBox)).sendKeys(username);
		testdriver.findElement(By.xpath(registrationPasswordTextBox)).sendKeys("Dhaka_1986");
		testdriver.findElement(By.xpath(confirmPasswordTextBox)).sendKeys("Dhaka_1986");
		testdriver.findElement(By.xpath(firstNameTextBox)).sendKeys(fname);
		testdriver.findElement(By.xpath(lastnameTextBox)).sendKeys(Lname);
		testdriver.findElement(By.xpath(addressTextBox)).sendKeys("123 5th Ave");
		testdriver.findElement(By.xpath(notificationChektBox)).click();

		testdriver.findElement(By.xpath(createAccountButton)).click();
		ApplicationWaitfor(3000);
	}
	
	
	
	/** Validation Module exp vs actual   */
	public boolean isvalidate(String exptext, String locatorOfActualElement) {
		// Validation Check the User is Mr  
		String expectation = exptext;
		String actual = testdriver.findElement(By.xpath(locatorOfActualElement)).getText();
		if(expectation.equalsIgnoreCase(actual)){
			System.out.println("Test Passed ");
			return true;
		}
		else{
			System.out.println("Test Failed ");
			return false;
		}

	}
	public void ApplicationWaitfor(int milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void ApplicationClose() {
		testdriver.close();
	}
		
}
