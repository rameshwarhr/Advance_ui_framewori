package TestObject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.DriverFactory;
import Base.TestBase;

import pageObject.welcomePage;


public class sample_test extends TestBase
{
	@BeforeMethod
	public void setup() throws Exception
	{
		LaunchApplication();
		DriverFactory.getInstance().getDriver().get("https://172.18.75.72/eNPS/");
		risktAccept();

	}
welcomePage wl=new welcomePage();

	
	
	
	@Test
	public void test_click_NPS()
	{
		wl.click_nps();
//		logs.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
//		logs.info("test case is of nps clickk");
	}
	
	@Test
	public void test1()
	{
		System.out.println("Test 2");
	
	}
	
	@Test
	public void test_url()
	{
	String url=	DriverFactory.getInstance().getDriver().getCurrentUrl();
	System.out.println("Url :- "+url);
	Assert.assertEquals(url, "https://172.18.75.72/eNPS/");
	
	
	}
	
	
	@Test
	public void test_title()
	{
	String title=	DriverFactory.getInstance().getDriver().getTitle();
	System.out.println("Title:-  "+title);
	Assert.assertEquals(title, "eNPS - National Pension System 123");
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}
}
