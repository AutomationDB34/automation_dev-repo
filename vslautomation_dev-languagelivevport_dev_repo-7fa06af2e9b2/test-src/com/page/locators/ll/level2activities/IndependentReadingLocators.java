package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface IndependentReadingLocators {
	
	By INVESTIGATE_THE_PASSAGE_POPUP = By.xpath("//span[contains(text(),'Investigate the passage.')]");
	By START_BTN = By.xpath("//button[contains(text(),'Start')]");
	By PASSAGE_TITLE = By.xpath("//div[@class='Cambium.Bundles.IndependentReading.Reading.headerContainer']/div");
	By CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
	By READ_THE_TIMED_PASSAGE_POPUP= By.xpath("//span[contains(text(),'Read the timed passage.')]");
	By STOP_TIMER_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.IndependentReading.Reading.step1')]");
	
	By LAST_WORD_POPUP = By.xpath("//span[contains(text(),'Click on the last word you read.')]");
	By LAST_WORD_SCREEN = By.xpath("//div[contains(text(),'Click on the last word you read.')]");
	By LAST_WORD = By.xpath("//div[contains(@class,'Cambium.Bundles.IndependentReading.Reading.passageContainer')]/div[20]");
	
	By TIMED_READING_RESULTS_PAGE = By.xpath("//div[contains(text(),'Timed Reading Results')]");
	By SCORE_PIN = By.xpath("//div[contains(@class,'Cambium.UI.Pins.WpmPin')]");
	By SCORE_BAR = By.xpath("//div[contains(@class,'Cambium.UI.Pinnable')]");
	
	

}
