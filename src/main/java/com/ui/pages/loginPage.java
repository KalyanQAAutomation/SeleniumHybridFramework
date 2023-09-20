package com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	public WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginLink;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement UserName;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement Passowrd;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	
	@FindBy(linkText="Forgotten Password")
	private WebElement forgotpassowrdlinnk;
	
	@FindBy(xpath="//h1[text()='Forgot Your Password?']")
	private WebElement forgetPassowrdTitle;
	
	
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickLoginLink() {
		loginLink.click();
	}
	public void clickonMyaccountLink() {
		myAccountLink.click();
	}
	
public void enterUserName(String email) {
	UserName.sendKeys(email);
	
}
public void enterPassword(String password) {
	Passowrd.sendKeys(password);
}
public void clickloginbutton() {
	loginbutton.click();
	
}
public String retriveWarningMessage() {
     String warnigntext=warningMessage.getText();
     return warnigntext;
}
public void clickonforgotPassword() {
	forgotpassowrdlinnk.click();
}
public String forgotPassowrdTitleMsg() {
    String forgotPasswordTitle=forgetPassowrdTitle.getText();
    return forgotPasswordTitle;
}

}
