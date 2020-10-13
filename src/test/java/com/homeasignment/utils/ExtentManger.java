package com.homeasignment.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
public class ExtentManger {
	private static ExtentReports extent;
	@BeforeSuite
	public static ExtentReports getInstance() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String date = simpleDateFormat.format(new Date());
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		date = simpleDateFormat.format(new Date());
		String path = System.getProperty("user.dir") + "\\target\\surefire-reports_\\ExtentReport.html";
		if (extent == null) {
			extent = new ExtentReports(path, true, DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\ExtentReport\\ReportsConfig.xml"));
		}
		return extent;
	}

}
