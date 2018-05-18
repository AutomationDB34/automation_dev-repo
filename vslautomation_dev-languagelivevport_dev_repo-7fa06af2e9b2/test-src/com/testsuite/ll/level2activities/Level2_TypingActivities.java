package com.testsuite.ll.level2activities;

import java.awt.AWTException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLActivity.ActivityType;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.level2activities.AddingSuffixes;
import com.page.module.ll.level2activities.BreakingWords;
import com.selenium.Sync;
import com.testng.Retry;

public class Level2_TypingActivities extends BaseSetup {
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private BreakingWords breakingWords;
	private AddingSuffixes addingSuffixes;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();
	}

	/**
	 * Purpose is to do a quick check of the Breaking words activity
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "RC","QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL018_Level2_BreakingWords()
	{
		//Step1: Login to LL with a valid student credentials
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.breakingwordsstudent,
				llData.breakingwordsstudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2: Verify welcome page and click on continue button
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		//Step3: Verify Home Page
		llactivity.verifyHomepage();
		//Step4: Select bundle (from Short cut menu) for QC as "BreakingWords: dragging", For RC "BreakingWords: planning"
		breakingWords = (BreakingWords) llactivity.bundleSelector(46, isIexploreBrowser(), ActivityType.BREAKING_WORDS,
				llData, executionMode);
		//Step5: verify the Breaking words Activity page
		breakingWords.verifyBreakingWordsActivity();
		//Step6: Verify the Audio Functionality
		breakingWords.verifyAudioFunctiionality();
		//Step7: Type the answer in all the given text areas and click on check it button. Repeat this to complete all the bundles
		breakingWords.breakingWords();
		//Step8: Click on activity user drop down
		breakingWords.navigateToHomePagefromActivity();
		//Step9: Click on logout link in the drop down
		breakingWords.clickLogoutfromHomePage();
		//Step10: Verify the Login Page
		breakingWords.verifyLoginPage();
	}

	/**
	 * Purpose is to do a quick check of the Adding suffixes activity
	 */
	@Test(groups = { "RC","QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL020_Level2_addingSuffixes()
	{
		//Follow the steps 1 to 3 from LL_018_BreakingWords
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.addingsuffixesstudent,
				llData.addingsuffixesstudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step4: Select bundle (from Short cut menu) for QC as "AddingSuffixes: blurred", For RC "AddingSuffixes: spotted"
		addingSuffixes = (AddingSuffixes) llactivity.bundleSelector(48, isIexploreBrowser(),
				ActivityType.ADDING_SUFFIXES, llData, executionMode);
		//Step5: Verify the Audio Functionality
		addingSuffixes.verifyAduioBarFunctionality();
		//Step6: Click on double it button and then type the answer text box and then click on Check it button to verify the answer. repeat this to reach summery page in RC mode
		addingSuffixes.AddingSuffixes(executionMode);
		//Step7: Verify the summary page and click on continue button
		addingSuffixes.addingSuffixesSummary();
		//Step8: Mouse over on course drop down and then click on log out link
		addingSuffixes.clickLogoutfromActivty();
		addingSuffixes.verifyLoginPage();
	}
}
