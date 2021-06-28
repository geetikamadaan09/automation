package com.auto.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class AdidasSearch {
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
	public void adidasSearch() throws Exception {
		String expectedSearchHeading = "Casual & Sport Socks";
		
		objHome = new HomePageFactory(driver);
		objHome.clickLoginLink();
		objHome.searchItems(TestDataUtils.getSearchTerm());
		WebElement socksSearchHeading = driver.findElement(By.xpath("//span[text()='Casual & Sport Socks']"));
		String actual = socksSearchHeading.getText();
		// Ignoring Case sensitivity 
		Assert.assertEquals(actual.toLowerCase(), expectedSearchHeading.toLowerCase());		
	}
	
	/*@AfterClass(alwaysRun = true)
	public void exit() throws Exception {
		driver.quit();
	}
	*/
	
}
