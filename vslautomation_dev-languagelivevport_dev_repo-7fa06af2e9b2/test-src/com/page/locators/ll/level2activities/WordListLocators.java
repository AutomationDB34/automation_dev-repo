package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface WordListLocators {
	
	By WORD_LIST_HEADER = By.xpath("//div[contains(text(),'Read through the words below.')]");
	By WORD_LIST_CONTAINER = By.xpath("//td[@class='Cambium.Bundles.WordList.details'][1]");
	
	By CONTINE_BTN = By.xpath("//button[contains(text(),'Continue')]");
}
