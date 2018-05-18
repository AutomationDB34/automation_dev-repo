package com.testsuite.ll.level1activites;

import java.awt.AWTException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.module.ll.level1activities.BuildaWordFamily;
import com.page.module.ll.level1activities.LLActivity;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.Rhyming;
import com.page.module.ll.level1activities.RhymingAdvanced;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.Syllabification;
import com.page.module.ll.level1activities.LLActivity.ActivityType;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class DragAndDropActivities extends BaseSetup {

	private LLData llData;
	private LLLoginPage llloginPage;
	private LLActivity llactivity;
	private StudentWelcomePage studentWelcomePage;
	private BuildaWordFamily buildaWordFamily;
	private Syllabification syllabification;
	private RhymingAdvanced rhymingAdvanced;
	private Rhyming rhyming;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	@BeforeMethod(alwaysRun = true, timeOut = 100000)
	public void BasesetUp() {
		llloginPage = new LLLoginPage(getDriver());
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
		//getDriver().get(llData.URL);
		(new Sync(getDriver())).waitForPageToLoad();
	}
	
	/**
	 * Purpose - To test Rhyming activity 
	 */
	@Test(groups = { "QC" , "RC"}, priority = 1, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL007_Level1_rhyming(){
		//Step1: login to the LL Application  with student credentials. And Verify the Successful Login.		
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.rhymingStudent,
				llData.rhymingStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		//Step2: Click on the WelCome Button
		llactivity = studentWelcomePage.welcomeButton();	
		//Navigate/Select the bundle named Sorting Rhyming from Unit1 Lesson1 (Select same bundle for both QC and RC)
		rhyming = (Rhyming) llactivity.bundleSelector(8, isIexploreBrowser(), ActivityType.RHYMING, llData, executionMode);
		//Step4: Verify the navigation to the activity 
		rhyming.verifyRhymingActivity();
		//Follow the instructions and drag and drop the tiles into the answer area to make the rhyming pair
		rhyming.rhyming(isIexploreBrowser());
		// Ckick next button after completing the required 5 rhyming pairs
		rhyming.clickNextBtn();
		//Verify the summary page
		rhyming.activitySummary();
		//Logout from the activity 
		rhyming.clickLogoutfromActivty();
		rhyming.verifyLoginPage();
	}

	/**
	 * Purpose - To test syllabification activity
	 */
	@Test(groups = { "QC" }, priority = 2, retryAnalyzer = Retry.class)
	public void LL010_Level1_syllabification(){
		//Step1: login to the LL Application  with student credentials. And Verify the Successful Login.		
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.syllabificationUN,
				llData.syllabificationUN, LLLoginReturnPage.STUD_WELCOME_PAGE);

		studentWelcomePage.verifywelcomePage();
		//Step2: Click on the WelCome Button
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step 3: Navigate/ Select the bundle named 'Syllabification: talisman' from Uni1 Lesson1(Select 'malady' for QC and Select "talisman"for RC and repeat the steps 5 & 6 for all the bundles in the activity in RC mode) 
		syllabification = (Syllabification) llactivity.bundleSelector(11, isIexploreBrowser(),
				ActivityType.SYLLABIFICATION, llData, executionMode);
		//Step4: Verify the navigation to the selected activity 
		syllabification.verifySyllabificationActivity();
		//Step 5: Follow the audio instruction and complete the word by drag & dropping the letters
		syllabification.syllabification(isIexploreBrowser());
		//Step 6:  Verify the Summary page 
		syllabification.syllabificationSummary();
		//Step 7: Log out from activity 
		syllabification.clickLogoutfromActivty();
		//Step8 :Verify the successful logout
		syllabification.verifyLoginPage();
	}

	/**
	 * Purpose - To perform Quick check of Rhyming Advanced activity
	 */
	@Test(groups = { "QC" }, priority = 3, retryAnalyzer = Retry.class, timeOut = 1000000)
	public void LL024_Level1_rhymingAdvanced() {
		//Step1: login to the LL Application  with student credentials. And Verify the Successful Login.			
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.rhymingAdvStudent,
				llData.rhymingAdvStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		//Step2: Click on the WelCome Button
		llactivity = studentWelcomePage.welcomeButton();
		
		llactivity.verifyHomepage();
		//Step3:  Navigate/Select the bundle named RhymingAdvanced: boy, ball, toy, boys, tar from Unit8 Lesson1(Select RhymingAdvanced: sack, rake, rakes, racks, sake for QC and RhymingAdvanced: boy, ball, toy, boys, tar for RC and repeat steps5& 6 )
		rhymingAdvanced = (RhymingAdvanced) llactivity.bundleSelector(25, isIexploreBrowser(),
				ActivityType.RHYMING_ADVANCED, llData, executionMode);
		//Step4: Verify the navigation to the activity 
		rhymingAdvanced.verifyRymingAdvancedActivity();
		//Step 5: Follow the instructions and drag and drop the tiles into the left and right answer area to make the rhyming pair
		//Step6: Ckick next button after completing the rhyming pair
		rhymingAdvanced.rhymingAdvanced(isIexploreBrowser());
		//Step7: Verify the summary page
		rhymingAdvanced.rhymingAdvancedSummary();
		rhymingAdvanced.navigateToHomePagefromActivity();
		//Step 8: Logout from the activity 
		rhymingAdvanced.clickLogoutfromHomePage();
		//Step9 :Verify the successful logout
		rhymingAdvanced.verifyLoginPage();
	}
	
	/**
	 * Purpose - To test build a Word Family activity
	 */
	@Test(groups = { "QC" }, priority = 4, retryAnalyzer = Retry.class)
	public void LL014_Level1_BuildaWordFamily(){
		//Step1: login to the LL Application  with student credentials. And Verify the Successful Login.
		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.BuildWordStudent,
				llData.BuildWordStudent, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
		//Step2: Click on the WelCome Button
		llactivity = studentWelcomePage.welcomeButton();
		llactivity.verifyHomepage();
		//Step 3: Navigate/ Select the bundle named 'BuildAWordFamily: mrwgd' from Uni2 Lesson1(Select 'dpwgb' for QC and Select "mrwgd"for RC and repeat the steps 5 & 6 for all the bundles in the activity in RC mode) 
		buildaWordFamily = (BuildaWordFamily) llactivity.bundleSelector(15, isIexploreBrowser(),
				ActivityType.BUILD_WORD_FAMILY, llData, executionMode);
		//Step4: Verify the navigation to the selected activity 
		buildaWordFamily.verifyBuildaWordFamily();
		//Step 5: Follow the audio instruction and complete the word by drag & dropping the letters
		buildaWordFamily.buildaWordFamily(isIexploreBrowser());
		//Step 6: Log out from activity 
		buildaWordFamily.navigateToHomePagefromActivity();
		buildaWordFamily.clickLogoutfromHomePage();
		//Step8 :Verify the successful logout
		buildaWordFamily.verifyLoginPage();
	}
}
