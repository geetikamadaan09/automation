package com.auto.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.auto.utils.TestDataUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Geetika
 *
 */
public class AdidasLogin {
	public WebDriver driver;
	private String baseUrl;
	
	
	
	@BeforeSuite(alwaysRun = true)
	public void readTestData() throws Exception {
		TestDataUtils.readTestData();
	}
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		baseUrl = TestDataUtils.getBaseURL();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
		
	@Test
	public void adidasLogin() throws Exception {
		String expectedWelcomeText = "HI GEETIKA";
		
		WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
		login.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement email = driver.findElement(By.id("login-email"));
		WebElement password = driver.findElement(By.id("login-password"));
		email.sendKeys(TestDataUtils.getUserName());
		password.sendKeys(TestDataUtils.getPassword());
		WebElement loginButton = driver.findElement(By.xpath("//span[text()='Log in']"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement salutation = driver.findElement(By.xpath("//h3[text()='Hi Geetika']"));

		Assert.assertEquals(salutation.getText(), expectedWelcomeText);		

	}
	
	
}
