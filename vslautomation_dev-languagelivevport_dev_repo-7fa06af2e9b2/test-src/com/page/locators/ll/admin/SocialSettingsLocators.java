package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface SocialSettingsLocators {
	// District Social Settings pane locators
	By DISTRICTSOCIALSETTINGSTAB_HEADING = By
			.xpath("//td[contains(@class,'Cambium.App.SocialSettings.District.title') and text()='Social Settings']");
	By DISRICTSOCIALSETTINGSSUB_HEADINGS = By
			.xpath("(//td[@class='Cambium.App.SocialSettings.District.pageHeading'])[%s]");
	By ENABLE_WALLPOSTINGFORALLSCHOOLS_CHECKBOX_CHECKED = By.xpath(
			"//td[@class='Cambium.App.SocialSettings.District.checkboxCol']//button[contains(@class,'Cambium.UI.Buttons.CheckButton.checked') and @checked]");
	By ENABLE_WALLPOSTINGFORALLSCHOOLS_CHECKBOX_UNCHECKED = By.xpath(
			"//button[@class='Cambium.UI.Buttons.CheckButton Cambium.App.SocialSettings.District.chkDistrictEnable cambium_ui_buttons_check_button']");
	By ENABLEWALLPOSTINGSCHOOLS_CHKBOX = By
			.xpath("//td[@class='Cambium.App.SocialSettings.District.checkboxCol']/button[@type='button']");
	By DISTRICTSOCIALSETTINGS_APPLYBTN = By
			.xpath("//button[contains(@class,'Cambium.App.SocialSettings.District.applyBtn ') and text()='Apply']");

	// School Social Settings Locators
	By CAMPUSSOCIALSETTINGSTAB_HEADING = By
			.xpath("//td[contains(@class,'Cambium.App.SocialSettings.Campus.title') and contains(.,'Social Settings')]");
	By SCHOOLSOCIALSETTINGSSUB_HEADINGS = By
			.xpath("(//td[@class='Cambium.App.SocialSettings.Campus.pageHeading'])[%s]");
	By ENABLE_WALLPOSTINGFORALLCLASSES_CHECKBOX_CHECKED = By.xpath(
			"//td[@class='Cambium.App.SocialSettings.Campus.checkboxCol']//button[contains(@class,'Cambium.UI.Buttons.CheckButton.checked') and @checked]");
	By ENABLE_WALLPOSTINGFORALLCLASSES_CHECKBOX_UNCHECKED = By.xpath(
			"//button[@class='Cambium.UI.Buttons.CheckButton Cambium.App.SocialSettings.Campus.chkCampusEnable cambium_ui_buttons_check_button']");
	By ENABLEWALLPOSTINGSCLASSES_CHKBOX = By
			.xpath("//td[@class='Cambium.App.SocialSettings.Campus.checkboxCol']/button[@type='button']");
	By SCHOOLSOCIALSETTINGS_APPLYBTN = By
			.xpath("//button[contains(@class,'Cambium.App.SocialSettings.Campus.applyBtn') and text()='Apply']");

	// Campus Social Settings
	By ENABLEPRIVILAGEWALLFORSCHOOL_CHKBOX_CHECKED = By.xpath(
			"//td[@class='Cambium.App.SocialSettings.District.col1' and text()='%s']/..//button[contains(@class,'Cambium.UI.Buttons.CheckButton.checked') and @checked]");
	By ENABLEPRIVILAGEWALLFORSCHOOL_CHKBOX_UNCHECKED = By.xpath(
			"//td[@class='Cambium.App.SocialSettings.District.col1' and text()='%s']/..//button[@class='Cambium.UI.Buttons.CheckButton Cambium.App.SocialSettings.District.checkbox Cambium.App.SocialSettings.District.chkCampusWall cambium_ui_buttons_check_button']");
	By ENABLEPRIVILAGEWALLFORSCHOOL_CHKBOX = By
			.xpath("//td[@class='Cambium.App.SocialSettings.District.col1' and text()='%s']/..//button");
	By CAMPUSSOCIALSETTINGS_APPLYBTN = By
			.xpath("//td[@class='Cambium.App.SocialSettings.District.col1' and text()='%s']/..//span[text()='Apply']");

	// Class Room social Settings
	By ENABLEPRIVILAGEWALLFORCLASS_CHKBOX_CHECKED = By.xpath(
			"//td[@class='Cambium.App.SocialSettings.Campus.col1' and text()='%s']/..//button[contains(@class,'Cambium.UI.Buttons.CheckButton.checked') and @checked]");
	By ENABLEPRIVILAGEWALLFORCLASS_CHKBOX_UNCHECKED = By.xpath(
			"//td[@class='Cambium.App.SocialSettings.Campus.col1' and text()='%s']/..//button[@class='Cambium.UI.Buttons.CheckButton Cambium.App.SocialSettings.Campus.checkbox Cambium.App.SocialSettings.Campus.chkClassWall cambium_ui_buttons_check_button']");
	By ENABLEPRIVILAGEWALLFORCLASS_CHKBOX = By
			.xpath("//td[@class='Cambium.App.SocialSettings.Campus.col1' and text()='%s']/..//button");
	By CLASSROOMSOCIALSETTINGS_APPLYBTN = By
			.xpath("//td[@class='Cambium.App.SocialSettings.Campus.col1' and text()='%s']/..//span[text()='Apply']");

	// Support pane

	By SUPPORT_PANE = By
			.xpath("//table[contains(@class,'NeedHelp.details')]");
	By EMAILSUPPORT_LINK = By.xpath(
			"//a[contains(@href,'mailto:support@voyagersopris.com')]");
	By ONLINE_TRAINING_SUPPORT_LINK = By.xpath(
			".//div[contains(.,'Online Training & Support') and contains(@class,'link')]");
	By LIVE_CHAT = By.xpath("//div[contains(.,'Live Chat') and contains(@class,'link')]");


	
}
