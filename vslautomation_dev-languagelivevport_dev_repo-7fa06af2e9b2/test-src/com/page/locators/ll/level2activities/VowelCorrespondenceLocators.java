package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface VowelCorrespondenceLocators {

	By AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.VowelCorrespondence.audio')]");
	By AUDIO_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton.active_pausable')]");
	
	By DRAGGABLE_TILE = By.xpath("//div[@class='Cambium.Bundles.VowelCorrespondence.draggableContainer']/div[contains(@class,'Cambium.Bundles.VowelCorrespondence.draggable')]/div");
	By DRAGGABLE_AREA_A = By.xpath("//div[contains(@class,'Cambium.Bundles.VowelCorrespondence.scrollable')][@data-index='0']");
	By DRAGGABLE_AREA_E = By.xpath("//div[contains(@class,'Cambium.Bundles.VowelCorrespondence.scrollable')][@data-index='1']");
	By DRAGGABLE_AREA_I = By.xpath("//div[contains(@class,'Cambium.Bundles.VowelCorrespondence.scrollable')][@data-index='2']");
	By DRAGGABLE_AREA_O = By.xpath("//div[contains(@class,'Cambium.Bundles.VowelCorrespondence.scrollable')][@data-index='3']");
	By DRAGGABLE_AREA_U = By.xpath("//div[contains(@class,'Cambium.Bundles.VowelCorrespondence.scrollable')][@data-index='4']");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
}
