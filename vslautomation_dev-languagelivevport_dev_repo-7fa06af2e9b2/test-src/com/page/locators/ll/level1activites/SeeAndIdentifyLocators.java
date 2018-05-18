package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface SeeAndIdentifyLocators {
	
	By ACTIVITY_CONTAINER = By.className("Cambium.Bundles.SeeAndIdentify.letterContainer");
	
	By RADIO_BTN_1 = By.xpath("//div/div[1]/button[contains(@class,'Cambium.Bundles.SeeAndIdentify.verify cambium_ui_buttons_radio_button')]");
	By RADIO_BTN_2 = By.xpath("//div/div[2]/button[contains(@class,'Cambium.Bundles.SeeAndIdentify.verify cambium_ui_buttons_radio_button')]");
	
	By CHECK_MARK= By.xpath("//div/span[contains(@class,'Cambium.UI.StateBox.right')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");

}
