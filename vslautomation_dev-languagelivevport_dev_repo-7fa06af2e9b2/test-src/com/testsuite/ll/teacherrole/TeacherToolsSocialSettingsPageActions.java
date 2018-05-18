package com.testsuite.ll.teacherrole;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.level1activities.TeacherHomePage.LLToolsTabReturnPage;
import com.page.module.ll.teacherrole.TeacherRoleSocialSettingsVerificationAsStudentPage;
import com.page.module.ll.teacherrole.TeacherRoleToolsPage;
import com.page.module.ll.teacherrole.TeacherToolsSocialSettingsPage;
import com.selenium.Sync;
import com.testng.Retry;

public class TeacherToolsSocialSettingsPageActions extends BaseSetup {
	
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLLogout lllogout;
	private TeacherHomePage teacherHomePage;
	private TeacherRoleToolsPage teacherRoleToolsPage;
	private TeacherToolsSocialSettingsPage teacherToolsSocialSettingsPage;
	private StudentWelcomePage studentWelcomePage;
	private LLActivity llactivity;
	private TeacherRoleSocialSettingsVerificationAsStudentPage teacherRoleSocialSettingsVerificationAsStudentPage;
	
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llData = new LLData();
		llloginPage= new LLLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		teacherRoleSocialSettingsVerificationAsStudentPage = new TeacherRoleSocialSettingsVerificationAsStudentPage(getDriver());
		getDriver().manage().deleteAllCookies();
		//getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();		
	}
	/**
	 * This test verifies class social settings for students 
	 */
	
	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_029_ToolsSocialSettingsClassSocialSettingsVerification(){

		
		
		//To navigate and To enter credentials and click on submit button of teacher user
		teacherHomePage=(TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername, llData.teacherRoleLLPassword,LLLoginReturnPage.TEACHER_HOME_PAGE);
		//To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		//To click on Tools link
		teacherRoleToolsPage=(TeacherRoleToolsPage) teacherHomePage.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		//To verify that tools page is loaded successfully
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		//To click on Social Settings tab under tools page
		teacherToolsSocialSettingsPage=teacherRoleToolsPage.clickOnSocialSettingsTab();
		//Verify that social settings tab content is loaded
		teacherToolsSocialSettingsPage.verifyThatSocialSettingsTabIsLoaded();
		//To verify and enable class Social settings 
		teacherToolsSocialSettingsPage.verifyAndEnableAllClassSocialSettings();	
		//To logout from the application as teacher user
		llloginPage = lllogout.clickLogoutfromHomePage();	
		//Login as student user 
		studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLStudentLastName,llData.teacherRoleLLStudentLastName,  LLLoginReturnPage.STUD_WELCOME_PAGE);
		//verify welcome page of the student user
		studentWelcomePage.verifywelcomePage();
		//click continue button
		llactivity=studentWelcomePage.welcomeButton();		
		//verifies home page
		llactivity.verifyHomepage();
		//Click on class tab
		teacherRoleSocialSettingsVerificationAsStudentPage.clickClassTab();
		//To verify that class wall tab is displayed for student user
		teacherRoleSocialSettingsVerificationAsStudentPage.verifyThatClassWallShareTextFieldIsDisplayedForStudent();
		//To verify that feedback tab is displayed for student user
		teacherRoleSocialSettingsVerificationAsStudentPage.verifyThatFeedbackTabIsDisplayedForStudent();		
		//To verify that leader boards section is displayed for student user
		teacherRoleSocialSettingsVerificationAsStudentPage.verifyThatLeaderBoardsSectionIsDisplayedForStudent();
		//To navigate to view profile page
		teacherRoleSocialSettingsVerificationAsStudentPage.navigateToViewProfilePage();
		//To verify that about me section is displayed with for student user
		teacherRoleSocialSettingsVerificationAsStudentPage.verifyThatAboutMeSectionIsDisplayedForStudent();	
		//Logout from application as student user
		llloginPage = lllogout.clickLogoutfromHomePage();		
	}
	
	/**
	 * This test verifies student social settings for the student users 
	 */
	
	@Test(groups = { "RC", "QC" },priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_030_ToolsSocialSettingsStudentSocialSettingsVerification(){
		//To enter credentials and click on submit button of teacher user
		teacherHomePage=(TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername, llData.teacherRoleLLPassword,LLLoginReturnPage.TEACHER_HOME_PAGE);
		//To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		//To click on Tools link
		teacherRoleToolsPage=(TeacherRoleToolsPage) teacherHomePage.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		//To verify that tools page is loaded successfully
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		//To click on Social Settings tab under tools page
		teacherToolsSocialSettingsPage=teacherRoleToolsPage.clickOnSocialSettingsTab();
		//Verify that social settings tab content is loaded
		teacherToolsSocialSettingsPage.verifyThatSocialSettingsTabIsLoaded();
		//To verify social settings for single student user. It disables wall posting and profile check boxes for the student user
		teacherToolsSocialSettingsPage.selectStudentSocialSettingsForSingleStudent(llData.teacherRoleLLStudentLastName);
		//To logout from the application as teacher user
		llloginPage = lllogout.clickLogoutfromHomePage();	
		//Login as student user 
		studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLStudentLastName,llData.teacherRoleLLStudentLastName,  LLLoginReturnPage.STUD_WELCOME_PAGE);
		//verify welcome page of the student user
		studentWelcomePage.verifywelcomePage();
		//click continue button
		llactivity=studentWelcomePage.welcomeButton();		
		//verifies home page
		llactivity.verifyHomepage();
		//Click on class tab
		teacherRoleSocialSettingsVerificationAsStudentPage.clickClassTab();	
		//To verify that student doesn't have access to class wall section
		teacherRoleSocialSettingsVerificationAsStudentPage.verifyThatClassWallSectionIsNotDisplayedForStudent();
		//To verify that feedback tab is not displayed for student user
		teacherRoleSocialSettingsVerificationAsStudentPage.verifyThatFeedbackTabIsNotDisplayedForStudent();
		//To verify that leader boards section is not displayed for student user 
		teacherRoleSocialSettingsVerificationAsStudentPage.verifyThatLeaderBoardsSectionIsNotDisplayedForStudent();
		//To navigate to view profile page
		teacherRoleSocialSettingsVerificationAsStudentPage.navigateToViewProfilePage();
		//To verify that about me section is disabled for student user
		teacherRoleSocialSettingsVerificationAsStudentPage.verifyThatAboutMeSectionIsNotDisplayedForStudent();
		//Logout from application as student user
		llloginPage = lllogout.clickLogoutfromHomePage();
		llloginPage.socialDefaultSettings(llloginPage);
	}	
}
