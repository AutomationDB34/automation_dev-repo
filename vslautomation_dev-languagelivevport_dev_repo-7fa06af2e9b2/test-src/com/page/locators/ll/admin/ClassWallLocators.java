package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface ClassWallLocators {

	//Locators in ALL tab
	public static By CLASSES_SUBHEADINGS=By.xpath("(.//table[@class='Cambium.UI.Tabs.Tabs.organizer'])[2]//span[@name='%s']");
	By CLASSWALL_HEADING=By.xpath("//td[@class='Cambium.App.ClassWall.col Cambium.App.ClassWall.title' and text()='Class Wall']");
	By CLASSSELECTOR_DRPDWN=By.xpath("//table[@class='Cambium.LanguageLive.UI.SelectMenu.ClassSelector.menuTable']//td");
	By CLASSSNAMEIN_CLASSSELECTOR_DRPDWN=By.xpath("//td[contains(@class,'Cambium.UI.Menu.item Cambium.LanguageLive.UI.SelectMenu.ClassSelector.option') and text()='%s']");
	By ALL_TAB=By.xpath("//td[@value='all']");
	By DESCRIPTION_TEXTAREA=By.xpath("//td[@class='Cambium.LanguageLive.UI.WallPost.AddNew.col1']/textarea");
	By SHAREINALLTAB_BTN=By.xpath("//button[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.shareStatus') and text()='Share']");
	By CLASSWALL_DESCRIPTION_POSTED=By.xpath("//span[@class='Cambium.LanguageLive.UI.WallPost.Status.description' and text()='%s']");
	By CLASSWALLPOSTS_PANES=By.className("Cambium.LanguageLive.UI.WallPost.Status.contents");
	
	//Locators in Assignment tab
	By ASSIGNMENTS_TAB=By.xpath("//td[@value='assignments']");
	By ASSIGNMENTS_POSTED_PANES=By.className("Cambium.LanguageLive.UI.WallPost.Assignment.contents");
	By ASSIGNMENT_HEADER=By.className("Cambium.LanguageLive.UI.WallPost.Assignment.header");
	By ASSIGNMENT_POSTED_USERNAME=By.xpath("//span[@class='Cambium.LanguageLive.UI.WallPost.Assignment.poster' and contains(text(),'%s')]");
	By ASSIGNMENT_TITLE_POSTED_SECTION = By.xpath("//span[@class='Cambium.LanguageLive.UI.WallPost.Assignment.title'][text()='%s']");

}
