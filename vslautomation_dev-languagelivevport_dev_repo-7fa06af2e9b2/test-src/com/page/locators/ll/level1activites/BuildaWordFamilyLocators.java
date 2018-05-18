package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface BuildaWordFamilyLocators {
	
	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.BuildAWordFamily.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");

	
	By ASNWER_CONTAINER = By.className("Cambium.UI.LetterBox.dragger");
	
	By ANSWER_CHOICES_1 = By.xpath("//div[contains(@class,'Cambium.UI.Draggable.originator ')][1]/div");
	By ANSWER_CHOICES_2 = By.xpath("//div[contains(@class,'Cambium.UI.Draggable.originator ')][2]/div");
	
	By CROSS_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.wrong')]");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
}
