package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface MemoryLocators {
	
	 By WORDS_BLUE_TILE = By.xpath("//td/div[contains(@class,'Cambium.Bundles.Memory.blue Cambium.Bundles.Memory.flip')]/div[contains(text(),'%s' )]");
	 By CONTRACTIONS_RED_TILE = By.xpath("//td/div[contains(@class,'Cambium.Bundles.Memory.red Cambium.Bundles.Memory.flip')]/div[contains(text(),'%s')]");
	 
	 By WORD_BANK_TILES = By.xpath("//div[@class='Cambium.Bundles.Memory.wordBank']//div/span[contains(text(),'%s')]");
	 

}
