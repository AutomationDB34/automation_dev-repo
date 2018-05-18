package com.page.locators.vport;

import org.openqa.selenium.By;

public interface TrackFiltersLocators {
	
	By PRODUCT_NAME = By.name("productIDValues");
	By USER_TYPE = By.name("useTypeIDValues");
	By ALPHA = By.name("alphaIDValues");
	By DIST_NAME = By.name("districtSearchName");
	By UPDATELIST_BTN = By.name("Update List");

	By ADDDISTRICT_BTN = By.name("Add District");
	
	By DIST_TRACK_NAME = By.xpath("//a[contains(text() , '%s')]");
	By MASTER_ICON = By.xpath("//a[contains(text(),'%s')]/../a[contains(@title,'Master')]");
	
	By DISTRICTTRACKS_MAINHEADING=By.xpath(".//td[@title='Districts/Tracks']/a/div[2]");
	By DISTRICT_TRACKS_TAB = By.xpath("//div[@class='main_menu_nav_c_on'][contains(text(),'Districts/Tracks')]");
	
	By TRACK_PI_ICON_= By.xpath("//a[contains(text(),'%s')]/../a[contains(@name,'Vport')]");

}
