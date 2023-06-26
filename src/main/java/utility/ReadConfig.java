package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties property;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			property=new Properties();
			property.load(fis);
		}catch(Exception e){
			System.out.println("Exception is"+ e.getMessage());
		}
	}
	

	
	
	// Tire-2 Activation 
	public String tire_2Activation()
	{
		return property.getProperty("Tire-2");
	}
	
	
	
	// enps _ Tire 2 Activation 
	public String enps_ur()
	{
		String enps_url=property.getProperty("enps");
		return enps_url;
	}
	
	
	
	
	
	
	
}
