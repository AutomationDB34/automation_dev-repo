package com.testsuite.vport;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.data.testdata.VportData;
import com.datamanager.ConfigManager;
import com.page.module.vport.DistrictAdminOrientationPage;
import com.page.module.vport.DistrictAdminPrivacyPage;
import com.page.module.vport.DistrictAdminWelcomePage;
import com.page.module.vport.MyDistrictPage;
import com.page.module.vport.VportLoginPage;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.Sync;

public class E2CreateUserswithDistrictUser extends BaseSetup {
	
	
	private VportLoginPage vportloginpage;
	private VportData vportData;
	private DistrictAdminOrientationPage districtAdminOrientationPage;
	private DistrictAdminPrivacyPage districtAdminPrivacyPage;
	private DistrictAdminWelcomePage districtAdminWelcomePage;
	private MyDistrictPage myDistrictPage;
	ConfigManager dependentData = new ConfigManager("DependentData");
	
	
	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetUp() {
		vportloginpage = new VportLoginPage(getDriver());
		vportData = new VportData();
		getDriver().manage().deleteAllCookies();
		getDriver().get(vportData.vportURL);
		(new Sync(getDriver())).waitForPageToLoad();
		vportloginpage.verifyLoginPage();
		vportloginpage.enterLoginCredentials(dependentData.getProperty("VPORT_002_DistrictUserName") , vportData.distUserPassword);
//		vportloginpage.enterLoginCredentials("zenautodistuser1445410143641" , vportData.distUserPassword);
		districtAdminPrivacyPage = (DistrictAdminPrivacyPage)vportloginpage.clickSignInButton(ReturnPage.PRIVACYPAGE);
		
	}
	
	@Test(priority=5, groups = { "RC", "QC" } )
	public void VPORT_005_districtAdminLogin(){
		//District admin user privacy agreement page
		districtAdminPrivacyPage.verifyPrivacyPage();
		districtAdminPrivacyPage.acceptPrivacy(vportData.districtAdminName , vportData.districtAdminTitle);
		districtAdminWelcomePage = districtAdminPrivacyPage.clickAcceptBtn();
		
		//District admin user profile information
		districtAdminWelcomePage.verifAdminWelcomePage();
		districtAdminOrientationPage = districtAdminWelcomePage.profileInformation(vportData.districtAdminEMail , vportData.districtAdmintraining);
		
		//Verifying the Orientation pages for Disrtict admin user for the first login and check school sctivation
		districtAdminOrientationPage.verifyOrientationPage();
		myDistrictPage = districtAdminOrientationPage.orientatonpages();
		myDistrictPage.verifyMyDistrictPage();
		myDistrictPage.activateSchool();
		
	}
}
