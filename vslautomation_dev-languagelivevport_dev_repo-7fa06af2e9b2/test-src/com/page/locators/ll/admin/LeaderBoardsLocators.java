package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface LeaderBoardsLocators {
	
	By LEADERBOARDSTAB_SELECTED = By.xpath("//span[@name='Leaderboards' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By LEADERBOARDS_FOOTER_SECTION = By.className("Cambium.App.Leaderboards.footer");
	
	By LEADERBOARDS_PAGE=By.xpath("//td[@class='Cambium.App.Leaderboards.col Cambium.App.Leaderboards.title' and text()='Leaderboards']");
	By CLASSSELECTOR_DRPDWN=By.xpath("//table[@class='Cambium.LanguageLive.UI.SelectMenu.ClassSelector.menuTable']//td");
	By CLASSSNAMEIN_CLASSSELECTOR_DRPDWN=By.xpath("//td[contains(@class,'Cambium.UI.Menu.item Cambium.LanguageLive.UI.SelectMenu.ClassSelector.option') and text()='%s']");
	
	By COURSEPOINTS_TAB=By.name("coursePoints");
	

	//Locators in Course Points tab
	By COURSEPOINTS_SUBTABS=By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.OptionPill.option') ]/span[text()='%s']");
	By COURSEPOINTS_HEADING=By.xpath("//span[@class='Cambium.App.Leaderboards.title']");
	By STUDENT_COURSEPOINTSCOUNT_RANKTABLE=By.xpath("(//td[.//div[@class='Cambium.App.Leaderboards.lastName' and text()='%s']])[3]//following-sibling::td/div");
	
	
	By YEARSUBTAB_HEADING=By.xpath("//span[@class='Cambium.App.Leaderboards.other Cambium.App.Leaderboards.hidden' and text()='for the school year']");
	
	//Loators in Acheivements
	By ACHIEVEMENTS_TAB=By.name("achievements");
	By ACHEIVEMENTS_SUBTABS=By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.OptionPill.option') ]/span[text()='%s']");
	By ACHIEVEMENTS_HEADING=By.xpath("//span[@class='Cambium.App.Leaderboards.title']");
	By STUDENT_ACHEIVEMENTSCOUNT_RANKTABLE=By.xpath("(//td[.//div[@class='Cambium.App.Leaderboards.lastName' and text()='%s']])[3]//following-sibling::td/div");

}