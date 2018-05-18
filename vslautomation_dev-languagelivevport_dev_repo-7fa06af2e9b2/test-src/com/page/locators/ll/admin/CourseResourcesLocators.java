package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface CourseResourcesLocators {
	
	By TOOLS_SUBHEADINGS=By.xpath("//span[contains(@class,'Cambium.UI.Tabs.Tabs.tab Cambium.LanguageLive.UI.DashboardMenu.secondaryTab')][text()='%s']");
	By PROGRAMPLANNING_HEADING=By.xpath(".//span[contains(@class,'Cambium.LanguageLive.UI.Tabs.tab Cambium.App.Tools.ResourceDashboard.Teacher.tabItem')][@name='programPlanning']");
	By WORDTRAINING_HEADING=By.xpath(".//span[contains(@class,'Cambium.LanguageLive.UI.Tabs.tab Cambium.App.Tools.ResourceDashboard.Teacher.tabItem')][@name='wordTraining']");
	By TEXTTRAINING_HEADING=By.xpath(".//span[contains(@class,'Cambium.LanguageLive.UI.Tabs.tab Cambium.App.Tools.ResourceDashboard.Teacher.tabItem')][@name='textTraining']");
	By PROGRAMPLANNING_TAB = By.name("programPlanning");
	By PROGRAMPLANNINGTAB_SELECTED = By.xpath("//span[@name='programPlanning' and contains(@class,'Cambium.LanguageLive.UI.Tabs.selected')]");
	By PROGRAMPLANNING_CONTENTS_TABLE = By.className("Cambium.App.Tools.ResourceDashboard.Teacher.ProgramPlanning.contents");
	By POSTERS_TAB = By.xpath("//span[@section='posters']");
	By POSTERSTAB_SELECTED = By.xpath("//span[@section='posters' and contains(@class,'Cambium.UI.Tabs.Boxy.selected')]");
	
	By PROGRAM_PLANNINGTAB_PDFLINK = By.xpath("(//tr[contains(@class,'Cambium.App.Tools.ResourceDashboard.Teacher.ProgramPlanning.book')])[2]//span[@class='Cambium.App.Tools.ResourceDashboard.Teacher.ProgramPlanning.link']");
	
	By PDFFILE_PAGENUMBER = By.id("pageNumber");
	
	By WORDTRAINING_TAB = By.name("wordTraining");
	By WORDTRAININGTAB_LEVEL_SELECTION = By.xpath("//table[@class='Cambium.LanguageLive.UI.OptionPill.LevelSelector.options']//span[contains(text(),'%s')]");
	By WORDTRAININGTAB_LEVEL_SELECTED = By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.OptionPill.LevelSelector.selected')]//span[contains(text(),'%s')]");
	By WORDTRAININGTAB_SELECTED = By.xpath("//span[@name='wordTraining' and contains(@class,'Cambium.LanguageLive.UI.Tabs.selected')]");
	By WORDTRAININGTAB_CONTENTES_TABLE = By.className("Cambium.App.Tools.ResourceDashboard.Teacher.WordTraining.contents");
	By WORDTRAININGTAB_SHOW_UNITNUMBER = By.xpath("//span[@name='%s']");
	By WORDTRAININGTAB_SHOW_UNITNUMBER_SELECTED = By.xpath("//span[@name='%s' and contains(@class,'Cambium.UI.Tabs.Boxy.selected')]");
	By WORDTRAINING_FIRSTVIDEO = By.xpath("(//span[@class='Cambium.App.Tools.ResourceDashboard.Teacher.WordTraining.link'])[1]");
	By WORDTRAINING_VIDEOPLAYER_BODY = By.xpath("//object[contains(@name,'Cambium.UI.Movie')]");
	By WORDTRAINING_VIDEOPLAYER_HEADER = By.xpath("//table[@class='Cambium.LanguageLive.UI.Well.heading']//td[contains(@class,'Cambium.LanguageLive.UI.Well.title')]");
	
	By TEXTTRAINING_TAB = By.name("textTraining");
	By TEXTTRAINING_LEVEL_SELECTION = By.xpath("//table[@class='Cambium.LanguageLive.UI.OptionPill.LevelSelector.options']//span[contains(text(),'%s')]");
	By TEXTTRAINING_LEVEL_SELECTED = By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.OptionPill.LevelSelector.selected')]//span[contains(text(),'%s')]");
	By TEXTTRAININGTAB_SELECTED = By.xpath("//span[@name='textTraining' and contains(@class,'Cambium.LanguageLive.UI.Tabs.selected')]");
	By TEXTTRAINING_CONTENTES_TABLE = By.className("Cambium.App.Tools.ResourceDashboard.Teacher.TextTraining.contents");
	By TEXTTRAINING_SHOW_UNITNUMBER = By.xpath("//span[@name='%s']");
	By TEXTTRAINING_SHOW_UNITNUMBER_SELECTED = By.xpath("//span[@name='%s' and contains(@class,'Cambium.UI.Tabs.Boxy.selected')]");
	By TEXTTRAINING_VIDEO_TOBEPLAYED = By.xpath("//span[@class='Cambium.App.Tools.ResourceDashboard.Teacher.TextTraining.link'][contains(text(),'Unit %s video')]");
	By TEXTTRAINING_VIDEOPLAYER_BODY = By.xpath("//object[contains(@name,'Cambium.UI.Movie')]");
	By TEXTTRAINING_VIDEOPLAYER_HEADER = By.xpath("//table[@class='Cambium.LanguageLive.UI.Well.heading']//td[contains(@class,'Cambium.LanguageLive.UI.Well.title')]");
	

}
