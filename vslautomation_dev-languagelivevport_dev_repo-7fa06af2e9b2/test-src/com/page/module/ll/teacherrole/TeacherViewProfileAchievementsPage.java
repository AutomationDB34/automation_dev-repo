package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.locators.ll.teacherrole.TeacherViewProfileAchievementsLocators;
import com.selenium.SafeActions;

public class TeacherViewProfileAchievementsPage extends SafeActions implements TeacherViewProfileAchievementsLocators {

	private WebDriver driver;
	
	public TeacherViewProfileAchievementsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void verifyAchievementsPageIsLoaded()
	{
		waitForPageToLoad();
		waitForSecs(10);
		Assert.assertEquals(safeGetText(ACHIEVEMENTS_TITLE,LONGWAIT),"Achievements","Achievements heading is not loaded after Clicking Achievement tab ");
		Assert.assertTrue(isElementDisplayed(BADGES_PANE),"Badges pane is not displayed in Achievements tab");
		Assert.assertTrue(isElementDisplayed(CERIFICATES_PANE),"Certificates pane is not displayed in Achievements tab");

	}

}
