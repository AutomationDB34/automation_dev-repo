package com.page.module.ll.level1activities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.RhymingAdvancedLocators;
import com.testng.Assert;

public class RhymingAdvanced extends CommonFunctionalities implements RhymingAdvancedLocators {

	private WebDriver driver;
	private LLData llData = new LLData();
	Logger log = Logger.getLogger(getClass());
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	public RhymingAdvanced(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	/**
	 * Purpose is to verify whether the activity is loaded or not
	 */
	public void verifyRymingAdvancedActivity() {

		closeInstIcon();
		Assert.assertTrue(isElementPresent(LEFT_CONTAINER, LONGWAIT),
				"Rhyming Advanced activity is not being displayed on page");
	}

	public void rhymingadvancedfunction(boolean isIE) {
		Assert.assertTrue(isElementDisplayed(MUSIC_NOTE), "Rhyming activity music note is not in displayed");

		// Drag and drop a tile1 into the left container
		if (isIE) {
			safeClickUsingSikuli(llData.rhymingLeftContainerImage,
					"Left container section of the Rhyming Advanced activity using sikuli", LONGWAIT);
		}
		dragAndDrop(TILE_1, LEFT_CONTAINER, LONGWAIT);
		Assert.assertTrue(isElementDisplayed(LEFT_CONTAINER),
				"Rhyming activity Left container is not in disabled state");
		waitForSecs(3);
		// Drag and drop a tile2 into the right container
		if (isIE) {
			safeClickUsingSikuli(llData.rhymingRightContainerImage,
					"Right container section of the rhyming advanced activity using sikuli", LONGWAIT);
		}
		dragAndDrop(TILE_2, RIGHT_CONTAINER, LONGWAIT);

		// Verify whether a correct /incorrect match is being made
		if (isElementPresent(INCORRECT_MATCH)) {
			System.out.println("Rhyming activity incorrect match ");
			waitUntilElementDisappears(INCORRECT_MATCH);
		} else {
			System.out.println("Rhyming activity correct match");
		}

		// Click the next button to move further
		safeClick(NEXT_BTN);
		waitForSecs(2);
	}

	/**
	 * Purpose of the method is to test only one bundle of the activity
	 */
	public void rhymingAdvanced(boolean isIE) {

		// Conditional run for Build a word Family activity
		if (executionMode.equalsIgnoreCase("qc")) {
			log.info("Runnig the Build a word Family Activity at QC mode");
			rhymingadvancedfunction(isIE);
		} else {
			log.info("Runnig the Blend Activity at QC mode");
			// Count the Steps need to be completed by student
			List<WebElement> progressBars = LocatorWebElements(BUNDLE_COUNT);
			for (int progressCount = 1; progressCount <= progressBars.size(); progressCount++) {
				rhymingadvancedfunction(isIE);
			}

		}
	}

	/**
	 * purpose id to verify the summary page of the activity
	 */
	public void rhymingAdvancedSummary() {

		Assert.assertTrue(isElementDisplayed(SUMMARY_HEADER), "Rhyming activity Summary page is not displayed");

		// get the correct ans incorrect words count displayed in respective
		// column
		List<WebElement> correctCount = LocatorWebElements(CORRECT_ANSWERS);
		List<WebElement> incorrectCount = LocatorWebElements(INCORRECT_ANSWERS);

		String correctAnswersCount = Integer.toString(correctCount.size());
		String incorrectAnswersCount = Integer.toString(incorrectCount.size());

		int correct = correctCount.size();
		int incorrect = incorrectCount.size();
		int total_question = correct + incorrect;
		System.out.println(total_question);

		String summarycorrectCount = driver.findElement(SUMMARY_CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + summarycorrectCount);

		String questionscount = driver.findElement(SUMMARY_QUESTIONS_COUNT).getText();
		System.out.println("Number of questions displayed in the summary header:" + questionscount);

		// compare the correct count with the correct count displayed in the
		// summary header
		if ((correctAnswersCount.equals(summarycorrectCount))
				&& (questionscount.contains(Integer.toString(total_question)))) {
			System.out.println("Correct answers count is matched with the Correct count dispalyed in the header");
			safeClick(SUMMARY_CONTINUE_BTN);
		} else {

			System.out.println("count not matching");
		}

	}
}
