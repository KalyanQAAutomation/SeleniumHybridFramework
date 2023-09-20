package com.ui.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;


public class base {
	public WebDriver driver;
	public Properties property;
	public Properties testprop;
	public static final int TIMEOUT_SEC=10;
	public static final int PAGE_LOAD_TIMEOUT_SEC=10;
	
	public void loadpropertiesFile(){
		property=new Properties();
	    File profile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties");
		FileInputStream fis;
		testprop=new Properties();
		File testpath=new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\testData.properties");
		
		try {
			fis = new FileInputStream(profile);
			property.load(fis);
			FileInputStream testfil=new FileInputStream(testpath);
			testprop.load(testfil);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(property.getProperty("URL"));
	}
	
	public  WebDriver inlitizeBrowser(String browsername) throws IOException {
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\browser_driver\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\browser_driver\\msedgedriver.exe");
			 EdgeOptions edgeOptions = new EdgeOptions();
			 edgeOptions.addArguments("--remote-allow-origins=*");
			 driver = new EdgeDriver(edgeOptions);
		}else if (browsername.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.chrome.driver", "D:\\browser_driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.get(property.getProperty("URL"));
		System.out.println(property.getProperty("URL"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_SEC));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT_SEC));
		return driver;
		
	}
	
public Object[][] readTestdataFromExcel(String sheetName) {
	XSSFWorkbook workbook=null;
	
	File path=new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\testdata.xlsx");
	try {
		FileInputStream fi=new FileInputStream(path);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
      workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.getSheet(sheetName);
	
	
	int row=sheet.getLastRowNum();
	int collumn=sheet.getRow(0).getLastCellNum();
	Object[][] data=new Object[row][collumn];
	for(int i=0;i<row;i++) {
		XSSFRow rowNum=sheet.getRow(i+1);
		for(int j=0;j<collumn;j++) {
			XSSFCell cel=rowNum.getCell(j);
			CellType cellname=cel.getCellType();
			switch (cellname) {
			case STRING:
				data[i][j]=cel.getStringCellValue();
				break;
			case NUMERIC:
				data[i][j]=cel.getNumericCellValue();
				break;
				
			case BOOLEAN:
				data[i][j]=cel.getBooleanCellValue();
				
				break;
			}
			
		}
	}
	return data;

}
		}
	
