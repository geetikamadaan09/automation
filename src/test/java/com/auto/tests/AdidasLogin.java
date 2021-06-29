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

import com.auto.pagefactory.HomePageFactory;
import com.auto.pagefactory.LoginPageFactory;
import com.auto.utils.TestDataUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Geetika
 *
 */
public class AdidasLogin {
	private ThreadLocal<WebDriver> tsDriver = new ThreadLocal<WebDriver>() ;
	private WebDriver driver ;

	private String baseUrl;
	HomePageFactory objHome;
	LoginPageFactory objLogin;
	
	
	
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
		tsDriver.set(driver);
		tsDriver.get().get(baseUrl);

	}
	
		
	@Test
	public void adidasLogin() throws Exception {
		String expectedWelcomeText = "HI GEETIKA";	
		
		objHome = new HomePageFactory(tsDriver.get());
		objHome.clickLoginLink();
		objLogin = new LoginPageFactory(tsDriver.get());
		objLogin.setUserName(TestDataUtils.getUserName());
		objLogin.setPassword(TestDataUtils.getPassword());
		objLogin.clickLoginButton();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement salutation = tsDriver.get().findElement(By.xpath("//h3[text()='Hi Geetika']"));
		Assert.assertEquals(salutation.getText(), expectedWelcomeText);		
	}
	
	/*@AfterClass(alwaysRun = true)
	public void exit() throws Exception {
		driver.quit();
	}
	*/
}
