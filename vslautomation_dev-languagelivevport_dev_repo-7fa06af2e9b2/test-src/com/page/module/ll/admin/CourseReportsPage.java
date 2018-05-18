package com.page.module.ll.admin;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.admin.CourseReportsLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class CourseReportsPage extends SafeActions implements CourseReportsLocators{

	WebDriver driver;
	
	public CourseReportsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/*
	 * To Select school from 'All Schools' drop down
	 */
	public void selectSchoolFromAllSchools(String schoolName) {
		
		isElementPresent(Dynamic.getNewLocator(ALLSCHOOLS_DRPDOWN, "All Schools"),VERYLONGWAIT);
		safeJavaScriptClick(Dynamic.getNewLocator(ALLSCHOOLS_DRPDOWN, "All Schools"), LONGWAIT);
		waitForSecs(8);
		safeJavaScriptClick(Dynamic.getNewLocator(ALLSCHOOLS_DRPDOWN, schoolName), LONGWAIT);

	}

	/*
	 * To verify 'All Classes' dropdown enabled after selecting a school
	 */
	public void verifyAllClassesDropdownDisplayed() {
		waitForPageToLoad();
		boolean bAllClassesDrpdwnDisplayed = isElementPresent(Dynamic.getNewLocator(ALLCLASSES_DRPDOWN, "All Classes"),LONGWAIT);
		Assert.assertTrue(bAllClassesDrpdwnDisplayed,"All Classes Dropdown is not enabled after selecting school from schools dropdown");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
 * To Selects class from 'All classes' drop down
 */
 public void selectClassFromAllClasses(String className)
 {
	 isElementPresent(Dynamic.getNewLocator(ALLCLASSES_DRPDOWN,"All Classes"), LONGWAIT)  ;
	 safeJavaScriptClick(Dynamic.getNewLocator(ALLCLASSES_DRPDOWN,"All Classes"), LONGWAIT);  
	   safeClick(Dynamic.getNewLocator(ALLCLASSES_DRPDOWN,className+" LL"), LONGWAIT);
	 	   
 }
 /*
  * To select Word training option from 'Display scores for' dropdown
  */
   public void selectWordTraining()
   {
	   waitForPageToLoad();
	   isElementPresent(Dynamic.getNewLocator(DISPLAYSCORESFOR_DRPDOWN, "Word Training"),LONGWAIT);
	   safeClick(Dynamic.getNewLocator(DISPLAYSCORESFOR_DRPDOWN, "Word Training"),LONGWAIT);
	   safeClick(Dynamic.getNewLocator(WORDTRAINING_DRPDOWN, "Word Training"),LONGWAIT);
   }
   
   /*
    * To select Text training option from 'Display scores for' drop down
    */

   public void selectTextTraining()
   {
	   waitForPageToLoad();
	   isElementPresent(Dynamic.getNewLocator(DISPLAYSCORESFOR_DRPDOWN, "Word Training"),LONGWAIT);
	   safeClick(Dynamic.getNewLocator(DISPLAYSCORESFOR_DRPDOWN, "Word Training"),LONGWAIT);
	   safeClick(Dynamic.getNewLocator(WORDTRAINING_DRPDOWN, "Text Training"),LONGWAIT);
   }
   /*
    * To Verify Student Average score  in Word Training Lesson scores table  
    */
   public void verifyWordTrainingStudentAverage(String studName, String studentAvg)
   {
	   waitForPageToLoad();
	   isElementPresent(Dynamic.getNewLocator(STUDENTROW_DATA,new String[]{studName,"3"}),LONGWAIT);
	   String txt=safeGetText(Dynamic.getNewLocator(STUDENTROW_DATA,new String[]{studName,"3"}), LONGWAIT);
	   Assert.assertEquals(txt, studentAvg,"Word training-> Student Average Score is not matched ");
   }
   /*
    * To verify Unit1-Lessons score in Word Training Lesson scores table
    */
   public void verifyWordTrainingUnit1LessonsScore(String studName, String l1Score, String l2Score,String l3Score,String l4Score)
   {
	   String txt=safeGetText(Dynamic.getNewLocator(STUDENTROW_DATA,new String[]{studName,"4"}), LONGWAIT);
	   Assert.assertEquals(txt, l1Score,"Word training-> unit1->Lesson1 Score is not matched  ");
	   txt=safeGetText(Dynamic.getNewLocator(STUDENTROW_DATA,new String[]{studName,"5"}), LONGWAIT);
	   Assert.assertEquals(txt, l2Score,"Word training-> unit1->Lesson2 Score is not matched  ");
	   txt=safeGetText(Dynamic.getNewLocator(STUDENTROW_DATA,new String[]{studName,"6"}), LONGWAIT);
	   Assert.assertEquals(txt, l3Score,"Word training-> unit1->Lesson3 Score is not matched  ");
	   txt=safeGetText(Dynamic.getNewLocator(STUDENTROW_DATA,new String[]{studName,"7"}), LONGWAIT);
	   Assert.assertEquals(txt, l4Score,"Word training-> unit1->Lesson4 Score is not matched  ");
   }
   /*
    * To Verify Student Average score  in text  Training Power passes scores table  
    */
   public void verifyTextTrainingStudentAverage(String studName, String studentAvg)
   {
	   String txt=safeGetText(Dynamic.getNewLocator(STUDENTROW_DATA,new String[]{studName,"3"}), LONGWAIT);
	   Assert.assertEquals(txt, studentAvg,"Text training-> Student Average Score is not matched ");
   }
   /*
    * To Verify unit1-Lessons score in text  Training Power passes scores table  
    */
   public void verifyTextTrainingUnit1Score(String studName, String unit1Score)
   {
	   String txt=safeGetText(Dynamic.getNewLocator(STUDENTROW_DATA,new String[]{studName,"4"}), LONGWAIT);
	   Assert.assertEquals(txt, unit1Score,"Word training-> unit1->Lesson1 Score is not matched  ");
	   
   }
 
 	
}
