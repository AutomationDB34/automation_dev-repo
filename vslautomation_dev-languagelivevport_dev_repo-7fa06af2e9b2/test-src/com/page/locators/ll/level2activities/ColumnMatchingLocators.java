package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface ColumnMatchingLocators {
	
	By COLUMN_MATCHING_CONTAINER = By.xpath("//table[@class='Cambium.Bundles.ColumnMatching.twoCategory']/tbody");
	
	By LEFT_COLUMN_COUNT = By.xpath("//td[@class='Cambium.Bundles.ColumnMatching.left']/div/table/tbody/tr");
	By RIGHT_COLUMN_COUNT = By.xpath("//td[@class='Cambium.Bundles.ColumnMatching.right']/div/table/tbody/tr");
	
	By LEFT_COLUMN_TILES = By.xpath("//td[@class='Cambium.Bundles.ColumnMatching.left']/div/table/tbody/tr//span[contains(text(),'%s')]");
	By RIGHT_COLUMN_TILES = By.xpath("//td[@class='Cambium.Bundles.ColumnMatching.right']/div/table/tbody/tr//span[contains(text(),'%s')]");
	
	
	By INCORRECT_MATCH = By.xpath("//table[@class='Cambium.Bundles.ColumnMatching.twoCategory']/tbody/tr[2]//div[contains(@class,'Cambium.UI.Draggable2.incorrect')]");
	By CORRECT_MATCH = By.xpath("//table[@class='Cambium.Bundles.ColumnMatching.twoCategory']/tbody/tr[2]//div[contains(@class,'Cambium.UI.Draggable2.correct')]");
	
	By RESULTS_COLUMN = By.xpath("//td[@class='Cambium.Bundles.ColumnMatching.results']//span[contains(text(),'%s')]");
	
	By SUMMARY_HEADER = By.xpath("//div[contains(text(),'Column Matching: Results')]");
	By SUMMARY_CORRECT_COUNT = By.xpath("//span[contains(@class,'Cambium.Bundles.ColumnMatching.Summary.right')]");
	By SUMMARY_INCORRECT_COUNT = By.xpath("//span[contains(@class,'Cambium.Bundles.ColumnMatching.Summary.wrong')]");
	
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");

}
