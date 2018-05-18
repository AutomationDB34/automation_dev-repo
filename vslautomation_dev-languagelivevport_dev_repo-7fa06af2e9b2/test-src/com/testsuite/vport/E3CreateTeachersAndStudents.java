package com.testsuite.vport;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.VportData;
import com.datamanager.ConfigManager;
import com.page.module.vport.DistrictAdminHomepage;
import com.page.module.vport.DistrictAdminMyClassPage;
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class E3CreateTeachersAndStudents extends BaseSetup{
	private VportLoginPage vportloginpage;
	private VportData vportData;
	private DistrictAdminHomepage districtAdminHomepage;
	private DistrictAdminMySchoolPage districtAdminMySchoolPage;
	private DistrictAdminMyClassPage districtAdminMyClassPage;
	//	private String teacheruserId;
	//	private String studentUserId;
	//	private String createdStudentID;
	//	private String classNames[];
	ConfigManager dependentData = new ConfigManager("DependentData");

	@BeforeMethod(alwaysRun = true, timeOut = 1000000)
	public void BaseClassSetUp() {
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		//vportloginpage.verifyLoginPage();

		//		if(districtLogin == null){
		//			districtLogin = vportData.districtAdminUserName;
		//			distAdminPassword = vportData.districtAdminPassword;
		//		}
	}


	/**
	 * This test creates Teachers and creates two classes in a school
	 */
	@Test(groups={"RC", "QC"},retryAnalyzer = Retry.class, timeOut = 1000000)
	public void VPORT_006_AddTeachersandClassestoSchool()
	{
		vportloginpage.verifyLoginPage();
		String distAdminPassword = vportData.distUserPassword;
		vportloginpage.enterLoginCredentials(dependentData.getProperty("VPORT_002_DistrictUserName"), distAdminPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		String trackName = dependentData.getProperty("VPORT_001_TrackName");
		String schoolName = dependentData.getProperty("VPORT_002_SchoolName");
		// verify admin Home page
		districtAdminHomepage.verifyHomePage(trackName, vportData.productName);
		// Selects school from school dropdown
		districtAdminHomepage.selectSchoolFromDropdown(vportData.districtAdminSchoolName);
		// Navigate to My school tab after selecting a class from classes dropdown and verifies it
		districtAdminMySchoolPage = districtAdminHomepage.clickOnMySchoolTab();
		districtAdminMySchoolPage.verifyMySchoolPage(schoolName);
		// Navigate to Teachers and classes tab and verifies it
		districtAdminMySchoolPage.navigateToTeachersAndClassesSubtab();
		districtAdminMySchoolPage.verifyTeachersAndClassesSubtab();
		//long strRandom = System.currentTimeMillis();
		// Adds teacher and edit the user name and password
		String lastname = districtAdminMySchoolPage.addTeacher(vportData.teacherLastName , vportData.teacherFirstName,vportData.teacherEmail);
		String teacherUserID = districtAdminMySchoolPage.editTeacherandSave(lastname ,vportData.teacherUserId , vportData.teacherPassword);
		//Add classes to school and verifies schools in schools drop down and classes section
		//Also add the class names to properties file
		String classes[] = districtAdminMySchoolPage.addClassesandSave(lastname,vportData.class1,vportData.class2, vportData.class3);
		districtAdminMySchoolPage.verifyAddedClasses(lastname,vportData.class1,vportData.class2, vportData.class3);
		districtAdminMySchoolPage.verifyClassesinClassesDropdown(lastname,vportData.class1,vportData.class2, vportData.class3);
		dependentData.writeProperty("VPORT_006_CLASS1", classes[0]);
		dependentData.writeProperty("VPORT_006_CLASS2", classes[1]);
		dependentData.writeProperty("VPORT_006_CLASS2", classes[2]);
		dependentData.writeProperty("VPORT_006_TeacherUserID", teacherUserID);
	}

	@Test(groups={"RC","QC"},retryAnalyzer = Retry.class, timeOut = 1000000)
	public void VPORT_007_AddStudentsToTheTeacherClasses() throws Exception
	{		
		vportloginpage.verifyLoginPage();
		String distAdminPassword = vportData.distUserPassword;
		vportloginpage.enterLoginCredentials(dependentData.getProperty("VPORT_002_DistrictUserName"), distAdminPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		String trackName = dependentData.getProperty("VPORT_001_TrackName");
		String classNames[] = {dependentData.getProperty("VPORT_006_CLASS1"),dependentData.getProperty("VPORT_006_CLASS2")};
		// verify admin Home page
		districtAdminHomepage.verifyHomePage(trackName, vportData.productName);
		// Selects school from school dropdown
		districtAdminHomepage.selectSchoolFromDropdown(vportData.districtAdminSchoolName);
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
		String createdStudentID=districtAdminMyClassPage.fillNewStudentDetailsOnAddNewStudentsPopUp(vportData.studentLastName,vportData.studentFirstName,vportData.studentID,vportData.studentGradeLevel,vportData.studentDOB);
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
		dependentData.writeProperty("VPORT_007_CreatedStudentID", createdStudentID);
		dependentData.writeProperty("TRACKCREATED", getDriver().getCurrentUrl());
	}


	/**
	 * This test assign available licenses in a track  to students 
	 */
	@Test(groups={"RC","QC"},retryAnalyzer = Retry.class)
	public void VPORT_008_AssignLicensesToStudentAvailableinClasss() 
	{
		vportloginpage.verifyLoginPage();
		String distAdminPassword = vportData.distUserPassword;
		vportloginpage.enterLoginCredentials(dependentData.getProperty("VPORT_002_DistrictUserName"), distAdminPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		String trackName = dependentData.getProperty("VPORT_001_TrackName");
		String createdStudentID = dependentData.getProperty("VPORT_007_CreatedStudentID");
		String classNames[] = {dependentData.getProperty("VPORT_006_CLASS1"),dependentData.getProperty("VPORT_006_CLASS2")};
		// verify admin Home page
		districtAdminHomepage.verifyHomePage(trackName, vportData.productName);
		// Selects school from school dropdown
		districtAdminHomepage.selectSchoolFromDropdown(vportData.districtAdminSchoolName);
		// Navigate to My school tab after selecting a class from classes dropdown and verifies it
		districtAdminMySchoolPage = districtAdminHomepage.clickOnMySchoolTab();
		districtAdminMyClassPage=districtAdminMySchoolPage.selectClassFromClassDropDown(classNames[1]);
		districtAdminMyClassPage.clickOnRoster();
		//Verifies all licenses added to track are displayed to the student 
		districtAdminMyClassPage.verifyLicensesAvailableToStudent(vportData.pP_T2RStudent, vportData.onlineAssessments, vportData.T2R, vportData.pP_T2R_EdplicityStudent);
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