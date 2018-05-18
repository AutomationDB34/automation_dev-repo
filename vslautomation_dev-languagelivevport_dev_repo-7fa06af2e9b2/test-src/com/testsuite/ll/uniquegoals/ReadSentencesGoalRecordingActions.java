package com.testsuite.ll.uniquegoals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.goals.ReadSentencesGoalRecordingPage;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.StudentCreation;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLActivity.ReturnPage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class ReadSentencesGoalRecordingActions extends BaseSetup {

	LLData llData;
	LLLoginPage llloginPage;
	LLActivity llactivity;
	StudentCreation studentCreation;
	int myScoreValue;	
	String[] newStudents;
	private ReadSentencesGoalRecordingPage readSentencesGoalRecording;
	private StudentWelcomePage studentWelcomePage;
	int testResultScoreValue;
	

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		//getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();		

	}
	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL_004_ReadSentencesGoalRecordingfastPace(){
		/*Student3.LevelOption=Level 1
				Student3.UnitOption=Unit 4
				Student3.LessonOption=Read Sentences
				Student3.RecordingRequired=YES*/
		//Pre-condition
		newStudents = llloginPage.createStudents(llloginPage,
				llData.student3LevelOption,
				llData.student3UnitOption,
				llData.student3LessonOption,
				llData.student3RecordingRequired);
		//Enter credentials for student user
		studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,newStudents[0],newStudents[0],  LLLoginReturnPage.STUD_WELCOME_PAGE);
		//verify welcome page of the student user
		studentWelcomePage.verifywelcomePage();
		//click continue button
		llactivity=studentWelcomePage.welcomeButton();		
		//verifies home page
		llactivity.verifyHomepage();
		//clicks start button to start reading passages
		llactivity.clickStartButton();		
		readSentencesGoalRecording=(ReadSentencesGoalRecordingPage) llactivity.clickContinueButtonOnWordTrainingPage(ReturnPage.READSENTENCESGOALRECORDING);		
		//To click on GATEWAY GOALS FIRST VIDEO window continue button
		readSentencesGoalRecording.clickContinueButtonOnGateWayGoalsVideoWindow();
		//To click on PASSAGE FLUENCY VIDEO window continue button
		readSentencesGoalRecording.clickContinueButtonOnPassageFluencyVideoWindow();
		//To verify that ready to start pop-up is displayed
		readSentencesGoalRecording.verifyReadyToStartWindowHeaderText();
		//To click on start button on Ready To Start pop-up
		readSentencesGoalRecording.clickStartButtonOnReadyToStartWindow();
		//Verify navigation to read sentences section
		readSentencesGoalRecording.verifyNavigationToReadSentencesSection();
		//Read sentences and click next button
		readSentencesGoalRecording.verifySentencesAndClickNextForAllSentences();
		//Verify the navigation to Select the correct word to complete the sentences.
		readSentencesGoalRecording.verifyTheNavigationToSelectTheCorrectWordSection();
		//Click continue button under 'Select the correct word to complete the sentences' section
		readSentencesGoalRecording.clickOnContinueButtonOnSelectTheCorrectWordSection();
		//To verify that ready to start pop-up is displayed
		readSentencesGoalRecording.verifyReadyToStartWindowHeaderText();
		//To click on start button on Ready To Start pop-up
		readSentencesGoalRecording.clickStartButtonOnReadyToStartWindow();
		//To verify the navigation to fill in the blanks section
		readSentencesGoalRecording.verifyNavigationToFillInTheBlanksSection();
		//To fill in the blanks for the sentences
		readSentencesGoalRecording.fillInTheBlanksForAllSentences();
		//Verify the navigation to 'Read along and listen to the model until you are ready to make a recording.'
		readSentencesGoalRecording.verifyNavigationReadAlongAndListenSection();
		//Click continue button  
		readSentencesGoalRecording.clickContinueButtonUnderReadAlongAndListenSection();
		//To verify that ready to start pop-up is displayed
		readSentencesGoalRecording.verifyReadyToStartWindowHeaderText();
		//To click on start button on Ready To Start pop-up
		readSentencesGoalRecording.clickStartButtonOnReadyToStartWindow();
		//Click next button for the sentences with speaker icons
		readSentencesGoalRecording.verifySentencesAndClickNextForAllSentences();
		//Verifies navigation to 'You are ready to take the test' section
		readSentencesGoalRecording.verifyNavigationToYouAreReadyToTakeTheTestSection();
		//Clicks continue button on 'You are ready to take the test' section
		readSentencesGoalRecording.clickContinueButtonUnderYouAreReadyToTakeTheTestSection();
		//To setup the microphone settings(or to click Allow button of microphone alert)
		readSentencesGoalRecording.microPhoneSetUp(llData);	
		//To verify navigation to 'Ready to record' window or pop-up
		readSentencesGoalRecording.verifyReadyToRecordWindowHeaderText();
		//To click start button on 'Ready to record' window or pop-up
		readSentencesGoalRecording.clickStartButtonOnReadyToRecordWindow();
		//To verify navigation to microphone recording section
		readSentencesGoalRecording.verifyNavigationToMicroPhoneRecordingPopUp();
		//Wait until microphone recording is complete for all sentences
		readSentencesGoalRecording.verifyRecordingOfTheSentences();
		//To verify navigation to 'Review your recording' window or pop-up
		readSentencesGoalRecording.verifyReviewYourRecordingsWindowHeaderText();		
		//To click start button on 'Review your recording' window or pop-up
		readSentencesGoalRecording.clickStartButtonOnReviewYourRecordingsWindow();
		//To verify navigation to Grading Sentences page
		readSentencesGoalRecording.verifyNavigationToGradingSentencesSection();
		//To grade the sentences
		readSentencesGoalRecording.gradeTheSentences(0);
		//To verify navigation to Test Results section
		readSentencesGoalRecording.verifyNavigationToTestResultsSection();
		//To retrieve score value from 'Test Results' section
		testResultScoreValue=readSentencesGoalRecording.retrieveTheTestResultsScoreValue();
		//To click continue button under 'Test Results' section
		readSentencesGoalRecording.clickContinueButtonUnderTestResultsSection();	
		//To verify the navigation to attempt summary section
		readSentencesGoalRecording.verifyNavigationToAttemptSummarySection();
		//To compare test results score with attempt summary score
		readSentencesGoalRecording.verifyTestResultAndAttemptSummaryScores(testResultScoreValue);
		//To click continue button under attempt summary section
		readSentencesGoalRecording.clickContinueButtonOfAttemptSummarySection();
		//To verify navigation to submit for feedback section
		readSentencesGoalRecording.verifyNavigationToSubmitForFeedBackSection();
		//To click submit for feedback button
		readSentencesGoalRecording.clickSubmitForFeedbackButton();
		//To verify navigation to your recording has been submitted for feed back section
		readSentencesGoalRecording.verifyNavigationToFeedbackSubmittedSection();
		//To click continue button under your recording has been submitted for feedback section
		readSentencesGoalRecording.clickContinueUnderFeedbackSubmittedSection();
		readSentencesGoalRecording.clickLogoutfromActivty();
		readSentencesGoalRecording.verifyLoginPage();
	}

@Test(groups = { "RC" }, priority = 1, retryAnalyzer = Retry.class)
public void LL_004_ReadSentencesGoalRecordingSlowPace(){
	/*Student3.LevelOption=Level 1
			Student3.UnitOption=Unit 4
			Student3.LessonOption=Read Sentences
			Student3.RecordingRequired=YES*/
	//Pre-condition
	newStudents = llloginPage.createStudents(llloginPage,
			llData.student3LevelOption,
			llData.student3UnitOption,
			llData.student3LessonOption,
			llData.student3RecordingRequired);
	//Enter credentials for student user
	studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,newStudents[0],newStudents[0],  LLLoginReturnPage.STUD_WELCOME_PAGE);
	//verify welcome page of the student user
	studentWelcomePage.verifywelcomePage();
	//click continue button
	llactivity=studentWelcomePage.welcomeButton();		
	//verifies home page
	llactivity.verifyHomepage();
	//clicks start button to start reading passages
	llactivity.clickStartButton();		
	readSentencesGoalRecording=(ReadSentencesGoalRecordingPage) llactivity.clickContinueButtonOnWordTrainingPage(ReturnPage.READSENTENCESGOALRECORDING);		
	//To click on GATEWAY GOALS FIRST VIDEO window continue button
	readSentencesGoalRecording.clickContinueButtonOnGateWayGoalsVideoWindow();
	//To click on PASSAGE FLUENCY VIDEO window continue button
	readSentencesGoalRecording.clickContinueButtonOnPassageFluencyVideoWindow();
	//To verify that ready to start pop-up is displayed
	readSentencesGoalRecording.verifyReadyToStartWindowHeaderText();
	//To click on start button on Ready To Start pop-up
	readSentencesGoalRecording.clickStartButtonOnReadyToStartWindow();
	//Verify navigation to read sentences section
	readSentencesGoalRecording.verifyNavigationToReadSentencesSection();
	//Read sentences and click next button
	readSentencesGoalRecording.verifySentencesAndClickNextForAllSentences();
	//Verify the navigation to Select the correct word to complete the sentences.
	readSentencesGoalRecording.verifyTheNavigationToSelectTheCorrectWordSection();
	//Click continue button under 'Select the correct word to complete the sentences' section
	readSentencesGoalRecording.clickOnContinueButtonOnSelectTheCorrectWordSection();
	//To verify that ready to start pop-up is displayed
	readSentencesGoalRecording.verifyReadyToStartWindowHeaderText();
	//To click on start button on Ready To Start pop-up
	readSentencesGoalRecording.clickStartButtonOnReadyToStartWindow();
	//To verify the navigation to fill in the blanks section
	readSentencesGoalRecording.verifyNavigationToFillInTheBlanksSection();
	//To fill in the blanks for the sentences
	readSentencesGoalRecording.fillInTheBlanksForAllSentences();
	//Verify the navigation to 'Read along and listen to the model until you are ready to make a recording.'
	readSentencesGoalRecording.verifyNavigationReadAlongAndListenSection();
	//Click continue button  
	readSentencesGoalRecording.clickContinueButtonUnderReadAlongAndListenSection();
	//To verify that ready to start pop-up is displayed
	readSentencesGoalRecording.verifyReadyToStartWindowHeaderText();
	//To click on start button on Ready To Start pop-up
	readSentencesGoalRecording.clickStartButtonOnReadyToStartWindow();
	//Click next button for the sentences with speaker icons
	readSentencesGoalRecording.verifySentencesAndClickNextForAllSentences();
	//Verifies navigation to 'You are ready to take the test' section
	readSentencesGoalRecording.verifyNavigationToYouAreReadyToTakeTheTestSection();
	//Clicks continue button on 'You are ready to take the test' section
	readSentencesGoalRecording.clickContinueButtonUnderYouAreReadyToTakeTheTestSection();
	//To setup the microphone settings(or to click Allow button of microphone alert)
	readSentencesGoalRecording.microPhoneSetUp(llData);	
	
	readSentencesGoalRecording.readsentencesTest(6);
	
	readSentencesGoalRecording.clickLogoutfromHomePage();
	readSentencesGoalRecording.verifyLoginPage();
}
}