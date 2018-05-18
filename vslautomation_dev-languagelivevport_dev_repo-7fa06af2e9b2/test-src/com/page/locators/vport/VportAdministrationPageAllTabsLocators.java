package com.page.locators.vport;

import org.openqa.selenium.By;

public interface VportAdministrationPageAllTabsLocators {
	
	public static By DISTRICT_TRACKS_TAB = By.xpath("//div[@class='main_menu_nav_c_on'][contains(text(),'Districts/Tracks')]");
	public static By DISTRICT_TRACKS_SUBTAB = By.xpath("//nobr[contains(text(),'Districts/Tracks')]");
	public static By DISTRICT_TRACKS_PAGE = By.id("printSection");
	public static By DISTRICT_MASTERS_SUBTAB = By.xpath("//nobr[contains(text(),'District Masters')]");
	public static By DISTRICT_MASTERS_PAGE = By.xpath("//nobr[contains(text(),'VPORT District Masters')]");
	public static By SEARCH_SUBTAB = By.xpath("//nobr[contains(text(),'Search')]");
	public static By SEARCH_PAGE = By.xpath("//h5[contains(text(),'Search Criteria:')]");
	
	public static By ADMINISTRATION_TAB = By.xpath("//div[@class='main_menu_nav_c_off'][contains(text(),'Administration')]");
	public static By USERS_SUBTAB = By.xpath("//nobr[contains(text(),'Users')]");
	public static By USERS_PAGE = By.xpath("//td[contains(text(),'Administer Admin Users')]");
	public static By CALENDER_TEMPLATE_SUBTAB = By.xpath("//nobr[contains(text(),'Calendar Templates')]");
	public static By CALENDER_TEMPLATE_PAGE = By.xpath("//nobr[contains(text(),'Administer Calendar Templates')]");
	public static By ASSESSMENTS_PLANS_SUBTAB = By.xpath("//nobr[contains(text(),'Assessment Plans')]");
	public static By ASSESSMENTS_PLANS_PAGE= By.xpath("//nobr[contains(text(),'Administer Assessment Plans')]");
	public static By ASSESSMENTS_PROFILES_SUBTAB = By.xpath("//nobr[contains(text(),'Assessment Profiles')]");
	public static By ASSESSMENTS_PROFILES_PAGE = By.xpath("//nobr[contains(text(),'Assessment Profiles')]");
	public static By ELIBRARY_USERS_SUBTAB = By.xpath("//nobr[contains(text(),'eLibrary Users')]");
	public static By ELIBRARY_USERS_PAGE = By.xpath("//td[contains(text(),'Administer eLibrary Users')]");

	public static By JDE_IMPORT_TAB = By.xpath("//div[@class='main_menu_nav_c_off'][contains(text(),'JDE Import')]");
	public static By OPEN_ITEMS_SUBTAB = By.xpath("//nobr[contains(text(),'Open Items')]");
	public static By OPEN_ITEMS_PAGE = By.xpath("//td[contains(text(),'Date/Order')]");
	public static By COMPLETED_ITEMS_SUBTAB = By.xpath("//nobr[contains(text(),'Completed Items')]");
	public static By COMPLETED_ITEMS_PAGE = By.xpath("//td[contains(text(),'Date/Order')]");

	public static By DIGITALSAMPLES_TAB = By.xpath("//div[@class='main_menu_nav_c_off'][contains(text(),'Digital Samples')]");
	public static By CREATE_NEW_SAMPLE_LINK = By.xpath("//a[contains(text(),'Create New Sample')]");
		
	public static By TRIAL_SAMPLE_TAB = By.xpath("//div[@class='main_menu_nav_c_off'][contains(text(),'Trial Sample')]");
	public static By ADD_ROW_BTN = By.xpath("//img[@title='Add Row']");
	
	
	
	
	
}
