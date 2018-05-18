package com.page.module.ll.teacherrole;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.teacherrole.TeacherReportsScoreDetailsLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherReportsScoreDetailsPage extends SafeActions implements TeacherReportsScoreDetailsLocators {

	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public TeacherReportsScoreDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose - To verify that score details page is loaded
	 */

	public void verifyThatScoreDetailsPageIsLoaded() {
		waitForPageToLoad();
		selectFrame(SCOREDETAILS_IFRAME, LONGWAIT);
		Assert.assertTrue(isElementPresent(SCOREDETAILS_FORM, LONGWAIT),
				"Score details page under Reports tab is not loaded");
		defaultFrame();
	}

	/**
	 * Purpose is to verify scores of student 
	 * @param lldata
	 */
	public void verifyScoreDetails(LLData lldata) {
		waitForPageToLoad();
		selectFrame(SCOREDETAILS_IFRAME, LONGWAIT);
		safeClick(TIMEPERIOD, MEDIUMWAIT);
		waitForSecs(3);
		String student_score = safeGetAttribute(Dynamic.getNewLocator(SCORE, lldata.benchmark_studentname), "value", MEDIUMWAIT);

		Assert.assertEquals(student_score, lldata.studentscore,
				"The actual score" + student_score + "is not matching with the expected score" + lldata.studentscore);
		defaultFrame();
	}
	
public void reportsScoreDetailsVerification(LLData llData){
		
		if (executionMode.equalsIgnoreCase("qc")) {
			log.info("Runnig the test case at QC mode");
			verifyThatScoreDetailsPageIsLoaded();

		} else {
			log.info("Runnig the test case at RC mode");
			verifyThatScoreDetailsPageIsLoaded();
			verifyScoreDetails(llData);
		}

	}
	

}
