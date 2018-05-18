package com.page.module.ll.level2activities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.page.locators.ll.level2activities.StressedSyllablesLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;

public class StressedSyllables extends CommonFunctionalities implements StressedSyllablesLocators {

	private WebDriver driver;
	private int incorrectcount;
	private int correctcount;

	public StressedSyllables(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of the method is to verify whether activity is loaded or not
	 */
	public void verifyStressedSyllableActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BAR), "stressed syllable activity is not being dispalyed");
	}

	/**
	 * Purpose is to verify the audio bar functionality
	 */
	public void verifyAudiofunctionality() {
		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED), "stressed syllable activity audio is not being palyed");

	}

	/**
	 * purpose is to verify all the bundles of the stressed syllables activity
	 */
	public void StressedSyllable() {
		List<WebElement> bundlesCount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle Count:" + bundlesCount.size());

		for (int bundles = 1; bundles <= bundlesCount.size(); bundles++) {
			safeClick(STRESSED_SYLLABLE, LONGWAIT);
			if (isElementPresent(INCORRECT_COLOR)) {
				waitUntilElementDisappears(INCORRECT_COLOR, LONGWAIT);
				incorrectcount++;
			} else {
				waitUntilElementDisappears(CORRECT_COLOR, LONGWAIT);
				correctcount++;
			}
		}
		System.out.println("correct count" + correctcount);
		System.out.println("incorrect count" + incorrectcount);
	}

	/**
	 * Purpose is to verify the summary page of the Stressed syllable activity
	 */
	public void stressedSyllablesSummary() {
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER),
				"Stressed syllable activity summary page is not being dispalyed");

		int total_Questions = incorrectcount + correctcount;
		System.out.println(total_Questions);

		// get the correct words count and questions count displayed in summary
		// page Header
		String correctAnswersInSummaryHEader = safeGetText(SUMMARY_HEADER_CORRECT_COUNT, LONGWAIT);
		System.out.println("Correct count dispalyed in summary Page:" + correctAnswersInSummaryHEader);

		String questionscountInSumamryHeader = safeGetText(SUMMARY_HEADER_QUES_COUNT, LONGWAIT);
		System.out.println("Number of questions displayed in the summary header:" + questionscountInSumamryHeader);

		// compare the correct words count with the correct count displayed in
		// the summary header
		if ((correctAnswersInSummaryHEader.equals(Integer.toString(correctcount)))
				&& (questionscountInSumamryHeader.contains(Integer.toString(total_Questions)))) {
			System.out.println("correct words count is matched with the Correct count dispalyed in the Summary header");
			safeClick(SUMMARY_CONTINUE_BTN);
		} else {
			System.out.println("count not matching");
		}
	}
}
