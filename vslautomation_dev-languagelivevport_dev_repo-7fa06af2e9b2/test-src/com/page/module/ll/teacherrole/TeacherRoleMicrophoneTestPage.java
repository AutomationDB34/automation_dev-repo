package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.teacherrole.TeacherRoleMicrophoneTestLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherRoleMicrophoneTestPage extends CommonFunctionalities implements TeacherRoleMicrophoneTestLocators {

	private WebDriver driver;
	
	public TeacherRoleMicrophoneTestPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose- To verify that Microphone test pop-up is displayed
	 */

	public void verifyThatUsermenuMicrophonePopupIsDisplayed()
	{
		Assert.assertTrue(isElementPresent(MICROPHONETEST_CONTENT_SECTION, LONGWAIT), "Microphone test content is not being displayed");
		Assert.assertTrue(isElementPresent(MICROPHONETEST_POPUP_START_BTN, LONGWAIT), "Microphone test popup content is not being displayed");
	}
	
	/**
	 * Purpose - To close Dictionary pop-up
	 */
	public void closeUsermenuMicrophonePopup()
	{
		refresh();
		waitForPageToLoad();
	}
	
}
