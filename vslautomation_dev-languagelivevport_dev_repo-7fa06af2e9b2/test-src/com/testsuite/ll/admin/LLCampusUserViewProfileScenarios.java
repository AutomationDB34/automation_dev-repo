package com.testsuite.ll.admin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherViewProfileAboutMePage;
import com.page.module.ll.teacherrole.TeacherViewProfileAchievementsPage;
import com.page.module.ll.teacherrole.TeacherViewProfileAvatarEditorPage;
import com.selenium.Sync;
import com.testng.Retry;

public class LLCampusUserViewProfileScenarios extends BaseSetup {
	
	private LLData llData;
	private LLLoginPage llLoginPage;
	private LLLogout lllogout;
	private TeacherHomePage teacherHomePage;
	private LLActivity llactivity;
	LLHomePage llHomePage;
	TeacherViewProfileAboutMePage teacherViewProfileAboutMePage;
	TeacherViewProfileAchievementsPage teacherViewProfileAchievementsPage;
	TeacherViewProfileAvatarEditorPage teacherViewProfileAvatarEditorPage;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llData = new LLData();
		llLoginPage= new LLLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		
	}

	/**
	 * This Test Verifies Campus user can edit own profile in view Profile->About Me page  
	 */

	@Test(groups = {"CampusUser","QC" }, priority = 1,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_031_ViewProfileAboutMePageScenarios() 
	{
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Navigate to View Profile page by clicking 'View Profile' link 
		teacherViewProfileAboutMePage = llHomePage.navigateToViewProfile();	
		teacherViewProfileAboutMePage.verifyThatViewProfileAboutMePageIsLoaded();
		
		//Verifies that View profile page is loaded or not 
		teacherViewProfileAboutMePage.verifyThatViewProfileAboutMePageIsLoaded();
		Long currentTime=System.currentTimeMillis();
		//In Edit Profile Information page, enters text into Birthplace field and saves 
		teacherViewProfileAboutMePage.editProfileOfUser(llData.UserProfileBirthPlace+currentTime);
		//Verify Birth place value is displayed correctly in profile pane of About me Page 
		teacherViewProfileAboutMePage.verifyProfileOfUserAfterEdit(llData.UserProfileBirthPlace+currentTime);
	}

/**
 * This Test Verifies whether Badges & Certificates panes are  displayed in View Profile->Achievements page as a campus user
 */

@Test(groups = {"CampusUser","QC" }, priority = 2,retryAnalyzer = Retry.class, timeOut = 1000000)
public void LL_CAMPUSUSER_032_ViewProfileAchievementsPageScenarios()
{
	llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
	// After login into application, verifies Dash board is loaded
	llHomePage.verifyDashBoardTab();
	// Navigate to View Profile page by clicking 'View Profile' link 
	teacherViewProfileAboutMePage = llHomePage.navigateToViewProfile();	
	teacherViewProfileAboutMePage.verifyThatViewProfileAboutMePageIsLoaded();
	
	//Clicks on Achievements tab
	teacherViewProfileAchievementsPage=teacherViewProfileAboutMePage.clickOnAchievementsTab();
	//verify Achievements tab is loaded with Badges and Certificates
	teacherViewProfileAchievementsPage.verifyAchievementsPageIsLoaded();
	
}
 
/**
 * This test verifies View Profile->Avatar Editor page loading as a Campus user
 * @throws Exception
 */

@Test(groups = {"CampusUser","QC" },priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
public void LL_CAMPUSUSER_033_ViewProfileAvatarEditorPageVerification() throws Exception {
	
	llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
	// After login into application, verifies Dash board is loaded
	llHomePage.verifyDashBoardTab();
	// Navigate to View Profile page by clicking 'View Profile' link 
	teacherViewProfileAboutMePage = llHomePage.navigateToViewProfile();	
	teacherViewProfileAboutMePage.verifyThatViewProfileAboutMePageIsLoaded();
	
	teacherViewProfileAvatarEditorPage=teacherViewProfileAboutMePage.clickOnAvatorEditorTab();
	//To verify that Avatar Editor page is loaded successfully
	teacherViewProfileAvatarEditorPage.verifyThatAvatarEditorTabIsLoaded();
}

/*
	@AfterMethod(alwaysRun=true)
	public void logoutfromLL()
	{
		LLLogout llLogout = new LLLogout(getDriver());
		llLogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();
	}*/

}
