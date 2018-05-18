package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface SortByFunctionLocators {

	By AUDIO_ICON = By.xpath("//button[contains(@class,'Cambium.Bundles.Sorting.SortByFunction.sortableAudio')]");
	By DRAGGABLE_WORD_TILE = By.xpath("//span[contains(@class,'Cambium.Bundles.Sorting.SortByFunction.word')]/span/span");
	
	By NOUN_COLUMN = By.xpath("//div[@class='Cambium.Bundles.Sorting.SortByFunction.scrollableContainer'][@data-index='0']");
	By VERB_COLUMN = By.xpath("//div[@class='Cambium.Bundles.Sorting.SortByFunction.scrollableContainer'][@data-index='1']");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	//summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Check Understanding')]");
	By CORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.Sorting.SortByFunction.Summary.right')]");
	By INCORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.Sorting.SortByFunction.Summary.wrong')]");
	
	By SUMMARY_HEADER_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_HEADER_QUES_COUNT  =By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
}
