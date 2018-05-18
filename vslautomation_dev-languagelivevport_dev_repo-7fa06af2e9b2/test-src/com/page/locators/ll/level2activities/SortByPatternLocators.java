package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface SortByPatternLocators {
	
	By CLOSED_COLUMN = By.xpath("//div[@class='Cambium.Bundles.Sorting.SortByPattern.scrollableContainer'][@data-index='0']");
	By OTHER_COLUMN = By.xpath("//div[@class='Cambium.Bundles.Sorting.SortByPattern.scrollableContainer'][@data-index='1']");

	By AUDIO_ICON = By.xpath("//button[contains(@class,'Cambium.Bundles.Sorting.SortByPattern.sortableAudio')]");
	
	By DRAGGABLE_TILES_COUNT = By.xpath("//span[contains(@class,'Cambium.Bundles.Sorting.SortByPattern.sortableList')]/ul/li");
	By DRAGGABLE_TILES = By.xpath("//span[contains(@class,'Cambium.Bundles.Sorting.SortByPattern.sortableList')]/ul/li[%s]/div/div");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	//Summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Sort')]");
	By CORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.correct')]");
	By INCORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.incorrect')]");
	
	By SUMMARY_HEADER_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_HEADER_QUES_COUNT  =By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
}
