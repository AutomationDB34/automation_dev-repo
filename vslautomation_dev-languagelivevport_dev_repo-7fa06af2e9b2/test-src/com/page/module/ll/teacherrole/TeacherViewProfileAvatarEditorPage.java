package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.teacherrole.TeacherViewProfileAvatarEditorLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherViewProfileAvatarEditorPage extends CommonFunctionalities implements TeacherViewProfileAvatarEditorLocators {

	private WebDriver driver;
	
	public TeacherViewProfileAvatarEditorPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose - To verify that Avatar Editor tab is loaded properly
	 */
	
	public void verifyThatAvatarEditorTabIsLoaded()
	{
		waitForPageToLoad();
		isElementDisplayed(AVATAREDITORTAB_SELECTED);
		Assert.assertTrue(isElementDisplayed(AVATAREDITORTAB_SELECTED), "Avatar Editor tab is not being displayed as highlighted even after clicking on it");
		Assert.assertTrue(isElementDisplayed(AVATAREDITORTAB_SECTION), "Avatar Editor content is not being displayed on View Profile page");
		setImplicitWait(VERYLONGWAIT);
		
	}
	
}
