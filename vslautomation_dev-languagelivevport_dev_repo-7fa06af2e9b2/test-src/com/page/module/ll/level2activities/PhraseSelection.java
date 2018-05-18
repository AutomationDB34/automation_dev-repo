package com.page.module.ll.level2activities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.page.locators.ll.level2activities.PhraseSelectionLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;

public class PhraseSelection extends CommonFunctionalities implements PhraseSelectionLocators {
	private WebDriver driver;
	private int incorrectcount;
	private int correctcount;
	Logger log = Logger.getLogger(getClass());

	public PhraseSelection(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to complete all the bundles of the Phrase Selection activity
	 */
	public void rcPhraseSelection() {

		closeInstIcon();

		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());
		for (int i = 1; i <= bundlecount.size(); i++) 
		{

			Assert.assertTrue(isElementPresent(PHRASE_SELECTION_CONTAINER),
					"Phrase Selection activity is not being dispalyed");
			safeClick(PHRASE_SELECTION_OPTION);

			if (isElementPresent(INCORRECT_ANSWER)) {
				incorrectcount++;
				waitUntilElementDisappears(INCORRECT_ANSWER);

			} else {
				correctcount++;
				waitUntilElementDisappears(CORRECT_ANSWER);
			}
			System.out.println("Incorrect answers count" + incorrectcount);
			System.out.println("correct answers count" + correctcount);
		}
	}

	/**
	 * Purpose is to complete one of the bundle of the Phrase Selection activity
	 */
	public void qcPhraseSelection() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(PHRASE_SELECTION_CONTAINER),
				"Phrase Selection activity is not being dispalyed");
		safeClick(PHRASE_SELECTION_OPTION);

		if (isElementPresent(INCORRECT_ANSWER)) {
			incorrectcount++;
			waitUntilElementDisappears(INCORRECT_ANSWER);

		} else {
			correctcount++;
			waitUntilElementDisappears(CORRECT_ANSWER);
		}
		System.out.println("Incorrect answers count" + incorrectcount);
		System.out.println("correct answers count" + correctcount);
	}
	
	/**
	 * QC/RC separate calling method
	 * @param executionMode
	 */
	public void PhraseSelection(String executionMode)
	{
		waitForSecs(10);
		if(executionMode.equalsIgnoreCase("RC"))
		{
			log.info("Selected RC mode of execution");
			rcPhraseSelection();		
		}
		else
		{
			log.info("Selected QC mode of execution");
			qcPhraseSelection();
		}
		
	}

	/**
	 * Purpose is to verify the summary page of the Phrase Selection activity
	 */
	public void PhraseSelectionSummary() {
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER),
				"Big Word strategy activity summary page is not being dispalyed");

		int total_Questions = incorrectcount + correctcount;
		System.out.println(total_Questions);

		// get the correct words count and questions count displayed in summary
		// page Header
		String correctAnswersInSummaryHEader = driver.findElement(SUMMARY_CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + correctAnswersInSummaryHEader);

		String questionscountInSumamryHeader = driver.findElement(SUMMARY_QUES_COUNT).getText();
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
