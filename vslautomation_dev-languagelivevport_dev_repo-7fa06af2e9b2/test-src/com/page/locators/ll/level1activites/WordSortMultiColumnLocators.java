package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface WordSortMultiColumnLocators {
	
	By AUDIO_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Sorting.WordSortMultiColumn.sortableAudio')]");
	By DRAGGABLE_TILE = By.xpath("//span[@class='Cambium.UI.Draggable2.txt']");
	By DRAGGABLE_COLUMN_FF = By.xpath("//div[@data-index='0']//td[@class='Cambium.Bundles.Sorting.WordSortMultiColumn.dataContainer']");
	By DRAGGABLE_COLUMN_LL = By.xpath("//div[@data-index='1']//td[@class='Cambium.Bundles.Sorting.WordSortMultiColumn.dataContainer']");
	By DRAGGABLE_COLUMN_SS = By.xpath("//div[@data-index='2']//td[@class='Cambium.Bundles.Sorting.WordSortMultiColumn.dataContainer']");
	By DRAGGABLE_COLUMN_ZZ = By.xpath("//div[@data-index='3']//td[@class='Cambium.Bundles.Sorting.WordSortMultiColumn.dataContainer']");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	//Summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Sort')]");
	By CORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.Sorting.WordSortMultiColumn.right')]");
	By INCORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.Sorting.WordSortMultiColumn.wrong')]");
	
	By SUMMARY_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_QUESTIONS_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
}
