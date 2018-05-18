package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherClassClassmatesLocators {

	By CLASSMATESTAB_SELECTED = By.xpath("//span[@name='Classmates' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By CLASSMATESTAB_TABLE = By.className("Cambium.App.Classmates.tbl");
	
	By STUDENT_LINK = By.xpath("//div[@class='Cambium.App.Classmates.lastName'][text()='%s']");
	By ABOUT_ME_PROFILE_CONTENT = By.className("Cambium.App.UserProfile.AboutMe.content");
	
	
	
}
