package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface SentenceCompletionLocators {

	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.SentenceCompletion.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");

	By DRAGGABLE_AREA = By.xpath("//span[contains(@class,'SentenceCompletion.answer')]/span");

	By CROSS_MARK = By.xpath(
			"//span[contains(@class,'SentenceCompletion.answer')]/div/div[contains(@class,'Cambium.UI.StateBox.wrong')]");

	By RIGHT_MARK = By.xpath("//span[contains(@class,'SentenceCompletion.answer')]/div/div[contains(@class,'Cambium.UI.StateBox.right')]");
	
	By ANSWER_TILE = By.xpath(
			"//div[@class='Cambium.Bundles.SentenceCompletion.choicesContainer']/span[1]//span[@class='Cambium.UI.Draggable2.txt']");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	//Summary Locators
	By SUMMARY_HEADER = By.xpath("//div[contains(text(),'Sentence Completion: Results')]");
	By INCORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.SentenceCompletion.Summary.wrong')]");
	By CORRECT_ANSWERS= By.xpath("//div[contains(@class,'Cambium.Bundles.SentenceCompletion.Summary.right')]");
	By SUMMARY_CONTINUE = By.xpath("//button[contains(text(),'Continue')]");
	
	
	
}
