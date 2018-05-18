package com.page.module.ll.teacherrole;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.teacherrole.TeacherClassClassResourcesLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherClassClassResourcesPage extends CommonFunctionalities implements TeacherClassClassResourcesLocators{

	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());
	
	public TeacherClassClassResourcesPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/**
	 * Purpose- To verify that Class Resources page is loaded successfully
	 */
	
	public void verifyThatClassResourcesPageIsLoaded()
	{
		waitForPageToLoad();		
		Assert.assertTrue(isElementPresent(CLASSRESOURCESTAB_SELECTED, LONGWAIT), "Class->Class Resources tab is not displayed as selected even after clicking on it");
		Assert.assertTrue(isElementPresent(CLASSRESOURCES_CONTENTS_SECTION, LONGWAIT), "Class->Class Resources page is not loaded");
	}
	
	/**
	 * Purpose- To select a level option and verify the page loading
	 * @param classClassResourcesLevel
	 */
	
	public void selectALevelAndVerifyPageLoading(String classClassResourcesLevel)
	{
		nullifyImplicitWait();
		if(getLocatorCount(Dynamic.getNewLocator(CLASSRESOURCES_LEVEL_SELECTED, classClassResourcesLevel))==0)
		{
			safeClick(Dynamic.getNewLocator(CLASSRESOURCES_LEVEL_OPTION, classClassResourcesLevel), LONGWAIT);
		}
		setImplicitWait(IMPLICITWAIT);
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(CLASSRESOURCES_CONTENTS_SECTION, LONGWAIT), "Class->Class Resources page is not loaded after selecing the level option("+classClassResourcesLevel+")");
	}
	
	public void verifyVideosofWT(){
		String clickedVideoFileName = safeGetText(WORDTRAINING_FIRSTVIDEO, LONGWAIT);
		safeClick(WORDTRAINING_FIRSTVIDEO, LONGWAIT);
		waitForPageToLoad();
		waitForSecs(5);
		Assert.assertTrue(isElementPresent(WORDTRAINING_VIDEOPLAYER_HEADER, LONGWAIT), "video player is not displayed when clicked on the video file("+clickedVideoFileName+") under course resources word training tab");
		String playedVideoFileName = safeGetText(WORDTRAINING_VIDEOPLAYER_HEADER, LONGWAIT);
		Assert.assertEquals(clickedVideoFileName, playedVideoFileName, "clicked video file name ("+clickedVideoFileName+") doesn't match with played video file name ("+playedVideoFileName+") under word training tab of course resources page");
		refresh();
		waitForPageToLoad();
	}
	
	
	public void classClassResourcesPageVerification(LLData llData){
		
		if (executionMode.equalsIgnoreCase("qc")) {
			log.info("Runnig the test case at QC mode");
			 selectALevelAndVerifyPageLoading(llData.teacherRoleLLClassClassResourcesLevel);

		} else {
			log.info("Runnig the test case at RC mode");
			 selectALevelAndVerifyPageLoading(llData.teacherRoleLLClassClassResourcesLevel);
			verifyVideosofWT();
			
		}

		
		
		
		
	}
	
	
	
}
