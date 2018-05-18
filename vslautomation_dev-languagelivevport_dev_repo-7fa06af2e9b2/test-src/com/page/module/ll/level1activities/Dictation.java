package com.page.module.ll.level1activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.level1activites.DictationLocators;
import com.selenium.Dynamic;
import com.testng.Assert;

public class Dictation extends CommonFunctionalities implements DictationLocators {

	private WebDriver driver;

	public Dictation(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of the method is to verify whether activity is loaded or not
	 */
	public void verifyDictiationActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(STEP1_HEADER, LONGWAIT), "Dictation activity is not being dispalyed ");
	}

	public void clickAudiobarFunctionality(){

		// verify the audio functionality
		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED, LONGWAIT),
				"Audio is not being played in the dictation activity");
	}
	/**
	 * Purpose of the method is to verify the Spelling step of the Dictation
	 */
	public void spellingStep() {
		List<WebElement> textBoxCount = LocatorWebElements(Dynamic.getNewLocator(INPUT_TEXT_BOX, ""));
		System.out.println("Input text box count:" + textBoxCount.size());

		// get the number of input text boxes
		for (int i = 1; i <= textBoxCount.size(); i++) {
			String dText = "[" + Integer.toString(i) + "]";

			By str = Dynamic.getNewLocator(INPUT_TEXT_BOX, dText);

			String length = safeGetAttribute(str, "maxlength", LONGWAIT);

			// Enter the text into text box depending on the length of the text
			for (int j = 1; j <= Integer.parseInt(length); j++) {

				safeType(str, "t");
			}
		}
	}

	/**
	 * Purpose of the method is to verify Dictation activity all bundles
	 */
	public void dictation() {

		// get the bundle count and repeat the activity for all the bundles
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());
		for (int i = 1; i <= bundlecount.size(); i++) {
			spellingStep();
			safeClick(CHECK_IT_BTN);
			if (isElementPresent(CROSS_MARK)) {
				waitUntilElementDisappears(CROSS_MARK);
				spellingStep();
				safeClick(CHECK_IT_BTN);
			}
			safeClick(NEXT_BTN);
		}
	}

}
