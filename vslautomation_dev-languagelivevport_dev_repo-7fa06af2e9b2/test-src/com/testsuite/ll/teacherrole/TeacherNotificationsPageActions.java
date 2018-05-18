package com.testsuite.ll.teacherrole;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherRoleNotificationsPage;
import com.selenium.Sync;
import com.testng.Retry;

public class TeacherNotificationsPageActions extends BaseSetup{

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLLogout lllogout;
	private TeacherHomePage teacherHomePage;
	private LLActivity llactivity;
	private TeacherRoleNotificationsPage teacherRoleNotificationsPage;
	
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llData = new LLData();
		llloginPage= new LLLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		getDriver().manage().deleteAllCookies();
		//getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();		
	}
	
	/**
	 * This test navigates to notifications page and verifies that some notifications are displayed 
	 */
	
	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_044_NotificationsPageVerification(){
	
		//To verify login page
		//To enter credentials and click on submit button of teacher user
		teacherHomePage=(TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername, llData.teacherRoleLLPassword,LLLoginReturnPage.TEACHER_HOME_PAGE);
		//To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		//To click on notifications tab or link
		teacherRoleNotificationsPage=(TeacherRoleNotificationsPage) teacherHomePage.clickOnNotificationsTab();
		//To verify that Notifications page is loaded successfully with some notifications or no notifications message
		teacherRoleNotificationsPage.verifyThatNotificationsPageIsLoadedWithOrWithoutNotifications();
		// Logout form the application
		teacherRoleNotificationsPage.clickLogoutfromHomePage();
		teacherRoleNotificationsPage.verifyLoginPage();
	}
}
