package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.locators.ll.teacherrole.TeacherCourseSightWordsLocators;
import com.selenium.SafeActions;

public class TeacherCourseSightWordsPage extends SafeActions implements TeacherCourseSightWordsLocators{

	private WebDriver driver;
	
	public TeacherCourseSightWordsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/**
	 * Purpose- To verify that sight words page is loaded for level 1
	 */
	
	public void verifyThatLevelOneSighWordsPageIsLoaded()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(SIGHTWORDS_IFRAME, LONGWAIT), "Sight words page is not loaded for level1");
		Assert.assertTrue(isElementPresent(SIGHTWORDS_USERLEVEL_ONE, LONGWAIT), "Sight words page is not loaded for level1");
	}
	
	/**
	 * Purpose- To navigate back to Course page from sight words page
	 */
	
	public TeacherRoleCoursePage navigateBackToCoursePageFromSightWordsPage()
	{	
		Assert.assertTrue(isElementPresent(SIGHTWORDS_USER_MENU_TABLE, LONGWAIT), "Usermenu section is not loaded after navigating to sightwords page");
		mouseHover(SIGHTWORDS_USER_MENU, LONGWAIT);
		safeClick(SIGTHWORDS_SUB_MENU_COURSE, LONGWAIT);
		return new TeacherRoleCoursePage(driver);
	}
	
	/**
	 * Purpose- To verify that sight words page is loaded for level 2
	 */
	
	public void verifyThatLevelTwoSighWordsPageIsLoaded()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(SIGHTWORDS_IFRAME, LONGWAIT), "Sight words page is not loaded for level2");
		Assert.assertTrue(isElementPresent(SIGHTWORDS_USERLEVEL_TWO, LONGWAIT), "Sight words page is not loaded for level2");
	}

}
