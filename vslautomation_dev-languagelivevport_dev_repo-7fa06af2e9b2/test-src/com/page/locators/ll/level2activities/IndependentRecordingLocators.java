package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface IndependentRecordingLocators {
	
	By RECORD_THE_PASSAGE_POPUP = By.xpath("//span[contains(text(),'Record the passage.')]");
	By START_BTN = By.xpath("//button[contains(text(),'Start')]");
	
	By PASSAGE_TITLE = By.xpath("//div[contains(text(),'Hope for Hugs')]");
	By STOP_RECORDING_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.IndependentReading.Recording.button')]");
	
	By READY_TO_UPLOAD_RECORDING_POPUP = By.xpath("//div[contains(text(),'Ready to upload your recording.')]");
	By ENCODE_RECORDING_POPUP = By.xpath("//div[contains(text(),'Encoding your recording.')]");
	By UPLOAD_YOUR_RECORDING_POPUP = By.xpath("//div[contains(text(),'Uploading your recording.')]");
	By UPLOAD_COMPLETE_POPUP = By.xpath("//div[contains(text(),'Upload complete.')]");
	By CLICK_ON_LAST_WORD_POPUP = By.xpath("//span[contains(text(),'Click on the last word you read.')]");
	By LAST_WORD_SCREEN = By.xpath("//div[contains(text(),'Click on the last word you read.')]");
	By LAST_WORD = By.xpath("//div[contains(@class,'Cambium.Bundles.IndependentReading.LastWord.passageContainer')]/div[20]");
	
	By CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
	By SUMMARY_SCREEN = By.xpath("//div[contains(text(),'Reading Results')]");
	By SCORE_BAR = By.xpath("//div[contains(@class,'Cambium.UI.Pinnable')]");

}
