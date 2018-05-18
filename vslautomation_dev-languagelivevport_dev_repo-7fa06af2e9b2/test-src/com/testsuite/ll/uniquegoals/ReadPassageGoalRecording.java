package com.testsuite.ll.uniquegoals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.goals.ReadPassagesGoalRecordingPage;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.StudentCreation;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLActivity.ReturnPage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class ReadPassageGoalRecording extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	StudentCreation studentCreation;
	int myScoreValue;
	String[] newStudents;
	private ReadPassagesGoalRecordingPage readPassagesGoalRecording;
	private StudentWelcomePage studentWelcomePage;
	ConfigManager dependentData = new ConfigManager("DependentData");

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		// getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();

	}

	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL_002_ReadPassageGoalFastPace() {
		// Step1: Prerequsite: Login with teacher & Create a student in Level
		// and set data to Unit6 - Read Passages goal

		newStudents = llloginPage.createStudents(llloginPage, llData.student1LevelOption, llData.student1UnitOption,
				llData.student1LessonOption, llData.student1RecordingRequired);

		// Step2: Login withith student
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

		/*
		 * NON-RECORDING STEPS
		 * 
		 * //To verify Ready To Speak window header text
		 * readPassagesGoalNonRecording.verifyReadyToSpeakWindowHeaderText(
		 * llData.readyToSpeakText); //To click on start button on Ready To
		 * Speak window
		 * readPassagesGoalNonRecording.clickStartButtonOnReadyToSpeakWindow();
		 * //To click stop timer button on the Recording Passage window
		 * readPassagesGoalNonRecording.clickStopTimerButtonOnTheWindow(); //To
		 * verify ReviewYourReading window header text
		 * readPassagesGoalNonRecording.verifyReviewYourReadingWindowHeaderText(
		 * llData.reviewYourReadingText); //To click on start button on Review
		 * Your Reading window readPassagesGoalNonRecording.
		 * clickStartButtonOnReviewYourReadingWindow(); //To verify that, the
		 * window with header text 'click on any words you said wrong' is
		 * displayed readPassagesGoalNonRecording.
		 * verifyNavigationToClickOnAnyWordsYouSaidWrongWIndow(); //To click a
		 * word on 'click on any words you said wrong' window
		 * readPassagesGoalNonRecording.clickAWrongWordOnWindow(); //To click on
		 * continue button on 'click on any words you said wrong' window
		 * readPassagesGoalNonRecording.
		 * clickContinueButtonOnnyWordsYouSaidWrongWindow(); //To verify that,
		 * 'click on the last word you read' window is displayed
		 * readPassagesGoalNonRecording.
		 * verifyNavigationToClickOnTheLastWordYouReadWindow(); //To click on
		 * some words on 'Click on the last word you read' window
		 * readPassagesGoalNonRecording.clikOnSomeLastWrodsYouRead(); //To click
		 * on continue button on 'click on last words you read' window
		 * readPassagesGoalNonRecording.
		 * clickContinueButtonOnLastWordYouReadWindow();
		 */

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

	@Test(groups = { "RC"}, priority = 2, retryAnalyzer = Retry.class)
	public void LL_002_ReadPassageGoalSlowPace() {
		// Step1: Prerequsite: Login with teacher & Create a student in Level
		// and set data to Unit6 - Read Passages goal

		newStudents = llloginPage.createStudents(llloginPage, llData.LL002_Goals_Student_Level, llData.LL002_Goals_Student_Unit,
				llData.LL002_Goals_Student_Lesson, llData.LL002_Goals_Student_Recording_Need);

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
		//Step28: Continue the steps 20 to 27 for six times to complete read passages goal in slow pace
		readPassagesGoalRecording.readPassageTest(llData, 6);
		// To click continue button on 'Words Per Minute Progress' window
		//Step29: verify the graph page and click conitnue button
		readPassagesGoalRecording.clickContinueButtonOnWordPerMinuteProgressWindow();
		readPassagesGoalRecording.navigateToHomePagefromActivity();
		//Step30: Logout from application 
		readPassagesGoalRecording.clickLogoutfromHomePage();
		//Step31: Verify login page
		readPassagesGoalRecording.verifyLoginPage();
	}
	
	@Test(groups = { "RC"}, priority = 3, retryAnalyzer = Retry.class)
	public void LL_002_ReadPassageGoalMediumPace() {
		// Step1: Prerequsite: Login with teacher & Create a student in Level
		// and set data to Unit6 - Read Passages goal

		newStudents = llloginPage.createStudents(llloginPage, llData.LL002_Goals_Student_Level, llData.LL002_Goals_Student_Unit,
				llData.LL002_Goals_Student_Lesson, llData.LL002_Goals_Student_Recording_Need);

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
		//Step28: Continue the steps 20 to 27 for six times to complete read passages goal in Medium pace
		readPassagesGoalRecording.readPassageTest(llData, 3);
		// To click continue button on 'Words Per Minute Progress' window
		//Step29: verify the graph page and click conitnue button
		readPassagesGoalRecording.clickContinueButtonOnWordPerMinuteProgressWindow();
		readPassagesGoalRecording.navigateToHomePagefromActivity();
		//Step30: Logout from application 
		readPassagesGoalRecording.clickLogoutfromHomePage();
		//Step31: Verify login page
		readPassagesGoalRecording.verifyLoginPage();
	}


}