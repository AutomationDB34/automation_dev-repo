package com.testsuite.ll.admin;

import java.util.Map;

import javax.swing.text.Utilities;

import org.apache.commons.io.FileUtils;
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
import com.selenium.Sync;
import com.testng.Retry;
import com.utilities.UtilityMethods;

public class LLCampusUserSchoolSettingsSchoolLevelScenarios extends BaseSetup{
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
	/*String[] students;*/
	StudentCreation studentCreation;
	DistrictSettingsPage districtSettingsPage;
	TeacherToolsClassSettingsPage teacherToolsClassSettingsPage;
	/*	String teacheruserId;
	String[] vportTrackLicensesPurchasesDetails;
	String[] vportSchoolLicensesPurchasesDetails;*/
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


	/*
	 * As a campus user, This test verifies Implementation Summary table data in School Settings->Summary page in School level
	 */
	@Test(groups = { "CampusUser", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_019_ToolsSchoolSetttingsSummaryPageSchoolLevelScenarios() {

		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llCampusAdmin, llData.llCampusAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		// Get the data from Implementation Summary Table
		implementationSummaryRowValues = getImplementationSummaryTableValues();
		getLicensesPurchasesDetailsFromVport();
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
	 * As a Campus user, This test Creates teachers and assign classes to the teachers in Schol Settings->Teachers and Classes page in School level
	 */
	@Test(groups ={"CampusUser", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_020_ToolsSchoolSetttingsTeachersAndClassesPageSchoolLevelScenarios() {
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llCampusAdmin, llData.llCampusAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		// Get the data from Implementation Summary Table
		implementationSummaryRowValues = getImplementationSummaryTableValues();
		getLicensesPurchasesDetailsFromVport();
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
		// Verify Summary tab is Highlighted or not by default
		schoolSettingsPage.verifySummaryTabHighlighted();


		//clicks on Teachers and Classes sub tab
		schoolSettingsPage.clickOnTeachersAndClassesTab();
		schoolSettingsPage.moveToFrame();
		//verify Teachers and Classes sub tab is loaded or not 
		schoolSettingsPage.verifyTeachersAndClassesTabLoaded();
		String strRandom = UtilityMethods.get4DRandomNumber();
		//creates Teacher by clicking 'Add New Staff' button 
		districtAdminMySchoolPage.addTeacher(vportData.teacherLastName + strRandom, vportData.teacherFirstName,vportData.teacherEmail);
		//edits teacher user details
		districtAdminMySchoolPage.editTeacherandSave(vportData.teacherLastName + strRandom,vportData.teacherUserId + strRandom, vportData.teacherPassword);		
		//Adds class and license to teacher account		
		districtAdminMySchoolPage.addClassAndLicencesToTeacher(vportData.teacherLastName + strRandom);
		schoolSettingsPage.moveToDefaultFrame();


	}

	/*
	 * As a Campus user, This test downloads template in 'School Settings'->'Import Students'->'Option 1: Roster students into classes' pane and add student details in the downloaded excel and 
	 * uploads the modified excel into the same page and verifies whether student details are uploaded correctly or not 
	 * 
	 */
	@Test(groups ={"CampusUser", "QC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_021_ToolsSchoolSetttingsImportStudentsPageSchoolLevelScenarios() 
	{
		
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llCampusAdmin, llData.llCampusAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		// Get the data from Implementation Summary Table
		implementationSummaryRowValues = getImplementationSummaryTableValues();
		getLicensesPurchasesDetailsFromVport();
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
		// Verify Summary tab is Highlighted or not by default
		schoolSettingsPage.verifySummaryTabHighlighted();
		//clicks on Import Students sub tab
		schoolSettingsPage.clickOnImportStudentsTab();
		schoolSettingsPage.moveToFrame();
		//verifies Import students tab is loaded or not
		schoolSettingsPage.verifyImportStudentsTabLoaded();
		//Clicks on 'Download template' button in 'Option 1: Roster students into classes' pane
		districtSettingsPage.clickOnDownloadTemplateButtoninRosterStudentsintoClassesPane();
		//verifies template is downloaded or not 
		/*if(isChromeBrowser())
		{*/
			String downloadedFilepath=districtSettingsPage.verifyTemplateIsDownloaded(llData.RosterStudentDownloadedTemplateFilePath);
			String currentTime=UtilityMethods.get4DRandomNumber();
			String StudentNew = vportData.studentID+currentTime;
			String[] cellData={StudentNew,vportData.studentLastName,vportData.studentFirstName,vportData.studentDOB,vportData.studentGradeLevel};
			String[] colNamesofExcelsheet={"StudentID","StudentLastName","StudentFirstName","StudentBirthDate","StudentGrade"};
			//Enter Student details into the down loaded excel sheet template 
			districtSettingsPage.enterStudentDetailsIntoDownloadedExcel(downloadedFilepath,"Sheet1",cellData,llData.RowNumbertoEnterData,colNamesofExcelsheet);
			//Uploads the modified excel sheet with student details 
			districtSettingsPage.uploadExcelSheetWithStudentDetials(downloadedFilepath);
			//verify Excel sheet is uploaded  or not 
			districtSettingsPage.verifyExcelSheetUploadedCorrectly();
			districtSettingsPage.clickProceddwithImportButton();
			//Verify Excel sheet is imported successfully or not 
			districtSettingsPage.verifyExcelSheetImportedCorrectly();
			districtSettingsPage.moveToDefaultFrame();
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
			districtSettingsPage.verifyAddedStudentInTheClass(StudentNew);
	//	}
		districtSettingsPage.moveToDefaultFrame();

	}
	/*
	 * As a Campus user, This test verifies License Purchased table data  in School Settings->Licenses tab in School level
	 */

	@Test(groups ={"CampusUser", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_CAMPUSUSER_022_ToolsSchoolSetttingsLicensesPageSchoolLevelScenarios() {
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llCampusAdmin, llData.llCampusAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		// Get the data from Implementation Summary Table
		implementationSummaryRowValues = getImplementationSummaryTableValues();
		getLicensesPurchasesDetailsFromVport();
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
		// Verify Summary tab is Highlighted or not by default
		schoolSettingsPage.verifySummaryTabHighlighted();

		//Clicks on Licenses tab
		schoolSettingsPage.clickOnLicensesTab();
		schoolSettingsPage.moveToFrame();
		//verify licenses tab is loaded or not 
		schoolSettingsPage.verifyLicensesTabLoaded();
		//Clicks on Student license type tab
		districtSettingsPage.clickOnStudentLicenseTab();
		//verify License purchased table is loaded in Student tab
		districtSettingsPage.verifyLicensesPurchasedTableisLoaded();
		String[] vportTrackLicensesPurchasesDetails = new String[2];
		vportTrackLicensesPurchasesDetails[0] = dependentData.getProperty("CampusUser_vportTrackLicensesPurchasesDetails_1");
		vportTrackLicensesPurchasesDetails[1] = dependentData.getProperty("CampusUser_vportTrackLicensesPurchasesDetails_2");
		//Compare track details(Purchased and Used) in Licenses purchased table in Licenses tab with track details read from Vport Licenses tab 
		districtSettingsPage.compareLicensesPurchasedTrackDetailsinLLwithVportLicensesPurchasedTableData(vportData.districAdminTrackName, vportTrackLicensesPurchasesDetails);
		String[] vportSchoolLicensesPurchasesDetails = new String[2];
		vportSchoolLicensesPurchasesDetails[0] = dependentData.getProperty("CampusUser_vportSchoolLicensesPurchasesDetails_1");
		vportSchoolLicensesPurchasesDetails[1] = dependentData.getProperty("CampusUser_vportSchoolLicensesPurchasesDetails_2");
		//Compare school details(Purchased and Used) in Licenses purchased table in Licenses tab with track details read from Vport Licenses tab 
		districtSettingsPage.compareLicensesPurchasedSchoolDetailsinLLwithVportLicensesPurchasedTableData(vportData.vportDistrictAdminSchoolName, vportSchoolLicensesPurchasesDetails);
		districtSettingsPage.moveToDefaultFrame();
	}

	public Map<String, String> getImplementationSummaryTableValues() {



		//Clicks on My class tab
		districtAdminMySchoolPage=districtAdminMyResultsPage.clickMySchoolTab();
		// Verifies whether My District page is loaded or not
		districtAdminMySchoolPage.verifyMySchoolPageIsLoaded();
		// Clicks on summary sub tab in My District page
		districtAdminMySchoolPage.clickSummaryTab();

		districtAdminMySchoolPage.verifySummaryTabLoaded();
		// Get the data from Implementation Summary Table
		implementationSummaryRowValues=	districtAdminMySchoolPage.getImplementationSummaryTableRowAndValues();

		return implementationSummaryRowValues;
	}

	public void getLicensesPurchasesDetailsFromVport()
	{
		//In vport, click on Licenses sub tab in My school tab
		districtAdminMySchoolPage.clickOnLicensesSubtab();
		//verify Licenses tab is laoded 
		districtAdminMySchoolPage.verifyLicensesSubtab();
		//Clicks on Student license type tab
		districtAdminMySchoolPage.clickOnStudentLicenseTab();
		//verify License purchased table is loaded in Student tab
		districtAdminMySchoolPage.verifyLicensesPurchasedTableisLoaded();
		//Get the Track licenses details(purchased and Used) from Licenses Purchased Table
		String vportTrackLicensesPurchasesDetails[]=districtAdminMySchoolPage.getTrackLicensesPurchasedDetailsFromLicensesPurchasedtable(vportData.districAdminTrackName);
		//Get the school licenses details(purchased and Used) from Licenses Purchased Table	
		int i=1;
		for (String s : vportTrackLicensesPurchasesDetails){
			dependentData.writeProperty("CampusUser_vportTrackLicensesPurchasesDetails_"+i, s);
			i++;
		}
		String vportSchoolLicensesPurchasesDetails[] = districtAdminMySchoolPage.getSchoolLicensesPurchasedDetailsFromLicensesPurchasedtable(vportData.vportDistrictAdminSchoolName);
		int j=1;
		for (String s : vportSchoolLicensesPurchasesDetails){
			dependentData.writeProperty("CampusUser_vportSchoolLicensesPurchasesDetails_"+j, s);
			j++;
		}

	}


}
