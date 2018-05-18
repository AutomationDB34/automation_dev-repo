package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface SoundLibraryLocators {
	
	By NEW_SOUND_LIB_MODAL = By.xpath("//div[contains(@class,'Cambium.UI.SoundLibrary.NewPhonemesModal.closerX')]");
	
	By CONSONANTS_TAB=By.xpath("//div[contains(text(),'Consonants')]");
	By VOWELS_TAB = By.xpath("//div[contains(text(),'Vowels')]");
	
	By UNLOCKED_CCONSONANTS_CARDS = By.xpath("//div[contains(@class,'Cambium.UI.SoundLibrary.unlockedC')]");
	By UNLOCKED_VOWEL_CARDS = By.xpath("//div[contains(@class,'Cambium.UI.SoundLibrary.unlockedV')]");
	
	By SOUNDS_UNLOCKED= By.xpath("//span[contains(text(), 'Sounds:')]/following-sibling::span[contains(text(), 'Unlocked')]");
	By SPELLINGS_UNLOCKED = By.xpath("//span[contains(text(), 'Spellings:')]/following-sibling::span[contains(text(), 'Unlocked')]");
	
	

}
