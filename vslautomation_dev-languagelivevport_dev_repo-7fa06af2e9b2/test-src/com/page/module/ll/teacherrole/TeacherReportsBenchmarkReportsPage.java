package com.page.module.ll.teacherrole;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.teacherrole.TeacherReportsBenchmarkReportsLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherReportsBenchmarkReportsPage extends SafeActions implements TeacherReportsBenchmarkReportsLocators {

	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public TeacherReportsBenchmarkReportsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose - To verify that Benchmarks Reports tab page is loaded
	 */

	public void verifyThatBenchmarksReportsPageIsLoaded() {
		waitForPageToLoad();
		selectFrame(BENCHMARKREPORTS_IFRAME, LONGWAIT);
		Assert.assertTrue(isElementPresent(BENCHMARKSREPORTS_FORM, LONGWAIT),
				"Benchmarks Reports page under Reports tab is not loaded");
		defaultFrame();
	}

	public void verifyBenchmarkScores(LLData lldata){
		
		selectFrame(BENCHMARKREPORTS_IFRAME, LONGWAIT);
		//safeClick(TIMEPERIOD_DROPDOWN, MEDIUMWAIT);
		
		//safeClick(UPDATE_BTN, MEDIUMWAIT);
		String student_score = safeGetText(Dynamic.getNewLocator(SCORE, lldata.benchmark_studentname), MEDIUMWAIT);

		Assert.assertEquals(student_score, lldata.studentLexilescore,
				"The actual score is not matching with the expected score");
		defaultFrame();
		
	}

public void reportsBenchmarksReportsVerification(LLData lldata){
		
		if (executionMode.equalsIgnoreCase("qc")) {
			log.info("Runnig the test case at QC mode");
			verifyThatBenchmarksReportsPageIsLoaded();

		} else {
			log.info("Runnig the test case at RC mode");
			verifyThatBenchmarksReportsPageIsLoaded();
			verifyBenchmarkScores(lldata);
		}

	}
}
