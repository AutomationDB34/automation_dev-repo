package com.testsuite.ll.uniquegoals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.goals.SaySoundsGoalPage;
import com.page.module.ll.goals.StressedSyllablesGoalPage;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.StudentCreation;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLActivity.ReturnPage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class StressedSyllablesGoalActions extends BaseSetup
{
	LLData llData;
	LLLoginPage llloginPage;
	LLActivity llactivity;
	TeacherHomePage teacherHomePage;
	StudentCreation studentCreation;
	StudentWelcomePage studentWelcomePage;
	StressedSyllablesGoalPage stressedSylabPage;


	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();		

	}

	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL_006_Goals_StressedSyllablesGoalActions()
	{
		/*	Student2.LevelOption=Level 2
		Student2.UnitOption=Unit 5
		Student2.LessonOption= Stressed Syllables 
		Student2.RecordingRequired=YES*/
		//Step1: Loggin With Teacher Credentials and Create a student Precondition to create students
		String newStudents[] = llloginPage.createStudents(llloginPage,
				llData.LL006_Goals_Student_Level,
				llData.LL006_Goals_Student_Unit,
				llData.LL006_Goals_Student_Lession,
				llData.LL006_Goals_Student_Recording_Need);
		//String newStudents[] = {"ID1456725557183"};
		//Step2: Login with th new student Credentials.
		studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,newStudents[0],newStudents[0],LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step3: Verify the Wel come Page
		studentWelcomePage.verifywelcomePage();
		//Step4: Click Continue on welcome page and verify the home page.
		llactivity=studentWelcomePage.welcomeButton();		
		llactivity.verifyHomepage();
		//Step5: Click On Word Training Start Button on Say Sounds Page
		llactivity.clickStartButton();
		//Step6: Click On Word Training Continue page
		stressedSylabPage = (StressedSyllablesGoalPage) llactivity.clickContinueButtonOnWordTrainingPage(ReturnPage.STRESSED_SYLLABLES);
		//Step7: Click on continue on gateWay Goals Video Window
		stressedSylabPage.clickContinueButtonOnGateWayGoalsVideoWindow();
		//Step8: Click on continue on Say Sounds video window
		stressedSylabPage.clickContinueButtonOnStressSyllablesVideoWindow(); 
		//Step9:Verify the Ready To start Test headder`
		stressedSylabPage.verifyReadyToWindow(llData.Goal_ReadyToStartTest);
		//Step10:Click on Start Button
		stressedSylabPage.clickOnStartButton();
		//Stress11: Play the audio of Option1 and Option2
		stressedSylabPage.clickPlayAudioOption1();
		stressedSylabPage.clickPlayAudioOption2();
		//Stress12: Based on the audio press on rights answer
		stressedSylabPage.clickOnAnswerRadioButton();
		//Step13: Repeat the Steps 11 and 12 until u reach the last page
		stressedSylabPage.repeatStepsToCompleteTest();
		//Step14: Click On continue button on Review your questions
		stressedSylabPage.clickContinueButtonOnReviewErrors();
		//Step15:Verify the Ready To start Test headder
		stressedSylabPage.verifyReadyToWindow(llData.Goal_ReadyToReviewText);
		//Step16:Click on Start Button
		stressedSylabPage.clickOnStartButton();
		//Step17: Click On continue button on Listen to the words below. 
		stressedSylabPage.clickContinueOnListenBelow();
		//Step18: Drag the word in box and drop it in Noun/Verb
		stressedSylabPage.dragAndDropTheWordToNoun(isIexploreBrowser());
		//Step19: Click Next Button on Review
		stressedSylabPage.clickNextButtonOnReview();
		//Step20: repeat the steps Step18 and 19 until you complete the Review
		stressedSylabPage.repeatReviewSteps();
		//Step21: Click Continue button On "Please retake the test to earn a trophy." Page. Parameter is Attempt Count
		stressedSylabPage.clickContinueOnRetakeTest();
		//Step22:Repeat the steps From Step9 to Step21 untill u earn a trhopy 
		stressedSylabPage.repeatStepsToCompleteGoal();	
		//Step23: log out from application
		stressedSylabPage.clickLogoutfromActivty();
		stressedSylabPage.verifyLoginPage();
	}

}
