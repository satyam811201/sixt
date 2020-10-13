package com.homeasignment.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitElementCondition implements ExpectedCondition<Boolean>  {
	protected By eltLocator;
	  protected boolean positiveCondition;
	  
	  /**
	   * Constructor
	   * @param eltLocator  the element locator
	   * @param positiveCondition flag for positive or negative condition (Exist or not Exist)
	   */
	  public WaitElementCondition(By eltLocator, boolean positiveCondition) {
	    super();
	    this.eltLocator = eltLocator;
	    this.positiveCondition = positiveCondition;
	  }
	  
	  public Boolean apply(WebDriver webDriver)
	  {
	    boolean exist = false;
	    try {
	      webDriver.findElement(eltLocator);
	      exist = positiveCondition;
	    } catch (NoSuchElementException e) {
	      exist = !positiveCondition;
	    } 
	      
	    return Boolean.valueOf(exist);
	  }
	  
	  public static void wait(int timeToWaitInSecond) {
		    try {
		      long timeToWaitinMS = (long)(timeToWaitInSecond * 1000);
		      Thread.sleep(timeToWaitinMS);
		    } catch (Exception e) {
		      // N/A
		    }
		  }
	}


