package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface BigWordStrategyLocators {

	By STEP1_HEADER = By.xpath("//span[contains(text(),'Step 1')]");
	By STEP2_HEADER = By.xpath("//span[contains(text(),'Step 2')]");

	By BIG_WORD_STRATEGY_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.BigWordStrategy.contentContainer')]");
	
	// Step1 Locators
	By STEP_1_VOWEL = By
			.xpath("//div[contains(@class,'Cambium.Bundles.BigWordStrategy.contentContainer')]/ul/li[1]/div/div[2]");
	By VOWEL_TILE = By.xpath("//div[@class='Cambium.Bundles.BigWordStrategy.colorsContainer']/div/div");

	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");

	By CROSS_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.wrong')]");
	By TICK_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.right')]");

	// step2 Locators
	By STEP_2_LETTERS_COUNT = By
			.xpath("//div[contains(@class,'Cambium.Bundles.BigWordStrategy.contentContainer')]/ul/li");

	By SYLLABLE_DIVISION_1 = By.xpath(
			"//div[contains(@class,'Cambium.Bundles.BigWordStrategy.contentContainer')]/ul/li[2]//div[@class='Cambium.UI.Marble.dragger']");

	By SYLLABLE_DIVISION_2 = By.xpath(
			"//div[contains(@class,'Cambium.Bundles.BigWordStrategy.contentContainer')]/ul/li[4]//div[@class='Cambium.UI.Marble.dragger']");

	By BLUE_MARBLE = By.xpath("//div[contains(@class,'Cambium.UI.Marble.blue cambium_ui_marble')]/div/span[3]");

	By INCORRECT_ANSWER = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.incorrect')]");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");

	// Summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Check Understanding')]");

	By SUMMARY_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_QUES_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");

	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");

}
