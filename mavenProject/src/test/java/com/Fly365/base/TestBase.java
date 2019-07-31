package com.Fly365.base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	public static WebDriver driver;
	
	@BeforeTest
	public static void intialization ()
	{
		
	
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//drivers//chromedriver (2).exe");
			
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("headless");
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//driver.get("https://www.fly365.com/");
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
	}
}
