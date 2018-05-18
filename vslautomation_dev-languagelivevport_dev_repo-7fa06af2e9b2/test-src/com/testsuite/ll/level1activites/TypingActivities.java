package com.testsuite.ll.level1activites;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.Dictation;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.SyllabificationTyping;
import com.page.module.ll.level1activities.LLActivity.ActivityType;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class TypingActivities extends BaseSetup {
	
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private SyllabificationTyping syllabificationTyping;
	private Dictation dictation;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	
	@BeforeMethod(alwaysRun = true , timeOut = 1000000)
	public void BaseClassSetUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
	}
	
	/**
	 * Purpose - is to test the functionality of Dictation activity
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL015_Level1_Dictation()
	{
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,llData.dictationStudent, llData.dictationStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the Bundle named as 'Dictation: Dan is big.' in Unit2 Lesson1.
		//(Select 'Dictation: Dan is big.' For QC and RC)
		dictation = (Dictation) llactivity.bundleSelector(16, isIexploreBrowser(), ActivityType.DICTATION,llData,executionMode);
		//Step4: Verify the Dictiation Activity page
		dictation.verifyDictiationActivity();
		//Step5: click on the audio bar
		dictation.clickAudiobarFunctionality();
		//Step6: click on check it button.
		//Step7: Click next Button
		dictation.dictation();
		//Follow the steps step8 and step9 from LL_001
		dictation.clickLogoutfromActivty();
		dictation.verifyLoginPage();
	}
	
	/**
	 * purpose - is to test he functionality of syllabification typing activity 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "QC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL025_Level1_SyllabificationTypingActivity() 
	{
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,llData.syllabificationTypingStudent, llData.syllabificationTypingStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the Bundle named as 'SyllabificationTyping: multitask' in Unit4 Lesson3.
		//(Select 'SyllabificationTyping: multitask' For QC and 'SyllabificationTyping: investment for 'RC)
		syllabificationTyping = (SyllabificationTyping) llactivity.bundleSelector(26, isIexploreBrowser(), ActivityType.SYLLABIFICATION_TYPE,llData,executionMode);
		//Step4: Verify the Syllabification typing activity
		syllabificationTyping.verifySyllabificationTypingActivity();
		//Step5: Click on the audio bar displayed
		syllabificationTyping.clickAudioBarfunctionality();
		//Step6:Type the answer in grid text box.
		//Step7: Click on CHeck it button.
		syllabificationTyping.SyllabificationTypingActivity();
		//syllabificationTyping.syllabificationTypingSummary();
		//Follow the steps step8 and step9 from LL_001
		syllabificationTyping.clickLogoutfromActivty();
		syllabificationTyping.verifyLoginPage();
	}

}
