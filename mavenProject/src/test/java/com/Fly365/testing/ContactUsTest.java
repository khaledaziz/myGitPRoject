package com.Fly365.testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Fly365.pages.ContactUsPage;
import com.Fly365.pages.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.Fly365.base.TestBase;

public class ContactUsTest extends TestBase{
	
	HomePage ContactUs;
	ContactUsPage ContactPage;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		
		driver.get("https://www.fly365.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		ContactUs = new HomePage(driver);
		ContactPage = new ContactUsPage(driver);
		
		
		
	}
	
	@Test
	public void sendMessage() throws InterruptedException {
		
		

		ContactUs.contactButton.click();
		ContactPage.fullName.sendKeys("New Customer");
		ContactPage.email.sendKeys("customer@fly365.com");
		ContactPage.category.click();
		Thread.sleep(1500);
		ContactPage.firstCat.click();
		Thread.sleep(1500);
		ContactPage.message.sendKeys("Send message to fly365");
		ContactPage.submitButton.click();
		String expectedThanksText="Thank you for contacting us";
		String actualThanksText=ContactPage.thanksText.getText();
		Assert.assertEquals(expectedThanksText,actualThanksText);
		String expectedSentText="Your message has been sent successfully";
		String actualSentText=ContactPage.messageSentText.getText();
		Assert.assertEquals(expectedSentText,actualSentText);
		

	}
}
