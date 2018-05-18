package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface ClosedSyllableLocators {
	
	By TILE = By.xpath("//span[contains(@class,'Cambium.Bundles.ClosedSyllable.contentContainer')]/span[1]");
	
	By INCORRECT_ANSWER = By.xpath("//span[contains(@class,'Cambium.UI.Draggable2.incorrect')]");
	By CORRECT_ANSWER = By.xpath("//span[contains(@class,'Cambium.UI.Draggable2.correct')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	By CONTINUE_BUTTON = By.xpath(".//button[contains(text(),'Continue')]");
			

}
