package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface TeacherHomePageLocators {

	By TOOLS_TAB = By.xpath("//table[@class='Cambium.UI.Tabs.Tabs.organizer']//span[@name='Tools']");
	By TOOLSPAGEREVIEWSLEGEND_TABLE = By.className("Cambium.App.Tools.Review.Reviews.legendTable");
	By REPORTS_DASHBOARD_NOSTUDENTS_SECTION = By.className("Cambium.App.Dashboards.Teacher.instructionsText");
	By REPORTSTAB_SELECTED = By.xpath("//span[contains(@class,'Cambium.UI.Tabs.Tabs.selected') and @name='Reports']");
	By REPORTS_DASHBOARD_STUDENT_TABLE = By.className("Cambium.App.Dashboards.Teacher.table");
	
	By COURSE_TAB = By.name("Course");
	
	By CLASS_TAB = By.name("Class");
	
	By NOTIFICATIONS_TAB = By.name("Notifications");
	
	
	By USER_DROPDOWN = By.xpath("//td[@class='Cambium.LanguageLive.UI.DashboardMenu.UserMenu.arrowCol']/span");
	By VIEW_PROFILE_LINK = By.xpath("//td[contains(@value,'profile')]");
	By DICTIONARY_LINK = By.xpath("//td[contains(@value,'dictionary')]");
	By CHECKMIC_LINK = By.xpath("//td[contains(@value,'micTest')]");
}
