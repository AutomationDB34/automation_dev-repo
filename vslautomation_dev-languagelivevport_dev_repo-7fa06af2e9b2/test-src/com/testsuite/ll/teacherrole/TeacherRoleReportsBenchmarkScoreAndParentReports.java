package com.testsuite.ll.teacherrole;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherReportsBenchmarkReportsPage;
import com.page.module.ll.teacherrole.TeacherReportsScoreDetailsPage;
import com.page.module.ll.teacherrole.TeacherRoleReportsPage;
import com.page.module.ll.teacherrole.TeacherRoleReportsParentReportPage;
import com.selenium.Sync;
import com.testng.Retry;

public class TeacherRoleReportsBenchmarkScoreAndParentReports extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private TeacherRoleReportsPage teacherRoleReportsPage;
	private TeacherReportsBenchmarkReportsPage teacherReportsBenchmarkReportsPage;
	private TeacherReportsScoreDetailsPage teacherReportsScoreDetailsPage;
	private TeacherRoleReportsParentReportPage teacherRoleReportsParentReportPage;
	private TeacherHomePage teacherHomePage;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llData = new LLData();
		llloginPage = new LLLoginPage(getDriver());
		getDriver().manage().deleteAllCookies();
		//getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();
	}

	/**
	 * This test verifies page loading of Reports->Benchmarks Reports page
	 */
	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_013_ReportsBenchmarksReportsVerification(){

		// To verify login page
		// To enter credentials and click on submit button
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// To verify that reports page is loaded successfully or teacher user is
		// logged in successfully
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// To click on Benchmarks Reports tab or link
		teacherReportsBenchmarkReportsPage = teacherRoleReportsPage.clickOnBenchMarksReportsTab();
		// To verify that Benchmarks Reports page is loaded successfully
		teacherReportsBenchmarkReportsPage.reportsBenchmarksReportsVerification(llData);
		// Logout form the application
		teacherRoleReportsPage.clickLogoutfromHomePage();
		teacherRoleReportsPage.verifyLoginPage();
	}

	/**
	 * This test verifies page loading of Reports->Score Details page
	 */

	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_014_ReportsScoreDetailsVerification(){
		// To verify login page
		// To login as existing teacher user
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// To verify that reports page is loaded successfully
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// To click on Score Details Tab
		teacherReportsScoreDetailsPage = teacherRoleReportsPage.clickOnScoreDetailsTab();
		// To verify that score details page is loaded successfully
		teacherReportsScoreDetailsPage.reportsScoreDetailsVerification(llData);
		// Logout form the application
		teacherRoleReportsPage.clickLogoutfromHomePage();
		teacherRoleReportsPage.verifyLoginPage();
	}

	/**
	 * This test verifies report generation for individual student and all
	 * students on Reports->Parent Reports page
	 */

	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_015_ReportsParentReportVerification(){
		// To verify login page
		// To login as existing teacher user
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		// To verify that reports page is loaded successfully
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		// To click on Parent Report tab
		teacherRoleReportsParentReportPage = teacherRoleReportsPage.clickOnParentReportTab();
		// To verify that parent report tab is loaded successfully with the
		// message text 'Choose a class and a student. Then select Create
		// Report.' in body
		teacherRoleReportsParentReportPage.verifyNavigationToParentReportTab();
		// Runs Parent report for single student user and verifies the report
		// also
		teacherRoleReportsParentReportPage.runAndVerifyParentReportForSingleStudentUser(
				llData.teacherRoleLLStudentLastName, llData.teacherRoleLLStudentFirstName);
		// Runs Parent report for all students and verifies them in the report
		teacherRoleReportsParentReportPage.runAndVerifyParentReportForAllStudentUsers();
		// Logout form the application
		teacherRoleReportsPage.clickLogoutfromHomePage();
		teacherRoleReportsPage.verifyLoginPage();
	}
}
