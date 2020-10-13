package com.homeasignment.locators;

import org.openqa.selenium.By;

public class welcomePageLocators {
	public static By To_Location=By.cssSelector("input#ToTag");
	public static By From_Location=By.cssSelector("input#FromTag");
	public static By Locationlist=By.xpath("//li/a[starts-with(@id,'ui-id') and @tabindex='-1']");
	public static By DepartureDate=By.cssSelector("input#DepartDate");
	public static By ReturnDate=By.cssSelector("input#ReturnDate");
	public static By SearchBtn=By.cssSelector("input#SearchBtn");
	public static By CalenderNextBtn=By.cssSelector("a.nextMonth");
	public static By CalenderdayBtn=By.cssSelector("a.ui-state-default");

}
