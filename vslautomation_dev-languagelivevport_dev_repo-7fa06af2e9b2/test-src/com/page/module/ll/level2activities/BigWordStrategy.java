package com.page.module.ll.level2activities;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.page.locators.ll.level2activities.BigWordStrategyLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.utilities.UtilityMethods;

public class BigWordStrategy extends CommonFunctionalities implements BigWordStrategyLocators {

	private WebDriver driver;
	private int incorrectcount;
	private int correctcount;
	Logger log = Logger.getLogger(getClass());

	public BigWordStrategy(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to complete the step1 of the Big WordStrategy activity
	 * @throws AWTException 
	 */
	public void step1_BigWordStrategy(boolean isIE){
		closeInstIcon();
		Assert.assertTrue(isElementPresent(STEP1_HEADER), "Step 1 of big word strategy is not being dispalyed");

		if (isIE) {
			Point coordinates = driver.findElement(BIG_WORD_STRATEGY_CONTAINER).getLocation();
			int x = coordinates.getX();
			int y = coordinates.getY();
			Dimension dimentions = driver.findElement(BIG_WORD_STRATEGY_CONTAINER).getSize();
			int height = dimentions.getHeight();
			int width = dimentions.getWidth();
			try
			{
			Robot robotclass = new Robot();
			robotclass.mouseMove(4 * x + height, 4 * y + width);
			}
			catch(AWTException e)
			{
				log.info("Unable perform Robot Actions at Bigword strategy" + UtilityMethods.getStackTrace());
			}
		}
		dragAndDrop(VOWEL_TILE, STEP_1_VOWEL, LONGWAIT);
		safeClick(CHECK_IT_BTN);
		if (isElementPresent(CROSS_MARK)) {
			waitUntilElementDisappears(CROSS_MARK);
			dragAndDrop(VOWEL_TILE, STEP_1_VOWEL, LONGWAIT);
			safeClick(CHECK_IT_BTN);
		}
	}

	/**
	 * Purpose is to complete the step2 of the Big WordStrategy activity
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	public void step2_BigWordStrategy(){
		closeInstIcon();
		Assert.assertTrue(isElementPresent(STEP2_HEADER), "Step 2 of big word strategy is not being dispalyed");
	
		List<WebElement> letterscount = LocatorWebElements(STEP_2_LETTERS_COUNT);
		System.out.println("Letters count:" + letterscount.size());
		if (letterscount.size() > 4) {
			waitForSecs(1);
			dragAndDrop(BLUE_MARBLE, SYLLABLE_DIVISION_1, LONGWAIT);
			safeClick(CHECK_IT_BTN);
			if (isElementPresent(INCORRECT_ANSWER)) {
				waitUntilElementDisappears(INCORRECT_ANSWER);
				dragAndDrop(BLUE_MARBLE, SYLLABLE_DIVISION_2, LONGWAIT);
				safeClick(CHECK_IT_BTN);
				incorrectcount++;
			} else {
				correctcount++;
			}
		}
	}

	/**
	 * Purpose is to complete all the bundles of Big Word Strategy activity
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	public void rcBigWordStrategy(boolean isIE)
 {
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());
		for (int i = 1; i <= bundlecount.size(); i++) {
			step1_BigWordStrategy(isIE);
			step2_BigWordStrategy();
			System.out.println("incorrect answers count" + incorrectcount);
			System.out.println("correct answers count" + correctcount);
		}
	}
	
	/**
	 * Purpose is to complete one of the bundle of Big Word Strategy activity
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	public void qcBigWordStrategy(boolean isIE){ 
			step1_BigWordStrategy(isIE);
			step2_BigWordStrategy();
			System.out.println("incorrect answers count" + incorrectcount);
			System.out.println("correct answers count" + correctcount);
	}
	
	
	/**
	 * Select the mode of execution call the internal method with the class
	 */
	public void bigWordStrategy(boolean isIE,String executionMode)
	{
		if(executionMode.equalsIgnoreCase("RC"))
		{
			log.info("Selected mode is RC");
			rcBigWordStrategy(isIE);
		}
		else
		{
			log.info("Selected mode is QC");
			qcBigWordStrategy(isIE);
		}
	}

	/**
	 * Purpose is to verify the summary page of the Big Word Strategy activity
	 */
	public void bigWordStrategysummary() {
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
