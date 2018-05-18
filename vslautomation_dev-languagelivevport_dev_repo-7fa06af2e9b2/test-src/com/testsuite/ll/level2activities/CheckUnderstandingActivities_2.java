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
import com.page.module.ll.level2activities.ClosedSyllable;
import com.page.module.ll.level2activities.CompoundWords;
import com.page.module.ll.level2activities.DoubleVowelIdentification;
import com.page.module.ll.level2activities.KeyConceptQuiz;
import com.page.module.ll.level2activities.PhraseSelection;
import com.page.module.ll.level2activities.StressedSyllables;
import com.selenium.Sync;
import com.testng.Retry;

public class CheckUnderstandingActivities_2 extends BaseSetup 
{
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private DoubleVowelIdentification doubleVowelIdentification;
	private CompoundWords compoundWords;
	private ClosedSyllable closedSyllable;
	private PhraseSelection phraseSelection;
	private KeyConceptQuiz keyconceptquiz;
	private StressedSyllables stressedSyllables;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();

	}

	/**
	 * purpose - is to do quick check of Key concept Quiz activity
	 */
	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class )
	public void LL002_Level2_keyconceptQuiz()
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.CheckUnderstandingstudent1, llData.CheckUnderstandingstudent1,
				LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2:Verify The Wel Come and click on welcome button and verify home Page 
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Select the bundle "KeyConceptQuiz: 5 questions" (For QC and RC Same bundle need to select)
		keyconceptquiz = (KeyConceptQuiz) llactivity.bundleSelector(30, isIexploreBrowser(),
				ActivityType.KEY_CONCEPT_QUIZ, llData, executionMode);
		//Step4: Verify the key concepts Activity and Audio bar
		keyconceptquiz.verifyKeyConceptquizActivity(); 
		keyconceptquiz.verifyAudioBarFunctionality();
		//Step5: Click on True button until you reach last bundle
		keyconceptquiz.keyConceptQuiz();
		//Step6: Verify the key concept quiz summery page
		keyconceptquiz.keyConceptQuizSummary();
		//Step7: Navigate to home page from activity and log out from the application
		keyconceptquiz.navigateToHomePagefromActivity();
		keyconceptquiz.clickLogoutfromHomePage();
		keyconceptquiz.verifyLoginPage();
	}

	/**
	 * Purpose is to quick check of the Closed Syllable activity  
	 */
	@Test(groups = {"RC", "QC"}, priority = 2, retryAnalyzer = Retry.class)
	public void LL007_Level2_ClosedSyllable() 
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.closedSyllableStudent, llData.closedSyllableStudent,
				LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2:Verify The Wel Come and click on welcome button and verify home Page 
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Select the bundle For QC "ClosedSyllable: chat" and RC "ClosedSyllable: fish"
		closedSyllable = (ClosedSyllable) llactivity.bundleSelector(34, isIexploreBrowser(), ActivityType.CLOSED_SYLLABLE,
				llData, executionMode);
		//Step5: Click on correct tile displayed
		//Step6: repeat step5 until u reach last bundle
		closedSyllable.closedSyllable();
		//Step7: Navigate to home page from activity and log out from the application
		closedSyllable.navigateToHomePagefromActivity();
		closedSyllable.clickLogoutfromHomePage();
		closedSyllable.verifyLoginPage();
	}

	/**
	 * Purpose is to do quick check of Compound Words activity

	 */
	@Test(groups = { "RC", "QC"}, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL013_Level2_CompoundWords()
	{
		//"Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage)
				llloginPage.loginCredentials(llData.URL,llData.CheckUnderstandingstudent2 , llData.CheckUnderstandingstudent2, LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2:Verify The Wel Come and click on welcome button and verify home Page 
		studentWelcomePage.verifywelcomePage(); 
		llactivity = studentWelcomePage.welcomeButton(); 
		llactivity.verifyHomepage();
		//Step3: Select the bundle For QC ""CompoundWords: sandbag"" and RC ""CompoundWords: sandbox""
		compoundWords = (CompoundWords) llactivity.bundleSelector(40, isIexploreBrowser(), ActivityType.COMPOUND_WORDS,
				llData, executionMode);
		//Step4: Click on correct tile displayed
		//Step5: repeat step4 until u reach last bundle
		compoundWords.CompundWords(isIexploreBrowser(),executionMode);
		//Step6: Navigate to home page from activity and log out from the application"
		compoundWords.navigateToHomePagefromActivity();
		compoundWords.clickLogoutfromHomePage();
		compoundWords.verifyLoginPage();
	}

	/**
	 * Purpose is to do quick check of Double vowel identification activity
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "RC", "QC" }, priority = 4, retryAnalyzer = Retry.class)
	public void LL011_Level2_DoubleVowelIdentification()
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage)
				llloginPage.loginCredentials(llData.URL,llData.CheckUnderstandingstudent3 , llData.CheckUnderstandingstudent3,LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2:Verify The Wel Come and click on welcome button and verify home Page 
		studentWelcomePage.verifywelcomePage(); 
		llactivity = studentWelcomePage.welcomeButton(); 
		llactivity.verifyHomepage();
		//Step3: Select the bundle For QC ""DoubleVowelIdentification: tablet"" and RC ""DoubleVowelIdentification: discuss""
		doubleVowelIdentification = (DoubleVowelIdentification) llactivity.bundleSelector(38, isIexploreBrowser(),
				ActivityType.DOUBLE_VOWEL_IDENTIFICATION, llData, executionMode);
		//Step4: verify doubble identification Activity and audio bar
		doubleVowelIdentification.verifyDoubleVowelIdentificationActivity();
		doubleVowelIdentification.verifyAudioBarFunctionality();
		//Step5: Click on two vowels and then check it button
		//Step6: Repeat step5 until you reach last bundle (RC mode)
		doubleVowelIdentification.doubleVowelIdentification(executionMode);
		//Step7: Verify the Summery of double vowel identification
		doubleVowelIdentification.doubleVowelIdentificationSummary();
		//Step8: Navigate to home page from activity and log out from the application
		doubleVowelIdentification.navigateToHomePagefromActivity();
		doubleVowelIdentification.clickLogoutfromHomePage();
		doubleVowelIdentification.verifyLoginPage();
	}

	/**
	 * Purpose is to do a quick check of the stressed syllables activity
	 */
	@Test(groups = { "RC", "QC" }, priority = 5, retryAnalyzer = Retry.class)
	public void LL017_Level2_StressedSyllables()
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage)
				llloginPage.loginCredentials(llData.URL,llData.CheckUnderstandingstudent4 , llData.CheckUnderstandingstudent4, LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2:Verify The wel come and home Page	
		studentWelcomePage.verifywelcomePage(); 
		llactivity = studentWelcomePage.welcomeButton(); 
		llactivity.verifyHomepage();
		//Step3: Select the bundle For QC/RC "StressedSyllables: 6 words""
		stressedSyllables = (StressedSyllables) llactivity.bundleSelector(45, isIexploreBrowser(),
				ActivityType.STRESSED_SYLLABLES, llData, executionMode);
		//Step4: verify Stressed Syllable Activity and audio bar
		stressedSyllables.verifyStressedSyllableActivity();
		stressedSyllables.verifyAudiofunctionality();
		//Step5: Click on stressed syllable and wait for the  answer
		stressedSyllables.StressedSyllable();
		//Step6: Verify the Summery of Stressed syllable
		stressedSyllables.stressedSyllablesSummary();
		//Step7: Navigate to home page from activity and log out from the application
		stressedSyllables.navigateToHomePagefromActivity();
		stressedSyllables.clickLogoutfromHomePage();
		stressedSyllables.verifyLoginPage();
	}

	/**
	 * Purpose is to do a quick check of the Phrase Selection activity

	 */
	@Test(groups = { "RC", "QC" }, priority = 6, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL023_Level2_PhraseSelection() 
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage)
				llloginPage.loginCredentials(llData.URL,llData.CheckUnderstandingstudent5 , llData.CheckUnderstandingstudent5, LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2:Verify The wel come and home Page
		studentWelcomePage.verifywelcomePage(); 
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Select the bundle For QC "PhraseSelection: The lonesome howls of wolves" and RC "PhraseSelection: For years"
		phraseSelection = (PhraseSelection) llactivity.bundleSelector(50, isIexploreBrowser(),
				ActivityType.PHRASE_SELECTION, llData, executionMode);
		//Step4: verify Phrase container and select phrase option and wait for the  answer
		phraseSelection.PhraseSelection(executionMode);
		//Step5: Verify the Summery of Phrase selection
		phraseSelection.PhraseSelectionSummary();
		//Step7: Navigate to home page from activity and log out from the application
		phraseSelection.navigateToHomePagefromActivity();
		phraseSelection.clickLogoutfromHomePage();
		phraseSelection.verifyLoginPage();
	}
}
