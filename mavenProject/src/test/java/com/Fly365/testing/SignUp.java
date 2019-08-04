package com.Fly365.testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Fly365.base.TestBase;
import com.Fly365.pages.ContactUsPage;
import com.Fly365.pages.HomePage;
import com.Fly365.pages.SignUpPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SignUp extends TestBase{
	
	HomePage SignUp;
	SignUpPage SignUpTest;
	static ExtentTest test;	
	static ExtentReports report;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		
		driver.get("https://www.fly365.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		SignUp = new HomePage(driver);
		SignUpTest = new SignUpPage(driver);
		
		
		
	}
	
	@Test
	public void sendMessage() throws InterruptedException {
		
		// start reporters
	    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Sign up Test Suite Report.html" );
	      
	    // create ExtentReports and attach reporter(s)
	    ExtentReports extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	      
	    // creates a toggle for the given test, adds all log events under it    
	    test = extent.createTest("Sign up Test", "This test case to validate that user can regiter");
	    
		String firstName= "First Name";
		String familyName= "Family Name";
		String email= "customer19@fly365.com";
		String password= "12345qwert";
		
		SignUp.signUpButton.click();
		SignUpTest.firstName.sendKeys(firstName);
		SignUpTest.familyName.sendKeys(familyName);
		SignUpTest.email.sendKeys(email);
		SignUpTest.password.sendKeys(password);
		Thread.sleep(1500);
		SignUpTest.createAccount.click();
		Thread.sleep(1500);
		SignUpTest.verifyAccount.click();
		
		String expectedHiText="Hi, " + firstName + " " +familyName;		
		String actualHiText=SignUpTest.hiText.getText();
		try {
			Assert.assertEquals(actualHiText,expectedHiText);
			test.pass("User Signed up successfully");
			extent.flush();
		}catch(Exception e) {
			test.fail("User failed to signup");
		}
		
	}
}
