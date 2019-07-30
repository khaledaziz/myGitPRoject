package com.Fly365.testing;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Fly365.pages.HomePage;
import com.Fly365.base.TestBase;



public class RoundTripSearch extends TestBase{
	
	HomePage RoundTripSearch;
	
	@BeforeMethod
	public void setup() throws IOException
	{
	
		RoundTripSearch = new HomePage(driver);
		
	}
	
	
	@Test
	//public void roundSearch(String originCity, String destCity, String depDate, String arrDate) 
	public void roundSearch() throws InterruptedException{
		//RoundTripSearch.earchButton.click();
		RoundTripSearch.scatterLoc(RoundTripSearch.originField, "dubai");
		Thread.sleep(1000);
		RoundTripSearch.originField.sendKeys(Keys.ENTER);
		//RoundTripSearch.roundTripSearch("cai", "jeddah", "31 Jul", "31 Aug");
		RoundTripSearch.scatterLoc(RoundTripSearch.destinationField, "jeddah");
		Thread.sleep(1000);
		RoundTripSearch.destinationField.sendKeys(Keys.ENTER);
		RoundTripSearch.setDateRoundTrip(RoundTripSearch.departureDateField, RoundTripSearch.departureDateField, "12 Aug", "25 Aug");
		Thread.sleep(2000);
		
		RoundTripSearch.doSearch();
	}
	

}
