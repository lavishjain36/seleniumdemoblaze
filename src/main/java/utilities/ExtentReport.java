package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	//method to create an extent reports object for genrating our report
	public static ExtentReports getExtentReports() {
		
//		String extentReportPath=System.getProperty("user.dir")+ "\\reports\\extentreport.html";
		String extentReportPath=System.getProperty("user.dir")+"\\reports\\extentreport.html";

		//create an object of ExtentSparkReporter 
		ExtentSparkReporter reporter=new ExtentSparkReporter(extentReportPath);
		
		//set the report name and provide document title to generate
		reporter.config().setReportName("Demoblaze");
		reporter.config().setDocumentTitle("Demoblaze Automation Test Results...");
		
		//create an objext of ExtentReports
		ExtentReports extentreport=new ExtentReports();
		
		extentreport.attachReporter(reporter);
		return extentreport;
		
	}

}
