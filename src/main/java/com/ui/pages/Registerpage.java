package com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	public WebDriver driver;
	
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//h1[text()='Register Account']")
	private WebElement registerTitle;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephonefield;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passowrd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmpassowrd;
	
	@FindBy(xpath="//input[@name='newsletter'  and @value='1']")
	private WebElement newsletetricon;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreeicon;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitbutton;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement successregistermsg;
	
	@FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstNameWarningmsg;
	
	@FindBy(xpath="//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement lastNameWarningmsg;
	
	@FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement emailWarningmsg;
	
	@FindBy(xpath="//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneWarningmsg;
	
	@FindBy(xpath="//div[text()='Password must be between 4 and 20 characters!']")
	 private WebElement passowrdWarningMsg;
	
	public Registerpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void verifyRegisterPageTitle() {
		registerTitle.isDisplayed();
	}
	public void clickonContinuebutton() {
		continueButton.click();
	}
	
	public void EnterFirstname(String firstname) {
		firstName.sendKeys(firstname);
	}
	
	public void EnterLasttname(String lastname) {
		lastName.sendKeys(lastname);
	}
	
	public void Enteremailaddress(String email) {
		emailAddress.sendKeys(email);
	}
	
	public void Entertelephonenum(String telephonenum) {
		telephonefield.sendKeys(telephonenum);
	}
	
	public void EnterPassword(String password) {
		passowrd.sendKeys(password);
	}
	
	public void EnterConfirmPassword(String confirmpassword) {
		confirmpassowrd.sendKeys(confirmpassword);
	}
	
	public void clickonNewsletter() {
		newsletetricon.click();
	}
	
	public void clickonAgreepolicy() {
		agreeicon.click();
	}
	
	public void clickonSumbitbutton() {
		submitbutton.click();
	}
	public String retirveregistersuccessMsg() {
		String msg=successregistermsg.getText();
		return msg;
	}
	
	public String retirveFirstNameWarningMsg() {
		String firstNamewarnmsg=firstNameWarningmsg.getText();
		return firstNamewarnmsg;
	}
	
	
	public String retirveLastNameWarningMsg() {
		String lastNamewarnmsg=lastNameWarningmsg.getText();
		return lastNamewarnmsg;
	}
	
	public String retirveEmailWarningMsg() {
		String emailwarnmsg=emailWarningmsg.getText();
		return emailwarnmsg;
	}
	
	public String retirvettelephoneWarningMsg() {
		String telwarnmsg=telephoneWarningmsg.getText();
		return telwarnmsg;
	}
	
	public String retirvePasswordWarningMsg() {
		String passwordwarnmsg=passowrdWarningMsg.getText();
		return passwordwarnmsg;
	}
	
	public void registerwithmandatoryfields(String firstname,String lastname,String email,String telephone,String password) {
		continueButton.click();
		firstName.sendKeys(firstname);
		lastName.sendKeys(firstname);
		emailAddress.sendKeys(email);
		telephonefield.sendKeys(telephone);
		passowrd.sendKeys(password);
		confirmpassowrd.sendKeys(password);
		newsletetricon.click();
		agreeicon.click();
		submitbutton.click();
	}
}
