package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherClassClassWallLocators {

	By ASSIGNMENT_FILTER = By.xpath("//td[@value='addAssignment']/span[text()='Assignment']");
	By ASSIGNMENT_FILTER_SELECTED = By.xpath("//td[@value='addAssignment' and contains(@class,'Cambium.LanguageLive.UI.OptionPill.selected')]/span[text()='Assignment']");
	
	By ASSIGNMENT_TITLE_TEXTFIELD = By.xpath("//textarea[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.assignmentTitle')]");
	By ASSIGNMENT_DESC_TEXTFIELD = By.xpath("//textarea[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.assignmentDesc')]");
	
	By CREDIT_DRP = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.credit')]//td");
	By CREDITDRP_OPTION = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.credit')]//table[@class='Cambium.UI.Menu.menuTable']//td[text()='%s']");
	
	By ENDDATE_CALENDAR_ICON = By.className("Cambium.LanguageLive.UI.DatePicker.calendarIcon");
	By ENDDATE_PICKER_TABLE = By.className("Cambium.LanguageLive.UI.DatePicker.pickDateTable");
	By ENDDATE_PICKER_FIRST_VALID_DATE = By.xpath("(//td[contains(@class,'Cambium.LanguageLive.UI.DatePicker.valid ')])[1]");
	
	By TIME_HOUR_DRP = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.hour')]//td");
	By TIME_HOURDRP_OPTION = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.hour')]//table[@class='Cambium.UI.Menu.menuTable']//td[text()='%s']");
	
	By TIME_MINUTE_DRP = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.minute')]//td");
	By TIME_MINUTEDRP_OPTION = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.minute')]//table[@class='Cambium.UI.Menu.menuTable']//td[text()='%s']");
	
	By TIME_AMPM_DRP = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.ampm')]//td");
	By TIME_AMPMDRP_OPTION = By.xpath("//div[contains(@class,'Cambium.LanguageLive.UI.WallPost.AddNew.ampm')]//table[@class='Cambium.UI.Menu.menuTable']//td[text()='%s']");
	
	By ASSIGNMENT_SHARE_BTN = By.xpath("//div[@class='Cambium.LanguageLive.UI.WallPost.AddNew.addAssignment']//button[text()='Share']");
	
	By CURRENT_MONTH_NAME = By.className("Cambium.LanguageLive.UI.DatePicker.pickDateMonth");
	By CURRENT_WEEK_DAY_NAME = By.xpath("(//td[@class='Cambium.LanguageLive.UI.DatePicker.pickDateWeek'])[%s]");
	By CURRENT_DATE_PREVIOUS_COLUMNS_COUNT = By.xpath("(//td[contains(@class,'Cambium.LanguageLive.UI.DatePicker.valid ')])[1]/preceding-sibling::*");
	
	By ASSIGNMENT_POST_SECTION = By.className("Cambium.LanguageLive.UI.Wall.wallStream");
	
	By ASSIGNMENT_TITLE_POSTED_SECTION = By.xpath("//span[@class='Cambium.LanguageLive.UI.WallPost.Assignment.title'][text()='%s']");
	By ASSIGNMENT_ENDDATE_POSTED_SECTION = By.xpath("//span[@class='Cambium.LanguageLive.UI.WallPost.Assignment.title'][text()='%s']/ancestor::td[1]//span[@class='Cambium.LanguageLive.UI.WallPost.Assignment.endDate']");
	
	By ASSIGNMENT_CREDITPOINTS_POSTED_SECTION = By.xpath("//span[@class='Cambium.LanguageLive.UI.WallPost.Assignment.title'][text()='%s']/following-sibling::span");
	
		//Locators in Status sub tab
	
	By WALLPOST_PANE=By.className("Cambium.LanguageLive.UI.WallPost.AddNew.addNewContainer");
	By STATUSSUBTAB_ISSELECTED=By.xpath("//td[@class='Cambium.LanguageLive.UI.OptionPill.option Cambium.LanguageLive.UI.OptionPill.selected' and @value='updateStatus']");
	By ALL_FILTER = By.xpath("//span[contains(text(),'All')]");
	
	
}
