package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface WordBuildingLocators {
	
	By STEP_1_HEADER = By.xpath("//span[contains(text(),'Step 1')]");
	By STEP_2_HEADER = By.xpath("//span[contains(text(),'Step 2')]");

	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.WordBuilding.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	//Step1 Locators
	By WORD_BUILDING_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.WordBuilding.contentContainer')]");
	By SYLLABLE_TILE = By.xpath("//div[contains(@class,'Cambium.UI.Draggable.originator')][@value='']/div");
	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");
	
	By INCORRECT_COLOR = By.xpath("//div[contains(@class,'Cambium.Bundles.WordBuilding.incorrectBGColor')]");
	By CORRECT_COLOR = By.xpath("//div[contains(@class,'Cambium.Bundles.WordBuilding.correctBGColor')]");

	//Step2 Locators
	By WORD_CONTAINER = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.group')]/ul/li[%s]/div/div[2]");
	By SYLLABLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.group')]/ul/li");
	By WORD_TILE_1= By.xpath("//div[@class='Cambium.Bundles.WordBuilding.choicesContainer']/div[1]/div");
	By WORD_TILE_2= By.xpath("//div[@class='Cambium.Bundles.WordBuilding.choicesContainer']/div[2]/div");

	By CROSS_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.wrong')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	//Summary Page locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Word Building')]");
	By CONTINUE_SUMMARY = By.xpath("//button[contains(text(),'Continue')]");


}
