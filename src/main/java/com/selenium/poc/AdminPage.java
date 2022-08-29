package com.selenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.selenium.base.Base;

public class AdminPage extends Base{
	
	public AdminPage(WebDriver driver) {
		super(driver);
	}

	// Objects
	By btnAdd = By.xpath("//button[text()=' Add ']");
	By ddnUserRole = By.xpath("//label[text()='User Role']//parent::div//following-sibling::div");
	By txtUserRole = By.xpath("//div[@class='oxd-select-option'][2]");
	By txtEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
	By txtEmployeeNameResult = By.xpath("//div[@class='oxd-autocomplete-option']");
	By ddnStatus = By.xpath("//label[text()='Status']//parent::div//following-sibling::div");
	By txtStatus = By.xpath("//div[@class='oxd-select-option'][2]");
	By txtUsername = By.xpath("//label[text()='Username']//parent::div//following-sibling::div//input");
	By txtPassword = By.xpath("(//input[@type='password'])[1]");
	By txtConfirmPassword = By.xpath("(//input[@type='password'])[2]");
	By btnSave = By.xpath("//button[@type='submit']");
	By txtUsernameSearch = By.xpath("//label[text()='Username']//parent::div//following-sibling::div//input");
	By btnSearch = By.xpath("//button[@type='submit']");
	By chkUsername = By.xpath("(//span[contains(@class, 'oxd-checkbox-input')])[2]"); 
	By btnDelete = By.xpath("//button[text()=' Delete Selected ']");
	By btnYesDelete = By.xpath("//button[text()=' Yes, Delete ']");
	
	/*
	 * Add admin user
	 * @author Claudia Becerra
	 */
	public void addAdminUser(String employeeName, String username, String password) throws InterruptedException {
		click(btnAdd);
		click(ddnUserRole);
		click(txtUserRole);
		type(txtEmployeeName, employeeName);
		Thread.sleep(5000);
		click(txtEmployeeNameResult);
		click(ddnStatus);
		click(txtStatus);
		type(txtUsername, username);
		type(txtPassword, password);
		type(txtConfirmPassword, password);
		Thread.sleep(5000);
		click(btnSave);
		Thread.sleep(20000);
	}
	
	/*
	 * Search admin user
	 * @author Claudia Becerra
	 */
	public void searchForUser(String username) {
		verifyVisibilityElement(txtUsernameSearch);
		type(txtUsernameSearch, username);
		click(btnSearch);
	}
	
	/*
	 * Delete admin user
	 * @author Claudia Becerra
	 */
	public void deleteAdminUser(String username) {
		click(chkUsername);
		click(btnDelete);
		click(btnYesDelete);
	}
}
