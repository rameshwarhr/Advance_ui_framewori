package Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import ReusableComponent.ActionEngine;

public class TestBase extends ActionEngine
{

	BrowserFactory bf = new BrowserFactory();
	
	public void LaunchApplication() throws Exception {


		DriverFactory.getInstance().setDriver(bf.createBrowserInstance("Chrome"));

		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	DriverFactory.getInstance().getDriver().navigate().to(url);

	}
	
	public void risktAccept() throws InterruptedException
	{
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@id='details-button']")).click();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@id='proceed-link']")).click();
		Thread.sleep(1000);
	}
	
	
	
	
	
	
	public static String getScreenshot(WebDriver driver, String methodname) 
	{

		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destPath=System.getProperty("user.dir")+"/Screenshot/"+methodname+"-"+getCurrentTime()+".png";
		
		File file=new File(destPath);
		
		try {
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return 	destPath;	
		
		

	}
	
	public static String getCurrentTime() {
		String currentDate=new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	
	
	
	
	
	
	
	
	
	
}
