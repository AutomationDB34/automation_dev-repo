package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherRoleToolsPageLocators {

	By TOOLS_TAB = By.xpath("//table[@class='Cambium.UI.Tabs.Tabs.organizer']//span[@name='Tools']");
	By REVIEW_TAB = By.name("Review");
	By REVIEWTAB_ICON = By.xpath("//span[@name='Review']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_checkRoundel']");
	By REVIEWTAB_SELECTED = By.xpath("//span[@name='Review' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By REVIEWSTAB_STUDENTS_TABLE = By.className("Cambium.App.Tools.Review.Reviews.table");
	
	By ASSIGNMENTS_TAB = By.name("Assignments");
	By ASSIGNMENTSTAB_ICON = By.xpath("//span[@name='Assignments']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_pencil']");
	
	By MODERATION_TAB = By.name("Moderation");
	By MODERATIONTAB_ICON = By.xpath("//span[@name='Moderation']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_personCheck']");
	
	By COURSERESOURCES_TAB = By.name("Resources");
	By COURSERESOURCESTAB_ICON = By.xpath("//span[@name='Resources']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_closedBook']");
	
	By CLASSSETTINGS_TAB = By.name("Settings");
	By CLASSSETTINGSTAB_ICON = By.xpath("//span[@name='Settings']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_mandelbrot']");
	
	By SOCIALSETTINGS_TAB = By.name("Social");
	By SOCIALSETTINGSTAB_ICON = By.xpath("//span[@name='Social']/span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_talkBubble']");
	
}
