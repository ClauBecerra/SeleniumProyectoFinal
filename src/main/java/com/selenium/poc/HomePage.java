package com.selenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.base.Base;

public class HomePage extends Base{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Objects
	By lnkAdmin = By.xpath("//span[text()='Admin']");
	
	/*
	 * Navigate to Admin page
	 * @author Claudia
	 * @date
	 */
	public void navigateToAdminPage() {
		click(lnkAdmin);
	}

}
