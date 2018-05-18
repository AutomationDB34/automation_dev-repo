package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherToolsSocialSettingsLocators {

	By SOCIALSETTINGSTAB_SELECTED = By.xpath("//span[@name='Social' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By SOCIALSETTINGS_SECTION = By.xpath("//div[contains(@class,'Cambium.App.SocialSettings.Teacher.content')]");
	
	By APPLY_MAIN_BTN = By.xpath("//button[contains(@class,'Cambium.App.SocialSettings.Teacher.applyBtn')]");
	
	By ENABLE_WALLPOSTING_CHECKBOX = By.xpath("//button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkClassEnable')]");
	By ENABLE_WALLPOSTING_CHECKBOX_CHECKED = By.xpath("//button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkClassEnable') and@checked]");
	
	By ENABLE_FEEDBACKTAB_CHECKBOX = By.xpath("//button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkPeerFeedback')]");
	By ENABLE_FEEDBACKTAB_CHECKBOX_CHECKED = By.xpath("//button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkPeerFeedback') and @checked]");
	
	By ENABLE_PROFILES_CHECKBOX = By.xpath("//button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkProfiles')]");
	By ENABLE_PROFILES_CHECKBOX_CHECKED = By.xpath("//button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkProfiles') and @checked]");
	
	By ENABLE_LEADERBOARDS_CHECKBOX = By.xpath("//button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkLeaderboard')]");
	By ENABLE_LEADERBOARDS_CHECKBOX_CHECKED = By.xpath("//button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkLeaderboard') and @checked]");
	By ENABLE_LEADERBOARDS_CHECKBOX_NOTCHECKED = By.xpath("//button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkLeaderboard') and not(@checked)]");
	
	By STUDENTS_SOCIALSETTINGS_COUNT = By.xpath("//td[@class='Cambium.App.SocialSettings.Teacher.microSettingsContainer']//tr[@class='Cambium.App.SocialSettings.Teacher.contentRow']");
	By STUDENTS_WALLPOSTINGENABLED_COUNT = By.xpath("//td[@class='Cambium.App.SocialSettings.Teacher.microSettingsContainer']//tr[@class='Cambium.App.SocialSettings.Teacher.contentRow']//button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkStudentWall') and contains(@class,'Cambium.UI.Buttons.CheckButton.checked')]");
	By STUDENTS_PROFILEENABLED_COUNT = By.xpath("//td[@class='Cambium.App.SocialSettings.Teacher.microSettingsContainer']//tr[@class='Cambium.App.SocialSettings.Teacher.contentRow']//button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkStudentProfile') and contains(@class,'Cambium.UI.Buttons.CheckButton.checked')]");
	
	By WALLPOSTING_CHECKBOX_SINGLESTUDENT = By.xpath("//td[@class='Cambium.App.SocialSettings.Teacher.microSettingsContainer']//tr//div[@class='Cambium.App.SocialSettings.Teacher.lastName'][text()='%s']/ancestor::tr[1]//td[3]/button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkStudentWall')]");
	
	By PROFILE_CHECKBOX_SINGLESTUDENT = By.xpath("//td[@class='Cambium.App.SocialSettings.Teacher.microSettingsContainer']//tr//div[@class='Cambium.App.SocialSettings.Teacher.lastName'][text()='%s']/ancestor::tr[1]//td[5]/button[contains(@class,'Cambium.App.SocialSettings.Teacher.chkStudentProfile')]");
	
	By SINGLE_STUDENT_APPLY_BTN = By.xpath("//td[@class='Cambium.App.SocialSettings.Teacher.microSettingsContainer']//tr//div[@class='Cambium.App.SocialSettings.Teacher.lastName'][text()='%s']/ancestor::tr[1]/td[7]/span[text()='Apply']");
	
}
