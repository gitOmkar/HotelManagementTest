package com.cucumber.MavenCucumberPrototype;

//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
    WebDriver driver = null;
	
	@Given("^I am on website$")
	public void i_am_on_website() throws Throwable {
        driver = new FirefoxDriver();
		driver.navigate().to("https://www.wikipedia.org/");
		//System.out.println("i_am_on_website");
	}

	@When("^I click on link$")
	public void i_click_on_link() throws Throwable {
		driver.navigate().to("https://www.wikipedia.org/");
		//System.out.println("i_click_on_link");
	}

	@Then("^Navigated page should be correct$")
	public void navigated_page_should_be_correct() throws Throwable {
		driver.navigate().to("https://www.wikipedia.org/");
		driver.close();
		//System.out.println("navigated_page_should_be_correct");
	}

}
