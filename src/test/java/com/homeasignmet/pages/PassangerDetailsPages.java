package com.homeasignmet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.homeasignment.locators.passangerDetailslocators;
import com.homeasignment.utils.FunctionalUtils;
import com.homeasignment.utils.SeleniumDriver;
import com.homeasignment.utils.WaitElementCondition;

public class PassangerDetailsPages extends CommonInPages {
	

		public void ProvideEmailAddress() {
			
			FunctionalUtils.click(SeleniumDriver.getDriver(), passangerDetailslocators.Email_Field);
			FunctionalUtils.sendKey(SeleniumDriver.getDriver(), passangerDetailslocators.Email_Field,email);
			
			FunctionalUtils.click(SeleniumDriver.getDriver(), passangerDetailslocators.Coninue_Login_Btn);
			
			WaitElementCondition.wait(05);
			Select title=new Select(SeleniumDriver.getDriver().findElement(By.cssSelector("select#AdultTitle1.required.travellerTitle")));
			title.selectByIndex(1);
			
			FunctionalUtils.click(SeleniumDriver.getDriver(), passangerDetailslocators.firtName);
			FunctionalUtils.sendKey(SeleniumDriver.getDriver(), passangerDetailslocators.firtName,Fname);
			
			FunctionalUtils.click(SeleniumDriver.getDriver(), passangerDetailslocators.lastName);
			FunctionalUtils.sendKey(SeleniumDriver.getDriver(), passangerDetailslocators.lastName,Lname);
			
			FunctionalUtils.click(SeleniumDriver.getDriver(), passangerDetailslocators.mobileNo);
			FunctionalUtils.sendKey(SeleniumDriver.getDriver(), passangerDetailslocators.mobileNo,mobileno);
			
			FunctionalUtils.click(SeleniumDriver.getDriver(),passangerDetailslocators.Continue_Btn);
			WaitElementCondition.wait(05);
		
		}
		
		
}
