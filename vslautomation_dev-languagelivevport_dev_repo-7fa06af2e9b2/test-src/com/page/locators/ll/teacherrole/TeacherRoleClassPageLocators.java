package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherRoleClassPageLocators {

	By CLASSWALL_TAB = By.name("ClassWall");
	By CLASSWALLTAB_ICON = By.xpath("//span[@name='ClassWall']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_talkBubble']");
	By CLASSWALLTAB_SELECTED = By.xpath("//span[@name='ClassWall' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By CLASSWALLTAB_SECTION = By.className("Cambium.LanguageLive.UI.WallPost.AddNew.addNewContainer");
	
	By CLASSMATES_TAB = By.name("Classmates");
	By CLASSMATESTAB_ICON = By.xpath("//span[@name='Classmates']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_group']");
	
	By CLASSRESOURCES_TAB = By.name("Resources");
	By CLASSRESOURCES_ICON = By.xpath("//span[@name='Resources']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_closedBook']");
	
	By READINGSCAPE_TAB = By.name("ReadingScape");
	By READINGSCAPETAB_ICON = By.xpath("//span[@name='ReadingScape']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_openedBook']");
	
	By EBOOKS_TAB = By.name("eBooks");
	By EBOOKSTAB_ICON = By.xpath("//span[@name='eBooks']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_openedBook']");
	
	By LEADERBOARDS_TAB = By.name("Leaderboards");
	By LEADERBOARDSTAB_ICON = By.xpath("//span[@name='Leaderboards']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_podiums']");

	By ASSIGNMENT_FILTER = By.xpath("//td[@value='addAssignment']/span[text()='Assignment']");

}
