package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.teacherrole.TeacherRoleDictionaryLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherRoleDictionaryPage extends CommonFunctionalities implements TeacherRoleDictionaryLocators {

	private WebDriver driver;
	
	public TeacherRoleDictionaryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/**
	 * Purpose- To verify that Dictionary pop-up is displayed
	 */

	public void verifyThatUsermenuDictionaryPopupIsDisplayed()
	{
		Assert.assertTrue(isElementPresent(DICTIONARYPOPUP_CONTENT, LONGWAIT), "Dictionary popup content is not being displayed");
		Assert.assertTrue(isElementPresent(DICTIONARYPOPUP_FIND_BTN, LONGWAIT), "Dictionary popup content is not being displayed");
	}
	
	/**
	 * Purpose - To close Dictionary pop-up
	 */
	public void closeUsermenuDictionaryPopup()
	{
		refresh();
		waitForPageToLoad();
	}

}
