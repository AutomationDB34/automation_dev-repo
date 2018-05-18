package com.page.module.vport;

import org.openqa.selenium.WebDriver;

import com.page.locators.vport.VportAdministrationPageAllTabsLocators;
import com.selenium.SafeActions;
import com.testng.Assert;

public class VportAdministrationPageAllTabs extends SafeActions implements VportAdministrationPageAllTabsLocators {

	WebDriver driver;
	
	
	public VportAdministrationPageAllTabs(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}


	public void verifyAllTabs() {
		
		safeClick(DISTRICT_TRACKS_SUBTAB, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(DISTRICT_TRACKS_PAGE), "District tracks page is not being dispalyed");
		
		safeClick(DISTRICT_MASTERS_SUBTAB, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(DISTRICT_MASTERS_PAGE), "District Masters page is not being dispalyed");
		
		safeClick(SEARCH_SUBTAB, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(SEARCH_PAGE), "Search page is not being dispalyed");
		
		safeClick(ADMINISTRATION_TAB, MEDIUMWAIT);
		safeClick(USERS_SUBTAB, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(USERS_PAGE), "Users page is not being dispalyed");
		
		safeClick(CALENDER_TEMPLATE_SUBTAB, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(CALENDER_TEMPLATE_PAGE), "Calender Template page is not being dispalyed");
		
		safeClick(ASSESSMENTS_PLANS_SUBTAB, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(ASSESSMENTS_PLANS_PAGE), "assessment plans page is not being dispalyed");
		
		safeClick(ASSESSMENTS_PROFILES_SUBTAB, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(ASSESSMENTS_PROFILES_PAGE), "assessment profile plans page is not being dispalyed");

		safeClick(ELIBRARY_USERS_SUBTAB, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(ELIBRARY_USERS_PAGE), "elibrary users page is not being dispalyed");
		
		safeClick(JDE_IMPORT_TAB, MEDIUMWAIT);
		safeClick(OPEN_ITEMS_SUBTAB, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(OPEN_ITEMS_PAGE), "open items page is not being dispalyed");
		
		safeClick(COMPLETED_ITEMS_SUBTAB, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(COMPLETED_ITEMS_PAGE), "completed items page is not being dispalyed");
		
		//safeClick(DIGITALSAMPLES_TAB, MEDIUMWAIT);
		safeJavaScriptClick(DIGITALSAMPLES_TAB, MEDIUMWAIT);
		switchToWindow(1);
		String currentURL = getCurrentURL().toString();
		String expecteddIGITALSampleUrl = "";
		if(currentURL.contains("/qa."))
		{
			expecteddIGITALSampleUrl = "https://qa.vport.voyagersopris.com/vip/admin/view_digital_sample_list.do";
		}
		else
		{
			expecteddIGITALSampleUrl = "https://vport.voyagersopris.com/vip/admin/view_digital_sample_list.do";
		}
		Assert.assertEquals(getCurrentURL(), expecteddIGITALSampleUrl,"expecteddIGITALSampleUrl is not as expected");
		Assert.assertTrue(isElementDisplayed(CREATE_NEW_SAMPLE_LINK), "Digital samples page is loaded");
		driver.close();
		switchToWindow(0);
		
		//safeClick(TRIAL_SAMPLE_TAB, MEDIUMWAIT);
		safeJavaScriptClick(TRIAL_SAMPLE_TAB, MEDIUMWAIT);
		switchToWindow(1);
		waitForSecs(4);
		currentURL = getCurrentURL().toString();
		String expectedtrial_sampleUrl = "";
		if(currentURL.contains("/qa."))
		{
			expectedtrial_sampleUrl = "https://qa.vport.voyagersopris.com/vip/admin/trial_sample.do";
		}
		else
		{
			expectedtrial_sampleUrl = "https://vport.voyagersopris.com/vip/admin/trial_sample.do";
		}
		Assert.assertEquals(getCurrentURL(),expectedtrial_sampleUrl, "expectedtrial_sampleUrl is not as expected");
		Assert.assertTrue(isElementDisplayed(ADD_ROW_BTN), "Trial samples page is loaded");
		driver.close();
		switchToWindow(0);
	}
}
