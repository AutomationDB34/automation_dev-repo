package com.testsuite.ll.uniquegoals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.goals.SentenceCompletionGoalPage;
import com.page.module.ll.goals.SpellWordsGoalPage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLActivity.ReturnPage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;

public class SentenceCompletionGoal extends BaseSetup {
	LLLoginPage llloginPage;
	LLData llData;
	private StudentWelcomePage studentWelcomePage;
	private LLActivity llactivity;
	SentenceCompletionGoalPage sentenceCompletion;
	
	@BeforeMethod(alwaysRun=true)
	public void BaseclassSetUP() throws Exception{
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();
	}
	
	@Test(priority=1, groups={"RC"})
	public void LL_008_SentenceCompletion() {
		
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
		sentenceCompletion = (SentenceCompletionGoalPage) llactivity.clickContinueButtonOnWordTrainingPage(ReturnPage.SENTENCE_COMPLETION);
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
		
		}
		
}
