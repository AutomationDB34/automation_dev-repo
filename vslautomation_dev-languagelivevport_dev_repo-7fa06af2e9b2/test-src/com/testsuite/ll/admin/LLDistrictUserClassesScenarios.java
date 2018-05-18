package com.testsuite.ll.admin;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.page.module.ll.admin.ClassMatesPage;
import com.page.module.ll.admin.ClassWallPage;
import com.page.module.ll.admin.CourseResourcesPage;
import com.page.module.ll.admin.DistrictSettingsPage;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.admin.LeaderBoardsPage;
import com.page.module.ll.admin.StartupReportspage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.LLStudentHomePage;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherClassClassWallPage;
import com.page.module.ll.teacherrole.TeacherRoleClassPage;
import com.page.module.ll.teacherrole.TeacherViewProfileAboutMePage;
import com.page.module.vport.TestDependencyFunctions;
import com.page.module.vport.VportLoginPage;
import com.selenium.Sync;
import com.testng.Retry;

public class LLDistrictUserClassesScenarios extends BaseSetup {
	LLData llData;
	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	VportData vportData;
	StartupReportspage startupReportspage;
	ImplementationCardsPage implementationCardsPage;
	ClassWallPage classWallPage;
	TeacherHomePage teacherHomePage;
	TeacherRoleClassPage teacherRoleClassPage;
	TeacherClassClassWallPage teacherClassClassWallPage;
	ClassMatesPage classMatesPage;
	CourseResourcesPage courseResourcesPage;
	DistrictSettingsPage districtSettingsPage;
	StudentWelcomePage studentWelcomePage;
	LLStudentHomePage llStudentHomePage;
	TeacherViewProfileAboutMePage teacherViewProfileAboutMePage;
	LeaderBoardsPage leaderBoardsPage;

	String assignmentTitle;
	Object[] studentDetails;
	// String[] studentNamesInRoster;
	String studentCoursePointsFromStudentProfile;
	String studentAcheivementsFromStudentProfile;

	/**

	@BeforeMethod(alwaysRun = true) public void
	 * getStudentCoursePointsAndAcheivementsFromStudentProfilePage() {
	 * 
	 * // Login into Langaugae live prduct llLoginPage = new
	 * LLLoginPage(getDriver()); llData = new LLData();
	 * getDriver().manage().deleteAllCookies(); // To verify login page // To
	 * enter login credentials of student and click sign in button
	 * studentWelcomePage = (StudentWelcomePage)
	 * llLoginPage.loginCredentials(llData.URL,
	 * llData.teacherRoleLLStudentFirstName,
	 * llData.teacherRoleLLStudentFirstName,
	 * LLLoginReturnPage.STUD_WELCOME_PAGE); // clicks continue button in
	 * student welcome page llStudentHomePage =
	 * studentWelcomePage.ClickContinueButton(); // Verifies Student home page
	 * is opened or not llStudentHomePage.verifyLLStudentHomePage(); // Clicks
	 * on student image and navigate to Profile page of student
	 * teacherViewProfileAboutMePage =
	 * llStudentHomePage.navigateToViewProfile(); // verifies that About Me page
	 * is loaded in Profile tab
	 * teacherViewProfileAboutMePage.verifyThatViewProfileAboutMePageIsLoaded();
	 * // In About Me tab, read the course points(This Year) value
	 * studentCoursePointsFromStudentProfile =
	 * teacherViewProfileAboutMePage.getCoursePointsCountInYear(); // In About
	 * Me tab, read

	achievements points(This Year) value
	 * studentAcheivementsFromStudentProfile =
	 * teacherViewProfileAboutMePage.getAchievementsCountInYear();
	 * 
	 * }*/

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {

		vportData = new VportData();
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();

		/*
		 * llHomePage = new LLHomePage(getDriver());
		 * getDriver().manage().deleteAllCookies(); getDriver().get(llData.URL);
		 * llLoginPage.verifyLoginPage(); // Login into application with
		 * district admin credentials and verify llHomePage = (LLHomePage)
		 * llLoginPage.loginCredentials(llData.URL, llData.llDistrictAdmin,
		 * llData.llDistrictAdmin, LLLoginReturnPage.ADMIN_HOME_PAGE);
		 * llHomePage.verifyDashBoardTab();
		 * llHomePage.verifyAllFramesEnabledInHomePageforDistrictUser(); // To
		 * clicks on Classes tab classWallPage = llHomePage.clickOnClassesTab();
		 */

	}

/*	@AfterMethod
	public void logoutfromLL() {
		LLLogout llLogout = new LLLogout(getDriver());
		llLogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();
	}*/

	/**
	 * This Test Verifies district user can post in class wall in
	 * 'Classes'->'Class Wall' page and verifies assessments posted by teacher
	 * are displayed in Assessment tab
	 */

	@Test(groups = { "DistrictUser", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_032_ClassessClassWallPageScenarios() 
	{
		// Login into Langaugae live prduct
		llLoginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		// This methods login into LL as a teacher and posts assignment in Class
		// wall->Assignments sub tab
		assignmentTitle = llLoginPage.postAssignmentinTeacherClassesPageandGetAssignmentName(llLoginPage);
		// Login into application with district admin credentials and verify
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL, llData.llDistrictAdmin,
				llData.llDistrictAdmin, LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyDashBoardTab();
		llHomePage.verifyAllFramesEnabledInHomePageforDistrictUser();
		// To clicks on Classes tab
		classWallPage = llHomePage.clickOnClassesTab();
		// Verify Class wall page is loaded
		classWallPage.verifyClassWallPageLoaded();
		// Clicks on All Sub tab in ClassWall page
		classWallPage.clickAllSubTab();
		// Selects class from Classes drop down in All sub tab
		classWallPage.selectClassFromClassDropdown(llData.LLClassName + " LL");
		Long randomtxt = System.currentTimeMillis();
		// Verify whether user can able to post the data in calss wall
		classWallPage.enterTextIntoClassWallFieldAndShare(llData.WallDescriptionData + randomtxt);
		// Verifies the posted data in class wall
		classWallPage.verifyWallPostDataSubmitted(llData.WallDescriptionData + randomtxt);
		// Clicks on Assignment sub tab
		classWallPage.clickAssignmentSubTab();
		// Verifies class wall posts are not displayed in Assessment sub tab
		classWallPage.verifyClassWallPostsNotDisplayedInAssigmentTab();
		// Verifies whether assignments posted by the teacher are displayed in
		// District user Assignment tab
		classWallPage.verifyAssignmentsDisplayed(llData.teacherRoleLLUsername, assignmentTitle);
	}

	/**
	 * This test verifies number of students and teachers displayed in
	 * Classmates page and verifies the profile of student
	 */

	@Test(groups = { "DistrictUser", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_033_ClassessClassMatesPageScenarios() {
		// Login into Langaugae live prduct
		llLoginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL, llData.llDistrictAdmin,
				llData.llDistrictAdmin, LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyLanguageLiveDashBoard();
		Object[] distStudentDetails = llHomePage.getStudentDetailsFromDistrictRosterTab(llHomePage);
		// To clicks on Classes tab
		classWallPage = llHomePage.clickOnClassesTab();
		// Clicks on Classmates tab
		classMatesPage = classWallPage.clickClassMatesTab();
		// Verifies that Classmates page is loaded
		classMatesPage.verifyClassMatesPageLoaded();
		// Selects class from All classes drop down
		classMatesPage.selectClassFromClassDropdown(llData.LLClassName + " LL");
		// Verify that teacher of particular class is displayed in Teacher pane
		classMatesPage.verifyTeacherinClassMates(llData.teacherLLUsername);
		// Verifies student count classmates tab by comparing the student count
		// read from Roster tab
		classMatesPage.verifyStudentsCountinClassMatesTab((Integer) distStudentDetails[0]);
		// Verifies the students displayed in Students pane
		ArrayList<String> al = (ArrayList<String>) distStudentDetails[1];
		String[] stuNames = new String[al.size()];
		stuNames = al.toArray(stuNames);
		classMatesPage.verifyStudentNamesinClassMatesTab(stuNames);
		// verifies Profile of student
		classMatesPage.verifyProfileOfStudent(llData.teacherRoleLLStudentLastName);
	}

	/**
	 * As a District user ,this test Verifies Course points and Achievements
	 * countof a student is displayed correctly or not in a year
	 */
	@Test(groups = { "DistrictUser", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_034_ClassessLeaderBoardsPageScenarios() 
	{
		// Login into Langaugae live prduct
		llLoginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		String[] profilePoints = llLoginPage.getStudentCoursePointsAndAcheivementsFromStudentProfilePage(llLoginPage);
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL, llData.llDistrictAdmin,
				llData.llDistrictAdmin, LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyLanguageLiveDashBoard();
		// To clicks on Classes tab
		classWallPage = llHomePage.clickOnClassesTab();
		// Clicks on Leader Boards tab
		leaderBoardsPage = classWallPage.clickLeaderBoardsTab();
		// Selects class from All classes drop down
		leaderBoardsPage.selectClassFromClassDropdown(llData.LLClassName + " LL");
		// Verifies that Leader Boards page is loaded
		leaderBoardsPage.verifyThatLeaderBoardsPageIsLoaded();
		// Clicks on course points sub tab and verifies whether it is loaded or
		// not
		leaderBoardsPage.clickCoursePointsTabAndVerify();
		// Clicks on year points sub tab and verifies whether it is loaded or
		// not
		leaderBoardsPage.clickYearSubtabAndVerify();
		// verifies Course points of student in year by comparing with the
		// course points read from student profile page
		leaderBoardsPage.verifyCoursePointsForStudentInYearTab(llData.teacherRoleLLStudentLastName,
				profilePoints[0]);
		// Clicks on Achievements points sub tab and verifies whether it is
		// loaded or not
		leaderBoardsPage.clickAchievementsTabAndVerify();
		// verifies Achievements points of student in year by comparing with the
		// Achievements points read from student profile page
		leaderBoardsPage.VerifyAchievementsForStudentInYear(llData.teacherRoleLLStudentLastName,
				profilePoints[1]);

	}
}
