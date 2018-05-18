package com.page.module.ll.teacherrole;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.teacherrole.TeacherClassLeaderboardsLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherClassLeaderboardsPage extends CommonFunctionalities implements TeacherClassLeaderboardsLocators {

	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public TeacherClassLeaderboardsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose- To verify that leader boards page is loaded successfully
	 */

	public void verifyThatLeaderBoardsPageIsLoaded() {
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(LEADERBOARDSTAB_SELECTED, LONGWAIT),
				"Class->LeaderBoards  tab is not displayed as selected even after clicking on it");
		Assert.assertTrue(isElementPresent(LEADERBOARDS_FOOTER_SECTION, LONGWAIT),
				"Class->LeaderBoards page is not loaded");
	}

	/**
	 * Purpose- To select a level option and verify the leader boards page
	 * loading
	 * 
	 * @param classLeaderboardsLevel
	 * @throws InterruptedException
	 */

	public void selectALevelAndVerifyLeaderboardsPageLoading(String classLeaderboardsLevel) {
		waitForSecs(20, "Page Load Wait Times and waiting to load LEADERBOARDS_LEVEL_DRP");
		waitForPageToLoad();
		isElementClickable(LEADERBOARDS_LEVEL_DRP, LONGWAIT);
		safeJavaScriptClick(LEADERBOARDS_LEVEL_DRP, LONGWAIT);
		isElementClickable(Dynamic.getNewLocator(LEADERBOARDSDRP_LEVEL_OPTION, classLeaderboardsLevel), LONGWAIT);
		safeClick(Dynamic.getNewLocator(LEADERBOARDSDRP_LEVEL_OPTION, classLeaderboardsLevel), LONGWAIT);
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(LEADERBOARDS_FOOTER_SECTION, LONGWAIT),
				"Class->leaderboards page is not loaded after selecing the level option(" + classLeaderboardsLevel
						+ ")");
	}

	public void selectFiltersandVerify() {

		// Verify course points across filters
		safeClick(THIS_WEEK_FILTER, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(SELECTED_TAB), "This week tab is selected");
		safeClick(LAST_WEEK_FILTER, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(SELECTED_TAB), "Last week tab is selected");
		safeClick(SCHOOL_YEAR_FILTER, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(SELECTED_TAB), "year tab is selected");

		// verify achievements across filters
		safeClick(ACHIEVEMENTS_TAB, MEDIUMWAIT);
		waitForSecs(3);
		safeClick(THIS_WEEK_FILTER, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(SELECTED_TAB), "This week tab is selected");
		safeClick(LAST_WEEK_FILTER, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(SELECTED_TAB), "Last week tab is selected");
		safeClick(SCHOOL_YEAR_FILTER, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(SELECTED_TAB), "year tab is selected");

	}

	public void classLeaderboardsPageVerification(LLData llData) {

		if (executionMode.equalsIgnoreCase("qc")) {
			log.info("Runnig the test case at QC mode");
			selectALevelAndVerifyLeaderboardsPageLoading(llData.teacherRoleLLClassLeaderboardsLevel);

		} else {
			log.info("Runnig the test case at RC mode");
			selectALevelAndVerifyLeaderboardsPageLoading(llData.teacherRoleLLClassLeaderboardsLevel);
			selectFiltersandVerify();
		}

	}

}
