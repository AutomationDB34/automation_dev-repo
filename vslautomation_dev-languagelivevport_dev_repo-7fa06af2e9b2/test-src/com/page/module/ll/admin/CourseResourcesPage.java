package com.page.module.ll.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.locators.ll.admin.CourseResourcesLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;

public class CourseResourcesPage extends SafeActions implements CourseResourcesLocators{

	WebDriver driver;
	public CourseResourcesPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public DistrictSettingsPage clickOnDistrictSettingsTab()
	{
		safeClick(Dynamic.getNewLocator(TOOLS_SUBHEADINGS,"District Settings"), LONGWAIT);
		return new DistrictSettingsPage(driver);
	}
	public SchoolSettingsPage clickOnSchoolSettingsTab()
	{
		safeClick(Dynamic.getNewLocator(TOOLS_SUBHEADINGS,"School Settings"), LONGWAIT);
		return new SchoolSettingsPage(driver);
	}
	/**
	 * Purpose- To verify that course resources page is loaded with program planning tab
	 */
	public void verifyThatProgramPlanningTabIsLoaded()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(PROGRAMPLANNINGTAB_SELECTED, LONGWAIT), "By default program planning tab under course resources is not selected");
		Assert.assertTrue(isElementPresent(PROGRAMPLANNING_CONTENTS_TABLE, LONGWAIT), "Program planning tab under course resources is not loaded");
	}
	
	/**
	 * Purpose- To click on posters tab under Course Resources->Program planning section 
	 */
	
	public void clickOnProgramPlanningPostersTab()
	{		
		safeClick(POSTERS_TAB, LONGWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * Purpose- To verify that posters tab is selected
	 */
	
	public void verifyThatPostersTabIsSelected()
	{
		Assert.assertTrue(isElementPresent(POSTERSTAB_SELECTED, LONGWAIT), "The selected sub section tab,'Posters' under program planning section is not displayed as selected");
	}
	
	/**
	 * Purpose - To click on first PDF file under Course Resources->Program Planning section
	 */
	
	public void clickOnFirstPDFFileUnderProgramPlanningSection(boolean isChromeBrowser)
	{
		nullifyImplicitWait();
		if(isChromeBrowser){
		setImplicitWait(IMPLICITWAIT);
		safeClick(PROGRAM_PLANNINGTAB_PDFLINK, LONGWAIT);
		}
	}
	
	/**
	 * Purpose- To verify that page is loaded with video file and also to close the window
	 */
	
	public void verifyThePdfFileLoadPageAndClose(boolean isChromeBrowser,String pdfFileBrowserPartialUrl)
	{
		nullifyImplicitWait();
		if(isChromeBrowser)
		{
		setImplicitWait(IMPLICITWAIT);
		switchToWindow(1);
		waitForPageToLoad();
		String browserURL = driver.getCurrentUrl();
		Assert.assertTrue(browserURL.contains(pdfFileBrowserPartialUrl), "The currently opened pdf file URL("+browserURL+") doesn't contain the expected partial URL text("+pdfFileBrowserPartialUrl+")");
		driver.close();
		switchToWindow(0);	
		}
	}
	
	/**
	 * Purpose - To click on word training tab under Course Resources section
	 */
	
	public void clickOnWordTrainingTabUnderCourseResourcesSection()
	{
		safeClick(WORDTRAINING_TAB, LONGWAIT);
	}
	
	/**
	 * Purpose- To verify that word training tab is loaded
	 */
	
	public void verifyThatWordTrainingTabIsLoaded()
	{
		Assert.assertTrue(isElementPresent(WORDTRAININGTAB_SELECTED, LONGWAIT), "Word Training Tab under Course Resources section is not selected after clicking");
		Assert.assertTrue(isElementPresent(WORDTRAININGTAB_CONTENTES_TABLE, LONGWAIT), "Word Training Tab under Course Resources section is not loaded after clicking");
	}
	
	/**
	 * Purpose- To click on the level option
	 * @param levelToBeSelected
	 */
	
	public void clickOnLevelSelectionOption(String levelToBeSelected)
	{
		nullifyImplicitWait();
		if(getLocatorCount(Dynamic.getNewLocator(WORDTRAININGTAB_LEVEL_SELECTED, levelToBeSelected))==0)
		{
			safeClick(Dynamic.getNewLocator(WORDTRAININGTAB_LEVEL_SELECTION, levelToBeSelected), LONGWAIT);
			waitForPageToLoad();
			Assert.assertTrue(isElementPresent(WORDTRAININGTAB_CONTENTES_TABLE, LONGWAIT), "Word Training Tab under Course Resources section is not loaded after selecting the level("+levelToBeSelected+")");
		}
		
		setImplicitWait(IMPLICITWAIT);
	}
	
	/**
	 * Purpose - To click on word training unit number
	 * @param wordTrainingUnitNumber
	 */
	
	public void clickOnWordTrainingTabUnitNumber(String wordTrainingUnitNumber)
	{		
		nullifyImplicitWait();
		
		int unitNumberSelectedCount = getLocatorCount(Dynamic.getNewLocator(WORDTRAININGTAB_SHOW_UNITNUMBER_SELECTED, wordTrainingUnitNumber));
		if(unitNumberSelectedCount==0)
		{
		setImplicitWait(IMPLICITWAIT);
		safeClick(Dynamic.getNewLocator(WORDTRAININGTAB_SHOW_UNITNUMBER, wordTrainingUnitNumber), LONGWAIT);
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(WORDTRAININGTAB_CONTENTES_TABLE, LONGWAIT), "Word Training Tab under Course Resources section is not loaded after selecting the unit("+wordTrainingUnitNumber+")");
		}
	}
	
	/**
	 * Purpose - To open and verify the video file
	 * @throws InterruptedException 
	 */
	
	public void verifyWordTrainingVideoFile() 
	{
		Assert.assertTrue(isElementPresent(WORDTRAININGTAB_CONTENTES_TABLE, LONGWAIT), "Word Training Tab under Course Resources section is not loaded ");
		String clickedVideoFileName = safeGetText(WORDTRAINING_FIRSTVIDEO, LONGWAIT);
		safeClick(WORDTRAINING_FIRSTVIDEO, LONGWAIT);
		waitForPageToLoad();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(isElementPresent(WORDTRAINING_VIDEOPLAYER_HEADER, LONGWAIT), "video player is not displayed when clicked on the video file("+clickedVideoFileName+") under course resources word training tab");
		String playedVideoFileName = safeGetText(WORDTRAINING_VIDEOPLAYER_HEADER, LONGWAIT);
		Assert.assertEquals(clickedVideoFileName, playedVideoFileName, "clicked video file name ("+clickedVideoFileName+") doesn't match with played video file name ("+playedVideoFileName+") under word training tab of course resources page");
		refresh();
		waitForPageToLoad();
	}

	
	/**
	 * Purpose - To click on text training tab under Course Resources section
	 */
	
	public void clickOnTextTrainingTabUnderCourseResourcesSection()
	{
		safeClick(TEXTTRAINING_TAB, LONGWAIT);
	}
	
	/**
	 * Purpose- To verify that text training tab is loaded
	 */
	
	public void verifyThatTextTrainingTabIsLoaded()
	{
		Assert.assertTrue(isElementPresent(TEXTTRAININGTAB_SELECTED, LONGWAIT), "Text Training Tab under Course Resources section is not selected after clicking");
		Assert.assertTrue(isElementPresent(TEXTTRAINING_CONTENTES_TABLE, LONGWAIT), "Text Training Tab under Course Resources section is not loaded after clicking");
	}
	
	/**
	 * Purpose- To click on the level option under Text Training tab
	 * @param levelToBeSelected
	 */
	
	public void clickOnTTLevelSelectionOption(String levelToBeSelected)
	{
		nullifyImplicitWait();
		if(getLocatorCount(Dynamic.getNewLocator(TEXTTRAINING_LEVEL_SELECTED, levelToBeSelected))==0)
		{
			safeClick(Dynamic.getNewLocator(TEXTTRAINING_LEVEL_SELECTION, levelToBeSelected), LONGWAIT);
			waitForPageToLoad();
			Assert.assertTrue(isElementPresent(TEXTTRAINING_CONTENTES_TABLE, LONGWAIT), "Text Training Tab under Course Resources section is not loaded after selecting the level("+levelToBeSelected+")");
		}
		
		setImplicitWait(IMPLICITWAIT);
	}
	
	/**
	 * Purpose - To click on text training unit number
	 * @param textTrainingUnitNumber
	 */
	
	public void clickOnTextTrainingTabUnitNumber(String textTrainingUnitNumber)
	{	
		nullifyImplicitWait();
		
		int unitNumberSelectedCount = getLocatorCount(Dynamic.getNewLocator(TEXTTRAINING_SHOW_UNITNUMBER_SELECTED, textTrainingUnitNumber));
		if(unitNumberSelectedCount==0)
		{
		setImplicitWait(IMPLICITWAIT);
		
		safeClick(Dynamic.getNewLocator(TEXTTRAINING_SHOW_UNITNUMBER, textTrainingUnitNumber), LONGWAIT);
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(TEXTTRAINING_CONTENTES_TABLE, LONGWAIT), "Text Training Tab under Course Resources section is not loaded after selecting the unit("+textTrainingUnitNumber+")");
		}
	}
	
	/**
	 * Purpose - To open and verify the video file under Text training section
	 * @param textTrainingUnitNumber
	 * @throws InterruptedException 
	 */
	
	public void verifyTextTrainingVideoFile(String textTrainingUnitNumber) 
	{
		Assert.assertTrue(isElementPresent(TEXTTRAINING_CONTENTES_TABLE, LONGWAIT), "Text Training Tab under Course Resources section is not loaded");
		String clickedVideoFileName = safeGetText(Dynamic.getNewLocator(TEXTTRAINING_VIDEO_TOBEPLAYED, textTrainingUnitNumber), LONGWAIT);
		//safeClick(Dynamic.getNewLocator(TEXTTRAINING_VIDEO_TOBEPLAYED, textTrainingUnitNumber), LONGWAIT);
		safeJavaScriptClick(Dynamic.getNewLocator(TEXTTRAINING_VIDEO_TOBEPLAYED, textTrainingUnitNumber), LONGWAIT);
		waitForPageToLoad();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(isElementPresent(TEXTTRAINING_VIDEOPLAYER_HEADER, LONGWAIT), "video player is not displayed when clicked on the video file("+clickedVideoFileName+") under course resources text training tab");
		String playedVideoFileName = safeGetText(TEXTTRAINING_VIDEOPLAYER_HEADER, LONGWAIT);
		Assert.assertEquals(clickedVideoFileName, playedVideoFileName, "clicked video file name ("+clickedVideoFileName+") doesn't match with played video file name ("+playedVideoFileName+") under text training tab of course resources page");
		refresh();
		waitForPageToLoad();
	}
	/**
	 * This methods clicks on Social Settings tab
	 * @return
	 */

	public SocialSettingsPage clickOnSocialSettingsTab()
	{
		safeClick(Dynamic.getNewLocator(TOOLS_SUBHEADINGS,"Social Settings"), LONGWAIT);
		return new SocialSettingsPage(driver);
	}
	
}
