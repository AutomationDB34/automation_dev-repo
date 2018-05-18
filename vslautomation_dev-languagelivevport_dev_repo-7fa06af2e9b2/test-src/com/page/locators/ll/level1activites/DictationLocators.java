package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface DictationLocators {

	By STEP1_HEADER = By.xpath("//span[contains(text(),'Step 1')]");
	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.Dictation.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	By INPUT_TEXT_BOX = By.xpath("//div[contains(@id,'Cambium.Bundles.Dictation')]%s//input[@class='Cambium.UI.LetterBox.input']");
	
	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");
	
	By CROSS_MARK= By.xpath("//span[contains(@class,'Cambium.UI.StateBox.wrong')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	By NEXT_BTN = By.xpath("//button[contains(text(),'Next')]");
	
}
