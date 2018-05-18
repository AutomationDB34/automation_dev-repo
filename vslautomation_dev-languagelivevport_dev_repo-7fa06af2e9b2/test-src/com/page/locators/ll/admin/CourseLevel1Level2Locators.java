package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface CourseLevel1Level2Locators {

	By COURSE_LEVELONE_TAB = By.name("Level1");
	By COURSE_LEVELONE_SELECTED = By.xpath("//span[@name='Level1' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	
	By COURSE_LEVELTWO_TAB = By.name("Level2");
	By COURSE_LEVELTWO_SELECTED = By.xpath("//span[@name='Level2' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
}
