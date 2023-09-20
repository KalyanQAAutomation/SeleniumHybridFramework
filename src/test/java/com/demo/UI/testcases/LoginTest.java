package com.demo.UI.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;
import com.ui.pages.loginPage;
import com.ui.pages.myAccountPage;
import com.ui.utilities.base;
import com.ui.utilities.utitlitydetails;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends base {
	// private static final String PROXY = null;
	public WebDriver driver;
	 loginPage loginpage;
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	 
	 @DataProvider
	 public Object[][] supplytestdata(){
		 Object[][] data= {{"abd@email.com","Abd@1245"},{"abd@email.com","Abd@45"},{"abd@email.com","Abd345"}};
//		 Object[][] data=readTestdataFromExcel("Login");
		return data;
		 
	 }
	 
	 @DataProvider
	 public Object[][] supplyValidtestdata(){
		 Object[][] data= {{"abd@email.com","Abd@12345"}};

		return data;
		 
	 }
	@BeforeMethod
	public  void setup() throws IOException {
		loadpropertiesFile();
		driver=inlitizeBrowser("chrome");
	
		loginpage=new loginPage(driver);
		loginpage.clickonMyaccountLink();
		loginpage.clickLoginLink();
		
	}
	@Test (dataProvider = "supplyValidtestdata")
	public void loginwithvalid(String email, String password) {
		 myAccountPage myaccountpage=new myAccountPage(driver);
		loginpage.enterUserName(email);
		loginpage.enterPassword(password);
		loginpage.clickloginbutton();
		Assert.assertTrue(myaccountpage.accountloginoptionsdisplayingornot(), "titleis displaying successfully");
		
	}
	
	@Test 
	public void loginWithInvalidCredentials() {
		
		loginpage.enterUserName(testprop.getProperty("invalidUserName"));
		loginpage.enterPassword(testprop.getProperty("invalidpassword"));
		loginpage.clickloginbutton();
		Assert.assertEquals(loginpage.retriveWarningMessage(),testprop.getProperty("WarningMessage"));
		
		
	}
	@Test
	public void loginWithInvalidEmailAndvalidPassword() {
		loginpage.enterUserName(testprop.getProperty("invalidUserName"));
		loginpage.enterPassword(testprop.getProperty("validPassword"));
		loginpage.clickloginbutton();
		Assert.assertEquals(loginpage.retriveWarningMessage(),testprop.getProperty("WarningMessage"));
	}
	@Test (dataProvider="supplytestdata")
	public void loginWithValidEmailAndInvalidPassword(String email, String password) {
		 myAccountPage myaccountpage=new myAccountPage(driver);
		loginpage.enterUserName(email);
		loginpage.enterPassword(password);
		loginpage.clickloginbutton();
		Assert.assertEquals(loginpage.retriveWarningMessage(),testprop.getProperty("WarningMessage"));
	}
	@Test
	public void forgetPassowrdforUnmappedEmail() {
		 loginpage.clickonforgotPassword();
		 Assert.assertEquals(loginpage.forgotPassowrdTitleMsg(),testprop.getProperty("expectedTitle"));
		 loginpage.enterUserName("asc@email.com");
		 loginpage.clickloginbutton();
		Assert.assertEquals(testprop.getProperty("expectedErrorMsg"), loginpage.retriveWarningMessage());
	}
	
	@Test
	public void failedtestscenario() {
		 loginpage.clickonforgotPassword();
		 Assert.assertEquals(loginpage.forgotPassowrdTitleMsg(),testprop.getProperty("expectedTitle"));
		 loginpage.enterUserName("asc@email.com");
		 loginpage.clickloginbutton();
		Assert.assertEquals(testprop.getProperty("emailwarningmessage"), loginpage.retriveWarningMessage());
	}
}
