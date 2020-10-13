package com.homeasignment.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	static int counter = 0;
	int retryLimit = 1;
	public boolean retry(ITestResult result) {
	if(counter < retryLimit){
		counter++;
		return true;
	}
	counter = 0;
	return false;
	}
}
