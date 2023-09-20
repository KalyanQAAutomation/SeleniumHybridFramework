package com.ui.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class extentReporter {
	
public static ExtentReports generateExtentReport() {
	ExtentReports extntreport=new ExtentReports();
	
	
	File reportpath=new File(System.getProperty("user.dir")+"\\test-output\\extentreport\\extentreport.html");
	ExtentSparkReporter sparkreporter=new ExtentSparkReporter(reportpath);
	sparkreporter.config().setTheme(Theme.DARK);
	sparkreporter.config().setReportName("Selenum_HybridFramework_Report");
	sparkreporter.config().setDocumentTitle("SeleniumAutomation");
	sparkreporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
	extntreport.attachReporter(sparkreporter);
	Properties prop=new Properties();
	File filepath=new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties");
	FileInputStream input;
	try {
		input = new FileInputStream(filepath);
		prop.load(input);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	extntreport.setSystemInfo("ApplicationURL", prop.getProperty("URL"));
	extntreport.setSystemInfo("BrowserName", prop.getProperty("browser"));
	extntreport.setSystemInfo("Operating System", System.getProperty("os.version"));
	extntreport.setSystemInfo("UserName", System.getProperty("user.name"));
	extntreport.setSystemInfo("java version", System.getProperty("java.version"));
	return extntreport;
}
}
