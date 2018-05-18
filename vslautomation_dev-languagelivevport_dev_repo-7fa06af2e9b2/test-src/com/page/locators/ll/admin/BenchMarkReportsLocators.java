package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface BenchMarkReportsLocators {
	By ALLSCHOOLS_DRPDOWN=By.xpath("//table[@class='Cambium.LanguageLive.UI.SelectMenu.CampusSelector.menuTable']//td[text()='%s']");
	By SCHOOLROW_DATA=By.xpath("(//div[@class='Cambium.App.BenchmarkReports.District2.BenchmarkReport.upper'][@title='%s']/../../td/span)[%s]");
    By MATCHED_CHKBOX=By.xpath("//button[@type='button']");
    
    By NOMATCHED_SCORES = By.xpath("//div[contains(text(),'There is no matched data available for this ')]");
 
}

