
package com.page.module.vport;


import org.openqa.selenium.WebDriver;

import com.page.locators.vport.DistrictTrackSchoolTracksLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class DistrictTrackSchoolTracksPage extends SafeActions implements DistrictTrackSchoolTracksLocators {

	private WebDriver driver;

	public DistrictTrackSchoolTracksPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * Purpose-To verify School tracks page 
	 **/

	public void verifySchoolTracksTab(String trackName) {
		waitForSecs(10);
		waitForPageToLoad();
		boolean bIsTrackNameDisplayed = isElementDisplayed(Dynamic.getNewLocator(TRACKNAME_HEADING, trackName));
		Assert.assertTrue(bIsTrackNameDisplayed, "Track name is not displayed on School Tracks page");
	}

	/**
	 * Purpose-To find the required school from the list of schools 
	 **/
	public void findSchool(String schoolName) {
		waitForPageToLoad();
		boolean bSchoolNameExists = isElementPresent(Dynamic.getNewLocator(SCHOOLNAME, schoolName), MEDIUMWAIT);
		Assert.assertTrue(bSchoolNameExists, "School name doesn't exists ");
	}

	/**
	 * Purpose-To checks whether Inherit radio buttons are in disabled state before activating the school
	 **/
	public void verifyInheritRadiobuttonsdisabled(String schoolName) {
		for (int i = 5; i <= 7; i++) {
			boolean bvalue = isElementEnabled(Dynamic.getNewLocator(INHERIT_RADIOBTN, new String[] { schoolName, Integer.toString(i) }));
			Assert.haultonfailure=false;
				Assert.assertFalse(bvalue, "Inherit radio button"+(i-3)+" are not in disabed state");
		}

	}

	/**
	 * Purpose-To activate the school by checking check box beside school name 
	 **/
	public void activateSchoolAndSave(String schoolName) {
		safeClick(Dynamic.getNewLocator(CHECKBOX_SCHOOL, schoolName));
		safeClick(SAVECHANGES_BTN);
	}

	/**
	 * Purpose-To checks whether Inherit radio buttons are in enabled  state after activating the school
	 **/
	public void verifyInheritRadiobuttonsStatus(String schoolName, boolean enabledStatus) {
		String status = "enabled";
		for (int i = 5; i <= 7; i++) {
			boolean bvalue = isElementEnabled(Dynamic.getNewLocator(INHERIT_RADIOBTN, new String[] { schoolName, Integer.toString(i) }));
			Assert.haultonfailure=false;
			if(!enabledStatus){
				bvalue=!bvalue;
				status = "disabled";
			}
			Assert.assertTrue(bvalue, "Inherit radio buttons are not in " + status + " state");
		}
		Assert.assertAll();

	}

	public DistrictAdminHomepage clickPIIcon(String trackname) {
		safeClick(Dynamic.getNewLocator(PI_ICON, trackname), MEDIUMWAIT);
		return new DistrictAdminHomepage(driver);
		
		
	}

}
