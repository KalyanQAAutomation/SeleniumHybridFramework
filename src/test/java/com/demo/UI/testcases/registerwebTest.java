package com.demo.UI.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.Registerpage;
import com.ui.pages.loginPage;
import com.ui.utilities.base;
import com.ui.utilities.utitlitydetails;

public class registerwebTest extends base {
	public WebDriver driver;
 Properties prop;
 loginPage loginpage;
 Registerpage register;
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	 
	 
	@BeforeMethod
	public  void setup() throws IOException {
		loadpropertiesFile();
		driver=inlitizeBrowser("chrome");
		loginpage=new loginPage(driver);
		 register=new Registerpage(driver);
		loginpage.clickonMyaccountLink();
		loginpage.clickLoginLink();
	}
	@Test
	public  void register() {
		register.registerwithmandatoryfields(utitlitydetails.randomName(),utitlitydetails.randomName(), utitlitydetails.generateCurrrentDateEmailAddress(), utitlitydetails.randomTelephoneNum(),testprop.getProperty("registerpassword"));
		Assert.assertEquals(register.retirveregistersuccessMsg(),"Your Account Has Been Created!");
		
	}
	@Test
	public void allWarningMessages() {
		register.clickonContinuebutton();
		register.clickonSumbitbutton();
		Assert.assertEquals(register.retirveFirstNameWarningMsg(),testprop.get("firstNameWarningMessage"));
		Assert.assertEquals(register.retirveLastNameWarningMsg(),testprop.get("lastNameWarningMessage"));
		Assert.assertEquals(register.retirveEmailWarningMsg(),testprop.get("emailwarningmessage"));
		Assert.assertEquals(register.retirvettelephoneWarningMsg(),testprop.get("telephonewarningmsg"));
		Assert.assertEquals(register.retirvePasswordWarningMsg(),testprop.get("passwordwarningmsg"));
		
	}

}
