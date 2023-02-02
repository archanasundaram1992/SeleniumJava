package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
	public static ExtentReports ExtentReportsMethod()
	{
	// Extent reports, Extent SparkReporter
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("web Automation Report-Amazon");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);				//Attaching cofig done using Extentspark Reporter to extentReports
		extent.setSystemInfo("Tester", "Archana");
		return extent;
	}

}
