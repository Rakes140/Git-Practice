package com.qsp.trello.genericutility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fileUtils=new FileUtility();
	public ExcelUtility excelUtils=new ExcelUtility();
	public WebDriverUtility webDriverUtils=new WebDriverUtility();
	public Select select;
	
	@BeforeTest
	public void lunchBrowser() throws Throwable
	{
		switch (fileUtils.readKeyValue("browser")) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		default:
			System.err.println("invalid browser");
			break;
		}
		driver.manage().window().maximize();
		webDriverUtils.implicityWait(driver);
	}
	@AfterTest 
	public void closeBrowser()
	{
		driver.manage().window().minimize();
		driver.quit();
	}

}
