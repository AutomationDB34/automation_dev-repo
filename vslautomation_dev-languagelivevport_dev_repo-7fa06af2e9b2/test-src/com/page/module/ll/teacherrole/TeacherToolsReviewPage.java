package com.page.module.ll.teacherrole;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.teacherrole.TeacherToolsReviewLocators;
import com.page.module.ll.goals.ReadPassagesGoalRecordingPage;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLActivity.ReturnPage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.level1activities.TeacherHomePage.LLToolsTabReturnPage;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;
import com.testsuite.ll.uniquegoals.ReadPassageGoalRecording;

public class TeacherToolsReviewPage extends CommonFunctionalities implements TeacherToolsReviewLocators {

	private WebDriver driver;
	TeacherToolsAssignmentsPage teacherToolsAssignmentsPage;
	private TeacherRoleStudentPowerPassTTActivityActions teacherRoleStudentPowerPassTTActivityActions;
	private StudentWelcomePage studentWelcomePage;
	private TeacherToolsReviewPage teacherToolsReviewPage;
	private TeacherHomePage teacherHomePage;
	TeacherRoleToolsPage teacherRoleToolsPage;
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLLogout lllogout;
	private LLActivity llactivity;
	private boolean isStudentDisplayedWithViewPowerPassFeedBack;
	TeacherToolsReviewFeedbackPage teacherToolsReviewFeedbackPage;
	ReadPassagesGoalRecordingPage readPassagesGoalRecording;
	String[] newStudents;
	int myScoreValue;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());
	ConfigManager dependentData = new ConfigManager("DependentData");

	public TeacherToolsReviewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose - To verify that Tools Review->Review Page is loaded
	 */

	public void verifyThatToolsReviewPageIsLoaded() {
		Assert.assertTrue(isElementPresent(REVIEWSTAB_STUDENTS_TABLE, LONGWAIT),
				"Reports->Review tab page is not loaded after clicking Tools tab");
		waitForPageToLoad();
	}

	/**
	 * Purpose- To verify that the student user who has taken feedback is
	 * removed from 'Review->Reviews' list
	 * 
	 * @param studentLastName
	 */

	public void verifyThatStudentUserIsRemovedFromFeedbackReviewList(String studentLastName) {
		nullifyImplicitWait();

		int studentCount = getLocatorCount(Dynamic.getNewLocator(REVIEWSTAB_STUDENT_REVIEW_BTN, studentLastName));

		Assert.assertEquals(studentCount, 0, "The student user with last name(" + studentLastName
				+ " )for which feedback is completed is still displayed under 'Tools->Review->Reviews' list");

		setImplicitWait(IMPLICITWAIT);
	}

	/**
	 * Purpose- To select class from class drop down under 'Reviews' tab
	 * 
	 * @param className
	 */

	public void selectClassFromClassDropDown(String className) {
		safeClick(REVIEW_REVIEWS_CLASS_DRP, LONGWAIT);
		safeClick(Dynamic.getNewLocator(REVIEW_REVIEWS_CLASS_OPTION, className), LONGWAIT);
		waitForPageToLoad();
	}

	/**
	 * Purpose- To click on review button for a student user
	 * 
	 * @param studentLastName
	 */

	public TeacherToolsReviewFeedbackPage clickReviewButtonForTheStudent(String studentLastName) {
		Assert.assertTrue(
				isElementPresent(Dynamic.getNewLocator(REVIEWSTAB_STUDENT_REVIEW_BTN, studentLastName), LONGWAIT),
				"The student user(" + studentLastName
						+ ") is not displayed with 'Review' button under Review->Reviews student table");

		safeClick(Dynamic.getNewLocator(REVIEWSTAB_STUDENT_REVIEW_BTN, studentLastName), LONGWAIT);

		return new TeacherToolsReviewFeedbackPage(driver);

	}

	/**
	 * Purpose- To click on Alerts tab
	 */

	public void clickOnAlertsTab() {
		safeClick(REVIEW_ALERTS_TAB, LONGWAIT);
	}

	/**
	 * Purpose- verify that alerts tab is loaded successfully
	 */

	public void verifyThatAlertsTabIsLoaded() {
		Assert.assertTrue(isElementPresent(REVIEW_ALERTSTAB_STUDENTTABLE, LONGWAIT),
				"Alerts tab is not loaded under Tools->Review section");
	}

	/**
	 * Purpose- verify that alerts tab is loaded with a student having auto pass
	 * 
	 * @param alertsStudentLastName
	 */

	public void verifyThatAlertsTabIsLoadedWithAutoPassAndReviewStudent(String alertsStudentLastName) {

		Assert.assertTrue(
				isElementPresent(Dynamic.getNewLocator(ALERTSSTUDENT_AUTOPASS, alertsStudentLastName), LONGWAIT),
				"Alerts tab is not loaded with auto pass enabled student(" + alertsStudentLastName + ")");

		Assert.assertTrue(
				isElementPresent(Dynamic.getNewLocator(ALERTSSTUDENT_REVIEW_BTN, alertsStudentLastName), LONGWAIT),
				"Alerts tab is not loaded with auto pass enabled student(" + alertsStudentLastName
						+ ") and review button");

	}

	/**
	 * Purpose - To verify that a student with power pass review button is
	 * displayed or not
	 */

	public boolean isStudentDisplayedWithPowerPassReviewButton(String studentLastName) {
		nullifyImplicitWait();
		int studentCount = getLocatorCount(
				Dynamic.getNewLocator(REVIEWSTAB_STUDENT_POWERPASS_REVIEW_BTN, studentLastName));

		if (studentCount == 1) {
			setImplicitWait(IMPLICITWAIT);
			return true;
		} else {
			setImplicitWait(IMPLICITWAIT);
			System.out.println("inside element not found");
			return false;
		}
	}

	/**
	 * Purpose-To get the number of WT goal activities are displayed in the
	 * Activity Column in Review Tab
	 */
	public int getNumberofWTActivitiesNeedtoReviewd() {
		if (isElementPresent(REVIEW_WTACTIVITY)) {
			int WTCount = getLocatorCount(REVIEW_WTACTIVITY);
			return WTCount;
		} else {
			return 0;
		}
	}

	/**
	 * Purpose-To get the number of Auto_pass goal activities are displayed in
	 * the Type Column in Alerts Tab
	 */
	public int getNumberofAutoPassTypesActivitiesNeedtoReviewd() {
		if (isElementPresent(AlERTS_AUTOPASSTYPE)) {
			int AutoPassCount = getLocatorCount(AlERTS_AUTOPASSTYPE);
			return AutoPassCount;
		} else {
			return 0;
		}
	}

	public void runTTandWTgoals(boolean isStudentDisplayedWithReviewButton, TeacherRoleToolsPage teacherRoleToolsPage ) {

		if (executionMode.equalsIgnoreCase("qc")) {
			log.info("Runnig the test case at QC mode");
			CompletePowerPassTTActivityAsStudent(isStudentDisplayedWithReviewButton, teacherRoleToolsPage);

		} else {
			log.info("Runnig the test case at RC mode");
			CompletePowerPassTTActivityAsStudent(isStudentDisplayedWithReviewButton, teacherRoleToolsPage);
			completeWTReadPassageGoal();
			wtFeedback();
		}

		
		

	}

	public void wtFeedback(){
		// To enter login credentials and click sign in button
				teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacher_stdcreation,
						llData.teacher_stdcreation, LLLoginReturnPage.TEACHER_HOME_PAGE);
				// To verify that teacher user is logged in successfully
				teacherHomePage.verifyTeacherLogin();
				// To click on Tools tab as teacher user
				teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
						.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
				// To verify whether tools page is loaded or not
				teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
				// Selects class from class drop down under Reviews tab
				teacherToolsReviewPage.selectClassFromClassDropDown(llData.teacherRoleLLClassName);
				teacherToolsReviewFeedbackPage = teacherToolsReviewPage
						.clickReviewButtonofGoal(dependentData.getProperty("ReadPassages_Student"));
				teacherToolsReviewFeedbackPage.verifyGoalFeedbackPage(dependentData.getProperty("ReadPassages_Student"));
				teacherToolsReviewFeedbackPage.giveFeedbackforWTGoal();
				// To verify that Tools review page is loaded successfully after
				// completing feedback for students
				teacherToolsReviewPage.verifyThatToolsReviewPageIsLoaded();
				
				// To verify that feedback completed student is removed from
				// Tools->Review->Reviews section
				teacherToolsReviewPage.verifyThatStudentUserIsRemovedFromFeedbackReviewList(
						dependentData.getProperty("ReadPassages_Student"));

				// Logout form the application
				teacherToolsReviewPage.clickLogoutfromHomePage();
				teacherToolsReviewPage.verifyLoginPage();
	}
	private void CompletePowerPassTTActivityAsStudent(boolean isRevewStudentPresent,
			TeacherRoleToolsPage teacherRoleToolsPage) {

		llData = new LLData();
		llloginPage = new LLLoginPage(driver);
		lllogout = new LLLogout(driver);

		if (isRevewStudentPresent == false) {

			// clicks on 'Assignments' link under Tools tab
			teacherToolsAssignmentsPage = teacherRoleToolsPage.clickOnAssignmentsTab();
			// To verify that Assignments tab is loaded successfully
			teacherToolsAssignmentsPage.verifyThatAssignmentsTabIsLoaded();
			// Assign power pass B TT activity for student user
			teacherToolsAssignmentsPage
					.assignPowerPassBTTActivityForStudent(llData.teacherRoleLLTTReviewFeedBackStudentLastName);
			// Logout from the page
			llloginPage = lllogout.clickLogoutfromHomePage();
			// To verify login page
			llloginPage.verifyLoginPage();
			// login as student user
			studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,
					llData.teacherRoleLLTTReviewFeedBackStudentLastName,
					llData.teacherRoleLLTTReviewFeedBackStudentLastName, LLLoginReturnPage.STUD_WELCOME_PAGE);
			// verify welcome page of the student user
			studentWelcomePage.verifywelcomePage();
			// click continue button
			llactivity = studentWelcomePage.welcomeButton();
			// verifies home page
			llactivity.verifyHomepage();
			// To verify wheather student is displayed with view power pass
			// feedback link or not
			isStudentDisplayedWithViewPowerPassFeedBack = llactivity.isStudentDisplayedWithViewPowerPassFeedbackLink();
			// To click on View Power Pass Feedback link
			teacherRoleStudentPowerPassTTActivityActions = llactivity
					.clickOnViewPowerPassFeedback(isStudentDisplayedWithViewPowerPassFeedBack);
			// To verify navigation to question 1 feedback and click continue
			// button
			teacherRoleStudentPowerPassTTActivityActions
					.navigateToQuestionOneFeedbackAndClickContinue(isStudentDisplayedWithViewPowerPassFeedBack);
			// To verify navigation to question 2 feedback and click continue
			// button
			teacherRoleStudentPowerPassTTActivityActions
					.navigateToQuestionTwoFeedbackAndClickContinue(isStudentDisplayedWithViewPowerPassFeedBack);
			// To click go to home page button on view power pass feedback
			// results section
			llactivity = teacherRoleStudentPowerPassTTActivityActions
					.clickGoToHomePageButton(isStudentDisplayedWithViewPowerPassFeedBack);
			// Verifies navigation back to student home page
			llactivity.verifyHomepage();
			// To click on TT unit 1 start power pass link as student user
			teacherRoleStudentPowerPassTTActivityActions = llactivity.clickOnStartPowerPassLink();
			// To click on start button on Ready To start part B? pop-up
			teacherRoleStudentPowerPassTTActivityActions.navigateToReadyToStartPartBSectionAndClickStart();
			// To verify the navigation to question 1 rubric content section and
			// click continue button
			teacherRoleStudentPowerPassTTActivityActions.navigateToQuestionOneRubricConentAndClickContinue();
			// To verify navigation to question 1 answer section and fill the
			// answer and click continue button
			teacherRoleStudentPowerPassTTActivityActions.verifyNavigationToQuestionOneRubricAnswerAndClickContinue();
			// To verify the navigation to question 2 rubric content section and
			// click continue button
			teacherRoleStudentPowerPassTTActivityActions.navigateToQuestionTwoRubricConentAndClickContinue();
			// To verify navigation to question 2 answer section and fill the
			// answer and click continue button
			teacherRoleStudentPowerPassTTActivityActions.verifyNavigationToQuestionTwoRubricAnswerAndClickContinue();
			// To verify the navigation to power pass part b results section and
			// click on back to home page button
			teacherRoleStudentPowerPassTTActivityActions.verifyNavigationToPowerPassBResultsSectionAndClickContinue();
			// Verifies navigation back to student home page
			llactivity.verifyHomepage();
			// To logout from home page
			llloginPage = lllogout.clickLogoutfromHomePage();
		/*	// To verify login page
			llloginPage.verifyLoginPage();
			// To enter login credentials and click sign in button
			teacherHomePage = (TeacherHomePage) llloginPage.loginCredentials(llData.URL, llData.teacherRoleLLUsername,
					llData.teacherRoleLLPassword, LLLoginReturnPage.TEACHER_HOME_PAGE);
			// To verify that teacher user is logged in successfully
			teacherHomePage.verifyTeacherLogin();
			// To click on Tools tab as teacher user
			teacherRoleToolsPage = (TeacherRoleToolsPage) teacherHomePage
					.clickOnToolsTab(LLToolsTabReturnPage.TEACHER_ROLE_TOOLS_PAGE);
			// To verify whether tools page is loaded or not
			teacherRoleToolsPage.verifyThatToolsPageIsLoaded();
			// Selects class from class drop down under Reviews tab
			teacherToolsReviewPage.selectClassFromClassDropDown(llData.teacherRoleLLClassName);*/
		}

	}

	public void completeWTReadPassageGoal() {

		newStudents = llloginPage.createStudents(llloginPage, llData.student1LevelOption, llData.student1UnitOption,
				llData.student1LessonOption, llData.student1RecordingRequired);

		// Step2: Login with student
		// Enter credentials for student user
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL, newStudents[0],
				newStudents[0], LLLoginReturnPage.STUD_WELCOME_PAGE);

		dependentData.writeProperty("ReadPassages_Student", newStudents[0]);

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
				.clickContinueButtonOnWordTrainingPage(ReturnPage.READPASSAGEGOALNONRECORDING);
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

	}

	public TeacherToolsReviewFeedbackPage clickReviewButtonofGoal(String studentLastName) {

		Assert.assertTrue(
				isElementPresent(Dynamic.getNewLocator(REVIEWSTAB_STUDENT_REVIEW_BTN, studentLastName), LONGWAIT),
				"The student user(" + studentLastName
						+ ") is not displayed with 'Review' button under Review->Reviews student table");

		safeClick(Dynamic.getNewLocator(REVIEWSTAB_STUDENT_REVIEW_BTN, studentLastName), LONGWAIT);

		return new TeacherToolsReviewFeedbackPage(driver);

	}
	
}
