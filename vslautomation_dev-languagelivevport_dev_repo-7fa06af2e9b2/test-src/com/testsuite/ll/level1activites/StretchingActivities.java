package com.testsuite.ll.level1activites;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.Stretching;
import com.page.module.ll.level1activities.StretchingPreview;
import com.page.module.ll.level1activities.StretchingWithNoErrorCorrection;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLActivity.ActivityType;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class StretchingActivities extends BaseSetup {
	
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private Stretching stretching;
	private StretchingPreview stretchingpreview;
	private StretchingWithNoErrorCorrection stretchingWithNoErrorCorrection;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	

	@BeforeMethod(alwaysRun = true, timeOut = 100000)
	public void setUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
	}
	
	/**
	 * Purpose - To test stretching preview activity
	 * 
	 */

	@Test(groups = { "QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL009_Level1_stretchingPreview(){
		//Step1: login to the LL Application  with student credentials. And Verify the Successful Login.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.stretchingPreviewUN,
				llData.stretchingPreviewUN, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		//Step2: Click on the WelCome Button
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Navigate/ Select the bundle named 'StretchingPreview: am' from Uni1 Lesson1(Select 'am' for QC and Select 'Mat' for RC and repeat the steps 
		stretchingpreview = (StretchingPreview) llactivity.bundleSelector(10, isIexploreBrowser(),
				ActivityType.STRETCHINGPREVIEW, llData, executionMode);
		//Verify the navigation to the selected activity 
		stretchingpreview.verifyStretchingPreviewActivity();
		//Step 5: Follow the instructions abd drag and drop the C/V tiles into the answer area
		//Step 6: Follow the audio instruction and complete the word by drag & dropping the letters
		stretchingpreview.stretchingPreview(isIexploreBrowser());
		//Step 7:  Verify the Summary page 
		stretchingpreview.strectchingPreviewSummary();
		//Step 8: Log out from activity 
		stretchingpreview.clickLogoutfromActivty();
		//Step9 :Verify the successful logout
		stretchingpreview.verifyLoginPage();
	}
	
	/**
	 * Purpose - To test stretching activity
	 * 
	 */
	@Test(groups = { "QC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LL013_Level1_Stretching(){
		//Step1: login to the LL Application  with student credentials. And Verify the Successful Login.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.stretchingUN, llData.stretchingUN,
				LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		//Step2: Click on the WelCome Button
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step 3: Navigate/ Select the bundle named 'StretchingPreview: am' from Uni2 Lesson1 (Select 'Win' for QC and Select 'fig' for RC and repeat the steps 5 & 6 for all the bundles in the activity in RC mode) 
		stretching = (Stretching) llactivity.bundleSelector(14, isIexploreBrowser(), ActivityType.STRETCHING, llData,
				executionMode);
		//Step4: Verify the navigation to the selected activity 
		stretching.verifyStretchingActivity();
		//Step 5: Follow the audio of the word and drag and drop the syllable tiles into the container
		//Step 6: Follow the instructions abd drag and drop the C/V tiles into the answer area
		//Step 7: Follow the audio instruction and complete the word by drag & dropping the letters
		stretching.stretching(isIexploreBrowser());
		//Step 8:  Verify the Summary page
		stretching.stretchingSummary();
		//Step 9: Log out from activity 
		stretching.clickLogoutfromActivty();
		//Step9 :Verify the successful logout
		stretching.verifyLoginPage();
	}

	/**
	 * Purpose - To perform Quick check of stretching activity with no error correction
	 * 
	 */
	@Test(groups = { "QC" }, priority = 3, retryAnalyzer = Retry.class)
	public void LL023_Level1_stretchingWothNoErrorCorrection() 
	{
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.stretchingNoErrorStudent, llData.stretchingNoErrorStudent,
				LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step 3: Navigate/ Select the bundle named 'Stretching: gasp' from Unit4 Lesson1
		//(For QC Select 'Stretching: gasp' for RC Select 'Stretching: still' and repeat the steps 5 & 7 for all the bundles in the activity in RC mode) 
		stretchingWithNoErrorCorrection = (StretchingWithNoErrorCorrection) llactivity.bundleSelector(24,
				isIexploreBrowser(), ActivityType.STRETCHING_WITH_NO_ERROR_CORRECTION, llData, executionMode);
		//Step4: Verify the navigation to the Stretching activity 
		stretchingWithNoErrorCorrection.verifyStretchingActivity();
		//Step 5: Follow the audio of the word and drag and drop the syllable tiles into the container
		//Step 6: Follow the instructions abd drag and drop the C/V tiles into the answer area
		//Step 7: Follow the audio instruction and complete the word by drag & dropping the letters
		//Step 8:  Verify the Summary page 
		stretchingWithNoErrorCorrection.stretching(isIexploreBrowser());
		//Step 9: Log out from activity
		stretchingWithNoErrorCorrection.clickLogoutfromActivty();
		//Step10 :Verify the successful logout
		stretchingWithNoErrorCorrection.verifyLoginPage();	
	}
}
