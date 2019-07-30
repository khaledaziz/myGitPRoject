package com.Fly365.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	WebDriver driver;

	@FindBy(how = How.CSS ,using ="input[placeholder='Full name']")
    public WebElement contactButton;
	
    @FindBy(name="origin")
	public WebElement originField;

    @FindBy(name="destination")
    public WebElement destinationField;  
	
	public ContactUsPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        contactButton.sendKeys("gggg");

    }
}
