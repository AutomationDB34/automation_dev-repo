package com.testsuite.basedata;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;

import com.data.testdata.VportData;
import com.data.testdata.VportData.UserRole;
import com.datamanager.ConfigManager;
import com.page.module.vport.AddorEditTrackPage;
import com.page.module.vport.DistrictAdminHomepage;
import com.page.module.vport.DistrictAdminMyClassPage;
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.DistrictAdminOrientationPage;
import com.page.module.vport.DistrictAdminPrivacyPage;
import com.page.module.vport.DistrictAdminWelcomePage;
import com.page.module.vport.DistrictTrackContactsPage;
import com.page.module.vport.DistrictTrackMaterialsPage;
import com.page.module.vport.DistrictTrackSchoolTracksPage;
import com.page.module.vport.DistrictTrackTechnologyPage;
import com.page.module.vport.MasterDistrictTracksPage;
import com.page.module.vport.MyDistrictPage;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportTrackFilterPage;
import com.selenium.SafeActions;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class BaseDataFunctionalities extends SafeActions
{
	
	private VportData vportData;
	private AddorEditTrackPage addedittrack;
	private VportTrackFilterPage vporttrackfilterPage;
	private MasterDistrictTracksPage masterDistrictTracksPage;
	private DistrictTrackMaterialsPage districtmaterialspage;
	private DistrictTrackTechnologyPage districttracktechnologypage;
	private DistrictTrackContactsPage districtTrackContactsPage;
	private DistrictTrackSchoolTracksPage districtTrackSchoolTracksPage;
	private DistrictAdminMySchoolPage districtAdminMySchoolPage;
	private DistrictAdminHomepage districtAdminHomepage;
	private DistrictAdminMyClassPage districtAdminMyClassPage;
	private DistrictAdminOrientationPage districtAdminOrientationPage;
	private DistrictAdminPrivacyPage districtAdminPrivacyPage;
	private DistrictAdminWelcomePage districtAdminWelcomePage;
	private MyDistrictPage myDistrictPage;
	Logger log = Logger.getLogger(getClass());
	
	ConfigManager dependentData = new ConfigManager("DependentData");

	public BaseDataFunctionalities(WebDriver driver) 
	{
		super(driver);
	}
	
	public String CreateNewTrack(String trackName,String buildNumber,VportData vportData,VportTrackFilterPage vporttrackfilterPage) 
	{
		this.vportData=vportData;
		this.vporttrackfilterPage=vporttrackfilterPage;
		
		String track;
		String districtnameWithBuildNumber=this.vportData.Districtname+"_"+buildNumber+"_";
		// Click the Add district button and enter the required details for
		// track creation
		addedittrack = vporttrackfilterPage.clickAddDistrictbutton();
		addedittrack.verfyDistrictPage();
		track = addedittrack.fillTrackDetails(districtnameWithBuildNumber, this.vportData.Address, this.vportData.DistCity,
				this.vportData.Country, this.vportData.State, this.vportData.ZipCode, this.vportData.userType, this.vportData.productName,
				this.vportData.Status,this.vportData.Year);
		this.vporttrackfilterPage = addedittrack.clickSaveChanges();

		// Filtering the track by providing details
		this.vporttrackfilterPage.verifyFilterPage();
		this.vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, track);
		this.vporttrackfilterPage.clickUpdateButton();
		this.vporttrackfilterPage.verifyTrackCreation(track);
		
		//Storing the Created data to use test case
		//dependentData.writeProperty("VPORTBuild_TrackName", track);
		return track;
	}
	
	public String[] AddSchoolAndUserstotheTrack(VportTrackFilterPage vporttrackfilterPageSchool,VportData vportDataSchool)
	{
		String[] schoolUserDetails = new String[4];
		
		try
		{
					
			if(vporttrackfilterPageSchool!=null&&vportDataSchool!=null)
			{
		this.vporttrackfilterPage=vporttrackfilterPageSchool;
		this.vportData=vportDataSchool;
		String trackName = dependentData.getProperty("VPORTBuild_TrackName");
		String districtAdminUser;// = config.getProperty("VPORT_002_DistrictUserName");
		String campusUser;
		String schoolAndCode[];// = config.getProperty("VPORT_002_SchoolUser");
		this.vporttrackfilterPage.verifyFilterPage();
		this.vporttrackfilterPage.trackFilters(this.vportData.productName, this.vportData.userType, this.vportData.alpha, trackName);
		this.vporttrackfilterPage.clickUpdateButton();
		this.vporttrackfilterPage.verifyTrackCreation(trackName);
		//String schoolName = config.getProperty("VPORT_002_SchoolName");
		// To navigate to master page of track
		masterDistrictTracksPage = this.vporttrackfilterPage.clickOnMasterIcon(trackName);
		// To Verify master page by 'District' tab is loaded
		masterDistrictTracksPage.verifyMasterDistrictTracksPage();
		// To Navigate to School sub tab from District tab
		masterDistrictTracksPage.navigateToSchoolsSubtab();
		// To verify Schools sub tab is loaded
		masterDistrictTracksPage.verifySchoolsSubtab();
		// Creating a school and store the name and Details in App.Properties
		schoolAndCode = masterDistrictTracksPage.CreateSchool(this.vportData.schoolName , this.vportData.Code,this.vportData.Address1, this.vportData.SchoolCity, this.vportData.zipCode);
		// verifying school is created correctly with the given data (data+random)
		masterDistrictTracksPage.verifySchoolDetails(schoolAndCode[0],schoolAndCode[1],this.vportData.SchoolCity);	
		// To navigate to users Tab
		masterDistrictTracksPage.navigateToUsersSubtab();
		// To verify users sub tab is loaded
		masterDistrictTracksPage.verifyUsersSubtab();
		// To Click on "Add User' button under District sub tab
		masterDistrictTracksPage.clickAddUser();
		// To verify Add District User page is loaded
		masterDistrictTracksPage.verifyAddDistrictUserPage();
		// To Create District user, and save the district user name in Config file
		districtAdminUser = masterDistrictTracksPage.addDistrictUser(this.vportData.distUserLogin,
				this.vportData.distUserFirstName, this.vportData.distUserLastName, this.vportData.distUserPassword);
		//Assigning District user to the variable in Base Class
		//districtLogin=districtAdminUser;
		
		// To verify District user is created correctly with the given data, District user name with randomnumber appended
		masterDistrictTracksPage.verifyDistrictUserDetails(districtAdminUser,
				this.vportData.distUserFirstName, this.vportData.distUserLastName, this.vportData.distUserPassword);
		// To navigate to users sub tab under Users tab
		masterDistrictTracksPage.navigateToSchoolUserTypeSubtab();
		// To verify users sub tab under Users tab is loaded
		masterDistrictTracksPage.verifySchoolUsersPage();
		// To click on Add New staff button
		masterDistrictTracksPage.clickAddNewStaff();
		// To verify Add New Staff dialog is loaded
		masterDistrictTracksPage.verifyAddNewStaffDialog();
		// To Create School user with teacher role
		String campUserLastname = this.vportData.schoolUserLastName+UtilityMethods.get4DRandomNumber();
		masterDistrictTracksPage.createSchoolUserWithCampusUserRole(this.vportData.schoolUserFirstName,campUserLastname, this.vportData.schoolUserEmail, schoolAndCode[0],
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
		
		schoolUserDetails[0]=districtAdminUser;
		schoolUserDetails[1]=campusUser;
		schoolUserDetails[2]=schoolAndCode[0];
		schoolUserDetails[3]=schoolAndCode[1];
		
		//return schoolUserDetails;
			}
		}
		catch(NullPointerException e)
		{
			log.info("Received parameters in the methods have null objects"+e.getMessage());
			Assert.fail("vporttrackfilterPageSchool or vportDataSchool objects has null values"+e.getMessage());
			return ArrayUtils.EMPTY_STRING_ARRAY;
		}
		catch(Exception e)
		{
			log.info("Received parameterns in the methods have null objects"+e.getMessage()+e.getStackTrace());
			Assert.fail("unable to create school using AddSchoolAndUserstotheTrack method"+e.getMessage());
			return ArrayUtils.EMPTY_STRING_ARRAY;
			
		}
//		dependentData.writeProperty("VPORT_Build_DistrictUserName",districtAdminUser);
//		dependentData.writeProperty("VPORT_Build_SchoolUser",campusUser);
//		dependentData.writeProperty("VPORT_Build_SchoolName", schoolAndCode[0]);
//		dependentData.writeProperty("VPORT_Build_SchoolCode", schoolAndCode[1]);
		return schoolUserDetails;

	}

	public void ActivatingSchool(VportTrackFilterPage vporttrackpagefilter,VportData vportDataActivateSchool) 
	{
		this.vporttrackfilterPage=vporttrackpagefilter;
		this.vportData=vportDataActivateSchool;

		String trackName = dependentData.getProperty("VPORTBuild_TrackName");
		String schoolName = dependentData.getProperty("VPORT_Build_SchoolName");
		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(this.vportData.productName, this.vportData.userType, this.vportData.alpha, trackName);
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

	}
	
	public void AddLicenceTypesAndVerifyAssessmentPlans(VportTrackFilterPage vporttrackpagefilterlicence,VportData vportDataAddLicence) 
	{
		this.vporttrackfilterPage=vporttrackpagefilterlicence;
		this.vportData=vportDataAddLicence;
		String trackName = dependentData.getProperty("VPORTBuild_TrackName");
		vporttrackfilterPage.trackFilters(this.vportData.productName, this.vportData.userType, this.vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
		// To click on Track name to open track and it returns Contacts page
		districtTrackContactsPage = vporttrackfilterPage.clickonTrackName(trackName);
		districtmaterialspage = districtTrackContactsPage.clickMaterialsTab();
		districtmaterialspage.verifyMaterialsPage();
		districtmaterialspage.verifyAvailableLicencesOnMaterialsPage();
		districtmaterialspage.addAndVerifyLicences(this.vportData.licencegradelevel, this.vportData.licenceseatcount,
				this.vportData.reasonforaddinglicence, this.vportData.addLicenceAlertMessage,
				this.vportData.reasonForCreatingLicenceImagePath);
		districttracktechnologypage = districtmaterialspage.clickOnTechnologyTab();
		districttracktechnologypage.verifyTechnologyPage();
		districttracktechnologypage.verifyAssessmentPlansAndEnabledRadioButtons();
	}
	
	public void DistrictAdminLogin(DistrictAdminPrivacyPage districtAdminPagePrivacy,VportData vportDataDistrictAdmin)
	{
		this.districtAdminPrivacyPage=districtAdminPagePrivacy;
		this.vportData=vportDataDistrictAdmin;
		
		//District admin user privacy agreement page
		districtAdminPrivacyPage.verifyPrivacyPage();
		districtAdminPrivacyPage.acceptPrivacy(this.vportData.districtAdminName , this.vportData.districtAdminTitle);
		districtAdminWelcomePage = districtAdminPrivacyPage.clickAcceptBtn();
		
		//District admin user profile information
		districtAdminWelcomePage.verifAdminWelcomePage();
		districtAdminOrientationPage = districtAdminWelcomePage.profileInformation(this.vportData.districtAdminEMail , this.vportData.districtAdmintraining);
		
		//Verifying the Orientation pages for Disrtict admin user for the first login and check school sctivation
		districtAdminOrientationPage.verifyOrientationPage();
		myDistrictPage = districtAdminOrientationPage.orientatonpages();
		myDistrictPage.verifyMyDistrictPage();
		myDistrictPage.activateSchool();
		
	}
	
	public String[] AddTeachersandClassestoSchool(DistrictAdminHomepage districtAdminHomeforTeacher,VportData vportDataTeacherandClasses)
	{
		this.districtAdminHomepage=districtAdminHomeforTeacher;
		this.vportData=vportDataTeacherandClasses;
		String trackName = dependentData.getProperty("VPORTBuild_TrackName");
		String schoolName = dependentData.getProperty("VPORT_Build_SchoolName");
				// verify admin Home page
		districtAdminHomepage.verifyHomePage(trackName, this.vportData.productName);
		// Selects school from school dropdown
		districtAdminHomepage.selectSchoolFromDropdown(this.vportData.districtAdminSchoolName);
		// Navigate to My school tab after selecting a class from classes dropdown and verifies it
		districtAdminMySchoolPage = districtAdminHomepage.clickOnMySchoolTab();
		districtAdminMySchoolPage.verifyMySchoolPage(schoolName);
		// Navigate to Teachers and classes tab and verifies it
		districtAdminMySchoolPage.navigateToTeachersAndClassesSubtab();
		districtAdminMySchoolPage.verifyTeachersAndClassesSubtab();
		//long strRandom = System.currentTimeMillis();
		// Adds teacher and edit the user name and password
		String lastname = districtAdminMySchoolPage.addTeacher(this.vportData.teacherLastName , this.vportData.teacherFirstName,this.vportData.teacherEmail);
		districtAdminMySchoolPage.editTeacherandSave(lastname ,this.vportData.teacherUserId , this.vportData.teacherPassword);
		//Add classes to school and verifies schools in schools drop down and classes section
		//Also add the class names to properties file
		String classes[] = districtAdminMySchoolPage.addClassesandSave(lastname,this.vportData.class1,this.vportData.class2, this.vportData.class3);
		districtAdminMySchoolPage.verifyAddedClasses(lastname,this.vportData.class1,this.vportData.class2 , this.vportData.class3);
		districtAdminMySchoolPage.verifyClassesinClassesDropdown(lastname,this.vportData.class1,this.vportData.class2, this.vportData.class3);
//		dependentData.writeProperty("VPORT_006_CLASS1", classes[0]);
//		dependentData.writeProperty("VPORT_006_CLASS2", classes[1]);
		
		return classes;

	}
	
	public String AddStudentsToTheTeacherClasses(DistrictAdminHomepage districtAdminHomeforStudents,VportData vportDataStudentsToTeachers) 
	{	
		this.districtAdminHomepage=districtAdminHomeforStudents;
		this.vportData=vportDataStudentsToTeachers;
		String trackName = dependentData.getProperty("VPORTBuild_TrackName");
		String classNames[] = {dependentData.getProperty("VPORT_BUILD_CLASS1"),dependentData.getProperty("VPORT_BUILD_CLASS2")};
		// verify admin Home page
		districtAdminHomepage.verifyHomePage(trackName, this.vportData.productName);
		// Selects school from school dropdown
		districtAdminHomepage.selectSchoolFromDropdown(this.vportData.districtAdminSchoolName);
		// Navigate to My school tab after selecting a class from classes dropdown and verifies it
		districtAdminMySchoolPage = districtAdminHomepage.clickOnMySchoolTab();
		districtAdminMyClassPage=districtAdminMySchoolPage.selectClassFromClassDropDown(classNames[0]);
		//districtAdminMyClassPage=districtAdminHomepage.clickOnMyClass();
		districtAdminMyClassPage.clickOnRoster();
		//Verifies navigation to My Class tab->Reroster page for the selected class1
		districtAdminMyClassPage.verifyNavigationToMyClassTabRoster(classNames[0]);
		//Clicks add students button on the roster page of class1
		districtAdminMyClassPage.clickAddStudentsButtonOnMYClassRostersMainPage();
		//Verifies navigation to adding roster students to class1 page
		districtAdminMyClassPage.verifyNavigationToCreateStudentsPage();
		//Clicks 'Add' button under 'Create New Students' section of class1 roster page
		districtAdminMyClassPage.clickAddButtonOnCreateNewStudentsToRosterPage();
		//Verifies navigation to 'Add New Students' popup of class1
		districtAdminMyClassPage.verifyNavigationToAddNewStudentsPopUp();
		//Fills student user details on 'Add New Students' popup and returns student id number of the created student user
		String createdStudentID=districtAdminMyClassPage.fillNewStudentDetailsOnAddNewStudentsPopUp(this.vportData.studentLastName,this.vportData.studentFirstName,this.vportData.studentID,this.vportData.studentGradeLevel,this.vportData.studentDOB);
		//Clicks 'Save Changes' button on 'Add New Students' popup of class1
		districtAdminMyClassPage.clickSaveChangesButtonOnAddNewStudentsPopUp();
		//Verifies that 'Add New students'popup disappears after clicking save changes button
		districtAdminMyClassPage.verifyAddNewStudentsPopUpDisappeared();
		//Clicks 'Return to Class Roster' button to return to roster main page of class1
		districtAdminMyClassPage.clickReturnToClassRosterButton();
		//Verifies navigation back to roster main page of class1
		districtAdminMyClassPage.verifyNavigationToMyClassTabRoster(classNames[0]);
		//Verifies added student using student id number under enrolled students list of class 1
		districtAdminMyClassPage.verifyAddedStudentInTheClass(createdStudentID);
		//Now selects class2 from top right class Dropdown list
		districtAdminMyClassPage=districtAdminMySchoolPage.selectClassFromClassDropDown(classNames[1]);
		//Verifies navigation to My Class tab->Reroster page for the selected class2
		districtAdminMyClassPage.verifyNavigationToMyClassTabRoster(classNames[1]);
		//Clicks add students button on the roster page of class2
		districtAdminMyClassPage.clickAddStudentsButtonOnMYClassRostersMainPage();
		//Searches for the student record using the student number captured above under 'Available Students' section
		districtAdminMyClassPage.searchForAnExistingStudentRecordByID(createdStudentID);
		//Clicks 'Add Student' arrow button for the searched student
		districtAdminMyClassPage.clickAddStudentArrowButton(createdStudentID);
		//Verifies the added student under the target class section being displayed at right hand side
		districtAdminMyClassPage.verifyAddedStudentUnderTargetClassSection(createdStudentID);
		//Clicks 'Save Changes' button for class2 roster
		districtAdminMyClassPage.clickSaveChangesButtonAfterMovingTheStudentsToNewClass(); 
		//Clicks 'Return to Class Roster' button to return to roster main page of class2
		districtAdminMyClassPage.clickReturnToClassRosterButton();
		//Verifies navigation back to roster main page of class2
		districtAdminMyClassPage.verifyNavigationToMyClassTabRoster(classNames[1]);
		//Verifies added student using student id number under enrolled students list of class2
		districtAdminMyClassPage.verifyAddedStudentInTheClass(createdStudentID);
		
		//dependentData.writeProperty("VPORT_007_CreatedStudentID", createdStudentID);
		
		return createdStudentID.toString();
	}

	public void AssignLicensesToStudentAvailableinClasss(DistrictAdminHomepage districtAdminHomeStudentLicence,VportData vportDataStudentsLicenses)
	{
		this.districtAdminHomepage=districtAdminHomeStudentLicence;
		this.vportData=vportDataStudentsLicenses;
		String trackName = dependentData.getProperty("VPORTBuild_TrackName");
		String createdStudentID = dependentData.getProperty("VPORT_Build_CreatedStudentID");
		String classNames[] = {dependentData.getProperty("VPORT_BUILD_CLASS1"),dependentData.getProperty("VPORT_BUILD_CLASS2")};
		// verify admin Home page
		districtAdminHomepage.verifyHomePage(trackName, this.vportData.productName);
		// Selects school from school dropdown
		districtAdminHomepage.selectSchoolFromDropdown(this.vportData.districtAdminSchoolName);
		// Navigate to My school tab after selecting a class from classes dropdown and verifies it
		districtAdminMySchoolPage = districtAdminHomepage.clickOnMySchoolTab();
		districtAdminMyClassPage=districtAdminMySchoolPage.selectClassFromClassDropDown(classNames[1]);
		districtAdminMyClassPage.clickOnRoster();
		//Verifies all licenses added to track are displayed to the student 
		districtAdminMyClassPage.verifyLicensesAvailableToStudent(this.vportData.pP_T2RStudent, this.vportData.onlineAssessments, this.vportData.T2R, this.vportData.pP_T2R_EdplicityStudent);
		//Assign  'PP/T2R/Edplicity Student ' license to student 
		districtAdminMyClassPage.checkPPT2REdplicityLicensetoStudent(createdStudentID);
		districtAdminMyClassPage.clicksaveChanges();
		//Verify all other licenses  are disabled after checking 'PP/T2R/Edplicity Student' checkbox
		districtAdminMyClassPage.verifyOtherLicensesaDisabled(createdStudentID);
		//Change student userId and password
		districtAdminMyClassPage.changeUserIDAndPasswordOfStudentAndSave(createdStudentID);
		districtAdminHomepage= districtAdminMyClassPage.navigateToHomePageofClass();
		districtAdminHomepage.verifyHomePageofClass(classNames[1]);
		//verifies resource images displayed under resources in Home page
		districtAdminHomepage.verifyResourcesinClassHomePage();
	}
	
	
}
