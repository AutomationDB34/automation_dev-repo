package com.page.module.ll.level2activities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.level2activities.KeyConceptQuizLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;

public class KeyConceptQuiz extends CommonFunctionalities implements KeyConceptQuizLocators {

	private WebDriver driver;
	Logger log = Logger.getLogger(getClass());

	public KeyConceptQuiz(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify whether the activity is loaded or not
	 */
	public void verifyKeyConceptquizActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BAR), "Key Concept quiz Activity is not being displayed");
	}

	/**
	 * purpose is to verify the functionality of audio bar
	 */
	public void verifyAudioBarFunctionality() {
		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED), "Key Concept quiz Activity audio is not being played");
	}

	/**
	 * purpose is to complete all the bundles of the Key concept quiz activity
	 */
	public void keyConceptQuiz() 
	{
		// get the bundle count of the activity
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());

		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {

			safeClick(TRUE_BTN);

			if (isElementPresent(TICK_MARK)) {
				log.info("correct option is selected");
				waitUntilElementDisappears(TICK_MARK);
			} else {
				log.info("incorrect option is selected");
				waitUntilElementDisappears(CROSS_MARK);
			}
		}
	}

	/**
	 * purpose is to verify the summary page Key concept quiz activity
	 */
	public void keyConceptQuizSummary() {

		// get the correct and incorrect words count displayed in summary page
		List<WebElement> correctCount = LocatorWebElements(CORRECT_ANSWERS);
		List<WebElement> incorrectCount = LocatorWebElements(INCORRCT_ANSWERS);

		String correctAnswers = Integer.toString(correctCount.size());
		System.out.println(correctAnswers);

		String incorrectAnswers = Integer.toString(incorrectCount.size());
		System.out.println(incorrectAnswers);

		// get the correct words count and questions count displayed in summary
		// page Header
		String correctAnswersInSummaryHEader = safeGetText(SUMMARY_HEADER_CORRECT_COUNT, LONGWAIT);
		System.out.println("Correct count dispalyed in summary Page:" + correctAnswersInSummaryHEader);

		String questionscountInSumamryHeader = safeGetText(SUMMARY_HEADER_QUES_COUNT, LONGWAIT);
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
	
	/**
	 * Purpose of the method is to navigate to home page on completing the activity
	 */
	public void navigateToHomePagefromActivity(){
		closeInstIcon();
		mouseHover(ACTIVITY_USER_DROP_DOWN, LONGWAIT);
		safeClick(HOME_LINK, LONGWAIT);
	}

	
}
