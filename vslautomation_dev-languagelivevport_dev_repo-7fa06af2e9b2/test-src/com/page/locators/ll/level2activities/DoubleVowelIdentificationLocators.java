package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface DoubleVowelIdentificationLocators {

	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.DoubleVowelIdentification.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	By VOWEL_TILE_A = By.xpath("//div[@class='Cambium.Bundles.DoubleVowelIdentification.contentContainer']/div[1]/div[@class='Cambium.UI.LetterBox.dragger']");
	By VOWEL_TILE_E = By.xpath("//div[@class='Cambium.Bundles.DoubleVowelIdentification.contentContainer']/div[2]/div[@class='Cambium.UI.LetterBox.dragger']");

	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");
	
	By INCORRECT_ANSWER = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.incorrect')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	//Summary Locators
	By SUMMARY_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_QUES_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
}
