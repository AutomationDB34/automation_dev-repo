package com.page.module.ll.level1activities;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.level1activites.WordSortwithSumamryLocators;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class WordSortwithSummary extends CommonFunctionalities implements WordSortwithSumamryLocators {

	private WebDriver driver;
	Logger log = Logger.getLogger(getClass());

	public WordSortwithSummary(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify whether the activity is loaded or not
	 */
	public void verifyWordSortActivity() {

		closeInstIcon();
		Assert.assertTrue(isElementPresent(COLUMN_HEADER, LONGWAIT), "Word Sort activity is not being dispalyed ");
	}

	/**
	 * purpose of the method is to sort the word in to the respective column
	 * 
	 * @param isIE
	 * @throws AWTException
	 */
	public void wordsorting(boolean isIE) {

		if (isIE) {
			Point coordinates = driver.findElement(PLURAL_COLUMN).getLocation();
			int x = coordinates.getX();
			int y = coordinates.getY();
			Dimension dimentions = driver.findElement(PLURAL_COLUMN).getSize();
			int height = dimentions.getHeight();
			int width = dimentions.getWidth();
			try
			{
			Robot robotclass = new Robot();
			robotclass.mouseMove(x + height / 2, y + width / 2);
			}
			catch(AWTException e)
			{
				log.info("Unable to perform the KeyBoard actions"+ UtilityMethods.getStackTrace());
			}

			if (isElementClickable(AUDIO_ICON)) {
				dragAndDrop(TILE_TO_DRAG, PLURAL_COLUMN, LONGWAIT);
			}

		} else {

			if (isElementClickable(AUDIO_ICON)) {

				String text = safeGetText(TILE_TO_DRAG, LONGWAIT);
				System.out.println(text);

				if (text.contains("s")) {
					dragAndDrop(TILE_TO_DRAG, PLURAL_COLUMN, LONGWAIT);
				} else {
					dragAndDrop(TILE_TO_DRAG, SINGULAR_COLUMN, LONGWAIT);
				}

			}
		}

	}

	/**
	 * purpose of the method is to verify th esummary page of the activity
	 */
	public void wordSortSummary() {

		Assert.assertTrue(isElementPresent(SUMMARY_HEADER, LONGWAIT),
				"Word Sort activity Summary is not being dispalyed ");

		// get the correct and incorrect words count displayed in summary page

		List<WebElement> correctCount = LocatorWebElements(RIGHT_COUNT);
		List<WebElement> incorrectCount = LocatorWebElements(WRONG_COUNT);

		String correctAnswers = Integer.toString(correctCount.size());
		System.out.println("correct answers:" + correctAnswers);

		String incorrectAnswers = Integer.toString(incorrectCount.size());
		System.out.println("incorrect answers:" + incorrectAnswers);

		int correct = correctCount.size();
		int incorrect = incorrectCount.size();
		int total_question = correct + incorrect;
		System.out.println(total_question);

		// get the correct words count and questions count displayed in summary
		// page Header
		String correctAnswersInSummaryHEader = driver.findElement(SUMMARY_CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + correctAnswersInSummaryHEader);

		String questionscountInSumamryHeader = driver.findElement(SUMMARY_QUESTIONS_COUNT).getText();
		System.out.println("Number of questions displayed in the summary header:" + questionscountInSumamryHeader);

		// compare the correct words count with the correct count displayed in
		// the summary header
		if ((correctAnswersInSummaryHEader.equals(correctAnswers))
				&& (questionscountInSumamryHeader.contains(Integer.toString(total_question)))) {
			System.out.println("correct words count is matched with the Correct count dispalyed in the Summary header");
			safeClick(SUMMARY_CONTINUE_BTN);
		} else {

			System.out.println("count not matching");
		}
	}

	/**
	 * purpose of the method is to verify all the bundles of the activity
	 * 
	 * @param isIE
	 * @throws AWTException
	 */
	public void wordSortActivity(boolean isIE)  {

		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());

		for (int i = 1; i <= bundlecount.size(); i++) {

			wordsorting(isIE);
		}
	}
}
