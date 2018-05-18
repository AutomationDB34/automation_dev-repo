package com.testsuite.ll.level1activites;

import java.awt.AWTException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.SentenceCompletion;
import com.page.module.ll.level1activities.SentenceCompletionSpelling;
import com.page.module.ll.level1activities.SentenceCompletionWithNoErrorCorrection;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLActivity.ActivityType;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class FillInTheBlanksActivities extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private SentenceCompletion sentenceCompletion;
	private SentenceCompletionSpelling sentenceCompletionSpelling;
	private SentenceCompletionWithNoErrorCorrection sentenceCompletionNoError;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	
	@BeforeMethod(alwaysRun = true, timeOut = 1000000)
	public void BaseClassSetUp() 
	{
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
	}

	/**
	 * purpose - is to do quick check of the Sentence Completion activity
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "QC","RC" }, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL017_Level1_SentenceCompletion() 
	{
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.sentenceCompletionStudent,
				llData.sentenceCompletionStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Navigate/Select the Bundle named as 'SentenceCompletion: Kings had many fancy  ___  to wear.' in Unit2 Lesson2.
		//(Select 'SentenceCompletion: Kings had many fancy  ___  to wear.' For QC,Select 'SentenceCompletion: Kings had many fancy  ___  to wear.' for RC and repeat the steps5 6 times)
		sentenceCompletion = (SentenceCompletion) llactivity.bundleSelector(18, isIexploreBrowser(),
				ActivityType.SENTENCE_COMPLETION, llData, executionMode);
		//Step4: Verify the Sentence Completion Activity
		sentenceCompletion.verifySentenceCompletion();
		//Step5: drag and drop the answer tile into answer area
		//Step6: Click continue on Summary page
		sentenceCompletion.sentenceCompletion(isIexploreBrowser());
		//Follow the steps step8 and step9 from LL_001"
		sentenceCompletion.clickLogoutfromActivty();
		sentenceCompletion.verifyLoginPage();
	}

	/**
	 * purpose - is to do quick check of the Sentence completion Spelling
	 * activity
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "QC" ,"RC"}, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL020_Level1_SentenceCompletionSpelling()
	{
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.sentenceCompletionSpellingStudent,
				llData.sentenceCompletionSpellingStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Navigate/Select the Bundle named as 'SentenceCompletion.Spelling: Will you ___ this spot?' in Unit4 Lesson1.
		//(Select 'SentenceCompletion.Spelling: Will you ___ this spot?' For QC,Select 'SentenceCompletion.Spelling: Can you ___ me that stuff?' for RC and repeat the steps5 8 times)		
		sentenceCompletionSpelling = (SentenceCompletionSpelling) llactivity.bundleSelector(21, isIexploreBrowser(),
				ActivityType.SENTENCE_COMPLETION_SPELLING, llData, executionMode);
		sentenceCompletionSpelling.verifySentenceCompletionSpellingActivity();
		//Step4: Verify the audio bar is open or not
		sentenceCompletionSpelling.verifyaudiobar();
		//Step5: Type your answer at answer text box 
		//Step6: Click on Check it.
		//Step: verify the summary page and Click continue on Summary page  
		sentenceCompletionSpelling.sentencecompletionSpelling();
		sentenceCompletionSpelling.sentenceCompletionSpellingSummary();
		//Follow the steps step8 and step9 from LL_001"
		sentenceCompletionSpelling.clickLogoutfromActivty();
		sentenceCompletionSpelling.verifyLoginPage();
	}

	/**
	 * purpose - is to do quick check of the Sentence Completion with no error
	 * correction activity
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(groups = { "QC" ,"RC"}, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL026_Level1_SentenceCompletionWithNoErrorCorrection()  
	{
		//Follow Steps1 &2 from LL_001.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.sentenceCompletionWithNoErrorStudent,llData.sentenceCompletionWithNoErrorStudent,
				LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3: Navigate/Select the Bundle named as 'SentenceCompletion: Those beads  ___ with that ring.' in Unit6 Lesson3.
		//(Select 'SentenceCompletion: Those beads  ___ with that ring.'SentenceCompletion: Will you  ___ up this mess?' for RC and repeat the steps5 8 times)		
		sentenceCompletionNoError = (SentenceCompletionWithNoErrorCorrection) llactivity.bundleSelector(27,
				isIexploreBrowser(), ActivityType.SENT_COMPLETION_NO_ERROR, llData, executionMode);
		//Step4: Verify the Sentence Complete Activuty Load
		sentenceCompletionNoError.verifySentCompletionactivity();
		//Step5: drag and drop the answer tile into answer area
		sentenceCompletionNoError.sentenceCompletion(isIexploreBrowser());
		//Step6: Verify the Summery Page and Click continue on Summary page
		sentenceCompletionNoError.sentCompleteionwithNoErrorSummary();
		//Follow the steps step8 and step9 from LL_001"
		sentenceCompletionNoError.clickLogoutfromActivty();
		sentenceCompletionNoError.verifyLoginPage();
	}
}
