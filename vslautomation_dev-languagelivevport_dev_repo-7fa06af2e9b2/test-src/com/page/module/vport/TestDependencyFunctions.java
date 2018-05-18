package com.page.module.vport;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.SafeActions;


public class TestDependencyFunctions extends CommonFunctionalitiesVPort{

	private Logger log = Logger.getLogger(getClass());
	public WebDriver driver;
	VportLoginPage vportloginpage;
	VportData vportData;
	AddorEditTrackPage addedittrack;
	VportTrackFilterPage vporttrackfilterPage;
	MasterDistrictTracksPage masterDistrictTracksPage;
	DistrictTrackContactsPage districtTrackContactsPage;
	DistrictTrackMaterialsPage districtTrackMaterialsPage;
	DistrictTrackSchoolTracksPage districtTrackSchoolTracksPage;
	ImplementationCardsPage implementationCardsPage;
	LLLogout llLogout;
	LLLoginPage llloginPage;
	LLHomePage llHomePage;
	LLData llData;

	public TestDependencyFunctions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		vportData = new VportData();
		llData = new LLData();
		// TODO Auto-generated constructor stub
	}


	public Map<String,String> LL_DISTRICTUSER_001_VerifyImplementationCardsforDistrictUserFirstLogin(VportLoginPage vportloginpage){
		log.info("Dependent Method called");
		if(dependentData.getProperty("newCampUser").equals("null"))
		{
			Map<String,String> newTrackSchoolUsers =createDistrictAndCampusUsers(vportloginpage);
			String distUser=newTrackSchoolUsers.get("newDistUser");
			// Login into Language live product
			llloginPage = new LLLoginPage(driver);
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
			LLLogout llLogout = new LLLogout(driver);
			llLogout.clickLogoutfromHomePage();
			// Login again into LL to check whether LLHome page displayed after
			// completion of IMplementation cards in the first login
			llloginPage.loginCredentials(llData.URL,distUser, vportData.distUserPassword,LLLoginReturnPage.IMPLEMENTATIONCARDS_PAGE);
			llHomePage.verifyLanguageLiveDashBoard();
			return newTrackSchoolUsers;
		}
		else
		{
			log.info("newTrackSchoolUsers are created already Getting the details from Property File");
			Map<String,String> newTrackSchoolUsers = new HashMap<>();
			newTrackSchoolUsers.put("newTrack", dependentData.getProperty("newTrack"));
			newTrackSchoolUsers.put("newSchool", dependentData.getProperty("newSchool"));
			newTrackSchoolUsers.put("newDistUser", dependentData.getProperty("newDistUser"));
			newTrackSchoolUsers.put("newCampUser", dependentData.getProperty("newCampUser"));
			return newTrackSchoolUsers;
		}
	}
	
	
	
	
	
	public Map<String,String> LL_DISTRICTUSER_001_VerifyImplementationCardsforDistrictUserFirstLogin_UsersWithTeacherAndCampusRole(VportLoginPage vportloginpage){
		log.info("Dependent Method called");
		if(dependentData.getProperty("newCampUser").equals("null"))
		{
			Map<String,String> newTrackSchoolUsers =createCampusUsersWithTeacherAndCampusRole(vportloginpage);
			String distUser=newTrackSchoolUsers.get("newDistUser");
			// Login into Language live product
			llloginPage = new LLLoginPage(driver);
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
			LLLogout llLogout = new LLLogout(driver);
			llLogout.clickLogoutfromHomePage();
			// Login again into LL to check whether LLHome page displayed after
			// completion of IMplementation cards in the first login
			llloginPage.loginCredentials(llData.URL,distUser, vportData.distUserPassword,LLLoginReturnPage.IMPLEMENTATIONCARDS_PAGE);
			llHomePage.verifyLanguageLiveDashBoard();
			
			dependentData.writeProperty("newTrack",newTrackSchoolUsers.get("newTrack"));
			dependentData.writeProperty("newSchool",newTrackSchoolUsers.get("newSchool"));
			dependentData.writeProperty("newDistUser",newTrackSchoolUsers.get("newDistUser"));
			dependentData.writeProperty("newCampUser",newTrackSchoolUsers.get("newCampUser"));
			
			return newTrackSchoolUsers;
		}
		else
		{
			log.info("newTrackSchoolUsers are created already Getting the details from Property File");
			Map<String,String> newTrackSchoolUsers = new HashMap<>();
			newTrackSchoolUsers.put("newTrack", dependentData.getProperty("newTrack"));
			newTrackSchoolUsers.put("newSchool", dependentData.getProperty("newSchool"));
			newTrackSchoolUsers.put("newDistUser", dependentData.getProperty("newDistUser"));
			newTrackSchoolUsers.put("newCampUser", dependentData.getProperty("newCampUser"));
			return newTrackSchoolUsers;
		}
	}
	//UsersWithTeacherAndCampusRole
	public void LL_002_CAMPUSUSER_VerifyImplementationCardsforCampusUserFirstLogin()
	{
		Map<String,String> newTrackSchoolUsers = LL_DISTRICTUSER_001_VerifyImplementationCardsforDistrictUserFirstLogin_UsersWithTeacherAndCampusRole(vportloginpage);
		String campUser =newTrackSchoolUsers.get("newCampUser");
		// // Login into Language live product
		llloginPage = new LLLoginPage(driver);
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
}
