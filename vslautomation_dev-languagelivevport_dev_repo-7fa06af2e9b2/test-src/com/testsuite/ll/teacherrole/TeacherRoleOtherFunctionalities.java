package com.testsuite.ll.teacherrole;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.data.testdata.LLData;
import com.page.module.ll.level1activities.LLLoginPage;
import com.page.module.ll.level1activities.LLStudentHomePage;
import com.page.module.ll.level1activities.StudentWelcomePage;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.selenium.Sync;
import com.testng.Retry;

public class TeacherRoleOtherFunctionalities  extends BaseSetup
{
	private LLData llData;
	private LLLoginPage llloginPage;
	LLStudentHomePage llstudentHomePage;
	StudentWelcomePage studentWelcomePage;
	String studentScoreDetails[] = new String[4];



	@BeforeMethod(alwaysRun = true)
	public void BaseClassSetup()throws Exception
	{
		llData = new LLData();	
		llloginPage = new LLLoginPage(getDriver());
		getDriver().manage().deleteAllCookies();
		(new Sync(getDriver())).waitForPageToLoad();
	}

	@Test(groups = {"RC"}, priority = 1, retryAnalyzer = Retry.class)
	public void LL_004_DashboardSelectStudentAndVerifyProgress()
	{
		/*	1. Login into the LL application with teacher credentials
		2. Hover on the user name to view the user drop down fields
		3. Now click on the 'Check mic' link
		4. Find that check mic pop up is dispalyed
		5. Now click 'Start' button to check the microphone */

		studentWelcomePage = (StudentWelcomePage) llloginPage.loginCredentials(llData.URL,llData.teacherRoleLLStudentFirstName,
				llData.teacherRoleLLStudentFirstName, LLLoginReturnPage.STUD_WELCOME_PAGE);
		studentWelcomePage.verifywelcomePage();
	}
}
