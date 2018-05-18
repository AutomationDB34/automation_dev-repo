package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface MultiRoleScenarioLocators {
	
	 By CAMPUS_ROLE_RADIOBTN = By.xpath("//button[@value = 'campus']");
	 By TEACHER_ROLE_RADIOBTN = By.xpath("//button[@value = 'teacher']");
	 

	 By CAMPUS_LAYOUT = By.xpath("//table[@class='Cambium.App.Dashboards.District2.layout']");
	 By USER_DROP_DOWN = By.xpath("//span[@class='Cambium.LanguageLive.UI.DashboardMenu.UserMenu.arrow']");
	 By CHANGE_ROLE = By.xpath("//td[@value = 'changeRole']");
	 By TEACHER_LAYOUT= By.xpath("//div[@class='Cambium.App.Dashboards.Teacher.header']");
	 By CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	 
	 
}
