package com.testsuite.ll.teacherrole;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherReportsCourseReportsPage;
import com.page.module.ll.teacherrole.TeacherReportsDashboardPage;
import com.page.module.ll.teacherrole.TeacherRoleReportsPage;
import com.page.module.ll.teacherrole.TeacherWelComePage;
import com.page.module.vport.DistrictAdminHomepage;
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportLogoutPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class TeacherRoleReportsDashboardCourseReports extends BaseSetup {

	private LLData llData;
	private TeacherWelComePage teacherWelComePage;
	private LLLoginPage llloginPage;
	private LLLogout lllogout;
	private TeacherHomePage teacherHomePage;
	private TeacherReportsDashboardPage teacherReportsDashboardPage;
	private TeacherReportsCourseReportsPage teacherReportsCourseReportsPage;
	private TeacherRoleReportsPage teacherRoleReportsPage;
//	private int studentUnitAndFloorValues[];
	private VportLoginPage vportloginpage;
	private VportData vportData;
	private DistrictAdminHomepage districtAdminHomepage;
	private DistrictAdminMySchoolPage districtAdminMySchoolPage;
	private String teacheruserId;
	ConfigManager dependentData = new ConfigManager("DependentData");

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception 
	{
		llData = new LLData();
		vportData = new VportData();
		llloginPage = new LLLoginPage(getDriver());
		vportloginpage = new VportLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		getDriver().manage().deleteAllCookies();
		//getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();
	}

	/**
	 * This test creates new teacher and verifies welcome screen after first
	 * time log in. Also attempts second time login and verifies that welcome
	 * page is not displayed second time
	 */

	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_001_WelComePageActions() {
		// To create new teacher user in Vport application
		teacheruserId = llloginPage.createNewTeacher(vportloginpage);
		// To launch language live URL
		// Verifies login page
		// Enters login credentials
		teacherWelComePage = (TeacherWelComePage) llloginPage.loginCredentials(llData.URL,teacheruserId, teacheruserId,
				LLLoginReturnPage.NEW_TEACHER_WELCOME_PAGE);
		// Verifies welcome page for the teacher user
		teacherWelComePage.verifyWelComePageForTeacherUser();
		// Select Options on Teacher WelCome page(Training Option, Terms of Use
		// Check box and Clicking continue button)
		teacherHomePage = teacherWelComePage.selectOptionsOnTeacherWelComePage(llData.newTeacherLLTrainingOption);
		// Verifies teacher login
		teacherHomePage.verifyNewTeacherLogin();
		// Logout as teacher user
		llloginPage = lllogout.clickLogoutfromHomePage();
		// Verifies login page
		llloginPage.verifyLoginPage();
		// Enters credentials for the same teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,teacheruserId, teacheruserId,
				LLLoginReturnPage.TEACHER_HOME_PAGE);
		// Verifies that welcome page is not displayed second time for the
		// teacher user
		teacherHomePage.verifyWelComePageNotDisplayedSecondTime();
		// Logout as teacher user
		llloginPage = lllogout.clickLogoutfromHomePage();
	}

	/**
	 * This test verifies that Reports page is loaded with all tabs(Dashboard,
	 * Course Reports, Benchmark reports, Parent Report, District Overview and
	 * Score details) and their icons
	 */

	@Test(groups = { "RC","QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_002_ReportsPageVerification() {
		// To verify login page
		// To login as existing teacher user
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// To verify that reports page is loaded successfully
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// To verify that reports page is displayed with all tabs and icons
		teacherRoleReportsPage.verifyReportsPageDisplayedWithAllTabsAndIcons();
		// Logout form the application
		teacherRoleReportsPage.clickLogoutfromHomePage();
		teacherRoleReportsPage.verifyLoginPage();

	}

	/**
	 * This test selects class on Reports->Dashboard page and verifies word
	 * training status for a student user
	 */
	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_003_ReportsDashboardSelectClassAndVerifyStudentProgress() {
		// To verify login page
		// To login as existing teacher user
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// To verify that reports page is loaded successfully
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// Navigate to the Dashboard page
		teacherReportsDashboardPage = teacherRoleReportsPage.navigateToDashboardPage();

		// Selects a class from class drop down being displayed on Reports->Dash
		// board section

		teacherReportsDashboardPage.selectClassFromClassDropdown(llData.teacherRoleLLClassName);
		// Verifies the student progress such as level,unit and lesson values
		teacherReportsDashboardPage.verifyStudentProgressUnderTheSelectedClass(llData.teacherRoleLLStudentLastName,
				llData.teacherRoleLLStudentWTLevel, llData.teacherRoleLLStudentWTLesson);

		// Logout form the application
		teacherReportsDashboardPage.clickLogoutfromHomePage();
		teacherReportsDashboardPage.verifyLoginPage();
	}

	/**
	 * This test verifies navigation to Reviews,Course Alert tabs,Time On Task
	 * and Items Completed.
	 */

	@Test(groups = { "RC", "QC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_005_ReportsDashboardVerifyReviewsAlertsTaskAndItemsCompleted() {
		// To verify login page
		// To login as existing teacher user
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// To verify that reports page is loaded successfully
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// Navigate to the Dashboard page
		teacherReportsDashboardPage = teacherRoleReportsPage.navigateToDashboardPage();
		// Clicks Review tab under Reports->Dash board section
		teacherReportsDashboardPage.clickOnReviewsTabUnderDashboard();
		// Verifies that 'Reviews' tab is highlighted on the redirected page
		teacherReportsDashboardPage.verifyReviewsTabIsHighlighted();
		// Clicks on Course Alerts tab under Reports->Dash board section
		teacherReportsDashboardPage.clickOnCourseAlertsUnderDashboard();
		// Verifies that 'Alerts' tab is highlighted on the redirected page
		teacherReportsDashboardPage.verifyAlertsTabIsHighlighted();
		// Verifies Time On Task under Reports->Dash board section
		teacherReportsDashboardPage.verifyTimeOnTaskTabUnderDashboard();
		// Closes Time On Task pop-up
		teacherReportsDashboardPage.verifyItemsCompletedTabUnderDashboard();

		// Logout form the application
		teacherReportsDashboardPage.clickLogoutfromHomePage();
		teacherReportsDashboardPage.verifyLoginPage();
	}

	/**
	 * This test verifies student progress under word training and sight words
	 * graph of Course Reports->Summary tab
	 */
	@Test(groups = { "RC", "QC" }, priority = 5, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_006_ReportsCourseReportsSummarySection() {
		// To verify login page
		// To login as existing teacher user
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// To verify that reports page is loaded successfully
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// Clicks on Course Reports tab link
		teacherReportsCourseReportsPage = teacherRoleReportsPage.clickOnCourseReportsTab();
		// Verifies that summary tab is loaded/highlighted by default
		teacherReportsCourseReportsPage.verifyThatCourseReportsSummaryTabIsHighlighted();
		// Verifies Course Reports-Summary Tab
		int [] studentUnitAndFloorValues = teacherReportsCourseReportsPage.verifyStudentProgressInWTAndSightWordsGraphs(
				llData.teacherRoleLLStudentLastName, llData.teacherRoleLLStudentWTLevel,
				llData.teacherRoleLLStudentSightWords);
		
		// Logout form the application
		teacherReportsCourseReportsPage.clickLogoutfromHomePage();
		teacherReportsCourseReportsPage.verifyLoginPage();
		dependentData.writeProperty("LL_TEACHER_006_studentUnitAndFloorValues_0", String.valueOf(studentUnitAndFloorValues[0]));
		dependentData.writeProperty("LL_TEACHER_006_studentUnitAndFloorValues_1", String.valueOf(studentUnitAndFloorValues[1]));
	}

	/**
	 * This test verifies that student score is displayed as percentages under
	 * all units section of Word Training Tab of Course Reports page
	 */

	@Test(groups = { "RC", "QC" }, priority = 6, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_010_ReportsCourseReportsWTSection() 
	{
		int [] studentUnitAndFloorValues = {Integer.parseInt(dependentData.getProperty("LL_TEACHER_006_studentUnitAndFloorValues_0")),
				Integer.parseInt(dependentData.getProperty("LL_TEACHER_006_studentUnitAndFloorValues_1"))};
		//dependentData.getProperty("LL_TEACHER_006_studentUnitAndFloorValues_1");
	
		// To verify login page
		// To login as existing teacher user
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// To verify that reports page is loaded successfully
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// Clicks on Course Reports tab link
		teacherReportsCourseReportsPage = teacherRoleReportsPage.clickOnCourseReportsTab();
		// Click on Word Training Tab under Course Reports section
		teacherReportsCourseReportsPage.clickOnWordTrainingTabUnderCourseReports();
		// Verify that Word Training Tab under Course Reports section is
		// displayed with all unit scores for students by default
		teacherReportsCourseReportsPage.verifyWordTrainingTabDisplaysTotalUnitScores();
		// To verify student scores being displayed in the percentages under WT
		// table
		teacherReportsCourseReportsPage.reportsCourseReportsWTSection(llData ,studentUnitAndFloorValues);
	/*teacherReportsCourseReportsPage.verifyStudentScoresUnderWordTrainingTabAllUnitsSection(
				llData.teacherRoleLLStudentLastName, Integer.toString(studentUnitAndFloorValues[0] + 1),
				llData.teacherRoleLLStudentWTUnitPercentageScore);		
		//## RC Scenarios ##
	teacherReportsCourseReportsPage.verifydisplayDropDown(llData.teacherRoleLLAlertsAutoPassStudentLastName ,llData.StudentReadPassageScore );
	
		teacherReportsCourseReportsPage.verifyPerUnitScoresDetails(llData.teacherRoleLLStudentLastName , llData.StudentLesson1Score ,llData.StudentLesson2Score, llData.StudentLesson3Score ,llData.StudentLesson4Score);
		
	*/	
		// Logout form the application
		teacherReportsCourseReportsPage.clickLogoutfromHomePage();
		teacherReportsCourseReportsPage.verifyLoginPage();

	}

	/**
	 * This test verifies Bots and Games played count for a student user under
	 * sight words page of Course Reports page
	 */

	@Test(groups = { "RC", "QC" }, priority = 7, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_011_ReportsCourseReportsSightWordsSection() 
	{
		int [] studentUnitAndFloorValues = {Integer.parseInt(dependentData.getProperty("LL_TEACHER_006_studentUnitAndFloorValues_0")),
				Integer.parseInt(dependentData.getProperty("LL_TEACHER_006_studentUnitAndFloorValues_1"))};
		// To verify login page
		// To login as existing teacher user
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// To verify that reports page is loaded successfully
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// Clicks on Course Reports tab link
		teacherReportsCourseReportsPage = teacherRoleReportsPage.clickOnCourseReportsTab();
		// Clicks Sight Words Tab under Course Reports section
		teacherReportsCourseReportsPage.clickOnSightWordsTabUnderCourseReports();
		// Verify that Sight Words tab is displayed with all floor wise results
		teacherReportsCourseReportsPage.verifySightWordsTabDisplaysFloorWiseScores();
		// Verifies student scores under sight words tab section(all floors)
/*		teacherReportsCourseReportsPage.verifyStudentScoresUnderSightWordsTabAllFloorsSection(
				llData.teacherRoleLLStudentLastName, studentUnitAndFloorValues[0],
				llData.teacherRoleLLStudentSWBOTSScore, llData.teacherRoleLLStudentSWGamesPlayedCount);*/
		teacherReportsCourseReportsPage.reportsCourseReportsSightWordsSection(llData, studentUnitAndFloorValues);
		// Logout form the application
		teacherReportsCourseReportsPage.clickLogoutfromHomePage();
		teacherReportsCourseReportsPage.verifyLoginPage();
	}

	/**
	 * This test verifies student scores under 'Practice Activities', 'Content
	 * Mastery', and 'Power Pass' columns under 'Text Training' tab of Course
	 * Reports page
	 */

	@Test(groups = { "RC", "QC" }, priority = 8, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_012_ReportsCourseReportsTextTrainingSection() 
	{
		// To verify login page
		// To login as existing teacher user
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// To verify that reports page is loaded successfully
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// Clicks on Course Reports tab link
		teacherReportsCourseReportsPage = teacherRoleReportsPage.clickOnCourseReportsTab();
		// Clicks on Text Training tab under Course Reports section
		teacherReportsCourseReportsPage.clickOnTextTrainingTabUnderCourseReports();
		// Verifies that Text Training Tab is loaded
		teacherReportsCourseReportsPage.verifyTheNavigationToTextTrainingTab();
		// Clicks on Text Training Unit Number Button on Top
		teacherReportsCourseReportsPage.clickOnTextTrainingUnitNumberButton(llData.teacherRoleLLStudentTTUnit);
		// To verify the navigation to selected student unit section
		teacherReportsCourseReportsPage
				.verifyTheNavigationToSelectedTextTrainingUnitSection(llData.teacherRoleLLStudentTTUnit);
		// To verify student score values under Text Training Tab
		teacherReportsCourseReportsPage.verifyStudentScoresUnderTheSelectedUnitTextTraining(
				llData.teacherRoleLLStudentLastName, llData.teacherRoleLLStudentTTPracticeActivity,
				llData.teacherRoleLLStudentTTPracticeActivityScore, llData.teacherRoleLLStudentTTContentMastery,
				llData.teacherRoleLLStudentTTContentMasteryScore, llData.teacherRoleLLStudentTTPowerPass,
				llData.teacherRoleLLStudentTTPowerPassScore);
		
		// Logout form the application
		teacherReportsCourseReportsPage.clickLogoutfromHomePage();
		teacherReportsCourseReportsPage.verifyLoginPage();
	}
}
