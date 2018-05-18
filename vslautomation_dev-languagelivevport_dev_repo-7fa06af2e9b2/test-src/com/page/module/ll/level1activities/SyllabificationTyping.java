package com.page.module.ll.level1activities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.SyllabificationTypingLocators;
import com.testng.Assert;

public class SyllabificationTyping extends CommonFunctionalities implements SyllabificationTypingLocators {

	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public SyllabificationTyping(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of the method is to verify whether the activity is loaded or not
	 */
	public void verifySyllabificationTypingActivity() {

		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BAR, LONGWAIT),
				"Syllabification Typing activity is not being displayed on page");
	}

	/**
	 * Purpose of the method is to verify the functionality of the audio bar
	 */
	public void clickAudioBarfunctionality() {
		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED, LONGWAIT),
				"Syllabification Typing activity audio is not being played");
	}

	/**
	 * Purpose of the method is to verify the functionality of the
	 * syllabification typing activity
	 */
	public void syllabificationtyping() {

		String length = safeGetAttribute(ANSWER_CONTAINER, "maxlength", LONGWAIT);
		int number_of_letters = Integer.parseInt(length);

		// Drag and drop the tiles as per the length into the answer container
		for (int i = 1; i <= number_of_letters; i++) {

			safeType(ANSWER_CONTAINER, "t");
		}
		safeClick(CHECK_IT_BTN);
		waitForPageToLoad();
	}

	/**
	 * Purpose of the method is to verify one bundle of the syllabification
	 * typing activity
	 */
	public void SyllabificationTypingActivity() {
		if(executionMode.equalsIgnoreCase("rc"))
		{
			waitForPageToLoad();
			waitForSecs(3);
			log.info("Runnig the Syllabification Typing Activity at RC mode");
			for(int i=0;i<5;i++)
			{
				syllabificationtyping();
				if (isElementPresent(CROSS_MARK)) 
				{
					waitUntilElementDisappears(CROSS_MARK);
					safeClick(AUDIO_BAR);
					syllabificationtyping();
				}
			}
		}
		else
		{
			log.info("Runnig the Syllabification Typing Activity at QC mode");
			syllabificationtyping();
			if (isElementPresent(CROSS_MARK)) 
			{
				waitUntilElementDisappears(CROSS_MARK);
				safeClick(AUDIO_BAR);
				syllabificationtyping();
			}
		}

	}

	/**
	 * Purpose of the method is to verify summary page of the syllabification
	 * typing activity
	 */
	public void syllabificationTypingSummary() {

		waitUntilElementDisappears(CONTENT_CONTAINER, LONGWAIT);
		Assert.assertTrue(isElementDisplayed(SUMMARY_HEADER),
				"Summary page is not displayed in Syllabification activity");

		// get the correct and incorrect words count displayed in summary page

		List<WebElement> correctCount = LocatorWebElements(CORRECT_ANSWERS);
		List<WebElement> incorrectCount = LocatorWebElements(INCORRECT_ANSWERS);

		String correctAnswers = Integer.toString(correctCount.size());
		System.out.println(correctAnswers);

		String incorrectAnswers = Integer.toString(incorrectCount.size());
		System.out.println(incorrectAnswers);

		// get the correct words count and questions count displayed in summary
		// page Header
		String correctAnswersInSummaryHEader = driver.findElement(SUMMARY_CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + correctAnswersInSummaryHEader);

		String questionscountInSumamryHeader = driver.findElement(SUMMARY_QUES_COUNT).getText();
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
			safeClick(SUMMARY_CONTINUE_BTN);
		} else {

			System.out.println("count not matching");
		}

	}
}
