package com.page.module.ll.admin;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.admin.SocialSettingsLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.page.module.vport.CommonFunctionalitiesVPort;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class SocialSettingsPage extends CommonFunctionalities implements SocialSettingsLocators{

	WebDriver driver;
	public SocialSettingsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	/**
	 * Verifies Tools->social settings page is loaded or not for district user
	 */
	public void verifySocialSettingsPageLoadedForDistrictUser()
	{
		Assert.assertTrue(isElementPresent(DISTRICTSOCIALSETTINGSTAB_HEADING,LONGWAIT),"Social Settings page heading is not displayed");
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(DISRICTSOCIALSETTINGSSUB_HEADINGS, "1"),LONGWAIT),"District Social Settings","'District Social Settings' sub heading is not displayed in Tools->social settings tab ");
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(DISRICTSOCIALSETTINGSSUB_HEADINGS, "2"),LONGWAIT),"Campus Social Settings","'Campus Social Settings' sub heading is not displayed in Tools->social settings tab ");

	}
	/**
	 * Verifies Tools->social settings page is loaded or not for campus user
	 */

	public void verifySocialSettingsPageLoadedForCampusUser()
	{
		waitForPageToLoad();
		waitForSecs(3);
		Assert.assertTrue(isElementPresent(CAMPUSSOCIALSETTINGSTAB_HEADING,LONGWAIT),"Social Settings page heading is not displayed");
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCHOOLSOCIALSETTINGSSUB_HEADINGS, "1"),LONGWAIT),"School Social Settings","'School Social Settings' sub heading is not displayed in Tools->social settings tab ");
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCHOOLSOCIALSETTINGSSUB_HEADINGS, "2"),LONGWAIT),"Classroom Social Settings","'Classroom Social Settings' sub heading is not displayed in Tools->social settings tab ");

	}
	/**
	 * Disables 'Enable wall posting for all schools.' check box 
	 */
	public void disableWallpostingForAllSchoolsCheckbox()
	{
		Assert.assertTrue(isElementPresent(ENABLE_WALLPOSTINGFORALLSCHOOLS_CHECKBOX_CHECKED, LONGWAIT),"Enable wall posting for all schools checkbox is not checked initially under Social Settings page");
		safeClick(ENABLEWALLPOSTINGSCHOOLS_CHKBOX,LONGWAIT);
		safeClick(DISTRICTSOCIALSETTINGS_APPLYBTN);


	}
	/**
	 * Enables 'Enable wall posting for all schools.' check box 
	 */
	public void enableWallpostingForAllSchoolsCheckbox()
	{

		Assert.assertTrue(isElementPresent(ENABLE_WALLPOSTINGFORALLSCHOOLS_CHECKBOX_UNCHECKED, LONGWAIT),"Enable wall posting for all schools checkbox is  displayed as checked  under Social Settings page");
		safeClick(ENABLE_WALLPOSTINGFORALLSCHOOLS_CHECKBOX_UNCHECKED);
		safeClick(DISTRICTSOCIALSETTINGS_APPLYBTN);
		waitForSecs(2);
	}
	/**
	 * Disables 'Enable wall posting for all Classes' check box 
	 */

	public void disableWallpostingForAllClassesCheckbox()
	{
		Assert.assertTrue(isElementPresent(ENABLE_WALLPOSTINGFORALLCLASSES_CHECKBOX_CHECKED, LONGWAIT),"Enable wall posting for all Classes checkbox is not checked initially under Social Settings page");
		safeClick(ENABLEWALLPOSTINGSCLASSES_CHKBOX,LONGWAIT);
		safeClick(SCHOOLSOCIALSETTINGS_APPLYBTN);


	}
	/**
	 * Enables 'Enable wall posting for all Classes' check box 
	 */

	public void enableWallpostingForAllClassesCheckbox()
	{

		Assert.assertTrue(isElementPresent(ENABLE_WALLPOSTINGFORALLCLASSES_CHECKBOX_UNCHECKED, LONGWAIT),"Enable wall posting for all schools checkbox is  displayed as checked  under Social Settings page");
		safeClick(ENABLEWALLPOSTINGSCLASSES_CHKBOX);
		safeClick(SCHOOLSOCIALSETTINGS_APPLYBTN);

	}

	/**
	 * Disables 'wall' check box of school under privilege wall column in Social Settings->Campus Social Settings Table
	 */
	public void disableWallCheckboxOfSchoolInCampusSocialSettings(String schoolName)
	{
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ENABLEPRIVILAGEWALLFORSCHOOL_CHKBOX_CHECKED,schoolName),LONGWAIT),"Enable Privilage wall checkbox for the school"+schoolName+" is not checked initially under Social Settings->Campus Social Settings Table");
		safeClick(Dynamic.getNewLocator(ENABLEPRIVILAGEWALLFORSCHOOL_CHKBOX,schoolName),LONGWAIT);
		safeClick(Dynamic.getNewLocator(CAMPUSSOCIALSETTINGS_APPLYBTN,schoolName),LONGWAIT);


	}
	/**
	 * Enables 'wall' check box of school under privilege wall column in Social Settings->Campus Social Settings Table
	 */
	public void enableWallCheckboxOfSchoolInCampusSocialSettings(String schoolName)
	{
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ENABLEPRIVILAGEWALLFORSCHOOL_CHKBOX_UNCHECKED,schoolName),LONGWAIT),"Enable Privilage wall checkbox for the school"+schoolName+" is displayed as checked  under Social Settings->Campus Social Settings Table");
		safeClick(Dynamic.getNewLocator(ENABLEPRIVILAGEWALLFORSCHOOL_CHKBOX,schoolName),LONGWAIT);
		safeClick(Dynamic.getNewLocator(CAMPUSSOCIALSETTINGS_APPLYBTN,schoolName),LONGWAIT);


	}
	/**
	 * Disables 'wall' check box of teacher under privilege wall column in Social Settings->Classroom Social Settings Table
	 */
	public void disableWallCheckboxOfTeacherInClassRoomSocialSettings(String teacherName)
	{
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ENABLEPRIVILAGEWALLFORCLASS_CHKBOX_CHECKED,teacherName),LONGWAIT),"Enable Privilage wall checkbox for the teacher"+teacherName+" is not checked initially under Social Settings->Classroom Social Settings Table");
		safeClick(Dynamic.getNewLocator(ENABLEPRIVILAGEWALLFORCLASS_CHKBOX,teacherName),LONGWAIT);
		safeClick(Dynamic.getNewLocator(CLASSROOMSOCIALSETTINGS_APPLYBTN,teacherName),LONGWAIT);


	}
	/**
	 * Enables 'wall' check box of teacher under privilege wall column in Social Settings->Classroom Social Settings Table
	 */
	public void enableWallCheckboxOfTeacherInClassRoomSocialSettings(String teacherName)
	{

		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ENABLEPRIVILAGEWALLFORCLASS_CHKBOX_UNCHECKED,teacherName),LONGWAIT),"Enable Privilage wall checkbox for the teacher"+teacherName+" is displayed as checked  under Social Settings->Classroom Social Settings Table");
		safeClick(Dynamic.getNewLocator(ENABLEPRIVILAGEWALLFORCLASS_CHKBOX,teacherName),LONGWAIT);
		safeClick(Dynamic.getNewLocator(CLASSROOMSOCIALSETTINGS_APPLYBTN,teacherName),LONGWAIT);


	}

	/**
	 * Verifies Support pane is displayed in Tools->Social settings page -> Support Pane
	 */
	public void verifySupportPaneDisplayed()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(SUPPORT_PANE,MEDIUMWAIT),"Support Pane is not displayed in Tools->Social Settings page");
		setHighlight(driver.findElement(SUPPORT_PANE));
	}

	/**
	 * Verifies links in  Support pane are displayed in Tools->Social settings page 
	 */
	public void verifyLinksDisplayedInSupportPane(){
		Assert.assertTrue(isElementDisplayed(EMAILSUPPORT_LINK),"E-mail our support team link is not displayed in Support Pane of Tools->Social Settings page");
		Assert.assertTrue(isElementDisplayed(ONLINE_TRAINING_SUPPORT_LINK),"Give us feedbacklink is not displayed in Support Pane of Tools->Social Settings page");
		setHighlight(driver.findElement(EMAILSUPPORT_LINK));
		setHighlight(driver.findElement(ONLINE_TRAINING_SUPPORT_LINK));
	}

	/**
	 * Click and Verify the Online training Link
	 */
	public void clickOnOnlineTrainingAndSupport() 
	{

	}
}
