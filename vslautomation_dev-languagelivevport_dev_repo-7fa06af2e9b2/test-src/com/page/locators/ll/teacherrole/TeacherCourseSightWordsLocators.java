package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherCourseSightWordsLocators {

	By SIGHTWORDS_IFRAME = By.className("Cambium.LanguageLive.SightWords.sightWordsGame");
	By SIGHTWORDS_USERLEVEL_ONE = By.xpath("//div[@class='Cambium.LanguageLive.SightWords.userLevel'][text()='Level 1']");
	By SIGHTWORDS_USERLEVEL_TWO = By.xpath("//div[@class='Cambium.LanguageLive.SightWords.userLevel'][text()='Level 2']");
	
	By SIGHTWORDS_USER_MENU_TABLE = By.className("Cambium.LanguageLive.UI.SightWordsMenu.menuTable");
	By SIGHTWORDS_USER_MENU = By.className("Cambium.LanguageLive.UI.SightWordsMenu.item");
	By SIGTHWORDS_SUB_MENU_COURSE = By.xpath("//td[@value='course']");
}
