package com.testsuite.ll.level1activites;

import java.awt.AWTException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.RealOrNonsense;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.WordSortMultiColumn;
import com.page.module.ll.level1activities.WordSortwithSummary;
import com.page.module.ll.level1activities.LLActivity.ActivityType;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class SortingActivities extends BaseSetup {
	
	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private WordSortwithSummary wordSortWithSumamry;
	private WordSortMultiColumn wordSortMultiColumn;
	private RealOrNonsense realOrNonsense;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	@BeforeMethod(alwaysRun = true, timeOut = 100000)
	public void BaseClassSetUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		
	}
	
	/**
	 * Purpose - To test Real and Nonsense activity
	 * 
	 * */
	@Test(groups = { "QC" ,"RC"}, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL006_Level1_realAndNonsense() {
		//Step1: login to the LL Application  with student credentials. And Verify the Successful Login.
		studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,llData.realOrNonsenseStudent, llData.realOrNonsenseStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		//Step2: Click on the WelCome Button
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the bundle named Sorting Wordsort from Unit1 Lesson1(Select same bundle for both QC and RC)
		realOrNonsense = (RealOrNonsense) llactivity.bundleSelector(6, isIexploreBrowser(), ActivityType.REAL_OR_NONSENSE,llData,executionMode);
		//Step4: Verify the navigation to the activity 
		realOrNonsense.verifyRealNonsenseActivity();
		//Step 5: Follow the auido and drag and drop the words into the column 
		realOrNonsense.rcrealOrNonsense(isIexploreBrowser());
		//Step6: Verify the summary page
		realOrNonsense.realOrNonsenseSummary();
		//Step 7: Logout from the activity  and verify the login page
		realOrNonsense.clickLogoutfromActivty();
		realOrNonsense.verifyLoginPage();
	}
	

	/**
	 * Purpose of the method is to test the Word sort with summary  activity
	 * */
	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL016_Level1_WordSortWithSymmary(){
		//Follow the steps Step1 And Step2 from LL_006
		studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,llData.wordSortStudent, llData.wordSortStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the bundle named'Sorting.WordSort: 2 categories + 8 sortables' from Unit2 Lesson2(Select same bundle for both QC and RC)
		wordSortWithSumamry = (WordSortwithSummary) llactivity.bundleSelector(17, isIexploreBrowser(), ActivityType.WORD_SORT_SUMMARY,llData,executionMode);
		//Step4: VBerify the word sorting activity Page
		wordSortWithSumamry.verifyWordSortActivity();
		//Step5:Mouse over on the plural Column.
		wordSortWithSumamry.wordSortActivity(isIexploreBrowser());
		//Step6: Drag and drop the answer to answer area and verify the 
		wordSortWithSumamry.wordSortSummary();
		//Follow the Step 7 from LL_006
		wordSortWithSumamry.clickLogoutfromActivty();
		wordSortWithSumamry.verifyLoginPage();
	}
	
	/**
	 * Purpose of the method is to test the Word SortMulti column activity
	 * */
	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL019_Level1_WordSortWitMultiColumn(){
		//Follow the steps Step1 And Step2 from LL_006 
		studentWelcomePage=(StudentWelcomePage)llloginPage.loginCredentials(llData.URL,llData.wordMulSortStudent, llData.wordMulSortStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step3:Navigate/Select the bundle named'Sorting.WordSortMultiColumn: 4 categories + 14 sortables' from Unit4 Lesson1(Select same bundle for both QC and RC)
		wordSortMultiColumn = (WordSortMultiColumn) llactivity.bundleSelector(20, isIexploreBrowser(), ActivityType.WORD_SORT_MULTI_COLUMN,llData,executionMode);
		//Step4: VBerify the word multi sorting activity Page
		wordSortMultiColumn.verifyWordSortMultiColumnActivity();
		//Step5:Mouse over on the plural Column.
		//Step6: Drag and drop the answer to answer area.
		wordSortMultiColumn.wordSortMultiColumnActivity(isIexploreBrowser());
		wordSortMultiColumn.wordSortMultiColumnSummary();
		//Follow the Step 7 from LL_006
		wordSortMultiColumn.clickLogoutfromActivty();
		wordSortMultiColumn.verifyLoginPage();
	}	
}
