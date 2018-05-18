package com.page.module.ll.level2activities;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.page.locators.ll.level2activities.SortByFunctionLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;

public class SortByFunction extends CommonFunctionalities implements SortByFunctionLocators {

	private WebDriver driver;

	public SortByFunction(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of the method is to complete all the bundles of the sort by
	 * function activtiy
	 * 
	 * @param isIE
	 	 */
	public void SortByFunction(boolean isIE)
	{
		closeInstIcon();
		// get the bundle count of the activity
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());
		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {
			Assert.assertTrue(isElementClickable(AUDIO_ICON, LONGWAIT),
					"Audio icon is not clickable in the Sort by Function activity");
			dragAndDropwithRobots(DRAGGABLE_WORD_TILE, NOUN_COLUMN, LONGWAIT, isIE);
		}
	}

	/**
	 * Purpose of the method is to verify the summary page of the activity
	 */
	public void sortByFunctionSummary() {
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER, LONGWAIT),
				"Summary page of the  Sort by Function activity is not being dispalyed ");
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
