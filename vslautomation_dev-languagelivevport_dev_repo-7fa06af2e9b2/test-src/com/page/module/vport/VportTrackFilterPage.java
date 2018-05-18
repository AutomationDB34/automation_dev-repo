package com.page.module.vport;

import javax.print.attribute.standard.Media;

import org.openqa.selenium.WebDriver;

import com.page.locators.vport.TrackFiltersLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class VportTrackFilterPage extends CommonFunctionalitiesVPort implements TrackFiltersLocators {

	private WebDriver driver;

	public VportTrackFilterPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose- To verify whether VPORT Filter page is being displayed or not after login
	 */	
	
	public void verifyFilterPage()
	{
		boolean productDropDownExists = isElementPresent(PRODUCT_NAME, LONGWAIT);
		Assert.assertTrue(productDropDownExists,
				"Product drop down is not being displayed on district page after login");
	}

	/**
	 * Purpose- To set filters to optimize the list displayed for track selection
	 */	
	
	public void trackFilters(String product, String userType, String alphabet , String trackname) 
	{

		safeSelectOptionInDropDownByVisibleText(PRODUCT_NAME, product);
		safeSelectOptionInDropDownByVisibleText(USER_TYPE, userType);
		safeSelectOptionInDropDownByVisibleText(ALPHA, alphabet);
		String trackName = trackname.trim();
		safeClearAndType(DIST_NAME ,trackName);
	}

	/**
	 * Purpose- To click Update List button
	 */	
	public void clickUpdateButton() {
		safeClick(UPDATELIST_BTN, SHORTWAIT);
		waitForPageToLoad(LONGWAIT);

	}

	/**
	 * Purpose- To Add District button
	 */	
	public AddorEditTrackPage clickAddDistrictbutton() {
		safeClick(ADDDISTRICT_BTN, SHORTWAIT);
		//waitForPageToLoad(LONGWAIT);
		return new AddorEditTrackPage(driver);

	}

	/**
	 * Purpose- To Verify whether the newly created track is dispalyed in the list or not after filtering 
	 */	
	public void verifyTrackCreation(String trackName) {
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(DIST_TRACK_NAME, trackName)),
				"Track with name : " + trackName + " is not created");
	}
	
	public MasterDistrictTracksPage clickOnMasterIcon(String strTrackName){
		safeClick(Dynamic.getNewLocator(MASTER_ICON, strTrackName), LONGWAIT);
		return new MasterDistrictTracksPage(driver);
	}
	
	 public DistrictTrackContactsPage clickonTrackName(String strTrackName)
	 {
		 waitForPageToLoad();
		 waitForSecs(10,"Waiting to load all the links and internal href");
		// isElementPresent(DIST_TRACK_NAME, MEDIUMWAIT);
		 safeClick(Dynamic.getNewLocator(DIST_TRACK_NAME,strTrackName),LONGWAIT);
		 return new DistrictTrackContactsPage(driver);
		 
	 }

	public VportTrackFilterPage navigateToDistrictTracksPage() {
		safeClick(DISTRICT_TRACKS_TAB, MEDIUMWAIT);
		return new VportTrackFilterPage(driver);
		
	}
	
	public VportAdministrationPageAllTabs navigateToDistrictTracksPage1() {
		safeClick(DISTRICT_TRACKS_TAB, MEDIUMWAIT);
		return new VportAdministrationPageAllTabs(driver);
		
	}

	public DistrictAdminMyResultsPage clickOnPiIcon(String trackName) {
		safeClick(Dynamic.getNewLocator(TRACK_PI_ICON_, trackName), MEDIUMWAIT);
		return new DistrictAdminMyResultsPage(driver);
		
	}

	
	

}
