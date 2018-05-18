package com.testsuite.ll.teacherrole;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
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

public class TeacherRoleToolsCourseResourcesClassSettingsPage extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLLogout lllogout;
	private TeacherHomePage teacherHomePage;
	private TeacherRoleToolsPage teacherRoleToolsPage;
	private TeacherToolsCourseResourcesPage teacherToolsCourseResourcesPage;
	private TeacherToolsClassSettingsPage teacherToolsClassSettingsPage;
	private StudentCreation studentCreation;
	private String[] students;

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
	 * This test clicks on a PDF file under 'Program planning' tab of
	 * Tools->Class Resources page
	 * 
	 * @throws Exception
	 */

	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_021_ToolsCourseResourcesProgramPlanningVerification() throws Exception {

		
		// To enter credentials and click on submit button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools link
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify that tools page is loaded successfully
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// To click on Course Resources tab
		teacherToolsCourseResourcesPage = teacherRoleToolsPage.clickOnCourseResourcesTab();
		// To verify that program planning tab section is loaded properly
		teacherToolsCourseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// To click on posters tab under program planning section
		teacherToolsCourseResourcesPage.clickOnProgramPlanningPostersTab();
		// To verify that posters tab is selected
		teacherToolsCourseResourcesPage.verifyThatPostersTabIsSelected();
		// To click on first PDF file under Program Planning section
		teacherToolsCourseResourcesPage.clickOnFirstPDFFileUnderProgramPlanningSection(isChromeBrowser());
		// To verify that PDF file is opened and close it
		teacherToolsCourseResourcesPage.verifyThePdfFileLoadPageAndClose(isChromeBrowser(),
				llData.teacherRoleLLCourseResourcesProgramPlanningPDFURL);
		// Logout form the application
		teacherToolsCourseResourcesPage.clickLogoutfromHomePage();
		teacherToolsCourseResourcesPage.verifyLoginPage();
	}

	/**
	 * This test clicks on video file under word training tab section of
	 * Tools->Course Resources page
	 */

	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_022_ToolsCourseResourcesWordTrainingVerification() {

		
		// To enter credentials and click on submit button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools link
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify that tools page is loaded successfully
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// To click on Course Resources tab
		teacherToolsCourseResourcesPage = teacherRoleToolsPage.clickOnCourseResourcesTab();
		// To click on word training tab under course resources section
		teacherToolsCourseResourcesPage.clickOnWordTrainingTabUnderCourseResourcesSection();
		// To verify that word training section is loaded successfully
		teacherToolsCourseResourcesPage.verifyThatWordTrainingTabIsLoaded();
		// To select level under word training tab
		teacherToolsCourseResourcesPage.clickOnLevelSelectionOption(llData.teacherRoleLLCourseResourcesWTLevel);
		// To click on a unit number under word training tab
		teacherToolsCourseResourcesPage.clickOnWordTrainingTabUnitNumber(llData.teacherRoleLLCourseResourcesUnitNumber);
		// To verify a video file
		teacherToolsCourseResourcesPage.verifyWordTrainingVideoFile();
		// Logout form the application
		teacherToolsCourseResourcesPage.clickLogoutfromHomePage();
		teacherToolsCourseResourcesPage.verifyLoginPage();
	}

	/**
	 * This test clicks on a video file under the selected unit number under
	 * 'Text Training' tab of Tools->Course Resources page
	 */

	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_023_ToolsCourseResourcesTextTrainingVerification() {
		
		// To enter credentials and click on submit button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools link
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify that tools page is loaded successfully
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// To click on Course Resources tab
		teacherToolsCourseResourcesPage = teacherRoleToolsPage.clickOnCourseResourcesTab();
		// To click on text training tab under course resources section
		teacherToolsCourseResourcesPage.clickOnTextTrainingTabUnderCourseResourcesSection();
		// To verify that text training section is loaded successfully
		teacherToolsCourseResourcesPage.verifyThatTextTrainingTabIsLoaded();
		// To select level under text training tab
		teacherToolsCourseResourcesPage.clickOnTTLevelSelectionOption(llData.teacherRoleLLCourseResourcesTTLevel);
		// To click on a unit number under text training tab
		teacherToolsCourseResourcesPage.clickOnTextTrainingTabUnitNumber(llData.teacherRoleLLCourseResourcesUnitNumber);
		// To verify a video file
		teacherToolsCourseResourcesPage.verifyTextTrainingVideoFile(llData.teacherRoleLLCourseResourcesUnitNumber);
		// Logout form the application
		teacherToolsCourseResourcesPage.clickLogoutfromHomePage();
		teacherToolsCourseResourcesPage.verifyLoginPage();
	}

	/**
	 * This test verifies loading of Summary Section under Tools->Class Settings
	 * page. Also, verifies student count under implementation summary table and
	 * the students in Roster(i.e. the count displayed on top of 'Add' button)
	 */

	@Test(groups = { "RC", "QC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_024_ToolsClassSettingsSummaryVerification() {

	
		// To enter credentials and click on submit button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools link
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify that tools page is loaded successfully
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// To click on Class Settings tab under Tools page
		teacherToolsClassSettingsPage = teacherRoleToolsPage.clickOnClassSettingsTab();
		// To verify student counts under summary section
		teacherToolsClassSettingsPage.verifyTheDataUnderSummaryTab();
		// Logout form the application
		teacherToolsClassSettingsPage.clickLogoutfromHomePage();
		teacherToolsClassSettingsPage.verifyLoginPage();
	}

	/**
	 * This test adds new student to the Roster and selects "language live"
	 * product and saves the details
	 */

	@Test(groups = { "RC", "QC" }, priority = 5, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_025_ToolsClassSettingsRosterVerification() {
		
		// To enter credentials and click on submit button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools link
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify that tools page is loaded successfully
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// To click on Class Settings tab under Tools page
		teacherToolsClassSettingsPage = teacherRoleToolsPage.clickOnClassSettingsTab();
		// To verify student counts under summary section
		teacherToolsClassSettingsPage.verifyTheDataUnderSummaryTab();
		// To click on Roster tab
		studentCreation = teacherToolsClassSettingsPage.clickOnRosterTab();
		// Clicks on Add Students button on Roster tab page
		studentCreation.clickOnaddStudentsButton();
		// Clicks on Add button on the next page
		studentCreation.clickAddButton();
		// Fills student details such as first name, last name, student id,
		// grade and Date of birth
		students = studentCreation.fillNewStudentDetailsOnAddNewStudentsPopUp(llData.studentID,
				llData.studentGradeLevel, llData.studentDOB, 1);
		// Clicks Save Changes button on the Add New students pop-up
		studentCreation.clickSaveChangesButtonOnAddNewStudentsPopUp();
		// Verifies that add new students pop-up has disappeared
		studentCreation.verifyAddNewStudentsPopUpDisappeared();
		// Clicks 'Return to Class Roster' button
		studentCreation.clickReturnToClassRosterButton();
		// Selects Language Live student check box for all the created students
		// and also enters user name and password fields
		studentCreation.selectLiveStudentCheckboxAndEnterUNAndPwdForStudent(students);
		// Saves the changes for the students
		studentCreation.saveCredentialsForStudents();

		// Logout form the application
		studentCreation.clickLogoutfromHomePage();
		studentCreation.verifyLoginPage();
	}

	/**
	 * This test configures settings for student under Student tab of
	 * Tools->Class Settings page
	 */

	@Test(groups = { "RC",
			"QC" }, dependsOnMethods = "LL_Teacher_025_ToolsClassSettingsRosterVerification", priority = 6, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_026_ToolsClassSettingsStudentsVerification() {
		
		// To enter credentials and click on submit button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools link
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify that tools page is loaded successfully
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// To click on Class Settings tab under Tools page
		teacherToolsClassSettingsPage = teacherRoleToolsPage.clickOnClassSettingsTab();
		// To click on students tab
		studentCreation = teacherToolsClassSettingsPage.clickOnStudentsTab();
		// Verifies navigation to Students tab page
		studentCreation.verifyNavigationToStudentsTab();
		// Configures settings for students(such as recording ON/OFF and Edit
		// selections)
		studentCreation.configureSettingsForStudents(students, llData.student1LevelOption, llData.student1UnitOption,
				llData.student1LessonOption, llData.student1RecordingRequired);

		// Logout form the application
		studentCreation.clickLogoutfromHomePage();
		studentCreation.verifyLoginPage();
	}

	/**
	 * This test changes 'Time to spend in word training' minutes for created
	 * student user and saves the details under 'Targets' tab of Tools->Class
	 * settings page
	 */

	@Test(groups = { "RC", "QC" }, priority = 7, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_027_ToolsClassSettingsTargetsVerification(){
		
		// To enter credentials and click on submit button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools link
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify that tools page is loaded successfully
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// To click on Class Settings tab under Tools page
		teacherToolsClassSettingsPage = teacherRoleToolsPage.clickOnClassSettingsTab();
		// To click on targets tab under Class Settings section
		teacherToolsClassSettingsPage.clickOnTargetsTab();
		// To verify that targets tab is loaded successfully
		teacherToolsClassSettingsPage.verifyThatTargetsTabIsLoaded();
		// To modify time to spend in word training value for student
		teacherToolsClassSettingsPage.updateTimeToSpendWordTrainingValueForStudent(students);
		// Logout form the application
		teacherToolsClassSettingsPage.clickLogoutfromHomePage();
		teacherToolsClassSettingsPage.verifyLoginPage();

	}

	/**
	 * This test verifies benchmarks displayed and enables first test of first
	 * benchmark and saves the changes under 'Benchmarks' tab of Tools->Class
	 * settings page
	 */

	@Test(groups = { "RC", "QC" }, priority = 8, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_Teacher_028_ToolsClassSettingsBenchMarksVerification(){
		
		// To enter credentials and click on submit button
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools link
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify that tools page is loaded successfully
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// To click on Class Settings tab under Tools page
		teacherToolsClassSettingsPage = teacherRoleToolsPage.clickOnClassSettingsTab();
		// To click on benchmarks tab under Class Settings section
		teacherToolsClassSettingsPage.clickOnBenchMarksTab();
		// To verify that benchmarks tab is loaded successfully
		teacherToolsClassSettingsPage.verifyThatBenchMarksTabIsLoaded();
		// To verify that list of benchmarks are displayed
		teacherToolsClassSettingsPage.verifyThatListOfBenchMarksAreLoaded();
		// To enable first test of first benchmark and save the changes
		teacherToolsClassSettingsPage.enableFirstTestOfFirstBenchmarkAndSave();
		/*
		 * //To click on Roster tab studentCreation.clickOnRosterTab(); //For
		 * deleting created student from Roster
		 * teacherToolsClassSettingsPage.deleteAddedStudentFromRoster(students,
		 * isChromeBrowser());
		 */

		// Logout form the application
		teacherToolsClassSettingsPage.clickLogoutfromHomePage();
		teacherToolsClassSettingsPage.verifyLoginPage();
	}
}
