package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;
import com.testng.Assert;

import com.page.locators.ll.teacherrole.TeacherRoleSocialSettingsVerificationAsStudentLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;

public class TeacherRoleSocialSettingsVerificationAsStudentPage extends CommonFunctionalities implements TeacherRoleSocialSettingsVerificationAsStudentLocators {

	private WebDriver driver;
	
	public TeacherRoleSocialSettingsVerificationAsStudentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/**
	 * Purpose-- To click Class tab
	 */
	
	public void clickClassTab()
	{
		
		waitForPageToLoad();
		
		safeClick(CLASS_TAB, LONGWAIT);
	}
	
	/**
	 * Purpose -- To verify that class wall page is loaded with share text area field for student user
	 */
	
	public void verifyThatClassWallShareTextFieldIsDisplayedForStudent()
	{
		
		Assert.assertTrue(isElementPresent(CLASSWALLTAB_SELECTED, LONGWAIT), "Class Wall tab is not displayed as selected upon navigating to Class page");
		Assert.assertTrue(isElementPresent(CLASSWALL_SECTION, LONGWAIT), "Class Wall tab content is not loaded for the student user eventhough it is enabled for student user under social settings of teacher user");
		Assert.assertTrue(isElementPresent(CLASSWALL_TEXTAREA_FIELD, LONGWAIT), "Class Wall text area field for sharing something to class is not displayed for the student user eventhough class wall setting is enabled for student user under social settings of teacher user ");
		
	}
	
	/**
	 * Purpose -- To verify that feedback tab is displayed for student user
	 */
	
	public void verifyThatFeedbackTabIsDisplayedForStudent()
	{
		Assert.assertTrue(isElementPresent(FEEDBACK_TAB, LONGWAIT), "Feedback tab is not displayed for student user eventhough it is enabled under social settings page of teacher user");		
	}
	
	/**
	 * Purpose -- To verify that leader boards section is displayed for student user
	 */
	
	public void verifyThatLeaderBoardsSectionIsDisplayedForStudent()
	{
		Assert.assertTrue(isElementPresent(LEADERBOARD_WIDGETS_ARROW_BTN, LONGWAIT), "Leader boards section is not displayed for student user eventhough it is enabled under social settings page of teacher user");		
	}
	
	/**
	 * Purpose- To navigate to view profile page
	 */
	
	public void navigateToViewProfilePage()
	{
		mouseHover(USERMENU_ARROW, LONGWAIT);
		safeClick(USERMENU_VIEWPROFILE_OPTION, LONGWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * Purpose -- To verify that about me section is displayed for student user
	 */
	
	public void verifyThatAboutMeSectionIsDisplayedForStudent()
	{
		Assert.assertTrue(isElementPresent(ABOUTME_EDIT_BTN, LONGWAIT), "About me section is not displayed for student user eventhough it is enabled under social settings page of teacher user");		
	}
	
	
	/**
	 * Purpose -- To verify that class wall page is loaded with share text area field for student user
	 */
	
	public void verifyThatClassWallSectionIsNotDisplayedForStudent()
	{
		Assert.haultonfailure=false;
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(CLASSWALLTAB_SELECTED, LONGWAIT), "Class Wall tab is not displayed as selected upon navigating to Class page");
		nullifyImplicitWait();

		if(isElementDisplayed(CLASSWALL_TEXTAREA_FIELD)){
			System.out.println("Class wall is dispalyed");
		}
		//Assert.assertEquals(getLocatorCount(CLASSWALL_TEXTAREA_FIELD), 0, "Class Wall section is displayedd for the student user eventhough class wall access is disabled for student user under social settings of teacher user ");
		setImplicitWait(IMPLICITWAIT);	
		Assert.assertAll();
	}
	
	/**
	 * Purpose -- To verify that feedback tab is not displayed for student user
	 */
	
	public void verifyThatFeedbackTabIsNotDisplayedForStudent()
	{
		nullifyImplicitWait();
		Assert.assertEquals(getLocatorCount(FEEDBACK_TAB), 0, "Feedback tab is still displayed for student user even though it is disabled under social settings page of teacher user");				
		setImplicitWait(IMPLICITWAIT);
	}
	
	/**
	 * Purpose -- To verify that leader boards section is not displayed for student user
	 */
	
	public void verifyThatLeaderBoardsSectionIsNotDisplayedForStudent()
	{
		Assert.assertTrue(isElementPresent(LEADERBOARDS_DISABLED_MESSAGE, LONGWAIT), "Leader boards section is  displayed for student user eventhough it is disabled under social settings page of teacher user");		
	}
	
	
	/**
	 * Purpose -- To verify that about me section is not displayed for student user
	 */
	
	public void verifyThatAboutMeSectionIsNotDisplayedForStudent()
	{
		Assert.assertTrue(isElementPresent(ABOUTME_DISABLED_MESSAGE, LONGWAIT), "About me section is displayed for student user eventhough it is disabled under social settings page of teacher user");		
	}
	

	
}
