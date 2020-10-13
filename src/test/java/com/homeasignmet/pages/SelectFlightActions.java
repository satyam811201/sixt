package com.homeasignmet.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.homeasignment.locators.selectFlightPage;
import com.homeasignment.locators.welcomePageLocators;
import com.homeasignment.utils.FunctionalUtils;
import com.homeasignment.utils.SeleniumDriver;
import com.homeasignment.utils.WaitElementCondition;

public class SelectFlightActions extends CommonInPages {
	
	
//	public void VerifyPage() {
//		//hardcoded value for now
//		FunctionalUtils.waitForElementPresent(SeleniumDriver.getDriver(), welcomePageLocators.To_Location, 90);
//		FunctionalUtils.checkPageTitle(SeleniumDriver.getDriver(), "Cleartrip | Bangalore → Kolkata");
//	
//	
//	}
	
public void SelectFlight() {
	
	    WaitElementCondition.wait(06);
		List<WebElement> ele= SeleniumDriver.getDriver().findElements(selectFlightPage.flight_List);
		
		FunctionalUtils.click(SeleniumDriver.getDriver(),ele.get(10));
		WaitElementCondition.wait(05);
		
		String parentWindowHandle = SeleniumDriver.getDriver().getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String> (SeleniumDriver.getDriver().getWindowHandles());
	
		for(String handle: tabs){
            if(!handle.equals(parentWindowHandle))
            {
            	SeleniumDriver.getDriver().switchTo().window(handle);
            	WaitElementCondition.wait(05);
            
            	((JavascriptExecutor) SeleniumDriver.getDriver())
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
            	FunctionalUtils.click(SeleniumDriver.getDriver(),selectFlightPage.Coninue_Flight_Btn);
            	WaitElementCondition.wait(8);
            }
		 
	
	
			}
		}

}

