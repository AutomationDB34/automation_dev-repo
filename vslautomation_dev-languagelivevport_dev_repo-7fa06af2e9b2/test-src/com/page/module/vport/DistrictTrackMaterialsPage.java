
package com.page.module.vport;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.datamanager.ConfigManager;
import com.page.locators.vport.DistrictTrackMaterialsLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class DistrictTrackMaterialsPage extends SafeActions implements DistrictTrackMaterialsLocators {
	
	private WebDriver driver;
	ConfigManager sysConfig = new ConfigManager();
	
	//constructor to define or call methods
	
	public DistrictTrackMaterialsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;			
	}
	
	/**
	 * Purpose- To click on district track link
	 * @throws Exception
	 */
	public void clickDistrictTrack(String trackName)
	{
	safeClick(By.partialLinkText(trackName),LONGWAIT);
	waitForPageToLoad(LONGWAIT);	
	}
	
	
	/**
	 * Purpose- To verify whether the Materials page is displayed or not
	 */
	public void verifyMaterialsPage()
	{
	boolean licenceTypeDropdownExists=isElementPresent(LICENCETYPE_DRP,MEDIUMWAIT);
	
	Assert.assertTrue(licenceTypeDropdownExists,"Licence Type dropdown is not being displayed on Materials page or unable to navigate to Materials page");
	}
	
	/**
	 * Purpose- To verify the available licences on Materials page
	 * @throws Exception
	 */
	public void verifyAvailableLicencesOnMaterialsPage() 
	{
		List<WebElement> licenceTypeDropdownOptions= safeGetOptionsInDropDown(LICENCETYPE_DRP, LONGWAIT);
		
		List<WebElement> licencePurchaseSummaryRecords = LocatorWebElements(LICENCEPURCHASESUMMARYRECORDS_LIST);
		
		Assert.assertEquals(licenceTypeDropdownOptions.size(), licencePurchaseSummaryRecords.size()-2, "Number of licence types("+licenceTypeDropdownOptions.size()+") in licence type dropdown is not equal to Number of licences in purchase summary("+licencePurchaseSummaryRecords.size()+")");
		
		boolean isRecordMatched=false;		

		for(int i=0;i<licenceTypeDropdownOptions.size();i++)
		{
			String licenceTypeName = licenceTypeDropdownOptions.get(i).getText();
													
			for(int k=2;k<licencePurchaseSummaryRecords.size();k++)
			{
				String licencePurchaceRecorName = licencePurchaseSummaryRecords.get(k).getText();
									
				if(licenceTypeName.equalsIgnoreCase(licencePurchaceRecorName))
				{						
					isRecordMatched=true;
				
					break;
				}
			}
			
			if(isRecordMatched)
			{				
				isRecordMatched=false;				
			}
			else
			{
				Assert.haultonfailure=false;
				
				Assert.assertTrue(isRecordMatched, "The licence type option--"+licenceTypeName+"--available in licence type dropdown on material page didn't find under Purchase summary section on the same page");
			}								
		}
		Assert.assertAll();
	}
	
	/**
	 * Purpose- To add and verify the available licences on Materials page
	 * @throws Exception 
	 */
	public void addAndVerifyLicences(String licencegradeleve, String licenceseatcount,String reasonroraddingLicence, String expectedlicencealertmessage, String reasonforlicencetextfieldimagepath)
	{
		List<WebElement> licenceTypeDropdownOptions= safeGetOptionsInDropDown(LICENCETYPE_DRP, LONGWAIT);
		
		for(int i=0;i<licenceTypeDropdownOptions.size();i++)
		{
			List<WebElement> reInitializeLicenceTypeDropdownOptions= safeGetOptionsInDropDown(LICENCETYPE_DRP, LONGWAIT);
			
			String licenceName = reInitializeLicenceTypeDropdownOptions.get(i).getText();
									
			safeSelectOptionInDropDownByVisibleText(LICENCETYPE_DRP, licenceName, LONGWAIT);
			
			safeSelectOptionInDropDownByVisibleText(LICENCEGRADELEVEL_DRP,licencegradeleve,LONGWAIT);
			
			safeType(LICENCESEATCOUNT_FIELD, licenceseatcount, LONGWAIT);
						
			if(sysConfig.getProperty("CurrentlyRunningBrowserName").contentEquals("internet explorer")){
				scrollIntoElementView(ADDALICENCE_HEADER);
				safeClickUsingSikuli(reasonforlicencetextfieldimagepath, "clicking in Reason for licence text field using sikuli", LONGWAIT);
				safeTypeUsingSikuli(reasonroraddingLicence, MEDIUMWAIT);
			}
			else{
				safeType(REASONFORCREATINGLICENCE_FIELD, "  "+reasonroraddingLicence, LONGWAIT);
			}
			safeClick(ADDLICENCE_BTN, LONGWAIT);
			Assert.assertTrue(isAlertPresent(LONGWAIT), "Alert message didn't appear after clicking 'Add licence' button on Materials page");
			Assert.assertEquals(getAlertMessage(), expectedlicencealertmessage, "Alert message text("+getAlertMessage()+") being displayed after clicking add licence button didn't match with the expected text("+expectedlicencealertmessage+")");
			acceptAlert();
			waitForSecs(5, "Waiting to alert should go");
			//waitForPageToLoad(LONGWAIT);
			int updatedTotalLicenceCount=Integer.parseInt(safeGetText(Dynamic.getNewLocator(TOTALLICENCECOUNTOFALICENCE_TABLE, licenceName), LONGWAIT));
			Assert.haultonfailure=false;
			int latestenteredcount = Integer.parseInt(licenceseatcount);
			Assert.assertEquals(updatedTotalLicenceCount, latestenteredcount, "The updated count--"+updatedTotalLicenceCount+"--doesn't match with entered seatcount--"+latestenteredcount);
		}
		Assert.assertAll();
	}
	
	/**
	 * Purpose- To navigate to Technology Page
	 * @throws Exception	 */
	
	public DistrictTrackTechnologyPage clickOnTechnologyTab()
	{
		safeClick(TECHNOLOGY_TAB, LONGWAIT);		
		return new DistrictTrackTechnologyPage(driver);		
	}
	
	public VportTrackFilterPage navigateToFiltersPage() {
		safeClick(LOGO_ICON, MEDIUMWAIT);
		return new VportTrackFilterPage(driver);
	}
	
}
