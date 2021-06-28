package com.auto.pagefactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


/**
 * Reading objects of home page
 * @author Geetika
 *
 */
public class HomePageFactory {

	WebDriver driver;

	@FindBy(xpath ="//a[text()='Log in']")
	WebElement login;

	
	@FindBy(name ="q")
	WebElement searchTextBox;

	
	public HomePageFactory(WebDriver driver){

	        PageFactory.initElements(driver, this);

	    }


	// Click on login link

	public void clickLoginLink() {

		login.click();

	}
	
	// Search items

	public void searchItems(String itemKeyword) {

		searchTextBox.sendKeys(itemKeyword);
		searchTextBox.submit();	

	}

}
