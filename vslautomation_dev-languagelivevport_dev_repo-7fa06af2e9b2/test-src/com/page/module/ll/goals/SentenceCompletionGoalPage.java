package com.page.module.ll.goals;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.page.locators.ll.goals.SentenceCompletionGoalLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class SentenceCompletionGoalPage extends CommonFunctionalities implements SentenceCompletionGoalLocators {
	Logger log = Logger.getLogger(getClass());
	private WebDriver driver;
	List<WebElement> error_count;

	public SentenceCompletionGoalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * To verify the Ready to pop up 
	 * @param expectedReadyToPreviewHeaderText
	 */
	public void verifyReadyToWindow(String expectedReadyToPreviewHeaderText) {
		String actualReadyToPreviewHeaderText = safeGetText(READYTO_TEXT, LONGWAIT);
		Assert.assertEquals(actualReadyToPreviewHeaderText, expectedReadyToPreviewHeaderText,
				"The expected Ready to preview header text(" + expectedReadyToPreviewHeaderText
						+ ") is not matched with the actual header text(" + actualReadyToPreviewHeaderText + ")");
	}

	/**
	 * To verify the Goal introduction video
	 */
	public void verifyGoalVideos() {
		Assert.assertTrue(isElementPresent(REPLAY_VIDEO_LINK), "Goal video1 is not being displayed");
		safeClick(VIDEO_1_CONTINUE_BTN);
	}

	/** 
	 * To click 'Start' button in the pop up
	 */
	public void clickStarBtn() {
		waitForPageToLoad();
		safeClick(START_BTN, LONGWAIT);
	}

	/**
	 * To verify whether sentence completion goal is enabeld or not
	 */
	public void verifysentenceCompletionGoal() {
		Assert.assertTrue(isElementPresent(TIME_BAR), "Sent completion goal is not being displayed");
	}

	/**
	 * To complete sentence completion test
	 * @param isIE
	 */
	public void sentenceCompletionTest(boolean isIE) {

		if (isIE) {
			Point coordinates = driver.findElement(SENTENCE_CONTAINER).getLocation();
			int x = coordinates.getX();
			int y = coordinates.getY();
			Dimension dimentions = driver.findElement(SENTENCE_CONTAINER).getSize();
			int height = dimentions.getHeight();
			int width = dimentions.getWidth();
			Robot robotclass;
			try {
				robotclass = new Robot();
				robotclass.mouseMove(2 * x + height, 2 * y + width);
			} catch (AWTException e) {
				log.info("unable to perform keyboar actions" + UtilityMethods.getStackTrace());
				e.printStackTrace();
			}

		}
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		for (int bundles = 0; bundles < bundlecount.size(); bundles++) {
			dragAndDrop(DRAGGABLE_TILE, DROPPABLE_AREA, LONGWAIT);
			waitForSecs(3);
		}
	}

	/**
	 * To verify the test results screen
	 */
	public void verifyTestResultsScreen() {

		Assert.assertTrue(isElementDisplayed(TEST_RESULTS_SCREEN),
				"Test results sumamry screen is not being displayed");
		safeClick(CONTINUE_BTN);
	}

	/**
	 * To verify the review errors page
	 */
	public void verifyReviewErrorsPage() {
		Assert.assertTrue(isElementDisplayed(REVIEW_ERROR_PAGE), "Review error page is not being displayed");
		error_count = LocatorWebElements(ERROR_COUNT);
		System.out.println(error_count.size());
		safeClick(CONTINUE_BTN);
	}

	/**
	 * To complete the remediation of the sentence completion goal
	 */
	public void remediationSteps() {

		for (int i = 0; i < error_count.size(); i++) {
			Assert.assertTrue(isElementDisplayed(PHRASES_AND_SENTENCES), "Remediation screen is not being displayed");
			safeClick(RECORD_IT_BTN, LONGWAIT);
			waitForSecs(2, "Waiting for grading buttons to enable");
			safeClick(THUMPS_UP_BTN, LONGWAIT);
			safeClick(NEXT_BTN, LONGWAIT);
		}
		waitForSecs(5);
	}

	/**
	 * To enable microphone
	 * @param llData
	 * @param effort
	 */
	public void enableMic(LLData llData , int effort){
		if(effort==0){
		microPhoneSetUp(llData);
		}
	}
	/**
	 * To verify the transition pages and click continue/retake test button
	 * @param effortcount
	 */
	public void verifytransitionPage(int effortcount) {
		if (effortcount < 3 || effortcount == 7) {
			waitForSecs(4, "Waiting for the prsence of transition page");
			safeClick(CONTINUE_BTN, LONGWAIT);

		} else {
			waitForSecs(4, "Waiting for the prsence of retake test page");
			Assert.assertTrue(isElementDisplayed(TRASITION_PAGE),
					"Goal transition page to next step is not being displayed");
			safeClick(RETAKE_TEST_BTN, LONGWAIT);
		}
	}
	
	/**
	  * Click On Continue onRetake test page
	  */
	 public void clickContinueOnRetakeTest(int attemptCount) 
	 {
	  waitForSecs(3);
	  if(isElementDisplayed(RETAKE_TEST_BTN))
	  {
	   safeJavaScriptClick(RETAKE_TEST_BTN, MEDIUMWAIT);
	   waitForPageToLoad();
	  }
	  else
	  {
	   isElementPresent(CONTINUE_BTN, MEDIUMWAIT);
	   safeJavaScriptClick(CONTINUE_BTN, MEDIUMWAIT);
	   waitForPageToLoad();
	  }
	 }

	 /**
	  * To complete Sentence completion goal in slow pace
	  * @param isIE
	  * @param llData
	  */
	public void sentenceCompletionSlowpace(boolean isIE, LLData llData) {
		for (int i = 0; i < 8; i++) {

			// Step9: Click start button to start the Sentence completion goal
			clickStarBtn();
			// Step10: Verify sentence completion goal
			verifysentenceCompletionGoal();
			// Step11: Complete Sentence completion goal for all the bundles
			// Drag and drop the answer tiles into the answer area
			sentenceCompletionTest(isIE);
			// Step12: Verify Test results screen
			verifyTestResultsScreen();
			// Step13: Verify ready to review window
			verifyReadyToWindow(llData.Goal_ReadyToReviewText);
			// Step14: Click start button to start reviewing errors
			clickStarBtn();
			// Step15: Verify the errors page
			verifyReviewErrorsPage();
			// Step16: enable the microphone
			enableMic(llData , i);
			// Step17: Complete the remediation step
			remediationSteps();
			clickContinueOnRetakeTest(i);

		}
	}

}
