package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherToolsReviewLocators {

	By REVIEW_REVIEWS_TAB = By.name("reviews");
	By REVIEW_REVIEWS_CLASS_DRP = By.xpath("//span[contains(@class,'Cambium.App.Tools.Review.levelSelector')]//td");
	By REVIEW_REVIEWS_CLASS_OPTION = By.xpath(
			"//span[contains(@class,'Cambium.App.Tools.Review.levelSelector')]//table[@class='Cambium.UI.Menu.menuTable']//td[text()='%s']");
	By REVIEWSTAB_STUDENTS_TABLE = By.className("Cambium.App.Tools.Review.Reviews.table");
	By REVIEWSTAB_STUDENT_REVIEW_BTN = By.xpath(
			"//div[@class='Cambium.App.Tools.Review.Reviews.lastName'][text()='%s']/ancestor::tr[1]//button[text()='Review']");
	By REVIEWSTAB_STUDENT_POWERPASS_REVIEW_BTN = By.xpath(
			"//div[@class='Cambium.App.Tools.Review.Reviews.lastName'][text()='%s']/ancestor::tr[1]//button[text()='Review']");

	By REVIEW_ALERTS_TAB = By.name("alerts");
	By REVIEW_ALERTSTAB_STUDENTTABLE = By.className("Cambium.App.Tools.Review.Alerts.table");

	By ALERTSSTUDENT_AUTOPASS = By.xpath(
			"//div[@class='Cambium.App.Tools.Review.Alerts.lastName'][text()='%s']/ancestor::tr[1]//span[@class='Cambium.App.Tools.Review.Alerts.type'][text()='Auto-pass']");
	By ALERTSSTUDENT_REVIEW_BTN = By.xpath(
			"//div[@class='Cambium.App.Tools.Review.Alerts.lastName'][text()='%s']/ancestor::tr[1]//button[.='Review']");

	By REVIEW_WTACTIVITY = By.xpath(
			"//span[@class='Cambium.LanguageLive.trainingAreaIcon Cambium.LanguageLive.trainingArea_wordTraining']");
	By AlERTS_AUTOPASSTYPE = By.xpath("//span[@class='Cambium.App.Tools.Review.Alerts.type'][text()='Auto-pass']");

}
