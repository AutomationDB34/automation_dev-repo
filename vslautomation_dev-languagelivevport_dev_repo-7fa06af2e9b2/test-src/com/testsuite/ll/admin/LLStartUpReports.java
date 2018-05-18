package com.testsuite.ll.admin;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.admin.StartupReportspage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.testng.Retry;

public class LLStartUpReports extends BaseSetup {
	LLData llData;
	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	StartupReportspage startupReportspage;
	ImplementationCardsPage implementationCardsPage;
	Map<String,String> teacherData;
	String[] studentData;
	
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
	
		// Login into Langaugae live prduct
		llLoginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		
	}
	
/*	@AfterMethod
	public void logoutfromLL()
	{
		LLLogout llLogout = new LLLogout(getDriver());
		llLogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();
	}*/
	/**
	 * This Test verifies District total in Start Up Page->Teacher Participation table by taking data from Dash board-> Start up reports->Teachers section 
	 */
	@Test(groups = {"DistrictUser","QC" }, priority = 1,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_010_VerifyStartUpReportsforTeacherAndStudent() throws Exception
	{
		//Login into Language live with District User
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//Reads the teachers  data from Dash board->Startup pane
		teacherData=llHomePage.readTeachersdatainStartUpFrame();
		//Reads the Students  data from Dash board->Startup pane
		studentData=llHomePage.readStudentsdatainStartUpFrame();
		//Clicks on 'View Teacher Start up reports' link in Teachers pane to navigate to Start up page and verifies the page
		llHomePage.verifyDashBoardTab();
		llHomePage.verifyAllFramesEnabledInHomePageforDistrictUser();
		startupReportspage=llHomePage.clickViewTeacherStartUpDetailReport();
		startupReportspage.verifyStartupReportsHeading();
		startupReportspage.verifyTeacherSubtab();
		//Verifies District total  Data in Teacher Participation table 
		startupReportspage.verifyTeacherParticipationforallSchoolsForDistUser(teacherData);
		//Clicks on Student tab and verifies it is loaded or not 
		startupReportspage.clickStudentTab();
		startupReportspage.verifyStudentSubtab();
		//Verifies District total  Data in Student  Participation table 
		startupReportspage.verifyStudentParticipationforallSchoolsforDistUser(studentData);
		
	}
	
	
	/**
	 * This Test verifies District total in Start Up Page->Student Participation table by taking data from Dash board-> Start up reports->Students section 
	 */
	@Test(groups = {"CampusUser","QC" },priority = 2,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_009_VerifyStartUpReportsforTeacherAndStudent() throws Exception
	{
		//Login into Language live with Campus User
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//Reads the Teachers  data from Dash board->Startup pane
		teacherData=llHomePage.readTeachersdatainStartUpFrame();
		//Reads the Students  data from Dash board->Startup pane
		studentData=llHomePage.readStudentsdatainStartUpFrame();
		llHomePage.verifyDashBoardTab();
		llHomePage.verifyAllFramesEnabledInHomePageforCampusUser();
		//Clicks on 'View Teacher Start up reports' link in Teachers pane to navigate to Start up page and verifies the page
		startupReportspage=llHomePage.clickViewTeacherStartUpDetailReport();
		startupReportspage.verifyStartupReportsHeading();
		startupReportspage.verifyTeacherSubtab();
		//Verifies District total  Data in Teacher Participation table 
		startupReportspage.verifyTeacherParticipationforallSchoolsForCampUser(teacherData);
		//Clicks on Student tab and verifies it is loaded or not 
		startupReportspage.clickStudentTab();
		startupReportspage.verifyStudentSubtab();
		//Verifies District total  Data in Student Participation table 
		startupReportspage.verifyStudentParticipationforallSchoolsforCampUser(studentData);
		
	}

}
