package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface StressedSyllablesLocators {

	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.StressedSyllables.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");

	By STRESSED_SYLLABLE = By
			.xpath("//div[contains(@class,'Cambium.Bundles.StressedSyllables.contentContainer')]/ul/li[1]/div/div");

	By CORRECT_COLOR = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.correct')]");
	By INCORRECT_COLOR = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.incorrect')]");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");

	// Summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Check Understanding')]");
	By SUMMARY_HEADER_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_HEADER_QUES_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");

	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");

}
