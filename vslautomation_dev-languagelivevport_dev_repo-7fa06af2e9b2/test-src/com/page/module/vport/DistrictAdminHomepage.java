package com.page.module.vport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.datamanager.ConfigManager;
import com.page.locators.vport.DistrictAdminHomeLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class DistrictAdminHomepage extends CommonFunctionalitiesVPort implements DistrictAdminHomeLocators {

	WebDriver driver;
	Logger log = Logger.getLogger(getClass());
	ConfigManager dependentData = new ConfigManager("DependentData");

	public DistrictAdminHomepage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	/*
	 * To verify Home page is loaded
	 */
	public void verifyHomePage(String trakName, String productName) {
		waitForSecs(3);

		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCREENTITLE, "1"), MEDIUMWAIT), "Home Page","Home Page text doesn't matched in title of page ");

		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCREENTITLE, "2"), MEDIUMWAIT), trakName,"TrackName doesn't matched in title of page");
		//	Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCREENTITLE, "3"), MEDIUMWAIT), productName,"Product Name  doesn't matched in title of page");

	}

	/**
	 * To selects school from schools dropdown 
	 */
	public void selectSchoolFromDropdown(String SchoolName) {
		waitForPageToLoad();
		safeClick(SCHOOL_DRPDOWN);
		safeClick(Dynamic.getNewLocator(SCHOOLNAME_OPTION, SchoolName));
	}
	/**
	 * To navigate to My school tab
	 */
	public DistrictAdminMySchoolPage clickOnMySchoolTab() {
		safeClick(MYSCHOOL_TAB);
		return new DistrictAdminMySchoolPage(driver);

	}

	/**
	 * To navigate to My school tab
	 */
	public DistrictAdminMySchoolPage clickOnMyClass() {
		safeClick(MYSCHOOL_TAB);
		return new DistrictAdminMySchoolPage(driver);

	}


	public void verifyHomePageofClass(String className){
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCREENTITLE, "2"), MEDIUMWAIT), className,"className doesn't matched in title of page");
	}
	public void verifyResourcesinClassHomePage()
	{
		boolean bT2RimageExists=isElementPresent(T2RICONINRESOURCES, LONGWAIT);
		Assert.assertTrue(bT2RimageExists,"T2R image doesn't exists in Resources section of Home page");
		boolean beBooksimageExists=isElementPresent(eBooksICONINRESOURCES, LONGWAIT);
		Assert.assertTrue(beBooksimageExists,"eBooks image doesn't exists in Resources section of Home page");
	}


	/**
	 * Verify all the links 
	 */
	public void verifyAllTheLinksAndPages(String userType)
	{
		HashMap<String,String> allThaPages = new HashMap<>();
		//All the available tabs
		List<WebElement> tabs = LocatorWebElements(TABS_ALL);
		log.info("tabs.size():"+tabs.size());
		boolean firsttabCompleted=false;
		for(int i=0;i<=tabs.size();i++)
		{
			waitForSecs(1,"Waiting to load the Active tab");
			if(i==0 || i==(tabs.size()))
			{
				safeClick(ACTIVE_TAB, MEDIUMWAIT);
				allThaPages.put("TAB_"+safeGetText(ACTIVE_TAB, MEDIUMWAIT).toUpperCase(), safeGetText(ACTIVE_TAB, MEDIUMWAIT));
				firsttabCompleted=true;
			}
			else
			{
				/*if(firsttabCompleted)
				{
				safeClick(Dynamic.getNewLocator(NEXT_TAB, String.valueOf(i-1)), MEDIUMWAIT);
				allThaPages.put("TAB_"+i, safeGetText(Dynamic.getNewLocator(NEXT_TAB, String.valueOf(i-1)), MEDIUMWAIT));
				}
				else
				{*/
				safeClick(Dynamic.getNewLocator(NEXT_TAB, String.valueOf(i)), MEDIUMWAIT);
				allThaPages.put("TAB_"+safeGetText(Dynamic.getNewLocator(NEXT_TAB, String.valueOf(i)), MEDIUMWAIT).toUpperCase(), safeGetText(Dynamic.getNewLocator(NEXT_TAB, String.valueOf(i)), MEDIUMWAIT));
				/*}*/
			}
			waitForPageToLoad();
			waitForSecs(1,"Waiting for tab to load");
			//All the Sub tabs
			List<WebElement> subTabs = LocatorWebElements(SUBTABS_ALL);
			log.info("subTabs.size():"+subTabs.size());
			for(int j=1;j<=subTabs.size();j++)
			{
				waitForSecs(1,"Waiting to load the Active sub tab");
				
			/*	if(j==1)
				{
					safeClick(Dynamic.getNewLocator(NEXT_SUBTAB, String.valueOf(j)), MEDIUMWAIT);
					allThaPages.put("TAB_"+safeGetText(ACTIVE_TAB, MEDIUMWAIT).toUpperCase()+"_SUBTAB_"+safeGetText(Dynamic.getNewLocator(NEXT_SUBTAB, String.valueOf(j)), MEDIUMWAIT).toUpperCase(), safeGetText(Dynamic.getNewLocator(NEXT_SUBTAB, String.valueOf(j)), MEDIUMWAIT));
				}
				else
				{*/
					safeClick(Dynamic.getNewLocator(NEXT_SUBTAB, String.valueOf(j)), MEDIUMWAIT);
					allThaPages.put("TAB_"+safeGetText(ACTIVE_TAB, MEDIUMWAIT).toUpperCase()+"_SUBTAB_"+safeGetText(Dynamic.getNewLocator(NEXT_SUBTAB, String.valueOf(j)), MEDIUMWAIT).toUpperCase(), safeGetText(Dynamic.getNewLocator(NEXT_SUBTAB, String.valueOf(j)), MEDIUMWAIT));
				/*}*/
				waitForPageToLoad();
				waitForSecs(1,"Waiting for sub tab to load");
			}
		}

		for(String keys : allThaPages.keySet())
		{
			dependentData.writeProperty(userType+"_"+keys.replace("\\ \\", ""), allThaPages.get(keys));
		}
	}

	/**
	 * Purpose is to navigate to the My Results page
	 * @return 
	 */
	public DistrictAdminMyResultsPage clickOnMyResultsTab() {
		safeClick(MY_RESULTS_TAB, MEDIUMWAIT);
		return new DistrictAdminMyResultsPage(driver);
		
		
	}


}
