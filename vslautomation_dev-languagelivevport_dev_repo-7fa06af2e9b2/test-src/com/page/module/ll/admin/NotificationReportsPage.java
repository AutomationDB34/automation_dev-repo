package com.page.module.ll.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.page.locators.ll.admin.NotificationReportsLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class NotificationReportsPage extends SafeActions implements NotificationReportsLocators {

	private WebDriver driver;
	int goalReviewsColumnsCount;
	
	public NotificationReportsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	/*
	 * To Verify whether Notification Reports tab is loaded or not 
	 */
	public void verifyNotificationReportsrPageLoaded(){
		
	String s=safeGetText(NOTIFICATIONREPORT_SUBHEADING, VERYLONGWAIT).split(" ")[0];
	Assert.assertEquals(s,"Goal Reviews and Alerts: ","Goal Reviews and Alerts: sub heading is not displayed on clicking Notification Reports");
	s=safeGetText(NOTIFICATIONREPORT_SUBHEADING, VERYLONGWAIT).split(" ")[1];
	Assert.assertEquals(s,"All","Goal Reviews and Alerts: sub heading is not displayed on clicking Notification Reports");

	}

	/*
	 * Clicks on 'All' Filter tab in Notification reports Page
	 */
	public void clickAllFiltertab() {
		safeClick(Dynamic.getNewLocator(FILTEROPTIONS_TABS, "All"), LONGWAIT);
	}

	/*
	 * Clicks on 'Last 4 Weeks' Filter tab in Notification reports Page
	 */
	public void clickLast4WeeksFiltertab() {
		safeClick(Dynamic.getNewLocator(FILTEROPTIONS_TABS, "Last 4 Weeks"), LONGWAIT);
	}

	/*
	 * Clcks on 'Last 90 Days' Filter tab in Notification reports Page
	 */
	public void clickLast90DaysFiltertab() {
		safeClick(Dynamic.getNewLocator(FILTEROPTIONS_TABS, "Last 90 Days"), LONGWAIT);
	}

	/*
	 * Verifies 'All' Filter tab is loaded in Notification reports Page
	 */
	public void verifyAllFilterPageLoaded()
	{
		boolean bAllFilterPageLoaded=isElementDisplayed(Dynamic.getNewLocator(FILTERPAGES_HEADINGS,"All"));
		Assert.assertTrue(bAllFilterPageLoaded,"Goal Reviews and Alerts:All Page is not loaded ");
		
	}
	/*
	 * Verifies 'LAst 4 weeks' Filter tab is loaded in Notification reports Page
	 */
	public void verifyLast4WeeksFilterPageLoaded()
	{
		boolean bLast4WeeksFilterPageLoaded=isElementDisplayed(Dynamic.getNewLocator(FILTERPAGES_HEADINGS,"Last 4 Weeks"));
		Assert.assertTrue(bLast4WeeksFilterPageLoaded,"Goal Reviews and Alerts:Last4WeeksFilter Page is not loaded ");
		
	}
	/*
	 * Verifies 'Last 90 Days' Filter tab is loaded in Notification reports Page
	 */
	
	public void verifyLast90DaysFilterPageLoaded()
	{
		boolean bLast90DaysFilterPageLoaded=isElementDisplayed(Dynamic.getNewLocator(FILTERPAGES_HEADINGS,"Last 90 Days"));
		Assert.assertTrue(bLast90DaysFilterPageLoaded,"Goal Reviews and Alerts:Last 90 Daysr Page is not loaded ");
		
	}
	/*
	 *To verify goal reviews->Open count  in All tab with the WTCount read from the teacher Tools->Review Page 

	 */
	
	 public void verifyGoalReviewsOpenCountinAlltab(int wtCount,String schoolName)
	 {
		 goalReviewsColumnsCount=getLocatorCount(GOALREVIEWS_SUBROWS_COUNT);
		 for(int i=1;i<=goalReviewsColumnsCount;i++)
		 {
			String goalReviewsColumnName=safeGetText(Dynamic.getNewLocator(GOALREVIEWS_SUBROWS,Integer.toString(i)),LONGWAIT);
				if(goalReviewsColumnName.equalsIgnoreCase("Open"))	
				{
					String goalReviewOpenValue=safeGetText(Dynamic.getNewLocator(SCHOOLROW_DATA, new String[]{schoolName,Integer.toString(i+2)}), LONGWAIT);
					Assert.assertEquals(goalReviewOpenValue, Integer.toString(wtCount), "Goal review And Alerts:All->Goal review open value is not matched with WT Count read from tacher tools review page");
				}
				break;
		 }
	 }
	 
	/*	
	 To verify Auto Pass->Open count  in All tab with the Auto pass count  read from the teacher Tools->Review Page 
	*/
	 public void verifyAutoPasssesOpenCountinAlltab(int AutoPassCount,String schoolName)
	 {
		 int autoPassesColumnsCount=getLocatorCount(AUTOPASSES_SUBROWS_COUNT);
		 for(int i=1;i<=autoPassesColumnsCount;i++)
		 {
			String autoPassesColumnName=safeGetText(Dynamic.getNewLocator(AUTOPASSES_SUBROWS,Integer.toString(i)),LONGWAIT);
				if(autoPassesColumnName.equalsIgnoreCase("Open"))	
				{
					String autoPassesOpenValue=safeGetText(Dynamic.getNewLocator(SCHOOLROW_DATA, new String[]{schoolName,Integer.toString(goalReviewsColumnsCount+i+2)}), LONGWAIT);
					Assert.assertEquals(autoPassesOpenValue,Integer.toString(AutoPassCount),"Goal review And Alerts:All->Auto passes open value is not matched with the Auto pass Type count read from tacher tools review page ");
					break;
				}
		 }
	 }
	
}
