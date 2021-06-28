package com.auto.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auto.pagefactory.HomePageFactory;
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
	HomePageFactory objHome;
	
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
		
		objHome = new HomePageFactory(driver);
		objHome.clickLoginLink();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Verify the new page title after navigating
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	@AfterClass(alwaysRun = true)
	public void exit() throws Exception {
		driver.quit();
	}
	
}
