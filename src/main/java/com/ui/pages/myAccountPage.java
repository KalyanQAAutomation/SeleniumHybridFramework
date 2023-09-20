package com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccountPage {
	public WebDriver driver;
	
	public myAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement accountpagemessage;

	public boolean accountloginoptionsdisplayingornot() {
		boolean displaystatus=accountpagemessage.isDisplayed();
		return displaystatus;
	}
}
