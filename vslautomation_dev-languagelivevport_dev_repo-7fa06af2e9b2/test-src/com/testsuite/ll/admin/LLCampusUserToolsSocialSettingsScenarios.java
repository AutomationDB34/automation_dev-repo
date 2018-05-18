package com.testsuite.ll.admin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.page.module.ll.admin.CourseReportsPage;
import com.page.module.ll.admin.CourseResourcesPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.admin.SocialSettingsPage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherClassClassWallPage;
import com.page.module.ll.teacherrole.TeacherRoleClassPage;
import com.page.module.vport.VportLoginPage;
import com.testng.Retry;

public class LLCampusUserToolsSocialSettingsScenarios extends BaseSetup {

	LLData llData;
	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	CourseReportsPage courseReportsPage;
	VportLoginPage vportLoginPage;
	VportData vportData;
	CourseResourcesPage courseResourcesPage;
	SocialSettingsPage socialSettingsPage;
	TeacherHomePage teacherHomePage;
	TeacherRoleClassPage teacherRoleClassPage;
	TeacherClassClassWallPage teacherClassClassWallPage;


	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {

		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		getDriver().get(llData.URL);
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
	}
	/*	@AfterMethod
	public void logoutfromLL()
	{
		//Logouts from Language Live Home Page
		LLLogout llLogout = new LLLogout(getDriver());
		llLogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();
		}
	 */
	/**
	 * As a Campus user,This Test disables the check box of 'Enable wall posting for all classes' field in 'Tools'->'Social Settings' tab  and  verifies whether wall is displayed for Teacher  in 'Class'->'Class Page' 
	 * @throws Exception
	 */
	@Test(groups = {"CampusUser","QC" }, priority = 1,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_023_ToolsSchoolSocialSettingsfunctionalityVerification() throws Exception
	{	
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on District Settings Tab
		socialSettingsPage = courseResourcesPage.clickOnSocialSettingsTab();
		socialSettingsPage.verifySocialSettingsPageLoadedForCampusUser();	

		//Disables 'Enable wall posting for all classes' check box and save 
		socialSettingsPage.disableWallpostingForAllClassesCheckbox();
		socialSettingsPage.clickLogoutfromHomePage();
		socialSettingsPage.verifyLoginPage();
		//To verify login page
		//To enter login credentials and click sign in button
		teacherHomePage=(TeacherHomePage)llLoginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername, llData.teacherRoleLLPassword,LLLoginReturnPage.TEACHER_HOME_PAGE);
		//To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		//To click on class tab as teacher user
		teacherRoleClassPage=(TeacherRoleClassPage)teacherHomePage.clickOnClassTab();
		//To verify whether class page is loaded or not
		teacherRoleClassPage.verifyThatClassPageIsLoaded();
		teacherClassClassWallPage=teacherRoleClassPage.verifyThatClassTabIsLoadedWithAllTabsAndIcons();
		//Checks wall Post pane is displayed in classes page tab as a teacher 
		teacherClassClassWallPage.verifyWallPostPaneisNotDisplayed();
		//logoutfromLL();
		llLoginPage =teacherClassClassWallPage.clickLogoutfromHomePage();
		//Enables 'Enable wall posting for all classes' check box and save 
		llLoginPage.campusSocialSchoolDefaultSettings(llLoginPage);

	}

	@Test(groups = {"CampusUser","QC" }, priority = 2,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_024_ToolsClassroomSocialSetttingsFunctionalityVerification() throws Exception
	{	
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on District Settings Tab
		socialSettingsPage = courseResourcesPage.clickOnSocialSettingsTab();
		socialSettingsPage.verifySocialSettingsPageLoadedForCampusUser();	

		//Disables wall check box of teacher under 'Enable privilege' column  in 'Classroom Social Settings' pane and save
		socialSettingsPage.disableWallCheckboxOfTeacherInClassRoomSocialSettings(llData.teacherRoleLLUsername+" LL");
		socialSettingsPage.clickLogoutfromHomePage();
		socialSettingsPage.verifyLoginPage();

		//To enter login credentials and click sign in button
		teacherHomePage=(TeacherHomePage)llLoginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername, llData.teacherRoleLLPassword,LLLoginReturnPage.TEACHER_HOME_PAGE);
		//To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		//To click on class tab as teacher user
		teacherRoleClassPage=(TeacherRoleClassPage)teacherHomePage.clickOnClassTab();
		//To verify whether class page is loaded or not
		teacherRoleClassPage.verifyThatClassPageIsLoaded();
		teacherClassClassWallPage=teacherRoleClassPage.verifyThatClassTabIsLoadedWithAllTabsAndIcons();
		//Checks wall Post pane is displayed in classes page tab as a teacher 
		teacherClassClassWallPage.verifyWallPostPaneisNotDisplayed();
		//logoutfromLL();
		llLoginPage =teacherClassClassWallPage.clickLogoutfromHomePage();
		//Disables wall check box of teacher under 'Enable privilege' column  in 'Classroom Social Settings' pane and save
		llLoginPage.campusSocialClassDefaultSettings(llLoginPage);

	}

	/**
	 * This Test Verifies whether support pane is displayed in Tools->Social Settings page
	 * @throws Exception
	 */

	@Test(groups = {"CampusUser","RC" }, priority = 3,retryAnalyzer = Retry.class)
	public void LL_CAMPUSUSER_34_RC_ToolsSupportpaneVerification() 
	{	

		//		1.Login into application https://qa.languagelive.voyagersopris.com/services/logon
		//			2.After completion of Implementation cards
		//			3.User displayed with reports pages
		//			4.Now navigate to tools tab,it dispalyed with course resources,District settings,Social settings
		//			5.Navigate to social settings tab.
		//			6.Find that user enabled with District and campus social setting s and also support links
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on District Settings Tab
		socialSettingsPage = courseResourcesPage.clickOnSocialSettingsTab();
		socialSettingsPage.verifySocialSettingsPageLoadedForCampusUser();	
		socialSettingsPage.verifySupportPaneDisplayed();
		socialSettingsPage.verifyLinksDisplayedInSupportPane();
		socialSettingsPage.clickOnOnlineTrainingAndSupport();
		socialSettingsPage.clickLogoutfromHomePage();
		socialSettingsPage.verifyLoginPage();
	}
}
