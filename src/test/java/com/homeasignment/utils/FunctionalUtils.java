package com.homeasignment.utils;


import java.util.List;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.homeasignment.locators.welcomePageLocators;
import com.homeasignmet.pages.CommonInPages;


public class FunctionalUtils extends CommonInPages{

	static Report reporter =null;
	public static boolean waitForElementPresent(WebDriver driver, By eltLocator, int timeout) {
		// wait for an element loaded
		try{
			return waitForCondition(driver, new WaitElementCondition(eltLocator, true), timeout);
		} catch (TimeoutException te) {
			// Report the timeout
			if (reporter != null)
				SeleniumDriver.reporter.fail("Fail", "element not found");

		}
		return false;
	}

	public static boolean waitForCondition(WebDriver driver, ExpectedCondition<Boolean> condition, int timeout) throws TimeoutException {
		// wait for an element condition
		Wait<WebDriver> wait = new WebDriverWait(driver, timeout);
		Boolean waitResult = wait.until(condition);
		if (waitResult != null) {
			return waitResult.booleanValue();
		}
		return false;
	}

	public static void click(WebDriver driver, WebElement elmt) {
		//SeleniumDriver.reporter.savePNGLightReport();

		if (elmt != null && elmt.isDisplayed()) {
			elmt.click();
		}
	}

	public void click(By byElmt) {
		click(SeleniumDriver.getDriver(), byElmt);
	}
	public static void click(WebDriver driver, By byElmt) {
		WebElement elmt = getElement(driver, byElmt);
		if (elmt != null && elmt.isDisplayed()) {
			elmt.click();
		}
	}
	public static WebElement getElement(WebDriver driver, By eltLocator) {
		return getElement(driver,null, eltLocator);
	}


	static public WebElement getElement(WebDriver driver, WebElement referenceElt, By eltLocator) {

		WebElement eltFound = null;

		// Debug mode NOT activated
		try {
			if (referenceElt == null) {
				eltFound = driver.findElement(eltLocator);
			}
			else {
				eltFound = referenceElt.findElement(eltLocator);
			}
		}
		catch (NoSuchElementException e) {
			// Elt not found
			eltFound = null;
		}

		return eltFound;
	}

	public static void sendKey(WebDriver driver, By byElmt, String keySend) {
		////SeleniumDriver.reporter.savePNGLightReport();
		WebElement elmt = getElement(driver, byElmt);
		if (elmt != null && elmt.isDisplayed()) {
			elmt.sendKeys("\u0008");
			elmt.clear();
			elmt.sendKeys(keySend);
		}
	}
	public static void sendKey(WebDriver driver, WebElement elmt, String keySend) {
		// //SeleniumDriver.reporter.savePNGLightReport();
		if (elmt != null && elmt.isDisplayed()) {
			elmt.sendKeys("\u0008");
			elmt.clear();
			elmt.sendKeys(keySend);
		}
	}


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

	public static void selectDate(WebDriver driver)  {

		WaitElementCondition.wait(10);
		FunctionalUtils.click(SeleniumDriver.getDriver(), welcomePageLocators.DepartureDate);
		List<WebElement> ele= SeleniumDriver.getDriver().findElements(welcomePageLocators.CalenderdayBtn);
		FunctionalUtils.click(SeleniumDriver.getDriver(),ele.get(10));
	}


}






