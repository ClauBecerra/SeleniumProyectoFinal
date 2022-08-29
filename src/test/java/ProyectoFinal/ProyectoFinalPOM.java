package ProyectoFinal;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.base.Base;
import com.selenium.base.GlobalVariables;
import com.selenium.poc.AdminPage;
import com.selenium.poc.HomePage;
import com.selenium.poc.LoginPage;

public class ProyectoFinalPOM {
	WebDriver driver;
	Base base;
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	String username;
	String password;
	String employeeName;
	String adminUsername;
	String adminPassword;
	ExtentReports extent;
	ExtentTest logger;
	private String className = this.getClass().getSimpleName();

	@BeforeTest
	public void beforeTest() {
		base = new Base(driver);
		driver = base.chromeDriverCon();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminPage = new AdminPage(driver);
		username = base.getJSONValue("Login", "username");
		password = base.getJSONValue("Login", "password");
		employeeName = base.getJSONValue("AddUser", "employeename");
		adminUsername = base.getJSONValue("AddUser", "username");
		adminPassword = base.getJSONValue("AddUser", "password");

		// Set up Extend reports
		extent = new ExtentReports(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.REPORT_PATH, true);
		extent.addSystemInfo(GlobalVariables.EXTENT_QA_URL, GlobalVariables.QA_URL);
		extent.loadConfig(new File(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.CONFIG_EXTENT));
	}
		
	@Test
	private void addAndDeleteUser() {
		// Extent report start test
		logger = extent.startTest(className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// Step 1 - Launch browser
		base.launchBrowser(GlobalVariables.QA_URL);

		// Step 2 - Enter Username and Password
		// Step 3 - Click login
		loginPage.login(username, password);

		// Step 4 - Validate user is logged successfully
		Assert.assertTrue(driver.getCurrentUrl().contains("viewEmployeeList"));
		
		// Log Extent Report
		logger.log(LogStatus.PASS, "Validation " + className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName() + " was successful");
		
		// Step 5 - Click Admin module
		homePage.navigateToAdminPage();
		
		// Step 6 - Validate user is able to see Admin page 
		Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
		
		// Log Extent Report
		logger.log(LogStatus.PASS, "Validation " + className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName() + " was successful");
		
		// Step 7 - Click Add button
		// Step 8 - Fill out the form to create the user
		// Step 9 - Click on Save button.
		try {
			adminPage.addAdminUser(employeeName, adminUsername, adminPassword);
		} catch (InterruptedException e) {
			e.getMessage();
		}
		
		// Step 10 - Insert user recently created into Username textbox
		// Step 11 = Click search
		adminPage.searchForUser(adminUsername);
		
		// Step 12 - Validate user exist in the table result after click search
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='" + adminUsername + "']")).isDisplayed());
		
		// Log Extent Report
		logger.log(LogStatus.PASS, "Validation " + className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName() + " was successful");

		// Log Extent Report
		logger.log(LogStatus.PASS, "Validation " + className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName() + " was successful");
				
		// Step 13 - Select user in the table result and click Delete
		// Step 14 - Click on OK button in modal window (Delete records?)
		adminPage.deleteAdminUser(adminUsername);
		
		// Step 15 - Validate user was deleted successfully 
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='No Records Found']")).isDisplayed());
		
		// Log Extent Report
		logger.log(LogStatus.PASS, "Validation " + className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName() + " was successful");
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, logger.addScreenCapture(base.takeScreenshot("fail")));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);

	}

	@AfterTest
	public void afterTest() {
		// Close Extend report
		extent.flush();
		extent.close();
		base.closeBrowser();
	}


}
