package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface RhymingAdvancedLocators {

	By LEFT_DISABLED_CONTAINER = By.xpath(
			"//div[contains(@class,'Cambium.Bundles.RhymingAdvanced.left')][contains(@class,'Cambium.Bundles.RhymingAdvanced.disabled')]");
	By RIGHT_DISABLED_CONTAINER = By.xpath(
			"//div[contains(@class,'Cambium.Bundles.Rhyming.right')][contains(@class,'Cambium.Bundles.Rhyming.disabled')]");

	By LEFT_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.RhymingAdvanced.left')]");
	By RIGHT_CONTAINER = By.xpath("//div[contains(@class,'Cambium.Bundles.RhymingAdvanced.right')]");
	
	By MUSIC_NOTE = By.className("Cambium.Bundles.RhymingAdvanced.music_note");

	By ANSWER = By
			.xpath("//div[contains(@class,'Cambium.Bundles.RhymingAdvanced.elementBox')]/span[contains(text(),%s)]");

	By TILE_1 = By.xpath(
			"//div[@class='Cambium.Bundles.RhymingAdvanced.row'][1]/div[contains(@class,'Cambium.Bundles.RhymingAdvanced.elementBox')][1]");
	By TILE_2 = By.xpath(
			"//div[@class='Cambium.Bundles.RhymingAdvanced.row'][1]/div[contains(@class,'Cambium.Bundles.RhymingAdvanced.elementBox')][2]");

	By INCORRECT_MATCH = By.xpath(
			"//div[contains(@class,'Cambium.Bundles.RhymingAdvanced.music_note_container Cambium.Bundles.RhymingAdvanced.incorrect')]");
	By CORRECT_MATCH = By.xpath(
			"//div[contains(@class,'Cambium.Bundles.RhymingAdvanced.music_note_container Cambium.Bundles.RhymingAdvanced.correct')]");

	By BUNDLE_COUNT = By.xpath(" //div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");

	By NEXT_BTN = By.xpath("//button[contains(text(),'Next')]");

	// Summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Rhyming Advanced')]");

	By CORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.RhymingAdvanced.Summary.right')]");
	By INCORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.RhymingAdvanced.Summary.wrong')]");

	By SUMMARY_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_QUESTIONS_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");

	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");

}
