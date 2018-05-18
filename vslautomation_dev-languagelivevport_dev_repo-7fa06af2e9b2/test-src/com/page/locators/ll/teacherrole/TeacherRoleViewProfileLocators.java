package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherRoleViewProfileLocators {

	By ABOUT_ME_TAB = By.name("UserProfile");
	By ABOUT_ME_TAB_SELECTED = By.xpath("//span[@name='UserProfile' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By ABOUT_ME_TAB_ICON = By.xpath("//span[@name='UserProfile']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_about']");
	By ABOUT_ME_CONTENT_SECTION = By.className("Cambium.App.UserProfile.AboutMe.content");
	
	By ACHIEVEMENTS_TAB = By.name("Achievements");
	By ACHIEVEMENTS_TAB_ICON = By.xpath("//span[@name='Achievements']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_award']");
	
	By CLASSMATES_TAB = By.name("Classmates");
	By CLASSMATES_TAB_ICON = By.xpath("//span[@name='Classmates']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_group']");
	
	By AVATAR_EDITOR_TAB = By.name("AvatarEditor");
	By AVATAR_EDITOR_TAB_ICON = By.xpath("//span[@name='AvatarEditor']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_person']");
}
