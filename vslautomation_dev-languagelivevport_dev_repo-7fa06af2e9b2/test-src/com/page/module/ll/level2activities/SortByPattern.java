package com.page.module.ll.level2activities;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.level2activities.SortByPatternLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.testng.Assert;

public class SortByPattern extends CommonFunctionalities implements SortByPatternLocators {

	private WebDriver driver;

	public SortByPattern(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify whether the Sort by pattern activity is loaded or
	 * not
	 */
	public void verifySortByPatternActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_ICON), "Sort by pattern Activity is not being displayed");
	}

	/**
	 * Purpose is to complete all the bundles of the sort by pattern activity 
	 * @param isIE.
	 */
	public void SortByPattern(boolean isIE) {

		// get the bundle count of the activity
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());

		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {
			if (isElementClickable(AUDIO_ICON)) {
				List<WebElement> syllableCount = LocatorWebElements(DRAGGABLE_TILES_COUNT);
				System.out.println("Syllable Count:" + syllableCount.size());

				for (int syllables = 1; syllables <= syllableCount.size(); syllables++) {
					if (isElementClickable(AUDIO_ICON)) {
					
						dragAndDropwithRobots(Dynamic.getNewLocator(DRAGGABLE_TILES, Integer.toString(syllables)),CLOSED_COLUMN, LONGWAIT, isIE);
					}
				}
			}
		}
	}

	/**
	 * Purpose is to verify the summary page of the sort by pattern activity 
	 */
	public void sortByPatternSummary() {

		// get the Correct and incorrect words count displayed in respective
		// column
		List<WebElement> correctCount = LocatorWebElements(CORRECT_ANSWERS);
		List<WebElement> incorrectCount = LocatorWebElements(INCORRECT_ANSWERS);

		int correct = correctCount.size();
		int incorrect = incorrectCount.size();
		int total_question = correct + incorrect;
		System.out.println(total_question);

		String correctAnswersCount = Integer.toString(correctCount.size());
		String incorrectAnswersCount = Integer.toString(incorrectCount.size());

		String summaryCorrectCount = driver.findElement(SUMMARY_HEADER_CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + summaryCorrectCount);

		String summaryquestionscount = driver.findElement(SUMMARY_HEADER_QUES_COUNT).getText();
		System.out.println("Number of questions displayed in the summary header:" + summaryquestionscount);

		// compare the correct answers count with the correct count displayed in
		// the
		// summary header
		if ((summaryCorrectCount.equals(correctAnswersCount))
				&& (summaryquestionscount.contains(Integer.toString(total_question)))) {
			System.out.println("Correct count is matched with the Correct count dispalyed in the Summary header");
			safeClick(SUMMARY_CONTINUE_BTN);
		} else {

			System.out.println("count not matching");
		}

	}

}
