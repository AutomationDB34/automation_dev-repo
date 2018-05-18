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
import com.data.testdata.VportData.UserRole;
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
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.MasterDistrictTracksPage;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.SafeActions;
import com.selenium.Sync;
import com.testng.Retry;
import com.utilities.UtilityMethods;

public class LLDistrictUserDistrictSettingsDistrictLevelScenarios extends BaseSetup{
	LLData llData;
	LLLoginPage llLoginPage;
	LLHomePage llHomePage;
	CourseReportsPage courseReportsPage;
	VportLoginPage vportLoginPage;
	VportData vportData;
	DistrictAdminMyResultsPage districtAdminMyResultsPage;
	DistrictAdminMyDistrictPage districtAdminMyDistrictPage;
	TeacherToolsClassSettingsPage teacherToolsClassSettingsPage;
	MasterDistrictTracksPage masterDistrictTracksPage;
	DistrictAdminMyClassPage districtAdminMyClassPage;
	Map<String, String> implementationSummaryrowValues;
	CourseResourcesPage courseResourcesPage;
	DistrictSettingsPage districtSettingsPage;
	DistrictAdminMySchoolPage districtAdminMySchoolPage;
	StudentCreation studentCreation;
	SafeActions safeActions;
	ConfigManager dependentData = new ConfigManager("DependentData");
	/*private String[] students;
	String campusUser;
	String vportTrackLicensesPurchasesDetails[];*/
	

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		teacherToolsClassSettingsPage = new TeacherToolsClassSettingsPage(getDriver());
		studentCreation = new StudentCreation(getDriver());
		// Login into Vport application with the District User Credentials
		vportLoginPage = new VportLoginPage(getDriver());
		vportData = new VportData();
		llData = new LLData();
		districtAdminMySchoolPage = new DistrictAdminMySchoolPage(getDriver());
	}
	/*
	@AfterMethod(alwaysRun = true)
	public void logout() {

		LLLogout lllogout = new LLLogout(getDriver());
		llLoginPage = lllogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();
	}

	@AfterMethod()
	public void moveToDefaultFrame()
	{
		districtSettingsPage.moveToDefaultFrame();
	}*/

	/**
	 * As a District user, This test verifies Implementation Summary table data in District Settings->Summary page in District level
	 */
	@Test(groups ={"DistrictUser", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_024_ToolsDistrictSetttingsSummaryPageDistrictLevelScenarios() {

		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues = getImplementationSummaryTableValuesfromVport();
		//Get the Licenses purchased table data from Vport 'My District'->'Licenses' tab 
		getLicensesPurchasesDetailsFromVport();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
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
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();
		
		
		// Move to Summary frame
		districtSettingsPage.moveToFrame();
		// verifies Summary tab is loaded by verifying Implementation summary
		// Table is loaded
		districtSettingsPage.verifySummaryTabLoaded();
		// Verifies Implementation summary data by comparing with the implementation table exists in Vport->My Districts Page
		districtSettingsPage.verifyImplementationSummaryTablewithVportSummaryTable(implementationSummaryrowValues);
		
		//llLoginPage = districtSettingsPage.clickLogoutfromHomePage();
		//llLoginPage.verifyLoginPage();

	}
	
	/*
	 * As a District user, This test enables/Disables the school in District Settings->Schools page in District level
	 */
	@Test(groups ={"DistrictUser", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_025_ToolsDistrictSetttingsSchoolsPageDistrictLevelScenarios() {
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues = getImplementationSummaryTableValuesfromVport();
		//Get the Licenses purchased table data from Vport 'My District'->'Licenses' tab 
		getLicensesPurchasesDetailsFromVport();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
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
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();
		
		//Clicks On Schools tab
		districtSettingsPage.clickOnSchoolsTab();
		// Move to Summary frame
		districtSettingsPage.moveToFrame();
		//Verify Schools tab is loaded or not
		districtSettingsPage.verifySchoolsTabLoaded();
		//Verify User can activates/Deactivates the select checkbox of school
		districtSettingsPage.verifyUserCanActivatesDeactivatesSchoolInSchoolsTab(llData.LLSchoolName);
		
	}
	
	/*
	 * As a District user, This test creates teacher users in District Settings->School Users page in District level
	 */
	@Test(groups ={"DistrictUser", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_026_ToolsDistrictSetttingsSchoolUsersPageDistrictLevelScenarios() {
		getDriver().manage().deleteAllCookies();

		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
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
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();
		
		
		//Clicks On Schools Users tab
		districtSettingsPage.clickOnSchoolUsersTab();
		// Move to Summary frame
		districtSettingsPage.moveToFrame();
		//Verify School Users tab is loaded or not
		districtSettingsPage.verifySchoolUsersTabLoaded();
		masterDistrictTracksPage= new MasterDistrictTracksPage(getDriver());
		// To click on Add New staff button
		masterDistrictTracksPage.clickAddNewStaff();
		//To verify Add New Staff dialog is loaded
		masterDistrictTracksPage.verifyAddNewStaffDialog();
		//To Create School user with teacher role
		String strRandom = UtilityMethods.get4DRandomNumber();
		masterDistrictTracksPage.createSchoolUserWithCampusUserRole(vportData.schoolUserFirstName,vportData.schoolUserLastName+strRandom, vportData.schoolUserEmail, llData.LLSchoolName,UserRole.CAMPUS_USER);
		//To edit the school user with new login and password
		String campusUser= masterDistrictTracksPage.EditSchoolUser(vportData.schoolUserLastName+strRandom, vportData.schoolUserLogin+strRandom,vportData.schoolUserPassword);
		dependentData.writeProperty("LL_DISTRICTUSER_026_CAMPUS_USER", campusUser);
		//To verify school user after modifying
		masterDistrictTracksPage.verifyScholUserDetails(vportData.schoolUserFirstName, vportData.schoolUserLastName+strRandom,llData.LLSchoolName, campusUser, vportData.schoolUserPassword,UserRole.CAMPUS_USER);
	}
	
	/**
	 * As a District user, This test downloads template in 'District Settings'->'Import Students'->'Option 1: Roster students into classes' pane and add student details in the downloaded excel and 
	 * uploads the modified excel into the same page and verifies whether student details are uploaded correctly or not 
	 * 
	 */
	@Test(groups ={"DistrictUser", "QC" }, priority = 5, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_027_ToolsDistrictSetttingsImportStudentsPageDistrictLevelScenarios() {
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues = getImplementationSummaryTableValuesfromVport();
		//Get the Licenses purchased table data from Vport 'My District'->'Licenses' tab 
		getLicensesPurchasesDetailsFromVport();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
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
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();
		
		
		//clicks on Import Students sub tab
		districtSettingsPage.clickOnImportStudentsTab();
		districtSettingsPage.moveToFrame();
		//verifies Import students tab is loaded or not
		districtSettingsPage.verifyImportStudentsTabLoaded();
		//Clicks on 'Download template' button in 'Option 1: Roster students into classes' pane
		districtSettingsPage.clickOnDownloadTemplateButtoninRosterStudentsintoClassesPane();
		if(isChromeBrowser()){
		//verifies template is downloaded or not 
		String downloadedFilepath=districtSettingsPage.verifyTemplateIsDownloaded(llData.RosterStudentDownloadedTemplateFilePath);
		Long currentTime=System.currentTimeMillis();
		String[] cellData={vportData.studentID+currentTime,vportData.studentLastName,vportData.studentFirstName,vportData.studentDOB,vportData.studentGradeLevel};
		String[] colNamesofExcelsheet={"StudentID","StudentLastName","StudentFirstName","StudentBirthDate","StudentGrade"};
		//Enter Student details into the downloaded excel sheet template 
		districtSettingsPage.enterStudentDetailsIntoDownloadedExcel(downloadedFilepath,llData.ExcelSheetName,cellData,llData.RowNumbertoEnterData,colNamesofExcelsheet);
		//Uploads the modified excel sheet with student details 
		districtSettingsPage.uploadExcelSheetWithStudentDetials(downloadedFilepath);
		//verify Excel sheet is uploaded  or not 
		districtSettingsPage.verifyExcelSheetUploadedCorrectly();
		districtSettingsPage.clickProceddwithImportButton();
		//Verify Excel sheet is imported successfully or not 
		districtSettingsPage.verifyExcelSheetImportedCorrectly();
		districtSettingsPage.moveToDefaultFrame();
		// Selects School from ALl schools Drop down
		districtSettingsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
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
		//Verify imported student details in the roster page
		districtSettingsPage.verifyAddedStudentInTheClass(vportData.studentID+currentTime);
		}
	
	}
	
	/*
	 * As a District user, This test verifies  License Purchased table data  in District Settings->Licenses tab in district level
	 */
		
	@Test(groups ={"DistrictUser", "QC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_028_ToolsDistrictSetttingsLicensesPageDistrictLevelScenarios() {
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues = getImplementationSummaryTableValuesfromVport();
		//Get the Licenses purchased table data from Vport 'My District'->'Licenses' tab 
		getLicensesPurchasesDetailsFromVport();
		getDriver().manage().deleteAllCookies();
		// Login into Language live product
		llLoginPage = new LLLoginPage(getDriver());
		llHomePage = (LLHomePage) llLoginPage.loginCredentials(llData.URL,llData.llDistrictAdmin, llData.llDistrictAdmin,LLLoginReturnPage.ADMIN_HOME_PAGE);
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
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();
		
		
		//Clicks on Licenses tab
		districtSettingsPage.clickOnLicensesTab();
		districtSettingsPage.moveToFrame();
		//verify licenses tab is loaded or not 
		districtSettingsPage.verifyLicensesTabLoaded();
		//Clicks on Student license type tab
		districtSettingsPage.clickOnStudentLicenseTab();
		//verify License purchased table is loaded in Student tab
		districtSettingsPage.verifyLicensesPurchasedTableisLoaded();
		String vportTrackLicensesPurchasesDetails[] = new String[2];
		vportTrackLicensesPurchasesDetails[0] = dependentData.getProperty("vportTrackLicensesPurchasesDetails_1");
		vportTrackLicensesPurchasesDetails[1] = dependentData.getProperty("vportTrackLicensesPurchasesDetails_2");
		//Compare track details(Purchased and Used) in Licenses purchased table in Licenses tab with track details read from Vport Licenses tab 
		districtSettingsPage.compareLicensesPurchasedTrackDetailsinLLwithVportLicensesPurchasedTableData(vportData.districAdminTrackName, vportTrackLicensesPurchasesDetails);
		
	}

	/**
	 * Get the Implementation summary table data from Vport 'My District'->'Summary' tab 
	 * @return
	 */
	
	public Map<String, String> getImplementationSummaryTableValuesfromVport() {
		//Clicks on My class tab
		districtAdminMyDistrictPage=districtAdminMyResultsPage.clickMyDistrictTab();
		// Verifies whether My District page is loaded or not
		districtAdminMyDistrictPage.verifyMyDistrictPageIsLoaded();
		// Clicks on summary sub tab in My District page
		districtAdminMyDistrictPage.clickSummaryTab();
		
		districtAdminMyDistrictPage.verifySummaryTabLoaded();
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues=	districtAdminMyDistrictPage.getImplementationSummaryTableRowAndValues();
					
		return implementationSummaryrowValues;
	}
	/**
	 * Get the Licenses purchased table data from Vport 'My District'->'Licenses' tab 
	 */
	 public void getLicensesPurchasesDetailsFromVport()
	 {
		 //In vport, click on Licenses sub tab in My school tab
		 districtAdminMyDistrictPage.clickOnLicenseTab();
		 //verify Licenses tab is loaded 
		 districtAdminMyDistrictPage.verifyLicensesTabLoaded();
		//Clicks on Student license type tab
		 districtAdminMySchoolPage.clickOnStudentLicenseTab();
		//verify License purchased table is loaded in Student tab
		 districtAdminMySchoolPage.verifyLicensesPurchasedTableisLoaded();
		 //Get the Track licenses details(purchased and Used) from Licenses Purchased Table
		 String vportTrackLicensesPurchasesDetails[] =districtAdminMySchoolPage.getTrackLicensesPurchasedDetailsFromLicensesPurchasedtable(vportData.districAdminTrackName);
		 int i=1;
		 for (String s : vportTrackLicensesPurchasesDetails){
		 dependentData.writeProperty("vportTrackLicensesPurchasesDetails_"+i, s);
		 i++;
		 }
	 }
}
