package com.testsuite.ll.teacherrole;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.LLStudentHomePage;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherRoleReportsPage;
import com.selenium.Sync;
import com.testng.Retry;

public class TeacherRoleDashboardPageActions extends BaseSetup{
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLLogout lllogout;
	LLStudentHomePage llstudentHomePage;
	StudentWelcomePage studentWelcomePage;
	String studentScoreDetails[] = new String[4];
	private TeacherRoleReportsPage teacherRoleReportsPage;
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetup()throws Exception{
	
		llData = new LLData();	
		llloginPage = new LLLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();
		
	}

	@Test(groups = { "RC"}, priority = 1, retryAnalyzer = Retry.class)
	public void LL_004_DashboardSelectStudentAndVerifyProgress(){
		//Pre - condition : Login with student and get the student progress data
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLStudentFirstName,
				llData.teacherRoleLLStudentFirstName, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		studentWelcomePage.ClickContinueButton();
		studentScoreDetails = studentWelcomePage.getStudentProgressData(llloginPage , llData);
		
		//Step1: Login into LL application with teacher credentials
		teacherRoleReportsPage = (TeacherRoleReportsPage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHERROLE_REPORTS_PAGE);
		//Step2: Find that Reports page is loaded
		teacherRoleReportsPage.verifyReportsPageIsLoaded();
		//Step3 :Click on the student links 
		teacherRoleReportsPage.clickOnStudentNameLink(llData);
		//Step4: Find that control navigates to the course reports - summary page
		//Step5: Verify the students summary page
		teacherRoleReportsPage.verifySummaryPage(llData);
		//Verify student progress 
		teacherRoleReportsPage.verifyStudentProgress(studentScoreDetails);
		//Logout from the application
		teacherRoleReportsPage.clickLogoutfromHomePage();
		teacherRoleReportsPage.verifyLoginPage();
		
	}
}
