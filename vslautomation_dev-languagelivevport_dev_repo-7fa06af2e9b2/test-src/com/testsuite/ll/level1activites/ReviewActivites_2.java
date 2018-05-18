package com.testsuite.ll.level1activites;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.IdentifyWordEndingSound;
import com.page.module.ll.level1activities.IdentifyWordEndings;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.ListenAndAnswerYesNo;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLActivity.ActivityType;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class ReviewActivites_2 extends BaseSetup {
	
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private ListenAndAnswerYesNo listenAnswerYesNo;
	private IdentifyWordEndingSound identifyWordEndingSound;
	private IdentifyWordEndings identifyWordEndings;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	
	@BeforeMethod(alwaysRun = true, timeOut = 1000000)
	public void BaseClassSetUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
	}

	/**
	 * Purpose is to perform Quick check for the Listen and answer Yes/No
	 * activity
	 */
	@Test(groups = { "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL018_Level1_listenAndAnswerYesNo() 
	{
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.ListenYesNoStudent,
				llData.ListenYesNoStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the Bundle named as 'ListenAndAnswerYesNo:' in Unit3 Lesson1.
		//(Same bundle for both QC and RC)
		listenAnswerYesNo = (ListenAndAnswerYesNo) llactivity.bundleSelector(19, isIexploreBrowser(),
				ActivityType.LISTEN_ANSWER_YES_NO, llData, executionMode);
		//Step4: verify the Listen And Answer Activity
		listenAnswerYesNo.verifyListenAndAnswerActivity();
		//Step5: Click on the Audio Bar
		listenAnswerYesNo.clickOnAudioBar();
		//Step6: Click on Answer button YES/NO.
		listenAnswerYesNo.listenAndAnswerActivity();
		//Follow the steps step8 and step9 from LL_001
		listenAnswerYesNo.clickLogoutfromActivty();
		listenAnswerYesNo.verifyLoginPage();
	}

	/**
	 * Purpose is to perform Quick check for the Identify Word Ending Sound
	 * activity
	 */
	@Test(groups = { "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL021_Level1_IdentifyWordEndingSound()
	{
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.IdentifyWordSoundStudent,
				llData.IdentifyWordSoundStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the Bundle named as 'IdentifyWordEndingSound: hissed' in Unit4 Lesson2.
		//(Select 'IdentifyWordEndingSound: sniffed' For QC, Select 'IdentifyWordEndingSound: hissed' for RC and repeat the step5 & step6 for 10 times)
		identifyWordEndingSound = (IdentifyWordEndingSound) llactivity.bundleSelector(22, isIexploreBrowser(),
				ActivityType.IDENTIFY_WORD_ENDING_SOUND, llData, executionMode);
		//Step4: verify the Identify Word Ending Sound Activity.
		identifyWordEndingSound.verifyIdentifyWordEndingSoundActivity();
		//Step5: Follow the audio instructions and click on a answer radio button displayed.
		//Step6: Verify other option is disabled.
		identifyWordEndingSound.identifyWordEnd();
		//Follow the steps step8 and step9 from LL_001
		identifyWordEndingSound.clickLogoutfromActivty();
		identifyWordEndingSound.verifyLoginPage();
	}

	/**
	 * Purpose is to perform Quick check for the Identify Word End activity
	 */
	@Test(groups = { "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL022_Level1_IdentifyWordEndings()  
	{
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.IdentifyWordEndStudent,
				llData.IdentifyWordEndStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the Bundle named as 'IdentifyWordEndings: ed' in Unit4 Lesson2.
		//(Select 'IdentifyWordEndings: ed' For QC and RC)
		identifyWordEndings = (IdentifyWordEndings) llactivity.bundleSelector(23, isIexploreBrowser(),
				ActivityType.IDENTIFY_WORD_ENDINGS, llData, executionMode);
		//Step4: verify the Identify Word Endings Activity.
		identifyWordEndings.verifyIdentifyWordEndingsActivity();
		//Step4: Click on answer radio button. 
		//Step6: Verify other option is disabled.
		identifyWordEndings.identifyWordEndings();
		//Follow the steps step8 and step9 from LL_001
		identifyWordEndings.clickLogoutfromActivty();
		identifyWordEndings.verifyLoginPage();
	}
}
