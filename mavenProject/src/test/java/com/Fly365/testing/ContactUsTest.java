package com.Fly365.testing;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Fly365.pages.ContactUsPage;
import com.Fly365.pages.HomePage;

import com.Fly365.base.TestBase;

public class ContactUsTest extends TestBase{
	
	HomePage ContactUs;
	ContactUsPage ContactPage;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		ContactUs = new HomePage(driver);
		ContactPage = new ContactUsPage(driver);
		
		ContactUs.contactButton.click();
		ContactPage.contactButton.sendKeys("gggg");
		
	}
	
	@Test
	public void dsds() {
		
	}
}
