package com.page.module.ll.level1activities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.SentenceCompletionSpellingLocators;
import com.testng.Assert;

public class SentenceCompletionSpelling extends CommonFunctionalities implements SentenceCompletionSpellingLocators {

	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public SentenceCompletionSpelling(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of this method is to verify whether the activity is loaded or not
	 */
	public void verifySentenceCompletionSpellingActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BAR, LONGWAIT),
				"Sentence Completion Spelling activity is not being dispalyed ");
	}

	/**
	 * Purpose is to verify the functionality of the audio bar
	 */
	public void verifyaudiobar() {
		// verify the audio functionality
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED, LONGWAIT),
				"Sentence Completion activity audio is not being palyed ");
	}

	/**
	 * purpose is to verify the spelling functionality of the activity
	 */
	public void sentenceSpelling() {
		

		String length = safeGetAttribute(ANSWER_LENGTH, "maxlength", LONGWAIT);
		System.out.println(length);
		waitForSecs(5);
		waitForPageToLoad();
		for (int i = 0; i <= Integer.parseInt(length); i++) {
			waitForSecs(2);
			safeType(ANSWER_AREA, "t", LONGWAIT);
		}
		waitForPageToLoad();
		safeClick(CHECK_IT_BTN);
	}

	/**
	 * Purpose is to verify the summary page of the activity
	 */
	public void sentenceCompletionSpellingSummary() {

		waitForSecs(15);
		// verify the summary header
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER, LONGWAIT),
				"Sentence Completion activity summary page is not being dispalyed ");

		List<WebElement> correctAnswersCount = LocatorWebElements(CORRECT_COUNT);
		List<WebElement> incorrectAnswersCount = LocatorWebElements(INCORRECT_COUNT);

		System.out.println("Correct answers:" + correctAnswersCount.size());
		System.out.println("InCorrect answers:" + incorrectAnswersCount.size());

		safeClick(SUMMARY_CONTINUE_BTN);
	}

	/**
	 * purpose is to verify all the bundles of the activity
	 */
	public void rcsentencecompletionSpelling() {

		// get the bundle count and repeat the activity for all the bundles
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());
		Assert.assertTrue(isElementClickable(AUDIO_BAR), "Sentence Completion activity audio is not being clickable ");
		for (int i = 1; i <= bundlecount.size(); i++) {
			sentenceSpelling();
			if (isElementPresent(CROSS_MARK)) {
				waitUntilElementDisappears(CROSS_MARK);
				Assert.assertTrue(isElementPresent(INCORRECT_TILE, LONGWAIT),
						"Sentence Completion Spelling activity incorrect tile is not being dispalyed ");
				sentenceSpelling();
			}
		}
	}

	/**
	 * purpose is to verify one bundle of the activity
	 */
	public void qcsentencecompletionSpelling() {

		sentenceSpelling();
		if (isElementPresent(CROSS_MARK)) {
			waitUntilElementDisappears(CROSS_MARK);
			Assert.assertTrue(isElementPresent(INCORRECT_TILE, LONGWAIT),
					"Sentence Completion Spelling activity incorrect tile is not being dispalyed ");
			sentenceSpelling();
		}
	}
	
	/**
	 * Deciding method of the Execution
	 */
	public void sentencecompletionSpelling()
	{
		if(executionMode.equalsIgnoreCase("rc"))
		{
			log.info("Runnig the SentenceCompletion Spelling Activity at RC mode");
			rcsentencecompletionSpelling();
		}
		else
		{
			log.info("Runnig the SentenceCompletion Spelling Activity at QC mode");
			qcsentencecompletionSpelling();
		}
	}
}
