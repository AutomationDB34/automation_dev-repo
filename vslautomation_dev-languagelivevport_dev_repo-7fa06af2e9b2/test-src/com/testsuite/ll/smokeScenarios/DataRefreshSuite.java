package com.testsuite.ll.smokeScenarios;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.datamanager.ConfigManager;
import com.page.module.dibelsnext.DibelsNextLoginPage;
import com.page.module.dibelsnext.StudentCenterPage;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.vport.AddorEditTrackPage;
import com.page.module.vport.DistrictAdminHomepage;
import com.page.module.vport.DistrictAdminMyClassPage;
import com.page.module.vport.DistrictAdminMyDistrictPage;
import com.page.module.vport.DistrictAdminMyResultsPage;
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.DistrictTrackContactsPage;
import com.page.module.vport.DistrictTrackMaterialsPage;
import com.page.module.vport.DistrictTrackSchoolTracksPage;
import com.page.module.vport.DistrictTrackTechnologyPage;
import com.page.module.vport.MasterDistrictTracksPage;
import com.page.module.vport.TeacherLoginScenarios;
import com.page.module.vport.VportAdministrationPageAllTabs;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportTrackFilterPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.selenium.Sync;
import com.utilities.UtilityMethods;

public class DataRefreshSuite extends BaseSetup
{
	private VportLoginPage vportloginpage;
	private VportData vportData;
	private DistrictAdminHomepage districtAdminHomepage;
	private DistrictAdminMySchoolPage districtAdminMySchoolPage;
	private DistrictAdminMyClassPage districtAdminMyClassPage;
	private VportTrackFilterPage vporttrackfilterPage;
	//ivate MasterDistrictTracksPage masterDistrictTracksPage;
	private DistrictAdminMyResultsPage districtAdminMyresultsPage;
	LLLoginPage llloginPage;

	ConfigManager dependentData = new ConfigManager("DependentData");
	ConfigManager app = new ConfigManager("App");
	private LLData llData;

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() 
	{
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		llData = new LLData();
		getDriver().manage().deleteAllCookies();
	}

	@Test
	public void TEST_DELETE_STUDENTS() 
	{
		
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
		//vportloginpage.enterLoginCredentials(vportData.vportUsername,vportData.vportPassword);
		//districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		String trackName = vportData.districAdminTrackName;
		String classNames[] = {llData.LLClassName+" LL"};
		String schoolName = llData.LLSchoolName;
		// verify admin Home page
		//districtAdminHomepage.verifyHomePage(trackName, vportData.productName);
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		vporttrackfilterPage.verifyFilterPage();
		vporttrackfilterPage.trackFilters("Language! Live", vportData.userType, vportData.alpha, trackName);
		vporttrackfilterPage.clickUpdateButton();
		vporttrackfilterPage.verifyTrackCreation(trackName);
		//String schoolName = config.getProperty("VPORT_002_SchoolName");
		// To navigate to master page of track
		districtAdminMyresultsPage = vporttrackfilterPage.clickOnPiIcon(trackName);
		// To Verify master page by 'District' tab is loaded
		districtAdminMyresultsPage.verifyMyResultspage();
		districtAdminHomepage=districtAdminMyresultsPage.navigateToDistrictAdmin();
		//districtAdminHomepage = masterDistrictTracksPage.navigateToDistrictAdmin();
		// Selects school from school dropdown
		districtAdminHomepage.selectSchoolFromDropdown(schoolName);
		// Navigate to My school tab after selecting a class from classes dropdown and verifies it
		districtAdminMySchoolPage = districtAdminHomepage.clickOnMySchoolTab();
		districtAdminMyClassPage=districtAdminMySchoolPage.selectClassFromClassDropDown(classNames[0]);
		//districtAdminMyClassPage=districtAdminHomepage.clickOnMyClass();
		districtAdminMyClassPage.clickOnRoster();
		//Verifies navigation to My Class tab->Reroster page for the selected class1
		districtAdminMyClassPage.verifyNavigationToMyClassTabRoster(classNames[0]);
		//Clicks add students button on the roster page of class1
		//districtAdminMyClassPage.clickAddStudentsButtonOnMYClassRostersMainPage();
		districtAdminMyClassPage.deleteExtraStudents();
	}
	
	//@Test
	public void CREATE_STUDENTS() 
	{
		
		
		llloginPage = new LLLoginPage(getDriver());
		  String newStudents[] = llloginPage.createStudents(llloginPage, llData.LL005_Goals_Student_Level,
				llData.LL005_Goals_Student_Unit, llData.teacherLLUsername,
					llData.LL005_Goals_Student_Recording_Need,8);
	}
}
