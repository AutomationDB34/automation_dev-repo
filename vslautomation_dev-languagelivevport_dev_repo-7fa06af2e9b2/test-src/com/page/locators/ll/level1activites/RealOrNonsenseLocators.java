package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface RealOrNonsenseLocators {

	By TILE = By.xpath("//span[@class='Cambium.UI.Draggable2.txt']");
	By AUDIO_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Sorting.WordSort.sortableAudio')]");

	By CORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.Sorting.WordSort.right')]");
	By INCORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.Sorting.WordSort.wrong')]");

	By REAL_COLUMN = By.xpath("//div[@class='Cambium.Bundles.Sorting.WordSort.scrollableContainer'][@data-index='0']");
	By NONSENSE_COLUMN = By.xpath("//div[@class='Cambium.Bundles.Sorting.WordSort.scrollableContainer'][@data-index='1']");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	By SUMMARY_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_NO_OF_QUES = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By SUMMARY_CONTINUE_BTN= By.xpath("//button[contains(@class,'Cambium.Bundles.Sorting.WordSort.continue')]");
	

}
