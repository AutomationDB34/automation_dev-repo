package com.testsuite.ll.admin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.admin.StartupReportspage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Dynamic;
import com.testng.Retry;

public class LLCampusUserDashBoardScenarios extends BaseSetup{
	
	LLData llData;
	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	StartupReportspage startupReportspage;
	ImplementationCardsPage implementationCardsPage;
	
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
	
		// Login into Langaugae live prduct
		llLoginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		
	}
	
	/**
	 * This Test verifies all tabs i.e  Dash board, Start Up reports, course reports, benchmark reports, notification report(along with icons) are displayed in LL home page for Campus User
	 * @throws Exception
	 */
	@Test(groups = {"CampusUser","QC" }, priority = 1,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_002_VerifyAllTabsEnabledinLLHomePage()
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//llHomePage.verifyLanguageLiveDashBoard();
		llHomePage.verifyDashBoardTab();
		//Verify Start up reports  tab
		llHomePage.verifyStartUpReportsTab();
		//Verify Course reports  tab
		llHomePage.verifyCourseReportsTab();
		//Verify Benchmark reports tab
		llHomePage.verifyBenchmarkReportsTab();
		//Verify Notification reports tab
		llHomePage.verifyNotificationsReportTab();
		llHomePage.clickLogoutfromHomePage();
		llHomePage.verifyLoginPage();
		
	}
	
	/**
	 * This Test verifies all frames i.e  Pre-Implementation & Launch, Need help?, Start Up, Technology, Course Progress & Performance, Benchmark Testing frames are enable in Home page Dash Board
	 * @throws Exception
	 */ 
	@Test(groups={"CampusUser","QC"},priority = 2,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_003_verifyDashBoardPage()
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//llHomePage.verifyLanguageLiveDashBoard();
		
		llHomePage.verifyDashBoardTab();
		//To Verify all the frames in the DashBoard are loaded or not 
		llHomePage.verifyAllFramesEnabledInHomePageforCampusUser();
		llHomePage.clickLogoutfromHomePage();
		llHomePage.verifyLoginPage();
	}
	
	/**
	 * This Test verifies Pre_implementation Launch frame in Dash board 
	 * @throws Exception
	 */ 	
	@Test(groups={"CampusUser","QC"},priority = 3,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_004_verifyPreImplementationLaunchFrame()
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//llHomePage.verifyLanguageLiveDashBoard();
		String [] gettingStartedSteps={ "About LANGUAGE! Live","Goals for School","Participation in Program","Review Plan","Teacher & Admin Training","Technology","Import Students, Teachers and Schools"};
		//Verify 'Getting started steps' links in pre implementation launch frame
		llHomePage.verifyGettingStartedStepsforCampusUser(gettingStartedSteps);
		String [] implementationPane_Headings={"School Calendar","Benchmark Windows","Instructional Targets","Technology Access"};
		//Verify Implementation plan pane
		llHomePage.verifyImplementationPlanforCampusUser(implementationPane_Headings);
		//Clicks on review link in Implementation Plan pane and verifies it 
		implementationCardsPage=llHomePage.clickReviewinImplementationPlan();
		implementationCardsPage.moveToImplemetationCardsFramefromDashboard();
		implementationCardsPage.verifyReviewLinkinImplementationPlan();
		implementationCardsPage.clickSaveandGotoDashBoard();
		implementationCardsPage.defaultFrame();
		//Verify Training stats pane
		llHomePage.verifyTrainingStats();
		llHomePage.clickLogoutfromHomePage();
		llHomePage.verifyLoginPage();
		}
	
	/**
	 * This Test verifies Needs Help frame in Dash board 
	 * @throws Exception
	 */ 
	@Test(groups={"CampusUser","QC"},priority = 4,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_005_verifyNeedsHelpFrame()
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//llHomePage.verifyLanguageLiveDashBoard();
		llHomePage.verifyNeedHelp();
		llHomePage.clickLogoutfromHomePage();
		llHomePage.verifyLoginPage();
	}
 
	/**
	 * This Test verifies Start up frame in Dash board 
	 * @throws Exception
	 */ 
	@Test(groups={"CampusUser","QC"},priority = 5,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_006_verifyStartUpFrame()
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//llHomePage.verifyLanguageLiveDashBoard();
		llHomePage.verifyDashBoardTab();
		llHomePage.verifyAllFramesEnabledInHomePageforCampusUser();
		llHomePage.verifyStartUpFrame();
		startupReportspage=llHomePage.clickViewStudentStartUpDetailReport();
		startupReportspage.verifyStartupReportsHeading();
		startupReportspage.verifyStudentSubtab();
		llHomePage.clickDashBoradTab();
		llHomePage.clickViewTeacherStartUpDetailReport();
		startupReportspage.verifyTeacherSubtab();
		llHomePage.clickDashBoradTab();
		llHomePage.verifyDashBoardTab();
		llHomePage.clickLogoutfromHomePage();
		llHomePage.verifyLoginPage();
	}
	
	/**
	 * This Test verifies Course Progress Performance frame in Dash board 
	 * @throws Exception
	 */ 
	@Test(groups={"CampusUser","QC"},priority = 7,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_007_verifyCourseProgressPerformanceFrame()
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//llHomePage.verifyLanguageLiveDashBoard();
		llHomePage.verifyDashBoardTab();
		llHomePage.verifyCourseProgressPerformance();
		String score = llHomePage.getScoreofL1LessoninWordTrainingPerformaceandClick();
		llHomePage.verifyWordTrainingLessonDialogandClassesScore(llData.LLClassName+" LL",score);
		llHomePage.clickLogoutfromHomePage();
		llHomePage.verifyLoginPage();
	}
	}