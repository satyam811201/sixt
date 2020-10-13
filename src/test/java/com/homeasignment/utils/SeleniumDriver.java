package com.homeasignment.utils;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class SeleniumDriver {
	// Initialize webdriver
	private static WebDriver driver;
	public static Report reporter = new Report();
	public final static Map<String, String> dataMap = new HashMap<String, String>();
	public static String dateTime;
	public static String date;
	public static String screenShotName;
	public static String ScreenshotPath = "\\target\\surefire-reports_"+dateTime+"\\html\\";
	public static int i=000;
	String labelNumber;
	protected void seleniumDriver(String browser) {

		String path = System.getProperty("user.dir") + "\\Drivers\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

	}
	public static WebDriver getDriver() {
		return driver;
	}

	public static void Maxi() {
		driver.manage().window().maximize();
	}
	RetryAnalyzer retyr=new RetryAnalyzer();

	@BeforeMethod
	public void ReportStartEngine() {
		if(RetryAnalyzer.counter==0) {
			reporter.reportStart(getClass().getSimpleName());
		}
	}

	@AfterMethod
	public void ReportgenerateTestEndEngine(ITestResult result) {

		String url=driver.getCurrentUrl();
		String jsessionId="";
		if(url.contains("TAB_ID=")) {
			jsessionId=url.split("TAB_ID=")[1];
		}
		String labelHref =driver.findElement(By.xpath("//link")).getAttribute("href");
		String[] labelDetails=labelHref.split("/");
		labelNumber=labelDetails[4];
		reporter.report("JsessionID",jsessionId);
		reporter.report("LabelNumber",labelNumber);
		if(result.getStatus()==ITestResult.SUCCESS){
			reporter.reportPassed("Result", "Execution completed");
			RetryAnalyzer.counter=0;
		}else
			if(result.getStatus()==ITestResult.FAILURE) {
				System.out.println(result.getThrowable());
				reporter.reportFailed("Result","Execution is incomplete");
				reporter.reportFailed("Result",result.getThrowable().getStackTrace().toString());
				//reporter.report("Error",  result.getThrowable().toString());
			}
		if(result.getStatus()==ITestResult.SKIP) {
			System.out.println(result.getThrowable());
			reporter.reportFailed("Result","Execution is incomplete");
			reporter.reportFailed("Result","Retrying Test case");

		}

		dataMap.clear();

		//close browser
		if (driver != null) {
			driver.close();
			driver.quit();
		}
		reporter.endTest();
		reporter.reportFlush();
	}


}
