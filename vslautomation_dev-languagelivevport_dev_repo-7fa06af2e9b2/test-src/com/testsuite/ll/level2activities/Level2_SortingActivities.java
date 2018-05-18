package com.testsuite.ll.level2activities;

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
import com.page.module.ll.level2activities.SortByFunction;
import com.page.module.ll.level2activities.SortByPattern;
import com.page.module.ll.level2activities.SyllableSort;
import com.selenium.Sync;
import com.testng.Retry;

public class Level2_SortingActivities extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private SyllableSort syllablesort;
	private SortByPattern sortByPattern;
	private SortByFunction sortByFunction;
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
	 * Purpose is to do quick check of syllable sort activity

	 */
	@Test(groups = { "RC", "QC" }, priority = 1, retryAnalyzer = Retry.class)
	public void LL010_Level2_SyllableSort()  
	{
		
		//Step1: Login to LL with a valid studen credentials
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.syllableSortStudent ,llData.syllableSortStudent , 
				LLLoginReturnPage.STUD_WELCOME_PAGE);
	    //Step2: Verify Welcome page and Click on welcome button
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		//Step3: veryfy Home page
		llactivity.verifyHomepage();
		//Step4: Select the bundle (from shortcut menu) for QC/RC as "Sorting.SyllableSort: 3 categories + 5 sortables"
		syllablesort = (SyllableSort) llactivity.bundleSelector(37, isIexploreBrowser(), ActivityType.SYLLABLE_SORT,
				llData, executionMode);
		//Step5: verifySyllableSortActivity Page
		syllablesort.verifySyllableSortActivity();
		//Step6: Drag and drop the syllable tile to sorting area. Repeat the same for all the words/letters
		syllablesort.syllableSort(isIexploreBrowser());
		//Step7: Mouse over on Activity user dropdown and then click on home link
		syllablesort.navigateToHomePagefromActivity();
		//Step8: click on log out link
		syllablesort.clickLogoutfromHomePage();
		//Step9: Verify the login page
		syllablesort.verifyLoginPage();
	}

	/**
	 * Purpose is to do quick check of Sort by Pattern activity

	 */
	@Test(groups = { "RC", "QC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LL015_Level2_SortByPattern()  
	{
		//Follow steps 1 to step 3 from LL_010_SyllableSort
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.sortByPatternStudent , llData.sortByPatternStudent,
				LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step4: Select the bundle (from shortcut menu) for QC/RC as "Sorting.SortByPattern: 2 categories + 8 sortables"
		sortByPattern = (SortByPattern) llactivity.bundleSelector(41, isIexploreBrowser(), ActivityType.SORT_BY_PATTERN,
				llData, executionMode);
		//Step5: verify Sortby patternActivity Page
		sortByPattern.verifySortByPatternActivity();
		//Step6: Drag and drop the syllable tile to sorting area. Repeat the same for all the words/letters
		sortByPattern.SortByPattern(isIexploreBrowser());
		//Step7: Verify the summery page and click on Continue
		sortByPattern.sortByPatternSummary();
		//Step8: click on course drop down and click on logout link
		sortByPattern.clickLogoutfromActivty();
		//Step9: Verify the Log in Page
		sortByPattern.verifyLoginPage();
	}

	/**
	 * Purpose is to do a quick check of Sort By Function activity
	 */
	@Test(groups = { "RC", "QC" }, priority = 3, retryAnalyzer = Retry.class)
	public void LL022_Level2_SortByFunction()  
	{
		//Follow steps 1 to step 3 from LL_010_SyllableSort
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.sortByFunctionStudent , llData.sortByFunctionStudent,
				LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step4: Select the bundle (from shortcut menu) for QC/RC as "Sorting.SortByFunction: 2 categories + 8 sortables"
		sortByFunction = (SortByFunction) llactivity.bundleSelector(42, isIexploreBrowser(),
				ActivityType.SORT_BY_FUNCTION, llData, executionMode);
		//Step5: Drag and Drop word tiles to Noun coloumn repeat for all
		sortByFunction.SortByFunction(isIexploreBrowser());
		//Step6: Verify the summery page and click on continue button
		sortByFunction.sortByFunctionSummary();
		//Step7: Mouse over on Activity user dropdown and then click on home link
		sortByFunction.navigateToHomePagefromActivity();
		//Step8: click on log out link
		sortByFunction.clickLogoutfromHomePage();
		//Step9: Verify the login page
		sortByFunction.verifyLoginPage();
	}
	
}
