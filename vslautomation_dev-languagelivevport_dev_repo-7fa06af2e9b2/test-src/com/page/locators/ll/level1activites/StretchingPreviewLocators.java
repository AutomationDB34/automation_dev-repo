package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface StretchingPreviewLocators {
	
	By STEP1_HEADER = By.xpath("//div[contains(@class,'Cambium.Bundles.StretchingPreview.step cambium_ui_step_bar')]/span[contains(text(),'Step 1')]");
	By STEP2_HEADER = By.xpath("//div[contains(@class,'Cambium.Bundles.StretchingPreview.step cambium_ui_step_bar')]/span[contains(text(),'Step 2')]");
	
	By AUDIO_BTN = By.xpath("  //button[contains(@class,'Cambium.Bundles.StretchingPreview.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	By SYLLABLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.group')]/ul/li");
	
	By SYLLABLE_CONTAINER = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.group')]/ul/li%s/div/div[2]");
	By LETTER_BOX_PHONEME=By.className("Cambium.UI.LetterBox.phoneme");
	
	By STEP2_WORNG_MARK_CONTAINER = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.wrong')]");
	By STEP2_RIGHT_MARK_CONTAINER = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.right')]");
	
	By CONSONANT_TILE = By.xpath("//div[@class='Cambium.UI.Draggable.dragger'][contains(.,'c')]");
	By VOWEL_TILE = By.xpath("//div[@class='Cambium.UI.Draggable.dragger'][contains(.,'v')]");
	
	By LETTER_TILES_M = By.xpath("//div[@class='Cambium.Bundles.StretchingPreview.choicesContainer']/div[contains(@class,' Cambium.UI.Draggable.originator')][1]/div");
	By LETTER_TILES_A = By.xpath("//div[@class='Cambium.Bundles.StretchingPreview.choicesContainer']/div[contains(@class,' Cambium.UI.Draggable.originator')][4]/div");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	
	//Summary Locators
	
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Phoneme/Grapheme Mapping')]");
	By SUMMARY_LETTERS_COUNT= By.xpath("//div[@class='Cambium.UI.LetterBox.group']/ul/li%s/div");
	
	By CORRECT_LETTER = By.xpath("//div[@class='Cambium.UI.LetterBox.group']/ul/li%s/div[contains(@class,'Cambium.UI.LetterBox.correct')]");
	
	By CORRECT_COUNT_IN_SUMMARY = By.xpath("//div[@class='Cambium.UI.SummaryHeading.infoBox Cambium.UI.SummaryHeading.scoreAsNumber']/div[1]");
	
	By CONTINUE_SUMMARY = By.xpath("//button[contains(text(),'Continue')]");
	
	
	
}