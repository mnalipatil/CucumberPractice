package com.qa.automation.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.core.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stefdef {
	
	private static final Logger Logger = LogManager.getLogger(stefdef.class);
	
	WebDriver driver;
	WebDriverWait wait;
	String baseUrl = "https://automationexercise.com/";
	int implictlyWaitTimeoutSec = 20;
    Scenario scn;
    
    @Before
    public void setup(Scenario scn) throws Exception
    {
    	this.scn=scn;
    	String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		wait = new WebDriverWait(driver, implictlyWaitTimeoutSec);
    }
    
    @After
    public void cleanUp()
    {
    	WebDriverFactory.quitDriver();
    	scn.log("Browser got closed");
    	Logger.info("Browser got closed");
    }
//    @Given("user opened browser")
//    public void user_opened_browser() {
//        System.setProperty("Webdriver.chrome.driver","C:\\Users\\Manali Patil\\eclipse-workspace\\chrome-win64 (3)\\chromedriver-win64\\chromedriver.exe");
//        ChromeOptions opt = new ChromeOptions();
//        opt.setBinary("C:\\Users\\Manali Patil\\eclipse-workspace\\chrome-win64 (3)\\chrome-win64\\chrome.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(implictlyWaitTimeoutSec, TimeUnit.SECONDS);
//    }

    @Given("user navigate to the home application url")
    public void user_navigate_to_the_home_application_url() {
    	driver.get("https://automationexercise.com/");
    	String exceptedtitle = "Automation Exercise";
    	String actualtitle = driver.getTitle();
    	Assert.assertEquals(exceptedtitle,actualtitle);	
    	Logger.info("getting a actualtitle");
    }
    
    @When("user click on Signup\\/Login button")
    public void user_click_on_signup_login_button() {
    	WebElement SignupLoginBtn = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
    	Logger.info("clicking on signin and login button");
    	SignupLoginBtn.click();
    }
    @Then("Signup\\/Login page is displayed")
    public void signup_login_page_is_displayed() {
    	WebElement LoginToAcEle = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
    	String Exceptedtitle = "Automation Exercise - Signup / Login";
    	String Actialtitle = driver.getTitle();
    	Assert.assertEquals(Exceptedtitle,Actialtitle);
    	Logger.info("Login to your account and  getting actualTitle");
    }
    @Then("user enter the correct emailid and password {string} and {string}")
    public void user_enter_the_correct_emailid_and_password_and(String emailid, String password) {
    	WebElement EmailId = driver.findElement(By.xpath("//input[@placeholder='Email Address' and @data-qa='login-email']"));
    	EmailId.sendKeys(emailid);
    	
    	WebElement PassEle = driver.findElement(By.xpath("//input[@placeholder='Password' and @data-qa='login-password']"));
    	PassEle.sendKeys(password);
    }
    @Then("user click on login button")
    public void user_click_on_login_button() {
    	WebElement LoginBtn = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
    	LoginBtn.click();
    }
//    @Then("user logged the username is displayed {string}")
//    public void user_logged_the_username_is_displayed(String string) {
//        WebElement loggedAsUsername = driver.findElement(By.xpath("//a[text()=' Logged in as ']//b"));
//        String exceptedText = "Tom";
//        String actualText =driver.getText(string);
//        Assert.assertEquals(exceptedText, actualText);
//    }
    @Then("user clic on logout button")
    public void user_clic_on_logout_button() {
        WebElement logoutBtn = driver.findElement(By.xpath("//a[text()=' Logout']"));
        logoutBtn.click();
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++driver.quit();
	

}
