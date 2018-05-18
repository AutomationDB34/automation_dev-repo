package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherRoleNotificationsPageLocators {

	By NOTIFICATIONSTAB_SELECTED = By.xpath("//span[@name='Notifications' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	
	By NOTIFICATIONS_CONTENTS_SECTION = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.Notifications.visible')]");
	
	By NOTIFICATIONS_LIST = By.className("Cambium.LanguageLive.UI.Notifications.message");
	
	By NOTIFICATIONS_EMPTY = By.xpath("//div[@class='Cambium.LanguageLive.UI.Notifications.emptyList'][text()='You have no notifications']");
}
