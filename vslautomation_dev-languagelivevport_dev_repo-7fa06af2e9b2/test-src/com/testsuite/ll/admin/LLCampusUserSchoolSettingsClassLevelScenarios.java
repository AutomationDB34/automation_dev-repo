package com.testsuite.ll.admin;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.datamanager.ConfigManager;
import com.page.module.ll.admin.CourseReportsPage;
import com.page.module.ll.admin.CourseResourcesPage;
import com.page.module.ll.admin.DistrictSettingsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.admin.SchoolSettingsPage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.StudentCreation;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherToolsClassSettingsPage;
import com.page.module.vport.DistrictAdminMyClassPage;
import com.page.module.vport.DistrictAdminMyResultsPage;
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.SafeActions;
import com.selenium.Sync;
import com.testng.Retry;

public class LLCampusUserSchoolSettingsClassLevelScenarios extends BaseSetup {
	LLData llData;
	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	CourseReportsPage courseReportsPage;
	VportLoginPage vportLoginPage;
	VportData vportData;
	DistrictAdminMyResultsPage districtAdminMyResultsPage;
	DistrictAdminMySchoolPage districtAdminMySchoolPage;
	DistrictAdminMyClassPage districtAdminMyClassPage;
	CourseResourcesPage courseResourcesPage;
	SchoolSettingsPage schoolSettingsPage;
	Map<String, String> implementationSummaryRowValues;
	//String[] students;
	StudentCreation studentCreation;
	DistrictSettingsPage districtSettingsPage;
	TeacherToolsClassSettingsPage teacherToolsClassSettingsPage;
	ConfigManager dependentData = new ConfigManager("DependentData");

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		// Login into Vport application with the District User Credentials
		vportLoginPage = new VportLoginPage(getDriver());
		vportData = new VportData();
		llData = new LLData();
		studentCreation = new StudentCreation(getDriver());
		districtSettingsPage = new DistrictSettingsPage(getDriver());
		teacherToolsClassSettingsPage= new TeacherToolsClassSettingsPage(getDriver());
		getDriver().manage().deleteAllCookies();
	}

/*	@AfterMethod(alwaysRun = true)
	public void logout() {
		LLLogout lllogout = new LLLogout(getDriver());
		llLoginPage = lllogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();
	}*/

	/*
	 *As a campus user, This test verifies Implementation Summary table data in School Settings->Summary page in class level
	 */
	@Test(groups = { "DistrictUser", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_014_ToolsSchoolSetttingsSummaryPageScenarios() 
	{
		
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llCampusAdmin, llData.llCampusAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//selects class from class drop down
		districtAdminMyResultsPage.selectClassFromClassDrpdown(llData.LLClassName+" LL");
		// Get the data from Implementation Summary Table
		implementationSummaryRowValues = getImplementationSummaryTableValues();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		courseResourcesPage = llHomePage.clickOnToolsTab();

		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on School Settings Tab
		schoolSettingsPage = courseResourcesPage.clickOnSchoolSettingsTab();
		// Selects class from 'All classes' drop down
		schoolSettingsPage.selectClassFromAllClasses(llData.teacherLLUsername);
		// Verify Summary tab is Highlighted or not by default
		schoolSettingsPage.verifySummaryTabHighlighted();
		
		
		// Move to Summary frame
		schoolSettingsPage.moveToFrame();
		// verifies Summary tab is loaded by verifying Implementation summary
		// Table is loaded
		schoolSettingsPage.verifySummaryTabLoaded();
		// Verifies Implementation summary data by comparing with the
		// implementation table exists in Vport->My Schools Page
		schoolSettingsPage.verifyImplementationSummaryTablewithVportSummaryTable(implementationSummaryRowValues);
		schoolSettingsPage.moveToDefaultFrame();
	}

	/*
	 * As a Campus user, Navigate to Tools->Campus Settings->Roster tab,adds student in Roster tab and verifies it
	 **/
	@Test(groups = { "CampusUser","QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_015_ToolsSchoolSetttingsRosterPageScenarios()

	{
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llCampusAdmin, llData.llCampusAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//selects class from class drop down
		districtAdminMyResultsPage.selectClassFromClassDrpdown(llData.LLClassName+" LL");
		// Get the data from Implementation Summary Table
		implementationSummaryRowValues = getImplementationSummaryTableValues();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		courseResourcesPage = llHomePage.clickOnToolsTab();

		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on School Settings Tab
		schoolSettingsPage = courseResourcesPage.clickOnSchoolSettingsTab();
		// Selects class from 'All classes' drop down
		schoolSettingsPage.selectClassFromAllClasses(llData.teacherLLUsername);
		// Verify Summary tab is Highlighted or not by default
		schoolSettingsPage.verifySummaryTabHighlighted();
				
		// Clicks on Roster sub tab
		schoolSettingsPage.clickOnRosterTab();
		// Move to Roster frame
		schoolSettingsPage.moveToFrame();
		// Verifies Roster tab is loaded or not
		schoolSettingsPage.verifyRosterTabLoaded();
		// Clicks in 'Add Students' button in Roster main page
		schoolSettingsPage.clickAddStudentsButtonOnMYClassRostersMainPage();
		// Verifies Roster Student page is loaded or not
		schoolSettingsPage.verifyNavigationToCreateStudentsPage();
		// Clicks on Add button in Create New Students pane
		schoolSettingsPage.clickAddButtonOnCreateNewStudentsToRosterPage();
		// Verifies Add New Students pop up is loaded or not o
		schoolSettingsPage.verifyNavigationToAddNewStudentsPopUp();
		// Enters data into Add New students popup
		String students[] = studentCreation.fillNewStudentDetailsOnAddNewStudentsPopUp(llData.studentID,
				llData.studentGradeLevel, llData.studentDOB, 1);
		//Writing the Data to Property File
		dependentData.writeProperty("LL_CAMPUSUSER_015_STUDENT", students[0]);
		// click Save button
		schoolSettingsPage.clickSaveChangesButtonOnAddNewStudentsPopUp();
		// Verifies Add new Student pop up is disappeared or not
		schoolSettingsPage.verifyAddNewStudentsPopUpDisappeared();
		// Clicks on 'Return to Class Roster' button
		schoolSettingsPage.clickReturnToClassRosterButton();
		/// Selects Language Live student check box for all the created students
		/// and also enters user name and password fields
		studentCreation.selectLiveStudentCheckboxAndEnterUNAndPwdForStudent(students);
		// Saves the changes for the students
		studentCreation.saveCredentialsForStudents();
		schoolSettingsPage.moveToDefaultFrame();

	}

	/*
	 * As a Campus user, Navigate to Tools->School Settings->Students tab,
	 * move the student Course position and change the recording settings
	 **/
	@Test(groups = { "CampusUser","QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_016_ToolsSchoolSetttingsStudentPageScenarios()

	{
		String students[] = new String[1];
		students[0] = dependentData.getProperty("LL_CAMPUSUSER_015_STUDENT");
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llCampusAdmin, llData.llCampusAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//selects class from class drop down
		districtAdminMyResultsPage.selectClassFromClassDrpdown(llData.LLClassName+" LL");
		// Get the data from Implementation Summary Table
		implementationSummaryRowValues = getImplementationSummaryTableValues();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on School Settings Tab
		schoolSettingsPage = courseResourcesPage.clickOnSchoolSettingsTab();
		// Selects class from 'All classes' drop down
		schoolSettingsPage.selectClassFromAllClasses(llData.teacherLLUsername);
		// Verify Summary tab is Highlighted or not by default
		schoolSettingsPage.verifySummaryTabHighlighted();
		
		
		// Clicks on Students Tab
		schoolSettingsPage.clickOnStudentsTab();
		// Clicks on roster tab
		schoolSettingsPage.clickOnRosterTab();
		// Clicks on Students tab
		schoolSettingsPage.clickOnStudentsTab();
		// Verifies navigation to Students tab page
		studentCreation.verifyNavigationToStudentsTab();
		// Configures settings for students(such as recording ON/OFF and Edit selections)
		districtSettingsPage.configureSettingsForStudents(students);

	}
	
	/*
	 * As a Campus user,This test changes 'Time to spend in word training'minutes for created student user and saves the details under Tools->Class Settings->Targets tab,
	 */
	@Test(groups = { "CampusUser","QC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_017_ToolsSchoolSetttingsTargetsPageScenarios() {
		
		String students[] = new String[1];
		students[0] = dependentData.getProperty("LL_CAMPUSUSER_015_STUDENT");
		
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llCampusAdmin, llData.llCampusAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//selects class from class drop down
		districtAdminMyResultsPage.selectClassFromClassDrpdown(llData.LLClassName+" LL");
		// Get the data from Implementation Summary Table
		implementationSummaryRowValues = getImplementationSummaryTableValues();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on School Settings Tab
		schoolSettingsPage = courseResourcesPage.clickOnSchoolSettingsTab();
		// Selects class from 'All classes' drop down
		schoolSettingsPage.selectClassFromAllClasses(llData.teacherLLUsername);
		// Verify Summary tab is Highlighted or not by default
		schoolSettingsPage.verifySummaryTabHighlighted();
		
		
		// Clicks on Students Tab
		schoolSettingsPage.clickOnTargetsTab();
		schoolSettingsPage.clickOnRosterTab();
		schoolSettingsPage.clickOnTargetsTab();
		// To verify that targets tab is loaded successfully
		districtSettingsPage.verifyThatTargetsTabIsLoaded();
		// To modify time to spend in word training value for student
		districtSettingsPage.updateTimeToSpendWordTrainingValueForStudent(students);
	}
	
	
	/**
	 * This test verifies benchmarks displayed and enables first test of first benchmark and saves the changes under 'Benchmarks' tab of Tools->Class settings page 
	 * @throws Exception
	 */
	@Test(groups = { "CampusUser","QC" }, priority = 5, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_018_ToolsSchoolSetttingsBenchMarksPageScenarios()	{
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llCampusAdmin, llData.llCampusAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//selects class from class drop down
		districtAdminMyResultsPage.selectClassFromClassDrpdown(llData.LLClassName+" LL");
		// Get the data from Implementation Summary Table
		implementationSummaryRowValues = getImplementationSummaryTableValues();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llCampusAdmin, llData.llCampusAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on School Settings Tab
		schoolSettingsPage = courseResourcesPage.clickOnSchoolSettingsTab();
		// Selects class from 'All classes' drop down
		schoolSettingsPage.selectClassFromAllClasses(llData.teacherLLUsername);
		// Verify Summary tab is Highlighted or not by default
		schoolSettingsPage.verifySummaryTabHighlighted();
		
		
		//To click on benchmarks tab under Class Settings section
		teacherToolsClassSettingsPage.clickOnBenchMarksTab();
		//To verify that benchmarks tab is loaded successfully
		teacherToolsClassSettingsPage.verifyThatBenchMarksTabIsLoaded();
		//To verify that list of benchmarks are displayed
		teacherToolsClassSettingsPage.verifyThatListOfBenchMarksAreLoaded();
		//To enable first test of first benchmark and save the changes
		teacherToolsClassSettingsPage.enableFirstTestOfFirstBenchmarkAndSave();	
	}
	

	public Map<String, String> getImplementationSummaryTableValues() {
				//Clicks on My class tab
				districtAdminMyClassPage=districtAdminMyResultsPage.clickOnMyClassTab();
				// Verifies whether My District page is loaded or not
				districtAdminMyClassPage.verifyMyClassPageIsLoaded();
				// Clicks on summary sub tab in My District page
				districtAdminMyClassPage.clickSummaryTab();
				
				districtAdminMyClassPage.verifySummaryTabLoaded();
				// Get the data from Implementation Summary Table
				implementationSummaryRowValues=	districtAdminMyClassPage.getImplementationSummaryTableRowAndValues();
							
				return implementationSummaryRowValues;
	}

}
