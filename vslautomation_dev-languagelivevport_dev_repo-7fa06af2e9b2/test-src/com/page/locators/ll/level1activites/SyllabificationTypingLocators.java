package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface SyllabificationTypingLocators {
	
	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.SyllabificationTyping.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
		
	By ANSWER_CONTAINER = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.editable')]//input");
	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");
	
	By CROSS_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.wrong')]");
		
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	By CONTENT_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.SyllabificationTyping.contentContainer')]");
	
	//Summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Syllabification')]");
	By INCORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.SyllabificationTyping.Summary.wrong')]");
	By CORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.SyllabificationTyping.Summary.right')]");
	
	By SUMMARY_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_QUES_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
}
