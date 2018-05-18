package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface SentenceCompletionSpellingLocators {
	
	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.SentenceCompletion.Spelling.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	By ANSWER_LENGTH = By.xpath("//span[contains(@class,'Cambium.Bundles.SentenceCompletion.Spelling.answer')]");
	By ANSWER_AREA = By.xpath("//span[contains(@class,'Cambium.Bundles.SentenceCompletion.Spelling.answer')]//input[@class='Cambium.UI.Draggable2.Editable.input']");
	
	By INCORRECT_TILE = By.xpath("//span[@class='Cambium.UI.Draggable2.txt'][contains(text(),'tt')]");
	
	
	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");
	
	By CROSS_MARK = By.xpath("//div[contains(@class,'cambium_ui_state_box Cambium.UI.StateBox.wrong')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	
	//Summary Locators
	
	By SUMMARY_HEADER = By.xpath("//div[contains(text(),'Sentence Completion with Spelling: Results')]");
	By CORRECT_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.SentenceCompletion.Spelling.Summary.right')]");
	By INCORRECT_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.SentenceCompletion.Spelling.Summary.wrong')]");

	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
}
