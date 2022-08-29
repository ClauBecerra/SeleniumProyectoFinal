package ProyectoFinal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProyectoFinalLineal {
  @Test
  public void addAndDeleteUser() throws InterruptedException {
	  
	  ChromeOptions chromeOpt = new ChromeOptions();
	  WebDriverManager.chromedriver().setup();	  
	  WebDriver driver = new ChromeDriver(chromeOpt);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 15);
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//span[text()='Admin']")).click();
	  
	  String url = driver.getCurrentUrl();
	  Assert.assertTrue(url.contains("admin"));
	  
	  driver.findElement(By.xpath("//button[text()=' Add ']")).click();
	  
	  driver.findElement(By.xpath("//label[text()='User Role']//parent::div//following-sibling::div")).click();
	  
	  driver.findElement(By.xpath("//div[@class='oxd-select-option'][2]")).click();
	  
	  driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Aaliyah");
	  
	  Thread.sleep(5000);
	
	  driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option']")).click();
	
	  driver.findElement(By.xpath("//label[text()='Status']//parent::div//following-sibling::div")).click();
	  
	  driver.findElement(By.xpath("//div[@class='oxd-select-option'][2]")).click();
	  
	  driver.findElement(By.xpath("//label[text()='Username']//parent::div//following-sibling::div//input")).sendKeys("admintest6");
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Admin123!");
	  
	  driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Admin123!");
	  
	  Thread.sleep(5000);
	  
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  Thread.sleep(25000);
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Username']//parent::div//following-sibling::div//input")));
	  driver.findElement(By.xpath("//label[text()='Username']//parent::div//following-sibling::div//input")).sendKeys("admintest6");
	  
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//div[text()='admintest6']")).isDisplayed());
	  
	  driver.findElement(By.xpath("(//span[contains(@class, 'oxd-checkbox-input')])[2]")).click();
	  
	  driver.findElement(By.xpath("//button[text()=' Delete Selected ']")).click();
			  
	  driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();	  
			  
	  Assert.assertTrue(driver.findElement(By.xpath("//span[text()='No Records Found']")).isDisplayed());
	  
	  driver.quit();
	  
  }
}
