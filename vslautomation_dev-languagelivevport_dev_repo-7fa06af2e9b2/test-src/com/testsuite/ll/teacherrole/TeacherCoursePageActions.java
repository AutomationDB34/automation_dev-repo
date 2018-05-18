package com.testsuite.ll.teacherrole;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherCourseSightWordsPage;
import com.page.module.ll.teacherrole.TeacherRoleCoursePage;
import com.selenium.Sync;
import com.testng.Retry;

public class TeacherCoursePageActions extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLLogout lllogout;
	private TeacherHomePage teacherHomePage;
	private LLActivity llactivity;
	private TeacherRoleCoursePage teacherRoleCoursePage;
	private TeacherCourseSightWordsPage teacherCourseSightWordsPage;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llData = new LLData();
		llloginPage = new LLLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		getDriver().manage().deleteAllCookies();
		// getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();
	}

	/**
	 * This test selects Level1 on Course page and completes the activity named
	 * 'Sort (Nouns and Verbs)' under 'Text Training Tab'
	 */

	@Test(groups = { "RC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL_Teacher_031_CourseL1WordTrainingActivityVerification() {
		// To verify login page
		// Step1: To enter credentials and click on submit button of teacher
		// user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// Step2: To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// Step3: navigate to course page
		teacherRoleCoursePage = (TeacherRoleCoursePage) teacherHomePage.clickOnCourseTab();
		// To verify that Course page is loaded successfully
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// Step4: To select Level1 option
		teacherRoleCoursePage.clickOnLevelOneOption();
		// Step5: To navigate to Word training tab for level1
		teacherRoleCoursePage.navigateToWordTrainingTab();
		// Step6: Click on any of the activity link of Word training
		teacherRoleCoursePage.completeWTActivityAndVerifySummaryMessageInLevel1();
		// Logout form the application
		teacherRoleCoursePage.clickLogoutfromHomePage();
		teacherRoleCoursePage.verifyLoginPage();
	}

	/**
	 * This test selects Level1 on Course page and completes the activity named
	 * 'Sort (Nouns and Verbs)' under 'Text Training Tab'
	 */

	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LL_Teacher_032_CourseL1TextTrainingActivityVerification() {
		// To verify login page
		// To enter credentials and click on submit button of teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Course link/tab
		teacherRoleCoursePage = (TeacherRoleCoursePage) teacherHomePage.clickOnCourseTab();
		// To verify that Course page is loaded successfully
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// To select Level1 option
		teacherRoleCoursePage.clickOnLevelOneOption();
		// To navigate to text training tab for level1
		teacherRoleCoursePage.navigateToTextTrainingTab();
		// To verify that text training tab content is loaded successfully
		teacherRoleCoursePage.verifyThatTextTrainingTabIsLoadedForLevel1();
		// Complete the activity under Text training tab
		teacherRoleCoursePage.completeTTActivityAndVerifySummaryMessageForLevel1(
				llData.teacherRoleLLCourseTTSortNounAndVerbsNounArea, isIexploreBrowser());
		// Logout form the application
		teacherRoleCoursePage.clickLogoutfromHomePage();
		teacherRoleCoursePage.verifyLoginPage();
	}

	/**
	 * This test selects Level2 on Course page and completes the activity named
	 * 'Listen and Identify' under 'Word Training Tab'
	 */

	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_033_CourseL2WordTrainingActivityVerification() {

		// To verify login page
		// To enter credentials and click on submit button of teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Course link/tab
		teacherRoleCoursePage = (TeacherRoleCoursePage) teacherHomePage.clickOnCourseTab();
		// To verify that Course page is loaded successfully
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// To select Level2 option
		teacherRoleCoursePage.clickOnLevelTwoOption();
		// To verify that word training tab content is loaded successfully
		teacherRoleCoursePage.verifyThatWordTrainingTabIsLoadedForLevel2();
		// Complete the activity under word training tab
		teacherRoleCoursePage.completeWTActivityAndVerifySummaryMessageInLevel2();

		// Logout form the application
		teacherRoleCoursePage.clickLogoutfromHomePage();
		teacherRoleCoursePage.verifyLoginPage();
	}

	/**
	 * This test selects Level2 on Course page and completes the activity named
	 * 'Listen and Identify' under 'Word Training Tab'
	 */

	@Test(groups = { "RC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_034_CourseL2TextTrainingActivityVerification() {

		// To verify login page
		// To enter credentials and click on submit button of teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Course link/tab
		teacherRoleCoursePage = (TeacherRoleCoursePage) teacherHomePage.clickOnCourseTab();
		// To verify that Course page is loaded successfully
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// To select Level2 option
		teacherRoleCoursePage.clickOnLevelTwoOption();
		teacherRoleCoursePage.navigateToTextTrainingTab();
		// To verify that word training tab content is loaded successfully
		teacherRoleCoursePage.verifyThatTextTrainingTabIsLoadedForLevel2();
		// Complete the activity under word training tab
		teacherRoleCoursePage.completeTTActivityAndVerifySummaryMessageForLevel2(
				llData.teacherRoleLLCourseTTSortNounAndVerbsNounArea, isIexploreBrowser());

		// Logout form the application
		teacherRoleCoursePage.clickLogoutfromHomePage();
		teacherRoleCoursePage.verifyLoginPage();
	}

	/**
	 * Purpose is to verify the sound library icon available for Teacher in
	 * course tab
	 */
	@Test(groups = { "RC"}, priority = 5, retryAnalyzer = Retry.class)
	public void LL_Teacher_035_CourseSoundLibraryiconVerification() {
		// To verify login page
		// Step1: To enter credentials and click on submit button of teacher
		// user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// Step2: To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// Step3: navigate to course page
		teacherRoleCoursePage = (TeacherRoleCoursePage) teacherHomePage.clickOnCourseTab();
		// To verify that Course page is loaded successfully
		teacherRoleCoursePage.verifyThatCoursePageIsLoaded();
		// Step4: To select Level1 option
		teacherRoleCoursePage.clickOnLevelOneOption();
		teacherRoleCoursePage.clickOnSoundLibraryLink();
		teacherRoleCoursePage.verifyConsonantAndVowelSections();
	}

	/**
	 * This test clicks sight words link under both the levels (level1 and
	 * level2) of Course page and verifies the navigation to respective level
	 * sight words page
	 */

	@Test(groups = { "RC", "QC" }, priority = 6, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_036_CourseSightWordsVerification() {
		// To verify login page
		// To enter credentials and click on submit button of teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Course link/tab
		teacherRoleCoursePage = (TeacherRoleCoursePage) teacherHomePage.clickOnCourseTab();
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
}
