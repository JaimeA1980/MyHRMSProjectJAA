package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.LoginPage;
import com.hrms.testbase.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class LoginPageTest extends CommonMethods{
	// Test case to validate valid login
	@Test
	public void login() {
		LoginPage login = new LoginPage();
		sendText(login.username, "Admin");
		sendText(login.password, "Hum@nhrm123");
		click(login.loginBtn);
	}
	
	
	@Test
	public void logo() {
	LoginPage login = new LoginPage();
	boolean isDisplayed = login.logo.isDisplayed();
	Assert.assertTrue(isDisplayed, "Logo not present");
	
	
	
	}
	
	/*
	 * Navigate to HRMS
	 * Enter uid
	 * leave password field blank
	 * click login
	 * verify "Password cannot be empty" text
	 * close browser
	 */
	@Test //using @FindBy
	public void negativeLogin() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, "Admin");
		click(login.loginBtn);
		String expectedError =  "Password cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(),  expectedError, "Error message text is not present");
		
	}
}
