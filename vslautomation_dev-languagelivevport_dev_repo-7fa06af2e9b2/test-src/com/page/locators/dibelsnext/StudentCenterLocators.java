package com.page.locators.dibelsnext;

import org.openqa.selenium.By;

public interface StudentCenterLocators {
	By STUDENTCENTER_HEADING=By.xpath(".//span[text()='Student Center']");
	By ASSIGNMENTSNAME=By.xpath(".//td[@class='assignments dashboardPadding']/span[text()='%s']");
	By RADIO_BUTTON =By.xpath("//td[@class='assignments dashboardPadding']/span[text()='%s']/../../td[@class='assignments']/input[@type='radio']");
	By STARTTAKINGTHISTEST_BTN=By.id("testing");
    By ASSESSMENTFLASHVIDEO=By.xpath("//object[@id='DIBELS Next']");

}
