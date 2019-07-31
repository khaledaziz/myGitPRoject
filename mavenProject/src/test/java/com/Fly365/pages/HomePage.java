package com.Fly365.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

    @FindBy(name="origin")
	public WebElement originField;

    @FindBy(name="destination")
    public WebElement destinationField;  
    
    @FindBy(name="d")
    public WebElement departureDateField;
    
    @FindBy(name="a")
    public WebElement arrivalDateField; 
    
    @FindBy(css="button.btn.uppercase")
    public WebElement searchButton;
    
    @FindBy(how = How.CSS ,using ="a[href='/en/contact-us']")
    public WebElement contactButton;
    
    @FindBy(how = How.CSS ,using ="a[href='/en/register']")
    public WebElement signUpButton;
    
    @FindBy(xpath="//span[text()='FLY365 MIX AND MATCH FLIGHT OPTIONS']")
    public WebElement resultHeader;
    
   
    public HomePage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    public  void enterCity(WebElement depDestTripNum , String city) {
		 
    	depDestTripNum.sendKeys(city);
	 }	
    
    public void doSearch(){

        searchButton.click();
    }
    
    public void scatterLoc(WebElement cityElement , String wantedLoc) throws InterruptedException{
    	String letter = null;
 
    	for(int id=0 ; id<wantedLoc.length(); id++) { 
    		letter = Character.toString(wantedLoc.charAt(id));
    		Thread.sleep(250);
    		enterCity(cityElement , letter);
    		Thread.sleep(250);
    	}
    	
    }
    
    public void setDateRoundTrip(WebElement depElement , WebElement arrElement , String depDate , String arrDate) {
    	
    	departureDateField.sendKeys(depDate); 
        arrivalDateField.sendKeys(arrDate);
        departureDateField.sendKeys(Keys.ENTER);
    	
    }

}
