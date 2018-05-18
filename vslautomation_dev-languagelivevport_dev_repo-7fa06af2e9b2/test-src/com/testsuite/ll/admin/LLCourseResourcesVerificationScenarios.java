package com.testsuite.ll.admin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.admin.CourseResourcesPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.StudentCreation;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.level1activities.TeacherHomePage.LLToolsTabReturnPage;
import com.page.module.ll.teacherrole.TeacherRoleToolsPage;
import com.page.module.ll.teacherrole.TeacherToolsClassSettingsPage;
import com.page.module.ll.teacherrole.TeacherToolsCourseResourcesPage;
import com.selenium.Sync;
import com.testng.Retry;

public class LLCourseResourcesVerificationScenarios extends BaseSetup{

	private LLData llData;
	private LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	private LLLogout lllogout;
	CourseResourcesPage courseResourcesPage;
	private StudentCreation studentCreation;
	private String[] students;
	
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llData = new LLData();
		llLoginPage= new LLLoginPage(getDriver());
		lllogout = new LLLogout(getDriver());
		getDriver().manage().deleteAllCookies();
	}
	
	/**
	 *As a District User,This test clicks on a PDF file under 'Program planning' tab ,clicks on  video file under word training tab ,clicks on video file under the selected unit number under 'Text Training' tab of Tools->Course Resources page
	 * @throws Exception
	 */
	
	@Test(groups = { "DistrictUser", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_014_ToolsCourseResourcesProgramPlanningVerification()  {
	
		//To verify login page
		//To enter credentials and click on submit button
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//To verify that teacher is logged in successfully
		llHomePage.verifyDashBoardTab();
		//To click on Tools link
		courseResourcesPage=llHomePage.clickOnToolsTab();
		
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		//To click on posters tab under program planning section
		courseResourcesPage.clickOnProgramPlanningPostersTab();
		//To verify that posters tab is selected
		courseResourcesPage.verifyThatPostersTabIsSelected();
		//To click on first PDF file under Program Planning section
		courseResourcesPage.clickOnFirstPDFFileUnderProgramPlanningSection(isChromeBrowser());
		//To verify that PDF file is opened and close it
		courseResourcesPage.verifyThePdfFileLoadPageAndClose(isChromeBrowser(),llData.teacherRoleLLCourseResourcesProgramPlanningPDFURL);

	
	
		//To click on word training tab under course resources section
		courseResourcesPage.clickOnWordTrainingTabUnderCourseResourcesSection();
		//To verify that word training section is loaded successfully
		courseResourcesPage.verifyThatWordTrainingTabIsLoaded();
		//To select level under word training tab
		courseResourcesPage.clickOnLevelSelectionOption(llData.teacherRoleLLCourseResourcesWTLevel);
		//To click on a unit number under word training tab
		courseResourcesPage.clickOnWordTrainingTabUnitNumber(llData.teacherRoleLLCourseResourcesUnitNumber);
		//To verify a video file
		courseResourcesPage.verifyWordTrainingVideoFile();
	
	

		//To click on text training tab under course resources section
		courseResourcesPage.clickOnTextTrainingTabUnderCourseResourcesSection();
		//To verify that text training section is loaded successfully
		courseResourcesPage.verifyThatTextTrainingTabIsLoaded();
		//To select level under text training tab
		courseResourcesPage.clickOnTTLevelSelectionOption(llData.teacherRoleLLCourseResourcesTTLevel);
		//To click on a unit number under text training tab
		courseResourcesPage.clickOnTextTrainingTabUnitNumber(llData.teacherRoleLLCourseResourcesUnitNumber);
		//To verify a video file
		courseResourcesPage.verifyTextTrainingVideoFile(llData.teacherRoleLLCourseResourcesUnitNumber);
	}
	
	/**
	 *As a Campus User,This test clicks on a PDF file under 'Program planning' tab ,clicks on  video file under word training tab ,clicks on video file under the selected unit number under 'Text Training' tab of Tools->Course Resources page
	 * @throws Exception
	 */
	
	@Test(groups = { "CampusUser", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_013_ToolsCourseResourcesProgramPlanningVerification()  {
	
		//To verify login page
		//To enter credentials and click on submit button
		llHomePage=(LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
		//To verify that teacher is logged in successfully
		llHomePage.verifyDashBoardTab();
		//To click on Tools link
		courseResourcesPage=llHomePage.clickOnToolsTab();
		
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		//To click on posters tab under program planning section
		courseResourcesPage.clickOnProgramPlanningPostersTab();
		//To verify that posters tab is selected
		courseResourcesPage.verifyThatPostersTabIsSelected();
		//To click on first PDF file under Program Planning section
		courseResourcesPage.clickOnFirstPDFFileUnderProgramPlanningSection(isChromeBrowser());
		//To verify that PDF file is opened and close it
		courseResourcesPage.verifyThePdfFileLoadPageAndClose(isChromeBrowser(),llData.teacherRoleLLCourseResourcesProgramPlanningPDFURL);

	
	
		//To click on word training tab under course resources section
		courseResourcesPage.clickOnWordTrainingTabUnderCourseResourcesSection();
		//To verify that word training section is loaded successfully
		courseResourcesPage.verifyThatWordTrainingTabIsLoaded();
		//To select level under word training tab
		courseResourcesPage.clickOnLevelSelectionOption(llData.teacherRoleLLCourseResourcesWTLevel);
		//To click on a unit number under word training tab
		courseResourcesPage.clickOnWordTrainingTabUnitNumber(llData.teacherRoleLLCourseResourcesUnitNumber);
		//To verify a video file
		courseResourcesPage.verifyWordTrainingVideoFile();
	
	

		//To click on text training tab under course resources section
		courseResourcesPage.clickOnTextTrainingTabUnderCourseResourcesSection();
		//To verify that text training section is loaded successfully
		courseResourcesPage.verifyThatTextTrainingTabIsLoaded();
		//To select level under text training tab
		courseResourcesPage.clickOnTTLevelSelectionOption(llData.teacherRoleLLCourseResourcesTTLevel);
		//To click on a unit number under text training tab
		courseResourcesPage.clickOnTextTrainingTabUnitNumber(llData.teacherRoleLLCourseResourcesUnitNumber);
		//To verify a video file
		courseResourcesPage.verifyTextTrainingVideoFile(llData.teacherRoleLLCourseResourcesUnitNumber);
	}
	
/*	@AfterMethod(alwaysRun = true)
	public void logout() {		
		LLLogout lllogout = new LLLogout(getDriver());
		llLoginPage = lllogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();
	}*/
	
	
}
