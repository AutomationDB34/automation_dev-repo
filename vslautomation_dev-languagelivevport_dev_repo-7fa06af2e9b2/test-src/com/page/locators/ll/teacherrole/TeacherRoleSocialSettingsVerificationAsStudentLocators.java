package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherRoleSocialSettingsVerificationAsStudentLocators {

	By STUDENT_STADIUMBACKGROUND = By.className("Cambium.App.StudentHomePage.stadiumBackground");
	By CLASS_TAB = By.name("Class");
	By CLASSWALLTAB_SELECTED = By.xpath("//span[@name='ClassWall' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By CLASSWALL_TEXTAREA_FIELD = By.xpath("//textarea[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.statusToPost')]");
	By CLASSWALL_SECTION = By.xpath("//div[contains(@class,'Cambium.App.ClassWall.content')]");
	By FEEDBACK_TAB = By.name("Feedback");
	By LEADERBOARD_WIDGETS_ARROW_BTN = By.className("Cambium.App.Leaderboards.Widget.arrow");	
	By USERMENU_ARROW = By.className("Cambium.LanguageLive.UI.DashboardMenu.UserMenu.arrow");
	By USERMENU_VIEWPROFILE_OPTION = By.xpath("//td[@value='profile']");
	By ABOUTME_EDIT_BTN = By.xpath("//span[contains(@class,'Cambium.App.UserProfile.AboutMe.editProfile')][text()='Edit']");
	
	
	By CLASSWALL_DISABLED_MESSAGE = By.xpath("//div[contains(text(),'Your teacher has disabled access to the wall for this class.')]");
	
	By LEADERBOARDS_DISABLED_MESSAGE = By.xpath("//div[@class='Cambium.App.Leaderboards.Widget.messageText'][contains(text(),'Your teacher has disabled')]");
	
	By ABOUTME_DISABLED_MESSAGE = By.xpath("//div[contains(text(),'Your teacher has removed the availability of your profile.')]");
}
