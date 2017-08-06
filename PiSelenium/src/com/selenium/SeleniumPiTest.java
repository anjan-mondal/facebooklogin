package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumPiTest {

  public static RemoteWebDriver driver;

  public static void main(String[] args) {
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
	  driver.findElement(By.xpath("//*[@data-testid='royal_login_button']")).click();
      Thread.sleep(5000);
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      driver.quit();
    }
  }
}