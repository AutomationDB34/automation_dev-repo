package com.page.module.ll.level2activities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.page.locators.ll.level2activities.DoubleVowelIdentificationLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;

public class DoubleVowelIdentification extends CommonFunctionalities implements DoubleVowelIdentificationLocators {

	private WebDriver driver;
	private int incorrectanswerscount;
	private int correctanswerscount;
	Logger log = Logger.getLogger(getClass());

	public DoubleVowelIdentification(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify whether the Double vowel identification activity is
	 * loaded or not
	 */
	public void verifyDoubleVowelIdentificationActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BAR), "Double vowel identification activity is not being displayed");
	}

	/**
	 * Purpose is to verify the Audio bar functionality
	 */
	public void verifyAudioBarFunctionality() {
		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED),
				"Double vowel identification activity audio is not being played");
	}

	/**
	 * Purpose is to complete all bundles of the Double vowel identification
	 * activity
	 */
	public void rcDoubleVowelIdentification() {

		List<WebElement> bundlesCount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle Count:" + bundlesCount.size());

		for (int bundles = 1; bundles <= bundlesCount.size(); bundles++) {
			Assert.assertTrue(isElementClickable(AUDIO_BAR), "Double vowel identification audio bar is not clickable");

			safeClick(VOWEL_TILE_A);
			safeClick(VOWEL_TILE_E);
			safeClick(CHECK_IT_BTN);

			if (isElementPresent(INCORRECT_ANSWER)) {

				incorrectanswerscount++;
				System.out.println(incorrectanswerscount);
				waitUntilElementDisappears(INCORRECT_ANSWER);

			} else {
				correctanswerscount++;
			}
		}
	}

	/**
	 * Purpose is to complete one bundle of the Double vowel identification
	 * activity
	 */
	public void qcDoubleVowelIdentification() {
		Assert.assertTrue(isElementClickable(AUDIO_BAR), "Double vowel identification audio bar is not clickable");

		safeClick(VOWEL_TILE_A);
		safeClick(VOWEL_TILE_E);
		safeClick(CHECK_IT_BTN);

		if (isElementPresent(INCORRECT_ANSWER)) {
			incorrectanswerscount++;
			System.out.println(incorrectanswerscount);
			waitUntilElementDisappears(INCORRECT_ANSWER);
		} else {
			correctanswerscount++;
		}
	}
	
	public void doubleVowelIdentification(String executionMode)
	{
		if(executionMode.equalsIgnoreCase("RC"))
		{
			log.info("Selected RC mode of execution");
			rcDoubleVowelIdentification();			
		}
		else
		{
			log.info("Selected QC mode of execution");
			qcDoubleVowelIdentification();
		}
		
	}

	/**
	 * Purpose is to verify the summary page of the Double vowel identification
	 * activity
	 */
	public void doubleVowelIdentificationSummary() {

		// get the correct words count and questions count displayed in summary
		// page Header
		String correctAnswersInSummaryHEader = driver.findElement(SUMMARY_CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + correctAnswersInSummaryHEader);

		String questionscountInSumamryHeader = driver.findElement(SUMMARY_QUES_COUNT).getText();
		System.out.println("Number of questions displayed in the summary header:" + questionscountInSumamryHeader);

		int total_question = correctanswerscount + incorrectanswerscount;
		System.out.println(total_question);

		// compare the correct words count with the correct count displayed in
		// the summary header
		if ((correctAnswersInSummaryHEader.equals(Integer.toString(correctanswerscount)))
				&& (questionscountInSumamryHeader.contains(Integer.toString(total_question)))) {
			System.out.println("correct words count is matched with the Correct count dispalyed in the Summary header");
			safeClick(SUMMARY_CONTINUE_BTN);
		} else {
			System.out.println("count not matching");
		}
	}

}
