package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherReportsBenchmarkReportsLocators {

	By BENCHMARKREPORTS_IFRAME = By.className("Cambium.App.BenchmarkReports.Teacher.BenchmarkReport.vportFrame");
	By BENCHMARKSREPORTS_FORM = By.xpath("//form[@id='classResultsByClassForm']//table[@id='row']");
	
	By TIMEPERIOD_DROPDOWN = By.id("filterBenchmarkIDs");
	By UPDATE_BTN = By.className("filtersSearchButton");
	By SCORE = By.xpath("//td/div[contains(text(),'%s')]/parent::td/following-sibling::td[3]");
}
