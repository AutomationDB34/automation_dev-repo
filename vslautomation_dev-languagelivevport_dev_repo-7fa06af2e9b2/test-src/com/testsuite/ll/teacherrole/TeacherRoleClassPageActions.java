package com.testsuite.ll.teacherrole;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherClassClassResourcesPage;
import com.page.module.ll.teacherrole.TeacherClassClassWallPage;
import com.page.module.ll.teacherrole.TeacherClassClassmatesPage;
import com.page.module.ll.teacherrole.TeacherClassEbooksPage;
import com.page.module.ll.teacherrole.TeacherClassLeaderboardsPage;
import com.page.module.ll.teacherrole.TeacherClassReadingScapePage;
import com.page.module.ll.teacherrole.TeacherRoleClassPage;
import com.selenium.Sync;
import com.testng.Retry;

public class TeacherRoleClassPageActions extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLLogout lllogout;
	private TeacherRoleClassPage teacherRoleClassPage;
	private TeacherClassClassWallPage teacherClassClassWallPage;
	private TeacherHomePage teacherHomePage;
	private TeacherClassClassmatesPage teacherClassClassmatesPage;
	private TeacherClassReadingScapePage teacherClassReadingScapePage;
	private TeacherClassEbooksPage teacherClassEbooksPage;
	private TeacherClassClassResourcesPage teacherClassClassResourcesPage;
	private TeacherClassLeaderboardsPage teacherClassLeaderboardsPage;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llData = new LLData();
		llloginPage = new LLLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		getDriver().manage().deleteAllCookies();
		//getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();
	}

	/**
	 * This test verifies that Class page is loaded with the tabs Classmates,
	 * Class Resources,Reading Scape, ebooks andLeaderboards along with their
	 * icons
	 */

	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_037_ClassPageVerification() {

		// To verify login page
		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on class tab as teacher user
		teacherRoleClassPage = (TeacherRoleClassPage) teacherHomePage.clickOnClassTab();
		// To verify whether class page is loaded or not
		teacherRoleClassPage.verifyThatClassPageIsLoaded();
		// To verify that tools page is loaded with all it's tabs(review,
		// Assignments, Moderation, Course Resources, Class Settings, and Social
		// Settings) and icons
		teacherClassClassWallPage = teacherRoleClassPage.verifyThatClassTabIsLoadedWithAllTabsAndIcons();
		// Logout form the application
		teacherClassClassWallPage.clickLogoutfromHomePage();
		teacherClassClassWallPage.verifyLoginPage();
	}

	/**
	 * This test assigns new assignment and verifies it's dates under posted
	 * area section
	 */

	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_038_ClassPageAssignmentsVerification() {
		// To verify login page
		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on class tab as teacher user
		teacherRoleClassPage = (TeacherRoleClassPage) teacherHomePage.clickOnClassTab();
		// To verify whether class page is loaded or not
		teacherRoleClassPage.verifyThatClassPageIsLoaded();
		// To click on Assignment tab
		teacherClassClassWallPage = teacherRoleClassPage.clickOnAssignmentTabInClsasWall();
		// To verify the navigation to share assignment section
		teacherClassClassWallPage.verifyThatAssignmentSectionIsLoaded();
		// To share new assignment and verify it
		teacherClassClassWallPage.addNewAssignmentAndVerify(
				llData.teacherRoleLLClassWallAssignmentTitle + System.currentTimeMillis(),
				llData.teacherRoleLLClassWallAssignmentDesc + System.currentTimeMillis(),
				llData.teacherRoleLLClassWallAssignmentCredit, llData.teacherRoleLLClassWallAssignmentTimeInHours,
				llData.teacherRoleLLClassWallAssignmentTimeInMinutes,
				llData.teacherRoleLLClassWallAssignmentTimeInAMPM);
		// Logout form the application
		teacherClassClassWallPage.clickLogoutfromHomePage();
		teacherClassClassWallPage.verifyLoginPage();
	}

	/**
	 * This test verifies page loading of classmates page
	 */

	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_039_ClassClassmatesPageVerification() {
		// To verify login page
		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on class tab as teacher user
		teacherRoleClassPage = (TeacherRoleClassPage) teacherHomePage.clickOnClassTab();
		// To verify whether class page is loaded or not
		teacherRoleClassPage.verifyThatClassPageIsLoaded();
		// To click on classmates tab
		teacherClassClassmatesPage = teacherRoleClassPage.clickOnClassmatesTab();
		// To verify that classmates page is loaded successfully
		teacherClassClassmatesPage.verifyThatClassmatesPageIsLoaded();
		teacherClassClassmatesPage.verifyAboutMeProfile(llData);
		// Logout form the application
		teacherClassClassmatesPage.clickLogoutfromHomePage();
		teacherClassClassmatesPage.verifyLoginPage();
	}

	/**
	 * This test verifies page loading of ReadingScape page
	 */

	@Test(groups = { "RC", "QC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_040_ClassReadingScapePageVerification() {
		// To verify login page
		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on class tab as teacher user
		teacherRoleClassPage = (TeacherRoleClassPage) teacherHomePage.clickOnClassTab();
		// To verify whether class page is loaded or not
		teacherRoleClassPage.verifyThatClassPageIsLoaded();
		// To click on classmates tab
		teacherClassReadingScapePage = teacherRoleClassPage.clickOnReadingScapeTab();
		// To verify that ReadingScape page is loaded successfully
		teacherClassReadingScapePage.verifyThatReadingScapePageIsDisplayed();
		// Logout form the application
		teacherClassReadingScapePage.clickLogoutfromHomePage();
		teacherClassReadingScapePage.verifyLoginPage();
	}

	/**
	 * This test verifies page loading of eBooks page
	 */

	@Test(groups = { "RC", "QC" }, priority = 5, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_041_ClassEBooksPageVerification() {
		// To verify login page
		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on class tab as teacher user
		teacherRoleClassPage = (TeacherRoleClassPage) teacherHomePage.clickOnClassTab();
		// To verify whether class page is loaded or not
		teacherRoleClassPage.verifyThatClassPageIsLoaded();
		// To click on eBooks tab
		teacherClassEbooksPage = teacherRoleClassPage.clickOnEBooksTab();
		// To verify that eBooks page is loaded successfully
		teacherClassEbooksPage.verifyThatEBooksPageIsDisplayed();
		// Logout form the application
		teacherClassEbooksPage.clickLogoutfromHomePage();
		teacherClassEbooksPage.verifyLoginPage();
	}

	/**
	 * This test verifies page loading of Class Resources page
	 */

	@Test(groups = { "RC", "QC" }, priority = 6, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_042_ClassClassResourcesPageVerification() {
		// To verify login page
		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on class tab as teacher user
		teacherRoleClassPage = (TeacherRoleClassPage) teacherHomePage.clickOnClassTab();
		// To verify whether class page is loaded or not
		teacherRoleClassPage.verifyThatClassPageIsLoaded();
		// To click on class Resources tab
		teacherClassClassResourcesPage = teacherRoleClassPage.clickOnClassResourcesTab();
		// To verify that Class Resources tab is loaded successfully
		teacherClassClassResourcesPage.verifyThatClassResourcesPageIsLoaded();
		// To select a level and verify the page loading
		teacherClassClassResourcesPage.classClassResourcesPageVerification(llData);
		
		// Logout form the application
		teacherClassClassResourcesPage.clickLogoutfromHomePage();
		teacherClassClassResourcesPage.verifyLoginPage();
	}

	/**
	 * This test verifies page loading of leader boards page
	 */

	@Test(groups = { "RC", "QC" }, priority = 7, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_043_ClassClassLeaderboardsPageVerification() {
		// To verify login page
		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on class tab as teacher user
		teacherRoleClassPage = (TeacherRoleClassPage) teacherHomePage.clickOnClassTab();
		// To click on leader boards tab
		teacherClassLeaderboardsPage = teacherRoleClassPage.clickOnLeaderboardsTab();
		// To verify that leader boards page is loaded successfully
		teacherClassLeaderboardsPage.verifyThatLeaderBoardsPageIsLoaded();
		// To select a level and verify leader boards page loading
	
		teacherClassLeaderboardsPage.classLeaderboardsPageVerification(llData);
		// Logout form the application
		teacherClassLeaderboardsPage.clickLogoutfromHomePage();
		teacherClassLeaderboardsPage.verifyLoginPage();
	}
}
