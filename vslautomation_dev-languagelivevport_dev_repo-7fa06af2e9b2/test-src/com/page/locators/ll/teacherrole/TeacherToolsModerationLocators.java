package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherToolsModerationLocators {

	By MODERATION_SECTION = By.className("Cambium.LanguageLive.UI.Moderation.moderationContents");
	
	By MODERATION_ABUSE_FILTER = By.xpath("//td[@class='Cambium.LanguageLive.UI.OptionPill.option' and @value='abuse']/span[text()='Abuse']");
	By MODERATION_ALLPOSTS_FILTER = By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.OptionPill.option')]/span[text()='All Posts']");
	By MODERATION_ALLDAYS_FILTER = By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.OptionPill.option')]/span[text()='All']");
	
	By NONOFFENSIVE_STUDENTS_COUNT = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.Moderation.notOffensive ') and @style='display: block;']");
	By ABUSE_STUDENTS_COUNT = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.Moderation.Status.abuseVisualCue')]");
	
	By FIRSTABUSESTUDENT_NAME = By.xpath("(//div[contains(@class,'Cambium.LanguageLive.UI.Moderation.Status.abuseVisualCue')]//span[@class='Cambium.LanguageLive.UI.Moderation.Status.posterLink'])[1]");
	By FIRSTABUSESTUDENT_MODERATE_BTN = By.xpath("(//table[@class='Cambium.LanguageLive.UI.Moderation.Status.statusTable']//button[contains(@class,'Cambium.LanguageLive.UI.Moderation.Status.show') and text()='Moderate'])[1]");
	By ABUSEREPORTDETAIL_STUDENTNAME = By.xpath("//td[@class='Cambium.App.Moderation.studentContainer']//td[@class='Cambium.App.Moderation.studentName']");
	
	By BACKTOMODERATIONOVERVIEW_BTN = By.xpath("//span[@class='Cambium.App.Moderation.backArrow']");
}
