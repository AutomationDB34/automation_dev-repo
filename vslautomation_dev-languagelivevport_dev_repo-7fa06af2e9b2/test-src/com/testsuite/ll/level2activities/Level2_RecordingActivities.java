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
import com.page.module.ll.level2activities.BlendAndReadAlternate;
import com.selenium.Sync;
import com.testng.Retry;

public class Level2_RecordingActivities extends BaseSetup{
	
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private BlendAndReadAlternate blendAndReadAlternate;
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
	 * Purpose is to do quick check of the Blend and Read Alternate activity 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "RC","QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL014_Level2_BlendAndReadAlternate()
	{
			
		//Step1: Login to LL with a valid student credentials
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.blendAndReadAlternatestudent ,llData.blendAndReadAlternatestudent,
				LLLoginReturnPage.STUD_WELCOME_PAGE);
		//Step2: Verify Welcome page and Click on welcome button
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		//Step3: verify Home page
		llactivity.verifyHomepage();
		//Step4: Select the bundle (from shortcut menu) for QC as "BlendAndReadAlternate: landfill", For RC as "BlendAndReadAlternate: flashback"
		blendAndReadAlternate = (BlendAndReadAlternate) llactivity.bundleSelector(43, isIexploreBrowser(), ActivityType.BLEND_AND_READ_ALTERNATE,
				llData, executionMode);
		//Step5: i) Click on Syllable tiles
			   //ii) Click on Record button
		      //iii) Click on Thumbs up/down icon button
		//Step6: Repeat the step 5 to reach summary page
		blendAndReadAlternate.blendAndReadAlternate(executionMode);
		//Step7: verify the summary and then click on continue
		blendAndReadAlternate.blendAndReadAlternateSummary();
		//Step8: Click on course drop down and then click on logout button
		blendAndReadAlternate.clickLogoutfromActivty();
		//Step9: Verify the login page
		blendAndReadAlternate.verifyLoginPage();
	}
}
