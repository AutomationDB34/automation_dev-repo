package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface OverviewRecapLocators {

	By RECAP_HEADER = By.xpath("//div[contains(text(),'RECAP')]");
	By RECAP_CONTENT = By.xpath("//div[contains(text(),'In this lesson, we learned:')]");
	
	By CONTINE_BTN = By.xpath("//button[contains(text(),'Continue')]");
}
