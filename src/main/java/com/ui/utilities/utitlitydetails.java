package com.ui.utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public  class utitlitydetails {
	
	public static Properties props;
	
	public static String generateCurrrentDateEmailAddress() {
		Date date=new Date();
		String emailaddress=date.toString().replace(" ", "_").replace(":", "_").concat("@gmail.com");
	System.out.println(emailaddress);
		return emailaddress;
		
	}
	public static String randomTelephoneNum() {
		Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);

        System.out.println(phoneNumber);
		return phoneNumber;
	}
	public static String randomName() {
		//RandomStringUtils.randomAlphanumeric(20).toUpperCase();
//		String randomString = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
//		System.out.println(randomString);
//		return randomString;
//
		String characters = "kj";
		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < 10; i++) {
		    int index = new Random().nextInt(characters.length());
		    sb.append(characters.charAt(index));
		}
		String randomString = sb.toString();
		System.out.println(randomString);
		return randomString;
	}

	public static String takeScreenShot(WebDriver driver, String testName) {
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationPath=System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		try {
			FileHandler.copy(screenshot, new File(destinationPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationPath;
		
	}
}
