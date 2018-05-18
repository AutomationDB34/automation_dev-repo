package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.data.testdata.LLData;
import com.page.locators.ll.teacherrole.TeacherClassEbooksLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;

public class TeacherClassEbooksPage extends CommonFunctionalities implements TeacherClassEbooksLocators {

	private WebDriver driver;
	LLData llData = new LLData();
	
	public TeacherClassEbooksPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose- To verify the navigation to eBooks page
	 */
	
	public void verifyThatEBooksPageIsDisplayed()
	{
		waitForSecs(20, "Waiting to new Window lunch");
		waitForPageToLoad();
		switchToWindow(1);
		String pageTitle=getTitle();	
		String expectedPageTile = llData.kitabooPageTitle;//"Kitaboo Online Bookshelf";		
		Assert.assertEquals(pageTitle.toLowerCase(), expectedPageTile.toLowerCase(), "The expected page tile("+expectedPageTile+")  is not being displayed when when clicked on the menu link eBooks under Class Page.Instead it has displayed the page with the title("+pageTitle+")");
		driver.close();
		switchToWindow(0);
	}
	
}
