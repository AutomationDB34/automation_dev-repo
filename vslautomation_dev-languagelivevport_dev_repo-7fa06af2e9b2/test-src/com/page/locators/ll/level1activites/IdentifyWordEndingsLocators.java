package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface IdentifyWordEndingsLocators {
	
	By WORDENDING_CONTAINER = By.className("Cambium.Bundles.IdentifyWordEndings.wordEndingContainer");
	
	By RADIO_BTN_1 = By.xpath("//div[@class='Cambium.Bundles.IdentifyWordEndings.optionContainer'][1]//button[contains(@class,'cambium_ui_buttons_radio_button')]");
	By RADIO_BTN_2 = By.xpath("//div[@class='Cambium.Bundles.IdentifyWordEndings.optionContainer'][2]//button[contains(@class,'cambium_ui_buttons_radio_button')]");
	
	By TICK_MARK = By.xpath("//span[contains(@class,'Cambium.UI.StateBox.right')]");
	By SOUND_LABEL = By.xpath("//span[contains(@class,'Cambium.Bundles.IdentifyWordEndings.soundLabel')]");
	
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	

}
