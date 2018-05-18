package com.page.module.ll.admin;



import org.openqa.selenium.WebDriver;

import com.page.locators.ll.admin.MultiRoleScenarioLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;

public class MultiRoleScenariosPage extends CommonFunctionalities implements MultiRoleScenarioLocators{

	WebDriver driver;
	
	public MultiRoleScenariosPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public void verifyMultiroleSelectionPage(){
		waitForSecs(5);
		Assert.assertTrue(isElementDisplayed(CAMPUS_ROLE_RADIOBTN), "Multirole selection page is not being displayed");
	}
	
	public void selectCampusRole(){
		safeClick(CAMPUS_ROLE_RADIOBTN, MEDIUMWAIT);
		safeClick(CONTINUE_BTN, MEDIUMWAIT);
	}
	
	public void verifyCampusDashboard(){
		waitForPageToLoad();
		Assert.assertTrue(isElementDisplayed(CAMPUS_LAYOUT), "Campus dashboard is not being displayed");
	}
	
	public void verifyTeacherDashboard(){
		waitForPageToLoad();
		Assert.assertTrue(isElementDisplayed(TEACHER_LAYOUT), "Teacher dashboard is not being displayed");
	}
	
	public void changeRole(){
		waitForPageToLoad();
		safeClick(USER_DROP_DOWN, MEDIUMWAIT);
		safeClick(CHANGE_ROLE, MEDIUMWAIT);
		waitForSecs(5);
	}
}
