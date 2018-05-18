package com.testsuite.ll.uniquegoals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.goals.SpellWordsGoalPage;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.StudentCreation;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.page.module.ll.level1activities.LLActivity.ReturnPage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class SpellWordsGoal extends BaseSetup {
	LLData llData;
	LLLoginPage llloginPage;
	LLActivity llactivity;
	TeacherHomePage teacherHomePage;
	StudentCreation studentCreation;
	SpellWordsGoalPage spellwords;
	private StudentWelcomePage studentWelcomePage;
	String[] newStudents;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() throws Exception {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();
	}

	@Test(groups = { "RC"}, priority = 1, retryAnalyzer = Retry.class)
	public void LL_005_SpellWords() {
		// Step1: Prerequsite: Login with teacher & Create a student in Level
		// and set data to Unit1- Spell Words goal
		newStudents = llloginPage.createStudents(llloginPage, llData.LL005_Goals_Student_Level,
			llData.LL005_Goals_Student_Unit, llData.LL005_Goals_Student_Goal,
				llData.LL005_Goals_Student_Recording_Need);
		// Step2: Login with student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL, newStudents[0],
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
		spellwords = (SpellWordsGoalPage) llactivity.clickContinueButtonOnWordTrainingPage(ReturnPage.SPELL_WORDS);
		// Step7: Verify two goal videos
		spellwords.verifyGoalVideos();
		//Compete spellwords goal
		spellwords.spellWordsGoalInSlowPace();
		//Step 17: Logout from application 
		spellwords.clickLogoutfromHomePage();
		//Step 18: Verify Login Page
		spellwords.verifyLoginPage();
	}

}
