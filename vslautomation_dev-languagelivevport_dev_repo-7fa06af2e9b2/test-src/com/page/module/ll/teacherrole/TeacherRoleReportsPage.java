package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.page.locators.ll.teacherrole.TeacherRoleReportsPageLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.level1activities.LLStudentHomePage;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherRoleReportsPage extends CommonFunctionalities implements TeacherRoleReportsPageLocators {

	private WebDriver driver;
	LLLoginPage llloginPage;
	LLData llData;
	StudentWelcomePage studentWelcomePage;
	LLStudentHomePage llstudentHomePage;
	// String studentScoreDetails[] ;

	public TeacherRoleReportsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose - To click on Course Reports tab
	 */

	public TeacherReportsCourseReportsPage clickOnCourseReportsTab() {
		safeClick(REPORTS_COURSEREPORTS_TAB, LONGWAIT);

		return new TeacherReportsCourseReportsPage(driver);
	}

	/**
	 * Purpose- To click on Benchmarks Reports tab
	 */
	public TeacherReportsBenchmarkReportsPage clickOnBenchMarksReportsTab() {
		safeClick(REPORTS_BENCHMARKREPORTS_TAB, LONGWAIT);

		return new TeacherReportsBenchmarkReportsPage(driver);
	}

	/**
	 * Purpose- To click on Score Details tab
	 */
	public TeacherReportsScoreDetailsPage clickOnScoreDetailsTab() {
		safeClick(REPORTS_SCOREDETAILS_TAB, LONGWAIT);

		return new TeacherReportsScoreDetailsPage(driver);
	}

	/**
	 * Purpose- To click on Parent Report tab
	 */
	public TeacherRoleReportsParentReportPage clickOnParentReportTab() {
		safeClick(REPORTS_PARENTREPORT_TAB, LONGWAIT);

		return new TeacherRoleReportsParentReportPage(driver);
	}

	/**
	 * Purpose- To verify that by default Reports Page is loaded
	 */
	public void verifyReportsPageIsLoaded() {
		Assert.assertTrue(isElementPresent(REPORTSTAB_SELECTED, LONGWAIT),
				"Reports page is not loaded after teacher is logged in");
		Assert.assertTrue(isElementPresent(REPORTS_DASHBOARD_STUDENT_TABLE, LONGWAIT),
				"Reports->Dashboard page is not loaded after teacher is logged in");
		waitForPageToLoad();
	}

	/**
	 * Purpose- To Reports page is loaded with different tabs and icons
	 */
	public void verifyReportsPageDisplayedWithAllTabsAndIcons() {
		Assert.assertTrue(isElementPresent(REPORTS_DASHBOARD_TAB, LONGWAIT),
				"Dashboard tab is not displayed under Reports tab");
		Assert.assertTrue(isElementPresent(REPORTS_DASHBOARD_ICON, LONGWAIT),
				"Dashboard tab icon is not displayed under Reports tab");
		Assert.assertTrue(isElementPresent(REPORTS_COURSEREPORTS_TAB, LONGWAIT),
				"Course Reports tab is not displayed under Reports tab");
		Assert.assertTrue(isElementPresent(REPORTS_COURSEREPORTS_ICON, LONGWAIT),
				"Course Reports tab icon is not displayed under Reports tab");
		Assert.assertTrue(isElementPresent(REPORTS_BENCHMARKREPORTS_TAB, LONGWAIT),
				"Benchmark Reports tab icon is not displayed under Reports tab");
		Assert.assertTrue(isElementPresent(REPORTS_BENCHMARKREPORTS_ICON, LONGWAIT),
				"Benchmark Reports icon icon is not displayed under Reports tab");
		Assert.assertTrue(isElementPresent(REPORTS_SCOREDETAILS_TAB, LONGWAIT),
				"Score Details  tab icon is not displayed under Reports tab");
		Assert.assertTrue(isElementPresent(REPORTS_SCOREDETAILS_ICON, LONGWAIT),
				"Score Details icon icon is not displayed under Reports tab");
		Assert.assertTrue(isElementPresent(REPORTS_PARENTREPORT_TAB, LONGWAIT),
				"Parent Report tab icon is not displayed under Reports tab");
		Assert.assertTrue(isElementPresent(REPORTS_PARENTREPORT_ICON, LONGWAIT),
				"Parent Report icon icon is not displayed under Reports tab");
		Assert.assertTrue(isElementPresent(REPORTS_DISTRICTOVERVIEW_TAB, LONGWAIT),
				"District Overview tab icon is not displayed under Reports tab");
		Assert.assertTrue(isElementPresent(REPORTS_DISTRICTOVERVIEW_ICON, LONGWAIT),
				"District Overview icon icon is not displayed under Reports tab");

	}

	public TeacherReportsDashboardPage navigateToDashboardPage() {

		safeClick(REPORTS_DASHBOARD_TAB);
		return new TeacherReportsDashboardPage(driver);
	}

	/**
	 * Purpose is to click on the student link in the Dashboard
	 *
	 * @param lldata
	 */
	public void clickOnStudentNameLink(LLData lldata) {
		waitForSecs(10, "Waiting for page to load");
		safeJavaScriptClick(Dynamic.getNewLocator(STUDENTNAME_LINK, lldata.teacherRoleLLStudentFirstName), MEDIUMWAIT);
		waitForSecs(10, "Waiting for page to load");
		safeJavaScriptClick(Dynamic.getNewLocator(STUDENTNAME_LINK, lldata.teacherRoleLLStudentFirstName), MEDIUMWAIT);

	}

	/**
	 * Purpose is to verify the summary page loaded
	 */
	public void verifySummaryPage(LLData lldata) {
		waitForSecs(5);
		Assert.assertTrue(isElementDisplayed(SUMMARY_PAGE),
				"Summary page is not being displayed after clicking the student link in the Dashboard page");
		Assert.assertTrue(isElementDisplayed(Dynamic.getNewLocator(STUDENT_NAME, lldata.teacherRoleLLStudentFirstName)),
				"Student name is not being displayed in the summary page");
	}

	/**
	 * Purpose is to verify the student progress
	 */
	public void verifyStudentProgress(String studentScoreDetails[]) {

		for (int i = 0; i < 4; i++) {
			Assert.assertEquals(
					safeGetText(Dynamic.getNewLocator(SCORECARD_DETAILS, Integer.toString(i + 2)), MEDIUMWAIT),
					studentScoreDetails[i], "Scores in Lesson" + i++ + "is not matched ");

		}

	}

}
