package com.testsuite.ll.admin;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.data.testdata.VportData.UserRole;
import com.datamanager.ConfigManager;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.vport.AddorEditTrackPage;
import com.page.module.vport.DistrictAdminHomepage;
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.DistrictTrackContactsPage;
import com.page.module.vport.DistrictTrackMaterialsPage;
import com.page.module.vport.DistrictTrackSchoolTracksPage;
import com.page.module.vport.DistrictTrackTechnologyPage;
import com.page.module.vport.MasterDistrictTracksPage;
import com.page.module.vport.TestDependencyFunctions;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportTrackFilterPage;
import com.selenium.Sync;
import com.testng.Retry;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import com.utilities.UtilityMethods;

public class SubDistrictScenarios extends BaseSetup {

	VportLoginPage vportloginpage;
	VportTrackFilterPage vporttrackfilterPage;
	private AddorEditTrackPage addedittrack;
	private DistrictTrackMaterialsPage districtmaterialspage;
	private DistrictAdminMySchoolPage districtAdminMySchoolPage;
	private DistrictTrackTechnologyPage districttracktechnologypage;
	private MasterDistrictTracksPage masterDistrictTracksPage;
	private DistrictTrackContactsPage districtTrackContactsPage;
	DistrictTrackSchoolTracksPage districtTrackSchoolTracksPage;
	DistrictTrackMaterialsPage districtTrackMaterialsPage;
	ImplementationCardsPage implementationCardsPage;
	TestDependencyFunctions testDependencyFunctions;

	LLLogout llLogout;
	LLLoginPage llloginPage;
	LLHomePage llHomePage;
	DistrictAdminHomepage districtAdminHomepage;
	ConfigManager dependentData = new ConfigManager("DependentData");
	VportData vportData;
	LLData lldata;

	@BeforeMethod
	public void baseSetup() {

		/*
		 * vportLoginPage = new VportLoginPage(getDriver()); vportData = new
		 * VportData();
		 * 
		 * getDriver().manage().deleteAllCookies();
		 * getDriver().get(vportData.vportURL); new
		 * Sync(getDriver()).waitForPageToLoad();
		 * vportLoginPage.verifyLoginPage(); ConfigManager dependentData = new
		 * ConfigManager("DependentData");
		 */

		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		lldata = new LLData();
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();

	}

	@Test(groups = { "RC" }, priority = 1, retryAnalyzer = Retry.class)
	public void VPORT_048_subDistrictScenarios() {
		
	

		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);

		String childschoolAndCode[];
		String childdistrictAdminUser;
		String childcampusUser;

		//String parenttrackName;
		String districtAdminUser;// =
									// config.getProperty("VPORT_002_DistrictUserName");
		String campusUser;
		String schoolAndCode[];
		// Click the Add district button and enter the required details for
		// track creation
		addedittrack = vporttrackfilterPage.clickAddDistrictbutton();
		addedittrack.verfyDistrictPage();
		String parenttrackName = addedittrack.fillTrackDetails(vportData.Districtname, 
				vportData.Address, 
				vportData.DistCity,
				vportData.Country, 
				vportData.State, 
				vportData.ZipCode,
				vportData.userType, 
				lldata.productName,
				vportData.Status,
				vportData.Year);
		vporttrackfilterPage = addedittrack.clickSaveChanges();

		// Filtering the track by providing details
		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(lldata.productName, vportData.userType, vportData.alpha, parenttrackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(parenttrackName);
		// Storing the Created data to use test case
		dependentData.writeProperty("VPORT_048_ParentTrackName", parenttrackName);

		// String schoolName = config.getProperty("VPORT_002_SchoolName");
		// To navigate to master page of track
		masterDistrictTracksPage = vporttrackfilterPage.clickOnMasterIcon(parenttrackName);
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
		// To navigate to users Tab
		masterDistrictTracksPage.navigateToUsersSubtab();
		// To verify users sub tab is loaded
		masterDistrictTracksPage.verifyUsersSubtab();
		// To Click on "Add User' button under District sub tab
		masterDistrictTracksPage.clickAddUser();
		// To verify Add District User page is loaded
		masterDistrictTracksPage.verifyAddDistrictUserPage();
		// To Create District user, and save the district user name in Config
		// file
		districtAdminUser = masterDistrictTracksPage.addDistrictUser(vportData.distUserLogin,
				vportData.distUserFirstName, vportData.distUserLastName, vportData.distUserPassword);
				// Assigning District user to the variable in Base Class
				// districtLogin=districtAdminUser;

		// To verify District user is created correctly with the given data,
		// District user name with randomnumber appended
		masterDistrictTracksPage.verifyDistrictUserDetails(districtAdminUser, vportData.distUserFirstName,
				vportData.distUserLastName, vportData.distUserPassword);
		// To navigate to users sub tab under Users tab
		masterDistrictTracksPage.navigateToSchoolUserTypeSubtab();
		// To verify users sub tab under Users tab is loaded
		masterDistrictTracksPage.verifySchoolUsersPage();
		// To click on Add New staff button
		masterDistrictTracksPage.clickAddNewStaff();
		// To verify Add New Staff dialog is loaded
		masterDistrictTracksPage.verifyAddNewStaffDialog();
		// To Create School user with teacher role
		String campUserLastname = vportData.schoolUserLastName + UtilityMethods.get4DRandomNumber();
		masterDistrictTracksPage.createSchoolUserWithCampusUserRole(vportData.schoolUserFirstName, campUserLastname,
				vportData.schoolUserEmail, schoolAndCode[0], UserRole.CAMPUS_USER);

		// masterDistrictTracksPage.clickShowTeachers();
		// To edit the school user with new login and password

		campusUser = masterDistrictTracksPage.EditSchoolUser(schoolAndCode[0], campUserLastname,
				vportData.schoolUserPassword);
		// masterDistrictTracksPage.clickShowTeachers();
		// To verify school user after modifying
		masterDistrictTracksPage.verifyScholUserDetails(vportData.schoolUserFirstName, campUserLastname,
				schoolAndCode[0], campusUser, vportData.schoolUserPassword, UserRole.CAMPUS_USER);
		// Writing Newly created data to App.Properties
		dependentData.writeProperty("VPORT_048_ParentDistrictUserName", districtAdminUser);
		dependentData.writeProperty("VPORT_048_ParentSchoolUser", campusUser);
		dependentData.writeProperty("VPORT_048_ParentSchoolName", schoolAndCode[0]);
		dependentData.writeProperty("VPORT_048_ParentSchoolCode", schoolAndCode[1]);

		vporttrackfilterPage = masterDistrictTracksPage.navigateToFiltersPage();
		districtTrackContactsPage = vporttrackfilterPage.clickonTrackName(parenttrackName);
		
	
		districtTrackMaterialsPage = districtTrackContactsPage.clickMaterialsTab();

		districtTrackMaterialsPage.addAndVerifyLicences(vportData.licencegradelevel, vportData.licenceseatcount,
				vportData.reasonforaddinglicence, vportData.addLicenceAlertMessage,
				vportData.reasonForCreatingLicenceImagePath);

		districtTrackSchoolTracksPage = districtTrackContactsPage.clickSchoolTrackstab();
		districtTrackSchoolTracksPage.activateSchoolAndSave(schoolAndCode[0]);
		districtAdminHomepage = districtTrackSchoolTracksPage.clickPIIcon(parenttrackName);

		
		// Selects school from school dropdown
		districtAdminHomepage.selectSchoolFromDropdown(vportData.districtAdminSchoolName);
		// Navigate to My school tab after selecting a class from classes
		// dropdown and verifies it
		districtAdminMySchoolPage = districtAdminHomepage.clickOnMySchoolTab();
		
		// Navigate to Teachers and classes tab and verifies it
		districtAdminMySchoolPage.navigateToTeachersAndClassesSubtab();
		districtAdminMySchoolPage.verifyTeachersAndClassesSubtab();
		// long strRandom = System.currentTimeMillis();
		// Adds teacher and edit the user name and password
		String lastname = districtAdminMySchoolPage.addTeacher(vportData.teacherLastName, vportData.teacherFirstName,
				vportData.teacherEmail);
		String teacherUserID = districtAdminMySchoolPage.editTeacherandSave(lastname, vportData.teacherUserId,
				vportData.teacherPassword);
		// Add classes to school and verifies schools in schools drop down and
		// classes section
		// Also add the class names to properties file
		districtAdminMySchoolPage.addClassesandSaveofLL(teacherUserID);

		districtAdminMySchoolPage.assignLicenseToTeacher();
		

		vporttrackfilterPage = districtAdminMySchoolPage.navigateToFiltersPage();
		masterDistrictTracksPage = vporttrackfilterPage.clickOnMasterIcon(parenttrackName);
		masterDistrictTracksPage.clickOnParentCheckBox();
		vporttrackfilterPage = masterDistrictTracksPage.clickUpdateBtn();
		vporttrackfilterPage.trackFilters(lldata.productName, vportData.userType, vportData.alpha, parenttrackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(parenttrackName);
		/*// To click on Track name to open track and it returns Contacts page
		districtTrackContactsPage = vporttrackfilterPage.clickonTrackName(parenttrackName);
		districtmaterialspage = districtTrackContactsPage.clickMaterialsTab();
		districtmaterialspage.verifyMaterialsPage();
		districtmaterialspage.verifyAvailableLicencesOnMaterialsPage();
		districtmaterialspage.addAndVerifyLicences(vportData.licencegradelevel, vportData.licenceseatcount,
				vportData.reasonforaddinglicence, vportData.addLicenceAlertMessage,
				vportData.reasonForCreatingLicenceImagePath);
		vporttrackfilterPage = districtmaterialspage.navigateToFiltersPage();*/

		
	//	 ############################################################### 

		// Creation of sub - district
		addedittrack = vporttrackfilterPage.clickAddDistrictbutton();
		addedittrack.enterDetailsForSubdistrictTrack(vportData.Districtname, vportData.Address, vportData.DistCity,
				vportData.Country, vportData.State, vportData.ZipCode, vportData.userType, parenttrackName);

		vporttrackfilterPage = addedittrack.clickSaveChanges();

		vporttrackfilterPage.trackFilters(lldata.productName, vportData.userType, vportData.alpha, parenttrackName);
		vporttrackfilterPage.clickUpdateButton();

		masterDistrictTracksPage = vporttrackfilterPage.clickOnMasterIcon(parenttrackName);
		masterDistrictTracksPage.verifySubDistrict();
		masterDistrictTracksPage.navigatetoSubDistrictPage();

		masterDistrictTracksPage.navigateToSchoolsSubtab();
		// To verify Schools sub tab is loaded
		masterDistrictTracksPage.verifySchoolsSubtab();
		// Creating a school and store the name and Details in App.Properties
		childschoolAndCode = masterDistrictTracksPage.CreateSchool(vportData.schoolName, vportData.Code,
				vportData.Address1, vportData.SchoolCity, vportData.zipCode);
		// verifying school is created correctly with the given data
		// (data+random)
		masterDistrictTracksPage.verifySchoolDetails(childschoolAndCode[0], childschoolAndCode[1],
				vportData.SchoolCity);
		// To navigate to users Tab
		masterDistrictTracksPage.navigateToUsersSubtab();
		// To verify users sub tab is loaded
		masterDistrictTracksPage.verifyUsersSubtab();
		// To Click on "Add User' button under District sub tab
		masterDistrictTracksPage.clickAddUser();
		// To verify Add District User page is loaded
		masterDistrictTracksPage.verifyAddDistrictUserPage();
		// To Create District user, and save the district user name in Config
		// file
		childdistrictAdminUser = masterDistrictTracksPage.addDistrictUser(vportData.distUserLogin,
				vportData.distUserFirstName, vportData.distUserLastName, vportData.distUserPassword);
				// Assigning District user to the variable in Base Class
				// districtLogin=districtAdminUser;

		// To verify District user is created correctly with the given data,
		// District user name with randomnumber appended
		masterDistrictTracksPage.verifyDistrictUserDetails(childdistrictAdminUser, vportData.distUserFirstName,
				vportData.distUserLastName, vportData.distUserPassword);
		// To navigate to users sub tab under Users tab
		masterDistrictTracksPage.navigateToSchoolUserTypeSubtab();
		// To verify users sub tab under Users tab is loaded
		masterDistrictTracksPage.verifySchoolUsersPage();
		// To click on Add New staff button
		masterDistrictTracksPage.clickAddNewStaff();
		// To verify Add New Staff dialog is loaded
		masterDistrictTracksPage.verifyAddNewStaffDialog();
		// To Create School user with teacher role
		String childcampUserLastname = vportData.schoolUserLastName + UtilityMethods.get4DRandomNumber();
		masterDistrictTracksPage.createSchoolUserWithCampusUserRole(vportData.schoolUserFirstName,
				childcampUserLastname, vportData.schoolUserEmail, childschoolAndCode[0], UserRole.CAMPUS_USER);

		// masterDistrictTracksPage.clickShowTeachers();
		// To edit the school user with new login and password

		childcampusUser = masterDistrictTracksPage.EditSchoolUser(schoolAndCode[0], childcampUserLastname,
				vportData.schoolUserPassword);
		// masterDistrictTracksPage.clickShowTeachers();
		// To verify school user after modifying
		masterDistrictTracksPage.verifyScholUserDetails(vportData.schoolUserFirstName, childcampUserLastname,
				schoolAndCode[0], childcampusUser, vportData.schoolUserPassword, UserRole.CAMPUS_USER);
		// Writing Newly created data to App.Properties
		dependentData.writeProperty("VPORT_048_ChildDistrictUserName", childdistrictAdminUser);
		dependentData.writeProperty("VPORT_048_ChildSchoolUser", childcampusUser);

		vporttrackfilterPage = masterDistrictTracksPage.navigateToFiltersPage();
		
		/*// To click on Track name to open track and it returns Contacts page
		districtTrackContactsPage = vporttrackfilterPage.clickonTrackName(parenttrackName);
		districtmaterialspage = districtTrackContactsPage.clickMaterialsTab();
		districtmaterialspage.verifyMaterialsPage();
		districtmaterialspage.verifyAvailableLicencesOnMaterialsPage();
		districtmaterialspage.addAndVerifyLicences(vportData.licencegradelevel, vportData.licenceseatcount,
				vportData.reasonforaddinglicence, vportData.addLicenceAlertMessage,
				vportData.reasonForCreatingLicenceImagePath);
		*/
		
		getDriver().get(lldata.URL);
		llloginPage = new LLLoginPage(getDriver());
		implementationCardsPage=(ImplementationCardsPage) llloginPage.loginCredentials(lldata.URL,districtAdminUser, vportData.distUserPassword,LLLoginReturnPage.IMPLEMENTATIONCARDS_PAGE);
		// Move to Welcome Frame
		implementationCardsPage.moveToWelcomeFrame();
		// Verifies Welcome page after first login of district User
		implementationCardsPage.verifyWelcomePage();
	
		getDriver().get(lldata.URL);
		llloginPage = new LLLoginPage(getDriver());
		implementationCardsPage=(ImplementationCardsPage) llloginPage.loginCredentials(lldata.URL,childdistrictAdminUser, vportData.distUserPassword,LLLoginReturnPage.IMPLEMENTATIONCARDS_PAGE);
		// Move to Welcome Frame
		implementationCardsPage.verifySubDistrictUserLogin();
		

	}

}
