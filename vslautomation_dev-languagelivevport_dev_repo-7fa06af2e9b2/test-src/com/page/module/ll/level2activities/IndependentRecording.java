package com.page.module.ll.level2activities;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.page.locators.ll.level2activities.IndependentRecordingLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;

public class IndependentRecording extends CommonFunctionalities implements IndependentRecordingLocators {

	private WebDriver driver;
	private LLData llData = new LLData();

	public IndependentRecording(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * purpose is to enable the microphone
	 * 
	 * @throws AWTException
	 */
	public void enableMicroPhone(){
		microPhoneSetUp(llData);
	}

	/**
	 * purpose is to verify Record The Passsage Popup
	 */
	public void verifyRecordThePasssagePopup() {
		Assert.assertTrue(isElementPresent(RECORD_THE_PASSAGE_POPUP), "record the Pasage PopUp is not being displayed");
		safeClick(START_BTN);
	}

	/**
	 * purpose is to complete Independent Recording
	 */
	public void irRecording() {
		Assert.assertTrue(isElementPresent(PASSAGE_TITLE), "Passage tile is not being displayed in the recording page");
		waitForSecs(10);
		safeClick(STOP_RECORDING_BTN);
		Assert.assertTrue(isElementPresent(READY_TO_UPLOAD_RECORDING_POPUP),
				"Ready to Upload recording PopUp is not being displayed");
		safeClick(START_BTN);
		Assert.assertTrue(isElementPresent(ENCODE_RECORDING_POPUP), "Encode Recording PopUp is not being displayed");
		Assert.assertTrue(isElementPresent(UPLOAD_YOUR_RECORDING_POPUP),
				"Upload your recording PopUp is not being displayed");
		Assert.assertTrue(isElementPresent(UPLOAD_COMPLETE_POPUP), "Upload complete PopUp is not being displayed");

	}

	/**
	 * purpose is to click th elast word in the passage recorded
	 */
	public void verifyLastWordScreen() {
		Assert.assertTrue(isElementPresent(CLICK_ON_LAST_WORD_POPUP),
				"Click on the last word PopUp is not being displayed");
		safeClick(START_BTN);
		Assert.assertTrue(isElementPresent(LAST_WORD_SCREEN), "Click on the last word screen is not being displayed");
		safeClick(LAST_WORD);
		safeClick(CONTINUE_BTN);
	}

	/**
	 * purpose is to verify the summary screen of the Independent Recording
	 */
	public void irRecordingSummary() {
		Assert.assertTrue(isElementPresent(SUMMARY_SCREEN), "IR Recording results page is not being displayed");
		Assert.assertTrue(isElementPresent(SCORE_BAR), "Score bar is not being displayed");
		safeClick(CONTINUE_BTN);
	}
}
