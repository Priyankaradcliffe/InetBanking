package com.inetBanking.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.ReadConfig;

import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();//ReadConfig Class

	public String baseURL= readconfig.getApplicationURL();
	
	public String username =readconfig.getUsername();
	
	public String password=readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br) {
		
		//  "./" can be used as Project home directory
		// so we can ./Drivers\\chromedriver.exe instead of whole path
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{	System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver = new ChromeDriver();	
		}	
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirepath());
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
		
	@AfterClass
	public void Teardown() {
		driver.quit();	
	}

	public void captureScreen(WebDriver driver, String testcasename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshots/" + testcasename + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String RandomString() {
		String GeneratedString = RandomStringUtils.randomAlphabetic(7);
		return GeneratedString;
	}
	
	public String RandomNum() {
		String GeneratedNum = RandomStringUtils.randomNumeric(7);		
		return GeneratedNum;
	}
}
