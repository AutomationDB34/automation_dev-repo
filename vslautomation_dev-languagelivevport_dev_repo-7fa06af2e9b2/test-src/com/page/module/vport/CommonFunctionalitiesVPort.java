package com.page.module.vport;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.data.testdata.VportData.UserRole;
import com.datamanager.ConfigManager;
import com.page.locators.vport.CommonVPortLocators;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLLogout;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.selenium.Sync;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class CommonFunctionalitiesVPort extends SafeActions implements CommonVPortLocators {

	private VportData vportData;
	private AddorEditTrackPage addedittrack;
	private VportTrackFilterPage vporttrackfilterPage;
	MasterDistrictTracksPage masterDistrictTracksPage;
	DistrictTrackContactsPage districtTrackContactsPage;
	DistrictTrackMaterialsPage districtTrackMaterialsPage;
	DistrictTrackSchoolTracksPage districtTrackSchoolTracksPage;
	ImplementationCardsPage implementationCardsPage;
	DistrictAdminMyResultsPage districtAdminMyResultsPage;
	//String[] matchedScores=new String[3];
	//String [] unMatchedScores=new String[3];
	LLLogout llLogout;
	LLLoginPage llloginPage;
	LLHomePage llHomePage;
	//String schoolName[];
	private LLData llData;
	//String trackName;
	//String districtAdminUser;
	//String[] userNames= new String[2];
	private WebDriver driver;
	ConfigManager dependentData = new ConfigManager("DependentData");

	public CommonFunctionalitiesVPort(WebDriver driver) {
		super(driver);
		this.driver = driver;
		vportData = new VportData();
		llData = new LLData();
	}


	/**
	 * Purpose- To verify whether VPORT login page is being displayed or not
	 * @throws Exception
	 */	
	public void verifyLoginPage()
	{
		//waitForPageToLoad();
		waitForSecs(20);
		refresh();
		waitForSecs(26);
		boolean uNameSignInButtonExists = isElementPresent(USERNAME_FIELD,LONGWAIT);
		Assert.assertTrue(uNameSignInButtonExists,"User Name button is not being displayed on Login page");	
	}


	/**
	 * Log Out Functionality
	 * @return
	 */
	public VportLoginPage clickLogoutLink(){

		safeClick(LOGOUT_LINK, MEDIUMWAIT);
		return new VportLoginPage(driver);
	}

	public Map<String,String> createDistrictAndCampusUsers(VportLoginPage vportloginpage)
	{

		driver.get(vportData.vportURL);
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		String strRandom = UtilityMethods.get4DRandomNumber();
		addedittrack = vporttrackfilterPage.clickAddDistrictbutton();
		addedittrack.verfyDistrictPage();
		String trackName = addedittrack.fillTrackDetails(vportData.Districtname, vportData.Address, vportData.DistCity,
				vportData.Country, vportData.State, vportData.ZipCode, vportData.userType, llData.productName,
				vportData.Status,vportData.Year);
		vporttrackfilterPage = addedittrack.clickSaveChanges();

		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(llData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
		masterDistrictTracksPage = vporttrackfilterPage.clickOnMasterIcon(trackName);
		masterDistrictTracksPage.verifyMasterDistrictTracksPage();

		masterDistrictTracksPage.navigateToSchoolsSubtab();
		String schooldetails[] = masterDistrictTracksPage.CreateSchool(vportData.schoolName + strRandom, vportData.Code + strRandom,vportData.Address1, vportData.SchoolCity, vportData.zipCode);			
		masterDistrictTracksPage.navigateToUsersSubtab();
		masterDistrictTracksPage.clickAddUser();
		// To verify Add District User page is loaded
		masterDistrictTracksPage.verifyAddDistrictUserPage();
		// To Create District user

		String distUser = masterDistrictTracksPage.addDistrictUser(vportData.distUserLogin + strRandom,vportData.distUserFirstName, vportData.distUserLastName, vportData.distUserPassword);
		//districtLogin = districtAdminUser;
		masterDistrictTracksPage.navigateToSchoolUserTypeSubtab();
		masterDistrictTracksPage.clickAddNewStaff();
		String campUserLastnam = vportData.schoolUserLastName+UtilityMethods.get4DRandomNumber();
		String campUser = campUserLastnam.toLowerCase();
		masterDistrictTracksPage.createSchoolUserWithCampusUserRole(vportData.schoolUserFirstName,campUser, vportData.schoolUserEmail, schooldetails[0],
				UserRole.CAMPUS_USER);

		//	masterDistrictTracksPage.clickShowTeachers();
		// To edit the school user with new login and password

		String campusUser= masterDistrictTracksPage.EditSchoolUser(schooldetails[0], campUser,
				vportData.schoolUserPassword);
		//masterDistrictTracksPage.clickShowTeachers();
		// To verify school user after modifying
		masterDistrictTracksPage.verifyScholUserDetails(vportData.schoolUserFirstName, campUser,
				schooldetails[0],campusUser, vportData.schoolUserPassword,
				UserRole.CAMPUS_USER);
		vporttrackfilterPage = masterDistrictTracksPage.clickDistrictTracksMainHeading();
		districtTrackContactsPage = vporttrackfilterPage.clickonTrackName(trackName);
		districtTrackMaterialsPage = districtTrackContactsPage.clickMaterialsTab();

		districtTrackMaterialsPage.addAndVerifyLicences(vportData.licencegradelevel, vportData.licenceseatcount,
				vportData.reasonforaddinglicence, vportData.addLicenceAlertMessage,
				vportData.reasonForCreatingLicenceImagePath);

		districtTrackSchoolTracksPage=districtTrackContactsPage.clickSchoolTrackstab();
		districtTrackSchoolTracksPage.activateSchoolAndSave(schooldetails[0]);
		vportloginpage = clickLogoutLink();
		String newDetails[] ={trackName,schooldetails[0],distUser,campUser}; 
		Map<String,String> newTrackSchoolUsers = new HashMap<>();
		newTrackSchoolUsers.put("newTrack", newDetails[0]);
		newTrackSchoolUsers.put("newSchool", newDetails[1]);
		newTrackSchoolUsers.put("newDistUser", newDetails[2]);
		newTrackSchoolUsers.put("newCampUser", newDetails[3]);
		return newTrackSchoolUsers;
	}
	
	
	public Map<String,String> createCampusUsersWithTeacherAndCampusRole(VportLoginPage vportloginpage)
	{

		driver.get(vportData.vportURL);
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		String strRandom = UtilityMethods.get4DRandomNumber();
		addedittrack = vporttrackfilterPage.clickAddDistrictbutton();
		addedittrack.verfyDistrictPage();
		String trackName = addedittrack.fillTrackDetails(vportData.Districtname, vportData.Address, vportData.DistCity,
				vportData.Country, vportData.State, vportData.ZipCode, vportData.userType, llData.productName,
				vportData.Status,vportData.Year);
		vporttrackfilterPage = addedittrack.clickSaveChanges();

		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters(llData.productName, vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
		masterDistrictTracksPage = vporttrackfilterPage.clickOnMasterIcon(trackName);
		masterDistrictTracksPage.verifyMasterDistrictTracksPage();

		masterDistrictTracksPage.navigateToSchoolsSubtab();
		String schooldetails[] = masterDistrictTracksPage.CreateSchool(vportData.schoolName + strRandom, vportData.Code + strRandom,vportData.Address1, vportData.SchoolCity, vportData.zipCode);			
		masterDistrictTracksPage.navigateToUsersSubtab();
		masterDistrictTracksPage.clickAddUser();
		// To verify Add District User page is loaded
		masterDistrictTracksPage.verifyAddDistrictUserPage();
		// To Create District user

		String distUser = masterDistrictTracksPage.addDistrictUser(vportData.distUserLogin + strRandom,vportData.distUserFirstName, vportData.distUserLastName, vportData.distUserPassword);
		//districtLogin = districtAdminUser;
		masterDistrictTracksPage.navigateToSchoolUserTypeSubtab();
		masterDistrictTracksPage.clickAddNewStaff();
		String campUserLastnam = vportData.schoolUserLastName+UtilityMethods.get4DRandomNumber();
		String campUser = campUserLastnam.toLowerCase();
		masterDistrictTracksPage.createSchoolUserWithCampusAndTeacherRole(vportData.schoolUserFirstName,campUser, vportData.schoolUserEmail, schooldetails[0],
				UserRole.CAMPUS_USER);

		//	masterDistrictTracksPage.clickShowTeachers();
		// To edit the school user with new login and password

		String campusUser= masterDistrictTracksPage.EditSchoolUserAndAssignteacherRole(schooldetails[0], campUser,
				vportData.schoolUserPassword,schooldetails[0]);
		//masterDistrictTracksPage.clickShowTeachers();
		// To verify school user after modifying
		masterDistrictTracksPage.verifyScholUserDetails(vportData.schoolUserFirstName, campUser,
				schooldetails[0],campusUser, vportData.schoolUserPassword,
				UserRole.CAMPUS_USER,UserRole.TEACHER);
		vporttrackfilterPage = masterDistrictTracksPage.clickDistrictTracksMainHeading();
		districtTrackContactsPage = vporttrackfilterPage.clickonTrackName(trackName);
		districtTrackMaterialsPage = districtTrackContactsPage.clickMaterialsTab();

		districtTrackMaterialsPage.addAndVerifyLicences(vportData.licencegradelevel, vportData.licenceseatcount,
				vportData.reasonforaddinglicence, vportData.addLicenceAlertMessage,
				vportData.reasonForCreatingLicenceImagePath);

		districtTrackSchoolTracksPage=districtTrackContactsPage.clickSchoolTrackstab();
		districtTrackSchoolTracksPage.activateSchoolAndSave(schooldetails[0]);
		vportloginpage = clickLogoutLink();
		String newDetails[] ={trackName,schooldetails[0],distUser,campUser}; 
		Map<String,String> newTrackSchoolUsers = new HashMap<>();
		newTrackSchoolUsers.put("newTrack", newDetails[0]);
		newTrackSchoolUsers.put("newSchool", newDetails[1]);
		newTrackSchoolUsers.put("newDistUser", newDetails[2]);
		newTrackSchoolUsers.put("newCampUser", newDetails[3]);
		return newTrackSchoolUsers;
	}


	public Map<String,String[]> benchmarkScoresFromVport(VportLoginPage vportloginpage)
	{

		if(dependentData.getProperty("UnMatchedScore3").equals("null"))
		{
			driver.get(vportData.vportURL);
			vportloginpage.verifyLoginPage();
			vportloginpage.enterLoginCredentials(llData.llDistrictAdmin, llData.llDistrictAdmin);
			districtAdminMyResultsPage = (DistrictAdminMyResultsPage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICTRESULTSPAGE);		
			String[] matchedScores = getMatchedscoresfromVportMyResultsPage(districtAdminMyResultsPage);
			String[] unMatchedScores = getUnMatchedscoresfromVportMyResultsPage(districtAdminMyResultsPage);
			Map<String,String[]> scores = new HashMap<String, String[]>();
			scores.put("MatchedScores", matchedScores);
			scores.put("UnMatchedScores", unMatchedScores);
			return scores;
		}
		else
		{
			String[] matchedScores = new String[3];
			matchedScores[0] = dependentData.getProperty("MatchedScore1");
			matchedScores[1] = dependentData.getProperty("MatchedScore2");
			matchedScores[2] = dependentData.getProperty("MatchedScore3");
			String[] unMatchedScores = new String[3];
			unMatchedScores[0] = dependentData.getProperty("UnMatchedScore1");
			unMatchedScores[1] = dependentData.getProperty("UnMatchedScore2");
			unMatchedScores[2] = dependentData.getProperty("UnMatchedScore3");
			Map<String,String[]> existingScores = new HashMap<String, String[]>();
			existingScores.put("MatchedScores", matchedScores);
			existingScores.put("UnMatchedScores", unMatchedScores);
			return existingScores;
		}


	}

	public String[] getMatchedscoresfromVportMyResultsPage(DistrictAdminMyResultsPage districtAdminMyResultsPage) {

		districtAdminMyResultsPage.verifyMyResultspage();
		districtAdminMyResultsPage.clickMatchedradioButton();
		String matchedScores[] = new String[3];
		matchedScores[0] = districtAdminMyResultsPage.getPARLexileScore(llData.LLSchoolName);
		matchedScores[1] = districtAdminMyResultsPage.getTOSCARFScore(llData.LLSchoolName);
		matchedScores[2] = districtAdminMyResultsPage.getTWS4Score(llData.LLSchoolName);
		dependentData.writeProperty("MatchedScore1",matchedScores[0]);
		dependentData.writeProperty("MatchedScore2", matchedScores[1]);
		dependentData.writeProperty("MatchedScore3", matchedScores[2]);
			
		return matchedScores;

	}

	public String[] getUnMatchedscoresfromVportMyResultsPage(DistrictAdminMyResultsPage districtAdminMyResultsPage) {

		districtAdminMyResultsPage.verifyMyResultspage();
		districtAdminMyResultsPage.clickUnMatchedradioButton();
		String unMatchedScores[] = new String[3];
		unMatchedScores[0] = districtAdminMyResultsPage.getPARLexileScore(llData.LLSchoolName);
		unMatchedScores[1] = districtAdminMyResultsPage.getTOSCARFScore(llData.LLSchoolName);
		unMatchedScores[2] = districtAdminMyResultsPage.getTWS4Score(llData.LLSchoolName);
		dependentData.writeProperty("UnMatchedScore1", unMatchedScores[0]);
		dependentData.writeProperty("UnMatchedScore2", unMatchedScores[1]);
		dependentData.writeProperty("UnMatchedScore3", unMatchedScores[2]);
		return unMatchedScores;

	}
	
	
	/**
	 * Purpose is to Click on My District Page
	 */
	public DistrictAdminMyDistrictPage clickOnMyDistrictLink()
	{
		safeClick(MY_DISTRICT, MEDIUMWAIT);
		waitForPageToLoad();
		return new DistrictAdminMyDistrictPage(driver);
	}

}
