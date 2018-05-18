package com.testsuite.ll.smokeScenarios;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.data.testdata.VportData.UserRole;
import com.page.module.ll.goals.ReadPassagesGoalRecordingPage;
import com.page.module.ll.goals.SentenceCompletionGoalPage;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.RealOrNonsense;
import com.page.module.ll.level1activities.StudentCreation;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLActivity.ActivityType;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.level2activities.SyllableSort;
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
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.testng.Retry;
import com.utilities.UtilityMethods;

public class SmokeScenarios extends BaseSetup {

	private VportLoginPage vportloginpage;
	private VportData vportData;
	private AddorEditTrackPage addedittrack;
	private VportTrackFilterPage vporttrackfilterPage;
	private DistrictTrackMaterialsPage districtmaterialspage;
	private DistrictTrackTechnologyPage districttracktechnologypage;
	private MasterDistrictTracksPage masterDistrictTracksPage;
	private DistrictTrackContactsPage districtTrackContactsPage;
	private DistrictTrackSchoolTracksPage districtTrackSchoolTracksPage;
	private DistrictAdminOrientationPage districtAdminOrientationPage;
	private DistrictAdminPrivacyPage districtAdminPrivacyPage;
	private DistrictAdminWelcomePage districtAdminWelcomePage;
	private MyDistrictPage myDistrictPage;
	private DistrictAdminHomepage districtAdminHomepage;
	private DistrictAdminMySchoolPage districtAdminMySchoolPage;
	private DistrictAdminMyClassPage districtAdminMyClassPage;

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private RealOrNonsense realOrNonsense;

	private SyllableSort syllablesort;

	StudentCreation studentCreation;
	int myScoreValue;
	String[] newStudents;
	private ReadPassagesGoalRecordingPage readPassagesGoalRecording;
	
	SentenceCompletionGoalPage sentenceCompletion;


	@BeforeMethod(alwaysRun=true)
	public void baseSetup()
	{
		vportData = new VportData();
		llData = new LLData();
		vportloginpage = new VportLoginPage(getDriver());
		getDriver().get(vportData.vportURL);
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
	}


	//@Test(retryAnalyzer = Retry.class)
	public void TEST001_SmokeScenario()
	{
		
	
		/*STEP1:Create LL track in VPORT with appropriate licenses*/
		String trackName;
		addedittrack = vporttrackfilterPage.clickAddDistrictbutton();
		addedittrack.verfyDistrictPage();
		trackName = addedittrack.fillTrackDetails(vportData.Districtname, vportData.Address, vportData.DistCity,
				vportData.Country, vportData.State, vportData.ZipCode, vportData.userType, vportData.productName,
				vportData.Status,vportData.Year);
		vporttrackfilterPage = addedittrack.clickSaveChanges();
		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
		vporttrackfilterPage = vporttrackfilterPage.navigateToDistrictTracksPage();

		/*STEP2:Add Users District user, Campus user, Teachers, Students for both levels*/
		String districtAdminUser;
		String campusUser;
		String schoolAndCode[];
				vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
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
		// To edit the school user with new login and password
		campusUser= masterDistrictTracksPage.EditSchoolUser(schoolAndCode[0], campUserLastname,
				vportData.schoolUserPassword);
		//masterDistrictTracksPage.clickShowTeachers();
		masterDistrictTracksPage.verifyScholUserDetails(vportData.schoolUserFirstName, campUserLastname,
				schoolAndCode[0],campusUser, vportData.schoolUserPassword,
				UserRole.CAMPUS_USER);
		vporttrackfilterPage = vporttrackfilterPage.navigateToDistrictTracksPage();


		 /*SubStep: Activate School */
		String schoolName = schoolAndCode[0];
				vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
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
		vportloginpage = vporttrackfilterPage.clickLogoutLink();

		/*SubStep: Login With District Admin*/ 
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(districtAdminUser , vportData.distUserPassword);
		//vportloginpage.enterLoginCredentials("zenautodistuser1445410143641" , vportData.distUserPassword);
		districtAdminPrivacyPage = (DistrictAdminPrivacyPage)vportloginpage.clickSignInButton(ReturnPage.PRIVACYPAGE);
		//District admin user privacy agreement page
		districtAdminPrivacyPage.verifyPrivacyPage();
		districtAdminPrivacyPage.acceptPrivacy(vportData.districtAdminName , vportData.districtAdminTitle);
		districtAdminWelcomePage = districtAdminPrivacyPage.clickAcceptBtn();
		//District admin user profile information
		districtAdminWelcomePage.verifAdminWelcomePage();
		districtAdminOrientationPage = districtAdminWelcomePage.profileInformation(vportData.districtAdminEMail , vportData.districtAdmintraining);
		//Verifying the Orientation pages for Disrtict admin user for the first login and check school sctivation
		districtAdminOrientationPage.verifyOrientationPage();
		myDistrictPage = districtAdminOrientationPage.orientatonpages();
		myDistrictPage.verifyMyDistrictPage();
		myDistrictPage.activateSchool();
		vportloginpage =  myDistrictPage.clickLogoutLink();

		/*SubStep: Creating the Teachers and Classes */
		vportloginpage.verifyLoginPage();
		String distAdminPassword = vportData.distUserPassword;
		vportloginpage.enterLoginCredentials(districtAdminUser, distAdminPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		//String schoolName = dependentData.getProperty("VPORT_002_SchoolName");
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
		vportloginpage = districtAdminMySchoolPage.clickLogoutLink();

		vportloginpage.enterLoginCredentials(districtAdminUser, distAdminPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		String classNames[] = {classes[0],classes[1]};
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
		vportloginpage = districtAdminMyClassPage.clickLogoutLink();


		String executionMode = "QC";
		/*STEP3: Login with Student to LL*/
		/*STEP4: Complete 1 activity of L1 (say, Unit 2 lesson 1 activity 1,LL_006_realAndNonsense())*/

		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		//Step1: login to the LL Application  with student credentials. And Verify the Successful Login.
		studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,llData.realOrNonsenseStudent, llData.realOrNonsenseStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		//Step2: Click on the WelCome Button
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the bundle named Sorting Wordsort from Unit1 Lesson1(Select same bundle for both QC and RC)
		realOrNonsense = (RealOrNonsense) llactivity.bundleSelector(6, isIexploreBrowser(), ActivityType.REAL_OR_NONSENSE,llData,executionMode);
		//Step4: Verify the navigation to the activity 
		realOrNonsense.verifyRealNonsenseActivity();
		//Step 5: Follow the auido and drag and drop the words into the column 
		realOrNonsense.rcrealOrNonsense(isIexploreBrowser());
		//Step6: Verify the summary page
		realOrNonsense.realOrNonsenseSummary();
		//Step 7: Logout from the activity  and verify the login page
		realOrNonsense.clickLogoutfromActivty();
		realOrNonsense.verifyLoginPage();

		/*STEP5: Complete 1 goal of L1 (that takes less time to execute)*/

		newStudents = llloginPage.createStudents(llloginPage, llData.student1LevelOption, llData.student1UnitOption,
				llData.student1LessonOption, llData.student1RecordingRequired);

		// Step2: Login with student
		// Enter credentials for student user
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL, newStudents[0],
				newStudents[0], LLLoginReturnPage.STUD_WELCOME_PAGE);

		// Step3: Verify Welcome Page
		studentWelcomePage.verifywelcomePage();
		// Step4: Click continue button in Welcome Page & Verify Home Page
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		// Step5: Click 'Start StartRead Passages' button and verify cambium
		// dashboard
		llactivity.clickStartButton();
		// Step6: Click 'Continue' button to start the goal
		readPassagesGoalRecording = (ReadPassagesGoalRecordingPage) llactivity
				.clickContinueButtonOnWordTrainingPage(com.page.module.ll.level1activities.LLActivity.ReturnPage.READPASSAGEGOALNONRECORDING);
		// Step7: Verify two goal videos
		// To click on GATEWAY GOALS FIRST VIDEO window continue button
		readPassagesGoalRecording.clickContinueButtonOnGateWayGoalsVideoWindow();
		// To click on PASSAGE FLUENCY VIDEO window continue button
		readPassagesGoalRecording.clickContinueButtonOnPassageFluencyVideoWindow();
		// Step8: Click 'Start' button on the 'Ready to Preview?' pop up
		readPassagesGoalRecording.verifyReadyToPreviewWindowHeaderText(llData.readyToPreviewText);
		readPassagesGoalRecording.clickStartButtonOnReadyToPreviewWindow();
		// Step9: Verify the passage displayed
		readPassagesGoalRecording.verifySomeReadingPassageTextIsDisplayed();
		// Step10:Click 'Continue' button in the passage page
		readPassagesGoalRecording.clickContinueButtonOnReadingPassageTextWindow();
		// Step11: Verify the "complete the sentence window' page and click
		// continue button
		readPassagesGoalRecording.verifyCompleteTheSentenceInPassageTextWindow(llData.completeTheSentencesInTheText);
		readPassagesGoalRecording.clickContinueButtonOnCompleteTheSentenceInPassageTextWindow();
		// Step12: Verify 'Ready to Start?' pop up and click 'Start' button
		readPassagesGoalRecording.verifyReadyToStartWindowHeaderText_First(llData.readyToStartText);
		readPassagesGoalRecording.clickStartButtonOnReadyToStartWindow_First();
		// Step13: Verify the 'Fill In the Blanks' section is displayed
		readPassagesGoalRecording.verifyNavigationToFillInTheBlanksPassageWindow();
		// Step14: Answer all the fill in the blanks displayed and click
		// continue button
		readPassagesGoalRecording.fillInTheBlanksInThePassage();
		// To click on continue button on fill in the blanks passage window
		readPassagesGoalRecording.clickContinueButtonOnFillInTheBlanksPassageWindow();
		// Step15: Verify 'Read along and listen to the model until you are
		// ready to make a recording.' window ia displayed and click 'Continue'
		// button
		readPassagesGoalRecording.verifyReadAlongAndListenToModelTextWindow(llData.readAlongAndListenToModelText);
		readPassagesGoalRecording.clickContinueButtonOnReadAlongAndListenToModelTextWindow();
		// Step16: Verify 'Ready to start reding?' pop up and click 'Start'
		// button
		readPassagesGoalRecording.verifyReadyToStartReadingWindowHeaderText(llData.readyToStartReadingText);
		readPassagesGoalRecording.clickStartButtonOnReadyToStartReadingWindow();
		// Step17:Verify Passage with audio bar is displayed or not and click
		// 'Continue' button
		readPassagesGoalRecording.verifyNavigationToAudioProgressPassageWindow();
		readPassagesGoalRecording.clickContinueButtonOnAudioReadingProgressWindow();
		// Step18: Verify 'You're ready to take the test' window and click
		// 'Continue button
		readPassagesGoalRecording.verifyYouAreReadyToTakeTheTestWindowHeaderText(llData.youAreReadyToTakeTheTestText);
		// To click on continue button on Ready To take the test window
		readPassagesGoalRecording.clickContinueButtonOnYouAreReadyToTakeTheTestWindow();
		// Step19: Enabled microphone
		readPassagesGoalRecording.microPhoneSetUp(llData);
		// Step20: Verify 'Ready to Record?' pop up and click 'Start' button
		readPassagesGoalRecording.verifyReadyToRecordPopUp();
		// Step21: Verify the passage recording page
		readPassagesGoalRecording.verifyPassageRecordingPage();
		// Step22: Click 'Stop Timer' button
		readPassagesGoalRecording.clickStopTimerBtn(15);
		// Step23: Verify the uploading pop ups
		readPassagesGoalRecording.verifyUploadPopup();
		// Step24: Verify Review your Recording. pop up and click 'Start' button
		readPassagesGoalRecording.verifyReviewPopup();
		// Step25: Verify Review passage page
		readPassagesGoalRecording.verifyPassageReviewPage();
		// Step26: Click on the words that recored wrong and click continue
		// button
		readPassagesGoalRecording.clickWordsRecordedWrong();
		// Step26: Click on the last word read in the passage and click
		// 'Continue' button
		readPassagesGoalRecording.clickLastWordRecorded();


		// To verify that, 'Test Results' window is displayed
		readPassagesGoalRecording.verifyNavigationToTestResultsWindow();
		// To retrieve the my score value from 'Test Results' window
		myScoreValue = readPassagesGoalRecording.retriveMyScoreValueFromTestResultsWindow();
		// To click on 'submit for feedback' button on 'Test Results' window
		readPassagesGoalRecording.clickSubmitFeedBackButtonOnTestResultsWindow();
		// To verify 'Your Recording has been submitted for feedback' window
		// header text
		readPassagesGoalRecording.verifyYourRecordingHasBeenSubmittedHeaderText(llData.yourRecordingSubmittedText);
		// To click continue button on 'Your Recording has been submitted for
		// feedback' window
		readPassagesGoalRecording.clickContinueButtonOnYourRecordingHasBeenSubmittedWindow();
		// To verify that, 'Word Per Minute Progress' window is displayed
		readPassagesGoalRecording.verifyNavigationToWordPerMinuteProgressWindow();
		// To verify that my score value displayed under 'Words Per Minute
		// Progress' chart is same as the score value displayed on 'Test
		// Results' section
		readPassagesGoalRecording.verifyMyScoreValueInTheProgressChartWindow(myScoreValue);
		// To click continue button on 'Words Per Minute Progress' window
		readPassagesGoalRecording.clickContinueButtonOnWordPerMinuteProgressWindow();
		readPassagesGoalRecording.navigateToHomePagefromActivity();
		readPassagesGoalRecording.clickLogoutfromHomePage();
		readPassagesGoalRecording.verifyLoginPage();





		/*STEP6: Complete 1 activity of L2 (say, Unit 2 lesson 1 activity 1,, LL_010_SyllableSort())	*/			

		//Step1: Login to LL with a valid studen credentials
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.syllableSortStudent ,llData.syllableSortStudent , 
				LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2: Verify Welcome page and Click on welcome button
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		//Step3: veryfy Home page
		llactivity.verifyHomepage();
		//Step4: Select the bundle (from shortcut menu) for QC/RC as "Sorting.SyllableSort: 3 categories + 5 sortables"
		syllablesort = (SyllableSort) llactivity.bundleSelector(37, isIexploreBrowser(), ActivityType.SYLLABLE_SORT,
				llData, executionMode);
		//Step5: verifySyllableSortActivity Page
		syllablesort.verifySyllableSortActivity();
		//Step6: Drag and drop the syllable tile to sorting area. Repeat the same for all the words/letters
		syllablesort.syllableSort(isIexploreBrowser());
		//Step7: Mouse over on Activity user dropdown and then click on home link
		syllablesort.navigateToHomePagefromActivity();
		//Step8: click on log out link
		syllablesort.clickLogoutfromHomePage();
		//Step9: Verify the login page
		syllablesort.verifyLoginPage();

		/*STEP7: Complete 1 goal of L2 (that takes less time to execute,LL_008_SentenceCompletion() )*/


		// Step1: Prerequsite: Login with teacher & Create a student in Level
		// and set data to Unit4- Sentence Completion goal
		String[] newStudents = llloginPage.createStudents(llloginPage, llData.LL008_Goals_Student_Level,
				llData.LL008_Goals_Student_Unit, llData.LL008_Goals_Student_Goal,
				llData.LL008_Goals_Student_Recording_Need);
		// Step2: Login with student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,newStudents[0] ,
				newStudents[0], LLLoginReturnPage.STUD_WELCOME_PAGE);

		// Step3: Verify Welcome Page
		studentWelcomePage.verifywelcomePage();
		// Step4: Click continue button in Welcome Page & Verify Home Page
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		// Step5: Click 'Start Start Spell Words' button and verify cambium
		// dashboard
		llactivity.clickStartButton();
		// Step6: Click 'Continue' button to start the goal
		sentenceCompletion = (SentenceCompletionGoalPage) llactivity.clickContinueButtonOnWordTrainingPage(com.page.module.ll.level1activities.LLActivity.ReturnPage.SENTENCE_COMPLETION);
		// Step7: Verify two goal videos
		sentenceCompletion.verifyGoalVideos();
		//Step8: Verify Ready to start window 
		sentenceCompletion.verifyReadyToWindow(llData.Goal_ReadyToStartTest);
		//complete sentence completion in slow pace
		sentenceCompletion.sentenceCompletionSlowpace(isIexploreBrowser(), llData);
		//Step19: Logout from application 
		sentenceCompletion.clickLogoutfromHomePage();
		//Step20: Verify Login Page
		sentenceCompletion.verifyLoginPage();



		/*STEP8:Login with Teacher*/
		/*STEP9: Navigate through all tabs (main tabs and sub tabs) and verify pages are loading or not */
		String teacher = llData.teacherLLUsername;
		getDriver().get(vportData.vportURL);
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(teacher, teacher);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		//	Verifying all the Pages and links for District user
		districtAdminHomepage.verifyAllTheLinksAndPages("Teacher");
		//Log out from Teacher user Login
		vportloginpage=districtAdminHomepage.clickLogoutLink();
		vportloginpage.verifyLoginPage();
		 
		/*STEP10: Login with District user*/
		/*STEP11: Navigate through all tabs (main tabs and sub tabs) and verify pages are loading or not */
		String districtUser = llData.llDistrictAdmin;
		vportloginpage.enterLoginCredentials(districtUser,districtUser);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		//	Verifying all the Pages and links for District user
		districtAdminHomepage.verifyAllTheLinksAndPages("DistUser");
		//Log out from District user Login
		vportloginpage=districtAdminHomepage.clickLogoutLink();
		vportloginpage.verifyLoginPage();
		
		/*STEP:12 Login with Campus user*/
		/*STEP:13 Navigate through all tabs (main tabs and sub tabs) and verify pages are loading or not */
		String campusUser1 = llData.llCampusAdmin;
		vportloginpage.enterLoginCredentials(campusUser1, campusUser1);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		//	Verifying all the Pages and links for District user
		districtAdminHomepage.verifyAllTheLinksAndPages("CampUser");
		//Log out from Campus/School user Login
		vportloginpage=districtAdminHomepage.clickLogoutLink();
		vportloginpage.verifyLoginPage();
		
	}
	
	
	@Test
	public void Test_Demo_Scenario()
	{
		/*STEP1:Create LL track in VPORT with appropriate licenses*/
		String trackName;
		addedittrack = vporttrackfilterPage.clickAddDistrictbutton();
		addedittrack.verfyDistrictPage();
		trackName = addedittrack.fillTrackDetails(vportData.Districtname, vportData.Address, vportData.DistCity,
				vportData.Country, vportData.State, vportData.ZipCode, vportData.userType, vportData.productName,
				vportData.Status,vportData.Year);
		vporttrackfilterPage = addedittrack.clickSaveChanges();
		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
		vporttrackfilterPage = vporttrackfilterPage.navigateToDistrictTracksPage();

		/*STEP2:Add Users District user, Campus user, Teachers, Students for both levels*/
		String districtAdminUser;
		String campusUser;
		String schoolAndCode[];
		/*		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);*/
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
		// To edit the school user with new login and password
		campusUser= masterDistrictTracksPage.EditSchoolUser(schoolAndCode[0], campUserLastname,
				vportData.schoolUserPassword);
		//masterDistrictTracksPage.clickShowTeachers();
		masterDistrictTracksPage.verifyScholUserDetails(vportData.schoolUserFirstName, campUserLastname,
				schoolAndCode[0],campusUser, vportData.schoolUserPassword,
				UserRole.CAMPUS_USER);
		vporttrackfilterPage = vporttrackfilterPage.navigateToDistrictTracksPage();


		/* SubStep: Activate School */
		String schoolName = schoolAndCode[0];
		/*		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(vportData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);*/
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
		vportloginpage = vporttrackfilterPage.clickLogoutLink();

		/*SubStep: Login With District Admin */
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(districtAdminUser , vportData.distUserPassword);
		//vportloginpage.enterLoginCredentials("zenautodistuser1445410143641" , vportData.distUserPassword);
		districtAdminPrivacyPage = (DistrictAdminPrivacyPage)vportloginpage.clickSignInButton(ReturnPage.PRIVACYPAGE);
		//District admin user privacy agreement page
		districtAdminPrivacyPage.verifyPrivacyPage();
		districtAdminPrivacyPage.acceptPrivacy(vportData.districtAdminName , vportData.districtAdminTitle);
		districtAdminWelcomePage = districtAdminPrivacyPage.clickAcceptBtn();
		//District admin user profile information
		districtAdminWelcomePage.verifAdminWelcomePage();
		districtAdminOrientationPage = districtAdminWelcomePage.profileInformation(vportData.districtAdminEMail , vportData.districtAdmintraining);
		//Verifying the Orientation pages for Disrtict admin user for the first login and check school sctivation
		districtAdminOrientationPage.verifyOrientationPage();
		myDistrictPage = districtAdminOrientationPage.orientatonpages();
		myDistrictPage.verifyMyDistrictPage();
		myDistrictPage.activateSchool();
		vportloginpage =  myDistrictPage.clickLogoutLink();

		/*SubStep: Creating the Teachers and Classes */
		vportloginpage.verifyLoginPage();
		String distAdminPassword = vportData.distUserPassword;
		vportloginpage.enterLoginCredentials(districtAdminUser, distAdminPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		//String schoolName = dependentData.getProperty("VPORT_002_SchoolName");
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
	}
}
