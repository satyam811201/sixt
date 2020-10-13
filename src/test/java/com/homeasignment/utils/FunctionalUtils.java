package com.homeasignment.utils;

import org.openqa.selenium.WebDriver;

import com.homeasignmet.pages.CommonInPages;

public class FunctionalUtils extends CommonInPages{

	static Report reporter =null;
	
	
	
	public static void checkPageTitle(WebDriver driver,
			String referenceTitle) {

		// check title
		String titleFound = driver.getTitle();
		if (titleFound != null && titleFound.contains(referenceTitle)) {
			SeleniumDriver.reporter.reportPassed("test for page title", "title matched");
		}
		else {
			SeleniumDriver.reporter.fail("Title not matched" );
		}
	
	}
	}