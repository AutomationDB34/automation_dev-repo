package com.testsuite.ll.teacherrole;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherReportsCourseReportsPage;
import com.page.module.ll.teacherrole.TeacherRoleReportsPage;
import com.selenium.Sync;
import com.testng.Retry;

public class TeacherRoleCourseReportsActions extends BaseSetup {
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLLogout lllogout;
	private TeacherRoleReportsPage teacherRoleReportsPage;
	TeacherReportsCourseReportsPage teacherReportsCourseReportsPage;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetup() throws Exception {
		llData = new LLData();
		llloginPage = new LLLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();
	}

	/**
	 * Purpose is to click on the bar graph of WT progress and verify the pop up displayed with student list
	 */
	@Test(groups = { "RC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL_007_VerifyStudentDetailsInBarGraphs() {

		// Step1: Login into LL application with teacher credentials
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,
				llData.teacherRoleLLUsername, llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// Step2: Find that Reports page is loaded
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// Step3: Navigate to Reports - Course reports tab
		teacherReportsCourseReportsPage = teacherRoleReportsPage.clickOnCourseReportsTab();
		// Sep 4: Find that student progress is displayed
		teacherReportsCourseReportsPage.verifyThatCourseReportsSummaryTabIsHighlighted();
		// Step5: Click on the progress displayed on the bar graph
		// Step6: Verify that pop up is displayed with student details
		teacherReportsCourseReportsPage.clickBarGraphAndVerifyStudentDetails();
		// Logout form the application
		teacherReportsCourseReportsPage.clickLogoutfromHomePage();
		teacherReportsCourseReportsPage.verifyLoginPage();
	}

	/**
	 * Purpose is to click on the student link in bar graph pop up and verify summary page of selected student
	 */
	@Test(groups = { "RC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LL_008_VerifyStudentSummaryFromBarGraphs() {

		// Step1: Login into LL application with teacher credentials
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,
				llData.teacherRoleLLUsername, llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// Step2: Find that Reports page is loaded
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// Step3: Navigate to Reports - Course reports tab
		teacherReportsCourseReportsPage = teacherRoleReportsPage.clickOnCourseReportsTab();
		// Sep 4: Find that student progress is displayed
		teacherReportsCourseReportsPage.verifyThatCourseReportsSummaryTabIsHighlighted();
		// Step5: Click on the student link in the pop up and verify summary
		// page
		teacherReportsCourseReportsPage.clickStudentInPopupAndVerifySummary(llData);
		// Logout form the application
		teacherReportsCourseReportsPage.clickLogoutfromHomePage();
		teacherReportsCourseReportsPage.verifyLoginPage();
	}

	/**
	 * Purpose is to verify the functionality of student selection drop down 
	 */
	@Test(groups = { "RC" }, priority = 3, retryAnalyzer = Retry.class)
	public void LL_009_VerifyCourseReportsSummary() {
		// Step1: Login into LL application with teacher credentials
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,
				llData.teacherRoleLLUsername, llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// Step2: Find that Reports page is loaded
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// Step3: Navigate to Reports - Course reports tab
		teacherReportsCourseReportsPage = teacherRoleReportsPage.clickOnCourseReportsTab();
		// Step 4: Find that student progress is displayed
		teacherReportsCourseReportsPage.verifyThatCourseReportsSummaryTabIsHighlighted();
		//Verify reports for "All Students" filter
		teacherReportsCourseReportsPage.verifyAllStudentsDisplayed();
		//Verify reports page for "Individual student" filter
		teacherReportsCourseReportsPage.verifyIndividualStudentData(llData);
		// Logout form the application
		teacherReportsCourseReportsPage.clickLogoutfromHomePage();
		teacherReportsCourseReportsPage.verifyLoginPage();
	}

}
