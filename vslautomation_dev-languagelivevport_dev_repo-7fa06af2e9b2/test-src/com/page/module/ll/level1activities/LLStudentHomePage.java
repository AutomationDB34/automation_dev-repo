package com.page.module.ll.level1activities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.locators.ll.level1activites.LLStudentHomePageLocators;
import com.page.module.ll.teacherrole.TeacherViewProfileAboutMePage;
import com.selenium.Dynamic;
import com.selenium.SafeActions;

public class LLStudentHomePage extends SafeActions implements LLStudentHomePageLocators  {

	WebDriver driver;
	String progressDetails[] = new String[4];
	
	public LLStudentHomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void verifyLLStudentHomePage()
	{
		waitForPageToLoad(LONGWAIT);
		Assert.assertTrue(isElementPresent(WTSTART_BUTTON,LONGWAIT),"WT->Start Say Sounds section is not displayed in Student LL Home Page");
	}
	 public TeacherViewProfileAboutMePage navigateToViewProfile() 	
	 {
		 	isElementPresent(USER_DROPDOWN,LONGWAIT);
			safeActionsClick(USER_DROPDOWN, LONGWAIT);
			safeClick(VIEWPROFILE_LINK, MEDIUMWAIT);
			return new TeacherViewProfileAboutMePage(driver);
		}

	 /**
	  * Purpose of this method is to click on the Class link 
	  */
	public void clickOnClassLink() {
		safeClick(CLASS_LINK, LONGWAIT);
	}
	
	/**
	 * Purpose is to verify the class wall 
	 */
	public void verifyClassPage(){
		Assert.assertTrue(isElementDisplayed(CLASS_WALL),"Class wall is not dispalyed after clicking the class link");
	}
	
	 /**
	  * Purpose of this method is to click on the My Scorecard link and get student progress
	 * @return 
	  */
	public String[] clickOnMyScoreCardandGetProgress(){
		safeClick(MYSCORECARD_LINK, LONGWAIT);
		
		for(int i=0; i<4; i++){
			progressDetails[i]=safeGetText(Dynamic.getNewLocator(SCORECARD_DETAILS, Integer.toString(i+2)), MEDIUMWAIT);
		}
		
		return progressDetails;
	}
	
	
}


