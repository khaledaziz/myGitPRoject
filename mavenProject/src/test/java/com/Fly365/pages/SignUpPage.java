package com.Fly365.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	WebDriver driver;

	@FindBy(how = How.CSS ,using ="input[placeholder='First Name']")
    public WebElement firstName;
	
	@FindBy(how = How.CSS ,using ="input[placeholder='Family Name']")
    public WebElement familyName;
	
	@FindBy(how = How.CSS ,using ="input[type='email']")
    public WebElement email;
	
	@FindBy(how = How.CSS ,using ="input[type='password']")
    public WebElement password;
	
	@FindBy(xpath="//span[text()='Verify your account by your mail']")
	public WebElement verifyAccount;
	
	@FindBy(xpath="//button[@type='submit' and text()='CREATE ACCOUNT']")
	public WebElement createAccount;

    @FindBy(css="div.text-center.text-white")
    public WebElement hiText;
    
    @FindBy(className="pt-3")
    public WebElement messageSentText;
	
	public SignUpPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        

    }
}
