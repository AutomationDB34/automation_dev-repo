package com.page.module.ll.goals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.goals.SpellWordsGoalLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;

public class SpellWordsGoalPage extends CommonFunctionalities implements SpellWordsGoalLocators {
	private WebDriver driver;
	List<WebElement> incorrectcount;
	List<WebElement> incorrectWordsCount;
	String effort;
	String score;
	String hint;

	public SpellWordsGoalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * To verify the Goal introduction videos
	 */
	public void verifyGoalVideos() {
		Assert.assertTrue(isElementPresent(REPLAY_VIDEO_LINK), "Goal video1 is not being displayed");
		safeClick(VIDEO_1_CONTINUE_BTN);
		Assert.assertTrue(isElementPresent(REPLAY_VIDEO_LINK), "Goal video2 is not being displayed");
		safeClick(VIDEO_1_CONTINUE_BTN);
	}

	/**
	 * To click the start button in the pop up
	 */
	public void clickStartBTN() {
		Assert.assertTrue(isElementDisplayed(READY_TO_START_POPUP), "Ready to start? pop up is not being displayed");
		safeClick(START_BTN);
	}

	/**
	 * To complete the spell words test
	 */
	public void startSpellWordsTest() {

		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		for (int j = 0; j < bundlecount.size(); j++) {

			Assert.assertTrue(isElementClickable(SPELLWORDS_AUDIO_BAR), "Spell words audio bar is not clickable");

			String maxlength = safeGetAttribute(TEXT_AREA, "maxlength", MEDIUMWAIT);
			int length = Integer.parseInt(maxlength);

			for (int i = 0; i < length; i++) {
				safeType(TEXT_AREA, "t", MEDIUMWAIT);
			}

			safeClick(CHECK_IT_BTN);
		}
	}

	/**
	 * To verify the results screen after the test
	 */
	public void verifyResultsScreen() {
		Assert.assertTrue(isElementDisplayed(RESULTS_SCREEN), "Test results screen is not being displayed");
		effort = safeGetText(EFFORT_COUNT, MEDIUMWAIT);
		score = safeGetText(SCORE, MEDIUMWAIT);
		safeClick(CONTINUE_BTN);
	}

	/**
	 * To verify the attempt summary screen
	 */
	public void verifyAttemptSummaryPage() {
		Assert.assertTrue(isElementDisplayed(ATTEMPT_SUMMARY), "Attempt summary screen is not being displayed");
		incorrectcount = LocatorWebElements(INCORRECT_COUNT);
		safeClick(CONTINUE_BTN);
	}

	/**
	 * To verify the review pop up
	 */
	public void verifyReviewPopUp() {
		Assert.assertTrue(isElementDisplayed(READY_TO_REVIEW_POPUP), "Ready to review pop up is not being displayed");
		safeClick(START_BTN);
	}

	/**
	 * To verify the review error page
	 */
	public void verifyReviewErrorsPage() {
		Assert.assertTrue(isElementDisplayed(REVIEW_ERRORS_PAGE), "Review error page is not being displayed");
		incorrectWordsCount = LocatorWebElements(INCORRECT_WORDS_COUNT);
		safeClick(CONTINUE_BTN);
	}

	/**
	 * To complete the remediation of spell words
	 */
	public void spellWordsRemediation() {

		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		for (int j = 0; j < bundlecount.size(); j++) {
			safeType(TEXT_AREA, "t", MEDIUMWAIT);
			safeClick(CHECK_IT_BTN);
			if (isElementDisplayed(REMEDIATION_INCORRECT_ATTEMPT)) {
				safeType(TEXT_AREA, "t", MEDIUMWAIT);
				safeClick(CHECK_IT_BTN);
			}
			waitForSecs(2);
			hint = safeGetAttribute(REMEDIATION_HINT, "value", MEDIUMWAIT);
			safeType(TEXT_AREA, hint, MEDIUMWAIT);
			safeClick(CHECK_IT_BTN,MEDIUMWAIT);
		}
		
		waitForSecs(6,"Waiting for continue button");
	}

	/**
	 * To click continue/retake test button in the transition pages
	 */
	public void verifytransitionPage() {
		
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
	 * To complete Spell words in slow pace i.e., 8 attempts
	 */
	public void spellWordsGoalInSlowPace() {

		for (int i = 1; i <= 8; i++) {
			clickStartBTN();
			// Step9: Verify spell words goal started
			// Step10:Complete all the bundles of the spell words test
			startSpellWordsTest();
			// Step11: Verify the Test results screen
			verifyResultsScreen();
			// Step12: Verify the Atempt summary screen
			verifyAttemptSummaryPage();
			// Verify Review error screen
			verifyReviewPopUp();
			verifyReviewErrorsPage();
			// Step13: Complete the Remediation of the incorrect words
			clickStartBTN();
			// Step14: Complete the Remediation of the incorrect words
			spellWordsRemediation();
			verifytransitionPage();
		}
	}
}
