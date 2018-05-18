package com.page.module.ll.level2activities;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.level2activities.OverviewRecapLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;

public class OverviewRecap extends CommonFunctionalities implements OverviewRecapLocators {

	private WebDriver driver;

	public OverviewRecap(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * purpose is to verify the Overview Recap page
	 */
	public void verifyRecapPage() {

		Assert.assertTrue(isElementPresent(RECAP_HEADER), "Recap header is not being displayed");
		Assert.assertTrue(isElementPresent(RECAP_CONTENT), "Overview recap content is not being displayed");
	}

	/**
	 * Purpose is to click the continue button in the word list page
	 */
	public void clickContinuebtn() {
		safeClick(CONTINE_BTN);
	}
	/**
	 * Purpose of the method is to navigate to home page on completing the activity
	 */
	public void navigateToHomePagefromActivity(){
		closeInstIcon();
		safeClick(ACTIVITY_USER_DROP_DOWN, LONGWAIT);
		//mouseHover(ACTIVITY_USER_DROP_DOWN, LONGWAIT);
		safeClick(HOME_LINK, LONGWAIT);
	}
}
