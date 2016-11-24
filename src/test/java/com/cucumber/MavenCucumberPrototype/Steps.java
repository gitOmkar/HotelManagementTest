package com.cucumber.MavenCucumberPrototype;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
   public WebDriver driver = new FirefoxDriver();
   public int records = 0;
	
	@Given("^I am on ([^\"]*)$")
	public void navigateToWebsite(String website) throws Throwable {
		//driver = new FirefoxDriver();
		driver.navigate().to(website);
	}
	
	@When("^I click Login$")
	public void clickLogin() throws Throwable {
		
		driver.findElement(By.xpath("//a[contains(@data-toggle, 'modal')]")).click();
	    
	}

	@When("^I enter the ([^\"]*) and ([^\"]*)$")
	public void enterCredentials(String username, String password) throws Throwable {
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//input[contains(@id, 'username')]")).sendKeys(username);
		driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(@id, 'doLogin')]")).click();
	
	}

	@Then("^I am logged in$")
	public void checkLoggedIn() throws Throwable {
		Thread.sleep(3000);		
		driver.switchTo().activeElement();
		Thread.sleep(3000);		
		Assert.assertTrue("User is logged in",
				driver.findElement(By.xpath("//a[contains(@id, 'logout')]")).getText().equals("Logout"));
		driver.close();
	   
	}

	@Given("^I am logged in on website$")
	public void loginWebsite() throws Throwable {
		driver.navigate().to("http://35.161.122.132:3003/");
		driver.findElement(By.xpath("//a[contains(@data-toggle, 'modal')]")).click();
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//input[contains(@id, 'username')]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys("password");
		driver.findElement(By.xpath("//button[contains(@id, 'doLogin')]")).click();
		Thread.sleep(3000);		
		driver.switchTo().activeElement();
		Thread.sleep(3000);		
		Assert.assertTrue("User is logged in",
	    driver.findElement(By.xpath("//a[contains(@id, 'logout')]")).getText().equals("Logout"));	
		List <WebElement> gridrow =   driver.findElements(By.xpath("//div[contains(@class, 'row detail')]"));
		//System.out.println(gridrow.size());
		records = gridrow.size();
	}

	@When("^I enter ([^\"]*) and ([^\"]*) and ([^\"]*) and ([^\"]*) and ([^\"]*) and Click Create button$")
	public void enterDetailsAndCreateEntry(String hotelname, String address, String owner, String phone, String email) throws Throwable {
		driver.findElement(By.xpath("//input[contains(@id, 'hotelName')]")).sendKeys(hotelname);
		driver.findElement(By.xpath("//input[contains(@id, 'address')]")).sendKeys(address);
		driver.findElement(By.xpath("//input[contains(@id, 'owner')]")).sendKeys(owner);
		driver.findElement(By.xpath("//input[contains(@id, 'phone')]")).sendKeys(phone);
		driver.findElement(By.xpath("//input[contains(@id, 'email')]")).sendKeys(email);
		driver.findElement(By.xpath("//input[contains(@id, 'createHotel')]")).click();
	}

	@Then("^New entry is created$")
	public void checkEntry() throws Throwable {
		Thread.sleep(3000);		
		List <WebElement> gridrow =   driver.findElements(By.xpath("//div[contains(@class, 'row detail')]"));
		//System.out.println(gridrow.size());
		Assert.assertTrue("New Entry is created",gridrow.size()==records+1);
		driver.close();

	}
	
	@Given("^I am logged in as admin$")
	public void loginSystem() throws Throwable {
		driver.navigate().to("http://35.161.122.132:3003/");
		driver.findElement(By.xpath("//a[contains(@data-toggle, 'modal')]")).click();
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//input[contains(@id, 'username')]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys("password");
		driver.findElement(By.xpath("//button[contains(@id, 'doLogin')]")).click();
		Thread.sleep(3000);		
		driver.switchTo().activeElement();
		Thread.sleep(3000);		
		Assert.assertTrue("User is logged in",
	    driver.findElement(By.xpath("//a[contains(@id, 'logout')]")).getText().equals("Logout"));	
		List <WebElement> gridrow =   driver.findElements(By.xpath("//div[contains(@class, 'row detail')]"));
		//System.out.println(gridrow.size());
		records = gridrow.size();
	}

	@When("^I delete the last entry$")
	public void deleteEntry() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(@class, 'glyphicon glyphicon-remove hotelDelete')]")).click();;
	}

	@Then("^Entry gets deleted$")
	public void checkDeletedEntry() throws Throwable {
		Thread.sleep(3000);		
		List <WebElement> gridrow =   driver.findElements(By.xpath("//div[contains(@class, 'row detail')]"));
		//System.out.println(gridrow.size());
		Assert.assertTrue("New Entry is created",gridrow.size()==records-1);
	}
	
}
