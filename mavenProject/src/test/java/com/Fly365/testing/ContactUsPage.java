package com.Fly365.testing;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import com.Fly365.pages.HomePage;
import com.Fly365.pages.ContactUsPage;
import com.Fly365.base.TestBase;

public class ContactUsPage extends TestBase{
	
	HomePage ContactUs;
	ContactUsPage ContactPage;
	
	@BeforeMethod
	public void setup() throws IOException
	{
	
		ContactPage = new ContactUsPage(driver);
		
	}
}
