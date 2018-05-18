package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherClassClassResourcesLocators {

	By CLASSRESOURCESTAB_SELECTED = By.xpath("//span[@name='Resources' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By CLASSRESOURCES_CONTENTS_SECTION = By.className("Cambium.App.Tools.ResourceDashboard.Student.CourseMaterials.contents");
	
	By CLASSRESOURCES_LEVEL_OPTION = By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.OptionPill.LevelSelector.option')]/span[text()='%s']");
	By CLASSRESOURCES_LEVEL_SELECTED =By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.OptionPill.LevelSelector.option') and contains(@class,'Cambium.LanguageLive.UI.OptionPill.LevelSelector.selected')]/span[text()='%s']");
			
	By WORDTRAINING_FIRSTVIDEO = By.xpath("(//span[@class='Cambium.App.Tools.ResourceDashboard.Student.CourseMaterials.link'])[1]");
	By WORDTRAINING_VIDEOPLAYER_BODY = By.xpath("//object[contains(@name,'Cambium.UI.Movie')]");
	By WORDTRAINING_VIDEOPLAYER_HEADER = By.xpath("//table[@class='Cambium.LanguageLive.UI.Well.heading']//td[contains(@class,'Cambium.LanguageLive.UI.Well.title')]");
	
			
}
