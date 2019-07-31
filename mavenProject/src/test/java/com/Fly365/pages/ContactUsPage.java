package com.Fly365.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	WebDriver driver;

	@FindBy(how = How.CSS ,using ="input[placeholder='Full name']")
    public WebElement fullName;
	
	@FindBy(how = How.CSS ,using ="input[placeholder='example@email.com']")
    public WebElement email;
	
	@FindBy(how = How.CSS ,using ="input[placeholder='Select Category']")
    public WebElement category;
	
	@FindBy(how = How.CSS ,using ="textarea[placeholder='Write your message here …']")
    public WebElement message;
	
	@FindBy(xpath="//span[text()='Booking Enquiry']")
	public WebElement firstCat;
	
	@FindBy(xpath="//button[@type='submit' and text()='SEND']")
	public WebElement submitButton;

    @FindBy(css="h3.text-xl.pt-5")
    public WebElement thanksText;
    
    @FindBy(className="pt-3")
    public WebElement messageSentText;
	
	public ContactUsPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        

    }
}
