package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface CourseReportsLocators {
	By COURSEREPORTS_HEADING=By.xpath("//td[@class='Cambium.App.CourseReports.District2.CoursePerformance.col Cambium.App.CourseReports.District2.CoursePerformance.title']");
	By DISPLAYSCORESFOR_DRPDOWN=By.xpath("//table[@class='Cambium.App.CourseReports.District2.CoursePerformance.selections']//td[text()='%s']");
	By WORDTRAINING_DRPDOWN=By.xpath("//table[@class='Cambium.UI.Menu.menuTable']//td[text()='%s']");
	By ALLCLASSES_DRPDOWN=By.xpath("//table[@class='Cambium.LanguageLive.UI.SelectMenu.ClassSelector.menuTable']//td[text()='%s']");
	By TABLE_HEADING=By.xpath("//td[@class='Cambium.App.CourseReports.District2.CoursePerformance.t1c Cambium.App.CourseReports.District2.CoursePerformance.c1']//span[%s]");
	By ALLSCHOOLS_DRPDOWN=By.xpath("//table[@class='Cambium.LanguageLive.UI.SelectMenu.CampusSelector.menuTable']//td[text()='%s']");
	By STUDENTROW_DATA=By.xpath("(//span[text()='%s']/ancestor::tr/td)[%s]");
	By TABLE_HEADINGS=By.xpath("//tr[@class='Cambium.App.CourseReports.District2.CoursePerformance.headingRow2']//td");
	
	
}
