package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {

	WebDriver driver;
			
	@Given("^Open Chrome and Start Application$")
	public void Open_Chrome_and_Start_Application() throws Throwable {
	    
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Tazirina.Awwal\\Documents\\PNT\\SELENIUM\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		
	}

	@When("^I Enter a Valid \"([^\"]*)\" and Valid \"([^\"]*)\"$")
	public void I_Enter_a_Valid_Username_and_Valid_Password(String uname, String pass) throws Throwable {
	    
		//Enter Login Info
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("pass")).sendKeys(pass);
		Thread.sleep(3000);
	}

	@Then("^User should be able to Login Successfully$")
	public void User_should_be_able_to_Login_Successfully() throws Throwable {
	    //Click Login Button
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(3000);	
		driver.quit();
	}
		
	@When("^I Enter a Valid \"([^\"]*)\" and Valid \"([^\"]*)\" and Valid \"([^\"]*)\" and Valid \"([^\"]*)\" and Valid \"([^\"]*)\" and Valid \"([^\"]*)\" and Valid \"([^\"]*)\"$")
	public void I_Enter_a_Valid_Firstname_and_Valid_Lastname_and_Valid_Mobile_and_Valid_Newpwd_and_Valid_Month_and_Valid_Day_and_Valid_Year (String firstname, String lastname, String mobile, String newpwd, String month, String day, int year) throws Throwable {
	    
		//New User Registration Info
		driver.findElement(By.id("u_0_e")).sendKeys(firstname);
		driver.findElement(By.id("u_0_g")).sendKeys(lastname);
		driver.findElement(By.id("u_0_j")).sendKeys(mobile);
		
		driver.findElement(By.id("u_0_q")).sendKeys(newpwd);
		
		Select sel1=new Select(driver.findElement(By.id("month")));
		sel1.selectByVisibleText(month);
		
		Select sel2=new Select(driver.findElement(By.id("day")));
		sel2.selectByValue(day);
		
		Select sel3=new Select(driver.findElement(By.id("year")));
		sel3.selectByIndex(year);
		
		//Female Gender Selection xpath/id
		driver.findElement(By.id("u_0_8")).click();
		
		//Male Gender Selection xpath/id
		//driver.findElement(By.id("u_0_9")).click();
							
	}

	@Then("^User should be able to Signup Successfully$")
	public void User_should_be_able_to_Signup_Successfully() throws Throwable {
	    
		//Click SignUp Button
		driver.findElement(By.id("u_0_y")).click();
		Thread.sleep(3000);	
		driver.quit();
		
	}

	
	
}
