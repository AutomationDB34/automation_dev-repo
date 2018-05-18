package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface SyllableSortLocators {
	
	By SORTABLE_COLUMN = By.xpath("//div[@class='Cambium.Bundles.Sorting.SyllableSort.scrollableContainer'][@data-index='1']");
	
	By SORTABLE_TILE = By.xpath("//span[@class='Cambium.UI.Draggable2.dragger']/span");
	
	By AUDIO_ICON = By.xpath("//button[contains(@class,'Cambium.Bundles.Sorting.SyllableSort.sortableAudio')]");
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
}
