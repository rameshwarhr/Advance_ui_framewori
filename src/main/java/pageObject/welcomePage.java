package pageObject;

import org.openqa.selenium.By;

import Base.DriverFactory;
import Base.TestBase;

public class welcomePage extends TestBase
{

	By click_NPS=By.xpath("//*[@id=\"content_translate\"]/div[2]/div[1]/div[2]/div[2]/div[1]/a[2]");
	By clikc_Registration=By.xpath("//*[@id=\"apyMore\"]/div[1]/div/div[2]/div/a[1]");
	
	public void click_nps()
	{
		click_custom(DriverFactory.getInstance().getDriver().findElement(click_NPS), "Naptional pension link");
		click_custom(DriverFactory.getInstance().getDriver().findElement(clikc_Registration), "Registration Tab");
	}
}
