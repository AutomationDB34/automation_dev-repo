package com.page.module.ll.level2activities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.datamanager.ConfigManager;
import com.page.locators.ll.level2activities.BreakingWordsLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.testng.Assert;

public class BreakingWords extends CommonFunctionalities implements BreakingWordsLocators {

	private WebDriver driver;
	private int incorrectcount;
	private int correctcount;
	ConfigManager app = new ConfigManager("App");
	Logger log = Logger.getLogger(getClass());

	public BreakingWords(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of the method is to verify whether the activity is loaded or not
	 */
	public void verifyBreakingWordsActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(BREAKING_WORDS_CONTAINER), "Breaking words activity is not being dispalyed");
	}

	/**
	 * Purpose of the method is to verify audio bar functionality
	 */
	public void verifyAudioFunctiionality() {
		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED), "Breaking words activity audio is not being palyed");
	}

	/**
	 * Purpose of the method is to enter the text in the answer area and click
	 * check it button
	 */
	public void enterTextAndCheckItAnswer() {
		// get the syllable count of the activity
		List<WebElement> syllablecount = LocatorWebElements(SYLLABLE_COUNT);
		System.out.println("Syllable count:" + syllablecount.size());

		for (int syllables = 1; syllables <= syllablecount.size(); syllables++) {
			String maxlength = safeGetAttribute(Dynamic.getNewLocator(ANSWER_TEXT_AREA, Integer.toString(syllables)),
					"maxlength", LONGWAIT);

			for (int length = 1; length <= Integer.parseInt(maxlength); length++) {
				safeType(Dynamic.getNewLocator(ANSWER_TEXT_AREA, Integer.toString(syllables)), "t", LONGWAIT);
			}
		}
		safeClick(CHECK_IT_BTN);
	}

	/**
	 * purpose of the method is to complete all the bundles of the breaking
	 * words activity
	 */
	public void breakingWords() {
		// Conditional run for breaking Words Activity
		if (app.getProperty("App.ExecutionMode").equalsIgnoreCase("qc")) {
			log.info("Runnig the breaking Words at QC mode");

			Assert.assertTrue(isElementClickable(AUDIO_BAR), "Breaking words activity bundle is not being palyed");

			enterTextAndCheckItAnswer();
			if (isElementPresent(INCORRECT_ANSWER)) {
				waitUntilElementDisappears(INCORRECT_ANSWER);
				incorrectcount++;
			} else {
				waitUntilElementDisappears(CORRECT_ANSWER);
				correctcount++;

			}
			System.out.println("correctanswers count" + correctcount);
			System.out.println("incorrectanswers count" + incorrectcount);

		} else {
			log.info("Runnig the breaking Words at RC mode");

			// get the bundle count of the activity
			List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
			System.out.println("bundle count:" + bundlecount.size());

			for (int bundles = 1; bundles <= bundlecount.size(); bundles++)
			{
				Assert.assertTrue(isElementClickable(AUDIO_BAR), "Breaking words activity bundle is not being palyed");

				enterTextAndCheckItAnswer();
				if (isElementPresent(INCORRECT_ANSWER)) {
					waitUntilElementDisappears(INCORRECT_ANSWER);
					incorrectcount++;
				} else {
					waitUntilElementDisappears(CORRECT_ANSWER);
					correctcount++;
				}
			}
			System.out.println("correctanswers count" + correctcount);
			System.out.println("incorrectanswers count" + incorrectcount);
		}
	}

}
