package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherRoleReportsPageLocators {

	By REPORTS_TAB = By.name("Reports");
	By REPORTSTAB_SELECTED = By.xpath("//span[contains(@class,'Cambium.UI.Tabs.Tabs.selected') and @name='Reports']");
	By REPORTS_DASHBOARD_TAB = By.name("Dashboard");
	By REPORTS_DASHBOARD_ICON = By.className("Cambium.LanguageLive.UI.DashboardMenu.tabIcon_gauge");
	By REPORTS_COURSEREPORTS_TAB = By.name("CourseReports");
	By REPORTS_COURSEREPORTS_ICON = By.className("Cambium.LanguageLive.UI.DashboardMenu.tabIcon_barGraph");
	By REPORTS_BENCHMARKREPORTS_TAB = By.name("BenchmarkReports");
	By REPORTS_BENCHMARKREPORTS_ICON = By.xpath(
			"//span[@name='BenchmarkReports']//span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_arrowToTarget']");
	By REPORTS_SCOREDETAILS_TAB = By.name("ScoreDetails");
	By REPORTS_SCOREDETAILS_ICON = By.xpath(
			"//span[@name='ScoreDetails']//span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_arrowToTarget']");
	By REPORTS_PARENTREPORT_TAB = By.name("ParentReport");
	By REPORTS_PARENTREPORT_ICON = By.xpath(
			"//span[@name='ParentReport']//span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_arrowToTarget']");
	By REPORTS_DISTRICTOVERVIEW_TAB = By.name("DistrictOverview");
	By REPORTS_DISTRICTOVERVIEW_ICON = By.xpath(
			"//span[@name='DistrictOverview']//span[@class='Cambium.LanguageLive.UI.DashboardMenu.tabIcon_arrowToTarget']");
	By REPORTS_DASHBOARD_STUDENT_TABLE = By.className("Cambium.App.Dashboards.Teacher.table");

	/*By STUDENTNAME_LINK = By.xpath(
			".//div[@class = 'Cambium.App.Dashboards.Teacher.studentName']/div[@class='Cambium.App.Dashboards.Teacher.lastName'][Text()='%s']");
	*/
	By STUDENTNAME_LINK = By.xpath(".//div[text()='testautostud1'][1]");
	By SUMMARY_PAGE = By.xpath("//div[@class='Cambium.App.Scorecard.Student.Summary.title']");
	By STUDENT_NAME = By.xpath("//span[contains(text(),'%s')]");

	By SCORECARD_DETAILS = By.xpath(
			"//td[contains(@class,'Cambium.App.Scorecard.Student.Summary.rightPane')]//table[@class='Cambium.App.Scorecard.Student.Summary.podData']/tbody/tr[%s]/td[2]");


	


}
