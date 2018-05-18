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
import com.page.module.ll.level2activities.FillInTheBlanks;
import com.page.module.ll.level2activities.Memory;
import com.page.module.ll.level2activities.OverviewRecap;
import com.page.module.ll.level2activities.VowelCorrespondence;
import com.page.module.ll.level2activities.WordList;
import com.selenium.Sync;
import com.testng.Retry;

public class CheckUnderstandingActivities_1 extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private VowelCorrespondence vowelcorrespondence;
	private OverviewRecap overviewRecap;
	private WordList wordList;
	private FillInTheBlanks fillintheBlanks;
	private Memory memory;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		
	}

	/**
	 * Purpose is to do quick check of Vowel Correspondence activity
	 */
	@Test(groups = { "RC", "QC" }, retryAnalyzer = Retry.class)
	public void LL003_Level2_VowelCorrespondence()  
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.checkUnderstandingStudent,llData.checkUnderstandingStudent ,
				LLLoginReturnPage.STUD_WELCOME_PAGE);//llData.checkUnderstandingStudent
		//Step2:Verify The Wel Come and home Page
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Select the bundle "VowelCorrespondence: pet, dim, fat, lip, mop, tub, pod, nut, cap, men"
		vowelcorrespondence = (VowelCorrespondence) llactivity.bundleSelector(31, isIexploreBrowser(),
				ActivityType.VOWEL_CORRESPONDENCE, llData, executionMode);
		//Step4: Verify the Vowel Correspondence Activity
		vowelcorrespondence.verifyVowelCorrespondenceActivity();
		//Step5: Verify audio Function
		vowelcorrespondence.verifyAudioFunctionality();
		//Step6: Drag and drop the correct tile to vowel area
		vowelcorrespondence.vowelCorrespondence(isIexploreBrowser());
		//Step7: Navigate to home page from activity and log out from the application
		vowelcorrespondence.navigateToHomePagefromActivity();
		vowelcorrespondence.clickLogoutfromHomePage();
		vowelcorrespondence.verifyLoginPage();
	}

	/**
	 * Purpose is to do quick check of Word list
	 * 
	 */
	@Test(groups = { "RC", "QC" },retryAnalyzer = Retry.class)
	public void LL004_Level2_WordList()
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.checkUnderstandingStudent,llData.checkUnderstandingStudent ,
				LLLoginReturnPage.STUD_WELCOME_PAGE);//llData.checkUnderstandingStudent
		//Step2:Verify The Wel Come and home Page
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Select the bundle "WordList: [WordList]"
		wordList = (WordList) llactivity.bundleSelector(32, isIexploreBrowser(), ActivityType.WORD_LIST, llData, executionMode);
		wordList.verifyWordList();
		//Step4: Click on Continue button
		wordList.clickContinuebtn();
		//Step5: Navigate to home page from activity and log out from the application
		wordList.navigateToHomePagefromActivity();
		wordList.clickLogoutfromHomePage();
		wordList.verifyLoginPage();
	}

	/**
	 * Purpose id to do a quick check of the Overview recap page
	 *
	 */
	@Test(groups = { "RC", "QC" }, retryAnalyzer = Retry.class)
	public void LL005_Level2_OverviewRecap() 
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.checkUnderstandingStudent,llData.checkUnderstandingStudent ,
				LLLoginReturnPage.STUD_WELCOME_PAGE);//llData.checkUnderstandingStudent
		//Step2:Verify The Wel Come and home Page
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Select the bundle "OverviewRecap: Lesson 1: Recap"
		overviewRecap = (OverviewRecap) llactivity.bundleSelector(33, isIexploreBrowser(), ActivityType.OVERVIEW_RECAP,
				llData, executionMode);
		//Step4: Verify Recap Page
		overviewRecap.verifyRecapPage();
		//Step5: Click on Continue button
		overviewRecap.clickContinuebtn();
		//Step6: Navigate to home page from activity and log out from the application
		overviewRecap.navigateToHomePagefromActivity();
		overviewRecap.clickLogoutfromHomePage();
		overviewRecap.verifyLoginPage();
	}

	/**
	 * purpose - is to do quick check of Fill in the blanks activity
	 */
	@Test(groups = { "RC", "QC" }, retryAnalyzer = Retry.class)
	public void LL008_Level2_fillInTheBlanks() 
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.checkUnderstandingStudent,llData.checkUnderstandingStudent ,
				LLLoginReturnPage.STUD_WELCOME_PAGE);//llData.checkUnderstandingStudent
		//Step2:Verify The Wel Come and home Page
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Select the bundle "FillInTheBlank: 6 sentences"
		fillintheBlanks = (FillInTheBlanks) llactivity.bundleSelector(35, isIexploreBrowser(),
				ActivityType.FILL_IN_THE_BLANKS, llData, executionMode);
		//Step4: Verify fill in the blanks Page and click the answer tile
		fillintheBlanks.fillinTheBlanks();
		//Step5: Navigate to home page from activity and log out from the application
		fillintheBlanks.navigateToHomePagefromActivity();
		fillintheBlanks.clickLogoutfromHomePage();
		fillintheBlanks.verifyLoginPage();
	}
	
	/**
	 * Purpose is to do quick check of the Memory activity
	 */

	@Test(groups = { "RC", "QC" },  retryAnalyzer = Retry.class)
	public void LL021_Level2_Memory() 
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.checkUnderstandingStudent,llData.checkUnderstandingStudent ,
				LLLoginReturnPage.STUD_WELCOME_PAGE);//llData.checkUnderstandingStudent
		//Step2:Verify The Wel Come and home Page
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Select the bundle "Memory: Words and Contraction"
		memory = (Memory) llactivity.bundleSelector(49, isIexploreBrowser(), ActivityType.MEMORY, llData, executionMode);
		//Step4: Click on words bulb in and contractions tile
		memory.memory();
		//Step5: Navigate to home page from activity and log out from the application
		memory.navigateToHomePagefromActivity();
		memory.clickLogoutfromHomePage();
		memory.verifyLoginPage();
	}
}
