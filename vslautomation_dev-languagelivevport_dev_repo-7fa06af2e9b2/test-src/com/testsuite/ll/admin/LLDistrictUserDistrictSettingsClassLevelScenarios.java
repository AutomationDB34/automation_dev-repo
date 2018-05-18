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
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.StudentCreation;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherToolsClassSettingsPage;
import com.page.module.vport.DistrictAdminMyClassPage;
import com.page.module.vport.DistrictAdminMyDistrictPage;
import com.page.module.vport.DistrictAdminMyResultsPage;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.SafeActions;
import com.selenium.Sync;
import com.testng.Retry;

public class LLDistrictUserDistrictSettingsClassLevelScenarios extends BaseSetup {

	LLData llData;
	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	CourseReportsPage courseReportsPage;
	VportLoginPage vportLoginPage;
	VportData vportData;
	DistrictAdminMyResultsPage districtAdminMyResultsPage;
	DistrictAdminMyDistrictPage districtAdminMyDistrictPage;
	DistrictAdminMyClassPage districtAdminMyClassPage;
	Map<String, String> implementationSummaryrowValues;
	CourseResourcesPage courseResourcesPage;
	DistrictSettingsPage districtSettingsPage;
	StudentCreation studentCreation;
	SafeActions safeActions;
	//private String[] students;
	TeacherToolsClassSettingsPage teacherToolsClassSettingsPage;
	ConfigManager dependentData = new ConfigManager("DependentData");

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		teacherToolsClassSettingsPage = new TeacherToolsClassSettingsPage(getDriver());
		studentCreation = new StudentCreation(getDriver());
		// Login into Vport application with the District User Credentials
		vportLoginPage = new VportLoginPage(getDriver());
		vportData = new VportData();
		llData = new LLData();
		

	}

/*	@AfterMethod(alwaysRun = true)
	public void logout() {

		LLLogout lllogout = new LLLogout(getDriver());
		llLoginPage = lllogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();
	}*/

	/*
	 * As a District user, This test verifies Implementation Summary table data in District Settings->Summary page in class level
	 */
	@Test(groups ={ "DistrictUser", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_015_ToolsDistrictSetttingsSummaryPageClassLevelScenarios() {
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);	
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//Selects School from school main Drop down
		districtAdminMyResultsPage.selectSchoolFromSchoolDrpdown(llData.LLSchoolName);
		//selects class from class drop down
		districtAdminMyResultsPage.selectClassFromClassDrpdown(llData.LLClassName+" LL");
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues = getImplementationSummaryTableValuesfromVport();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on District Settings Tab
		districtSettingsPage = courseResourcesPage.clickOnDistrictSettingsTab();
		// Verifies Summary tab is highlighted by default on clicking District
		// settings tab
		districtSettingsPage.verifySummaryTabHighlighted();
		// Selects School from ALl schools Drop down
		districtSettingsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		// Verifies All Classes drop down is enabled on selecting school
		districtSettingsPage.verifyAllClassesDropdownDisplayed();
		// Selects class from 'All classes' drop down
		districtSettingsPage.selectClassFromAllClasses(llData.LLClassName);
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();
		// Move to Summary frame
		districtSettingsPage.moveToFrame();
		// verifies Summary tab is loaded by verifying Implementation summary
		// Table is loaded
		districtSettingsPage.verifySummaryTabLoaded();
		// Verifies Implementation summary data by comparing with the implementation table exists in Vport->My Districts Page
		districtSettingsPage.verifyImplementationSummaryTablewithVportSummaryTable(implementationSummaryrowValues);
		districtSettingsPage.moveToDefaultFrame();
	}

	/*
	 * As a District user, Navigate to Tools->District Settings->Roster tab,
	 * adds student in Roster tab and verifies it
	 **/
	@Test(groups = { "DistrictUser","QC" },priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_016_ToolsDistrictSetttingsRosterPageScenarios()

	{
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);	
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//Selects School from school main Drop down
		districtAdminMyResultsPage.selectSchoolFromSchoolDrpdown(llData.LLSchoolName);
		//selects class from class drop down
		districtAdminMyResultsPage.selectClassFromClassDrpdown(llData.LLClassName+" LL");
		
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues = getImplementationSummaryTableValuesfromVport();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on District Settings Tab
		districtSettingsPage = courseResourcesPage.clickOnDistrictSettingsTab();
		// Verifies Summary tab is highlighted by default on clicking District
		// settings tab
		districtSettingsPage.verifySummaryTabHighlighted();
		// Selects School from ALl schools Drop down
		districtSettingsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		// Verifies All Classes drop down is enabled on selecting school
		districtSettingsPage.verifyAllClassesDropdownDisplayed();
		// Selects class from 'All classes' drop down
		districtSettingsPage.selectClassFromAllClasses(llData.LLClassName);
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();
		// Clicks on Roster sub tab
		districtSettingsPage.clickOnRosterTab();
		// Move to Roster frame
		districtSettingsPage.moveToFrame();
		// Verifies Roster tab is loaded or not
		districtSettingsPage.verifyRosterTabLoaded();
		// Clicks in 'Add Students' button in Roster main page
		districtSettingsPage.clickAddStudentsButtonOnMYClassRostersMainPage();
		// Verifies Roster Stundet page is loaded or not
		districtSettingsPage.verifyNavigationToCreateStudentsPage();
		// Clicks on Add button in Create New Students pane
		districtSettingsPage.clickAddButtonOnCreateNewStudentsToRosterPage();
		// Verifies Add New Students pop up is loaded or not o
		districtSettingsPage.verifyNavigationToAddNewStudentsPopUp();
		// Enters data into Add New students popup
		String students[] = studentCreation.fillNewStudentDetailsOnAddNewStudentsPopUp(llData.studentID,
				llData.studentGradeLevel, llData.studentDOB, 1);
		//Write the Student details to Property file for next case use
		dependentData.writeProperty("LL_DISTRICTUSER_016_STUDENT", students[0]);
		// click Save button
		districtSettingsPage.clickSaveChangesButtonOnAddNewStudentsPopUp();
		// Verifies Add new Student pop up is disappeared or not
		districtSettingsPage.verifyAddNewStudentsPopUpDisappeared();
		// Clicks on 'Return to Class Roster' button
		districtSettingsPage.clickReturnToClassRosterButton();
		// Selects Language Live student check box for all the created students
		// and also enters user name and password fields
		studentCreation.selectLiveStudentCheckboxAndEnterUNAndPwdForStudent(students);
		// Saves the changes for the students
		studentCreation.saveCredentialsForStudents();
		districtSettingsPage.moveToDefaultFrame();
	}

	/*
	 * As a District user, Navigate to Tools->District Settings->Students tab,
	 * move the student Course position and change the recording settings
	 **/
	@Test(groups = { "DistrictUser","QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_017_ToolsDistrictSetttingsStudentPageScenarios()
	{
		String students[] = new String[1];
		students[0] = dependentData.getProperty("LL_DISTRICTUSER_016_STUDENT");
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);	
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//Selects School from school main Drop down
		districtAdminMyResultsPage.selectSchoolFromSchoolDrpdown(llData.LLSchoolName);
		//selects class from class drop down
		districtAdminMyResultsPage.selectClassFromClassDrpdown(llData.LLClassName+" LL");
		
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues = getImplementationSummaryTableValuesfromVport();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on District Settings Tab
		districtSettingsPage = courseResourcesPage.clickOnDistrictSettingsTab();
		// Verifies Summary tab is highlighted by default on clicking District
		// settings tab
		districtSettingsPage.verifySummaryTabHighlighted();
		// Selects School from ALl schools Drop down
		districtSettingsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		// Verifies All Classes drop down is enabled on selecting school
		districtSettingsPage.verifyAllClassesDropdownDisplayed();
		// Selects class from 'All classes' drop down
		districtSettingsPage.selectClassFromAllClasses(llData.LLClassName);
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();
		// Clicks on Students Tab
		districtSettingsPage.clickOnStudentsTab();
		// Clicks on Roster tab
		districtSettingsPage.clickOnRosterTab();
		// Clicks on Student tab
		districtSettingsPage.clickOnStudentsTab();
		// Verifies navigation to Students tab page
		studentCreation.verifyNavigationToStudentsTab();
		// Configures settings for students(such as recording ON/OFF and Edit//
		// selections)
		districtSettingsPage.configureSettingsForStudents(students);

	}

	/*
	 * As a District user,This test changes 'Time to spend in word
	 * training'minutes for created student user and saves the details under
	 * Tools->District Settings->Targets tab,
	 */
	@Test(groups = { "DistrictUser","QC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_018_ToolsDistrictSetttingsTargetsPageScenarios() {
		String students[] = new String[1];
		students[0] = dependentData.getProperty("LL_DISTRICTUSER_016_STUDENT");
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);	
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//Selects School from school main Drop down
		districtAdminMyResultsPage.selectSchoolFromSchoolDrpdown(llData.LLSchoolName);
		//selects class from class drop down
		districtAdminMyResultsPage.selectClassFromClassDrpdown(llData.LLClassName+" LL");
		
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues = getImplementationSummaryTableValuesfromVport();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on District Settings Tab
		districtSettingsPage = courseResourcesPage.clickOnDistrictSettingsTab();
		// Verifies Summary tab is highlighted by default on clicking District
		// settings tab
		districtSettingsPage.verifySummaryTabHighlighted();
		// Selects School from ALl schools Drop down
		districtSettingsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		// Verifies All Classes drop down is enabled on selecting school
		districtSettingsPage.verifyAllClassesDropdownDisplayed();
		// Selects class from 'All classes' drop down
		districtSettingsPage.selectClassFromAllClasses(llData.LLClassName);
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();
		// Clicks on Students Tab
		districtSettingsPage.clickOnTargetsTab();
		districtSettingsPage.clickOnRosterTab();
		districtSettingsPage.clickOnTargetsTab();
		// To verify that targets tab is loaded successfully
		districtSettingsPage.verifyThatTargetsTabIsLoaded();
		// To modify time to spend in word training value for student
		districtSettingsPage.updateTimeToSpendWordTrainingValueForStudent(students);
	}

	/**
	 * This test verifies benchmarks displayed and enables first test of first
	 * benchmark and saves the changes under 'Benchmarks' tab of Tools->Class
	 * settings page
	 * 
	 * @throws Exception
	 */
	@Test(groups = { "DistrictUser","QC" },priority = 5, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_019_ToolsDistrictSetttingsBenchMarksPageScenarios() {
		String students[] = new String[1];
		students[0] = dependentData.getProperty("LL_DISTRICTUSER_016_STUDENT");
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);	
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//Selects School from school main Drop down
		districtAdminMyResultsPage.selectSchoolFromSchoolDrpdown(llData.LLSchoolName);
		//selects class from class drop down
		districtAdminMyResultsPage.selectClassFromClassDrpdown(llData.LLClassName+" LL");
		
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues = getImplementationSummaryTableValuesfromVport();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,
				LLLoginReturnPage.ADMIN_HOME_PAGE);
		// After login into application, verifies Dash board is loaded
		llHomePage.verifyDashBoardTab();
		// Clicks on Tool Tab
		courseResourcesPage = llHomePage.clickOnToolsTab();
		// Verifies program planning tab is loaded after clicking Tools tab
		courseResourcesPage.verifyThatProgramPlanningTabIsLoaded();
		// Clicks on District Settings Tab
		districtSettingsPage = courseResourcesPage.clickOnDistrictSettingsTab();
		// Verifies Summary tab is highlighted by default on clicking District
		// settings tab
		districtSettingsPage.verifySummaryTabHighlighted();
		// Selects School from ALl schools Drop down
		districtSettingsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		// Verifies All Classes drop down is enabled on selecting school
		districtSettingsPage.verifyAllClassesDropdownDisplayed();
		// Selects class from 'All classes' drop down
		districtSettingsPage.selectClassFromAllClasses(llData.LLClassName);
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();
		// To click on benchmarks tab under Class Settings section
		teacherToolsClassSettingsPage.clickOnBenchMarksTab();
		// To verify that benchmarks tab is loaded successfully
		teacherToolsClassSettingsPage.verifyThatBenchMarksTabIsLoaded();
		// To verify that list of benchmarks are displayed
		teacherToolsClassSettingsPage.verifyThatListOfBenchMarksAreLoaded();
		// To enable first test of first benchmark and save the changes
		teacherToolsClassSettingsPage.enableFirstTestOfFirstBenchmarkAndSave();
	}

	public Map<String, String> getImplementationSummaryTableValuesfromVport() {
		//Clicks on My class tab
		districtAdminMyClassPage=districtAdminMyResultsPage.clickOnMyClassTab();
		// Verifies whether My District page is loaded or not
		districtAdminMyClassPage.verifyMyClassPageIsLoaded();
		// Clicks on summary sub tab in My District page
		districtAdminMyClassPage.clickSummaryTab();
		
		districtAdminMyClassPage.verifySummaryTabLoaded();
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues=	districtAdminMyClassPage.getImplementationSummaryTableRowAndValues();
					
		return implementationSummaryrowValues;
	}

}
