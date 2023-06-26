package utility;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG 
{
	static ExtentReports extent;
	
	    static Date date = new Date();  
        static Timestamp ts=new Timestamp(date.getTime());  
        static SimpleDateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");  
	    private static String reportFileName = "Test-Automaton-Report "+timestamp.format(ts)+".html";
	    private static String fileSeperator = System.getProperty("file.separator");
	    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
	    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;

	public static ExtentReports setupExtentReport() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String reportPath = System.getProperty("user.dir")+
				"/Reports/ExecutionReport_"+actualDate+".html";
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportFileLocation);
		
		 extent = new ExtentReports();
		 extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("reportFileName");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("POP Automation Report");
		
		// Adding system information / environment ifo
		extent.setSystemInfo("Window Ip:", "172.19.66.58");
		extent.setSystemInfo("OS:", "Window");
		extent.setSystemInfo("QA Name:", "Rameshwar Rathod");
		extent.setSystemInfo("Project:", "POP");
		

		return extent;
	}
}
