package com.page.locators.vport;

import org.openqa.selenium.By;

public interface MyDistrictLocators {
	
	public static By MY_DISTRICT_PAGE = By.className("screenTitle");
	//public static By SCHOOL_TAB = By.id("subtabs02_setup_schools");
	public static By SCHOOL_TAB = By.xpath("//nobr[contains(.,'  Schools  ')]");
	
	public static By SCHOOL_PAGE = By.className("screenTitle");
	public static By SCHOOL_CHECKBOX = By.xpath("//td[@class='nameRowNoBg']/input[@type='checkbox']");

}
