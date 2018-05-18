package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface ListenAndAnswerYesNoLocators {
	
	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.ListenAndAnswerYesNo.audioButton')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	By YES_BTN = By.xpath("//button[contains(text(),'Yes')]");
	
	By TICK_MARK = By.xpath("//span[contains(@class,'Cambium.UI.StateBox.right')]");
	By CROSS_MARK = By.xpath("//span[contains(@class,'Cambium.UI.StateBox.wrong')]");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
}
