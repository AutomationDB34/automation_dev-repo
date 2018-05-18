package com.testsuite.ll.admin;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.data.testdata.VportData.UserRole;
import com.datamanager.ConfigManager;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.vport.AddorEditTrackPage;
import com.page.module.vport.DistrictTrackContactsPage;
import com.page.module.vport.DistrictTrackMaterialsPage;
import com.page.module.vport.DistrictTrackSchoolTracksPage;
import com.page.module.vport.MasterDistrictTracksPage;
import com.page.module.vport.TestDependencyFunctions;
import com.page.module.vport.VportLoginPage;

import com.page.module.vport.VportTrackFilterPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class LLAdminLoginScenarios extends BaseSetup {

	private VportLoginPage vportloginpage;
	private VportData vportData;
	private AddorEditTrackPage addedittrack;
	private VportTrackFilterPage vporttrackfilterPage;
	MasterDistrictTracksPage masterDistrictTracksPage;
	DistrictTrackContactsPage districtTrackContactsPage;
	DistrictTrackMaterialsPage districtTrackMaterialsPage;
	DistrictTrackSchoolTracksPage districtTrackSchoolTracksPage;
	ImplementationCardsPage implementationCardsPage;
	LLLogout llLogout;
	LLLoginPage llloginPage;
	LLHomePage llHomePage;
	LLData llData;
	ConfigManager dependentData = new ConfigManager("DependentData");
	TestDependencyFunctions testDependencyFunctions;
	/*String schoolName[];
	private 
	String trackName;
	String districtAdminUser;
	String[] userNames= new String[2];
	boolean trackCreated = false;
*/

	@BeforeMethod(alwaysRun = true)
	public void BaseSetUp() {
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		llData = new LLData();
		testDependencyFunctions = new TestDependencyFunctions(getDriver());
		getDriver().manage().deleteAllCookies();	
		(new Sync(getDriver())).waitForPageToLoad();


	}

	/**
	 * This Test verifies Implementation cards are displayed for  District User First Login and fill all details in implementation cards and verifies LL Home Page 
	 */
	@Test(groups = {"DistrictUSer","RC","QC" }, priority=1,retryAnalyzer = Retry.class,timeOut = 1000000)
	public void LL_001_DISTRICTUSER_VerifyImplementationCardsforDistrictUserFirstLogin(){
		//PreCondition
		Map<String,String> newTrackSchoolUsers =vportloginpage.createDistrictAndCampusUsers(vportloginpage);
		String distUser=newTrackSchoolUsers.get("newDistUser");
		// Login into Language live product
		llloginPage = new LLLoginPage(getDriver());
		implementationCardsPage=(ImplementationCardsPage) llloginPage.loginCredentials(llData.URL,distUser, vportData.distUserPassword,LLLoginReturnPage.IMPLEMENTATIONCARDS_PAGE);
		// Move to Welcome Frame
		implementationCardsPage.moveToWelcomeFrame();
		// Verifies Welcome page after first login of district User
		implementationCardsPage.verifyWelcomePage();
		// Enters Data into Welcome Screen
		implementationCardsPage.completeProfileinWelcomePage(llData.testEmail);
		// Verifies all implementation cards are existed
		implementationCardsPage.verifyAllImplementationTabsExistsforDistrictUser();
		// Complete About tab by filling details
		implementationCardsPage.completeAboutTab();
		// Complete Goals tab by filling details
		implementationCardsPage.completeGoalsTab();
		// Complete Participation tab by filling details
		implementationCardsPage.completeParticipationTab();
		// Complete Create plan tab by filling details
		implementationCardsPage.completeCreatePlanTab();
		// Complete Training tab by filling details
		implementationCardsPage.completeTrainingTab();
		// Complete Technology tab by filling details
		implementationCardsPage.completeTechnologyTab();
		// Complete Import data tab by filling details
		llHomePage = implementationCardsPage.completeImportDataTab();
		// Move to default frame from Welcome frame
		implementationCardsPage.defaultFrame();
		// verifies Language Live Home page
		llHomePage.verifyLanguageLiveDashBoard();
		// LOgout from LL
		LLLogout llLogout = new LLLogout(getDriver());
		llLogout.clickLogoutfromHomePage();
		// Login again into LL to check whether LLHome page displayed after
		// completion of IMplementation cards in the first login
		llloginPage.loginCredentials(llData.URL,distUser, vportData.distUserPassword,LLLoginReturnPage.IMPLEMENTATIONCARDS_PAGE);
		llHomePage.verifyLanguageLiveDashBoard();
		dependentData.writeProperty("newTrack",newTrackSchoolUsers.get("newTrack"));
		dependentData.writeProperty("newSchool",newTrackSchoolUsers.get("newSchool"));
		dependentData.writeProperty("newDistUser",newTrackSchoolUsers.get("newDistUser"));
		dependentData.writeProperty("newCampUser",newTrackSchoolUsers.get("newCampUser"));
	}
	
	/**
	 * This Test verifies Implementation cards are displayed for  Campus User First Login and fill all details in implementation cards and verifies LL Home Page 
	 * @throws Exception
	 */

	@Test(groups = {"CampusUser","RC","QC" },priority=2,retryAnalyzer = Retry.class,timeOut = 1000000)
	public void LL_002_CAMPUSUSER_VerifyImplementationCardsforCampusUserFirstLogin()
	{
		Map<String,String> newTrackSchoolUsers = testDependencyFunctions.LL_DISTRICTUSER_001_VerifyImplementationCardsforDistrictUserFirstLogin(vportloginpage);
		String campUser =newTrackSchoolUsers.get("newCampUser");
		// // Login into Language live product
		llloginPage = new LLLoginPage(getDriver());
		implementationCardsPage=(ImplementationCardsPage) llloginPage.loginCredentials(llData.URL,campUser, vportData.distUserPassword,LLLoginReturnPage.IMPLEMENTATIONCARDS_PAGE);
		// Move to Welcome Frame
		implementationCardsPage.moveToWelcomeFrame();
		// Verifies Welcome page after first login of district User
		implementationCardsPage.verifyWelcomePage();
		// Enters Data into Welcome Screen
		implementationCardsPage.completeProfileinWelcomePage(llData.testEmail);
		// Verifies all implementation cards are existed
		implementationCardsPage.verifyAllImplementationTabsExistsforCampusUser();
		// Complete About tab by filling details
		implementationCardsPage.completeAboutTab();
		// Complete Goals tab by filling details
		implementationCardsPage.completeGoalsTab();
		// Complete Participation tab by filling details
		implementationCardsPage.completeParticipationTab();
		// Complete Create plan tab by filling details
		implementationCardsPage.completeReviewPlanTab();
		// Complete Training tab by filling details
		implementationCardsPage.completeTrainingTab();
		// Complete Technology tab by filling details
		implementationCardsPage.completeTechnologyTab();
		// Complete Import data tab by filling details
		llHomePage = implementationCardsPage.completeImportDataTab();
		// Move to default frame from Welcome frame
		implementationCardsPage.defaultFrame();
		// verifies Language Live Home page
		llHomePage.verifyLanguageLiveDashBoard();
		// Login again into LL to check whether LLHome page displayed after
		// completion of IMplementation cards in the first login
		llloginPage.loginCredentials(llData.URL,campUser, vportData.distUserPassword,LLLoginReturnPage.IMPLEMENTATIONCARDS_PAGE);
		llHomePage.verifyLanguageLiveDashBoard();		
	}
	
	@AfterClass
	public void makeNullCreatedDetails()
	{
		ConfigManager dependentData = new ConfigManager("DependentData");
		dependentData.writeProperty("newTrack","null");
		dependentData.writeProperty("newSchool","null");
		dependentData.writeProperty("newDistUser","null");
		dependentData.writeProperty("newCampUser","null");
	}
}


