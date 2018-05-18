package com.page.module.ll.level1activities;

import java.awt.AWTException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.SyllabificationLocators;
import com.selenium.Dynamic;
import com.testng.Assert;

public class Syllabification extends CommonFunctionalities implements SyllabificationLocators {

	private WebDriver driver;
	private LLData llData = new LLData();
	ConfigManager app = new ConfigManager("App");
	Logger log = Logger.getLogger(getClass());

	public Syllabification(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * purpose of the method is to verify whether activity is loaded or not
	 */
	public void verifySyllabificationActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BTN, LONGWAIT),
				"Syllabification activity is not being displayed on page");
	}

	/**
	 * purpose of the method is to test the functionality of syllabification
	 * activity
	 */
	public void syllabificationfunction(boolean isIE) 
	{

		// Verify the audio Functionality
		safeClick(AUDIO_BTN);
		Assert.assertTrue(isElementPresent(AUDIO_BTN, LONGWAIT),
				"Syllabification activity is not being displayed on page");

		if (isIE) {
			safeClickUsingSikuli(llData.syllabificationMousepointerImage,
					"answer container section of the Syllabification activity using sikuli", LONGWAIT);
		}

		Assert.assertTrue(isElementDisplayed(ANSWER_CONTAINER),
				"Answer container is not displayed for the bundle in Syllabification activity");

		// get the length of the text that can be entered into the answer
		// container
		String length = driver.findElement(ANSWER_CONTAINER).getAttribute("maxlength");
		int number_of_letters = Integer.parseInt(length);

		// Drag and drop the tiles as per the length into the answer container
		for (int i = 1; i <= number_of_letters; i++) {

			String str = "[" + Integer.toString(i) + "]";

			dragAndDrop(Dynamic.getNewLocator(ANSWER_TILES, str), ANSWER_CONTAINER, LONGWAIT);
		}
		safeClick(CHECK_IT_BTN);
	}

	/**
	 * Purpose of the method is to verify the summary page of the
	 * Syllabification activity
	 */

	public void syllabificationSummary() {

		waitUntilElementDisappears(TEMP_CONTAINER, LONGWAIT);
		Assert.assertTrue(isElementDisplayed(SUMMARY_PAGE),
				"Summary page is not displayed in Syllabification activity");

		// get the correct and incorrect words count displayed in summary page

		List<WebElement> correctCount = LocatorWebElements(CORRECT_BUNDLES);
		List<WebElement> incorrectCount = LocatorWebElements(INCORRECT_BUNDLES);

		String correctAnswers = Integer.toString(correctCount.size());
		System.out.println(correctAnswers);

		String incorrectAnswers = Integer.toString(incorrectCount.size());
		System.out.println(incorrectAnswers);

		// get the correct words count and questions count displayed in summary
		// page Header
		String correctAnswersInSummaryHEader = driver.findElement(SUMMARY_CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + correctAnswersInSummaryHEader);

		String questionscountInSumamryHeader = driver.findElement(SUMMARY_NUMBER_OF_QUES).getText();
		System.out.println("Number of questions displayed in the summary header:" + questionscountInSumamryHeader);

		int correct = correctCount.size();
		int incorrect = incorrectCount.size();
		int total_question = correct + incorrect;
		System.out.println(total_question);

		// compare the correct words count with the correct count displayed in
		// the summary header
		if ((correctAnswersInSummaryHEader.equals(correctAnswers))
				&& (questionscountInSumamryHeader.contains(Integer.toString(total_question)))) {
			System.out.println("correct words count is matched with the Correct count dispalyed in the Summary header");
			safeClick(CONTINUE_SUMMARY);
		} else {

			System.out.println("count not matching");
		}
	}

	/**
	 * Purpose of the method is to verify single bundle of Syllabification
	 * activity
	 */

	public void syllabification(boolean isIE) {
		// Conditional run for Syllabification Activity
		if (app.getProperty("App.ExecutionMode").equalsIgnoreCase("qc")) {
			log.info("Runnig the Syllabification at QC mode");

			syllabificationfunction(isIE);
			if (isElementPresent(CROSS_MARK)) {

				waitUntilElementDisappears(CROSS_MARK);
				syllabificationfunction(isIE);
			}
		} else {
			log.info("Runnig the Syllabification at RC mode");
			// Count the bundles need to be completed by student
			List<WebElement> progressBars = LocatorWebElements(BUNDLE_COUNT);
			for (int progressCount = 1; progressCount <= progressBars.size(); progressCount++) 
			{
				syllabificationfunction(isIE);
				if (isElementPresent(CROSS_MARK)) 
				{
					waitUntilElementDisappears(CROSS_MARK);
					syllabificationfunction(isIE);
					
				}
				waitForSecs(10, "wait for correct or wrong answer to disappear and next bundle automatic audio is completed");
			}
		}
	}

}
