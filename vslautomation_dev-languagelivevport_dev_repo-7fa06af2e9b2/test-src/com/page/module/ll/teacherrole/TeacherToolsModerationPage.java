package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.teacherrole.TeacherToolsModerationLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherToolsModerationPage extends CommonFunctionalities implements TeacherToolsModerationLocators {

	private WebDriver driver;
	
	public TeacherToolsModerationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose - To verify that Moderation page is loaded
	 */
	
	public void verifyThatModerationTabIsLoaded()
	{
		Assert.assertTrue(isElementPresent(MODERATION_SECTION, LONGWAIT), "Moderation tab section under Tools tab is not loaded");
	}
	
	/**
	 * Purpose - To verify that flagged posts for students across the filters such as 'Abuse', 'All Posts'
	 */
	
	public void verifyFlaggedPostsForTeacher()
	{
		
		Assert.assertTrue(isElementPresent(MODERATION_SECTION, LONGWAIT), "Flagged list section under moderation tab is not loaded after clicking 'Abuse' filter");
		safeClick(MODERATION_ALLDAYS_FILTER, LONGWAIT);
		Assert.assertTrue(isElementPresent(MODERATION_SECTION, LONGWAIT), "Flagged list section under moderation tab is not loaded after clicking 'All' days filter");
		nullifyImplicitWait();
		Assert.assertEquals(getLocatorCount(NONOFFENSIVE_STUDENTS_COUNT), 0, "Non offensive flag posts are displayed when selected 'Abuse' filter");
		
		String firstAbuseStudentNameInTheList=safeGetText(FIRSTABUSESTUDENT_NAME, LONGWAIT).trim();
		
		safeClick(FIRSTABUSESTUDENT_MODERATE_BTN, LONGWAIT);
		
		String abuseStudentNameInTheReportDetailSection=safeGetText(ABUSEREPORTDETAIL_STUDENTNAME, LONGWAIT).trim();
		
		Assert.assertEquals(firstAbuseStudentNameInTheList, abuseStudentNameInTheReportDetailSection, "The student name("+firstAbuseStudentNameInTheList+")(for which moderate button is clicked) doesn't match with the student name("+abuseStudentNameInTheReportDetailSection+") being displayed under abuse report details section");
		
		safeClick(BACKTOMODERATIONOVERVIEW_BTN, LONGWAIT);
		
		Assert.assertTrue(isElementPresent(MODERATION_SECTION, LONGWAIT), "Flagged list section under moderation tab is not loaded after clicking 'Back To overview' link under Abuse Report Detail section");
		
		safeClick(MODERATION_ALLPOSTS_FILTER, LONGWAIT);
		Assert.assertTrue(isElementPresent(MODERATION_SECTION, LONGWAIT), "Flagged list section under moderation tab is not loaded after clicking 'All Posts' filter");
		nullifyImplicitWait();
		Assert.assertTrue(getLocatorCount(ABUSE_STUDENTS_COUNT)>0, "No abuse flagposts are displayed when selected the filter 'All Posts'");		
		Assert.assertTrue(getLocatorCount(NONOFFENSIVE_STUDENTS_COUNT)>0, "No non offensive flagposts are displayed when selected the filter 'All Posts'");		
			
	}
}
