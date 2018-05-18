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
import com.page.module.ll.level2activities.BigWordStrategy;
import com.page.module.ll.level2activities.Shuffle;
import com.page.module.ll.level2activities.WordBuilding;
import com.page.module.ll.level2activities.WordConstruction;
import com.selenium.Sync;
import com.testng.Retry;

public class Level2_DragAndDropActivities extends BaseSetup {
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private BigWordStrategy bigWordStrategy;
	private Shuffle shuffle;
	private WordConstruction wordConstruction;
	private WordBuilding wordBuilding;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
	}

	/**
	 * Purpose is to do a quick check of the Big Word Strategy activity
	 */
	@Test(groups = { "RC","QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000,alwaysRun=true)
	public void LL019_Level2_BigWordStrategy()
	{
		//Step1: Login to LL with a valid studen credentials
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.bigWordStrategyStudent,
				llData.bigWordStrategyStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2: Verify Welcome page and Click on welcome button
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		//Step3: veryfy Home page
		llactivity.verifyHomepage();
		//Step4: Select the bundle (from shortcut menu) for QC as "BigWordStrategy: ribbon", For RC as "BigWordStrategy: nugget" 
		bigWordStrategy = (BigWordStrategy) llactivity.bundleSelector(47, isIexploreBrowser(),
				ActivityType.BIG_WROD_STRATEGY, llData, executionMode);
		//Step5: drag and drop vowel tile and click on check it button and continue the same steps until window reach the last bundle
		//Step6: Repeat the step5 for blue marble
		bigWordStrategy.bigWordStrategy(isIexploreBrowser(),executionMode);
		//Step7: Verify the summary page and values then click on continue
		bigWordStrategy.bigWordStrategysummary();
		//Step8: Navigate to home page and click logout and verify the login page
		bigWordStrategy.navigateToHomePagefromActivity();
		bigWordStrategy.clickLogoutfromHomePage();
		bigWordStrategy.verifyLoginPage();
	}

	/**
	 * Purpose is to do a quick check of Shuffle activity
	 */
	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LL016_Level2_Shuffle()  
	{
		//Step1: Login to LL with a valid student credentials
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.shufflestudent,
				llData.shufflestudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2: Verify Welcome page and Click on welcome button
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		
		llactivity.verifyHomepage();
		//Step4: Select the bundle (from shortcut menu) for QC as "Shuffle: Can you help us with this complex problem?", For RC as "Shuffle: My backbone is strong from all these handstands."
		shuffle = (Shuffle) llactivity.bundleSelector(44, isIexploreBrowser(), ActivityType.SHUFFLE, llData, executionMode);
		//Step5: Verify Shuffle Activity page
		shuffle.verifyShuffleActivity();
		//Step6: Drag and drop the answer shuffle tile to target tile and repeat it until the last bundle is completed
		shuffle.shuffle(isIexploreBrowser());
		//Step7: Verify the summary and click continue
		shuffle.shuffleSummary();
		//Step8: Navigate to home page and click logout and verify the login page
		shuffle.navigateToHomePagefromActivity();
		shuffle.clickLogoutfromHomePage();
		shuffle.verifyLoginPage();
	}

	/**
	 * Purpose is to do quick check of Word Building activity
	 */
	@Test(groups = { "QC" }, priority = 3, retryAnalyzer = Retry.class)
	public void LL012_Level2_WordBuilding()
	{
		//Step1: Login to LL with a valid student credentials
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.wordbuildingstudent,
				llData.wordbuildingstudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2: Verify Welcome page and Click on welcome button
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		//Step3: verify Home page
		llactivity.verifyHomepage();
		//Step4: Select the bundle (from shortcut menu) for QC as "WordBuilding: hundred", For RC as "WordBuilding: dentist"
		wordBuilding = (WordBuilding) llactivity.bundleSelector(39, isIexploreBrowser(), ActivityType.WORD_BUILDING,
				llData, executionMode);
		//Step5: Drag and drop the syllable tile to word building container and then click on check it button
		//Step6: Repeat step5 for RC mode of execution unti the screen reaches the summery page
		wordBuilding.wordBuilding(executionMode,isIexploreBrowser());
		
		//Step7: Verify the summary of word building and click on continue
		wordBuilding.wordBuildingSummary();
		//Step8: Click on course drop down and then click on logout button
		wordBuilding.clickLogoutfromActivty();
		//Step9: Verify the login page
		wordBuilding.verifyLoginPage(); 
	}

	/**
	 * Purpose is to do quick check of word construction activity
	 */
	@Test(groups = { "RC", "QC" }, priority = 4, retryAnalyzer = Retry.class)
	public void LL009_Level2_WordConstruction() {
		
		//Step1: Login to LL with a valid student credentials
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.wordconstructionstudent,
				llData.wordconstructionstudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
	    //Step2: Verify Welcome page and Click on welcome button
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		//Step3: verify Home page
		llactivity.verifyHomepage();
		//Step4: Select the bundle for QC/RC as "WordConstruction: Prefixes + Base Words"
		wordConstruction = (WordConstruction) llactivity.bundleSelector(36, isIexploreBrowser(),
				ActivityType.WORD_CONSTRUCTION, llData, executionMode);
		//Step5: Drag and drop the word to left/right draggable area and click on check it button. Repeat it to reach the summary page
		wordConstruction.wordConstruction();
		//Step6: Verify the summary page and values and then click on continue button
		wordConstruction.wordConstructionSummary();
		//Step7: Click on course drop down and then click on logout button
		wordConstruction.clickLogoutfromActivty();
		//Step8: Verify the login page
		wordConstruction.verifyLoginPage();
	}
}
