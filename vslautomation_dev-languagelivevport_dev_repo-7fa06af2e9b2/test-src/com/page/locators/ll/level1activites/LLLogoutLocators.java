package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface LLLogoutLocators {
	
	By USER_DROPDOWN = By.xpath("//td[@class='Cambium.LanguageLive.UI.DashboardMenu.UserMenu.arrowCol']/span");
	By LOGOUT_LINK = By.xpath("//td[@value='logout']");
	

	//Locators for the Logout from the Activity or word training page
	By COURSE_DROPDOWN = By.xpath("//td[contains(@class , 'Cambium.LanguageLive.UI.CourseMenu.item')]");
}
