
package com.testsuite.ll.uniquegoals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.goals.SaySoundsGoalPage;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.StudentCreation;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLActivity.ReturnPage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class SaySoundsGoalActions extends BaseSetup {

	LLData llData;
	LLLoginPage llloginPage;
	LLActivity llactivity;
	TeacherHomePage teacherHomePage;
	StudentCreation studentCreation;
	StudentWelcomePage studentWelcomePage;
	SaySoundsGoalPage saySoundsPage;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();		

	}


	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL_001_Goals_SaySoundsGoalRecording(){
		/*	Student2.LevelOption=Level 1
		Student2.UnitOption=Unit 1
		Student2.LessonOption= Say Sounds
		Student2.RecordingRequired=YES*/
		//Precondition to create students
		String newStudents[] = llloginPage.createStudents(llloginPage,
				llData.LL001_Goals_Student_Level,
				llData.LL001_Goals_Student_Unit,
				llData.LL001_Goals_Student_Lession,
				llData.LL001_Goals_Student_Recording_Need);
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
		saySoundsPage = (SaySoundsGoalPage) llactivity.clickContinueButtonOnWordTrainingPage(ReturnPage.SAYSOUNDSGOAL);
		//Step7: Click on continue on gateWay Goals Video Window
		saySoundsPage.clickContinueButtonOnGateWayGoalsVideoWindow();
		//Step8: Click on continue on Say Sounds video window
		saySoundsPage.clickContinueButtonOnSaySoundsVideoWindow();
		//Step9: verify Ready To preview window header text
		saySoundsPage.verifyReadyToWindow(llData.Goal_ReadyToStartText);
		//Step10: click on start button on Ready To  window
		saySoundsPage.clickOnStartButton();
		//Step11: Follow the Audio and click on the right answer.Displayed in grid View
		saySoundsPage.clickOnPracticeAnswers();
		//Step12: Click On Continue on Review Errors Page
		saySoundsPage.clickOnContinueOnReviewYourErrorsPage();
		//Step13: Verify the Ready to Review Headder
		saySoundsPage.verifyReadyToWindow(llData.Goal_ReadyToReviewText);
		//Step14: Click on Start Button On Review
		saySoundsPage.clickReviewStartButton();
		//Step15:Click Continue button on Listen to the Phonemes below
		saySoundsPage.clicContinueOnListenPhonemes();
		//Step16: Click next button and complete the review 
		saySoundsPage.clickNextOnWrongAnswersAudioPage();
		//Step17: Click ON cONTINUE on Start Untimed Practice
		saySoundsPage.clcikContinueButoon();
		//Step18: repeat the Steps Step9 to Step17 until you reach the Goal test
		saySoundsPage.repeatThePractiseSteps(llData.Goal_ReadyToStartText, llData.Goal_ReadyToReviewText);
		//Step19: Accept the Micro Phone 
		saySoundsPage.microPhoneSetUp(llData);
		//Step20: verify Ready To preview window header text
		saySoundsPage.verifyReadyToWindow(llData.Goal_ReadyToRecordText);
		//Step21: click on start button on Ready To  window
		saySoundsPage.clickStartReadyToRecord();
		//Step22: Record your answers
		saySoundsPage.recordTheDsplayedLetter();
		saySoundsPage.verifyReadyToWindow(llData.Goal_Reviewyourrecordings);
		//Step23; Click on start button
		saySoundsPage.clickOnStartButton();
		//Step24: Review your answer and Click on the Grade symbol.(This is in slow Pace)
		saySoundsPage.clickOnGradeThumbsUpAndDown();
		//Step25: Click On Continue on Review Errors Page
		saySoundsPage.clickOnContinueOnReviewYourErrorsPage();
		//Step26: Repeat the steps from Step20 to Step25
		saySoundsPage.recordSoundsInSlowPace(llData.Goal_ReadyToReviewText,llData.Goal_ReadyToRecordText,llData.Goal_Reviewyourrecordings);
		//Step26: log Out from the activity
		saySoundsPage.clickLogoutfromActivty();
		saySoundsPage.verifyLoginPage();
	}
}
