package com.testsuite.ll.admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.admin.CourseReportsPage;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.admin.NotificationReportsPage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.level1activities.TeacherHomePage.LLToolsTabReturnPage;
import com.page.module.ll.teacherrole.TeacherRoleToolsPage;
import com.page.module.ll.teacherrole.TeacherToolsReviewPage;
import com.testng.Retry;

public class LLNotificationReportsScenarios extends BaseSetup {

	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	CourseReportsPage courseReportsPage;
	LLData llData;
	TeacherHomePage teacherHomePage;
	TeacherRoleToolsPage teacherRoleToolsPage;
	TeacherToolsReviewPage teacherToolsReviewPage;
	NotificationReportsPage notificationReportsPage;
	ImplementationCardsPage implementationCardsPage;
	/*int WTCount;
	int autoPassCount;*/



	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {

		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
	}

	/*	
	@AfterMethod(alwaysRun=true)
	public void logoutfromLL()
	{
		LLLogout llLogout = new LLLogout(getDriver());
		llLogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();

	}*/
	/**
	 * As a District User, this Test verifies Notification reports page Data in All,Last 4 weeks and Last 90 days tabs by comparing Goal Reviews->Open  count and Auto passes-> Open count with the data read from teacher user-> Tools->Review Page 
	 * @throws Exception
	 */

	@Test(groups = {"DistrictUser","QC" }, priority =1,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_013_VerifyNotificationReportsData() {

		//Login with teacher credentials into LL
		teacherHomePage=(TeacherHomePage) llLoginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername, llData.teacherRoleLLPassword,LLLoginReturnPage.TEACHER_HOME_PAGE);
		//To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		teacherRoleToolsPage=(TeacherRoleToolsPage) teacherHomePage.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		//To verify whether tools page is loaded or not
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		//To verify that tools page is loaded with all it's tabs(review, Assignments, Moderation, Course Resources, Class Settings, and Social Settings) and icons
		teacherToolsReviewPage=teacherRoleToolsPage.verifyThatToolsTabIsLoadedWithAllTabsAndIcons();
		//To get WT count from Reviews  table in  Tools->Review Page 
		int WTCount=teacherToolsReviewPage.getNumberofWTActivitiesNeedtoReviewd();
		teacherToolsReviewPage.clickOnAlertsTab();
		//To get auto pass type count from Alerts tab in Tools->Review Page 
		int autoPassCount=teacherToolsReviewPage.getNumberofAutoPassTypesActivitiesNeedtoReviewd();


		llHomePage=(LLHomePage)llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyDashBoardTab();
		llHomePage.verifyAllFramesEnabledInHomePageforDistrictUser();
		//To clicks on Notification reports tab
		notificationReportsPage=llHomePage.clickNotificationReportTab();
		//To click on All filter tab and verifies whether it is loaded or not 
		notificationReportsPage.clickAllFiltertab();
		notificationReportsPage.verifyAllFilterPageLoaded();
		//To verify goal reviews->Open count  in All tab with the WTCount read from the teacher Tools->Review Page 
		notificationReportsPage.verifyGoalReviewsOpenCountinAlltab(WTCount, llData.LLSchoolName);
		//To verify Auto Pass->Open count  in All tab with the Auto pass count  read from the teacher Tools->Review Page 
		notificationReportsPage.verifyAutoPasssesOpenCountinAlltab(autoPassCount, llData.LLSchoolName);
		//To click on Last 4 weeks  tab and verifies whether it is loaded or not 
		notificationReportsPage.clickLast4WeeksFiltertab();
		notificationReportsPage.verifyLast4WeeksFilterPageLoaded();
		//To click on Last 90 Days  tab and verifies whether it is loaded or not 
		notificationReportsPage.clickLast90DaysFiltertab();
		notificationReportsPage.verifyLast90DaysFilterPageLoaded();


	}
	/**
	 * As a Campus User, this Test verifies Notification reports page Data in All,Last 4 weeks and Last 90 days tabs by comparing Goal Reviews->Open  count and Auto passes-> Open count with the data read from teacher user->  Tools->Review Page 
	 * @throws Exception
	 */
	@Test(groups = {"CampusUser","QC" }, priority = 2,retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_012_VerifyNotificationReportsData() {


		//Login with teacher credentials into LL
		teacherHomePage=(TeacherHomePage) llLoginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername, llData.teacherRoleLLPassword,LLLoginReturnPage.TEACHER_HOME_PAGE);
		//To verify that teacher user is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		teacherRoleToolsPage=(TeacherRoleToolsPage) teacherHomePage.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		//To verify whether tools page is loaded or not
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		//To verify that tools page is loaded with all it's tabs(review, Assignments, Moderation, Course Resources, Class Settings, and Social Settings) and icons
		teacherToolsReviewPage=teacherRoleToolsPage.verifyThatToolsTabIsLoadedWithAllTabsAndIcons();
		//To get WT count from Reviews  table in  Tools->Review Page 
		int WTCount=teacherToolsReviewPage.getNumberofWTActivitiesNeedtoReviewd();
		teacherToolsReviewPage.clickOnAlertsTab();
		//To get auto pass type count from Alerts tab in Tools->Review Page 
		int autoPassCount=teacherToolsReviewPage.getNumberofAutoPassTypesActivitiesNeedtoReviewd();



		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		llHomePage.verifyDashBoardTab();
		llHomePage.verifyAllFramesEnabledInHomePageforCampusUser();
		//To clicks on Notification reports tab
		notificationReportsPage=llHomePage.clickNotificationReportTab();
		//To click on All filter tab and verifies whether it is loaded or not 
		notificationReportsPage.clickAllFiltertab();
		notificationReportsPage.verifyAllFilterPageLoaded();
		//To verify goal reviews->Open count  in All tab with the WTCount read from the teacher Tools->Review Page 
		notificationReportsPage.verifyGoalReviewsOpenCountinAlltab(WTCount, llData.teacherLLUsername+" LL");
		//To verify Auto Pass->Open count  in All tab with the Auto pass count  read from the teacher Tools->Review Page 
		notificationReportsPage.verifyAutoPasssesOpenCountinAlltab(autoPassCount, llData.teacherLLUsername+" LL");
		//To click on Last 4 weeks  tab and verifies whether it is loaded or not 
		notificationReportsPage.clickLast4WeeksFiltertab();
		notificationReportsPage.verifyLast4WeeksFilterPageLoaded();
		//To click on Last 90 Days  tab and verifies whether it is loaded or not 
		notificationReportsPage.clickLast90DaysFiltertab();
		notificationReportsPage.verifyLast90DaysFilterPageLoaded();


	}

}
