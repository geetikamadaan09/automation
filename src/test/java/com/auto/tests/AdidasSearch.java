package com.auto.tests;

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
public class AdidasSearch {
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
	public void adidasSearch() throws Exception {
		String expectedSearchHeading = "Casual & Sport Socks";
	
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(TestDataUtils.getSearchTerm());
		searchText.submit();
		WebElement socksSearchHeading = driver.findElement(By.xpath("//span[text()='Casual & Sport Socks']"));
		String actual = socksSearchHeading.getText();
		// Ignoring Case sensitivity 
		Assert.assertEquals(actual.toLowerCase(), expectedSearchHeading.toLowerCase());		
	}
	
}
