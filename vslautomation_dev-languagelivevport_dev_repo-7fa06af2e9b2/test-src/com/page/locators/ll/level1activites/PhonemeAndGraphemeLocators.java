package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface PhonemeAndGraphemeLocators{

	By REPLAY_VIDEO = By.xpath("//div[contains(text(),'Replay Video')]");
	By NEXT_BTN = By.xpath("//button[contains(text(),'Next')]");

	By PHONEMEINTRO_FRONTAL_IMG = By
			.xpath("//div[contains(@class,'Cambium.Bundles.PhonemeIntroduction.imageFrontal')]");
	By PHONEMEINTRO_SAGGITAL_IMG = By
			.xpath("//div[contains(@class,'Cambium.Bundles.PhonemeIntroduction.imageSaggital')]");

	By PHONEMEINTRO_FRONTAL_REPLAY = By
			.xpath("//div[contains(@class,'Cambium.Bundles.PhonemeIntroduction.replayFrontal')]");
	By PHONEMEINTRO_SAGGITAL_REPLAY = By
			.xpath("//div[contains(@class,'Cambium.Bundles.PhonemeIntroduction.replaySaggital')]");

	
	By ACTIVE_LETTER = By.className("Cambium.UI.Alphabet.active");
	By LETTER_GROUP = By.xpath("//span[@class='Cambium.Bundles.GraphemeIntroduction.grapheme']");
	
	By SPELLING_STEP = By.xpath("//div[@class='Cambium.Bundles.PhonemeAndGrapheme.spelling']");
	
	
}
