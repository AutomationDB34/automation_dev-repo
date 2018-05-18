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
import com.page.module.ll.level2activities.IndependentReading;
import com.page.module.ll.level2activities.IndependentRecording;
import com.selenium.Sync;
import com.testng.Retry;

public class IRActivities extends BaseSetup {
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private IndependentReading independentReading;
	private IndependentRecording independentRecording;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() 
	{
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
	}

	/**
	 * Purpose - is to do quick check of Independent Reading activity
	 */
	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL001_Level2_independentReading() 
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.irReadStudent,
				llData.irReadStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2:Verify The Wel Come and click on welcome button and verify home Page
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Select the bundle "IndependentReading.Reading: Hope for Hugs" (For QC and RC Same bundle need to select)
		independentReading = (IndependentReading) llactivity.bundleSelector(28, isIexploreBrowser(),
				ActivityType.INDEPENDENT_READING, llData, executionMode);
		//Step4: Verify the Investigate Passage PopUp
		independentReading.verifyInvestigatePasagePopUp();
		//Step5: Click on continue button on untimed IR reading window
		independentReading.untimedIRReading();
		//Step6: Verify the Read Timed PasagePopUp
		independentReading.verifyReadTimedPasagePopUp();
		//Step7: Click on Stop Timer button
		//Step8: Click on Start Button
		//Step9: Clik on last word and Continue button
		independentReading.timedReading();
		//Step10: Verify the summary page and then click onContinue button
		independentReading.irReadingSummary();
		//Step11: Navigate to home page from activity and log out from the application
		independentReading.navigateToHomePagefromActivity();
		independentReading.clickLogoutfromHomePage();
	}

	/**
	 * Purpose - is to do quick check of Independent Recording activity
	 */
	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LL006_Level2_independentRecording()
	{
		//Step1: Login to Application with a valid student
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.irRecordStudent,
				llData.irRecordStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2:Verify The Wel Come and click on welcome button and verify home Page 
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Select the bundle ""IndependentReading.Reading: Hope for Hugs"" (For QC and RC Same bundle need to select)
		independentRecording = (IndependentRecording) llactivity.bundleSelector(29, isIexploreBrowser(),
				ActivityType.INDEPENDENT_RECORDING, llData, executionMode);
		//Step4: enable the micro phone
		independentRecording.enableMicroPhone();
		//Step5: click on Start button Verify the Record the Passage PopUp
		independentRecording.verifyRecordThePasssagePopup();
		//Step6: Click Stop and start buttons.
		//Step7: Verify the Last Word Screen
		independentRecording.irRecording();
		//Step8: Click on last word and Continue button
		independentRecording.verifyLastWordScreen();
		//Step9: Verify the summery page and then click onContinue button
		independentRecording.irRecordingSummary();
		//Step10: Navigate to home page from activity and log out from the application
		independentRecording.navigateToHomePagefromActivity();
		independentRecording.clickLogoutfromHomePage();
	}
}
