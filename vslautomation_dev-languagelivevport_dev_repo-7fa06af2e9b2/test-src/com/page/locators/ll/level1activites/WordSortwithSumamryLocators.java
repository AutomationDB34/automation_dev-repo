package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface WordSortwithSumamryLocators {
	
	By TILE_TO_DRAG = By.xpath("//span[contains(@class,'Cambium.UI.Draggable2.originator')]//span[@class='Cambium.UI.Draggable2.dragger']/span");
	By AUDIO_ICON = By.xpath("//button[contains(@class,'Cambium.Bundles.Sorting.WordSort.sortableAudio')]");
	
	By COLUMN_HEADER = By.xpath("//td[contains(text(),'Singular Noun')]");
	
	By SINGULAR_COLUMN = By.xpath("//div[@class='Cambium.Bundles.Sorting.WordSort.scrollableContainer'][@data-index=0]//td[@class='Cambium.Bundles.Sorting.WordSort.dataContainer']");
	By PLURAL_COLUMN = By.xpath("//div[@class='Cambium.Bundles.Sorting.WordSort.scrollableContainer'][@data-index=1]//td[@class='Cambium.Bundles.Sorting.WordSort.dataContainer']");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
			
	//Summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Sort')]");
	
	By WRONG_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.Sorting.WordSort.wrong')]");
	By RIGHT_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.Sorting.WordSort.right')]");
	
	By SUMMARY_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_QUESTIONS_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By SUMMARY_CONTINUE_BTN = By.xpath(" //button[contains(text(),'Continue')]");
	

}
