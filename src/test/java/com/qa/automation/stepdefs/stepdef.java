package com.qa.automation.stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdef {
	
	WebDriver driver;
	WebDriverWait wait;
	String BaseUrl = "https://www.amazon.in/";
	int implictlyWaitTimeoutSec = 20;
	Scenario scn;
	
	

		@Given("user opened browser")
		public void user_opened_browser() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Manali Patil\\eclipse-workspace\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");

			ChromeOptions opt = new ChromeOptions();
			opt.setBinary("C:\\Users\\Manali Patil\\eclipse-workspace\\chrome-win64 (2)\\chrome-win64\\chrome.exe");

			driver = new ChromeDriver(opt);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(implictlyWaitTimeoutSec,TimeUnit.SECONDS);
		
		}

		@When("user navigate to the home application url")
		public void user_navigate_to_the_home_application_url() {
			driver.get(BaseUrl);
			String exceptedtitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			String actualtitle = driver.getTitle();
			Assert.assertEquals("navigate to the page",exceptedtitle,actualtitle);
		}
		@Then("user search for product {string}")
		public void user_search_for_product(String productName) {
			WebElement searchBoxEle = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(searchBoxEle));
			searchBoxEle.sendKeys("Jeans");
			
			WebElement searchBtnEle = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		    searchBtnEle.click();
		}
		@Then("Search result page is displayed with page title keyword contains {string}")
		public void search_result_page_is_displayed_with_page_title_keyword_contains(String titleProdNameKeyword) {
			
			String exceptedtitle ="Amazon.in : Jeans";
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.titleContains(titleProdNameKeyword));
			Assert.assertEquals(exceptedtitle, driver.getTitle());
		}

}


