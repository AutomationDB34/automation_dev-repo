package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface LLStudentHomePageLocators {
	
	By WTSTART_BUTTON=By.xpath("//button[@class='Cambium.App.StudentHomePage.WT Cambium.App.StudentHomePage.courseButton']");
	
	By USER_DROPDOWN = By.xpath("//td[@class='Cambium.LanguageLive.UI.DashboardMenu.UserMenu.arrowCol']/span");
	By VIEWPROFILE_LINK=By.xpath("//td[@value='profile']");
	
	By CLASS_LINK = By.xpath("//span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_people']");
	By CLASS_WALL = By.xpath("//td[contains(text(),'Class Wall')]");
	By MYSCORECARD_LINK = By.xpath("//span[contains(@class,'Cambium.LanguageLive.UI.DashboardMenu.tabIcon_barGraph')]");
	By SUMMARY_PAGE = By.xpath("//div[@class='Cambium.App.Scorecard.Student.Summary.title']");

	By SCORECARD_DETAILS = By.xpath(
			"//td[contains(@class,'Cambium.App.Scorecard.Student.Summary.rightPane')]//table[@class='Cambium.App.Scorecard.Student.Summary.podData']/tbody/tr[%s]/td[2]");

	
}
