package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.teacherrole.TeacherRoleNotificationsPageLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherRoleNotificationsPage extends CommonFunctionalities implements TeacherRoleNotificationsPageLocators{

	private WebDriver driver;
	
	public TeacherRoleNotificationsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose- To verify that Notifications page is loaded with some notifications or no notifications
	 */
	public void verifyThatNotificationsPageIsLoadedWithOrWithoutNotifications()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(NOTIFICATIONSTAB_SELECTED, LONGWAIT), "Notifications tab is not being displayed as selected even after clicking on it");
		Assert.assertTrue(isElementPresent(NOTIFICATIONS_CONTENTS_SECTION, LONGWAIT), "Notifications content is not loaded after clicking on notifications tab");
		int notificationsCount = getLocatorCount(NOTIFICATIONS_LIST);
		nullifyImplicitWait();
		if(notificationsCount<1)
		{
			Assert.assertTrue(isElementPresent(NOTIFICATIONS_EMPTY, LONGWAIT), "Neither the notifications nor the message stating 'You have no notifications' being displayed on Notifications page");
		}		
	}
}
