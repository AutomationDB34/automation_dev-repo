package com.testsuite.ll.uniquegoals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.goals.FluencyCheckGoalRecordingPage;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.StudentCreation;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLActivity.ReturnPage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class FluencyCheckGoalRecordingActions extends BaseSetup{

	LLData llData;
	LLLoginPage llloginPage;
	LLActivity llactivity;
	TeacherHomePage teacherHomePage;
	StudentCreation studentCreation;
	int myScoreValue;	
	String[] newStudents;
	private FluencyCheckGoalRecordingPage fluencyCheckGoalRecording;
	private StudentWelcomePage studentWelcomePage;
	
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		//getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();		
		
	}
	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL_003_FluencyCheckGoalRecording(){
	/*	Student2.LevelOption=Level 2
				Student2.UnitOption=Unit 3
				Student2.LessonOption=Fluency Check
				Student2.RecordingRequiredd=YES*/
		//Precondition to create students
		newStudents = llloginPage.createStudents(llloginPage,
				llData.student2LevelOption,
				llData.student2UnitOption,
				llData.student2LessonOption,
				llData.student2RecordingRequired);		
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
		fluencyCheckGoalRecording=(FluencyCheckGoalRecordingPage) llactivity.clickContinueButtonOnWordTrainingPage(ReturnPage.FLUENCYCHECKGOALRECORDING);		
		//To click on GATEWAY GOALS FIRST VIDEO window continue button
		fluencyCheckGoalRecording.microPhoneSetUp(llData);
		//verify navigation to 'Ready to Start Recording' pop-up
		fluencyCheckGoalRecording.verifyNavigationToReadyToStartRecordingPopup();
		//click start button on 'Ready to Start Recording' pop-up
		fluencyCheckGoalRecording.clickStartButtonOnReadyToStartRecordingPopup();
		//Verify navigation to fluency check passage reading content
		fluencyCheckGoalRecording.verifyNavigationToFluencyPassageReadingPopup();
		//click stop recording button on fluency check passage reading content
		fluencyCheckGoalRecording.clickStopRecordingButtonOnFluencyPassageReading();
		//Verify navigation to Ready to Upload your recording pop-up
		fluencyCheckGoalRecording.verifyNavigationToReadyToUploadYourRecordingPopup();
		//Click start button on 'Ready to upload your recording' popup
		fluencyCheckGoalRecording.clickStartButtonOnReadyToUploadRecordingPopup();
		//To verify that click on the last word you read pop-up is displayed
		fluencyCheckGoalRecording.verifyNavigationToClickOnTheLastWordYouReadPopup();
		//To click start button on the last word you read pop-up 
		fluencyCheckGoalRecording.clickStartButtonOnLastWordYouReadPopup();
		//Verify navigation to last word you read passage content
		fluencyCheckGoalRecording.verifyTheNavigationToLastWordYouReadPassageContent();
		//Select a word under passage section
		fluencyCheckGoalRecording.clikOnSomeLastWrodsYouRead();
		//To click on continue button on last word you read passage section
		fluencyCheckGoalRecording.clickContinueButtonOnLastWordYouReadPopup();
		//To verify navigation to test results window
		fluencyCheckGoalRecording.verifyNavigationToTestResultsWindow();
		//To retrieve fluency check reading score value from test results summary section
		myScoreValue=fluencyCheckGoalRecording.retriveMyScoreValueFromTestResultsWindow();
		//To click submit recording button on test results section
		fluencyCheckGoalRecording.clickSubmitRecordingButtonOnTestResultsWindow();
		//To verify that your recording has been received message being displayed
		fluencyCheckGoalRecording.verifyThatYourRecordingHasBeenReceivedMessageDisplayed();
		//To click continue button on your recording has been received message window
		fluencyCheckGoalRecording.clickContinueButtonOnRecordingHasBeenSubmittedWindow();		
		//To verify that, 'Word Per Minute Progress' window is displayed
		fluencyCheckGoalRecording.verifyNavigationToWordPerMinuteProgressWindow();
		//To verify that my score value displayed under 'Words Per Minute Progress' chart is same as the score value displayed on 'Test Results' section
		fluencyCheckGoalRecording.verifyMyScoreValueInTheProgressChartWindow(myScoreValue);
		//To click continue button on 'Words Per Minute Progress' window
		fluencyCheckGoalRecording.clickContinueButtonOnWordPerMinuteProgressWindow();	
		fluencyCheckGoalRecording.clickLogoutfromActivty();
		fluencyCheckGoalRecording.verifyLoginPage();
	}	
}
