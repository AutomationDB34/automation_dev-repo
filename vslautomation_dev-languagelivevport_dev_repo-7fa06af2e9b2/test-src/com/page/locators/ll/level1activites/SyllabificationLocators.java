package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface SyllabificationLocators {
	
	
	By AUDIO_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Syllabification.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	By ANSWER_CONTAINER = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.droppable')]");
	
	By ANSWER_TILES = By.xpath("//div[contains(@class,'Cambium.UI.Draggable.originator')]%s/div");
	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");
	
	By CROSS_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.wrong')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	//Summary Page Locators
	
	By TEMP_CONTAINER= By.xpath("//div[@class='Cambium.Bundles.Syllabification.tempContainer']");
	By SUMMARY_PAGE = By.xpath("//td[contains(text(),'Correct')]");
	
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Syllabification')]");
	By SUMMARY_CORRECT_COUNT = By.xpath("//div[@class='Cambium.UI.SummaryHeading.infoBox Cambium.UI.SummaryHeading.scoreAsNumber']/div[1]");
	By SUMMARY_NUMBER_OF_QUES = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	
	By INCORRECT_BUNDLES= By.xpath("//div[contains(@class,'Cambium.Bundles.Syllabification.Summary.wrong')]");
	By CORRECT_BUNDLES = By.xpath("//div[contains(@class,'Cambium.Bundles.Syllabification.Summary.right')]");
	
	By CONTINUE_SUMMARY = By.xpath("//button[contains(text(),'Continue')]");
	
	
	
	
}
