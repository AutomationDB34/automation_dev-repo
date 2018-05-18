package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface NotificationReportsLocators {
By NOTIFICATIONREPORT_SUBHEADING=By.xpath("//span[@class='Cambium.App.NotificationsReport.subTitle']");
By FILTEROPTIONS_TABS=By.xpath("//table[@class='Cambium.LanguageLive.UI.OptionPill.options']//span[text()='%s']");
By FILTERPAGES_HEADINGS=By.xpath("//span[@class='Cambium.App.NotificationsReport.filterLabel'][text()='%s']");
By GOALREVIEWS_SUBROWS_COUNT=By.xpath("//tr[@class='Cambium.App.NotificationsReport.headingRow2']//td[contains(@class,'Cambium.App.NotificationsReport.grp2')]");
By GOALREVIEWS_SUBROWS=By.xpath("//tr[@class='Cambium.App.NotificationsReport.headingRow2']//td[contains(@class,'Cambium.App.NotificationsReport.grp2')][%s]");

By AUTOPASSES_SUBROWS_COUNT=By.xpath("//tr[@class='Cambium.App.NotificationsReport.headingRow2']//td[contains(@class,'Cambium.App.NotificationsReport.grp3')]");
By AUTOPASSES_SUBROWS=By.xpath("//tr[@class='Cambium.App.NotificationsReport.headingRow2']//td[contains(@class,'Cambium.App.NotificationsReport.grp3')][%s]");

By SCHOOLROW_DATA=By.xpath("(//span[@class='Cambium.App.NotificationsReport.campusName'][text()='%s']/../../td/span)[%s]");
}
