package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface AddingSuffixesLocators {

	By STEP1_HEADER = By.xpath("//span[contains(text(),'Step 1')]");
	By STEP2_HEADER = By.xpath("//span[contains(text(),'Step 2')]");

	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.AddingSuffixes.audioButton')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	By DOUBLE_IT_BTN = By.xpath("//div[contains(@class,'Cambium.Bundles.AddingSuffixes.buttonsContainer')]/div[1]//button[contains(text(),'Double It')]");
	
	By STEP1_TICK_MARK = By.xpath("//span[contains(@class,'Cambium.UI.StateBox.right')]");
	By STEP1_CROSS_MARK = By.xpath("//span[contains(@class,'Cambium.UI.StateBox.wrong')]");
	
	By ANSWER_TEXT_BOX = By.xpath("//div[contains(@class,'Cambium.Bundles.AddingSuffixes.answer')]/div/input");
	
	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");
	
	By STEP2_INCORRECT = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.incorrect')]");
	By STEP2_CORRECT = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.correct')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");

	//Summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Adding Suffixes')]");

	By SUMMARY_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_QUES_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");

	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");

}
