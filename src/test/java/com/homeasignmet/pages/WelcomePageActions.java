package com.homeasignmet.pages;

import java.util.concurrent.TimeUnit;

import com.homeasignment.welcomePageLocators;
import com.homeasignment.utils.FunctionalUtils;
import com.homeasignment.utils.SeleniumDriver;

public class WelcomePageActions extends CommonInPages{
	int count=0;
	int val=2;

	
	public void verifyWelcomePageTitle() {
		SeleniumDriver.getDriver().manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		FunctionalUtils.checkPageTitle(SeleniumDriver.getDriver(), "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
			
			}

}