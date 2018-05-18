package com.page.module.ll.level2activities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.page.locators.ll.level2activities.AddingSuffixesLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;

public class AddingSuffixes extends CommonFunctionalities implements AddingSuffixesLocators {

	private WebDriver driver;
	private int incorrectcount;
	private int correctcount;
	Logger log = Logger.getLogger(getClass());

	public AddingSuffixes(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify the audio functionality
	 */
	public void verifyAduioBarFunctionality() {
		closeInstIcon();
		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED), "Adding suffixes activity audio is being palyed");
	}

	/**
	 * Purpose is to complete the step1 of the Adding suffixes activity
	 */
	public void step1_Addingsuffixes() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(STEP1_HEADER), "Step 1 of adding suffixes is not being dispalyed");
		safeClick(DOUBLE_IT_BTN);
		if (isElementPresent(STEP1_CROSS_MARK)) {
			waitUntilElementDisappears(STEP1_CROSS_MARK);
		} else {
			waitUntilElementDisappears(STEP1_TICK_MARK);
		}
	}

	/**
	 * Purpose is to enter text into the answer text area of step 2
	 */
	public void enterTextIntoTextArea() {
		String length = safeGetAttribute(ANSWER_TEXT_BOX, "maxlength", LONGWAIT);
		for (int maxlength = 1; maxlength <= Integer.parseInt(length); maxlength++) {
			safeType(ANSWER_TEXT_BOX, "t");
		}
	}

	/**
	 * Purpose is to complete the step2 of the Adding suffixes activity
	 */
	public void step2_AddingSuffixes() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(STEP2_HEADER), "Step 2 of adding suffixes is not being dispalyed");

		enterTextIntoTextArea();
		safeClick(CHECK_IT_BTN);
		if (isElementPresent(STEP2_INCORRECT)) {
			waitUntilElementDisappears(STEP2_INCORRECT);
			enterTextIntoTextArea();
			safeClick(CHECK_IT_BTN);
			incorrectcount++;
		} else {
			waitUntilElementDisappears(STEP2_CORRECT);
			correctcount++;
		}
	}

	/**
	 * Purpose is to complete one bundle of the Adding suffixes activity
	 */
	public void qcAddingSuffixes() {
		step1_Addingsuffixes();
		step2_AddingSuffixes();
		System.out.println("incorrect answers count" + incorrectcount);
		System.out.println("correct answers count" + correctcount);
	}

	/**
	 * Purpose is to complete all bundles of the Adding suffixes activity
	 */
	public void rcAddingSuffixes() {
		// get the bundle count of the activity
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("bundle count:" + bundlecount.size());

		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {
			step1_Addingsuffixes();
			step2_AddingSuffixes();
			System.out.println("incorrect answers count" + incorrectcount);
			System.out.println("correct answers count" + correctcount);
		}
	}
	
	/**
	 * purpose is to separate the execution from QC and RC
	 */
	public void AddingSuffixes(String executionMode)
	{
		if(executionMode.equalsIgnoreCase("RC"))
		{
			log.info("Selected mode is RC");
			rcAddingSuffixes();
		}
		else
		{
			log.info("Selected mode is QC");
			qcAddingSuffixes();
		}
	}

	/**
	 * Purpose is to verify the summary page of the Adding suffixes activity
	 */
	public void addingSuffixesSummary() {

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
