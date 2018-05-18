package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;
import com.testng.Assert;

import com.page.locators.ll.teacherrole.TeacherRoleViewProfileLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;

public class TeacherRoleViewProfilePage extends CommonFunctionalities implements TeacherRoleViewProfileLocators {

	private WebDriver driver;
	public TeacherRoleViewProfilePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose- To verify that View Profile page is loaded successfully
	 */
	
	public void verifyThatViewProfilePageIsLoaded()
	{
		waitForSecs(10);
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(ABOUT_ME_TAB_SELECTED, LONGWAIT), "About me tab is not being displayed as highlighted upon navigating to View Profile as teacher user");
		Assert.assertTrue(isElementPresent(ABOUT_ME_CONTENT_SECTION, LONGWAIT), "About me tab content is not being displayed upon navigating to View Profile as teacher user");
		waitForSecs(10);
		waitForPageToLoad();
	}
	
	/**
	 * Purpose- To verify that view profile page is displayed with all tabs(About me, Achievements, Classmates and Avatar Editor) and their icons
	 */
	
	public void verifyThatViewProfilePageIsLoadedWithAllTabsAndIcons()
	{
		Assert.assertTrue(isElementPresent(ABOUT_ME_TAB, LONGWAIT), "About me tab is not displayed under View Profile page");
		Assert.assertTrue(isElementPresent(ABOUT_ME_TAB_ICON, LONGWAIT), "About me tab icon is not displayed under View Profile page");
		Assert.assertTrue(isElementPresent(ACHIEVEMENTS_TAB, LONGWAIT), "Achievements tab is not displayed under View Profile page");
		Assert.assertTrue(isElementPresent(ACHIEVEMENTS_TAB_ICON, LONGWAIT), "Achievements tab icon is not displayed under View Profile page");
		Assert.assertTrue(isElementPresent(CLASSMATES_TAB, LONGWAIT), "Classmates tab is not displayed under View Profile page");
		Assert.assertTrue(isElementPresent(CLASSMATES_TAB_ICON, LONGWAIT), "Classmates tab icon is not displayed under View Profile page");
		Assert.assertTrue(isElementPresent(AVATAR_EDITOR_TAB, LONGWAIT), "Avatar Editor tab is not displayed under View Profile page");
		Assert.assertTrue(isElementPresent(AVATAR_EDITOR_TAB_ICON, LONGWAIT), "Avatar Editor tab icon is not displayed under View Profile page");
		
		
	}
	
	/**
	 * Purpose- To click on Achievements tab under view profile page
	 */
	
	public TeacherViewProfileAchievementsPage clickOnAchievementsTab()
	{
		safeClick(ACHIEVEMENTS_TAB, LONGWAIT);
		waitForSecs(20);
		waitForPageToLoad();
		return new TeacherViewProfileAchievementsPage(driver);
	}
	
	/**
	 * Purpose- To click on Classmates tab under view profile page
	 */
	
	public TeacherViewProfileClassmatesPage clickOnClassmatesTab()
	{
		safeClick(CLASSMATES_TAB, LONGWAIT);
		waitForSecs(20);
		waitForPageToLoad();
		return new TeacherViewProfileClassmatesPage(driver);
	}
	
	/**
	 * Purpose- To click on Avatar Editor tab under view profile page
	 */
	
	public TeacherViewProfileAvatarEditorPage clickOnAvatarEditorTab()
	{
		waitForSecs(10);
		waitForPageToLoad();
		safeClick(AVATAR_EDITOR_TAB, LONGWAIT);
		
		return new TeacherViewProfileAvatarEditorPage(driver);
	}
	/**
	 * Purpose- To click on Aboutme tab tab under view profile page
	 */
	
	public TeacherViewProfileAboutMePage clickOnAboutMeTab()
	{
		waitForSecs(10);
		waitForPageToLoad();
		safeClick(ABOUT_ME_TAB, LONGWAIT);
		waitForSecs(20);
		waitForPageToLoad();
		return new TeacherViewProfileAboutMePage(driver);
	}
}
