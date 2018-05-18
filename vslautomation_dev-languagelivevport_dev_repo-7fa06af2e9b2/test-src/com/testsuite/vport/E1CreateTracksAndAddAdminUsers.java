package com.testsuite.vport;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.VportData;
import com.data.testdata.VportData.UserRole;
import com.datamanager.ConfigManager;
import com.page.module.vport.AddorEditTrackPage;
import com.page.module.vport.DistrictTrackContactsPage;
import com.page.module.vport.DistrictTrackMaterialsPage;
import com.page.module.vport.DistrictTrackSchoolTracksPage;
import com.page.module.vport.DistrictTrackTechnologyPage;
import com.page.module.vport.MasterDistrictTracksPage;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportLogoutPage;
import com.page.module.vport.VportTrackFilterPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.Sync;
import com.testng.Retry;
import com.utilities.UtilityMethods;

//Each TestSuite class must do the following
//1. It should extends the "BaseClass", so that @BeforeClass - BrowserInitialization, 
//	 launch, URL Navigation and @AfterClass - Browser Quit happens automatically
//2. It should create instances for respective PageParts classes along with LoadProperties class
//3. Create @BeforeMethod setup to initalize instances with getDriver(taken from Baseclass)

public class E1CreateTracksAndAddAdminUsers extends BaseSetup {
	// Declaration of respective PageParts instances along with configmanager
	// instance
	private VportLoginPage vportloginpage;
	private VportData vportData;
	private AddorEditTrackPage addedittrack;
	private VportTrackFilterPage vporttrackfilterPage;
//	private String districtAdminUser;
//	private String campusUser;
//	private String schoolName;
	private DistrictTrackMaterialsPage districtmaterialspage;
	private DistrictTrackTechnologyPage districttracktechnologypage;
	private MasterDistrictTracksPage masterDistrictTracksPage;
	private DistrictTrackContactsPage districtTrackContactsPage;
	ConfigManager dependentData = new ConfigManager("DependentData");

	private DistrictTrackSchoolTracksPage districtTrackSchoolTracksPage;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
	}

	@Test(groups = {"QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void VPORT_001_CreateNewTrack() {
		String trackName;
		// Click the Add district button and enter the required details for
		// track creation
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
		//Storing the Created data to use test case
		dependentData.writeProperty("VPORT_001_TrackName", trackName);
	}

	/**
	 * This Test Creates School , District User and School user with teacher
	 * role in track
	 **/
	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class)
	public void VPORT_002_addSchoolAndUserstotheTrack() {
		String trackName = dependentData.getProperty("VPORT_001_TrackName");
		String districtAdminUser;// = config.getProperty("VPORT_002_DistrictUserName");
		String campusUser;
		String schoolAndCode[];// = config.getProperty("VPORT_002_SchoolUser");
		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
		//String schoolName = config.getProperty("VPORT_002_SchoolName");
		// To navigate to master page of track
		masterDistrictTracksPage = vporttrackfilterPage.clickOnMasterIcon(trackName);
		// To Verify master page by 'District' tab is loaded
		masterDistrictTracksPage.verifyMasterDistrictTracksPage();
		// To Navigate to School sub tab from District tab
		masterDistrictTracksPage.navigateToSchoolsSubtab();
		// To verify Schools sub tab is loaded
		masterDistrictTracksPage.verifySchoolsSubtab();
		// Creating a school and store the name and Details in App.Properties
		schoolAndCode = masterDistrictTracksPage.CreateSchool(vportData.schoolName , vportData.Code,
				vportData.Address1, vportData.SchoolCity, vportData.zipCode);
		// verifying school is created correctly with the given data (data+random)
		masterDistrictTracksPage.verifySchoolDetails(schoolAndCode[0],
				schoolAndCode[1],
				vportData.SchoolCity);	
		// To navigate to users Tab
		masterDistrictTracksPage.navigateToUsersSubtab();
		// To verify users sub tab is loaded
		masterDistrictTracksPage.verifyUsersSubtab();
		// To Click on "Add User' button under District sub tab
		masterDistrictTracksPage.clickAddUser();
		// To verify Add District User page is loaded
		masterDistrictTracksPage.verifyAddDistrictUserPage();
		// To Create District user, and save the district user name in Config file
		districtAdminUser = masterDistrictTracksPage.addDistrictUser(vportData.distUserLogin,
				vportData.distUserFirstName, vportData.distUserLastName, vportData.distUserPassword);
		//Assigning District user to the variable in Base Class
		//districtLogin=districtAdminUser;
		
		// To verify District user is created correctly with the given data, District user name with randomnumber appended
		masterDistrictTracksPage.verifyDistrictUserDetails(districtAdminUser,
				vportData.distUserFirstName, vportData.distUserLastName, vportData.distUserPassword);
		// To navigate to users sub tab under Users tab
		masterDistrictTracksPage.navigateToSchoolUserTypeSubtab();
		// To verify users sub tab under Users tab is loaded
		masterDistrictTracksPage.verifySchoolUsersPage();
		// To click on Add New staff button
		masterDistrictTracksPage.clickAddNewStaff();
		// To verify Add New Staff dialog is loaded
		masterDistrictTracksPage.verifyAddNewStaffDialog();
		// To Create School user with teacher role
		String campUserLastname = vportData.schoolUserLastName+UtilityMethods.get4DRandomNumber();
		masterDistrictTracksPage.createSchoolUserWithCampusUserRole(vportData.schoolUserFirstName,campUserLastname, vportData.schoolUserEmail, schoolAndCode[0],
				UserRole.CAMPUS_USER);

	//	masterDistrictTracksPage.clickShowTeachers();
		// To edit the school user with new login and password

		 campusUser= masterDistrictTracksPage.EditSchoolUser(schoolAndCode[0], campUserLastname,
				vportData.schoolUserPassword);
		//masterDistrictTracksPage.clickShowTeachers();
		// To verify school user after modifying
		masterDistrictTracksPage.verifyScholUserDetails(vportData.schoolUserFirstName, campUserLastname,
				schoolAndCode[0],campusUser, vportData.schoolUserPassword,
				UserRole.CAMPUS_USER);
		//Writing Newly created data to App.Properties
		dependentData.writeProperty("VPORT_002_DistrictUserName",districtAdminUser);
		dependentData.writeProperty("VPORT_002_SchoolUser",campusUser);
		dependentData.writeProperty("VPORT_002_SchoolName", schoolAndCode[0]);
		dependentData.writeProperty("VPORT_002_SchoolCode", schoolAndCode[1]);
	}

	/**
	 * This Test activates the newly created School
	 **/

	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class)
	public void VPORT_003_activatingSchool() {

		String trackName = dependentData.getProperty("VPORT_001_TrackName");
		String schoolName = dependentData.getProperty("VPORT_002_SchoolName");
		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
		/*masterDistrictTracksPage = vporttrackfilterPage.clickOnMasterIcon(trackName);
		// To click on District/Tracks main heading to navigate to Filter page
		// and it returns Filter page
		vporttrackfilterPage = masterDistrictTracksPage.clickDistrictTracksMainHeading();
*/
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
		districtTrackSchoolTracksPage.findSchool(schoolName);
		// Verifies Inherit buttons are disabled before activating school
		districtTrackSchoolTracksPage.verifyInheritRadiobuttonsStatus(schoolName, false);
		// To activate the school
		districtTrackSchoolTracksPage.activateSchoolAndSave(schoolName);
		// Verifies Inherit buttons are enabled after activating school
		districtTrackSchoolTracksPage.verifyInheritRadiobuttonsStatus(schoolName, true);
		dependentData.writeProperty("NEWTRACKURL", getDriver().getCurrentUrl());

	}

	@Test(groups = { "RC", "QC" }, priority = 4)
	public void VPORT_004_AddLicenceTypesAndVerifyAssessmentPlans()  {
		String trackName = dependentData.getProperty("VPORT_001_TrackName");
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
	}


}
