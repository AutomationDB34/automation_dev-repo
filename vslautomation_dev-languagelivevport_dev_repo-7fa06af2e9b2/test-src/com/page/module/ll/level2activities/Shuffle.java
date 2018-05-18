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

import com.datamanager.ConfigManager;
import com.page.locators.ll.level2activities.ShuffleLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.utilities.UtilityMethods;

public class Shuffle extends CommonFunctionalities implements ShuffleLocators {

	private WebDriver driver;
	private int incorrectcount;
	private int correctcount;
	ConfigManager app = new ConfigManager("App");
	Logger log = Logger.getLogger(getClass());

	public Shuffle(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify whether the activity is loaded or not
	 */
	public void verifyShuffleActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(SUFFLE_CONTENT_CONTAINER), "shuffle activity is not being dispalyed");
	}

	/**
	 * Purpose is to verify the shuffle functionality
	 * 
	 * @param isIE
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void shuffleFunctionality(boolean isIE) {

		List<WebElement> answerTilesRowsCount = LocatorWebElements(SHUFFLE_TILES_ROWS);
		System.out.println("Answer tiles rows:" + answerTilesRowsCount.size());

		for (int i = 1; i <= answerTilesRowsCount.size(); i++) {

			List<WebElement> answerTilesCount = LocatorWebElements(
					Dynamic.getNewLocator(SHUFFLE_TILES_IN_A_ROW, "[" + Integer.toString(i) + "]"));
			System.out.println("Answer tiles count:" + answerTilesCount.size());

			for (int j = 1; j <= answerTilesCount.size(); j++) {

				if (isElementPresent(TARGET_TILE)) {

					if (isIE) {

						Point coordinates = driver.findElement(SUFFLE_CONTENT_CONTAINER).getLocation();
						int x = coordinates.getX();
						int y = coordinates.getY();
						Dimension dimentions = driver.findElement(SUFFLE_CONTENT_CONTAINER).getSize();
						int height = dimentions.getHeight();
						int width = dimentions.getWidth();
						try {
							Robot robotclass = new Robot();
							robotclass.mouseMove(2 * x + height, 2 * y + width);
						} catch (AWTException e) {
							log.info("unable to perform Robot actions at shuffle functionolities"
									+ UtilityMethods.getStackTrace());

						}
					}
					dragAndDrop(Dynamic.getNewLocator(SHUFFLE_ANSWER_TILES, "[" + Integer.toString(i) + "]",
							"[" + Integer.toString(j) + "]"), TARGET_TILE, LONGWAIT);
					waitForSecs(2);
				}
			}
		}
		safeClick(CHECK_IT_BTN);
	}

	/**
	 * Purpose is to complete all the bundles in the shuffle activity
	 * 
	 * @param isIE
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void shuffle(boolean isIE) {

		// Conditional run for shuffle Activity
		if (app.getProperty("App.ExecutionMode").equalsIgnoreCase("qc")) {
			log.info("Runnig the breaking Words at QC mode");

			shuffleFunctionality(isIE);
			if (isElementPresent(INCORRECT_COLOR)) {
				waitUntilElementDisappears(INCORRECT_COLOR);
				shuffleFunctionality(isIE);
				incorrectcount++;
			} else {
				correctcount++;
			}
			System.out.println("incorrect answers count : " + incorrectcount);

		} else {
			log.info("Runnig the shuffle at RC mode");

			List<WebElement> bundleCount = LocatorWebElements(BUNDLE_COUNT);
			System.out.println("Answer tiles rows:" + bundleCount.size());

			for (int i = 1; i <= bundleCount.size(); i++) {
				shuffleFunctionality(isIE);
				if (isElementPresent(INCORRECT_COLOR)) {
					waitUntilElementDisappears(INCORRECT_COLOR);
					shuffleFunctionality(isIE);
					incorrectcount++;
				} else {
					correctcount++;
				}
			}
			System.out.println("incorrect answers count : " + incorrectcount);

		}
	}

	/**
	 * Purpose is to verify the summary page of the shuffle activity
	 */
	public void shuffleSummary() {

		Assert.assertTrue(isElementPresent(SUMMARY_HEADER), "shuffle activity summary page is not being dispalyed");

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
