package com.testsuite.ll.admin;

import java.sql.Date;
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
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.SafeActions;
import com.selenium.Sync;
import com.testng.Retry;
import com.utilities.UtilityMethods;

public class LLDistrictUserDistrictSettingsSchoolLevelScenarios extends BaseSetup{
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
	DistrictAdminMySchoolPage districtAdminMySchoolPage;
	ConfigManager dependentData = new ConfigManager("DependentData");
	/*String teacheruserId;
	String vportTrackLicensesPurchasesDetails[];
	String[] vportSchoolLicensesPurchasesDetails;
	 */

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		teacherToolsClassSettingsPage = new TeacherToolsClassSettingsPage(getDriver());
		studentCreation = new StudentCreation(getDriver());
		// Login into Vport application with the District User Credentials
		vportLoginPage = new VportLoginPage(getDriver());
		vportData = new VportData();
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
	}

/*	@AfterMethod(alwaysRun = true)
	public void logout() {

		LLLogout lllogout = new LLLogout(getDriver());
		llLoginPage = lllogout.clickLogoutfromHomePage();
		llLoginPage.verifyLoginPage();
	}*/

	/*
	 * As a District user, This test verifies Implementation Summary table data in District Settings->Summary page in School level
	 */
	@Test(groups ={ "DistrictUser", "QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_020_ToolsDistrictSetttingsSummaryPageSchoolLevelScenarios() {

		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//Selects School from school main Drop down
		districtAdminMyResultsPage.selectSchoolFromSchoolDrpdown(llData.LLSchoolName);
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
		// Verifies Summary tab is highlighted by default on clicking District settings tab
		districtSettingsPage.verifySummaryTabHighlighted();
		// Selects School from ALl schools Drop down
		districtSettingsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();

		// Move to Summary frame
		districtSettingsPage.moveToFrame();
		// verifies Summary tab is loaded by verifying Implementation summary
		// Table is loaded
		districtSettingsPage.verifySummaryTabLoaded();
		// Verifies Implementation summary data by comparing with the implementation table exists in Vport->My Districts Page
		districtSettingsPage.verifyImplementationSummaryTablewithVportSummaryTable(implementationSummaryrowValues);
		districtSettingsPage.verifyAddAndImportButtonsareDisplayedinSummaryPageaAtSchoolLevel();
		districtSettingsPage.moveToDefaultFrame();

	}	
	/*
	 * As a District user, This test Creates teachers and assign classes to the teachers in District Settings->Teachers and Classes page in School level
	 */
	@Test(groups ={"DistrictUser", "QC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_021_ToolsDistrictSetttingsTeachersAndClassesPageSchoolLevelScenarios() {

		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//Selects School from school main Drop down
		districtAdminMyResultsPage.selectSchoolFromSchoolDrpdown(llData.LLSchoolName);
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
		// Verifies Summary tab is highlighted by default on clicking District settings tab
		districtSettingsPage.verifySummaryTabHighlighted();
		// Selects School from ALl schools Drop down
		districtSettingsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();

		//clicks on Teachers and Classes sub tab
		districtSettingsPage.clickOnTeachersAndClassesTab();
		districtSettingsPage.moveToFrame();
		//verify Teachers and Classes sub tab is loaded or not 
		districtSettingsPage.verifyTeachersAndClassesTabLoaded();
		String strRandom = UtilityMethods.get4DRandomNumber();	
		//creates Teacher by clicking 'Add New Staff' button 
		districtAdminMySchoolPage.addTeacher(vportData.teacherLastName + strRandom, vportData.teacherFirstName,vportData.teacherEmail);
		//edits teacher user details
		districtAdminMySchoolPage.editTeacherandSave(vportData.teacherLastName + strRandom,vportData.teacherUserId + strRandom, vportData.teacherPassword);		
		//Adds class and license to teacher account		
		districtAdminMySchoolPage.addClassAndLicencesToTeacher(vportData.teacherLastName + strRandom);
		districtSettingsPage.moveToDefaultFrame();


	}

	/*
	 * As a District user, This test downloads template in 'District Settings'->'Import Students'->'Option 1: Roster students into classes' pane and add student details in the downloaded excel and 
	 * uploads the modified excel into the same page and verifies whether student details are uploaded correctly or not 
	 * 
	 */
	@Test(groups ={"DistrictUser", "QC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL_DISTRICTUSER_022_ToolsDistrictSetttingsImportStudentsPageSchoolLevelScenarios() {
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//Selects School from school main Drop down
		districtAdminMyResultsPage.selectSchoolFromSchoolDrpdown(llData.LLSchoolName);
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
		// Verifies Summary tab is highlighted by default on clicking District settings tab
		districtSettingsPage.verifySummaryTabHighlighted();
		// Selects School from ALl schools Drop down
		districtSettingsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
		// Verify Summary tab is Highlighted or not by default
		districtSettingsPage.verifySummaryTabHighlighted();


		//clicks on Import Students sub tab
		districtSettingsPage.clickOnImportStudentsTab();
		districtSettingsPage.moveToFrame();
		//verifies Import students tab is loaded or not
		districtSettingsPage.verifyImportStudentsTabLoaded();
		//Clicks on 'Download template' button in 'Option 1: Roster students into classes' pane
		districtSettingsPage.clickOnDownloadTemplateButtoninRosterStudentsintoClassesPane();
	//	if(isChromeBrowser()){
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
	//	}
		districtSettingsPage.moveToDefaultFrame();

	}

	/*
	 * As a District user, This test verifies  License Purchased table data  in District Settings->Licenses tab in School level
	 */

	@Test(groups ={"DistrictUser", "QC" }, priority = 3, retryAnalyzer = Retry.class)
	public void LL_DISTRICTUSER_023_ToolsDistrictSetttingsLicensesPageSchoolLevelScenarios() {

		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportLoginPage.verifyLoginPage();
		vportLoginPage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
		districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportLoginPage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);
		//Selects School from school main Drop down
		districtAdminMyResultsPage.selectSchoolFromSchoolDrpdown(llData.LLSchoolName);
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
		// Verifies Summary tab is highlighted by default on clicking District settings tab
		districtSettingsPage.verifySummaryTabHighlighted();
		// Selects School from ALl schools Drop down
		districtSettingsPage.selectSchoolFromAllSchools(llData.LLSchoolName);
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
		String[] vportTrackLicensesPurchasesDetails = new String[2];
		vportTrackLicensesPurchasesDetails[0] = dependentData.getProperty("DistrictUser_vportTrackLicensesPurchasesDetails_1");
		vportTrackLicensesPurchasesDetails[1] = dependentData.getProperty("DistrictUser_vportTrackLicensesPurchasesDetails_2");
		//Compare track details(Purchased and Used) in Licenses purchased table in Licenses tab with track details read from Vport Licenses tab 
		districtSettingsPage.compareLicensesPurchasedTrackDetailsinLLwithVportLicensesPurchasedTableData(vportData.districAdminTrackName, vportTrackLicensesPurchasesDetails);
		String[] vportSchoolLicensesPurchasesDetails = new String[2];
		vportSchoolLicensesPurchasesDetails[0] = dependentData.getProperty("DistrictUser_vportSchoolLicensesPurchasesDetails_1");
		vportSchoolLicensesPurchasesDetails[1] = dependentData.getProperty("DistrictUser_vportSchoolLicensesPurchasesDetails_2");
		//Compare school details(Purchased and Used) in Licenses purchased table in Licenses tab with track details read from Vport Licenses tab 
		districtSettingsPage.compareLicensesPurchasedSchoolDetailsinLLwithVportLicensesPurchasedTableData(vportData.vportDistrictAdminSchoolName, vportSchoolLicensesPurchasesDetails);
		districtSettingsPage.moveToDefaultFrame();
	}
	/**
	 * Get the Implementation summary table data from Vport 'My District'->'Summary' tab 
	 * @return
	 */
	public Map<String, String> getImplementationSummaryTableValuesfromVport() {



		//Clicks on My class tab
		districtAdminMySchoolPage=districtAdminMyResultsPage.clickMySchoolTab();
		// Verifies whether My District page is loaded or not
		districtAdminMySchoolPage.verifyMySchoolPageIsLoaded();
		// Clicks on summary sub tab in My District page
		districtAdminMySchoolPage.clickSummaryTab();
		districtAdminMySchoolPage.verifySummaryTabLoaded();
		// Get the data from Implementation Summary Table
		implementationSummaryrowValues=	districtAdminMySchoolPage.getImplementationSummaryTableRowAndValues();		
		return implementationSummaryrowValues;
	} 
	/**
	 * Get the Licenses purchased table data from Vport 'My District'->'Licenses' tab 
	 */

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
		int i=1;
		for (String s : vportTrackLicensesPurchasesDetails){
			dependentData.writeProperty("DistrictUser_vportTrackLicensesPurchasesDetails_"+i, s);
			i++;
		}
		//Get the school licenses details(purchased and Used) from Licenses Purchased Table
		String []vportSchoolLicensesPurchasesDetails = districtAdminMySchoolPage.getSchoolLicensesPurchasedDetailsFromLicensesPurchasedtable(vportData.vportDistrictAdminSchoolName);
		int j=1;
		for (String s : vportSchoolLicensesPurchasesDetails){
			dependentData.writeProperty("DistrictUser_vportSchoolLicensesPurchasesDetails_"+j, s);
			j++;
		}



	}
}
