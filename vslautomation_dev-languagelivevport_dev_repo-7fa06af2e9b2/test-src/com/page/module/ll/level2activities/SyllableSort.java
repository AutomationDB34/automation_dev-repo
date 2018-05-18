package com.page.module.ll.level2activities;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.level2activities.SyllableSortLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;

public class SyllableSort extends CommonFunctionalities implements SyllableSortLocators {

	private WebDriver driver;

	public SyllableSort(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify whether the Syllable sort activity is loaded or not
	 */
	public void verifySyllableSortActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_ICON), "Syllable sort Activity is not being displayed");
	}

	/**
	 * Purpose is to complete the syllable sort all bundles
	 * 
	 * @param isIE
	 * @throws AWTException
	 */
	public void syllableSort(boolean isIE){

		// get the bundle count of the activity
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());

		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {

			if (isElementClickable(AUDIO_ICON)) {
				dragAndDropwithRobots(SORTABLE_TILE, SORTABLE_COLUMN, LONGWAIT, isIE);
			}
		}
	}

	/**
	 * Purpose of the method is to navigate to home page on completing the
	 * activity
	 */
	public void navigateToHomePagefromActivity() {
		closeInstIcon();
		mouseHover(ACTIVITY_USER_DROP_DOWN, LONGWAIT);
		safeClick(HOME_LINK, LONGWAIT);
	}
}
