package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface KeyConceptQuizLocators {

	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.KeyConceptQuiz.audioButton')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	By TEXT_CONTAINER = By.className("Cambium.Bundles.KeyConceptQuiz.textContainer");
	By TRUE_BTN = By.xpath("//button[contains(text(),'True')]");
	
	By TICK_MARK = By.xpath("//span[contains(@class,'Cambium.UI.StateBox.right')]");
	By CROSS_MARK = By.xpath("//span[contains(@class,'Cambium.UI.StateBox.wrong')]");
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	//Summary page Locators
	By CORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.KeyConceptQuiz.Summary.right')]");
	By INCORRCT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.KeyConceptQuiz.Summary.wrong')]");
	
	By SUMMARY_HEADER_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_HEADER_QUES_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
}
