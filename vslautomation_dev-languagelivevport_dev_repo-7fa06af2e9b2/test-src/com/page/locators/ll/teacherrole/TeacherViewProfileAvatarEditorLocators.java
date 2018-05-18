package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherViewProfileAvatarEditorLocators {

	By AVATAREDITORTAB_SELECTED = By.xpath("//span[@name='AvatarEditor' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By AVATAREDITORTAB_IFRAME = By.xpath("//td[contains(@class ,'Cambium.AvatarEditor.title')]");
	By AVATAREDITORTAB_SECTION = By.xpath("//div[@class='Cambium.AvatarEditor.avatarContainer']");
	
	
	
	
}
