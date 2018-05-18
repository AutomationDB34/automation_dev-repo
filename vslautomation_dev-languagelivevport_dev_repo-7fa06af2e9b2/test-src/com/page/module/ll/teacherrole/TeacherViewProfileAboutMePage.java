package com.page.module.ll.teacherrole;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.teacherrole.TeacherViewProfileAboutMeLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherViewProfileAboutMePage extends CommonFunctionalities implements TeacherViewProfileAboutMeLocators{

	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());
	
	public TeacherViewProfileAboutMePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/**
	 * Purpose- To verify that View Profile->About me page is loaded successfully
	 */
	
	public void verifyThatViewProfileAboutMePageIsLoaded()
	{
		waitForPageToLoad();
		waitForSecs(20);
		Assert.assertTrue(isElementPresent(ABOUT_ME_TAB_SELECTED, LONGWAIT), "About me tab is not being displayed as highlighted upon navigating to View Profile as teacher user");
		Assert.assertTrue(isElementPresent(ABOUT_ME_CONTENT_SECTION, LONGWAIT), "About me tab content is not being displayed upon navigating to View Profile as teacher user");
		waitForPageToLoad();
		waitForSecs(10);
	}
	/**
	 * Reads Course points in a year sub tab of student 
	 * @return
	 */
	
	public String getCoursePointsCountInYear(){
		 
		return safeGetText(COURSEPOINTSCOUNT_YEAR,LONGWAIT);
		
	}
		
	/**
	 *Reads Achievements count in a year sub tab of student
	 * @return
	 */
			
	public String getAchievementsCountInYear(){
		 
		return safeGetText(ACHEIVEMENTSCOUNT_YEAR,LONGWAIT);
		
	}
	
	 /**
	  * Clicks on Edit link and enter birth place of user and save it
	  * @param birthPlace
	  */
	 public void editProfileOfUser(String birthPlace)
	 {
		 isElementPresent(EDIT_LINK,LONGWAIT);
		 //setImplicitWait(LONGWAIT);
		 safeJavaScriptClick(EDIT_LINK,LONGWAIT);
		 Assert.assertTrue(isElementPresent(EDITPROFILE_HEADING,LONGWAIT), "On clciking Edit link in About me Tab, Edit Profile Information page is not being opened");
		 safeClearAndType(BIRTHPLACE_TEXTAREA, birthPlace, LONGWAIT);
		 safeJavaScriptClick(SAVEINEDITPROFILE_BTN,LONGWAIT);
		 waitForSecs(10);
	 }
	 /**
	  * verify the profile of user is being edited or not 
	  * @param birthPlace
	  */
	 
	  public void verifyProfileOfUserAfterEdit(String birthPlace)
	  {
		  String birthPlavetext=safeGetText(BIRTHPLACELABEL_VALUE, LONGWAIT);
		  Assert.assertEquals(birthPlavetext, birthPlace,"After editing the Birth place value in Edit profile page and saving, BirthPlace value is not modified correctly ");
	  }
	
	   /**
	    * Clicks on Achievements tab
	    */
	  
	  public TeacherViewProfileAchievementsPage clickOnAchievementsTab() 
	  {
		  safeJavaScriptClick(ACHIVEMENTS_TAB,LONGWAIT);
		   return new TeacherViewProfileAchievementsPage(driver);
	  }
	  /**
	    * Clicks on Avatar Editor tab
	    */
	  
	  public TeacherViewProfileAvatarEditorPage clickOnAvatorEditorTab() 
	  {
		  isElementPresent(AVATOR_EDITOR,LONGWAIT);
		  waitForSecs(15);
		  safeJavaScriptClick(AVATOR_EDITOR,LONGWAIT);
		   return new TeacherViewProfileAvatarEditorPage(driver);
	  }

	  public void editProfileInfo(LLData lldata){
		  safeClick(FILL_OUT_PROFILE_LINK, MEDIUMWAIT);
		  waitForPageToLoad();
		  Assert.assertTrue(isElementDisplayed(EDIT_PROFILE_HEADER),"Edit profile page is not being dispalyed");
		  safeType(DISPLAYNAME_TEXTAREA, lldata.teacherLLUsername, MEDIUMWAIT);
		  safeClick(SAVE_BTN, MEDIUMWAIT);
		  
		  Assert.assertTrue(isElementDisplayed(TEACEHER_DISPLAYNAME),"Teacher display name is not being updated");

	  }
	  
	  public void viewProfileAboutMePageVerification(LLData llData) {

			if (executionMode.equalsIgnoreCase("qc")) {
				log.info("Runnig the test case at QC mode");
				verifyThatViewProfileAboutMePageIsLoaded();
			
			} else {
				log.info("Runnig the test case at RC mode");
				verifyThatViewProfileAboutMePageIsLoaded();
				editProfileInfo(llData);
				
			}

		}
}
