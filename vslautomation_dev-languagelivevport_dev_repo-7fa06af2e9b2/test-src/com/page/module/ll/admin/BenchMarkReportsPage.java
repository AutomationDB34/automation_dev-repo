package com.page.module.ll.admin;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.admin.BenchMarkReportsLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class BenchMarkReportsPage extends SafeActions implements BenchMarkReportsLocators {

	WebDriver driver;
	public BenchMarkReportsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	/**
	 * To select school from All schools drop down in Bench mark reports page
	 * @param schoolName
	 */
	public void selectSchoolFromAllSchools(String schoolName)
	{
		waitForPageToLoad();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		safeJavaScriptClick(Dynamic.getNewLocator(ALLSCHOOLS_DRPDOWN,"All Schools"), LONGWAIT);

		safeClick(Dynamic.getNewLocator(ALLSCHOOLS_DRPDOWN,schoolName), LONGWAIT);

	}
	/**
	 * To verify un matched score in Benchmark reports->scores table 
	 * @param schoolName
	 * @param PARB1Score
	 * @param TOSCRFB1Score
	 * @param TWS4B1Score
	 */
	public void verifyUnMatchedScoresForStudent(String schoolName,String PARB1Score, String TOSCRFB1Score, String TWS4B1Score)
	{
		waitForPageToLoad();
		if(!PARB1Score.equalsIgnoreCase(" ")&&!TOSCRFB1Score.equalsIgnoreCase(" ") &&!TWS4B1Score.equalsIgnoreCase(" ")){
			isElementPresent(Dynamic.getNewLocator(SCHOOLROW_DATA, new String[]{schoolName,"2"}),VERYLONGWAIT);
			String value=safeGetText(Dynamic.getNewLocator(SCHOOLROW_DATA, new String[]{schoolName,"2"}),LONGWAIT);
			Assert.assertEquals(value,PARB1Score,"PARB1 Score is not matched with the score read from Vport->My Results->Key Mesaures Page");

			value=safeGetText(Dynamic.getNewLocator(SCHOOLROW_DATA, new String[]{schoolName,"8"}),LONGWAIT);
			Assert.assertEquals(value,TOSCRFB1Score,"TOSCRFB1  Score is not matched with the score read from Vport->My Results->Key Mesaures Page");

			value=safeGetText(Dynamic.getNewLocator(SCHOOLROW_DATA, new String[]{schoolName,"14"}),LONGWAIT);
			Assert.assertEquals(value,TWS4B1Score,"TWS4B1  Score is not matched with the score read from Vport->My Results->Key Mesaures Page");
		}
		else{
			
		}
	}
	/**
	 * clicks on Matched check box in Benchmark reports->scores table
	 */
	public void clickMatchedCheckBox()
	{
		safeCheck(MATCHED_CHKBOX,LONGWAIT);
	}
	/**
	 *  To verify matched score in Benchmark reports->scores table 
	 * @param schoolName
	 * @param PARB1Score
	 * @param TOSCRFB1Score
	 * @param TWS4B1Score
	 */
	public void verifyMatchedScoresForStudent(String schoolName,String PARB1Score, String TOSCRFB1Score, String TWS4B1Score)
	{
		if(!PARB1Score.equalsIgnoreCase(" ") && !TOSCRFB1Score.equalsIgnoreCase(" ") && !TWS4B1Score.equalsIgnoreCase(" "))
		{
			isElementPresent(Dynamic.getNewLocator(SCHOOLROW_DATA, new String[]{schoolName,"2"}),VERYLONGWAIT);
			String value=safeGetText(Dynamic.getNewLocator(SCHOOLROW_DATA, new String[]{schoolName,"2"}),LONGWAIT);
			Assert.assertEquals(value,PARB1Score,"PARB1 Score is not matched with the score read from Vport->My Results->Key Mesaures Page");
			value=safeGetText(Dynamic.getNewLocator(SCHOOLROW_DATA, new String[]{schoolName,"8"}),LONGWAIT);
			Assert.assertEquals(value,TOSCRFB1Score,"TOSCRFB1  Score is not matched with the score read from Vport->My Results->Key Mesaures Page");
			value=safeGetText(Dynamic.getNewLocator(SCHOOLROW_DATA, new String[]{schoolName,"14"}),LONGWAIT);
			Assert.assertEquals(value,TWS4B1Score,"TWS4B1  Score is not matched with the score read from Vport->My Results->Key Mesaures Page");
		}
		else
		{
			Assert.assertTrue(isElementDisplayed(NOMATCHED_SCORES), "no matched scores for the school message is not being dispalyed");
		}
	}


}
