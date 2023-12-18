//package listen;
//
//import org.openqa.selenium.WebDriver;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//
//import base.BaseClass;
//import utilities.ExtentReport;
//
//public class Listeners extends BaseClass implements ITestListener{
//	WebDriver driver=null;
//	//create an extent report object
//	ExtentReports extentReport=ExtentReport.getExtentReports();
//    //initialize extenttest variable.
//	ExtentTest extentTest;
//	
//	//call all the method for which we want execute test case
//	public void onTestStart​(ITestResult result) {
//		extentTest=extentReport.createTest(result.getName());//create a test in extent report
//	}
//	
//	
//	//create one more method before rach test method successfull execution
//	
//    public void onTestSuccess​(ITestResult result)	{
//    	extentTest.log(Status.PASS, "Test Passed.");
//    }
//    
//    //create method that should be used before 
//    public void onTestFailure​(ITestResult result) {
//    	extentTest.fail(result.getThrowable());
//    	//get the name of test case
//    	String testName=result.getName();
//    	
//    	//logic to capture screenshot
//    	try {
//    		driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//    	
//    	try {
//    		//take screenshot
//    		String screenshotpath=takeScreenshot(testName,driver);
//    		extentTest.addScreenCaptureFromPath(screenshotpath,testName);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    }
//
//    
//    public void onFinish​(ITestContext context) {
//    	extentReport.flush();
//    }
//}


package Listeners;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import utilities.ExtentReport;

public class Listeners extends BaseClass implements ITestListener {
	
//WebDriver driver;
ExtentReports extentReport=ExtentReport.getExtentReports();
ExtentTest extentTest;


//method which invoked before each test method execution
@Override
public void onTestStart(ITestResult result) {
	extentTest=extentReport.createTest(result.getName());
}

//method which invoked before each test method sucessful.
@Override
public void onTestSuccess(ITestResult result) {
	//log the status 
	//get the name of failed test case
	String testName=result.getName();
	try {
		String screenshotPath=takeScreenshot(testName, driver);//calling method coming utilitu class in utilties
		extentTest.addScreenCaptureFromPath(screenshotPath,testName);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	extentTest.log(Status.PASS, "Test Passed");
}

//Invoked each time a test fails.
@Override
public void onTestFailure(ITestResult result) {
	extentTest.fail(result.getThrowable());
	//get the name of failed test case
	String testName=result.getName();
	//Logic for screenshot capture
	try {
		driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (IllegalAccessException|IllegalArgumentException|NoSuchFieldException|SecurityException e) {
		e.printStackTrace();
	}
	try {
		String screenshotPath=takeScreenshot(testName, driver);//calling method coming utilitu class in utilties
		extentTest.addScreenCaptureFromPath(screenshotPath,testName);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}

@Override
public void onFinish(ITestContext context) {
	//flush the extent  to write the data to report file
	extentReport.flush();
}

}

