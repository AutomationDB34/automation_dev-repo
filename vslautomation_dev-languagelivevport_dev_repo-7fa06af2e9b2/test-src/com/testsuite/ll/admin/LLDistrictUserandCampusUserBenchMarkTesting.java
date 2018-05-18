package com.testsuite.ll.admin;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.datamanager.ConfigManager;
import com.page.module.ll.admin.BenchMarkReportsPage;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.admin.StartupReportspage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.vport.DistrictAdminHomepage;
import com.page.module.vport.DistrictAdminMyResultsPage;
import com.page.module.vport.TestDependencyFunctions;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportLogoutPage;
import com.page.module.vport.VportTrackFilterPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class LLDistrictUserandCampusUserBenchMarkTesting extends BaseSetup{
	
	LLData llData;
	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	StartupReportspage startupReportspage;
	VportData vportData;
	LLLoginPage llloginPage;
	DistrictAdminMyResultsPage districtAdminMyResultsPage;
	BenchMarkReportsPage benchMarkReportsPage;
	TestDependencyFunctions testDependencyFunctions;
	VportLoginPage vportloginpage;
	ConfigManager dependentData;
	
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() 
	{
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		llData = new LLData();
		dependentData = new ConfigManager("DependentData");
		testDependencyFunctions = new TestDependencyFunctions(getDriver());
		getDriver().manage().deleteAllCookies();	
		(new Sync(getDriver())).waitForPageToLoad();
	}
	
/*	@AfterMethod(alwaysRun=true)
	public void logoutfromLL() {
		
		LLLogout llLogout = new LLLogout(getDriver());
		llLogout.clickLogoutfromHomePage();
		llloginPage.verifyLoginPage();
	}*/

	/*
	 * This test verifies Benchmark testing graphs in District Admin Dash board
	 * page
	 */
	@Test(groups = { "DistrictUser", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_009_VerifyBenchMarkTestingMatchedAndUnmatchedScoresInDashboard()  {
		
		Map<String,String[]> newBenchmarkScores = vportloginpage.benchmarkScoresFromVport(vportloginpage);
		String[] matchedScores =  newBenchmarkScores.get("MatchedScores");
		String[] unMatchedScores =  newBenchmarkScores.get("UnMatchedScores");
		// Login into Language live product
		llloginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llloginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		// verifies Matched score of PAR ,TOSCRF and TWS4 in Dash board page ->Benchmark Testing graphs
		llHomePage.verifyBenchMarkTestingMatchedScore(matchedScores);
		// Clicks on Unmatched scores tab in Benchmark testing pane
		llHomePage.clickUnmatchedScorestabinBenchmarkTesting();
		
		// verifies Unmatched score of PAR ,TOSCRF and TWS4 inDash board page -> Benchmark Testing graphs
		llHomePage.verifyBenchMarkTestingUnMatchedScore(unMatchedScores);

	}
	
	/*
	 * This test verifies Benchmark testing graphs in  District Admin Dash board page  
	 */
	
	@Test(groups = { "CampusUser","QC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LL_CAMPUSUSER_008_VerifyBenchMarkTestingMatchedAndUnmatchedScoresInDashboard() 
	{
		Map<String,String[]> newBenchmarkScores = vportloginpage.benchmarkScoresFromVport(vportloginpage);
		String[] matchedScores =  newBenchmarkScores.get("MatchedScores");
		String[] unMatchedScores =  newBenchmarkScores.get("UnMatchedScores");
		
		getDriver().manage().deleteAllCookies();
		// Login into language live product
		llloginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llloginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//verifies  Matched score of PAR ,TOSCRF and TWS4  in Dash board page-> Benchmark Testing graphs  
		llHomePage.verifyBenchMarkTestingMatchedScore(matchedScores);
		llHomePage.clickUnmatchedScorestabinBenchmarkTesting();
		//verifies  Un Matched score of PAR ,TOSCRF and TWS4  in Dash board page ->Benchmark Testing graphs 
		llHomePage.verifyBenchMarkTestingUnMatchedScore(unMatchedScores);

	}

	@Test(groups = {"DistrictUser","QC" }, priority = 3,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_012_VerifyBenchMarkReportsForMatchedAndUnMatchedScores() 
	{
		Map<String,String[]> newBenchmarkScores = vportloginpage.benchmarkScoresFromVport(vportloginpage);
		String[] matchedScores =  newBenchmarkScores.get("MatchedScores");
		String[] unMatchedScores =  newBenchmarkScores.get("UnMatchedScores");
		// Login into Language live product
		llloginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llloginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,
						LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		benchMarkReportsPage=llHomePage.clickBenchMarkReportsTab();
		benchMarkReportsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		benchMarkReportsPage.verifyUnMatchedScoresForStudent(llData.teacherLLUsername+" LL", unMatchedScores[0], unMatchedScores[1], unMatchedScores[2]);
		benchMarkReportsPage.clickMatchedCheckBox();
		benchMarkReportsPage.verifyMatchedScoresForStudent(llData.teacherLLUsername+" LL", matchedScores[0], matchedScores[1], matchedScores[2]);

	
	}	
	
	@Test(groups = {"CampusUser","QC" }, priority =4,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_011_VerifyBenchMarkReportsForMatchedAndUnMatchedScores() 
	{
		Map<String,String[]> newBenchmarkScores = vportloginpage.benchmarkScoresFromVport(vportloginpage);
		String[] matchedScores =  newBenchmarkScores.get("MatchedScores");
		String[] unMatchedScores =  newBenchmarkScores.get("UnMatchedScores");
		// Login into Language live product
		llloginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llloginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,
						LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyAllFramesEnabledInHomePageforCampusUser();
		benchMarkReportsPage=llHomePage.clickBenchMarkReportsTab();
		//benchMarkReportsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		benchMarkReportsPage.verifyUnMatchedScoresForStudent(llData.teacherLLUsername+" LL", unMatchedScores[0], unMatchedScores[1], unMatchedScores[2]);
		benchMarkReportsPage.clickMatchedCheckBox();
		benchMarkReportsPage.verifyMatchedScoresForStudent(llData.teacherLLUsername+" LL", matchedScores[0], matchedScores[1], matchedScores[2]);
	}

	@AfterClass()
	public void resetScores()
	{
		ConfigManager dependentData = new ConfigManager("DependentData");
		dependentData.writeProperty("MatchedScore1", "null");
		dependentData.writeProperty("MatchedScore2", "null");
		dependentData.writeProperty("MatchedScore3", "null");
		dependentData.writeProperty("UnMatchedScore1","null");
		dependentData.writeProperty("UnMatchedScore2", "null");
		dependentData.writeProperty("UnMatchedScore3", "null");
	}
	
	
}
