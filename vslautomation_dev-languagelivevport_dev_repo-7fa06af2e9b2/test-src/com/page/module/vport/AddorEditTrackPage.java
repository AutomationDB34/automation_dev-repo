package com.page.module.vport;

import org.openqa.selenium.WebDriver;

import com.page.locators.vport.AddorEditTrackLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class AddorEditTrackPage extends SafeActions implements AddorEditTrackLocators {
	private WebDriver driver;
	String text;

	public AddorEditTrackPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose- To Add District page is loaded or not
	 */	
	public void verfyDistrictPage() {
		waitForPageToLoad();
		boolean districtNameFiledExists = isElementPresent(DIST_NAME_FIELD, MEDIUMWAIT);
		Assert.assertTrue(districtNameFiledExists, "District creation page is not being displayed");
		waitForSecs(2);
	}

	/**
	 * Purpose- To fill the details required to create a track
	 */	
	public String fillTrackDetails(String distName, String address, String city, String country, String state,
			String zipcode, String usertype, String product, String status,String year) {

		text = distName + System.currentTimeMillis();
		String short_Distname = "ZAutoT"+text.substring(7,20);
		//text=distName;
		safeType(DIST_NAME_FIELD, short_Distname);
		safeType(DIST_SHORT_NAME_FIELD, short_Distname);
		safeType(ADDRESS_FIELD, address);
		safeType(CITY_FIELD, city);
		safeSelectOptionInDropDownByVisibleText(COUNTRY, country);
		safeSelectOptionInDropDownByVisibleText(STATE, state);
		safeType(ZIPCODE_FIELD, zipcode);
		safeSelectOptionInDropDownByVisibleText(USERTYPE, usertype);

		safeClick(ADDTRACK_BTN);
		//for (int i = 0; i < product.length; i++) {
			safeSelectOptionInDropDownByVisibleText(PRODUCT, product);
			// UtilityMethods.getCurrentDateTime("YYYY")
			safeSelectOptionInDropDownByVisibleText(YEAR, year);
			safeSelectOptionInDropDownByVisibleText(STATUS, status);
		//}
		return short_Distname;
	}

	/**
	 * Purpose- To click Save Changes button inorder to create new track
	 */	
	public VportTrackFilterPage clickSaveChanges() {
		safeClick(SAVE_CHANGES_BTN);
		return new VportTrackFilterPage(driver);
	}

	public String enterDetailsForSubdistrictTrack(String distName, String address, String city, String country, String state,
			String zipcode, String usertype, String ParentID) {
	
		text = distName + System.currentTimeMillis();
		String short_Distname = text.substring(7,20);
		//text=distName;
		safeType(DIST_NAME_FIELD, text);
		safeClick(PARENT_DISTRICT_DROPDOWN, MEDIUMWAIT);
		safeClick(Dynamic.getNewLocator(PARENT_ID, "ZenAuto"+ParentID));
		safeType(DIST_SHORT_NAME_FIELD, short_Distname);
		safeType(ADDRESS_FIELD, address);
		safeType(CITY_FIELD, city);
		safeSelectOptionInDropDownByVisibleText(COUNTRY, country);
		safeSelectOptionInDropDownByVisibleText(STATE, state);
		safeType(ZIPCODE_FIELD, zipcode);
		safeSelectOptionInDropDownByVisibleText(USERTYPE, usertype);
		
		return short_Distname;

	}

}
