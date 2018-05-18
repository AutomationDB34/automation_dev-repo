package com.page.module.ll.teacherrole;
import org.openqa.selenium.WebDriver;

import com.page.locators.ll.teacherrole.TeacherToolsSocialSettingsLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherToolsSocialSettingsPage extends SafeActions implements TeacherToolsSocialSettingsLocators{

	private WebDriver driver;
	
	public TeacherToolsSocialSettingsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/**
	 * Purpose-- To verify that social settings page is loaded
	 */
	public void verifyThatSocialSettingsTabIsLoaded()
	{
	Assert.assertTrue(isElementPresent(SOCIALSETTINGSTAB_SELECTED, LONGWAIT), "Social Settings tab is not selected after clicking on it under Tools page");
	Assert.assertTrue(isElementPresent(SOCIALSETTINGS_SECTION, LONGWAIT), "Social Settings tab content is not loaded after clicking on it under Tools page");
	}
	
	/**
	 * Purpose-- To verify and enable class social settings under Social Settings tab
	 */
	
	public void verifyAndEnableAllClassSocialSettings()
	{
		
		Assert.assertTrue(isElementPresent(ENABLE_WALLPOSTING_CHECKBOX_CHECKED, LONGWAIT),"Enable wall posting for all students checkbox is not checked initially under Sociall Settings page");
		Assert.assertTrue(isElementPresent(ENABLE_FEEDBACKTAB_CHECKBOX_CHECKED, LONGWAIT),"Enable feedback tab for all students checkbox is not checked initially under Sociall Settings page");
		Assert.assertTrue(isElementPresent(ENABLE_PROFILES_CHECKBOX_CHECKED, LONGWAIT),"Enable profiles for all students checkbox is not checked initially under Sociall Settings page");
		Assert.assertTrue(isElementPresent(ENABLE_LEADERBOARDS_CHECKBOX_CHECKED, LONGWAIT),"Enable leaderboards for all students checkbox is checked initially under Sociall Settings page");		
		int totalStudentsInSocialSettingsTable = getLocatorCount(STUDENTS_SOCIALSETTINGS_COUNT);
		
		int totalWallPostingEnabledStudents = getLocatorCount(STUDENTS_WALLPOSTINGENABLED_COUNT);
		
		Assert.assertEquals(totalWallPostingEnabledStudents, totalStudentsInSocialSettingsTable, "Wall posting social settings are not enabled for all students. Total students displayed are("+totalStudentsInSocialSettingsTable+"),but wall posting checkbox is enabled only for("+totalWallPostingEnabledStudents+")");
		
		int totalProfileEnabledStudents = getLocatorCount(STUDENTS_WALLPOSTINGENABLED_COUNT);
		
		Assert.assertEquals(totalProfileEnabledStudents, totalStudentsInSocialSettingsTable, "Wall posting social settings are not enabled for all students. Total students displayed are("+totalStudentsInSocialSettingsTable+"),but wall posting checkbox is enabled only for("+totalProfileEnabledStudents+")");
		
		//safeClick(ENABLE_LEADERBOARDS_CHECKBOX, LONGWAIT);		
		//safeClick(APPLY_MAIN_BTN, LONGWAIT);		
		//waitForPageToLoad();	
		//Assert.assertTrue(isElementPresent(SOCIALSETTINGS_SECTION, LONGWAIT), "Social Settings tab content is not loaded after enabling 'leader boards' checkbox  and clicking  'Apply' button under Social Settings page");		
		//Assert.assertTrue(isElementPresent(ENABLE_LEADERBOARDS_CHECKBOX_CHECKED, LONGWAIT),"Enable leaderboards for all students checkbox is not checked even after selecting it and clicking 'Apply' button under Sociall Settings page");
		
	}

	/**
	 * Purpose- To verify student social settings for single student user
	 * @param studentLastName
	 */
	public void selectStudentSocialSettingsForSingleStudent(String studentLastName)
	{
		
		safeJavaScriptClick(Dynamic.getNewLocator(WALLPOSTING_CHECKBOX_SINGLESTUDENT, studentLastName), LONGWAIT);
		safeJavaScriptClick(Dynamic.getNewLocator(PROFILE_CHECKBOX_SINGLESTUDENT, studentLastName), LONGWAIT);
		safeJavaScriptClick(Dynamic.getNewLocator(SINGLE_STUDENT_APPLY_BTN, studentLastName), LONGWAIT);		
		safeJavaScriptClick(ENABLE_FEEDBACKTAB_CHECKBOX, LONGWAIT);
		safeJavaScriptClick(ENABLE_LEADERBOARDS_CHECKBOX, LONGWAIT);
		safeJavaScriptClick(APPLY_MAIN_BTN, LONGWAIT);
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(SOCIALSETTINGS_SECTION, LONGWAIT), "Social Settings tab content is not loaded after clicking apply button under social settings page");
		
	}
	
	/**
	 * Purpose - To revert back social settings to default settings
	 * @param studentLastName
	 */
	
	public void revertBackSocialSettingsToDefault(String studentLastName)
	{
		Assert.assertTrue(isElementPresent(SOCIALSETTINGS_SECTION, LONGWAIT), "Social Settings tab content is not loaded after clicking apply button under social settings page");
		safeCheck(Dynamic.getNewLocator(WALLPOSTING_CHECKBOX_SINGLESTUDENT, studentLastName), LONGWAIT);
		safeCheck(Dynamic.getNewLocator(PROFILE_CHECKBOX_SINGLESTUDENT, studentLastName), LONGWAIT);
		safeCheck(Dynamic.getNewLocator(SINGLE_STUDENT_APPLY_BTN, studentLastName), LONGWAIT);
		safeCheck(ENABLE_FEEDBACKTAB_CHECKBOX, LONGWAIT);
		safeClick(ENABLE_LEADERBOARDS_CHECKBOX, LONGWAIT);
		safeCheck(APPLY_MAIN_BTN, LONGWAIT);
		waitForSecs(4);
		Assert.assertTrue(isElementPresent(SOCIALSETTINGS_SECTION, LONGWAIT), "Social Settings tab content is not loaded after clicking apply button under social settings page");
	
		
	/*	
		Assert.assertTrue(isElementPresent(SOCIALSETTINGS_SECTION, LONGWAIT), "Social Settings tab content is not loaded after clicking apply button under social settings page");
		safeJavaScriptClick(Dynamic.getNewLocator(WALLPOSTING_CHECKBOX_SINGLESTUDENT, studentLastName), LONGWAIT);
		safeJavaScriptClick(Dynamic.getNewLocator(PROFILE_CHECKBOX_SINGLESTUDENT, studentLastName), LONGWAIT);
		safeJavaScriptClick(Dynamic.getNewLocator(SINGLE_STUDENT_APPLY_BTN, studentLastName), LONGWAIT);
		safeJavaScriptClick(ENABLE_FEEDBACKTAB_CHECKBOX, LONGWAIT);
		safeClick(ENABLE_LEADERBOARDS_CHECKBOX, LONGWAIT);
		safeJavaScriptClick(APPLY_MAIN_BTN, LONGWAIT);
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(SOCIALSETTINGS_SECTION, LONGWAIT), "Social Settings tab content is not loaded after clicking apply button under social settings page");
	*/
	}
}
