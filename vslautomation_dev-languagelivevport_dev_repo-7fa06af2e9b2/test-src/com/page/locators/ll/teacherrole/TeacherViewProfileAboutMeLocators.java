package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherViewProfileAboutMeLocators {

	By ABOUT_ME_TAB_SELECTED = By.xpath("//span[@name='UserProfile' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By ABOUT_ME_CONTENT_SECTION = By.className("Cambium.App.UserProfile.AboutMe.content");
	
	By COURSEPOINTSCOUNT_YEAR=By.xpath("(//*[@class='Cambium.App.UserProfile.AboutMe.count Cambium.App.UserProfile.AboutMe.coursePoints'])[2]");
	By ACHEIVEMENTSCOUNT_YEAR=By.xpath("(//*[@class='Cambium.App.UserProfile.AboutMe.count Cambium.App.UserProfile.AboutMe.achievementsCount'])[2]");
	
	By EDIT_LINK=By.xpath("//span[text()='Edit']");
	By EDITPROFILE_HEADING=By.xpath("//td[text()='Edit Profile Information']");
	By BIRTHPLACE_TEXTAREA=By.xpath("//textarea[contains(@class,'Cambium.App.UserProfile.EditProfile.birthPlace')]");
	By BIRTHPLACELABEL_VALUE=By.xpath("//span[@class='Cambium.App.UserProfile.AboutMe.lbl' and text()='Birthplace']//following-sibling::span");
	By SAVEINEDITPROFILE_BTN=By.xpath("//span[text()='Save']");
	
	By ACHIVEMENTS_TAB=By.name("Achievements");
	By AVATOR_EDITOR=By.name("AvatarEditor");
	
	By FILL_OUT_PROFILE_LINK = By.xpath("//div[contains(text(),'Fill out your Profile')]");
	By EDIT_PROFILE_HEADER = By.className("Cambium.App.UserProfile.EditProfile.header");
	By DISPLAYNAME_TEXTAREA = By.xpath("//textarea[contains(@class,'Cambium.App.UserProfile.EditProfile.displayName')]");
	By SAVE_BTN = By.xpath("//div[@class='Cambium.App.UserProfile.EditProfile.content']/div[1]//span[contains(text(),'Save')]");
	
	By TEACEHER_DISPLAYNAME = By.xpath("//td[contains(text(),'testautoteachuser')]");
	
}
