package com.testsuite.ll.level1activites;

import java.awt.AWTException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.BlendAndRead;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.PhrasesAndSentences;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLActivity.ActivityType;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class RecordingActivities extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private BlendAndRead blendandread;
	private PhrasesAndSentences phrasesAndSentences;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();		
	}

	/**
	 * Purpose - is to do quick check of blend and read activity 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL001_Level1_blendAndRead() {
		//Step1: login to the LL Application  with student credentials. And Verify the Successful Login.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.blendAndReadUN,
				llData.blendAndReadUN, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		//Step2: Click on the WelCome Button
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the Bundle named as 'BlendAndRead: fan' in Unit1 Lesson2.(Select 'lap' For QC, Select 'fan' for RC and repeat the steps step4 to step7 utnil summery page displays)
		blendandread = (BlendAndRead) llactivity.bundleSelector(2, isIexploreBrowser(), ActivityType.BLEND_AND_READ,
				llData, executionMode);
		//Step4: Follow the Audio instructions and click the letters displayed.
		//Step5: Then Click Record button.
		//Step6: Click on Review button. User will be navigated to Summary Page
		//Step7: Click on the Grade (Thumbs UP/Down)
		blendandread.blendandReadActivity();
		blendandread.blendandReadSummary();
		//Step8: Click Logout from the mouse hover drop down menu.
		blendandread.clickLogoutfromActivty();
		blendandread.verifyLoginPage();
	}

	/**
	 * Purpose - is t do quick check of Phrases and sentences activity 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "QC" },priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL008_Level1_phrasesAndSentences() {
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.blendAndReadUN,
				llData.blendAndReadUN, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Navigate/Select the Bundle named as 'PhrasesAndSentences: Can I have the pan?' in Unit1 Lesson2.
		//(Select 'Can I have the pan?' For QC, Select 'sat on the lap' for RC and repeat the steps step4 to step7 utnil summery page displays)
		phrasesAndSentences = (PhrasesAndSentences) llactivity.bundleSelector(9, isIexploreBrowser(),
				ActivityType.PHRASES_AND_SENTENCES, llData, executionMode);
		//Step4:  Follow the Audio instructions and Click Each Word to Connect the Phrase or Sentence
		//Step5: Then Click Record button.
		//Step6: Click on Review button. User will be navigated to Summary Page
		//Step7: Click on the Grade (Thumbs UP/Down)
		phrasesAndSentences.PhrasesAndSentences();
		phrasesAndSentences.activitySummary();
		//Follow the steps step8 and step9 from LL_001
		phrasesAndSentences.clickLogoutfromActivty();
		phrasesAndSentences.verifyLoginPage();
	}
}