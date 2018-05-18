package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.page.locators.ll.teacherrole.TeacherViewProfileClassmatesLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherViewProfileClassmatesPage extends CommonFunctionalities implements TeacherViewProfileClassmatesLocators {

	private WebDriver driver;
	
	public TeacherViewProfileClassmatesPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/**
	 * Purpose - To verify that classmates tab is loaded properly
	 */
	
	public void verifyThatClassmatesTabIsLoaded()
	{
		Assert.assertTrue(isElementPresent(CLASSMATESTAB_SELECTED, LONGWAIT), "Classmates tab is not being displayed as highlighted even after clicking on it");
		Assert.assertTrue(isElementPresent(CLASSMATESTAB_CONTENTS_SECTION, LONGWAIT), "Classmates tab content is not being displayed on View Profile page");
	}
	
	
	public void verifyAboutMeProfile(LLData lldata) {
		safeClick(Dynamic.getNewLocator(STUDENT_LINK, lldata.teacherRoleLLStudentLastName), MEDIUMWAIT);
		waitForPageToLoad();
		Assert.assertTrue(isElementDisplayed(ABOUT_ME_PROFILE_CONTENT),
				"About me profile page of the studnet is not being displayed");

	}
}

