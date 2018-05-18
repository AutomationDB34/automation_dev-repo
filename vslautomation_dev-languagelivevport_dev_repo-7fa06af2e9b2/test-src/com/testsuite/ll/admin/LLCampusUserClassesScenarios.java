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
import com.page.module.ll.admin.SchoolSettingsPage;
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
import com.utilities.UtilityMethods;

public class LLCampusUserClassesScenarios extends BaseSetup {
	LLData llData;
	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	StartupReportspage startupReportspage;
	ImplementationCardsPage implementationCardsPage;
	ClassWallPage classWallPage;
	TeacherHomePage teacherHomePage;
	TeacherRoleClassPage teacherRoleClassPage;
	TeacherClassClassWallPage teacherClassClassWallPage;
	ClassMatesPage classMatesPage;
	CourseResourcesPage courseResourcesPage;
	SchoolSettingsPage schoolettingsPage;
	VportLoginPage vportloginpage;
	VportData vportData;
	TestDependencyFunctions testDependencyFunctions;

	StudentWelcomePage studentWelcomePage;
	LLStudentHomePage llStudentHomePage;
	TeacherViewProfileAboutMePage teacherViewProfileAboutMePage;
	LeaderBoardsPage leaderBoardsPage;
	/*String studentCoursePointsFromStudentProfile;
	String studentAcheivementsFromStudentProfile;

	String assignmentTitle;
	int studentCountInRoster;
	String[] studentNamesInRoster;
	Object[] studentDetails;
	 */
	@BeforeMethod()
	public void BaseSetUp() {

		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		llData = new LLData();
		testDependencyFunctions = new TestDependencyFunctions(getDriver());
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();

	}

	/*	@AfterMethod
	public void logoutfromLL() {
		LLLogout llLogout = new LLLogout(getDriver());
		llLogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();
	}
	 */
	/**
	 * This Test Verifies Campus user can post in class wall in
	 * 'Classes'->'Class Wall' page and verifies assessments posted by teacher
	 * are displayed in Assessment tab
	 */

	@Test(groups = { "CampusUser", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_026_ClassessClassWallPageScenarios() {

		// Login into Langaugae live prduct
		llLoginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		// This methods login into LL as a teacher and posts assignment in Class
		// wall->Assignments sub tab
		String assignmentTitle = llLoginPage.postAssignmentinTeacherClassesPageandGetAssignmentName(llLoginPage);

		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL, llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyLanguageLiveDashBoard();
		// Clicks on Classes sub tab
		classWallPage = llHomePage.clickOnClassesTab();
		// Verify Class wall page is loaded
		classWallPage.verifyClassWallPageLoaded();
		// Clicks on All Sub tab in ClassWall page
		classWallPage.clickAllSubTab();
		// Selects class from Classes drop down in All sub tab
		classWallPage.selectClassFromClassDropdown(llData.LLClassName + " LL");
		String randomtxt = UtilityMethods.get4DRandomNumber();
		// Verify whether user can able to post the data in classs wall
		classWallPage.enterTextIntoClassWallFieldAndShare(llData.WallDescriptionData + randomtxt);
		// Verifies the posted data in class wall
		classWallPage.verifyWallPostDataSubmitted(llData.WallDescriptionData + randomtxt);
		classWallPage.clickAssignmentSubTab();
		// Verifies class wall posts are not displayed in Assessment sub tab
		classWallPage.verifyClassWallPostsNotDisplayedInAssigmentTab();
		// Verifies whether assignments posted by the teacher are displayed in
		// campus user Assignment tab
		classWallPage.verifyAssignmentsDisplayed(llData.teacherRoleLLUsername, assignmentTitle);
	}

	@Test(groups = { "CampusUser", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_027_ClassessClassMatesPageScenarios() {

		// Login into Langaugae live prduct
		llLoginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL, llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyLanguageLiveDashBoard();

		Object[] studentDetails = llHomePage.getStudentDetailsFromRosterTab(llHomePage);
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
		classMatesPage.verifyStudentsCountinClassMatesTab((Integer) studentDetails[0]);
		// Verifies the students displayed in Students pane
		ArrayList<String> al = (ArrayList<String>) studentDetails[1];
		String[] stuNames = new String[al.size()];
		stuNames = al.toArray(stuNames);
		classMatesPage.verifyStudentNamesinClassMatesTab(stuNames);
	}

	@Test(groups = { "CampusUser", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_028_ClassessLeaderBoardsPageScenarios() {

		// Login into Langaugae live prduct
		llLoginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();

		String[] profilePoints = llLoginPage.getStudentCoursePointsAndAcheivementsFromStudentProfilePage(llLoginPage);

		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL, llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
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
		leaderBoardsPage.verifyCoursePointsForStudentInYearTab(llData.teacherRoleLLStudentLastName, profilePoints[0]);
		// Clicks on Achievements points sub tab and verifies whether it is
		// loaded or not
		leaderBoardsPage.clickAchievementsTabAndVerify();
		// verifies Achievements points of student in year by comparing with the
		// Achievements points read from student profile page
		leaderBoardsPage.VerifyAchievementsForStudentInYear(llData.teacherRoleLLStudentLastName, profilePoints[1]);
	}

}
