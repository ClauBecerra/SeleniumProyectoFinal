package com.selenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.base.Base;

public class LoginPage extends Base{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// Objects
	By txtUsername = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin = By.xpath("//button[@type='submit']");

	/*
	 * Login
	 * @author Claudia
	 * @date
	 */
	public void login(String username, String password) {
		type(txtUsername, username);
		type(txtPassword, password);
		click(btnLogin);
		implicitWait(5);
	}
	
}
