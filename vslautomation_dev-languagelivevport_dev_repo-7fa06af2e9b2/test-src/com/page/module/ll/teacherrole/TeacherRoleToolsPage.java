package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.teacherrole.TeacherRoleToolsPageLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherRoleToolsPage extends CommonFunctionalities implements TeacherRoleToolsPageLocators {

	private WebDriver driver;

	public TeacherRoleToolsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose - To verify that Tools page is loaded
	 */

	public void verifyThatToolsPageIsLoaded() {
		Assert.assertTrue(isElementPresent(REVIEWTAB_SELECTED, LONGWAIT),
				"Tools page is not loaded after clicking Tools tab");
		Assert.assertTrue(isElementPresent(REVIEWSTAB_STUDENTS_TABLE, LONGWAIT),
				"Reports->Review tab page is not loaded after clicking Tools tab");
		waitForPageToLoad();
	}

	/**
	 * Purpose- To verify that Tools page is displayed with all tabs and their
	 * icons
	 */

	public TeacherToolsReviewPage verifyThatToolsTabIsLoadedWithAllTabsAndIcons() {

		Assert.assertTrue(isElementPresent(REVIEW_TAB, LONGWAIT), "Review tab is not displayed under Tools tab");
		Assert.assertTrue(isElementPresent(REVIEWTAB_ICON, LONGWAIT),
				"Review tab icon is not displayed under Tools tab");
		Assert.assertTrue(isElementPresent(ASSIGNMENTS_TAB, LONGWAIT),
				"Assignments tab is not displayed under Tools tab");
		Assert.assertTrue(isElementPresent(ASSIGNMENTSTAB_ICON, LONGWAIT),
				"Assignments tab icon is not displayed under Tools tab");
		Assert.assertTrue(isElementPresent(MODERATION_TAB, LONGWAIT),
				"Moderation tab is not displayed under Tools tab");
		Assert.assertTrue(isElementPresent(MODERATIONTAB_ICON, LONGWAIT),
				"Moderation tab icon is not displayed under Tools tab");
		Assert.assertTrue(isElementPresent(COURSERESOURCES_TAB, LONGWAIT),
				"Course Resources tab is not displayed under Tools tab");
		Assert.assertTrue(isElementPresent(COURSERESOURCESTAB_ICON, LONGWAIT),
				"Course Resources tab icon is not displayed under Tools tab");
		Assert.assertTrue(isElementPresent(CLASSSETTINGS_TAB, LONGWAIT),
				"Class Settings tab is not displayed under Tools tab");
		Assert.assertTrue(isElementPresent(CLASSSETTINGSTAB_ICON, LONGWAIT),
				"Class Settings tab icon is not displayed under Tools tab");
		Assert.assertTrue(isElementPresent(SOCIALSETTINGS_TAB, LONGWAIT),
				"Social Settings tab is not displayed under Tools tab");
		Assert.assertTrue(isElementPresent(SOCIALSETTINGSTAB_ICON, LONGWAIT),
				"Social Settings tab icon is not displayed under Tools tab");


		return new TeacherToolsReviewPage(driver);
	}

	/**
	 * Purpose - To click on the Assignments tab
	 */

	public TeacherToolsAssignmentsPage clickOnAssignmentsTab() {
		safeClick(ASSIGNMENTS_TAB, LONGWAIT);

		return new TeacherToolsAssignmentsPage(driver);
	}

	/**
	 * Purpose - To click on the Moderation tab
	 */

	public TeacherToolsModerationPage clickOnModerationTab() {
		safeClick(MODERATION_TAB, LONGWAIT);

		return new TeacherToolsModerationPage(driver);
	}

	/**
	 * Purpose- To click on Course Resources link or tab
	 */

	public TeacherToolsCourseResourcesPage clickOnCourseResourcesTab() 
	{
		waitForSecs(10);
		safeClick(COURSERESOURCES_TAB, LONGWAIT);
		waitForSecs(10);
		return new TeacherToolsCourseResourcesPage(driver);
	}

	/**
	 * Purpose - To click on Class Settings tab
	 */

	public TeacherToolsClassSettingsPage clickOnClassSettingsTab() {
		safeClick(CLASSSETTINGS_TAB, LONGWAIT);

		return new TeacherToolsClassSettingsPage(driver);
	}

	/**
	 * Purpose - To click on Class Settings tab
	 */

	public TeacherToolsSocialSettingsPage clickOnSocialSettingsTab() {
		safeClick(SOCIALSETTINGS_TAB, LONGWAIT);

		return new TeacherToolsSocialSettingsPage(driver);
	}

	public TeacherToolsReviewPage navigateReviewPage() {
		refresh();
		safeClick(TOOLS_TAB);
		safeClick(REVIEW_TAB);
		return new TeacherToolsReviewPage(driver);
	}
}
