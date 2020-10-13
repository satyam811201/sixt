package com.homeasignment.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.homeasignment.utils.SeleniumDriver;
import com.homeasignmet.pages.CommonInPages;
import com.homeasignmet.pages.WelcomePageActions;

public class BasicBookingTest1 extends SeleniumDriver{

	@SuppressWarnings("static-access")
	@Test
	@Parameters({"browser"})
	public void scenario() throws Exception {

		CommonInPages comPage = new CommonInPages();
		comPage.testConfiguration("BasicBookingTest1Data");
		seleniumDriver("Chrome");
		comPage.launchApplicationEntryFlow();
		
		WelcomePageActions welcomepage=new WelcomePageActions();
		welcomepage.verifyWelcomePageTitle();
		
	}
}