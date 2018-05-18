package com.page.locators.vport;

import org.openqa.selenium.By;

public interface AddorEditTrackLocators {
	
	//Add District
	public static By DIST_NAME_FIELD = By.name("name");
	public static By DIST_SHORT_NAME_FIELD = By.name("shortName");
	public static By ADDRESS_FIELD = By.name("address1");
	public static By CITY_FIELD = By.name("city");
	public static By COUNTRY = By.id("countryId");
	public static By STATE = By.id("stateId");
	public static By ZIPCODE_FIELD = By.name("postalCode");
	public static By USERTYPE = By.name("useTypeId");
	
	//Add Product
	public static By ADDTRACK_BTN = By.name("Add Track");
	public static By PRODUCT = By.name("districtTrackInfo[0].productId");
	public static By YEAR = By.name("districtTrackInfo[0].academicYearId");
	public static By STATUS = By.name("districtTrackInfo[0].status");
	public static By SAVE_CHANGES_BTN = By.className("submit");
	

	//Locators for sub district 
	By PARENT_DISTRICT_DROPDOWN = By.name("parentDistrictId");
	By PARENT_ID = By.xpath("//option[contains(text(),'%s')]");
	
	
}
