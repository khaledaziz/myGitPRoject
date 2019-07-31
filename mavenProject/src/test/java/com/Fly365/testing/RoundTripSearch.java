package com.Fly365.testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Fly365.pages.HomePage;
import com.Fly365.data.ExcelRead;
import com.Fly365.base.TestBase;



public class RoundTripSearch extends TestBase{
	
	HomePage RoundTripSearch;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		driver.get("https://www.fly365.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		RoundTripSearch = new HomePage(driver);
		
	}
	
	@DataProvider (name = "roundTripData" )
	public Object[][] dp_oneInput() throws IOException {
	String path = System.getProperty("user.dir") + "//Data//RoundTripData.xlsx";		
		String inSheet = "input";
		ExcelRead testData = new ExcelRead();
		Object data[][] = testData.retrieveMyData(path, inSheet); 
		return data;
	}
	
	@Test(dataProvider = "roundTripData")
	public void roundSearch(String originCity, String destCity, String depDate, String arrDate) throws InterruptedException {
	
		RoundTripSearch.scatterLoc(RoundTripSearch.originField, originCity);
		Thread.sleep(1000);
		RoundTripSearch.originField.sendKeys(Keys.ENTER);		
		RoundTripSearch.scatterLoc(RoundTripSearch.destinationField, destCity);
		Thread.sleep(1000);
		RoundTripSearch.destinationField.sendKeys(Keys.ENTER);
		RoundTripSearch.setDateRoundTrip(RoundTripSearch.departureDateField, RoundTripSearch.departureDateField, depDate, arrDate);
		Thread.sleep(1000);		
		RoundTripSearch.doSearch();
		String expectedPageTitle = "Fly365 - search-results";
		
		WebDriverWait wait = new WebDriverWait(driver, 30,250);
		
		wait.until(ExpectedConditions.visibilityOf(RoundTripSearch.resultHeader));
			
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		
                  
				
	}
}

