package com.page.module.ll.level1activities;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.level1activites.PhonemeAndGraphemeLocators;
import com.testng.Assert;

public class PhonemeAndGrapheme extends CommonFunctionalities implements PhonemeAndGraphemeLocators {
	private WebDriver driver;

	public PhonemeAndGrapheme(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of this method is to verify whether the Phoneme & Grapheme
	 * Activity is loaded or not
	 */
	public void verifyPhonemeActivity() {

		Assert.assertTrue(isElementPresent(PHONEMEINTRO_FRONTAL_IMG, LONGWAIT),
				"Phoneme and Grapheme introduction frontal image is not being displayed on Activity page");
		Assert.assertTrue(isElementPresent(PHONEMEINTRO_SAGGITAL_IMG, LONGWAIT),
				"Phoneme and Grapheme introduction saggital image is not being displayed on Activity page");

	}

	/**
	 * Purpose of this method is to verify and click Replay links *
	 */
	public void clickReplayLink() {

		safeClick(PHONEMEINTRO_FRONTAL_REPLAY, LONGWAIT);
		waitForSecs(3);
		isElementClickable(PHONEMEINTRO_SAGGITAL_REPLAY, LONGWAIT);
		safeClick(PHONEMEINTRO_SAGGITAL_REPLAY, LONGWAIT);

	}

	/**
	 * Purpose of this method is to click Next Button *
	 */
	public void clickNextBtn() {

		safeClick(NEXT_BTN, LONGWAIT);
	}

	/**
	 * Purpose of this method is to verify the letters displayed *
	 */
	public void verifyLetters() {

		String activeLetter = driver.findElement(ACTIVE_LETTER).getText();
		String letterDisplayed = driver.findElement(LETTER_GROUP).getText();

		if (activeLetter.equalsIgnoreCase(letterDisplayed)) {
			System.out.println("The tutorial is for Letter" + activeLetter);
			safeClick(NEXT_BTN, LONGWAIT);
		}
	}

	/**
	 * Purpose of this method is to verify spelling step and click next button
	 * to move further *
	 */
	public void spellingStep() {
		Assert.assertTrue(isElementPresent(SPELLING_STEP, LONGWAIT),
				"Phoneme and Grapheme introduction saggital image is not being displayed on Activity page");
		safeClick(NEXT_BTN, LONGWAIT);
	}
}
