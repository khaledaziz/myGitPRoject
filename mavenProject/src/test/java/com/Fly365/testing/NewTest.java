package com.Fly365.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest {
	
	public WebDriver driver;
	
  @Test
  public void openMyBlog() {
	driver.get("https://www.softwaretestingmaterial.com/");
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//drivers//chromedriver (2).exe");
		//create chrome instance
		driver = new ChromeDriver();
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}