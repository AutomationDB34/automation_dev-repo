package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface BlendAndReadAlternateLocators {

	By STEP_1_HEADER = By.xpath("//span[contains(text(),'Step 1')]");
	By STEP_2_HEADER = By.xpath("//span[contains(text(),'Step 2')]");
	By STEP_3_HEADER = By.xpath("//span[contains(text(),'Step 3')]");

	//Step1 Locators
	By STEP1_SLLABLE_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.BlendAndReadAlternate.contentContainer')]/ul/li");
	By SYLLABLE_TILE = By.xpath("//div[contains(@class,'Cambium.Bundles.BlendAndReadAlternate.contentContainer')]/ul/li[%s]/div/div");
	By TARGET_SYLLABLE_TILE = By.xpath("//div[contains(@class,'Cambium.Bundles.BlendAndReadAlternate.target')]");
	
	//Step2 Locators
	By RECORD_IT_BTN = By.xpath("//div[contains(text(),'RECORD IT')]");
	
	//Step3 Locators
	By THUMPS_UP_BTN = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.ThumbsButton.up ')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	//summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Blend and Read Words')]");
	By THUMPS_UP_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.BlendAndReadAlternate.Summary.right')]");
	By THUMPS_DOWN_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.BlendAndReadAlternate.Summary.wrong')]");
	By CORRECT_COUNT= By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By NUMBER_OF_QUESTIONS = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	By CONTINUE_SUMMARY_BTN = By.xpath("//button[contains(text(),'Continue')]");

	
}
