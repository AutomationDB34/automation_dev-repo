package com.testsuite.ll.level1activites;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.ListenAndIdentifyKeywordWithSummary;
import com.page.module.ll.level1activities.SeeAndIdentify;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLActivity.ActivityType;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class ReviewActivities_1 extends BaseSetup {
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private SeeAndIdentify seeAndIdentify;
	private ListenAndIdentifyKeywordWithSummary listenAndIdentifyWithSummary;
	int myScoreValue;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	@BeforeMethod(alwaysRun = true, timeOut = 1000000)
	public void BaseClassSetUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
	}

	/**
	 * Purpose - To perform Quick check of See And Identify activity
	 * 
	 */
	@Test(groups = { "QC" }, priority = 5, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL011_Level1_seeAndIdentify()
	{
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.reviewActivityUN,
				llData.reviewActivityUN, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the Bundle named as 'SeeAndIdentify: s' in Unit1 Lesson2.
		//(Select 'SeeAndIdentify: s' For QC, Select 'SeeAndIdentify: a' for RC and repeat the step5 for 3 times)
		seeAndIdentify = (SeeAndIdentify) llactivity.bundleSelector(12, isIexploreBrowser(),
				ActivityType.SEEANDIDENTIFY, llData, executionMode);
		//Step4: Verify the See And Identify activity
		seeAndIdentify.verifySeeAndIdentifyActivity();
		//Step5: Follow the audio instructions and click on a radio button. And verify other radio button is disabled
		seeAndIdentify.SeeAndIdentifyActivity();
		//Follow the steps step8 and step9 from LL_001
		seeAndIdentify.clickLogoutfromActivty();
		seeAndIdentify.verifyLoginPage();
	}

	/**
	 * Purpose - To perform Quick check of Listen And Identify activity with
	 * summary
	 */
	@Test(groups = { "QC" }, priority = 6, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL012_Level1_listenAndIdentifyKeywordWithSummary() 
	{
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.reviewActivityUN,
				llData.reviewActivityUN, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the Bundle named as 'ListenAndIdentify: lap' in Unit1 Lesson2.
		//(Select 'ListenAndIdentify: lap' For QC, Select 'ListenAndIdentify: pal' for RC and repeat the step5 and Steps for 8 times)
		listenAndIdentifyWithSummary = (ListenAndIdentifyKeywordWithSummary) llactivity.bundleSelector(13,
				isIexploreBrowser(), ActivityType.LISTEN_IDENTIFY_WITH_SUMMARY, llData, executionMode);
		//Step4: Verify the Listen Identify Activity
		listenAndIdentifyWithSummary.verifyListenIdentifyActivity();
		//Step5: Click Audio bar to play the audio of words displayed.
		//Step6: Click on a answer.(any of the words displayed as grid)
		listenAndIdentifyWithSummary.ListenIdentifyKeyword();
		//Step7: Verify the Listen and Identify Summary page.
		listenAndIdentifyWithSummary.listenAndIdentifySummary();
		//Follow the steps step8 and step9 from LL_001
		listenAndIdentifyWithSummary.clickLogoutfromActivty();
		listenAndIdentifyWithSummary.verifyLoginPage();
	}
}
