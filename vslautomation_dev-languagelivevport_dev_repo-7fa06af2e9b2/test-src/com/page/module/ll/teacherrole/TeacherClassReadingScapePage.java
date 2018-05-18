package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.locators.ll.teacherrole.TeacherClassReadingScapeLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;

public class TeacherClassReadingScapePage extends CommonFunctionalities implements TeacherClassReadingScapeLocators{

	private WebDriver driver;
	
	public TeacherClassReadingScapePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose- To verify the navigation to Reading Scape page
	 */
	
	public void verifyThatReadingScapePageIsDisplayed()
	{
		waitForSecs(20, "Waiting for ReadingScape window");
		switchToWindow(1);
		Assert.assertTrue(isElementPresent(READINGSCAPE_BOOKS_SECTION, LONGWAIT), "ReadingScape window is not displayed");
		driver.close();
		switchToWindow(0);
	}
	
}
