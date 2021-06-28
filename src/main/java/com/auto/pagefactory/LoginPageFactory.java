package com.auto.pagefactory;
	
	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.WebElement;

	import org.openqa.selenium.support.FindBy;

	import org.openqa.selenium.support.PageFactory;

/**
 * 	Reading objects of Login page
 * @author Geetika
 *
 */
	public class LoginPageFactory {

		WebDriver driver;

		@FindBy(id = "login-email")
		WebElement loginEmail;

		@FindBy(id = "login-password")
		WebElement loginPassword;

		@FindBy(xpath ="//span[text()='Log in']")
		WebElement loginButton;

		public LoginPageFactory(WebDriver driver){

		        PageFactory.initElements(driver, this);

		    }

		// Set user name in textbox

		public void setUserName(String strUserName) {

			loginEmail.sendKeys(strUserName);
		}

		// Set password in password textbox

		public void setPassword(String strPassword) {

			loginPassword.sendKeys(strPassword);

		}

		// Click on login button

		public void clickLoginButton() {

			loginButton.click();

		}


		public void login(String strUserName, String strPasword) {

			this.setUserName(strUserName);

			this.setPassword(strPasword);

			this.clickLoginButton();

		}
}
