package com.testsuite.ll.admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherCourseSightWordsPage;
import com.page.module.ll.teacherrole.TeacherRoleCoursePage;
import com.selenium.Sync;
import com.testng.Retry;

public class LLDistrictUserCoursePageScenarios extends BaseSetup {
	private LLData llData;
	private LLLoginPage llLoginPage;
	private LLLogout lllogout;
	private TeacherHomePage teacherHomePage;
	private LLActivity llactivity;
	LLHomePage llHomePage;
	private TeacherRoleCoursePage teacherRoleCoursePage;
	private TeacherCourseSightWordsPage teacherCourseSightWordsPage;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llData = new LLData();
		llLoginPage = new LLLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();

	}

	/**
	 * This test selects Level1 on Course page and completes the activity named
	 * 'Listen and Identify' under 'Word Training Tab'
	 * 
	 * @throws Exception
	 */

	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_037_CourseLevel1WordTrainingPageScenarios() {

		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL, llData.llDistrictAdmin,
				llData.llDistrictAdmin, LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Courses Tab
		teacherRoleCoursePage = llHomePage.clickOnCoursesTab();

		// To verify that Course page is loaded successfully
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// To select Level1 option
		teacherRoleCoursePage.clickOnLevelOneOption();
		// To verify that word training tab content is loaded successfully
		teacherRoleCoursePage.verifyThatWordTrainingTabIsLoadedForLevel1();
		// Complete the activity under word training tab
		teacherRoleCoursePage.completeWTActivityAndVerifySummaryMessageInLevel1();

	}

	@Test(groups = { "RC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LLDISTRICTUSER_038_CourseLevel1TextTrainingScenarios() {
		// Step1: Login into application
		// https://qa.languagelive.voyagersopris.com/services/logon
		// Step2: After completion of Implementation cards
		// Step3: User displayed with reports pages
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL, llData.llDistrictAdmin,
				llData.llDistrictAdmin, LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyDashBoardTab();

		// Step4: User should navigate to Course page through navigation bar.
		teacherRoleCoursePage = llHomePage.clickOnCoursesTab();
		// To verify that Course page is loaded successfully
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// Step5:User displayed with Level 1 & level 2 options
		// Step6: User by default displayed with Level 1 Word training course.
		teacherRoleCoursePage.clickOnLevelOneOption();
		// Step7: User able to select text training tab
		teacherRoleCoursePage.navigateToTextTrainingTab();
		// Step8: User displayed with Text training course links.
		teacherRoleCoursePage.verifyThatTextTrainingTabIsLoadedForLevel1();
		// Step9: Complete any of the TT activity
		// Step 10: After completion of the activity user should not displayed
		// with summary page and message should be displayed which conveys that
		// district user should not contain summary page.
		teacherRoleCoursePage.completeTTActivityAndVerifySummaryMessageForLevel1(
				llData.teacherRoleLLCourseTTSortNounAndVerbsNounArea, isIexploreBrowser());
		// Logout form the application
		teacherRoleCoursePage.clickLogoutfromHomePage();
		teacherRoleCoursePage.verifyLoginPage();

	}

	@Test(groups = { "RC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LLDITRICTUSER_039_CourseLevel2WordTrainingScenarios() {
		// Step1: Login into application
		// https://qa.languagelive.voyagersopris.com/services/logon
		// Step2: After completion of Implementation cards
		// Step3: User displayed with reports pages
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL, llData.llDistrictAdmin,
				llData.llDistrictAdmin, LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyDashBoardTab();

		// Step4: User should navigate to Course page through navigation bar.
		teacherRoleCoursePage = llHomePage.clickOnCoursesTab();
		// To verify that Course page is loaded successfully
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// Step5:User displayed with Level 1 & level 2 options
		// Step6: User by default displayed with Level 2 Word training course.
		teacherRoleCoursePage.clickOnLevelTwoOption();
		// Step7: User able to select text training tab
		teacherRoleCoursePage.navigateToWordTrainingTab();
		// Step8: User displayed with Text training course links.
		teacherRoleCoursePage.verifyThatWordTrainingTabIsLoadedForLevel2();
		// Step9: Complete any of the TT activity
		// Step 10: After completion of the activity user should not displayed
		// with summary page and message should be displayed which conveys that
		// district user should not contain summary page.
		teacherRoleCoursePage.completeWTActivityAndVerifySummaryMessageInLevel2();
		// Logout form the application
		teacherRoleCoursePage.clickLogoutfromHomePage();
		teacherRoleCoursePage.verifyLoginPage();
	}

	/**
	 * This test selects Level2 on Course page and completes the activity named
	 * Sort(Nouns and Verbs) under 'Text Training Tab'
	 * 
	 * @throws Exception
	 */

	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_040_CourseLevel2TextTrainingPageScenarios() throws Exception {
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL, llData.llDistrictAdmin,
				llData.llDistrictAdmin, LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Courses Tab
		teacherRoleCoursePage = llHomePage.clickOnCoursesTab();

		// To select Level2 option
		teacherRoleCoursePage.clickOnLevelTwoOption();
		// To navigate to text training tab for level1
		teacherRoleCoursePage.navigateToTextTrainingTab();
		// To verify that text training tab content is loaded successfully
		teacherRoleCoursePage.verifyThatTextTrainingTabIsLoadedForLevel2();
		// Complete the activity under Text training tab
		teacherRoleCoursePage.completeTTActivityAndVerifySummaryMessageForLevel2(
				llData.teacherRoleLLCourseTTSortNounAndVerbsNounArea, isIexploreBrowser());
		// Logout form the application
		teacherRoleCoursePage.clickLogoutfromHomePage();
		teacherRoleCoursePage.verifyLoginPage();
	}

	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_041_CourseSightWordsScenarios() {
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL, llData.llDistrictAdmin,
				llData.llDistrictAdmin, LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Courses Tab
		teacherRoleCoursePage = llHomePage.clickOnCoursesTab();
		// To verify that Course page is loaded successfully
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// To click on level 1 under course page
		teacherRoleCoursePage.clickOnLevelOneOption();
		// To click on sight words link
		teacherCourseSightWordsPage = teacherRoleCoursePage.clickOnSightWordsLink();
		// To verify that sight words page is loaded for level1
		teacherCourseSightWordsPage.verifyThatLevelOneSighWordsPageIsLoaded();
		// To navigate back to Course page from sight words page
		teacherRoleCoursePage = teacherCourseSightWordsPage.navigateBackToCoursePageFromSightWordsPage();
		// To verify that Course page is loaded successfully
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// To click on Level 2 option under Course page
		teacherRoleCoursePage.clickOnLevelTwoOption();
		// To verify that Course page is loaded successfully after selecting the
		// level 2
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// To click on sight words link
		teacherCourseSightWordsPage = teacherRoleCoursePage.clickOnSightWordsLink();
		// To verify that sight words page is loaded for level2
		teacherCourseSightWordsPage.verifyThatLevelTwoSighWordsPageIsLoaded();
		// To navigate back to Course page from sight words page
		teacherRoleCoursePage = teacherCourseSightWordsPage.navigateBackToCoursePageFromSightWordsPage();
		// To verify that Course page is loaded successfully
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// Logout form the application
		teacherRoleCoursePage.clickLogoutfromHomePage();
		teacherRoleCoursePage.verifyLoginPage();

	}
	/*
	 * @AfterMethod(alwaysRun = true) public void logout() {
	 * 
	 * LLLogout lllogout = new LLLogout(getDriver()); llLoginPage =
	 * lllogout.clickLogoutfromActivty(); llLoginPage.verifyLoginPage(); }
	 */

}
