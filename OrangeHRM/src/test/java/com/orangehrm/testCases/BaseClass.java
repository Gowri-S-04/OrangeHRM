package com.orangehrm.testCases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.orangehrm.utilities.ReadConfiguration;

public class BaseClass {

	public WebDriver d;
	public Logger log;
	ReadConfiguration rc=new ReadConfiguration();
	
	@Parameters("Browser")
	@BeforeTest()
	public void openBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			d=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			d=new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", rc.getEdgePath());
			d=new EdgeDriver();
		}
		log=Logger.getLogger("OrangeHRM Project");
		PropertyConfigurator.configure("./log4j.properties");
		d.get(rc.getApplicationURL());
		log.info("Browsed Opened");
		d.manage().window().maximize();
	}
	@AfterTest()
	public void closeBrowser()
	{
		d.close();
	}
	public void captureScreenshot(String filename) throws IOException
	{
		TakesScreenshot t=(TakesScreenshot)d;
		File src=t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./Screenshots\\"+filename+".png"));
	}
}
