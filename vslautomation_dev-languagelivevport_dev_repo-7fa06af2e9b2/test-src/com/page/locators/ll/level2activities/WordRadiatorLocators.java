package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface WordRadiatorLocators {

	By WORD_RADIATOR_HUB = By.xpath("//div[contains(@class,'Cambium.Bundles.WordRadiator.mainHub')]");

	By WORDRADIATOR_WORDS = By.xpath(
			"//div[contains(@class,'Cambium.Bundles.WordRadiator.word')][%s]//span[not(contains(@class,'Cambium.Bundles.WordRadiator.remove'))]/span/span");

	By CORRECT_ANSWER_DISPALYED = By.xpath(
			"//div[contains(@class,'Cambium.Bundles.WordRadiator.word')][%s]//span[(contains(@class,'Cambium.UI.Draggable2.Cambium.Bundles.WordRadiator.found'))]/span/span");

	By INCORRECT_ANSWER = By.xpath("//span[contains(@class,'Cambium.UI.Draggable2.incorrect')]");
	By CORRECT_ANSWER = By.xpath("//span[contains(@class,'Cambium.UI.Draggable2.correct')]");

}
