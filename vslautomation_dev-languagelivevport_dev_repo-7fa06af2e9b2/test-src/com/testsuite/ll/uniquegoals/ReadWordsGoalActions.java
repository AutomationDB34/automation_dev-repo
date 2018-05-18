
package com.testsuite.ll.uniquegoals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.goals.ReadWordsPage;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.StudentCreation;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLActivity.ReturnPage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class ReadWordsGoalActions extends BaseSetup {

	LLData llData;
	LLLoginPage llloginPage;
	LLActivity llactivity;
	TeacherHomePage teacherHomePage;
	StudentCreation studentCreation;
	StudentWelcomePage studentWelcomePage;
	ReadWordsPage readWordsPage;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception 
	{
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();		

	}


	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL_007_Goals_ReadWordsGoal()
	{
		/*	Student2.LevelOption=Level 1
		Student2.UnitOption=Unit 1
		Student2.LessonOption= Read Words
		Student2.RecordingRequired=YES*/
		//Precondition to create students
		String newStudents[] = llloginPage.createStudents(llloginPage,
				llData.LL007_Goals_Student_Level,
				llData.LL007_Goals_Student_Unit,
				llData.LL007_Goals_Student_Lession,
				llData.LL007_Goals_Student_Recording_Need);
		//Step2: Login with th new student Credentials.
		studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,newStudents[0],newStudents[0],LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step3: Verify the Wel come Page
		studentWelcomePage.verifywelcomePage();
		//Step4: Click Continue on welcome page and verify the home page.
		llactivity=studentWelcomePage.welcomeButton();		
		llactivity.verifyHomepage();
		//Step5: Click On Word Training Start Button on Read Words Goal
		llactivity.clickStartButton();
		//Step6: Click On Word Training Continue page
		readWordsPage = (ReadWordsPage) llactivity.clickContinueButtonOnWordTrainingPage(ReturnPage.READ_WORDS);
		//Step7: Click on continue on gateWay Goals Video Window
		readWordsPage.clickContinueButtonOnGateWayGoalsVideoWindow();
		//Step8: Click on continue on Read Words video window
		readWordsPage.clickContinueButtonOnSaySoundsVideoWindow();
		//Step9: verify Ready To start text on header
		readWordsPage.verifyReadyToWindow(llData.Goal_ReadyToStartText);
		//Step10: click on start button on Ready To  window
		readWordsPage.clickOnStartButton();
		//Step11: Follow the Audio and click on the right answer.Displayed in grid View
		readWordsPage.clickOnPracticeAnswers();
		//Step12: Click On Continue on Review Errors Page
		readWordsPage.clickOnContinueOnReviewYourErrorsPage();
		//Step13: Verify the Ready to Review Headder
		readWordsPage.verifyReadyToWindow(llData.Goal_ReadyToReviewText);
		//Step14: Click on Start Button On Review
		readWordsPage.clickReviewStartButton();
		//Step15:Click Continue button on Listen to the Phonemes below
		readWordsPage.clickContinueOnListenWords();
		//Step16: Click the each letter displayed in Grid by listening it individual.And then Click On NExt Button once after completing the word.And Click on Contiue button
		readWordsPage.clickNextOnWrongAnswersAudioPage();
		readWordsPage.clcikContinueButoon();
		//Step17: Click ON cONTINUE on Start Untimed Practice
		readWordsPage.clickOnContinueOnReviewYourErrorsPageOnUntimed();
		//Step18: Repeat the Steps From 9 to 17
		readWordsPage.repeatPracticeSteps(llData.Goal_ReadyToStartText,llData.Goal_ReadyToReviewText);
		//Step19: Click On Continue on Review Errors Page
		readWordsPage.clickOnContinueOnReviewYourErrorsPage();
		//Step20: verify Ready To preview window header text
		readWordsPage.verifyReadyToWindow(llData.Goal_ReadyToSpeak);
		//Step21: click on start button on Ready To  window
		readWordsPage.clickOnStartButton();
		//Step22: Review your answer and Click on the Grade symbol.(This is in slow Pace)
		readWordsPage.clickOnGradeThumbsUpAndDown();
		//Step23: Click On Continue on Review Errors Page
		readWordsPage.clickOnContinueOnReviewYourErrorsPage();
		//Step24: Click On Continue on Review Errors Page
		readWordsPage.clickOnContinueOnReviewYourErrorsPage();
		//Step25: Verify the Ready to Review Headder
		readWordsPage.verifyReadyToWindow(llData.Goal_ReadyToReviewText);
		//Step26; Click on start button
		readWordsPage.clickOnStartButton();
		//Step27: Click On Continue on Review Errors Page
		readWordsPage.clickOnContinueOnReviewYourErrorsPage();
		//Step28: Click the each letter displayed in Grid by listening it individual.And then Click On NExt Button once after completing the word.
		readWordsPage.clickNextOnWrongAnswersAudioPage();
		//Step29: Click On Continue on Review Errors Page
		readWordsPage.clickContinueOnRetakeTest();
		//Step30: Repeat the steps from Step19 to Step29
		readWordsPage.recordSoundsInSlowPace(llData.Goal_ReadyToReviewText,llData.Goal_ReadyToSpeak,llData.Goal_Reviewyourrecordings);
		//Step31: log Out from the activity
		readWordsPage.clickLogoutfromActivty();
		readWordsPage.verifyLoginPage();
	}
}
