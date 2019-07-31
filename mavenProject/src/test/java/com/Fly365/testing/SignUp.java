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

public class SignUp extends TestBase{
	
	HomePage SignUp;
	SignUpPage SignUpTest;
	
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
		
		String firstName= "First Name";
		String familyName= "Family Name";
		String email= "customer16@fly365.com";
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
		Assert.assertEquals(actualHiText,expectedHiText);
		
	}
}
