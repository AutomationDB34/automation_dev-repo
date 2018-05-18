package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherReportsScoreDetailsLocators {

	By SCOREDETAILS_IFRAME = By.className("Cambium.App.ScoreDetails.vportFrame");
	By SCOREDETAILS_FORM = By.xpath("//form[@id='classEnterScoresForm']//table[@id='standard']");
	
	By TIMEPERIOD = By.xpath("//nobr[contains(text(),'1')]");
	By SCORE = By.xpath("//tr[@class='enrolledNameRowNoSelect']/td[contains(text(),'%s')][1]/following-sibling::td[3]//input");
	
	
}
