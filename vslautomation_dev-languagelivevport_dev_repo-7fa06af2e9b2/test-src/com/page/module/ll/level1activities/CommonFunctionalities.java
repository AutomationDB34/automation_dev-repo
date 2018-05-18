package com.page.module.ll.level1activities;

import javax.swing.text.Utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.data.testdata.VportData.UserRole;
import com.page.locators.ll.level1activites.CommonLocators;
import com.page.module.ll.admin.CourseResourcesPage;
import com.page.module.ll.admin.DistrictSettingsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.admin.LeaderBoardsPage;
import com.page.module.ll.admin.SchoolSettingsPage;
import com.page.module.ll.admin.SocialSettingsPage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.level1activities.TeacherHomePage.LLToolsTabReturnPage;
import com.page.module.ll.teacherrole.TeacherClassClassWallPage;
import com.page.module.ll.teacherrole.TeacherRoleClassPage;
import com.page.module.ll.teacherrole.TeacherRoleReportsPage;
import com.page.module.ll.teacherrole.TeacherRoleToolsPage;
import com.page.module.ll.teacherrole.TeacherToolsSocialSettingsPage;
import com.page.module.ll.teacherrole.TeacherViewProfileAboutMePage;
import com.page.module.ll.teacherrole.TeacherWelComePage;
import com.page.module.vport.DistrictAdminHomepage;
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportLogoutPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.SafeActions;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public abstract class CommonFunctionalities extends SafeActions implements CommonLocators {

	private WebDriver driver;
	Logger log = Logger.getLogger(getClass());
	LLLoginPage lllPage;
	LLData llData;
	LLLoginPage llloginPage;
	LLActivity llactivity;
	LLStudentHomePage llstudentHomePage;
	TeacherHomePage teacherHomePage;
	StudentCreation studentCreation;
	TeacherRoleToolsPage teacherRoleToolsPage;
	TeacherToolsSocialSettingsPage teacherToolsSocialSettingsPage;
	TeacherRoleClassPage teacherRoleClassPage;
	TeacherClassClassWallPage teacherClassClassWallPage;
	DistrictSettingsPage districtSettingsPage;
	LLLogout lllogout;
	LLHomePage llHomePage;
	int myScoreValue;
	String[] students;
	Object[] studentDetails;
	Object[] distStudentDetails;
	CourseResourcesPage courseResourcesPage;
	SchoolSettingsPage schoolettingsPage;


	LLLoginPage llLoginPage;
	StudentWelcomePage studentWelcomePage;
	LLStudentHomePage llStudentHomePage;
	TeacherViewProfileAboutMePage teacherViewProfileAboutMePage;
	LeaderBoardsPage leaderBoardsPage;
	String studentCoursePointsFromStudentProfile;
	String studentAcheivementsFromStudentProfile;
	String profilePoints[] = new String[2];

	// VPORT Related Common Functionalities used in LL
	private VportLoginPage vportloginpage;
	private VportData vportData;
	private DistrictAdminHomepage districtAdminHomepage;
	private DistrictAdminMySchoolPage districtAdminMySchoolPage;
	private SocialSettingsPage socialSettingsPage;

	public CommonFunctionalities(WebDriver driver) {
		super(driver);
		this.driver = driver;
		llData = new LLData();
		vportData = new VportData();
	}

	/*
	 * purpose of the Method is used to verify the instruction icon in the frame
	 */
	public void verifyinstructionIcon() {

		Assert.assertTrue(isElementPresent(INSTRUCTION_ICON, LONGWAIT),
				"Instruction icon is not being displayed on Activity page");

	}

	public void closeInstIcon() {
		if (isElementPresent(INST_CLOSE, MEDIUMWAIT)) {
			safeClick(INST_CLOSE);
		} else {
			System.out.println("Instruction icon is not displayed ");
		}
	}

	public void verifyMicroPhonePopup() {

		boolean microPhonePupupExists = isElementPresent(MICRO_PHONE_POP, LONGWAIT);
		Assert.assertTrue(microPhonePupupExists, "Microphone pop up is not being displayed on Activity page");

	}

	public void microPhoneSetUp(LLData llData) {

		if (isElementPresent(TRY_AGAIN_BUTTON)) {
			safeClick(TRY_AGAIN_BUTTON, LONGWAIT);
			if (isElementPresent(TRY_AGAIN_LINK_POPUP)) {
				safeClick(TRY_AGAIN_LINK, LONGWAIT);
			}
		}
		safeClickUsingSikuliWithMouseDown(llData.MICROPHONE_IMAGE, "Allow microphone radio button", VERYLONGWAIT);
		waitForSecs(10, "Waiting after accepting the Microphone");
	}

	/**
	 * Purpose of the method is to navigate to home page on completing the
	 * activity
	 */
	public void navigateToHomePagefromActivity() {
		closeInstIcon();
		isElementPresent(ACTIVITY_USER_DROP_DOWN);
		safeClick(ACTIVITY_USER_DROP_DOWN, LONGWAIT);
		isElementPresent(HOME_LINK);
		safeClick(HOME_LINK, LONGWAIT);
	}

	public LLLoginPage clickLogoutfromHomePage() {

		try
		{
			if (isElementPresent(ACTIVITY_USER_DROP_DOWN)) 
			{
				safeClick(ACTIVITY_USER_DROP_DOWN, LONGWAIT);
				safeClick(HOME_LINK, LONGWAIT);
			}

			safeClick(USER_DROPDOWN, LONGWAIT);
			safeClick(LOGOUT_LINK, MEDIUMWAIT);
		}
		catch(Exception e)
		{
			log.warn("Logout step not performed.(Browser will be closed after completing the functional steps)"+e.getMessage());
		}
		return new LLLoginPage(driver);
	}

	public LLLoginPage clickLogoutfromActivty() {
		waitForSecs(10, "Waiting before logout");
		closeInstIcon();
		isElementPresent(COURSE_DROPDOWN, MEDIUMWAIT);
		safeClick(COURSE_DROPDOWN, SHORTWAIT);
		isElementPresent(LOGOUT_LINK, MEDIUMWAIT);
		safeClick(LOGOUT_LINK, SHORTWAIT);



		return new LLLoginPage(driver);
	}

	/**
	 * Purpose- To verify whether LL Login page is being displayed or not
	 */
	public void verifyLoginPage() {
		boolean uNamenExists = isElementPresent(USERNAME_FIELD, LONGWAIT);
		Assert.assertTrue(uNamenExists, "User Name button is not being displayed on Login page");
	}

	/**
	 * Purpose- To verify whether LL Welcomme page is being displayed or not
	 */
	public void verifywelcomePage() {
		boolean cotinueButtonExists = isElementPresent(WELCOME_CONTINUE_BTN, LONGWAIT);
		Assert.assertTrue(cotinueButtonExists, "Comtinue button is not being displayed on Welcome page");
	}

	/**
	 * Purpose- To enter user credentials and submit
	 * 
	 * @return
	 *//*
	 * public Object loginCredentials(String vportUsername, String
	 * vportPassword, LLLoginReturnPage llloginreturnpage) { try {
	 * navigateToURLandRetrivePageLoadTime(url, VERYLONGWAIT); } catch
	 * (Exception e) { log.info("Page navigation is failed due to"+
	 * UtilityMethods.getStackTrace()); e.printStackTrace(); }
	 * safeType(USERNAME_FIELD, vportUsername, SHORTWAIT);
	 * safeType(PASSWORD_FIELD, vportPassword, SHORTWAIT);
	 * safeClick(LOGIN_BTN, SHORTWAIT);
	 * 
	 * switch (llloginreturnpage) { case STUD_WELCOME_PAGE: return new
	 * StudentWelcomePage(driver); case TEACHER_HOME_PAGE: return new
	 * TeacherHomePage(driver); case NEW_TEACHER_WELCOME_PAGE: return new
	 * TeacherWelComePage(driver); case TEACHERROLE_REPORTS_PAGE: return new
	 * TeacherRoleReportsPage(driver); default: return null; }
	 * 
	 * }
	 */

	/**
	 * get the login driver which is intiated already
	 * 
	 * @return
	 */
	public LLLoginPage getLoginPage() {
		return new LLLoginPage(driver);
	}

	public void socialDefaultSettings(LLLoginPage llloginPage) {
		// To verify login page
		llloginPage.verifyLoginPage();
		// To enter credentials and click on submit button of teacher user
		teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
				llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
		// To verify that teacher is logged in successfully
		teacherHomePage.verifyTeacherLogin();
		// To click on Tools link
		teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
				.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
		// To verify that tools page is loaded successfully
		teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
		// To click on Social Settings tab under tools page
		teacherToolsSocialSettingsPage = teacherRoleToolsPage.clickOnSocialSettingsTab();
		// Verify that social settings tab content is loaded
		teacherToolsSocialSettingsPage.verifyThatSocialSettingsTabIsLoaded();
		// To revert back social settings to default values
		teacherToolsSocialSettingsPage.revertBackSocialSettingsToDefault(llData.teacherRoleLLStudentLastName);
		// LLLogout lllogout = new LLLogout(getDriver());
		llloginPage.clickLogoutfromHomePage();
		llloginPage.verifyLoginPage();
	}

	public void campusSocialSchoolDefaultSettings(LLLoginPage llloginPage) {
		// To verify login page
		llloginPage.verifyLoginPage();
		// To enter credentials and click on submit button of teacher user
		llHomePage = (LLHomePage) llloginPage.loginCredentials(llData.URL, llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on Social Settings Tab
		socialSettingsPage = courseResourcesPage.clickOnSocialSettingsTab();
		socialSettingsPage.verifySocialSettingsPageLoadedForCampusUser();
		socialSettingsPage.enableWallpostingForAllClassesCheckbox();

		socialSettingsPage.clickLogoutfromHomePage();
		llloginPage.verifyLoginPage();
	}

	public void campusSocialClassDefaultSettings(LLLoginPage llloginPage) {

		// To verify login page
		llloginPage.verifyLoginPage();
		// To enter credentials and click on submit button of teacher user
		llHomePage = (LLHomePage) llloginPage.loginCredentials(llData.URL, llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on Social Settings Tab
		socialSettingsPage = courseResourcesPage.clickOnSocialSettingsTab();
		socialSettingsPage.verifySocialSettingsPageLoadedForCampusUser();
		socialSettingsPage.enableWallCheckboxOfTeacherInClassRoomSocialSettings(llData.teacherRoleLLUsername + " LL");

		socialSettingsPage.clickLogoutfromHomePage();
		llloginPage.verifyLoginPage();

	}

	public void districtSocialDefaultSettings_District(LLLoginPage llLoginPage) {

		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on District Settings Tab
		socialSettingsPage = courseResourcesPage.clickOnSocialSettingsTab();
		socialSettingsPage.verifySocialSettingsPageLoadedForDistrictUser();	
		socialSettingsPage.enableWallpostingForAllSchoolsCheckbox();

		socialSettingsPage.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();

	}

	public void districtSocialDefaultSettings_Campus(LLLoginPage llLoginPage) {

		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on District Settings Tab
		socialSettingsPage = courseResourcesPage.clickOnSocialSettingsTab();
		socialSettingsPage.verifySocialSettingsPageLoadedForDistrictUser();	
		socialSettingsPage.enableWallCheckboxOfSchoolInCampusSocialSettings(llData.LLSchoolName);

		socialSettingsPage.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();

	}


	public String[] createStudents(LLLoginPage llLoginPage, String level, String unit, String lesson,
			String recordingRequired) {

		// Enters login credentials of teacher user (llData.teacherLLUsername,
		// llData.teacherLLUsername
		teacherHomePage = (TeacherHomePage) llLoginPage.loginCredentials(llData.URL, llData.teacher_stdcreation, llData.teacher_stdcreation,
				LLLoginReturnPage.TEACHER_HOME_PAGE);
		// Verifies teacher login
		teacherHomePage.verifyTeacherLogin();
		// Clicks on Tools tab
		studentCreation = (StudentCreation) teacherHomePage.clickOnToolsTab(LLToolsTabReturnPage.STUDENT_CREATION_PAGE);
		// Verifies Tools tab page
		teacherHomePage.verifyToolsTab();
		// Clicks on Class Settings tab
		studentCreation.clickOnClassSettingsTab();
		// Clicks on Roster Tab
		studentCreation.clickOnRosterTab();
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
		// Clicks on Students Tab
		studentCreation.clickOnStudentsTab();
		// Verifies navigation to Students tab page
		studentCreation.verifyNavigationToStudentsTab();
		// Configures settings for students(such as recording ON/OFF and Edit
		// selections)
		studentCreation.configureSettingsForStudents(students, level, unit, lesson, recordingRequired);
		// Clicks logout for the teacher user
		llLoginPage = llLoginPage.clickLogoutfromHomePage();
		// Verifies login page
		llLoginPage.verifyLoginPage();
		return students;
	}
	
	public String[] createStudents(LLLoginPage llLoginPage, String level, String unit, String lesson,
			String recordingRequired,int NumberOfStudents) {

		// Enters login credentials of teacher user (llData.teacherLLUsername,
		// llData.teacherLLUsername
		teacherHomePage = (TeacherHomePage) llLoginPage.loginCredentials(llData.URL, "testautoteachuser", "testautoteachuser",
				LLLoginReturnPage.TEACHER_HOME_PAGE);
		// Verifies teacher login
		teacherHomePage.verifyTeacherLogin();
		// Clicks on Tools tab
		studentCreation = (StudentCreation) teacherHomePage.clickOnToolsTab(LLToolsTabReturnPage.STUDENT_CREATION_PAGE);
		// Verifies Tools tab page
		teacherHomePage.verifyToolsTab();
		// Clicks on Class Settings tab
		studentCreation.clickOnClassSettingsTab();
		// Clicks on Roster Tab
		studentCreation.clickOnRosterTab();
		// Clicks on Add Students button on Roster tab page
		studentCreation.clickOnaddStudentsButton();
		// Clicks on Add button on the next page
		studentCreation.clickAddButton();
		// Fills student details such as first name, last name, student id,
		// grade and Date of birth
		students = studentCreation.fillNewStudentDetailsOnAddNewStudentsPopUp(llData.studentID,
				llData.studentGradeLevel, llData.studentDOB, NumberOfStudents);
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
		// Clicks on Students Tab
		studentCreation.clickOnStudentsTab();
		// Verifies navigation to Students tab page
		studentCreation.verifyNavigationToStudentsTab();
		// Configures settings for students(such as recording ON/OFF and Edit
		// selections)
		//studentCreation.configureSettingsForStudents(students, level, unit, lesson, recordingRequired);
		// Clicks logout for the teacher user
		llLoginPage = llLoginPage.clickLogoutfromHomePage();
		// Verifies login page
		llLoginPage.verifyLoginPage();
		return students;
	}

	public String createNewTeacher(VportLoginPage vportloginpage) {
		this.vportloginpage = vportloginpage;
		driver.get(vportData.vportURL);
		// Verifies vport login page
		vportloginpage.verifyLoginPage();
		// Enter credentials
		vportloginpage.enterLoginCredentials(vportData.vportDistrictAdminUserName,
				vportData.vportDistrictAdminPassword);
		// clicks sign in button
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		// Selects school from school drop down
		districtAdminHomepage.selectSchoolFromDropdown(vportData.vportDistrictAdminSchoolName);
		// Navigate to My school tab
		districtAdminMySchoolPage = districtAdminHomepage.clickOnMySchoolTab();
		// Navigate to Teachers and classes tab and verifies it
		districtAdminMySchoolPage.navigateToTeachersAndClassesSubtab();
		// Verifies teachers and classes sub tab
		districtAdminMySchoolPage.verifyTeachersAndClassesSubtab();
		String strRandom = UtilityMethods.get4DRandomNumber();
		// Adds teacher user
		districtAdminMySchoolPage.addTeacher(vportData.teacherLastName + strRandom, vportData.teacherFirstName,
				vportData.teacherEmail);
		// edits teacher user details
		String teacheruserId = districtAdminMySchoolPage.editTeacherandSave(vportData.teacherLastName + strRandom,
				vportData.teacherUserId + strRandom, vportData.teacherPassword);
		// Adds class and license to teacher account
		districtAdminMySchoolPage.addClassAndLicencesToTeacher(vportData.teacherLastName + strRandom);
		// creating vport logout object
		districtAdminMySchoolPage.clickLogoutLink();
		// verifies that logout is successful
		districtAdminMySchoolPage.verifyLoginPage();
		return teacheruserId;
	}

	public String[] getStudentCoursePointsAndAcheivementsFromStudentProfilePage(LLLoginPage llLoginPage) {
		// To verify login page
		// To enter login credentials and click sign in button
		studentWelcomePage = (StudentWelcomePage) llLoginPage.loginCredentials(llData.URL,
				llData.teacherRoleLLStudentFirstName, llData.teacherRoleLLStudentFirstName,
				LLLoginReturnPage.STUD_WELCOME_PAGE);
		llStudentHomePage = studentWelcomePage.ClickContinueButton();
		llStudentHomePage.verifyLLStudentHomePage();
		// Clicks on student image and navigate to Profile page of student
		teacherViewProfileAboutMePage = llStudentHomePage.navigateToViewProfile();
		// verifies that About Me page is loaded in Profile tab
		teacherViewProfileAboutMePage.verifyThatViewProfileAboutMePageIsLoaded();
		// In About Me tab, read the course points(This Year) value
		profilePoints[0] = teacherViewProfileAboutMePage.getCoursePointsCountInYear();
		profilePoints[1] = teacherViewProfileAboutMePage.getAchievementsCountInYear();

		return profilePoints;
	}

	// This method reads student count and respective student names in Roster
	// Tab
	public Object[] getStudentDetailsFromRosterTab(LLHomePage llHomePage) {
		courseResourcesPage = llHomePage.clickOnToolsTab();
		schoolettingsPage = courseResourcesPage.clickOnSchoolSettingsTab();
		// Selects class from 'All classes' drop down
		schoolettingsPage.selectClassFromAllClasses(llData.LLClassName);
		schoolettingsPage.clickOnRosterTab();
		schoolettingsPage.moveToFrame();
		// Get number of students count and Students names from Roster tab
		studentDetails = schoolettingsPage.getStudentsCountAndNamesInRosterTable();

		schoolettingsPage.moveToDefaultFrame();

		return studentDetails;

	}

	/**
	 * This method Login as a teacher into LL and posts an assignment in
	 * 'Class'->'ClassWall'->'Assignment' sub tab
	 * 
	 * @return
	 */
	public String postAssignmentinTeacherClassesPageandGetAssignmentName(LLLoginPage llLoginPage) {

		// To enter login credentials and click sign in button
		teacherHomePage = (TeacherHomePage) llLoginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
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
		// To click on Assignment tab
		teacherClassClassWallPage.clickOnAssignmentTab();
		// To verify the navigation to share assignment section
		teacherClassClassWallPage.verifyThatAssignmentSectionIsLoaded();
		Long currentTime = System.currentTimeMillis();
		// To share new assignment and verify it
		teacherClassClassWallPage.addNewAssignmentAndVerify(llData.teacherRoleLLClassWallAssignmentTitle + currentTime,
				llData.teacherRoleLLClassWallAssignmentDesc + System.currentTimeMillis(),
				llData.teacherRoleLLClassWallAssignmentCredit, llData.teacherRoleLLClassWallAssignmentTimeInHours,
				llData.teacherRoleLLClassWallAssignmentTimeInMinutes,
				llData.teacherRoleLLClassWallAssignmentTimeInAMPM);
		// Clicks logout for the teacher user
		llLoginPage = llLoginPage.clickLogoutfromHomePage();
		// Verifies login page
		llLoginPage.verifyLoginPage();
		return llData.teacherRoleLLClassWallAssignmentTitle + currentTime;

	}

	// This method reads student count and respective student names in Roster
	// Tab
	public Object[] getStudentDetailsFromDistrictRosterTab(LLHomePage llHomePage) {
		courseResourcesPage = llHomePage.clickOnToolsTab();
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		districtSettingsPage = courseResourcesPage.clickOnDistrictSettingsTab();
		// Selects School from ALl schools Drop down
		districtSettingsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		// Selects class from 'All classes' drop down
		districtSettingsPage.selectClassFromAllClasses(llData.LLClassName);
		districtSettingsPage.clickOnRosterTab();
		districtSettingsPage.moveToFrame();
		// Get number of students count and Students names from Roster tab
		distStudentDetails = districtSettingsPage.getStudentsCountAndNamesInRosterTable();

		districtSettingsPage.moveToDefaultFrame();
		return distStudentDetails;
	}




}
