package com.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumPiTest {

  public static WebDriver driver;

 @Test
  public void test1() {
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
    capabilities.setCapability("marionette", false);
    capabilities.setPlatform(Platform.LINUX);
    capabilities.setBrowserName("firefox");
    try {
      driver = new FirefoxDriver(capabilities);
      driver.get("https://www.fb.com");
      driver.findElement(By.name("email")).sendKeys("test");
	  driver.findElement(By.name("pass")).sendKeys("test");
	  System.out.println("testing success");
	  driver.findElement(By.xpath("//*[@data-testid='royal_login_button']")).click();
      Thread.sleep(5000);
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
    	 System.out.println("quitting..");
      driver.quit();
    }
  }
}