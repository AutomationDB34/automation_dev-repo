package com.page.locators.vport;
import org.openqa.selenium.By;

public interface DistrictTrackMaterialsLocators {

	
	public static By ADDALICENCE_HEADER = By.xpath("//td[text()='Add a License']");
	public static By LICENCETYPE_DRP = By.id("newLicenseTypeID");
	public static By LICENCEGRADELEVEL_DRP = By.name("newLicenseGradeLevelID");	
	public static By LICENCESEATCOUNT_FIELD = By.id("newLicense_");
	public static By REASONFORCREATINGLICENCE_FIELD = By.id("newLicenseReason");
	public static By ADDLICENCE_BTN = By.xpath(".//input[@src='/vip/assets/images/buttons/add_license.jpg']");
	public static By LICENCEPURCHASESUMMARYRECORDS_LIST = By.xpath(".//div[@id='printSection']//table[2]//tr[4]//table//td[1]"); 
	public static By TOTALLICENCECOUNTOFALICENCE_TABLE = By.xpath("//td[contains(text(),'%s')]/../*[last()]");	
	public static By TECHNOLOGY_TAB = By.name("view_by_technology");
	By LOGO_ICON = By.xpath("//img[@id='headerIcon']");

}
