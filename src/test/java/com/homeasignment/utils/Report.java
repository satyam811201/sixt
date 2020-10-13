package com.homeasignment.utils;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Report {
	
	public ExtentReports rep = ExtentManger.getInstance();
	public ExtentTest test;
	public String screenShot=null;

	
	public String lastIndex(String name) {
		if(name==null) {
			return "";
		}
		String[] name1 = name.split("\\\\");
		 name = name1[name1.length-1];
		return name;
		
	}
	public void report(String reportTitle,String reportDescription,String ScreenShot) {
		
		test.log(LogStatus.INFO,reportTitle,reportDescription+"<br> <a target=\"blank\" href=html\\"+lastIndex(ScreenShot)+">"+lastIndex(ScreenShot) +"</a>");
	}
	
	public void report(String reportTitle,String reportDescription) {
		report(reportTitle,reportDescription,null);
	}
	
	public void report(String ScreenShot) {
		report(null,null,ScreenShot);
	}
	
	public void reportWarning(String reportTitle,String reportDescription,String ScreenShot) {
		test.log(LogStatus.WARNING,reportTitle,reportDescription+"<br> <a target=\"blank\" href=html\\"+lastIndex(ScreenShot)+">"+lastIndex(ScreenShot) +"</a>");
	}
	
	public void reportWarning(String reportTitle,String reportDescription) {
		reportWarning(reportTitle,reportDescription,null);
	}
	
	public void reportPassed(String reportTitle,String reportDescription,String ScreenShot) {
		test.log(LogStatus.PASS, reportTitle,reportDescription+"<br> <a target=\"blank\" href=html\\"+lastIndex(ScreenShot)+">"+lastIndex(ScreenShot) +"</a>");
	}
	
	public void reportPassed(String reportTitle,String reportDescription) {
		reportPassed(reportTitle,reportDescription,null);
	}
	
	public void reportFailed(String reportTitle,String reportDescription,String ScreenShot) {
		test.log(LogStatus.FAIL, reportTitle,reportDescription+"<br> <a target=\"blank\" href=html\\"+lastIndex(ScreenShot)+">"+lastIndex(ScreenShot) +"</a>");
	}
	
	public void reportFailed(String reportTitle,String reportDescription) {
		reportFailed(reportTitle,reportDescription,null);
	}
	
	public void fail(String reportTitle,String reportDescription,String ScreenShot) {
		test.log(LogStatus.FAIL, reportTitle,reportDescription+"<br> <a target=\"blank\" href=html\\"+lastIndex(ScreenShot)+">"+lastIndex(ScreenShot) +"</a>");
		
		rep.endTest(test);
		rep.flush();
		Assert.fail();
	}
	
	public void fail(String reportTitle,String ScreenShot) {
		fail(reportTitle,null,ScreenShot);
	}
	
	public void fail(String reportTitle) {
		fail(reportTitle,null,null);
	}
	
	public void reportStart(String name) {
		test = rep.startTest(name);

	}

	public void reportFlush() {
		rep.flush();
	}
	
	public void endTest() {
		rep.endTest(test);
	}
}



