package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface StartupReportsLocators {
By STARTUPREPORTS_HEADING=By.xpath("//td[@class='Cambium.App.Dashboards.District2.StartUp.Participation.col Cambium.App.Dashboards.District2.StartUp.Participation.title']");
 By SUBTABS_HEADING=By.xpath("//span[@class='Cambium.App.Dashboards.District2.StartUp.Participation.text']");
 By STUDENTTAB_ISSELECTED=By.xpath("//td[@class='Cambium.LanguageLive.UI.OptionPill.option Cambium.LanguageLive.UI.OptionPill.selected']");
 By TEACHERTAB_ISSELECTED=By.xpath("//td[@class='Cambium.LanguageLive.UI.OptionPill.option Cambium.LanguageLive.UI.OptionPill.selected']");
 By STUDENT_SUBTAB=By.xpath("//*[@class='Cambium.LanguageLive.UI.OptionPill.options']//td[@value='student']");
 By TEACHER_SUBTAB=By.xpath("//*[@class='Cambium.LanguageLive.UI.OptionPill.options']//td[@value='teacher']");
 
 By TEACHERPARTICIAPTIONTABLECOLUMN_HEADINGS=By.xpath("//tr[@class='Cambium.App.Dashboards.District2.StartUp.Participation.headingRow']//td");
 By STUDENTPARTICIAPTIONTABLECOLUMN_HEADINGS=By.xpath("//tr[@class='Cambium.App.Dashboards.District2.StartUp.Participation.headingRow']//td");
 
 By STUDENTPARTICIPATIONTABLEROW_VALUES=By.xpath("//span[text()='District Total']/../..//span");
 By TEACHERPARTICIPATIONTABLEROW_VALUESFORDISTUSER=By.xpath("//span[text()='District Total']/../..//span");
 
 By TEACHERPARTICIPATIONTABLEROW_VALUESFORCAMPUSER=By.xpath("//span[text()='Campus Total']/../..//span");
 By STUDENTPARTICIPATIONTABLEROW_VALUESFORCAMPUSER=By.xpath("//span[text()='Campus Total']/../..//span");
}
	