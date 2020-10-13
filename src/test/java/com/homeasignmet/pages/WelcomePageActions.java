package com.homeasignmet.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.homeasignment.locators.welcomePageLocators;
import com.homeasignment.utils.FunctionalUtils;
import com.homeasignment.utils.SeleniumDriver;
import com.homeasignment.utils.WaitElementCondition;

public class WelcomePageActions extends CommonInPages{
	int count=0;
	int val=2;

	
	public void verifyWelcomePageTitle() {
		SeleniumDriver.getDriver().manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		FunctionalUtils.checkPageTitle(SeleniumDriver.getDriver(), "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
			
			}

	public void enterFlightLocations() throws IOException, InterruptedException {
        
		SeleniumDriver.getDriver().manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		FunctionalUtils.waitForElementPresent(SeleniumDriver.getDriver(), welcomePageLocators.From_Location, 90);
		//WaitElementCondition.wait(05);
		FunctionalUtils.click(SeleniumDriver.getDriver(), welcomePageLocators.From_Location);
		FunctionalUtils.sendKey(SeleniumDriver.getDriver(), welcomePageLocators.From_Location,from);
		WaitElementCondition.wait(07);
		
		List<WebElement> fromInputBox = SeleniumDriver.getDriver().findElements(welcomePageLocators.Locationlist);
		FunctionalUtils.click(SeleniumDriver.getDriver(), fromInputBox.get(0));
		FunctionalUtils.click(SeleniumDriver.getDriver(), welcomePageLocators.To_Location);
		FunctionalUtils.sendKey(SeleniumDriver.getDriver(), welcomePageLocators.To_Location,to);
		WaitElementCondition.wait(07);
		List<WebElement> fromInputBox1 = SeleniumDriver.getDriver().findElements(welcomePageLocators.Locationlist);
	
		
		FunctionalUtils.click(SeleniumDriver.getDriver(), fromInputBox1.get(1));
		FunctionalUtils.selectDate(SeleniumDriver.getDriver());
		SeleniumDriver.getDriver().manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);

		FunctionalUtils.click(SeleniumDriver.getDriver(), welcomePageLocators.SearchBtn);
		
	}
	
}