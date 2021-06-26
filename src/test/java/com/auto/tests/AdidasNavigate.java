package com.auto.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auto.utils.TestDataUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Geetika
 *
 */
public class AdidasNavigate {
	public WebDriver driver;
	private String baseUrl;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		baseUrl = TestDataUtils.getBaseURL();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@Test
	public void adidasNavigate() throws Exception {
		String expectedTitle = "adidas Online Shop | adidas AU";
		
		WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
		login.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
}
