package com.page.locators.vport;

import org.openqa.selenium.By;

public interface DistrictAdminHomeLocators 
{
	By SCREENTITLE=By.xpath(".//div[@class='screenTitle']/b[%s]");
	By SCHOOL_DRPDOWN=By.id("msdrpdd21_msdd");
	By SCHOOLNAME_OPTION = By.xpath(".//div[@id='msdrpdd21_msdd']//li//span[contains(text(),'%s')]");
	By MYSCHOOL_TAB=By.xpath(".//div[contains(text(),'My School')]");
	By MYCLASS_TAB=By.xpath(".//div[contains(text(),'My Class')]");
	By T2RICONINRESOURCES=By.xpath("//img[@src='/vip/assets/images/resources/PP-NAT/t2rf.png']");
	By eBooksICONINRESOURCES=By.xpath("//img[@src='/vip/assets/images/resources/PP-NAT/kitaboo.png']");

	By TABS_ALL = By.xpath("//td[@class='main_menu_nav_container']");
	By ACTIVE_TAB = By.xpath(".//div[@class='main_menu_nav_c_on']");
	By NEXT_TAB = By.xpath("(.//div[@class='main_menu_nav_c_off'])[%s]");
	By SUBTABS_ALL =By.xpath(".//table[@class='subTabMargin']/tbody/tr/td[2]/a/nobr");
	By NEXT_SUBTAB =By.xpath("(.//table[@class='subTabMargin']/tbody/tr/td[2])[%s]/a/nobr");

	By MY_RESULTS_TAB = By.xpath("//div[contains(text(),'My Results')]");

	
	
}
