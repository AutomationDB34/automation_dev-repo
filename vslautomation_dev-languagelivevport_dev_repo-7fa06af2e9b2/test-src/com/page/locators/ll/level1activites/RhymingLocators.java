package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface RhymingLocators {
	
	By LEFT_DISABLED_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.Rhyming.left')][contains(@class,'Cambium.Bundles.Rhyming.disabled')]");
	By RIGHT_DISABLED_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.Rhyming.right')][contains(@class,'Cambium.Bundles.Rhyming.disabled')]");
	
	
	By LEFT_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.Rhyming.left')]");
	By RIGHT_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.Rhyming.right')]");

	By ELEMENT_BOX = By.xpath("//div[contains(@class,'Cambium.Bundles.Rhyming.set')]%s");
	By RHYMING_WORDS= By.xpath("//div[contains(@class,'Cambium.Bundles.Rhyming.choice')]");
	
	By WORD_TILES= By.xpath("//div[@class='Cambium.Bundles.Rhyming.sm_card_container']/div[@class='Cambium.Bundles.Rhyming.row']%s/div%s/span");
	
	By ANSWER = By.xpath("//div[contains(@class,'Cambium.Bundles.Rhyming.elementBox')]/span[contains(text(),%s)]");
	

	By CORRECT_MATCH= By.xpath("//div[contains(@class,'Cambium.Bundles.Rhyming.music_note_container Cambium.Bundles.Rhyming.correct')]");
	
	By NEXT_BTN = By.xpath("//button[contains(@class,'Cambium.UI.ActionButton.NextButton')]");
	By SUMMARY_PAGE = By.className("Cambium.Bundles.RhymingSummary.summary");
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.RhymingSummary.continue')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
			
	
	
	
}
