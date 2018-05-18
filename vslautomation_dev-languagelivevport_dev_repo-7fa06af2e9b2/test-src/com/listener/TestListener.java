 
package com.listener;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import ru.yandex.qatools.allure.annotations.Attachment;

import com.datamanager.ConfigManager;
import com.testng.Assert;
import com.testresults.ResultsToLocalExcel;
import com.utilities.JDBCConn;
import com.utilities.ReportSetup;
import com.utilities.ScreenCapture;
import com.utilities.UtilityMethods;

public class TestListener extends TestListenerAdapter implements ISuiteListener
{

	private  static char cQuote = '"';
	ConfigManager sys = new ConfigManager();
	ConfigManager depend = new ConfigManager("TestDependency");
	private  static String fileSeperator = System.getProperty("file.separator");
	Logger log =Logger.getLogger("TestListener");
	String runID = System.getProperty("user.name").toUpperCase()+"_"+UtilityMethods.get4DRandomNumber();
	String runType;
	private final String PASS = "PASSED";
	private final String FAIL = "FAILED";
	private final String SKIP = "SKIPPED";

	/**
	 * This method will be called if a test case is failed. 
	 * Purpose - For attaching captured screenshots and videos in ReportNG report 
	 */
	public void onTestFailure(ITestResult result)
	{
		depend.writeProperty(result.getName(),"Fail");

		log.error("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n" );
		log.error("ERROR ----------"+result.getName()+" has failed-----------------" );
		log.error("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n" );

		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver)context.getAttribute("driver");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.setCurrentTestResult(result);

		String imagepath = ".." + fileSeperator+"Screenshots" + fileSeperator + ScreenCapture.saveScreenShot(driver);
		createAttachment(driver);
		Reporter.log("<a href="+cQuote+imagepath+cQuote+">"+" <img src="+cQuote+imagepath+cQuote+" height=48 width=48 ></a>");
		ScreenCapture.stopVideoCapture(result.getName());
		UtilityMethods.verifyPopUp();
		String sValue = new ConfigManager().getProperty("VideoCapture");
		String sModeOfExecution = new ConfigManager().getProperty("ModeOfExecution");
		String sVideoPath = null;
		if(sValue.equalsIgnoreCase("true") && sModeOfExecution.equalsIgnoreCase("linear"))
		{
			sVideoPath = testCaseVideoRecordingLink(result.getName());
			Reporter.log("<a href="+cQuote+sVideoPath+cQuote+" style="+cQuote+"text-decoration: none; color: white;"+cQuote+"><div class = cbutton>Download Video</div></a>");
			Reporter.log("<font color='Blue' face='verdana' size='2'><b>"+Assert.doAssert()+"</b></font>");
			//			Reporter.log("<a color='Blue' face='verdana' size='2'><b>"+Assert.doAssert()+"</b></a>");
		}
		Reporter.setCurrentTestResult(null);
		updateResultToDb(runID, result.getMethod().getMethodName()+getParameters(result), FAIL, result.getThrowable().toString(), imagepath, sVideoPath);

	}

	/**
	 * Method to capture screenshot for allure reports
	 * @param driver , need to pass the driver object
	 * @return , returns the captured image file in the form of bytes
	 */
	@Attachment(value="Screenshot",type = "image/png")
	private byte[] createAttachment(WebDriver driver)
	{
		try
		{
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		}
		catch(Exception e)
		{
			log.error("An exception occured while saving screenshot of current browser window from createAttachment method.."+e.getCause());
			return null;
		}
	} 

	public void test()
	{

	}

	/**
	 * This method will be called if a test case is skipped. 
	 * 
	 */
	public void onTestSkipped(ITestResult result)
	{	
		//		IResultMap c = result.getTestContext().getSkippedConfigurations();
		//		IResultMap a = result.getTestContext().getSkippedTests();
		//		IResultMap f = result.getTestContext().getFailedTests();
		//		IResultMap cff = result.getTestContext().getFailedConfigurations();
		//		System.out.println(result.getMethod().isBeforeMethodConfiguration());
		//		System.out.println(result.getMethod().isBeforeClassConfiguration());
		//		System.out.println(result.getMethod().isBeforeTestConfiguration());
		//		System.out.println(result.getMethod().isBeforeSuiteConfiguration());
		//		System.out.println(result.getMethod().isBeforeGroupsConfiguration());
		//		if(result.getMethod().isBeforeMethodConfiguration()){
		//			IResultMap cf = result.getTestContext().getFailedConfigurations();
		//			System.out.println(cf);
		//		}
		//		System.out.println(c);
		//		System.out.println(a);
		//		System.out.println(f);
		//		System.out.println(f.size());
		//		System.out.println(cff);

		log.warn("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" );
		log.warn("WARN ------------"+result.getName()+" has skipped-----------------" );
		log.warn("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" );			
		updateResultToDb(runID, result.getMethod().getMethodName()+getParameters(result), SKIP, "Configuration error noticed", "----------------------", "----------------------");
		depend.writeProperty(result.getName(),"Skip");

		//************* comment below code if you are using TestNG dependency methods

		Reporter.setCurrentTestResult(result);
		ScreenCapture.stopVideoCapture(result.getName());
		UtilityMethods.verifyPopUp();
		Reporter.setCurrentTestResult(null);
	}

	/**
	 * This method will be called if a test case is passed. 
	 * Purpose - For attaching captured videos in ReportNG report 
	 */
	public void onTestSuccess(ITestResult result)
	{
		depend.writeProperty(result.getName(),"Pass");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		log.info("###############################################################" );
		log.info("SUCCESS ---------"+result.getName()+" has passed-----------------" );
		log.info("###############################################################" );
		Reporter.setCurrentTestResult(result);
		ScreenCapture.stopVideoCapture(result.getName());
		UtilityMethods.verifyPopUp();
		String sValue = new ConfigManager().getProperty("VideoCapture");
		String sModeOfExecution = new ConfigManager().getProperty("ModeOfExecution");
		String sVideoPath = null;
		if(sValue.equalsIgnoreCase("true")&&sModeOfExecution.equalsIgnoreCase("linear"))
		{
			sVideoPath = testCaseVideoRecordingLink(result.getName());
			Reporter.log("<a href="+cQuote+sVideoPath+cQuote+" style="+cQuote+"text-decoration: none; color: white;"+cQuote+"><div class = cbutton>Download Video</div></a>");
		}
		Reporter.setCurrentTestResult(null);
		updateResultToDb(runID, result.getMethod().getMethodName()+getParameters(result), PASS, "----------------------", "----------------------", sVideoPath);
	}

	/**
	 * This method will be called before a test case is executed. 
	 * Purpose - For starting video capture and launching balloon popup in ReportNG report 
	 */
	public void onTestStart(ITestResult result)
	{
		log.infoLevel("<h2>**************CURRENTLY RUNNING TEST************ "+result.getName()+"</h2>" );
		ScreenCapture.startVideoCapture();		
		UtilityMethods.currentRunningTestCaseBalloonPopUp(result.getName());
	}

	public void onStart(ITestContext context) 
	{

	}

	public void onFinish(ITestContext context) 
	{
		Iterator<ITestResult> failedTestCases = context.getFailedTests().getAllResults().iterator();
		while (failedTestCases.hasNext())
		{
			ITestResult failedTestCase = failedTestCases.next();
			ITestNGMethod method = failedTestCase.getMethod();            
			if ( context.getFailedTests().getResults(method).size() > 1)
			{
				if(sys.getProperty("KeepFailedResult").equalsIgnoreCase("false")){
					failedTestCases.remove(); 
				}
			}
			else
			{	                
				if (context.getPassedTests().getResults(method).size() > 0)
				{
					if(sys.getProperty("KeepFailedResult").equalsIgnoreCase("false")){
						failedTestCases.remove();
					}	                    
				}                          
			}            
		}

	}

	/**
	 * 
	 * To identify the latest captured screenshot
	 *
	 * @return
	 */
	public String capturedScreenShot()
	{

		File mediaFolder=new File(ReportSetup.getImagesPath());
		File[] files = mediaFolder.listFiles();
		Arrays.sort( files, new Comparator<Object>()
		{
			public int compare(Object o1, Object o2) {
				//return new Long(((File)o1).lastModified()).compareTo(new Long(((File)o2).lastModified())); // for ascending order
				return -1*(new Long(((File)o1).lastModified()).compareTo(new Long(((File)o2).lastModified()))); //for descending order 
			}
		});
		return files[0].getName();
	}

	/**
	 * 
	 * This method is used to rename the captured video with test case name
	 *
	 * @param tname , Need to pass the test case name
	 * @return, Returns the captured video path name
	 */
	public  String testCaseVideoRecordingLink(String tname)
	{	
		String sVideoPath = ".." + fileSeperator + "Videos" + fileSeperator + tname + "(1).avi";		
		if(new File(ReportSetup.getVideosPath()+fileSeperator+tname+"(1).avi").exists())
		{			
			return sVideoPath;
		}
		else
		{
			String sVideoPath2 = sVideoPath.substring(0,sVideoPath.length()-7)+".avi";
			return sVideoPath2;
		}
	}

	@Override
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub

	}
	private static boolean isRunCreated = true;
	@Override
	public void onStart(ISuite arg0) {
		if (isRunCreated) {
			if (sys.getProperty("InsertResultsIntoDB").equalsIgnoreCase("true")) {
				if (runType == null) {
					runType = sys.getProperty("RunType");
				}
				/*JDBCConn.insert("INSERT INTO TestAutomationResults (RunType, TestRunTimestamp)"
						+ "VALUES('"+ sys.getProperty("RunType")+ "', CURRENT_TIMESTAMP)");*/
				//runID = JDBCConn.select("SELECT * FROM TestAutomationResults ORDER BY TEST_TIME_STAMP DESC");
				isRunCreated = false;
			}
		}
		//		System.out.println("ISuite arg0");
		//		if (sys.getProperty("InsertResultsIntoDB").equalsIgnoreCase("true")) {
		//			if (runType == null) {
		//				runType = sys.getProperty("RunType");
		//			}
		//			JDBCConn.insert("INSERT INTO TestRunLog (RunType, TestRunTimestamp)"
		//					+ "VALUES('"+ sys.getProperty("RunType")+ "', CURRENT_TIMESTAMP)");


		//			String a = results[0][1].toString();
		//				runID = Integer.parseInt(a);
		//		}
	}

	private String getParameters(ITestResult result) {
		Object[] params = result.getParameters();
		if (params.length > 0) {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < params.length; i++) {
				buffer.append(params[i] + ", ");
			}
			System.out.println(params);
			return "[" + buffer.subSequence(0, buffer.length() - 2) + "]";
		} else
			return "";
	}


	private void updateResultToDb(String TestRunId, String TestCaseTitle, String Status, String FailStackTrace, String ImageLink, String VideoLink) {
		String CURRENT_TIMESTAMP= UtilityMethods.getCurrentDateTime();
		String DATE_VALUE = UtilityMethods.getCurrentDateTime("dd-MMM-yyyy");
		if (sys.getProperty("InsertResultsIntoExcel").equalsIgnoreCase("true")) 
		{
			//Length cutting of the stack trace
			if(FailStackTrace!=null)
			{
				if(FailStackTrace.length()>199)
				{
					FailStackTrace = FailStackTrace.substring(0, 199); 
				}
				while(FailStackTrace.contains("'"))
				{
					FailStackTrace = FailStackTrace.replace("'", "\"");
				}
			}
			String path = sys.getProperty("TestResultExcelFile");
			String oldSheet = sys.getProperty("TestResult.OLD.Sheet");
			String latestSheet = sys.getProperty("TestResult.LATEST.Sheet");
			ResultsToLocalExcel resultsToLocalExcel = new ResultsToLocalExcel(path);
		
			HashMap<String, String> columnsAndValues = new HashMap<>();
			columnsAndValues.put("RUN_ID",runID);
			columnsAndValues.put("TESTCASE_TITLE",TestCaseTitle);
			columnsAndValues.put("TEST_STATUS",Status);
			columnsAndValues.put("FAIL_STACKTRACE",FailStackTrace);
			columnsAndValues.put("TEST_TIME_STAMP",CURRENT_TIMESTAMP);
			columnsAndValues.put("TEST_DATE",DATE_VALUE);
			columnsAndValues.put("TEST_BROWSER",sys.getProperty("CurrentlyRunningBrowserName"));
			columnsAndValues.put("TEST_MACHINE",System.getenv("COMPUTERNAME")+"\\"+System.getProperty("user.name"));
			columnsAndValues.put("IMAGE_LINK",ImageLink);
			columnsAndValues.put("VIDEO_LINK",VideoLink);
			resultsToLocalExcel.insertresultRow(latestSheet, columnsAndValues);
			//JDBCConn.insert("INSERT INTO TestAutomationResults (TESTCASE_TITLE, TEST_TIME_STAMP,TEST_STATUS, FAIL_STACKTRACE, IMAGE_LINK, VIDEO_LINK)"
			//		+ "VALUES('"+TestCaseTitle+"','"+CURRENT_TIMESTAMP+"','"+Status+"','"+FailStackTrace+"', '"+ImageLink+"', '"+VideoLink+"')");
		}

	}
}