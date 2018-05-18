
package com.page.module.vport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.datamanager.ConfigManager;
import com.page.locators.vport.VportLoginLocators;
import com.selenium.SafeActions;
import com.selenium.Sync;
import com.testng.Assert;


public class VportLoginPage extends CommonFunctionalitiesVPort implements VportLoginLocators {

	private WebDriver driver;
	ConfigManager app;
	Logger log = Logger.getLogger(getClass());

	//constructor to define or call methods
	public VportLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;			
	}




	/**
	 * Purpose- To enter login credentilas i.e., username and password 
	 * @param vportUsername- we pass username of VPORT application
	 * @param vportPassword- we pass passowrd of VPORT application
	 * @throws Exception
	 */
	public void enterLoginCredentials(String vportUsername, String vportPassword)
	{
		safeClearAndType(USERNAME_FIELD ,vportUsername, SHORTWAIT);
		safeClearAndType(PASSWORD_FIELD ,vportPassword, SHORTWAIT);	
	}

	/**
	 * Purpose- To click on Login In button
	 * @throws Exception
	 */
	public Object clickSignInButton(ReturnPage returnPage)
	{
		safeClick(LOGIN_BTN, SHORTWAIT);
		waitForPageToLoad(LONGWAIT);
		switch (returnPage) {
		case FILTERPAGE:
			return new VportTrackFilterPage(driver);
		case PRIVACYPAGE:
			return new DistrictAdminPrivacyPage(driver);
		case MYDISTRICPAGE:
			return new DistrictAdminHomepage(driver);
		case MYDISTRICTRESULTSPAGE:
			return new DistrictAdminMyResultsPage(driver);
		default:
			return null;
		}

	}

	public enum ReturnPage{FILTERPAGE, PRIVACYPAGE, MYDISTRICPAGE,MYDISTRICTRESULTSPAGE};

	/**
	 * Verify the foot titles
	 */
	public void verifyfooterTitles(String footTitleNames[])
	{
		String expected[] = footTitleNames;
		List<WebElement> footerTitles = LocatorWebElements(FOOTER_TITLES);
		log.info(Arrays.asList(expected));
		for(WebElement el : footerTitles)
		{
			Assert.assertTrue(Arrays.asList(expected).contains(el.getText().toString()),"Exepected link in not prasent on the Loging page"
					+ "Expected List : "+Arrays.asList(expected)+" Not contains "+el.getText().toString());
			setHighlight(el);
		}		
	}


	/**
	 * Verify the VSL logo is displayed
	 */
	public void verifyVSLLogo() 
	{
		waitForSecs(4);
		Assert.assertTrue(isElementPresent(VSL_LOGO, MEDIUMWAIT), "The VSL Logo is not Loaded ");
		setHighlight(driver.findElement(VSL_LOGO));
		Assert.assertTrue(isElementPresent(LOGIN_LOGO, MEDIUMWAIT), "The Login Logo is not Loaded ");
		setHighlight(driver.findElement(LOGIN_LOGO));

	}



	/**
	 * Verifieng the links
	 */
	public void verifyForgetPasswordLinkAndFunctionality() 
	{	
		Assert.assertTrue(isElementPresent(FORGET_PASSWORD_LINK, MEDIUMWAIT), "Forget Password link is not available");
		setHighlight(driver.findElement(FORGET_PASSWORD_LINK));
		safeClick(FORGET_PASSWORD_LINK, MEDIUMWAIT);
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(FORGET_PASSWORD_USERNAME, MEDIUMWAIT), "User name Text field is not available on Forgot Password Page");
		setHighlight(driver.findElement(FORGET_PASSWORD_USERNAME));
		Assert.assertTrue(isElementPresent(FORGET_PASSWORD_RETRIEVEPASSWORD_BTN, MEDIUMWAIT), "Retrieve password button is not available on Forgot Password Page");
		setHighlight(driver.findElement(FORGET_PASSWORD_RETRIEVEPASSWORD_BTN));
		Assert.assertTrue(isElementPresent(FORGET_PASSWORD_EMAILE, MEDIUMWAIT), "Email Text field is not available on Forgot Password Page");
		setHighlight(driver.findElement(FORGET_PASSWORD_EMAILE));
		Assert.assertTrue(isElementPresent(FORGET_PASSWORD_RETRIEVEUSER_ID_BTN, MEDIUMWAIT), "Retrieve User ID button is not available on Forgot Password Page");
		setHighlight(driver.findElement(FORGET_PASSWORD_RETRIEVEUSER_ID_BTN));
		Assert.assertTrue(isElementPresent(FORGET_PASSWORD_BACKTO_HOMEPAGE_LINK, MEDIUMWAIT), "Back To home Page link is not available on Forgot Password Page");
		setHighlight(driver.findElement(FORGET_PASSWORD_BACKTO_HOMEPAGE_LINK));
		safeClick(FORGET_PASSWORD_BACKTO_HOMEPAGE_LINK, MEDIUMWAIT);
		waitForPageToLoad();
	}



/**
 * Verification of system check
 */
	public void verifySystemCheckAndList() 
	{
		Assert.assertTrue(isElementPresent(SYSTEM_CHECK_LINK, MEDIUMWAIT), "System Check link button is not available");
		setHighlight(driver.findElement(SYSTEM_CHECK_LINK));
		safeClick(SYSTEM_CHECK_LINK, MEDIUMWAIT);
		waitForPageToLoad();
		List<WebElement> bc_pass = LocatorWebElements(SYSTEM_CHECK_LIST_PASS);
		for(WebElement e : bc_pass)
		{
			setHighlight(driver.findElement(SYSTEM_CHECK_LIST_PASS));
			Assert.assertTrue(isElementPresent(SYSTEM_CHECK_LIST_PASS),"SYSTEM_CHECK_LIST_PASS is not available");
		}
		//safeClick(SYSTEM_CHECK_LINK, MEDIUMWAIT);
		safeJavaScriptClick(SYSTEM_CHECK_LINK, MEDIUMWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * Verify Learn More Link
	 */
	public void verifyLearnMoreLink(String vslURL)
	{
		Assert.assertTrue(isElementPresent(LEARN_MORE, MEDIUMWAIT), "Learn More link button is not available");
		setHighlight(driver.findElement(LEARN_MORE));
		String actual = safeGetAttribute(LEARN_MORE, "href", MEDIUMWAIT);
		Assert.assertEquals(actual, vslURL,"VSL URL is not as expected on Learn More link");
	}
}
