package com.testsuite.ll.admin;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.admin.CourseReportsPage;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.admin.StartupReportspage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.testng.Retry;

public class LLCourseReortsScenarios extends BaseSetup {
	LLData llData;
	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	CourseReportsPage courseReportsPage;
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
	
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
	}
	
/*	@AfterMethod(alwaysRun = true)
	public void logout() {
		
		LLLogout lllogout = new LLLogout(getDriver());
		llLoginPage = lllogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();
	}*/
	/*
	 * As a District user, this test verifies Course Performance Reports for Word training and Text training in the class
	 */
	@Test(groups = {"DistrictUser","QC" }, priority=1,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_011_VerifyCourseReportsDataforWordTrainingAndTexTraining() 
	{
		//To login with District User Credentials
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//To verify Application DashBoard is loaded or not 
		llHomePage.verifyDashBoardTab();
		llHomePage.verifyAllFramesEnabledInHomePageforDistrictUser();
		//Clicks on Course Reports tab and verifies whether it is loaded or not 
		courseReportsPage=llHomePage.clickCourseReportsTab();
		//llHomePage.verifyCourseReportsTab();
		//Selects School from 'All Schools' drop down and verifies classes drop down is loaded 
		courseReportsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		courseReportsPage.verifyAllClassesDropdownDisplayed();
		//Selects class from 'All classes' drop down
		courseReportsPage.selectClassFromAllClasses(llData.teacherLLUsername);
		//Verify Student Average in Word Training Lesson scores 
		courseReportsPage.verifyWordTrainingStudentAverage(llData.teacherRoleLLStudentFirstName,llData.adminLLStudentWordTrainingStudentAverage);
		//verify Unit1-Lessons score in Word Training Lesson scores 
		courseReportsPage.verifyWordTrainingUnit1LessonsScore(llData.teacherRoleLLStudentFirstName,llData.adminLLStudentWordTrainingU1Lesson1Score,llData.adminLLStudentWordTrainingU1Lesson2Score,llData.adminLLStudentWordTrainingU1Lesson3Score,llData.adminLLStudentWordTrainingU1Lesson4Score);
		//Selects Text training option from 'Display scores for ' dropdown 
		courseReportsPage.selectTextTraining();
		//Verify Student Average in Text Training Power passe scores 
		courseReportsPage.verifyTextTrainingStudentAverage(llData.teacherRoleLLStudentFirstName,llData.adminLLStudentTextTrainingStudentAverage);
		//verify Unit1-Lessons score in Text Training Power pass  scores 
		courseReportsPage.verifyTextTrainingUnit1Score(llData.teacherRoleLLStudentFirstName,llData.adminLLStudentTextTrainingUnit1Score);
	}
	/*
	 * As a Campus user, this test verifies Course Performance Reports for Word training and Text training in the class
	 */
	@Test(groups = {"CampusUser","QC" }, priority=2,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_010_VerifyCourseReportsDataforWordTrainingAndTexTraining() 
	{
		//Login into Language live with District User
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyDashBoardTab();
		llHomePage.verifyAllFramesEnabledInHomePageforCampusUser();
		//Clicks on Course Reports tab and verifies whether it is loaded or not 
		courseReportsPage=llHomePage.clickCourseReportsTab();
		//llHomePage.verifyCourseReportsTab();
		//Selects class from 'All classes' drop down
		courseReportsPage.selectClassFromAllClasses(llData.teacherLLUsername);
		
		//Verify Student Average in Word Training Lesson scores 
		courseReportsPage.verifyWordTrainingStudentAverage(llData.teacherRoleLLStudentFirstName,llData.adminLLStudentWordTrainingStudentAverage);
		//verify Unit1-Lessons score in Word Training Lesson scores 
		courseReportsPage.verifyWordTrainingUnit1LessonsScore(llData.teacherRoleLLStudentFirstName,llData.adminLLStudentWordTrainingU1Lesson1Score,llData.adminLLStudentWordTrainingU1Lesson2Score,llData.adminLLStudentWordTrainingU1Lesson3Score,llData.adminLLStudentWordTrainingU1Lesson4Score);
		//Selects Text training option from 'Display scores for ' dropdown 
		courseReportsPage.selectTextTraining();
		//Verify Student Average in Text Training Power passe scores 
		courseReportsPage.verifyTextTrainingStudentAverage(llData.teacherRoleLLStudentFirstName,llData.adminLLStudentTextTrainingStudentAverage);
		//verify Unit1-Lessons score in Text Training Power pass  scores 
		courseReportsPage.verifyTextTrainingUnit1Score(llData.teacherRoleLLStudentFirstName,llData.adminLLStudentTextTrainingUnit1Score);
	}
	

	
}
