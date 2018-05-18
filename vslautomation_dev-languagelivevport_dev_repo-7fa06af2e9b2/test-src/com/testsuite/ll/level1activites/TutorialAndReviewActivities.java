package com.testsuite.ll.level1activites;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.ListenAndIdentifyKeyword;
import com.page.module.ll.level1activities.MatchPhonemeToGrapheme;
import com.page.module.ll.level1activities.PhonemeAndGrapheme;
import com.page.module.ll.level1activities.SoundLibrary;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLActivity.ActivityType;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class TutorialAndReviewActivities extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private PhonemeAndGrapheme phonemeAndGrapheme;
	private StudentWelcomePage studentWelcomePage;
	private ListenAndIdentifyKeyword listenAndIdentifyKeyword;
	private MatchPhonemeToGrapheme matchPhonemeToGrapheme;
	private SoundLibrary soundLibrary;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	@BeforeMethod(alwaysRun = true, timeOut = 1000000)
	public void BaseClassSetUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		
		
	}

	/**
	 * Purpose - To perform Quick check of phoneme And Grapheme introduction
	 * activity
	 * 
	 */
	@Test(groups = { "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL002_Level1_phonemeAndGrapheme(){
		//Step1: login to the LL Application  with student credentials. And Verify the Successful Login.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.tutorialActivityUN,
				llData.tutorialActivityUN, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		//Step2: Click on the WelCome Button
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Navigate/Select the Bundle named as 'PhonemeIntroduction: m' in Unit1 Lesson1.
		phonemeAndGrapheme = (PhonemeAndGrapheme) llactivity.bundleSelector(7, isIexploreBrowser(),
				ActivityType.PHONEME_AND_GRAPHEME, llData, executionMode);
		//Step4:Verify The Successful navigation of Activity
		phonemeAndGrapheme.verifyPhonemeActivity();
		//Step5: Click on the Reply Link
		phonemeAndGrapheme.clickReplayLink();
		//Step6: Click On Next Button
		phonemeAndGrapheme.clickNextBtn();
		//Step7: Verify the Letters displayed. and Click Next in Spelling
		phonemeAndGrapheme.verifyLetters();
		phonemeAndGrapheme.spellingStep();
		//Step8: Click Home Button/Link
		phonemeAndGrapheme.navigateToHomePagefromActivity();
		//Step9: Click Logout 
		phonemeAndGrapheme.clickLogoutfromHomePage();
		//Step10: Verify the login Page
		phonemeAndGrapheme.verifyLoginPage();
	}

	/**
	 * Purpose - To perform Quick check of listen And Identify Keyword activity
	 * 
	 */
	@Test(groups = { "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL003_Level1_listenAndIdentifyKeyword(){
		//Step1: login to the LL Application  with student credentials. And Verify the Successful Login.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.tutorialActivityUN,
				llData.tutorialActivityUN, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		//Step2: Click on the WelCome Button
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Navigate/Select the Bundle named as 'ListenAndIdentifyKeyword: t' in Unit1 Lesson1.(Select 'ListenAndIdentifyKeyword: t: m' for RC and repeat the steps step5 to step6 util summery page displays)
		listenAndIdentifyKeyword = (ListenAndIdentifyKeyword) llactivity.bundleSelector(3, isIexploreBrowser(),
				ActivityType.LISTEN_AND_IDENTIFY_KEYWORD, llData, executionMode);
		//Step4: Verify the Listen and Identify activity page and Follow the audio instructions.
		listenAndIdentifyKeyword.verifyListenAndIdentifyActivity();
		//Step5: Listen to the audio and identify the correct answer in displayed pictures and click on it.
		//Step6: Repeat the same until summary page displayed.
		listenAndIdentifyKeyword.listenAndIdentifyActivity();
		//Step7:  Click on logout button from the Mouse hover drop down at home/Course.
		listenAndIdentifyKeyword.clickLogoutfromActivty();
		//Step8: Verify the successful logout
		listenAndIdentifyKeyword.verifyLoginPage();
	}

	/**
	 * Purpose - To perform Quick check of match Phoneme To Grapheme activity
	 * 
	 */
	@Test(groups = { "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL004_Level1_matchPhonemeToGrapheme() {
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.tutorialActivityUN,
				llData.tutorialActivityUN, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Navigate/Select the Bundle named as 'MatchPhonemeToGrapheme: t' in Unit1 Lesson1.
		//(Select 'MatchPhonemeToGrapheme: s' for RC and repeat the steps step4 to step7 until summary page displays)
		matchPhonemeToGrapheme = (MatchPhonemeToGrapheme) llactivity.bundleSelector(4, isIexploreBrowser(),
				ActivityType.MATCH_PHONEME_GRAHEME, llData, executionMode);
		//Step4: Verify the match PhonemeToGrapheme activity loaded.
		matchPhonemeToGrapheme.verifyActivity();
		//Step5: Follow the audio instructions and click on a answer. Wait For the verification mark.
		matchPhonemeToGrapheme.MatchPtoGActivity();
		//Follow the steps step8 and step9 from LL_001
		matchPhonemeToGrapheme.clickLogoutfromActivty();
		matchPhonemeToGrapheme.verifyLoginPage();
	}

	/**
	 * Purpose - To perform Quick check of Sound Library
	 * 
	 */
	@Test(groups = { "QC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL005_Level1_soundLibrary() {
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.tutorialActivityUN,
				llData.tutorialActivityUN, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Navigate/Select the Bundle named as 'SoundLibrary: [Sound Library]' in Unit1 Lesson1.
		soundLibrary = (SoundLibrary) llactivity.bundleSelector(5, isIexploreBrowser(), ActivityType.SOUND_LIBRARY,
				llData, executionMode);
		//Step4: Verify the new Sound library Loaded.
		soundLibrary.verifyNewSoundLibModal(llData);
		//Step5: Click on Consonants tab.
		//Step6: Verify the Number of Consonants unlocked and Sounds, Spellings in library.
		soundLibrary.checkSoundLibrary();
		//Follow the steps step8 and step9 from LL_001
		soundLibrary.clickLogoutfromActivty();
		soundLibrary.verifyLoginPage();
	}


}