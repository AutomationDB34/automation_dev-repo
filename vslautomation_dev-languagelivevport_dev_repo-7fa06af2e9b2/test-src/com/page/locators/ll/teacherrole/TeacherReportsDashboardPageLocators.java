package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherReportsDashboardPageLocators {

	//REPORTS TAB MAIN PAGE LOCATORS
	By REPORTS_TAB = By.name("Reports");
	By REPORTS_DASHBOARD_STUDENT_TABLE = By.className("Cambium.App.Dashboards.Teacher.table");
	By LEVELS_DRP = By.xpath("//span[contains(@class,'cambium_language_live_ui_select_menu_level_selector')]//td");
	By LEVELSDRP_OPTION = By.xpath("//span[contains(@class,'cambium_language_live_ui_select_menu_level_selector')]//table[@class='Cambium.UI.Menu.menuTable']//td[contains(text(),'%s')]");
	
	By WORDTRAININGSTATUSFIRST_TEXT = By.xpath("//div[@class='Cambium.App.Dashboards.Teacher.lastName'][contains(text(),'%s')]/ancestor::tr[1]/td[2]//span[@class='Cambium.App.Dashboards.Teacher.upper']");
	By WORDTRAININGSTATUSSECOND_TEXT = By.xpath("//div[@class='Cambium.App.Dashboards.Teacher.lastName'][contains(text(),'%s')]/ancestor::tr[1]/td[2]//div[@class='Cambium.App.Dashboards.Teacher.lower']");
	
	By DASHBOARD_REVIEW_TAB = By.xpath("//div[@class='Cambium.App.Dashboards.Teacher.detailLower'][contains(text(),'Review')]");
	By DASHBOARD_COURSEALERTS_TAB = By.xpath("//div[@class='Cambium.App.Dashboards.Teacher.detailLower'][contains(text(),'Course Alert')]");
	
	By DASHBOARD_TIMEONTASK_TAB = By.xpath("//div[@class='Cambium.App.Dashboards.Teacher.detailLower'][.='Time On Task']");
	By DASHBOARD_TIMEONTASKTAB_COUNT = By.xpath("//div[@class='Cambium.App.Dashboards.Teacher.detailLower'][.='Time On Task']/preceding-sibling::div/span");
	By DASHBOARD_TIMEONTASKPOPUP_HEADER = By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.Well.title')][.='Time on task']");
	By DASHBOARD_TIMEONTASKPOPUPSTUDENT_COUNT = By.xpath("//div[@class='Cambium.App.Dashboards.Teacher.Details.dataTable']//tr");
	
	By DASHBOARD_ITEMSCOMPLETED_TAB = By.xpath("//div[@class='Cambium.App.Dashboards.Teacher.detailLower'][contains(text(),'Completed')]");
	By DASHBOARD_ITEMSCOMPLETEDTAB_COUNT = By.xpath("//div[@class='Cambium.App.Dashboards.Teacher.detailLower'][contains(text(),'Completed')]/preceding-sibling::div/span");
	By DASHBOARD_ITEMSCOMPLETEDPOPUP_HEADER = By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.Well.title')][.='Items completed']");
	By DASHBOARD_ITEMSCOMPLETEDPOPUPSTUDENT_COUNT = By.xpath("//div[@class='Cambium.App.Dashboards.Teacher.Details.dataTable']//tr");
	
	
	By REVIEW_REVIEWSSELECTED_TAB = By.xpath("//span[contains(@class,'Cambium.LanguageLive.UI.Tabs.selected') and @name='reviews']");
	By REVIEW_REVIEWS_TABLE = By.className("Cambium.App.Tools.Review.Reviews.table");
	By REVIEW_ALERTSSELECTED_TAB = By.xpath("//span[contains(@class,'Cambium.LanguageLive.UI.Tabs.selected') and @name='alerts']");
	By REVIEW_ALERTS_TABLE = By.className("Cambium.App.Tools.Review.Alerts.table");
	
	
	
}
