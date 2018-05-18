package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface SentenceCompletionWithNoErrorCorrectionLocators {
	
	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.SentenceCompletion.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	By ANSWER_AREA = By.xpath("//span[contains(@class,'Cambium.Bundles.SentenceCompletion.answer')]");
	By ANSWER_TILE = By.xpath("//div[@class='Cambium.Bundles.SentenceCompletion.choicesContainer']/span[1]//span[@class='Cambium.UI.Draggable2.txt']");
		
	By CONTENT_CONTAINER = By.className("Cambium.Bundles.SentenceCompletion.content");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	//Summary Locators
	By SUMMARY_HEADER = By.xpath("//div[contains(text(),'Review: Results')]");
	By CORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.SentenceCompletion.Summary.right')]");
	By INCORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.SentenceCompletion.Summary.wrong')]");
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
}
