package com.testsuite.ll.teacherrole;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherRoleDictionaryPage;
import com.page.module.ll.teacherrole.TeacherRoleMicrophoneTestPage;
import com.page.module.ll.teacherrole.TeacherRoleViewProfilePage;
import com.page.module.ll.teacherrole.TeacherViewProfileAboutMePage;
import com.page.module.ll.teacherrole.TeacherViewProfileAvatarEditorPage;
import com.page.module.ll.teacherrole.TeacherViewProfileClassmatesPage;
import com.selenium.Sync;
import com.testng.Retry;

public class TeacherViewProfileDictionaryCheckMicPageActions extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLLogout lllogout;
	private TeacherHomePage teacherHomePage;
	private TeacherRoleViewProfilePage teacherRoleViewProfilePage;
	private TeacherViewProfileAboutMePage teacherViewProfileAboutMePage;
	private TeacherViewProfileClassmatesPage teacherViewProfileClassmatesPage;
	private TeacherViewProfileAvatarEditorPage teacherViewProfileAvatarEditorPage;
	private TeacherRoleDictionaryPage teacherRoleDictionaryPage;
	private TeacherRoleMicrophoneTestPage teacherRoleMicrophoneTestPage;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception
	{
		llData = new LLData();
		llloginPage = new LLLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		getDriver().manage().deleteAllCookies();
		//getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();
	}

	/**
	 * This test verifies that 'View Profile' page is loaded with all tabs(About
	 * me, Achievements, classmates and avatar editor) and their icons
	 */

	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_045_ViewProfilePageVerification() {

		
		// To enter URL To enter credentials and click on submit button of teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on User menu->View Profile link
		teacherRoleViewProfilePage = (TeacherRoleViewProfilePage) teacherHomePage.clickUsermenuViewProfileLink();
		// To verify that view profile page is loaded successfully
		teacherRoleViewProfilePage.verifyThatViewProfilePageIsLoaded();
		// To verify that View Profile page is loaded with all tabs(About me,
		// achievements, classmates and Avatar Editor) and icons
		teacherRoleViewProfilePage.verifyThatViewProfilePageIsLoadedWithAllTabsAndIcons();
		// Logout form the application
		teacherRoleViewProfilePage.clickLogoutfromHomePage();
		teacherRoleViewProfilePage.verifyLoginPage();
	}

	/**
	 * This test verifies page loading of View Profile->About me section
	 */

	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_046_ViewProfileAboutMePageVerification() 
	{
		// To enter credentials and click on submit button of teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on User menu->View Profile link
		teacherRoleViewProfilePage = (TeacherRoleViewProfilePage) teacherHomePage.clickUsermenuViewProfileLink();
		// To verify that view profile page is loaded successfully
		teacherRoleViewProfilePage.verifyThatViewProfilePageIsLoaded();
		// To click on About Me tab
		teacherViewProfileAboutMePage = teacherRoleViewProfilePage.clickOnAboutMeTab();
		// To verify that view profile->about me page is loaded successfully
		teacherViewProfileAboutMePage.viewProfileAboutMePageVerification(llData);
		// Logout form the application
		teacherViewProfileAboutMePage.clickLogoutfromHomePage();
		teacherViewProfileAboutMePage.verifyLoginPage();
	}

	/**
	 * This test verifies View Profile->Classmates page loading
	 */

	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_047_ViewProfileClassmatesPageVerification() 
	{
		// To enter credentials and click on submit button of teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on User menu->View Profile link
		teacherRoleViewProfilePage = (TeacherRoleViewProfilePage) teacherHomePage.clickUsermenuViewProfileLink();
		// To verify that view profile page is loaded successfully
		teacherRoleViewProfilePage.verifyThatViewProfilePageIsLoaded();
		// To click on Classmates tab under View profile page
		teacherViewProfileClassmatesPage = teacherRoleViewProfilePage.clickOnClassmatesTab();
		// To verify that Classmates page is loaded successfully
		teacherViewProfileClassmatesPage.verifyThatClassmatesTabIsLoaded();
		teacherViewProfileClassmatesPage.verifyAboutMeProfile(llData);
		// Logout form the application
		teacherViewProfileClassmatesPage.clickLogoutfromHomePage();
		teacherViewProfileClassmatesPage.verifyLoginPage();
	}

	/**
	 * This test verifies View Profile->Avatar Editor page loading
	 */

	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_048_ViewProfileAvatarEditorPageVerification() 
	{
		// To enter credentials and click on submit button of teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on User menu->View Profile link
		teacherRoleViewProfilePage = (TeacherRoleViewProfilePage) teacherHomePage.clickUsermenuViewProfileLink();
		// To verify that view profile page is loaded successfully
		teacherRoleViewProfilePage.verifyThatViewProfilePageIsLoaded();
		// To click on Avatar Editor tab under View profile page
		teacherViewProfileAvatarEditorPage = teacherRoleViewProfilePage.clickOnAvatarEditorTab();
		// To verify that Avatar Editor page is loaded successfully
		teacherViewProfileAvatarEditorPage.verifyThatAvatarEditorTabIsLoaded();
		// Logout form the application
		teacherViewProfileAvatarEditorPage.clickLogoutfromHomePage();
		teacherViewProfileAvatarEditorPage.verifyLoginPage();
	}

	/**
	 * This test verifies User menu->Dictionary page loading
	 * 
	 * @throws Exception
	 */

	@Test(groups = { "RC",
			"QC" }, dependsOnMethods = "LL_Teacher_048_ViewProfileAvatarEditorPageVerification", priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_049_UsermenuDictionaryPageVerification() throws Exception {
		
		// To enter credentials and click on submit button of teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on dictionary link under user menu
		teacherRoleDictionaryPage = teacherHomePage.clickUsermenuDictionaryLink();
		// To verify that dictionary pop-up is displayed
		teacherRoleDictionaryPage.verifyThatUsermenuDictionaryPopupIsDisplayed();
		// To close Dictionary pop-up
		teacherRoleDictionaryPage.closeUsermenuDictionaryPopup();
		// Logout form the application
		teacherRoleDictionaryPage.clickLogoutfromHomePage();
		teacherRoleDictionaryPage.verifyLoginPage();
	}

	/**
	 * This test verifies User menu->check mic(or microphone test) page loading
	 */
	@Test(groups = { "RC","QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_050_UsermenuMicrophoneTestPageVerification(){
		
		// To enter credentials and click on submit button of teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on check mic link under user menu
		teacherRoleMicrophoneTestPage = teacherHomePage.clickUsermenuCheckMicLink();
		// To verify that microphone test pop-up is displayed
		teacherRoleMicrophoneTestPage.verifyThatUsermenuMicrophonePopupIsDisplayed();
		// To close microphone pop-up
		teacherRoleMicrophoneTestPage.closeUsermenuMicrophonePopup();
		// Logout form the application
		teacherRoleMicrophoneTestPage.clickLogoutfromHomePage();
		teacherRoleMicrophoneTestPage.verifyLoginPage();
	}
}
