package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.page.locators.ll.teacherrole.TeacherClassClassmatesLocators;
import com.page.locators.ll.teacherrole.TeacherRoleClassPageLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherClassClassmatesPage extends CommonFunctionalities implements TeacherClassClassmatesLocators {

	private WebDriver driver;

	public TeacherClassClassmatesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose- To verify that classmates page is loaded
	 */
	public void verifyThatClassmatesPageIsLoaded() {
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(CLASSMATESTAB_SELECTED, LONGWAIT),
				"Class->Classmates tab is not displayed as selected even after clicking on it");
		Assert.assertTrue(isElementPresent(CLASSMATESTAB_TABLE, LONGWAIT), "Class->Classmates page is not loaded");
	}

	public void verifyAboutMeProfile(LLData lldata) {
		safeClick(Dynamic.getNewLocator(STUDENT_LINK, lldata.teacherRoleLLStudentLastName), MEDIUMWAIT);
		waitForPageToLoad();
		Assert.assertTrue(isElementDisplayed(ABOUT_ME_PROFILE_CONTENT),
				"About me profile page of the studnet is not being displayed");

	}
	
	

}
