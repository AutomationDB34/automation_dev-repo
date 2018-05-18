package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface ShuffleLocators {

	By SUFFLE_CONTENT_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.Shuffle.mainContainer')]");

	By TARGET_TILE = By.xpath("//div[contains(@class,'Cambium.Bundles.Shuffle.target')]/div");
	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");

	By SHUFFLE_TILES_ROWS = By.xpath(
			"//div[@class='Cambium.Bundles.Shuffle.choicesContainer']//div[@class='Cambium.Bundles.Shuffle.group']");
	By SHUFFLE_TILES_IN_A_ROW = By.xpath(
			"//div[@class='Cambium.Bundles.Shuffle.choicesContainer']//div[@class='Cambium.Bundles.Shuffle.group']%s/ul/li");

	By SHUFFLE_ANSWER_TILES = By.xpath(
			"//div[@class='Cambium.Bundles.Shuffle.choicesContainer']//div[@class='Cambium.Bundles.Shuffle.group']%s/ul/li%s/div/div");
	By SHUFFLE_ANSWER_TILES_AFTER_ANSWERING = By.xpath(
			"//div[contains(@class,'Cambium.Bundles.Shuffle.mainContainer')]//div[@class='Cambium.Bundles.Shuffle.group']%s/ul/li%s//div[contains(@class,'Cambium.Bundles.Shuffle.remover')]");

	By ANSWER_TILES = By.xpath("//div[contains(@class,'Cambium.UI.Draggable.originator')]");

	
	By INCORRECT_COLOR= By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.incorrect')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	//Summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Shuffle')]");
	By SUMMARY_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_QUES_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
}
