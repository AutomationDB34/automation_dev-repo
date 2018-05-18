package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.teacherrole.TeacherWelComePageLocators;
import com.page.module.ll.level1activities.TeacherHomePage;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherWelComePage extends SafeActions implements TeacherWelComePageLocators {

	private WebDriver driver;
	
	public TeacherWelComePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * Purpose-To verify welcome page for new teacher user for accepting terms and conditions
	 */
	public void verifyWelComePageForTeacherUser()
	{
		selectFrame(TEACHERWELCOMEPAGE_IFRAME, LONGWAIT);
		Assert.assertTrue(isElementPresent(TRAININGOPTIONS_DRP, LONGWAIT), "Welcome page is not displayed for the newly logged in teacher user");
	}
		
	/**
	 * Purpose - To select options on new Teacher Welcome page( such as training drop down option, terms of use check box, continue button click)
	 * @param trainingOption
	 */
	
	public TeacherHomePage selectOptionsOnTeacherWelComePage(String trainingOption)
	{
		safeSelectOptionInDropDownByVisibleText(TRAININGOPTIONS_DRP, trainingOption, LONGWAIT);
		
		safeJavaScriptClick(TERMSOFUSE_CHECKBOX, LONGWAIT);
		waitForPageToLoad();
		
		safeClick(SAVEANDCONTINUE_BTN, LONGWAIT);
		
		defaultFrame();
		
		return new TeacherHomePage(driver);
	}
}
