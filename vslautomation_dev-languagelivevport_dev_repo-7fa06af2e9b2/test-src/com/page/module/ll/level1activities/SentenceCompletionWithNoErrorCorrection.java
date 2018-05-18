package com.page.module.ll.level1activities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.SentenceCompletionWithNoErrorCorrectionLocators;
import com.testng.Assert;

public class SentenceCompletionWithNoErrorCorrection extends CommonFunctionalities
		implements SentenceCompletionWithNoErrorCorrectionLocators {

	private WebDriver driver;
	private LLData llData = new LLData();
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public SentenceCompletionWithNoErrorCorrection(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose - is to verify whether the activity is loaded or not
	 */
	public void verifySentCompletionactivity() {

		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BAR, LONGWAIT),
				"SentenceCompletion activity is not being displayed on page");
	}

	/**
	 * Purpose - is to test all the bundles of the activity
	 */
	public void rcsentenceCompletion(boolean isIE) {

		// get the bundle count and repeat the activity for all the bundles
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());

		for (int i = 1; i <= bundlecount.size(); i++) {
			Assert.assertTrue(isElementPresent(AUDIO_ENABLED, LONGWAIT),
					"SentenceCompletion activity audio is not being played");
			if (isIE) {
				safeClickUsingSikuli(llData.SentCompletionWithNoErrorMousePointerImage,
						"answer container section of the Sentence Completion activity using sikuli", LONGWAIT);
			}
			dragAndDrop(ANSWER_TILE, ANSWER_AREA, LONGWAIT);
		}
	}

	/**
	 * Purpose - is to test one bundle of the activity
	 */
	public void qcsentenceCompletion(boolean isIE) {

		Assert.assertTrue(isElementPresent(AUDIO_ENABLED, LONGWAIT),
				"SentenceCompletion activity audio is not being played");
		if (isIE) {
			safeClickUsingSikuli(llData.SentCompletionWithNoErrorMousePointerImage,
					"answer container section of the Sentence Completion activity using sikuli", LONGWAIT);
		}
		dragAndDrop(ANSWER_TILE, ANSWER_AREA, LONGWAIT);
	}
	
	
	/**
	 * Deciding method of the Execution
	 */
	public void sentenceCompletion(boolean isIE)
	{
		if(executionMode.equalsIgnoreCase("rc"))
		{
			log.info("Runnig the SentenceCompletion Spelling with No error CreationActivity at RC mode");
			rcsentenceCompletion(isIE);
		}
		else
		{
			log.info("Runnig the SentenceCompletion Spelling with No error Creation Activity at QC mode");
			qcsentenceCompletion(isIE);
		}
	}

	/**
	 * Purpose is to verify the summary page of the activity
	 */
	public void sentCompleteionwithNoErrorSummary() {

		// verify the summary header
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER, LONGWAIT),
				"Sentence Completion activity summary page is not being dispalyed ");

		List<WebElement> correctAnswersCount = LocatorWebElements(CORRECT_ANSWERS);
		List<WebElement> incorrectAnswersCount = LocatorWebElements(INCORRECT_ANSWERS);

		System.out.println("Correct answers:" + correctAnswersCount.size());
		System.out.println("InCorrect answers:" + incorrectAnswersCount.size());

		safeClick(SUMMARY_CONTINUE_BTN);
	}
}
