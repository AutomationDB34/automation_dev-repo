package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherRoleDictionaryLocators {

	By DICTIONARYPOPUP_CONTENT = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.DashboardMenu.Dictionary.content')]");
	
	By DICTIONARYPOPUP_FIND_BTN = By.xpath("//span[contains(@class,'Cambium.LanguageLive.UI.DictionaryMenu.Dictionary.find')][text()='Find']");
}
