package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface IdentifyWordEndingSoundLocators {
	
	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.IdentifyWordEndingSound.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	By RADIO_BTN_1= By.xpath("//div[@class='Cambium.Bundles.IdentifyWordEndingSound.choicesContainer']/div[1]/div[5]/button");
	By RADIO_BTN_2= By.xpath("//div[@class='Cambium.Bundles.IdentifyWordEndingSound.choicesContainer']/div[2]/div[5]/button");

	
	By CORRECT_WORD = By.xpath("//span[contains(@class,'Cambium.Bundles.IdentifyWordEndingSound.correct')]");
	By TICK_MARK = By.xpath("//div[contains(@class,'cambium_ui_state_box Cambium.UI.StateBox.right')]");
			
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	

}
