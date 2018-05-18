package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface ListenIdentifyKeywordWithSummaryLocators {

	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.ListenAndIdentify.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");

	By ANSWER_TILE = By.className("Cambium.UI.Draggable2.dragger");

	By CROSS_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.wrong')]");
	By TICK_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.right')]");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");

	// Summary Locators

	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Listen and Identify')]");
	By CORRECT_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.ListenAndIdentify.Summary.right')]");
	By INCORRECT_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.ListenAndIdentify.Summary.wrong')]");
	
	By SUMMARY_HEADER_CORRECT_VOUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_HEADER_QUES_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	

}
