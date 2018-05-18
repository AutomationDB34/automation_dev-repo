package com.testsuite.basedata;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.VportData;
import com.datamanager.ConfigManager;
import com.page.module.vport.AddorEditTrackPage;
import com.page.module.vport.DistrictAdminHomepage;
import com.page.module.vport.DistrictAdminMyClassPage;
import com.page.module.vport.DistrictAdminMySchoolPage;
import com.page.module.vport.DistrictAdminPrivacyPage;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportTrackFilterPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.Sync;
import com.testng.Retry;
import com.testsuite.vport.E1CreateTracksAndAddAdminUsers;

public class BaseDataCreation extends BaseSetup
{
	private VportLoginPage vportloginpage ;
	private VportData vportData;
	private VportTrackFilterPage vporttrackfilterPage;
	BaseDataFunctionalities baseData = new BaseDataFunctionalities(getDriver());
	private DistrictAdminHomepage districtAdminHomepage;
	private DistrictAdminMySchoolPage districtAdminMySchoolPage;
	private DistrictAdminMyClassPage districtAdminMyClassPage;
	private DistrictAdminPrivacyPage districtAdminPrivacyPage;
	ConfigManager dependentData = new ConfigManager("DependentData");

	public BaseDataCreation()
	{

	}

	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp()
	{


	}

	@Test
	public void VPORT_Build_001_CreateNewTrackWithBuildNumber()
	{
		String trackName="zenqtest3";
		String buildNumber="163";
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		String newTrackName=baseData.CreateNewTrack(trackName,buildNumber,vportData,vporttrackfilterPage);	
		dependentData.writeProperty("VPORTBuild_TrackName", newTrackName);
	}

	@Test
	public void VPORT_Build_002_CreateNewSchoolAndUserstotheTrack()
	{
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		String[] schoolUserDetails=baseData.AddSchoolAndUserstotheTrack(vporttrackfilterPage,vportData);
		dependentData.writeProperty("VPORT_Build_DistrictUserName",schoolUserDetails[0]);
		dependentData.writeProperty("VPORT_Build_SchoolUser",schoolUserDetails[1]);
		dependentData.writeProperty("VPORT_Build_SchoolName", schoolUserDetails[2]);
		dependentData.writeProperty("VPORT_Build_SchoolCode", schoolUserDetails[3]);

	}
	@Test
	public void VPORT_Build_003_ActivatingSchool()
	{
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
	
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		baseData.ActivatingSchool(vporttrackfilterPage,vportData);
	}

	@Test
	public void VPORT_Build_004_AddLicenceTypesAndVerifyAssessmentPlans()
	{
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
	
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(vportData.vportUsername, vportData.vportPassword);
		vporttrackfilterPage = (VportTrackFilterPage) vportloginpage.clickSignInButton(ReturnPage.FILTERPAGE);
		baseData.AddLicenceTypesAndVerifyAssessmentPlans(vporttrackfilterPage,vportData);
	}

	@Test
	public void VPORT_Build_005_districtAdminLogin()
	{
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(dependentData.getProperty("VPORT_Build_DistrictUserName") , vportData.distUserPassword);
		//		vportloginpage.enterLoginCredentials("zenautodistuser1445410143641" , vportData.distUserPassword);
		districtAdminPrivacyPage = (DistrictAdminPrivacyPage)vportloginpage.clickSignInButton(ReturnPage.PRIVACYPAGE);
		baseData.DistrictAdminLogin(districtAdminPrivacyPage,vportData);
	}


	@Test
	public void VPORT_Build_006_AddTeachersandClassestoSchool()
	{
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
		String distAdminPassword = vportData.distUserPassword;
		//		if(districtLogin == null){
		//			districtLogin = vportData.districtAdminUserName;
		//			distAdminPassword = vportData.districtAdminPassword;
		//		}
		vportloginpage.enterLoginCredentials(dependentData.getProperty("VPORT_Build_DistrictUserName"), distAdminPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		String[] classes=baseData.AddTeachersandClassestoSchool(districtAdminHomepage,vportData);
		dependentData.writeProperty("VPORT_BUILD_CLASS1", classes[0]);
		dependentData.writeProperty("VPORT_BUILD_CLASS2", classes[1]);
	}

	@Test
	public void VPORT_Build_007_AddStudentsToTheTeacherClasses()
	{
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
		String distAdminPassword = vportData.distUserPassword;
		//		if(districtLogin == null){
		//			districtLogin = vportData.districtAdminUserName;
		//			distAdminPassword = vportData.districtAdminPassword;
		//		}
		vportloginpage.enterLoginCredentials(dependentData.getProperty("VPORT_Build_DistrictUserName"), distAdminPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		
			String studentIDCreated=baseData.AddStudentsToTheTeacherClasses(districtAdminHomepage,vportData);
			dependentData.writeProperty("VPORT_Build_CreatedStudentID", studentIDCreated);
				
	}

	@Test
	public void VPORT_Build_008_AssignLicensesToStudentAvailableinClasss()
	{

		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
		String distAdminPassword = vportData.distUserPassword;
		//		if(districtLogin == null){
		//			districtLogin = vportData.districtAdminUserName;
		//			distAdminPassword = vportData.districtAdminPassword;
		//		}
		vportloginpage.enterLoginCredentials(dependentData.getProperty("VPORT_Build_DistrictUserName"), distAdminPassword);
		districtAdminHomepage = (DistrictAdminHomepage) vportloginpage.clickSignInButton(ReturnPage.MYDISTRICPAGE);
		baseData.AssignLicensesToStudentAvailableinClasss(districtAdminHomepage,vportData);
	}

}
