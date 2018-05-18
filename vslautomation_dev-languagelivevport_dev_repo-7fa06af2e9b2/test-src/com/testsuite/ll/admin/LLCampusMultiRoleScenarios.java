package com.testsuite.ll.admin;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.datamanager.ConfigManager;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.admin.MultiRoleScenariosPage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.vport.AddorEditTrackPage;
import com.page.module.vport.DistrictAdminHomepage;
import com.page.module.vport.DistrictAdminMyDistrictPage;
import com.page.module.vport.DistrictAdminMyResultsPage;
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.DistrictAdminOrientationPage;
import com.page.module.vport.DistrictAdminPrivacyPage;
import com.page.module.vport.DistrictAdminWelcomePage;
import com.page.module.vport.DistrictTrackContactsPage;
import com.page.module.vport.DistrictTrackMaterialsPage;
import com.page.module.vport.DistrictTrackSchoolTracksPage;
import com.page.module.vport.MasterDistrictTracksPage;
import com.page.module.vport.MyDistrictPage;
import com.page.module.vport.TestDependencyFunctions;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportTrackFilterPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class LLCampusMultiRoleScenarios extends BaseSetup {

	private VportLoginPage vportloginpage;
	private VportData vportData;
	private AddorEditTrackPage addedittrack;
	private VportTrackFilterPage vporttrackfilterPage;
	MasterDistrictTracksPage masterDistrictTracksPage;
	DistrictTrackContactsPage districtTrackContactsPage;
	DistrictTrackMaterialsPage districtTrackMaterialsPage;
	private DistrictAdminMySchoolPage districtAdminMySchoolPage;
	private DistrictAdminOrientationPage districtAdminOrientationPage;
	DistrictAdminMyResultsPage districtAdminMyResultsPage;
	private DistrictAdminPrivacyPage districtAdminPrivacyPage;
	private DistrictAdminWelcomePage districtAdminWelcomePage;
	MultiRoleScenariosPage multiRoleScenariosPage;
	DistrictAdminMyDistrictPage districtAdminMyDistrictPage;
	private MyDistrictPage myDistrictPage;
	DistrictTrackSchoolTracksPage districtTrackSchoolTracksPage;
	DistrictAdminHomepage districtAdminHomepage;
	ImplementationCardsPage implementationCardsPage;
	LLLogout llLogout;
	LLLoginPage llloginPage;
	LLHomePage llHomePage;
	LLData llData;
	ConfigManager dependentData = new ConfigManager("DependentData");
	TestDependencyFunctions testDependencyFunctions;

	@BeforeMethod(alwaysRun = true)
	public void BaseSetUp() {
		vportloginpage = new VportLoginPage(getDriver());
		llloginPage = new LLLoginPage(getDriver());
		vportData = new VportData();
		llData = new LLData();
		testDependencyFunctions = new TestDependencyFunctions(getDriver());
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();
	}

	@Test(retryAnalyzer = Retry.class)
	public void LL_ADMIN_001_CAMPUS_MULTIROLE_SCENARIO() {

		// 1.Login into application
		// https://qa.languagelive.voyagersopris.com/services/logon with campus
		// multi role user credentials.
		// 2.User displayed with welcome screen
		// 3.Enter required fields(mail id, Source of training & check the
		// accept terms box) in the welcome screen
		// 4.Click on the 'Save & Continue' button.
		// 5.User displayed with 7 implementation cards pane.
		// 6.User need to complete all 7 cards or skip those cards.
		// 7.Click on the 'Go to my dashboard' button.
		// 8.User displayed with screen where user can select either campus role
		// or teacher role
		// 9.User need to select any one of the option.
		// 10.By clicking on the save and continue button user should be
		// displayed with selected role dashboard.
		Map<String, String> newTrackSchoolUsers = testDependencyFunctions
				.LL_DISTRICTUSER_001_VerifyImplementationCardsforDistrictUserFirstLogin_UsersWithTeacherAndCampusRole(
						vportloginpage);
		String campUser = newTrackSchoolUsers.get("newCampUser");
		// // Login into Language live product
		llloginPage = new LLLoginPage(getDriver());
		implementationCardsPage = (ImplementationCardsPage) llloginPage.loginCredentials(llData.URL, campUser,
				vportData.distUserPassword, LLLoginReturnPage.IMPLEMENTATIONCARDS_PAGE);
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

		getDriver().get(vportData.vportURL);
		vportloginpage.verifyLoginPage();

		String trackName = dependentData.getProperty("newTrack");
		String schoolName = dependentData.getProperty("newSchool");

		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		vporttrackfilterPage.trackFilters(llData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
		districtAdminMyResultsPage = vporttrackfilterPage.clickOnPiIcon(trackName);
		districtAdminMyDistrictPage = districtAdminMyResultsPage.clickMyDistrictTab();
		districtAdminMyDistrictPage.selectSchoolFromAllSchools(schoolName);

		// Navigate to My school tab after selecting a class from classes
		// dropdown and verifies it
		districtAdminMySchoolPage = districtAdminMyDistrictPage.clickOnMySchoolTab();
		// Navigate to Teachers and classes tab and verifies it
		districtAdminMySchoolPage.navigateToTeachersAndClassesSubtab();
		districtAdminMySchoolPage.verifyTeachersAndClassesSubtab();

		districtAdminMySchoolPage.addClassesandSaveofLL(dependentData.getProperty("newCampUser"));

		districtAdminMySchoolPage.assignLicenseToTeacher();
		vportloginpage = districtAdminMySchoolPage.clickLogoutLink();
		vportloginpage.verifyLoginPage();

		getDriver().get(llData.URL);
		multiRoleScenariosPage = (MultiRoleScenariosPage) llloginPage.loginCredentials(llData.URL,
				dependentData.getProperty("newCampUser"), vportData.distUserPassword,
				LLLoginReturnPage.MULTIROLE_SELECTION_PAGE);
		multiRoleScenariosPage.verifyMultiroleSelectionPage();
		multiRoleScenariosPage.selectCampusRole();
		multiRoleScenariosPage.verifyCampusDashboard();
		multiRoleScenariosPage.changeRole();
		multiRoleScenariosPage.verifyTeacherDashboard();

	}

 @AfterClass
	public void makeNullCreatedDetails() {
		ConfigManager dependentData = new ConfigManager("DependentData");
		dependentData.writeProperty("newTrack", "null");
		dependentData.writeProperty("newSchool", "null");
		dependentData.writeProperty("newDistUser", "null");
		dependentData.writeProperty("newCampUser", "null");
	}
}
