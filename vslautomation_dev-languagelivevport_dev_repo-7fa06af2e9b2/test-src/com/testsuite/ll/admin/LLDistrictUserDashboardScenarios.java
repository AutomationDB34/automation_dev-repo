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

public class LLDistrictUserDashboardScenarios extends BaseSetup
{

	LLData llData;
	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	StartupReportspage startupReportspage;
	ImplementationCardsPage implementationCardsPage;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() 
	{

		// Login into Langaugae live prduct
		llLoginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();

	}


	/**
	 * This Test verifies all tabs i.e  Dash board, Start Up reports, course reports, benchmark reports, notification report(along with icons) are displayed in LL home page for District User
	 * @throws Exception
	 */
	@Test(groups = {"DistrictUser","QC" }, priority = 1,retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_002_VerifyAllTabsEnabledinLLHomePage() 
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//Verify Dash board tab 
		llHomePage.verifyLanguageLiveDashBoard();
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
	@Test(groups={"DistrictUser","QC"},priority = 2,retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_003_verifyDashBoardPage()
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyDashBoardTab();
		llHomePage.verifyAllFramesEnabledInHomePageforDistrictUser();
		llHomePage.clickLogoutfromHomePage();
		llHomePage.verifyLoginPage();
	}


	/**
	 * This Test verifies pre implementation Launch frame in Dash board 
	 * @throws Exception
	 */ 

	@Test(groups={"DistrictUser","QC"},priority = 3,retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_004_verifyPreImplementationLaunchFrame()
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		String [] gettingStartedSteps={ "About LANGUAGE! Live","Goals for School","Participation in Program","Implementation Plan","Teacher & Admin Training","Technology","Import Students, Teachers and Schools"};
		//Verify 'Getting started steps' links in pre implementation launch frame
		llHomePage.verifyGettingStartedStepsforDistrictUser(gettingStartedSteps);
		String [] implementationPane_Headings={"District Calendar","Benchmark Windows","Instructional Targets","Technology Access"};
		//Verify Implementation plan pane
		llHomePage.verifyImplementationPlanforDistrictUser(implementationPane_Headings);
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

	@Test(groups={"DistrictUser","QC"},priority = 4,retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_005_verifyNeedsHelpFrame()
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//Step1: Login into appication with admin user
		//Step2: After completion of Implementation cards
		//Step3: User displayed with reports pages
		llHomePage.verifyDashBoardTab();
		//Step4: Verify Need help section consisting Sopprt number and Email link
		llHomePage.verifyNeedHelp();
		llHomePage.clickLogoutfromHomePage();
		llHomePage.verifyLoginPage();
	}

	/**
	 * This Test verifies Start up frame in Dash board 
	 * @throws Exception
	 */ 
	@Test(groups={"DistrictUser","QC"},priority = 5,retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_006_verifyStartUpFrame()
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyDashBoardTab();
		llHomePage.verifyAllFramesEnabledInHomePageforDistrictUser();
		llHomePage.verifyStartUpFrame();
		startupReportspage=llHomePage.clickViewStudentStartUpDetailReport();
		startupReportspage.verifyStartupReportsHeading();
		startupReportspage.verifyStudentSubtab();
		llHomePage.clickDashBoradTab();
		llHomePage.clickViewTeacherStartUpDetailReport();
		startupReportspage.verifyTeacherSubtab();
		llHomePage.clickDashBoradTab();
		llHomePage.clickLogoutfromHomePage();
		llHomePage.verifyLoginPage();
	}
	/**
	 * This Test verifies Technology frame in Dash board 
	 * @throws Exception
	 */ 
	@Test(groups={"DistrictUser","QC"},priority = 6,retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_007_verifyTechnologyFrame()
	{llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
	//Step1:Login into application https://qa.languagelive.voyagersopris.com/services/logon
	//Step2:After completion of Implementation cards
	//Step3:User displayed with reports pages
	//Step4:Reports page consists of technology option
	//Step5:Find that respective page is displayed on selection
	llHomePage.verifyTechnologyframe();
	llHomePage.clickLearnLink();
	llHomePage.verifyLearnLink();
	llHomePage.closeTechnologyIssuesDialog();
	llHomePage.clickLogoutfromHomePage();
	llHomePage.verifyLoginPage();
	}
	/**
	 * This Test verifies Course Progress Performance frame in Dash board 
	 * @throws Exception
	 */ 

	@Test(groups={"DistrictUser","QC"},priority = 7,retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_008_verifyCourseProgressPerformanceFrame()
	{
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
	llHomePage.verifyCourseProgressPerformance();
	String score = llHomePage.getScoreofL1LessoninWordTrainingPerformaceandClick();
	llHomePage.verifyWordTrainingLesssonDialogandSchoolsScores(llData.LLSchoolName,score);
	llHomePage.clickClassesSubTab();
	llHomePage.verifyWordTrainingLessonDialogandClassesScore(llData.LLClassName+" LL",score);
	llHomePage.closeCoursePerformancedialog();
	llHomePage.clickLogoutfromHomePage();
	llHomePage.verifyLoginPage();
	}


}
