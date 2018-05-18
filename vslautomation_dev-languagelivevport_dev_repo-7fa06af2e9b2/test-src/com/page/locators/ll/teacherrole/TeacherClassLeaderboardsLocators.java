package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherClassLeaderboardsLocators {


	By LEADERBOARDSTAB_SELECTED = By.xpath("//span[@name='Leaderboards' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By LEADERBOARDS_FOOTER_SECTION = By.className("Cambium.App.Leaderboards.footer");
	
	By LEADERBOARDS_LEVEL_DRP = By.xpath(".//td[contains(@class,'LevelSelector')]");
	
	By LEADERBOARDSDRP_LEVEL_OPTION = By.xpath(".//td[contains(text(),'%s')]");
	
	By THIS_WEEK_FILTER = By.xpath("//span[contains(text(),'This Week')]");
	By LAST_WEEK_FILTER = By.xpath("//span[contains(text(),'Last Week')]");
	By SCHOOL_YEAR_FILTER = By.xpath("//span[contains(text(),'Year')]");
	By SELECTED_TAB = By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.OptionPill.selected')]");
	By ACHIEVEMENTS_TAB = By.name("achievements");
	
	
	
	
	
}
