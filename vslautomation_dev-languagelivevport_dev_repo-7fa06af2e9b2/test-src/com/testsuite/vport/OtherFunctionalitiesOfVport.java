/**
 * Phase4 Test Cases
 */
package com.testsuite.vport;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.datamanager.ConfigManager;
import com.page.module.dibelsnext.DibelsNextLoginPage;
import com.page.module.dibelsnext.StudentCenterPage;
import com.page.module.vport.AddorEditTrackPage;
import com.page.module.vport.DistrictAdminHomepage;
import com.page.module.vport.DistrictAdminMyClassPage;
import com.page.module.vport.DistrictAdminMyDistrictPage;
import com.page.module.vport.DistrictAdminMyResultsPage;
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.DistrictTrackContactsPage;
import com.page.module.vport.DistrictTrackMaterialsPage;
import com.page.module.vport.DistrictTrackSchoolTracksPage;
import com.page.module.vport.DistrictTrackTechnologyPage;
import com.page.module.vport.MasterDistrictTracksPage;
import com.page.module.vport.TeacherLoginScenarios;
import com.page.module.vport.VportAdministrationPageAllTabs;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportTrackFilterPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.Sync;
import com.testng.Retry;
import com.utilities.UtilityMethods;

/**
 * Phase4 Test Cases
 */
public class OtherFunctionalitiesOfVport extends BaseSetup
{
	private VportLoginPage vportloginpage;
	private VportData vportData;
	private VportAdministrationPageAllTabs vportAdminnistrationpageallTabs;
	private DistrictAdminMyDistrictPage districtAdminMyDistrictPage;
	private VportTrackFilterPage vporttrackfilterPage;
	private MasterDistrictTracksPage masterDistrictTracksPage;
	private DistrictTrackMaterialsPage districtmaterialspage;
	private DistrictAdminHomepage districtAdminHomePage;
	private DistrictAdminMyClassPage districtAdminMyClassPage;
	private DibelsNextLoginPage dibelsNextLoginPage;
	private StudentCenterPage studentCenterPage;
	private AddorEditTrackPage addedittrack;
	private DistrictTrackTechnologyPage districttracktechnologypage;
	private TeacherLoginScenarios teacherLoginScenarios;
	private DistrictTrackSchoolTracksPage districtTrackSchoolTracksPage;
	private DistrictTrackContactsPage districtTrackContactsPage;
	private DistrictAdminHomepage districtAdminHomepage;
	private DistrictAdminMySchoolPage districtAdminMySchoolPage;

	private DistrictAdminMyResultsPage districtAdminResultsPage;
	ConfigManager dependentData = new ConfigManager("DependentData");
	ConfigManager app = new ConfigManager("App");
	private LLData llData;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
	}


	@Test(priority = 1, groups = { "RC" },retryAnalyzer = Retry.class)
	public void VPORT_009_SceduleOnlineAssessmentsAndStudentCenters() {
		String trackName = dependentData.getProperty("VPORT_001_TrackName");
		String schoolName = dependentData.getProperty("VPORT_002_SchoolName");
		String className = dependentData.getProperty("VPORT_006_CLASS3");
		String districtUser = dependentData.getProperty("VPORT_002_DistrictUserName");

		// Step1: Login to vport site with the admin logins created for the
		// newly created track
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(districtUser, vportData.distUserPassword);
		districtAdminHomePage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		// Step 2: Find that My Home page is shown
		districtAdminHomePage.verifyHomePage(trackName, vportData.productName);
		// Step3:select the school available from the school selection dropdown
		// displayed at the top of the screen
		districtAdminHomePage.selectSchoolFromDropdown(schoolName);
		districtAdminHomePage.verifyHomePage(schoolName, vportData.productName);
		districtAdminMySchoolPage = districtAdminHomePage.clickOnMySchoolTab();
		// Step4: Now select the class available from the class selection
		// dropdown displayed at the top of the screen
		districtAdminMySchoolPage.selectClassFromClassDropDown(className);
		districtAdminMyClassPage = districtAdminMySchoolPage.clickOnMyClassTab();
		districtAdminMyClassPage.clickOnRoster();
		// Step5: find that My class - roster page is shown with list of
		// students available
		districtAdminMyClassPage.verifyNavigationToMyClassTabRoster(className);
		districtAdminMyClassPage.clickAddStudentsButtonOnMYClassRostersMainPage();
		districtAdminMyClassPage.verifyNavigationToCreateStudentsPage();
		// Create new student in the roster page
		districtAdminMyClassPage.clickAddButtonOnCreateNewStudentsToRosterPage();
		districtAdminMyClassPage.verifyNavigationToAddNewStudentsPopUp();
		String studentID = districtAdminMyClassPage.fillNewStudentDetailsOnAddNewStudentsPopUp(
				vportData.studentLastName, vportData.studentFirstName, vportData.studentID, vportData.studentGradeLevel,
				vportData.studentDOB);
		districtAdminMyClassPage.clickSaveChangesButtonOnAddNewStudentsPopUp();
		districtAdminMyClassPage.verifyAddNewStudentsPopUpDisappeared();
		districtAdminMyClassPage.clickReturnToClassRosterButton();
		districtAdminMyClassPage.verifyNavigationToMyClassTabRoster(className);
		districtAdminMyClassPage.verifyAddedStudentInTheClass(studentID);
		districtAdminMyClassPage.checkPPT2REdplicityLicensetoStudent(studentID);
		districtAdminMyClassPage.changeUserIDAndPasswordOfStudentAndSave(studentID);
		districtAdminMyClassPage.clicksaveChanges();
		//Storing the student data which has assessment score
		dependentData.writeProperty("VPORT_009_StudentDetails", studentID);

		// Step6: If the product is having student center, then click on schedule online assessment tab for assigning the activities
		districtAdminMyClassPage.navigateToScheduleOnlineAssessmentsTab();
		districtAdminMyClassPage.verifyScheduleOnlineAssessmentsTab();
		// Step 7: click on the check boxes available for each assessment/user
		// inorder to assign the assignment
		String passageName = districtAdminMyClassPage.enableTestForStudent("Benchmark 1");
		districtAdminMyClassPage.clicksaveChanges();
		//Logout from the application
		vportloginpage=districtAdminMyClassPage.clickLogoutLink();
		vportloginpage.verifyLoginPage();
		dibelsNextLoginPage = new DibelsNextLoginPage(getDriver());
		// Step8: now, navigate to the respective student center available for the application/license type & login with the studnet logins available in roster page
		if(vportData.vportURL.contains("qa."))
		{
			getDriver().get("https://qa.dibelsnext.voyagersopris.com/logon");
		}
		else
		{
			getDriver().get("https://dibelsnext.voyagersopris.com/logon");
		}
		dibelsNextLoginPage.verifyLoginPage();
		dibelsNextLoginPage.enterLoginCredentials(studentID, studentID);
		studentCenterPage = dibelsNextLoginPage.clickSignInButton();
		// Step9: find that user is logged in successfully
		studentCenterPage.verifyStudentCenterPage();
		// Step10: find that on the login page, assigned assessments are beign
		// enabled
		studentCenterPage.verifyenabledAssessmentExists(passageName);
		// Step11: Click on the assessment link enabled
		studentCenterPage.startAssessment(passageName);
		// Step 12: find that test is enabled
		// Step 13: complete the assessment enabled according to the
		// instructions played
		// Step 14: after completion of the assessment, find that user is being
		// moved to the home page
		studentCenterPage.completeAssessment(vportData);


		// Step 15: now, move back to vport page
		getDriver().get(vportData.vportURL);

		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(districtUser, vportData.distUserPassword);
		districtAdminHomePage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);

		districtAdminHomePage.verifyHomePage(trackName, vportData.productName);
		districtAdminHomePage.selectSchoolFromDropdown(schoolName);
		districtAdminMySchoolPage = districtAdminHomePage.clickOnMySchoolTab();
		districtAdminMySchoolPage.selectClassFromClassDropDown(className);
		districtAdminMyClassPage = districtAdminMySchoolPage.clickOnMyClassTab();
		districtAdminMyClassPage.verifyNavigationToMyClassTabRoster(className);
		// Step 16: click on enter scores tab
		// Step 17: find that, results of the test taken are shown for the
		// respective assessments
		districtAdminMyClassPage.navigateToEnterScoresSubTab();
		String student_Assessment_score = districtAdminMyClassPage.verifyAssessmentSubmittedByStudentDAZE(studentID);

		//Storing the student scored data 
		dependentData.writeProperty("VPORT_009_StudentAssessmentScore", student_Assessment_score);

		// Step 18: If the application does not have any studnet center then
		// click on enter scores tab
		districtAdminMyClassPage.verifyPencilIcon(studentID);
		// Step 19: click on the pencil icon available for each assessment & user in order to enabled the assessment
		// Step 20: find that test is enabled with in the vport page
		// Step 21: complete the assessment enabled according to the instructions enabled
		// Step 22: find that after completion, control will be moved to the enter scores page again along with test score updation for the respective test
		districtAdminMyClassPage.clickOnPencilIconForAssessment(studentID, vportData);

		//Logout from the application
		vportloginpage=districtAdminMyClassPage.clickLogoutLink();
		vportloginpage.verifyLoginPage();
	}

	@Test(priority = 2 , retryAnalyzer = Retry.class)
	public void VPORT_10_VerifyAllTabsPages()
	{
		//1. Login to vport site with the admin/teacher logins created for the newly created track
		//2. click on all tabs, link, pages available on vport
		//3. check whether user is being navigated to the respective pages or not & links are functional or not
		/* ---Verification For District User--- */
		String districtUser = dependentData.getProperty("VPORT_002_DistrictUserName");
		vportloginpage.enterLoginCredentials(districtUser, vportData.distUserPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		//	Verifying all the Pages and links for District user
		districtAdminHomepage.verifyAllTheLinksAndPages("DistUser");
		//Log out from District user Login
		vportloginpage=districtAdminHomepage.clickLogoutLink();
		vportloginpage.verifyLoginPage();

		/*	 ---Verification For Campus User User--- 
		String campusUser = dependentData.getProperty("VPORT_002_SchoolUser");
		vportloginpage.enterLoginCredentials(campusUser, vportData.schoolUserPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		//	Verifying all the Pages and links for District user
		districtAdminHomepage.verifyAllTheLinksAndPages("CampUser");
		//Log out from Campus/School user Login
		vportloginpage=districtAdminHomepage.clickLogoutLink();
		vportloginpage.verifyLoginPage();

		 ---Verification For Teacher User--- 
		String teacher = dependentData.getProperty("VPORT_006_TeacherUserID");
		vportloginpage.enterLoginCredentials(teacher, teacher);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		//	Verifying all the Pages and links for District user
		districtAdminHomepage.verifyAllTheLinksAndPages("Teacher");
		//Log out from Teacher user Login
		vportloginpage=districtAdminHomepage.clickLogoutLink();
		vportloginpage.verifyLoginPage();*/
	}

	@Test(priority = 3, retryAnalyzer = Retry.class)
	public void VPORT_11_ImportStudentsOption1()
	{
		//		"1. Login to vport site with the admin/teacher logins created for the newly created track
		String districtUser = dependentData.getProperty("VPORT_002_DistrictUserName");
		String school = dependentData.getProperty("VPORT_002_SchoolName");
		vportloginpage.enterLoginCredentials(districtUser, vportData.distUserPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		//		 2. Navigate to My district/school - Import students page
		districtAdminMyDistrictPage = districtAdminHomepage.clickOnMyDistrictLink();
		districtAdminMyDistrictPage.clickOnImportStudents();
		//		 3. find that page is enbaled with two options to import the students 
		districtAdminMyDistrictPage.verifyImportOptions();
		//		 4. Now download template in the first option 
		//		 ""Option 1: Roster students into classes""
		//		 5. click on the ""Download template"" button & download the template for the import 
		districtAdminMyDistrictPage.clickOnOption1DownloadTemplateButton();
		//		 6. Open the file downloaded & add thye users details(student ID, first name, last name, student birth date, Grade) need to be added to the vport to a particular class
		String downloadedFilepath=districtAdminMyDistrictPage.verifyTemplateIsDownloaded(vportData.RosterStudentDownloadedTemplateFilePath);
		String currentTime=UtilityMethods.get4DRandomNumber();
		String StudentNew = vportData.studentID+currentTime;
		String[] cellData={StudentNew,vportData.studentLastName,vportData.studentFirstName,vportData.studentDOB,vportData.studentGradeLevel};
		String[] colNamesofExcelsheet={"StudentID","StudentLastName","StudentFirstName","StudentBirthDate","StudentGrade"};
		//Enter Student details into the down loaded excel sheet template 
		districtAdminMyDistrictPage.enterStudentDetailsIntoDownloadedExcel(downloadedFilepath,"Sheet1",cellData,llData.RowNumbertoEnterData,colNamesofExcelsheet);
		//		 7. Now select the file using browse button & click on submit button 
		districtAdminMyDistrictPage.uploadExcelSheetWithStudentDetialsOption1(downloadedFilepath);
		//		 8. Find that file is being submitted & respective success message is shown 
		//		 9. respective error message will be shown if the data provided in file is not correct 
		districtAdminMyDistrictPage.verifyExcelSheetUploadedCorrectly();
		//		 10. Click ""proceed to import"" button to complete the importing students 
		districtAdminMyDistrictPage.clickProceddwithImportButton();
		districtAdminMyDistrictPage.verifyExcelSheetImportedCorrectly();
		//		 11. navigate to the respective school & class to check whether the user is added to the roster or not
		districtAdminMyDistrictPage.selectSchoolFromAllSchools(school);
		districtAdminMyDistrictPage.selectClassFromAllClassesDefault("TL Level A");
		//		 12. Verify whether student is rostered into the class wihtout assigning licenses "
		districtAdminMyDistrictPage.clickOnRosterTab();
		districtAdminMyDistrictPage.verifyRosterTabLoaded();
		districtAdminMyDistrictPage.verifyAddedStudentInTheClass(StudentNew);
		//Log out from Teacher user Login
		vportloginpage=districtAdminHomepage.clickLogoutLink();
		vportloginpage.verifyLoginPage();

	}

	@Test(priority = 4, retryAnalyzer = Retry.class)
	public void VPORT_12_ImportStudentsOption2()
	{
		//		1. Login to vport site with the admin/teacher logins created for the newly created track
		String districtUser = dependentData.getProperty("VPORT_002_DistrictUserName");
		String school = dependentData.getProperty("VPORT_002_SchoolName");
		vportloginpage.enterLoginCredentials(districtUser, vportData.distUserPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		//		2. Navigate to My district/school - Import students page
		districtAdminMyDistrictPage = districtAdminHomepage.clickOnMyDistrictLink();
		districtAdminMyDistrictPage.clickOnImportStudents();
		//		3. find that page is enbaled with two options to import the students 
		districtAdminMyDistrictPage.verifyImportOptions();
		//		4. Now download template in the first option 
		//"Option 2: Import students into the database" 
		//		5. click on the "Download template" button & download the template for the import 
		districtAdminMyDistrictPage.clickOnOption2DownloadTemplateButton();
		//		6. Open the file downloaded & add thye users details(student ID, first name, last name, student birth date, Grade) need to be added to the vport 
		String downloadedFilepath=districtAdminMyDistrictPage.verifyTemplateIsDownloaded(vportData.RosterStudentDownloadedTemplateFilePath);
		String currentTime=UtilityMethods.get4DRandomNumber();
		String StudentNew = vportData.studentID+currentTime;
		String[] cellData={StudentNew,vportData.studentLastName,vportData.studentFirstName,vportData.studentDOB,vportData.studentGradeLevel};
		String[] colNamesofExcelsheet={"StudentID","StudentLastName","StudentFirstName","StudentBirthDate","StudentGrade"};
		districtAdminMyDistrictPage.enterStudentDetailsIntoDownloadedExcel(downloadedFilepath,"Sheet1",cellData,llData.RowNumbertoEnterData,colNamesofExcelsheet);
		//		7. Now select the file using browse button & click on submit button 
		districtAdminMyDistrictPage.uploadExcelSheetWithStudentDetialsOption2(downloadedFilepath);
		//8. Find that file is being submitted & respective success message is shown 
		//		9. respective error message will be shown if the data provided in file is not correct 
		districtAdminMyDistrictPage.verifyExcelSheetUploadedCorrectly();
		//		10. Click "proceed to import" button to complete the importing students 
		districtAdminMyDistrictPage.clickProceddwithImportButton();
		districtAdminMyDistrictPage.verifyExcelSheetImportedCorrectly();
		//11. Now after successful importing of student, the student is added into database 
		districtAdminMyDistrictPage.selectSchoolFromAllSchools(school);
		districtAdminMyDistrictPage.selectClassFromAllClassesDefault("TL Level A");
		//		12. Next navigate to any class to which you wish to add the imported student 
		//13. Navigate to My Class - Roster - Add students 
		districtAdminMyDistrictPage.clickOnRosterTab();
		districtAdminMyDistrictPage.verifyRosterTabLoaded();
		districtAdminMyDistrictPage.clickOnAddStudentsRoster();
		//		14. Search the imported student ID under "Available Students"text box and click enter 
		districtAdminMyDistrictPage.verifyAvailableStudentsSearchHeadder();
		districtAdminMyDistrictPage.enterStudentIDToSearch(StudentNew);
		districtAdminMyDistrictPage.verifyThesearchedStudentLoaded();
		//15.Click on the Add (->) button to add student to the particular class and click 'save changes' 
		districtAdminMyDistrictPage.clickOnAddArrowButtonOnSearchedStudent();
		districtAdminMyDistrictPage.clickOnSaveChangesButton();
		//		16. Verify whether student is rostered into the class wihtout assigning licenses
		districtAdminMyDistrictPage.verifyTheStudentAddedClassRosterOnSamePage(StudentNew);
		districtAdminMyDistrictPage.ClickOnReturnToClassRoasterButton();
		districtAdminMyDistrictPage.verifyRosterTabLoaded();
		districtAdminMyDistrictPage.verifyAddedStudentInTheClass(StudentNew);
		//Log out from Teacher user Login
		vportloginpage=districtAdminHomepage.clickLogoutLink();
		vportloginpage.verifyLoginPage();
	}
	
	@Test(priority = 5,retryAnalyzer = Retry.class)
	public void VPORT_13_CompareResults() {

		String trackName = dependentData.getProperty("VPORT_001_TrackName");
		String schoolName = dependentData.getProperty("VPORT_002_SchoolName");
		String className = dependentData.getProperty("VPORT_006_CLASS3");
		String districtUser = dependentData.getProperty("VPORT_002_DistrictUserName");
		String studentAssessmentSCore = dependentData.getProperty("VPORT_013_StudentAssessmentScore");


		//------------------creating student user--------------------- 		
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(districtUser, vportData.distUserPassword);
		districtAdminHomePage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		// Step 2: Find that My Home page is shown
		districtAdminHomePage.verifyHomePage(trackName, vportData.productName);
		// Step3:select the school available from the school selection dropdown
		// displayed at the top of the screen
		districtAdminHomePage.selectSchoolFromDropdown(schoolName);
		districtAdminHomePage.verifyHomePage(schoolName, vportData.productName);
		districtAdminMySchoolPage = districtAdminHomePage.clickOnMySchoolTab();
		// Step4: Now select the class available from the class selection
		// dropdown displayed at the top of the screen
		districtAdminMySchoolPage.selectClassFromClassDropDown(className);
		districtAdminMyClassPage = districtAdminMySchoolPage.clickOnMyClassTab();
		districtAdminMyClassPage.clickOnRoster();
		// Step5: find that My class - roster page is shown with list of
		// students available
		districtAdminMyClassPage.verifyNavigationToMyClassTabRoster(className);
		districtAdminMyClassPage.clickAddStudentsButtonOnMYClassRostersMainPage();
		districtAdminMyClassPage.verifyNavigationToCreateStudentsPage();
		// Create new student in the roster page
		districtAdminMyClassPage.clickAddButtonOnCreateNewStudentsToRosterPage();
		districtAdminMyClassPage.verifyNavigationToAddNewStudentsPopUp();
		String studentID13 = districtAdminMyClassPage.fillNewStudentDetailsOnAddNewStudentsPopUp(
				vportData.studentLastName, vportData.studentFirstName, vportData.studentID, vportData.studentGradeLevel,
				vportData.studentDOB);
		districtAdminMyClassPage.clickSaveChangesButtonOnAddNewStudentsPopUp();
		districtAdminMyClassPage.verifyAddNewStudentsPopUpDisappeared();
		districtAdminMyClassPage.clickReturnToClassRosterButton();
		districtAdminMyClassPage.verifyNavigationToMyClassTabRoster(className);
		districtAdminMyClassPage.verifyAddedStudentInTheClass(studentID13);
		districtAdminMyClassPage.checkPPT2REdplicityLicensetoStudent(studentID13);
		districtAdminMyClassPage.changeUserIDAndPasswordOfStudentAndSave(studentID13);
		districtAdminMyClassPage.clicksaveChanges();
		//Storing the student data which has assessment score
		dependentData.writeProperty("VPORT_013_StudentDetails", studentID13);

		//-----------------------Complete DORF Assessment---------------------
		getDriver().get(vportData.vportURL);

		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(districtUser, vportData.distUserPassword);
		districtAdminHomePage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);

		districtAdminHomePage.verifyHomePage(trackName, vportData.productName);
		districtAdminHomePage.selectSchoolFromDropdown(schoolName);
		districtAdminMySchoolPage = districtAdminHomePage.clickOnMySchoolTab();
		districtAdminMySchoolPage.selectClassFromClassDropDown(className);
		districtAdminMyClassPage = districtAdminMySchoolPage.clickOnMyClassTab();
		districtAdminMyClassPage.verifyNavigationToMyClassTabRoster(className);
		// Step 16: click on enter scores tab
		// Step 17: find that, results of the test taken are shown for the
		// respective assessments
		districtAdminMyClassPage.navigateToEnterScoresSubTab();


		// Step 18: If the application does not have any studnet center then
		// click on enter scores tab
		districtAdminMyClassPage.verifyPencilIcon(studentID13);
		// Step 19: click on the pencil icon available for each assessment & user in order to enabled the assessment
		// Step 20: find that test is enabled with in the vport page
		// Step 21: complete the assessment enabled according to the instructions enabled
		// Step 22: find that after completion, control will be moved to the enter scores page again along with test score updation for the respective test
		districtAdminMyClassPage.clickOnPencilIconForAssessment(studentID13, vportData);
		String student_Assessment_score = districtAdminMyClassPage.verifyAssessmentSubmittedByStudentDORF(studentID13);

		//Storing the student scored data 
		dependentData.writeProperty("VPORT_013_StudentAssessmentScore", student_Assessment_score);

		//Logout from the application
		vportloginpage=districtAdminMyClassPage.clickLogoutLink();

		//------------------------------Verify DORF score results----------------------------
		// Step 1: 1. Login to vport site with the admin/teacher logins created
		// for the newly created track
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(districtUser, vportData.distUserPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		// Step 2: Find that My Home page is shown
		districtAdminHomepage.verifyHomePage(trackName, "Passport");
		// Navigate to My results page
		districtAdminResultsPage = districtAdminHomepage.clickOnMyResultsTab();
		// Step3: find that key measures page is displayed
		districtAdminResultsPage.verifyMyResultspage();
		// Step4: select the filters & find that results are being updated
		districtAdminResultsPage.selectFiltersAndVerifyREsults();
		// Step5:select scores sub tab and results are shown correctly or not in
		// compare to My class - enter scores page
		String studentName = dependentData.getProperty("VPORT_013_StudentDetails");
		districtAdminResultsPage.verifyScoresScaleResults(schoolName, className, studentName, studentAssessmentSCore);
		// Step6:verify student/parent report & its options available for
		// generating the reports
		districtAdminResultsPage.verifyStudentParentReports(studentName);

		// Log out from Teacher user Login
		vportloginpage = districtAdminHomepage.clickLogoutLink();
		vportloginpage.verifyLoginPage();

	}

	@Test(priority = 6, retryAnalyzer = Retry.class)
	public void VPORT_14_VerifyLoginPageAndLinks()
	{
		String footerTitles[] = {vportData.SYSTEMREQUIREMENTS,vportData.CUSTOMERSUPPORT,vportData.FBSHARE};
		//		1. Login to Vport login page
		//		2. check the system check details
		//		3. ckeck the links available & its functionality
		vportloginpage.verifyLearnMoreLink(vportData.VSL_URL);
		vportloginpage.verifyfooterTitles(footerTitles);
		vportloginpage.verifyForgetPasswordLinkAndFunctionality();
		vportloginpage.verifySystemCheckAndList();
		//		4. check the VSL logo & TM
		vportloginpage.verifyVSLLogo();
	}

	@Test(priority = 7, retryAnalyzer = Retry.class)
	public void VPORT_16_EnablingBenchmarkScoresManageRosterProgressMonitoring()
	{
		//1.Navigate to vport site
		String trackName = dependentData.getProperty("VPORT_001_TrackName");
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		vporttrackfilterPage.verifyFilterPage();
		//2.Select any product track & navigate to IPT tab - District track - technology section
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		districtTrackContactsPage = vporttrackfilterPage.clickonTrackName(trackName);
		// To verify Contacts page is loaded
		districtTrackContactsPage.verifyDistrictTrackContactsPage(trackName);
		districtTrackContactsPage.clickOnIPTTab();
		districtTrackContactsPage.clickOnTechnologyTab();		
		//3.Find that Customer interface section is being displayed
		districtTrackContactsPage.verifyCustomerInterface();
		//4.Here we can explicitly enable or disable Benchmark Scores, Manage Roster & Progress monitoring sections for a particular levels for products having assesment plans"
		districtTrackContactsPage.verifyTheRadioButtons();
		districtTrackContactsPage.verifyTheSaveChangesButton();
		districtTrackContactsPage.verifyTheAssessmentsplansSelectOptions();
		//Log Off from the application
		vportloginpage=districtTrackContactsPage.clickLogoutLink();
		vportloginpage.verifyLoginPage();

	}

	@Test(priority = 8, retryAnalyzer = Retry.class)
	public void VPORT_15_TeacherLoginScenarios() {
		//******* PreCondition to verify the Teacher login scenarios*********

		String schoolAndCode[];
		String trackName;
		String tickeToReadURL;// = "https://tickettoread.com/";[https://www.tickettoread.com/choose/index.jsp]
		if(vportData.vportURL.contains("qa."))
		{
			 tickeToReadURL = "https://qa.tickettoread.com/choose/index.jsp";
		}
		else
		{
			tickeToReadURL = "https://www.tickettoread.com/choose/index.jsp";
		}
		// Create Track
		// Click the Add district button and enter the required details for
		// track creation
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);

		addedittrack = vporttrackfilterPage.clickAddDistrictbutton();
		addedittrack.verfyDistrictPage();
		trackName = addedittrack.fillTrackDetails(vportData.Districtname, vportData.Address, vportData.DistCity,
				vportData.Country, vportData.State, vportData.ZipCode, vportData.userType, vportData.productName,
				vportData.Status,vportData.Year);
		vporttrackfilterPage = addedittrack.clickSaveChanges();

		// Filtering the track by providing details
		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);

		// Create school
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
		// String schoolName = config.getProperty("VPORT_002_SchoolName");
		// To navigate to master page of track
		masterDistrictTracksPage = vporttrackfilterPage.clickOnMasterIcon(trackName);
		// To Verify master page by 'District' tab is loaded
		masterDistrictTracksPage.verifyMasterDistrictTracksPage();
		// To Navigate to School sub tab from District tab
		masterDistrictTracksPage.navigateToSchoolsSubtab();
		// To verify Schools sub tab is loaded
		masterDistrictTracksPage.verifySchoolsSubtab();
		// Creating a school and store the name and Details in App.Properties
		schoolAndCode = masterDistrictTracksPage.CreateSchool(vportData.schoolName, vportData.Code, vportData.Address1,
				vportData.SchoolCity, vportData.zipCode);
		// verifying school is created correctly with the given data
		// (data+random)
		masterDistrictTracksPage.verifySchoolDetails(schoolAndCode[0], schoolAndCode[1], vportData.SchoolCity);

		// Activating School
		vporttrackfilterPage = masterDistrictTracksPage.navigateToFiltersPage();
		// To click on Track name to open track and it returns Contacts page
		districtTrackContactsPage = vporttrackfilterPage.clickonTrackName(trackName);
		// To verify Contacts page is loaded
		districtTrackContactsPage.verifyDistrictTrackContactsPage(trackName);

		// to click on School Tracks tab to navigate to SchoolTracks page and it
		// returns school tracks page object
		districtTrackSchoolTracksPage = districtTrackContactsPage.clickSchoolTrackstab();
		// To verify schoolTracks page is loaded
		districtTrackSchoolTracksPage.verifySchoolTracksTab(trackName);
		// To find a required school to activate from the list of schools
		districtTrackSchoolTracksPage.findSchool(schoolAndCode[0]);
		// Verifies Inherit buttons are disabled before activating school
		districtTrackSchoolTracksPage.verifyInheritRadiobuttonsStatus(schoolAndCode[0], false);
		// To activate the school
		districtTrackSchoolTracksPage.activateSchoolAndSave(schoolAndCode[0]);
		// Verifies Inherit buttons are enabled after activating school
		districtTrackSchoolTracksPage.verifyInheritRadiobuttonsStatus(schoolAndCode[0], true);

		// Create teacher and Add classes to the teacher
		districtAdminHomepage = districtTrackSchoolTracksPage.clickPIIcon(trackName);
		// Selects school from school dropdown
		districtAdminHomepage.selectSchoolFromDropdown(schoolAndCode[0]);
		// Navigate to My school tab after selecting a class from classes
		// dropdown and verifies it
		districtAdminMySchoolPage = districtAdminHomepage.clickOnMySchoolTab();
		districtAdminMySchoolPage.verifyMySchoolPage(schoolAndCode[0]);
		// Navigate to Teachers and classes tab and verifies it
		districtAdminMySchoolPage.navigateToTeachersAndClassesSubtab();
		districtAdminMySchoolPage.verifyTeachersAndClassesSubtab();
		// long strRandom = System.currentTimeMillis();
		// Adds teacher and edit the user name and password
		String lastname = districtAdminMySchoolPage.addTeacher(vportData.teacherLastName, vportData.teacherFirstName,
				vportData.teacherEmail);
		String teacherID = districtAdminMySchoolPage.editTeacherandSave(lastname, vportData.teacherUserId, vportData.teacherPassword);

		// Add classes to school and verifies schools in schools drop down and
		// classes section
		// Also add the class names to properties file
		String classes[] = districtAdminMySchoolPage.addClassesandSave(lastname, vportData.class1, vportData.class2,
				vportData.class3);
		districtAdminMySchoolPage.verifyAddedClasses(lastname, vportData.class1, vportData.class2, vportData.class3);
		districtAdminMySchoolPage.verifyClassesinClassesDropdown(lastname, vportData.class1, vportData.class2,
				vportData.class3);

		//Scenario 1 - TEACHER LOGIN WITHOUT STUDENTS IN THE CLASS & WITHOUT STAFF LICENSES

		getDriver().get(tickeToReadURL);
		teacherLoginScenarios = new TeacherLoginScenarios(getDriver());
		teacherLoginScenarios.loginIntoAppication(teacherID);
		teacherLoginScenarios.verifyLogin(tickeToReadURL);


		//*** Pre condition for second Scenario *****
		//adding staff Licenses to the track
		getDriver().get(vportData.vportURL);
		vportloginpage.verifyLoginPage();	
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
		// To click on Track name to open track and it returns Contacts page
		districtTrackContactsPage = vporttrackfilterPage.clickonTrackName(trackName);
		districtmaterialspage = districtTrackContactsPage.clickMaterialsTab();
		districtmaterialspage.verifyMaterialsPage();
		districtmaterialspage.verifyAvailableLicencesOnMaterialsPage();
		districtmaterialspage.addAndVerifyLicences(vportData.licencegradelevel, vportData.licenceseatcount,
				vportData.reasonforaddinglicence, vportData.addLicenceAlertMessage,
				vportData.reasonForCreatingLicenceImagePath);
		districttracktechnologypage = districtmaterialspage.clickOnTechnologyTab();
		districttracktechnologypage.verifyTechnologyPage();
		districttracktechnologypage.verifyAssessmentPlansAndEnabledRadioButtons();

		//Scenario 2 - Verify teacher login without students in the class 

		getDriver().get(tickeToReadURL);
		teacherLoginScenarios = new TeacherLoginScenarios(getDriver());
		teacherLoginScenarios.loginIntoAppication(teacherID);
		teacherLoginScenarios.verifyLogin(tickeToReadURL);
	}

	/* @Test(priority = 9, retryAnalyzer = Retry.class)
	public void VPORT_17_AssessMentPlanDummyAssessment()
	{
		//		 1.Navigate to vport site
		String vportUser = vportData.vportUsername;
		String trackName = dependentData.getProperty("VPORT_001_TrackName");
		vportloginpage.enterLoginCredentials(vportUser,  vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		vporttrackfilterPage.verifyFilterPage();
		//		 2.Select any product track & navigate to IPT tab - District track - technology section
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		districtTrackContactsPage = vporttrackfilterPage.clickonTrackName(trackName);
		// To verify Contacts page is loaded
		districtTrackContactsPage.verifyDistrictTrackContactsPage(trackName);
		districtTrackContactsPage.clickOnIPTTab();
		districtTrackContactsPage.clickOnTechnologyTab();		
		//		 3.Find that Customer interface section is being displayed
		districtTrackContactsPage.verifyCustomerInterface();
		//		 4.Here we find assessment plans for the product, By default Product will have an assessment plan, if no assessment plans are displayed for the product at grade level we manually add dummy assessment plans
		districtTrackContactsPage.verifyTheAssessmentsplansSelectOptions();
		//		 5.Goto administration tab in IPT tab & goto assessment plans section and add assesment plans manually
		districtTrackContactsPage.clickOnAdministrationLink();
		districtTrackContactsPage.clickOnAssessmentPlansTab();
		districtTrackContactsPage.clickOnAddAssessmentPlanButton();
		String newPlanName = districtTrackContactsPage.enterPlanName(vportData.DummyAssessmentPlanName);
		districtTrackContactsPage.selectGradeLevel(2);//Index value given to select a grade
		districtTrackContactsPage.clickOnActiveCheckBox();
		districtTrackContactsPage.selectEdition(1);//Index value given to select the edition
		districtTrackContactsPage.clickOnAddProfileButton();
		districtTrackContactsPage.enterAssessmentPlanSequence("2");
		districtTrackContactsPage.enterPmCount("4");
		districtTrackContactsPage.enterMinimumScore("15");
		districtTrackContactsPage.enterMaximumScore("20");
		districtTrackContactsPage.clickOnSaveAndContinue();
		districtTrackContactsPage.ClickOnUpdateButton();
		districtTrackContactsPage.verifyTheAddedAssessMentPlan(newPlanName);
		//		 6.Added dummy assessment plans are reflected in technology tab of IPT section"
		vporttrackfilterPage=districtTrackContactsPage.clickOnDistrictTracksTab();
		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		districtTrackContactsPage = vporttrackfilterPage.clickonTrackName(trackName);
		// To verify Contacts page is loaded
		districtTrackContactsPage.verifyDistrictTrackContactsPage(trackName);
		districtTrackContactsPage.clickOnIPTTab();
		districtTrackContactsPage.clickOnTechnologyTab();	
		//Add Dummy Assessment
		districtTrackContactsPage.clickOnAddRow();
		districtTrackContactsPage.selectCreatedAssessmentPlan(newPlanName);
		districtTrackContactsPage.clickOnSaveChangesInTechnologyTab();
		districtTrackContactsPage.verifySavedAssessmentPlan(newPlanName);
		//Log out from application
		vportloginpage=districtTrackContactsPage.clickLogoutLink();
		vportloginpage.verifyLoginPage();
	}*/ 

	@Test(priority = 10, retryAnalyzer = Retry.class)
	public void VPORT_18_VerifyAllTabsInAdministrationPage(){
		//Step1: Login into Vport with Admin credentials
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		//Step2: Verify all the tabs are loading or not in the administration page
		vportAdminnistrationpageallTabs = vporttrackfilterPage.navigateToDistrictTracksPage1();
		vportAdminnistrationpageallTabs.verifyAllTabs();
	}
}
