package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface CompoundWordsLocators {
	
	By COMPOUNDWORDS_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.CompoundWords.contentContainer')]");
	By MERGED_WORD = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.mergedStep1')]");
		
	
	By ANSWER_AREA = By.xpath("//div[contains(@class,'Cambium.Bundles.CompoundWords.answer')]/div");
	By ANSWER_TILE = By.xpath("//div[@class='Cambium.Bundles.CompoundWords.choicesContainer']/div[1]/div");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	

}
