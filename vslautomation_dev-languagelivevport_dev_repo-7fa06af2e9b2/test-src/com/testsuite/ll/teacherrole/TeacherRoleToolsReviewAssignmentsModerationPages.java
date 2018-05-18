package com.testsuite.ll.teacherrole;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.level1activities.TeacherHomePage.LLToolsTabReturnPage;
import com.page.module.ll.teacherrole.TeacherRoleReportsPage;
import com.page.module.ll.teacherrole.TeacherRoleStudentPowerPassTTActivityActions;
import com.page.module.ll.teacherrole.TeacherRoleToolsPage;
import com.page.module.ll.teacherrole.TeacherToolsAssignmentsPage;
import com.page.module.ll.teacherrole.TeacherToolsModerationPage;
import com.page.module.ll.teacherrole.TeacherToolsReviewFeedbackPage;
import com.page.module.ll.teacherrole.TeacherToolsReviewPage;
import com.selenium.Sync;
import com.testng.Retry;
import com.testsuite.ll.uniquegoals.ReadPassageGoalRecording;

public class TeacherRoleToolsReviewAssignmentsModerationPages extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLLogout lllogout;
	private TeacherRoleToolsPage teacherRoleToolsPage;
	private TeacherToolsReviewPage teacherToolsReviewPage;
	private TeacherToolsReviewFeedbackPage teacherToolsReviewFeedbackPage;
	private TeacherToolsAssignmentsPage teacherToolsAssignmentsPage;
	private TeacherToolsModerationPage teacherToolsModerationPage;
	private TeacherRoleReportsPage teacherRoleReportsPage;
	private TeacherHomePage teacherHomePage;
	private TeacherRoleStudentPowerPassTTActivityActions teacherRoleStudentPowerPassTTActivityActions;
	private StudentWelcomePage studentWelcomePage;
	private LLActivity llactivity;
	private boolean isStudentDisplayedWithReviewButton;
	private boolean isStudentDisplayedWithViewPowerPassFeedBack;
	ConfigManager dependentData = new ConfigManager("DependentData");
	

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llData = new LLData();
		llloginPage = new LLLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		
		teacherRoleStudentPowerPassTTActivityActions = new TeacherRoleStudentPowerPassTTActivityActions(getDriver());
		getDriver().manage().deleteAllCookies();
		// getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();
	}

	/**
	 * This test verifies that tools page is loaded with the tabs(Review,
	 * Assignments, Moderation, Course Resources, Class Settings and Social
	 * Settings) and their icons
	 */
	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_016_ToolsPagesVerification() {

		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools tab as teacher user
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify whether tools page is loaded or not
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// To verify that tools page is loaded with all it's tabs(review,
		// Assignments, Moderation, Course Resources, Class Settings, and Social
		// Settings) and icons
		teacherRoleToolsPage.verifyThatToolsTabIsLoadedWithAllTabsAndIcons();

		// Logout form the application
		teacherRoleToolsPage.clickLogoutfromHomePage();
		teacherRoleToolsPage.verifyLoginPage();
	}

	/**
	 * This test provides feedback for a student user under 'Reviews' tab of
	 * Tools->Review Page
	 */

	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LL_Teacher_017_ToolsReviewFeedbackForStudents() {

		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// Click on tools tab
		teacherRoleToolsPage = teacherHomePage.navigateToToolPage();
		// Navigate to reviews tab
		teacherToolsReviewPage = teacherRoleToolsPage.navigateReviewPage();
		// Selects class from class drop down under Reviews tab
		teacherToolsReviewPage.selectClassFromClassDropDown(llData.teacherRoleLLClassName);
		// To verify that review page is loaded after selecting the class
		teacherToolsReviewPage.verifyThatToolsReviewPageIsLoaded();
		// To verify that power pass part b student is displayed with review
		// button
		isStudentDisplayedWithReviewButton = teacherToolsReviewPage
				.isStudentDisplayedWithPowerPassReviewButton(llData.teacherRoleLLTTReviewFeedBackStudentLastName);
		// To assign activity for student user if student user not displayed
		// with review button

		teacherToolsReviewPage.runTTandWTgoals(isStudentDisplayedWithReviewButton, teacherRoleToolsPage  );

		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools tab as teacher user
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify whether tools page is loaded or not
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// Selects class from class drop down under Reviews tab
		teacherToolsReviewPage.selectClassFromClassDropDown(llData.teacherRoleLLClassName);

		// Clicks Review button for the input student
		teacherToolsReviewFeedbackPage = teacherToolsReviewPage
				.clickReviewButtonForTheStudent(llData.teacherRoleLLTTReviewFeedBackStudentLastName);
		// Verifies navigation to students feedback review page
		teacherToolsReviewFeedbackPage.verifyNavigationToReviewFeedBackPage();
		// Gives feedback for the student
		teacherToolsReviewFeedbackPage.giveFeedbackForStudent();
		// To verify that Tools review page is loaded successfully after
		// completing feedback for students
		teacherToolsReviewPage.verifyThatToolsReviewPageIsLoaded();
		// To verify that feedback completed student is removed from
		// Tools->Review->Reviews section
		teacherToolsReviewPage.verifyThatStudentUserIsRemovedFromFeedbackReviewList(
				llData.teacherRoleLLTTReviewFeedBackStudentLastName);

		// Logout form the application
		teacherToolsReviewPage.clickLogoutfromHomePage();
		teacherToolsReviewPage.verifyLoginPage();

	/*	// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacher_stdcreation,
				llData.teacher_stdcreation, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools tab as teacher user
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify whether tools page is loaded or not
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// Selects class from class drop down under Reviews tab
		teacherToolsReviewPage.selectClassFromClassDropDown(llData.teacherRoleLLClassName);
		teacherToolsReviewFeedbackPage = teacherToolsReviewPage
				.clickReviewButtonofGoal(dependentData.getProperty("ReadPassages_Student"));
		teacherToolsReviewFeedbackPage.verifyGoalFeedbackPage(dependentData.getProperty("ReadPassages_Student"));
		teacherToolsReviewFeedbackPage.giveFeedbackforWTGoal();
		// To verify that Tools review page is loaded successfully after
		// completing feedback for students
		teacherToolsReviewPage.verifyThatToolsReviewPageIsLoaded();
		
		// To verify that feedback completed student is removed from
		// Tools->Review->Reviews section
		teacherToolsReviewPage.verifyThatStudentUserIsRemovedFromFeedbackReviewList(
				dependentData.getProperty("ReadPassages_Student"));

		// Logout form the application
		teacherToolsReviewPage.clickLogoutfromHomePage();
		teacherToolsReviewPage.verifyLoginPage();*/

	}

	/**
	 * This test verifies that Alerts tab under 'Reviews' tab of Tools->Review
	 * Page is loaded with a student with auto pass and review button enabled
	 * 
	 * @throws Exception
	 */

	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_018_ToolsReviewAlertsStudentVerification() {

		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// Click on tools tab
		teacherRoleToolsPage = teacherHomePage.navigateToToolPage();
		// Navigate to reviews tab
		teacherToolsReviewPage = teacherRoleToolsPage.navigateReviewPage();
		// click on 'Alerts' tab under Tools->Review section
		teacherToolsReviewPage.clickOnAlertsTab();
		// To verify that alerts tab is loaded
		teacherToolsReviewPage.verifyThatAlertsTabIsLoaded();
		// To verify the alerts tab with a student having auto pass and review
		// button
		teacherToolsReviewPage.verifyThatAlertsTabIsLoadedWithAutoPassAndReviewStudent(
				llData.teacherRoleLLAlertsAutoPassStudentLastName);

		// Logout form the application
		teacherToolsReviewPage.clickLogoutfromHomePage();
		teacherToolsReviewPage.verifyLoginPage();
	}

	/**
	 * This test adds assignment for a student and verifies assignment
	 * score(only practice activity) also
	 */
	@Test(groups = { "RC", "QC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_019_ToolsAssignmentsVerification() {

		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// Click on tools tab
		teacherRoleToolsPage = teacherHomePage.navigateToToolPage();
		// clicks on 'Assignments' link under Tools tab
		teacherToolsAssignmentsPage = teacherRoleToolsPage.clickOnAssignmentsTab();
		// To verify that Assignments tab is loaded successfully
		teacherToolsAssignmentsPage.verifyThatAssignmentsTabIsLoaded();
		// To select a class from class drop down under Assignments section
		teacherToolsAssignmentsPage.selectClassFromClassDropDown(llData.teacherRoleLLClassName);
		// To click on student unit number under Assignments section
		teacherToolsAssignmentsPage.clickOnStudentUnitNumberUnderAssignmentsSection(llData.teacherRoleLLStudentTTUnit);
		// To verify that Assignments tab is loaded successfully after clicking
		// unit number
		teacherToolsAssignmentsPage.verifyThatAssignmentsTabIsLoaded();
		// To assign text and verify assign text score for students
		/*
		 * teacherToolsAssignmentsPage.
		 * assignTextAndVerifyAssignTextScoreForStudents(llData.
		 * teacherRoleLLStudentLastName,
		 * llData.teacherRoleLLStudentTTPracticeActivity,
		 * llData.teacherRoleLLStudentTTPracticeActivityScore,
		 * llData.teacherRoleLLAssignmentsAssignTextStudentLastName);
		 */

		teacherToolsAssignmentsPage.toolsAssignmentsVerification(llData);

		// Logout form the application
		teacherToolsAssignmentsPage.clickLogoutfromHomePage();
		teacherToolsAssignmentsPage.verifyLoginPage();
	}

	/**
	 * This test verifies flagged posts filtering across the filters under
	 * 'Moderation' tab of Tools page
	 */

	@Test(groups = { "RC", "QC" }, priority = 5, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_020_ToolsModerationVerification() {

		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// Click on tools tab
		teacherRoleToolsPage = teacherHomePage.navigateToToolPage();
		// clicks on 'Moderation' link under Tools tab
		teacherToolsModerationPage = teacherRoleToolsPage.clickOnModerationTab();
		// To verify whether the moderation page is loaded or not
		teacherToolsModerationPage.verifyThatModerationTabIsLoaded();
		// To verify the moderation flag posts for student users
		teacherToolsModerationPage.verifyFlaggedPostsForTeacher();

		// Logout form the application
		teacherToolsModerationPage.clickLogoutfromHomePage();
		teacherToolsModerationPage.verifyLoginPage();
	}

}
