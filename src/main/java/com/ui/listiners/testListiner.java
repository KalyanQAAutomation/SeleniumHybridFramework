package com.ui.listiners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ui.utilities.extentReporter;
import com.ui.utilities.utitlitydetails;

public class testListiner implements ITestListener {
	ExtentReports extentreport;
	 ExtentTest extntest;
	 public WebDriver driver;
	@Override
	public void onStart(ITestContext context) {
		 extentreport=extentReporter.generateExtentReport();
		 
		System.out.println("execution started successfully");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		//String testName=result.getName();
		 extntest = extentreport.createTest(result.getName());
		 extntest.log(Status.INFO, result.getName()+"execution Started");
		//System.out.println(testName+"execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//String testName=result.getName();
		 extntest = extentreport.createTest(result.getName());
		extntest.log(Status.PASS, result.getName()+"execution successfull");
		//System.out.println(testName+"execution successfull");	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		//String testName=result.getName();
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		//File screenshot=(TakesScreenshot)driver).getscreenshotAs(OutputType.FILE);
//		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//String storingpath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
//try {
//	FileHandler.copy(screenshot, new File(storingpath));
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
		String storingpath=utitlitydetails.takeScreenShot(driver, result.getName());
extntest = extentreport.createTest(result.getName());
extntest.addScreenCaptureFromPath(storingpath);
extntest.log(Status.INFO, result.getThrowable());
		 extntest.log(Status.FAIL, result.getName()+"test execution failed");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//String testName=result.getName();
		extntest = extentreport.createTest(result.getName());
		 extntest.log(Status.SKIP, result.getName()+"test execution skipped");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentreport.flush();
//		String pathofExtentReport=System.getProperty("user.dir"+"\\test-output\\extentreport\\extentreport.html");
//		File extentreporter=new File(pathofExtentReport);
//		try {
//			Desktop.getDesktop().browse(extentreporter.toURI());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("finished all tests");
	}
	

}
