package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherRoleReportsParentReportLocators {

	By STUDENTSELECTION_DRP = By.xpath("//span[contains(@class,'Cambium.App.ParentReport.studentMenu ')]//td");
	By STUDENTDRP_OPTION = By.xpath("//span[contains(@class,'Cambium.App.ParentReport.studentMenu ')]//table[@class='Cambium.UI.Menu.menuTable']//td[contains(text(),'%s %s')]");
	By STUDENTDRPOPTION_ALLSTUDENTS_OPTION = By.xpath("//span[contains(@class,'Cambium.App.ParentReport.studentMenu ')]//table[@class='Cambium.UI.Menu.menuTable']//td[.='All Students']");
	By STUDENTDRP_ALLSTUDENT_NAMES = By.xpath("//span[contains(@class,'Cambium.App.ParentReport.studentMenu ')]//table[@class='Cambium.UI.Menu.menuTable']//td");
	By STUDENTDRP_ALLSTUDENTS_LEVELS = By.xpath("//span[contains(@class,'Cambium.App.ParentReport.studentMenu ')]//table[@class='Cambium.UI.Menu.menuTable']//td/span");
	By CREATEREPORT_BTN = By.xpath("//span[contains(@class,'Cambium.App.ParentReport.createReport')][.='Create Report']");
	By MESSAGEBODY_TEXT = By.xpath("//div[@class='Cambium.App.ParentReport.messageText'][text()='Choose a class and a student. Then select Create Report.']");
	
	By NUMBEROFSTUDENTREPORT_SECTIONS = By.className("Cambium.App.ParentReport.body");
	By STUDENTNAMEINTHEPARENTREPORT = By.xpath("//div[@class='Cambium.App.ParentReport.pri'][text()='%s']");
}
