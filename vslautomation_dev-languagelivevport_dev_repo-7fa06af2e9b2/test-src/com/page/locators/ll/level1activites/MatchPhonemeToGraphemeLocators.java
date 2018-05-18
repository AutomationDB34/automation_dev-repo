package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface MatchPhonemeToGraphemeLocators {
	
	By ACTIVITY_CONTAINER = By.className("Cambium.Bundles.MatchPhonemeToGrapheme.audioContainer");
	By ANSWER_TILE= By.xpath("//span[contains(@class,'Cambium.Bundles.MatchPhonemeToGrapheme.contentContainer')]/span");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	By MARK_CONTAINER = By.xpath("//div[contains(@class,'cambium_ui_state_box Cambium.UI.StateBox.right')]");
	

}
