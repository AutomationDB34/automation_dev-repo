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
import com.page.module.ll.level2activities.AssociationWall;
import com.page.module.ll.level2activities.ColumnMatching;
import com.page.module.ll.level2activities.WordGenerator;
import com.page.module.ll.level2activities.WordRadiator;
import com.selenium.Sync;
import com.testng.Retry;

public class OtherActivities extends BaseSetup {
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private WordRadiator wordRadiator;
	private WordGenerator wordGenerator;
	private ColumnMatching columnMatching;
	private AssociationWall associationWall;
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
	 * Purpose is to do a quick check of Word Radiator activity
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000, alwaysRun = true)
	public void LL024_Level2_WordRadiator() {
		// Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL, llData.wordRadiatorStudent,
				llData.wordRadiatorStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		// Step2:Verify The WelCome and home Page
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		// Step3: Select the bundle WordRadiator: Select the nouns that indicate
		// a Quality or State (10 words)
		wordRadiator = (WordRadiator) llactivity.bundleSelector(51, isIexploreBrowser(), ActivityType.WORD_RADIATOR,
				llData, executionMode);
		// Step4: Verify Activity displayed or not
		wordRadiator.verifyWordRadiatorActivity();
		// Step5: Complete Word Radiator activity
		wordRadiator.rcWordRadiator();
		// Step6: Navigate to home page from activity and log out from the
		// application
		wordRadiator.navigateToHomePagefromActivity();
		wordRadiator.clickLogoutfromHomePage();
		wordRadiator.verifyLoginPage();
	}

	/**
	 * Purpose is to do a quick check of Word Generator activity
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000, alwaysRun = true)
	public void LL025_Level2_WordGenerator() {
		// Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL, llData.wordGeneratorStudent,
				llData.wordGeneratorStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		// Step2:Verify The WelCome and home Page
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		// Step3: Select the bundle WordGenerator: 9 syllables + 5 words
		wordGenerator = (WordGenerator) llactivity.bundleSelector(52, isIexploreBrowser(), ActivityType.WORD_GENERATOR,
				llData, executionMode);
		// Step4: Verify Activity displayed or not
		wordGenerator.verifyWordGeneratorActivity();
		// Step5: Complete Word Generator activity
		wordGenerator.rcWordGenerator();
		wordGenerator.wordGeneratorSummary();
		// Step6: Navigate to home page from activity and log out from the
				// application
		wordGenerator.navigateToHomePagefromActivity();
		wordGenerator.clickLogoutfromHomePage();
		wordGenerator.verifyLoginPage();
	}

	/**
	 * Purpose is to do a quick check of the column matching activity
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000, alwaysRun = true)
	public void LL026_Level2_ColumnMatching() {
		// Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL, llData.columnMatchingStudent,
				llData.columnMatchingStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		// Step2:Verify The WelCome and home Page
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		// Step3: Select the bundle ColumnMatching: 6 matches
		columnMatching = (ColumnMatching) llactivity.bundleSelector(53, isIexploreBrowser(),
				ActivityType.COLUMN_MATCHING, llData, executionMode);
		// Step4: Verify Activity displayed or not
		columnMatching.verifycolumnMatchingActivity();
		// Step5: Complete Column matching activity
		columnMatching.rcColumnMatching();
		columnMatching.columnMatchingSummary();
		// Step6: Navigate to home page from activity and log out from the
		// application
		columnMatching.clickLogoutfromActivty();
		columnMatching.verifyLoginPage();
	}

	/**
	 * Purpose is to do perform QC/RC of the Association wall activity
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "RC", "QC" }, priority = 4, retryAnalyzer = Retry.class, timeOut = 1000000, alwaysRun = true)
	public void LL027_Level2_AssociationWall() {
		// Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,
				llData.associationWallStudent, llData.associationWallStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		// Step2:Verify The WelCome and home Page
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		// Step3: Select the bundle AssociationWall: 10 questions + 12 words
		associationWall = (AssociationWall) llactivity.bundleSelector(54, isIexploreBrowser(),
				ActivityType.ASSOCIATION_WALL, llData, executionMode);
		// Step4: Verify Activity displayed or not
		associationWall.verifyassociationWallActivity();
		// Step5: Complete Association wall activity
		associationWall.rcAssociationWall();
		associationWall.associationWallSummary();
		// Step6: Navigate to home page from activity and log out from the
		// application
		associationWall.navigateToHomePagefromActivity();
		associationWall.clickLogoutfromHomePage();
		associationWall.verifyLoginPage();
	}
}
