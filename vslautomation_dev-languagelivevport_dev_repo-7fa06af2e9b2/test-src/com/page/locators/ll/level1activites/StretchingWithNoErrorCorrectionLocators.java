package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface StretchingWithNoErrorCorrectionLocators {
	
	By STEP1_HEADER = By.xpath("//span[contains(text(),'Step 1')]");
	By STEP2_HEADER = By.xpath("//span[contains(text(),'Step 2')]");
	By STEP3_HEADER = By.xpath("//span[contains(text(),'Step 3')]");

	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	//Step 1 Locators
	By STRETCHING_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.Stretching.contentContainer')]");
	By SYLLABLE_TILES = By.xpath("//div[contains(@class,'Cambium.UI.Draggable.originator')][@value='']/div");
	
	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");
	
	By INCORRECT_CONTAINER_COLOR = By.xpath("//div[contains(@class,'Cambium.Bundles.Stretching.incorrectBGColor')]");
	By CORRECT_CONTAINER_COLOR = By.xpath("//div[contains(@class,'Cambium.Bundles.Stretching.correctBGColor')]");

	//Step 2 Locators
	By SYLLABLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.group')]/ul/li");
	
	By SYLLABLE_CONTAINER = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.group')]/ul/li%s/div/div[2]");
	By LETTER_BOX_PHONEME = By.className("Cambium.UI.LetterBox.phoneme");
	
	By CONSONANT_TILE = By.xpath("//div[@class='Cambium.UI.Draggable.dragger'][contains(.,'c')]");
	By VOWEL_TILE = By.xpath("//div[@class='Cambium.UI.Draggable.dragger'][contains(.,'v')]");
	
	//Step 3 Locators
	By LETTER_TILES_1 = By.xpath(
			"//div[@class='Cambium.Bundles.Stretching.choicesContainer']/div[contains(@class,' Cambium.UI.Draggable.originator')][1]/div");
	By LETTER_TILES_2 = By.xpath(
			"//div[@class='Cambium.Bundles.Stretching.choicesContainer']/div[contains(@class,' Cambium.UI.Draggable.originator')][2]/div");
	
	By CROSS_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.wrong')]");
	By TICK_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.right')]");
	
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	By PROGRESS_STEP_COUNT= By.xpath("//div[contains(@class,'progressDotRed')]");
}
