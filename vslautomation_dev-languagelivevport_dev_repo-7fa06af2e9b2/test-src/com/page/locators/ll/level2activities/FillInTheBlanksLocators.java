package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface FillInTheBlanksLocators {

	By ANSWER_BLANKS = By.xpath("//div[contains(@class,'Cambium.Bundles.FillInTheBlank.wordGroup')]");

	By COMPLETE_TILE = By.xpath(
			"//div[contains(@class,'Cambium.Bundles.FillInTheBlank.complete')][%s]//div[contains(@class,'Cambium.Bundles.FillInTheBlank.incorrect')]");

	By ANSWER_TILE = By.xpath(
			"//div[contains(@class,'Cambium.Bundles.FillInTheBlank.target')]//div[contains(@class,'Cambium.Bundles.FillInTheBlank.top')]");

	By CORRECT_ANSWER = By.xpath("//div[contains(@class,'Cambium.Bundles.FillInTheBlank.correct')]");
	By INCORRECT_ANSWER = By.xpath("//div[contains(@class,'Cambium.Bundles.FillInTheBlank.incorrect')]");

}
