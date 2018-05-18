package com.page.module.ll.level1activities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.level1activites.ListenAndAnswerYesNoLocators;
import com.testng.Assert;

public class ListenAndAnswerYesNo extends CommonFunctionalities implements ListenAndAnswerYesNoLocators {

	private WebDriver driver;

	public ListenAndAnswerYesNo(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of the method is to verify whether the activity is loaded or not
	 */
	public void verifyListenAndAnswerActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BAR), "ListenAndAnswerYesNo Activity is not being displayed");
	}

	/**
	 * Purpose of the method is to verify the functionality of audio bar
	 */
	public void clickOnAudioBar() {
		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED), "ListenAndAnswerYesNo Activity audio is not played");
	}

	/**
	 * Purpose of the method is to verify the functionality of Listen and answer
	 * yes no activity for all bundles
	 */
	public void listenAndAnswerActivity() {

		// get the bundle count of the activity
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());

		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {

			safeClick(YES_BTN);

			if (isElementPresent(TICK_MARK)) {
				waitUntilElementDisappears(TICK_MARK);
				System.out.println("correct answer is selected , Tick mark is dispalyed ");
			} else {
				waitUntilElementDisappears(CROSS_MARK);
				System.out.println("incorrect answer is selected, cross mark is dispalyed ");
			}
		}
	}

}
