package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface BreakingWordsLocators {

	By BREAKING_WORDS_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.BreakingWords.contentContainer')]");
	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.BreakingWords.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");

	By SYLLABLE_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.BreakingWords.contentContainer')]/ul/li");
	
	By ANSWER_TEXT_AREA =By.xpath("//div[contains(@class,'Cambium.Bundles.BreakingWords.contentContainer')]/ul/li[%s]//input[@class='Cambium.UI.LetterBox.input']");
	
	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");
	
	By INCORRECT_ANSWER = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.incorrect')]");
	By CORRECT_ANSWER = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.correct')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");

	
}
