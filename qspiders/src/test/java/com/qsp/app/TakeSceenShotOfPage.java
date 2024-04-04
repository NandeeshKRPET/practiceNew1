package com.qsp.app;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeSceenShotOfPage {
  
	WebDriver driver = null;
	
	@BeforeMethod
	public void bm()
	{
		driver = new ChromeDriver();
	}
	
@Test
  public void takeScreenShot() throws IOException 
  {
	
	driver.manage().window().maximize();
	driver.get("https://www.amazon.com/");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File src = ts.getScreenshotAs(OutputType.FILE);
	 String df = LocalDateTime.now().toString();
	 String newDate = df.replace(":", "-");
	 File dest = new File("./Screenshots/amazon-"+newDate+".png");
	 FileHandler.copy(src, dest);
	 
	 
	 
  }
	@AfterMethod
	public void am()
	{
		driver.quit();
	}
}
