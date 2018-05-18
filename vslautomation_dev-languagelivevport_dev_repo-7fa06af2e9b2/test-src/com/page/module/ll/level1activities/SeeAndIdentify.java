package com.page.module.ll.level1activities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.SeeAndIdentifyLocators;
import com.testng.Assert;

public class SeeAndIdentify extends CommonFunctionalities implements SeeAndIdentifyLocators{
	private WebDriver driver;
	ConfigManager config = new ConfigManager("App");
	Logger log = Logger.getLogger(getClass());

	public SeeAndIdentify(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


	/**
	 * Purpose of the method is to verify the loading of the activity
	 * */
	public void verifySeeAndIdentifyActivity(){

		//Verify the presence of the Activity container
		Assert.assertTrue(isElementPresent(ACTIVITY_CONTAINER, LONGWAIT), "Activity is not being displayed");
	}

	/**
	 * Purpose of the method is to perform QC on one bundle
	 * */
	public void SeeAndIdentifyActivity(){
		closeInstIcon();

		if(config.getProperty("App.ExecutionMode").equalsIgnoreCase("RC"))
		{
			log.info("RC mode started for See And Identify Activity");
			for(int i =0;i<3;i++)
			{
				safeClick(RADIO_BTN_1);
				Assert.assertTrue(isElementDisplayed(CHECK_MARK), "Check mark after answering the bundle is not being displayed");
				String radiobtn = driver.findElement(RADIO_BTN_2).getAttribute("disabled");
				System.out.println(radiobtn);
				if(radiobtn.equals("true"))
				{
					log.info("The other opiton is disabled");
				}
			}
		}
		else
		{
			log.info("QC mode started for See And Identify Activity");
			safeClick(RADIO_BTN_1);
			Assert.assertTrue(isElementDisplayed(CHECK_MARK), "Check mark after answering the bundle is not being displayed");
			String radiobtn = driver.findElement(RADIO_BTN_2).getAttribute("disabled");
			System.out.println(radiobtn);
			if(radiobtn.equals("true"))
			{
				log.info("The other opiton is disabled");
			}
		}
	}

}
