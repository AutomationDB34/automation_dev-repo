package com.page.module.vport;

import org.openqa.selenium.WebDriver;

import com.datamanager.ConfigManager;
import com.page.locators.vport.DistrictTrackTechnologyLocators;
import com.selenium.SafeActions;
import com.selenium.Sync;
import com.testng.Assert;

public class DistrictTrackTechnologyPage extends SafeActions implements DistrictTrackTechnologyLocators {

	private WebDriver driver;
	
	ConfigManager app;	
	
	Sync sync;
	
	//constructor to define or call methods
	
	public DistrictTrackTechnologyPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;			
	}

	/**
	 * Purpose- To verify whether the Technology tab page is displayed or not
	 * @throws Exception
	 */
	public void verifyTechnologyPage()
	{
		boolean addRowButtonExists=isElementPresent(ADDROW_BTN, LONGWAIT);
		
		Assert.assertTrue(addRowButtonExists, "Add row button is not found on Technology page or unable to navigate to technology page");
	}
	
	/**
	 * 	Purpose- To verify assessment plans and their radio button options set to 'ON'
	 *  @throws Exception
	 */
	public void verifyAssessmentPlansAndEnabledRadioButtons() 
	{
		int availableAssessmentPlansCount = getLocatorCount(AVAILABLEASSESSMENTPLANS)-1;
		
		int enabledRadioButtonsCount = getLocatorCount(ENABLEDRADIOBUTTONSFORASSESSMENT);
		
		Assert.assertEquals(availableAssessmentPlansCount*3, enabledRadioButtonsCount, "Some of customer interface radio buttons are not enabled for some assesment plans availble on Technology page");
	}	

}
