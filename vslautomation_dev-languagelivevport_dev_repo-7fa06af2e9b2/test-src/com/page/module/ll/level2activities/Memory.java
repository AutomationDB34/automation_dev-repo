package com.page.module.ll.level2activities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.data.testdata.LLData;
import com.page.locators.ll.level2activities.MemoryLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;

public class Memory extends CommonFunctionalities implements MemoryLocators {

	private WebDriver driver;

	private LLData llData = new LLData();

	public Memory(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to complete the memory activity
	 */
	public void memory() {
		closeInstIcon();

		String str1[] = { llData.memoryBlueTile1, llData.memoryBlueTile2, llData.memoryBlueTile3,
				llData.memoryBlueTile4, llData.memoryBlueTile5, llData.memoryBlueTile6, llData.memoryBlueTile7,
				llData.memoryBlueTile8 };
		
		String str2[] = { llData.memoryRedTile1, llData.memoryRedTile2, llData.memoryRedTile3, llData.memoryRedTile4,
				llData.memoryRedTile5, llData.memoryRedTile6, llData.memoryRedTile7, llData.memoryRedTile8 };
		
		for(int i=0; i<8;i++){
		safeJavaScriptClick(Dynamic.getNewLocator(WORDS_BLUE_TILE, str1[i]), LONGWAIT);
		safeJavaScriptClick(Dynamic.getNewLocator(CONTRACTIONS_RED_TILE, str2[i]), LONGWAIT);

		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(WORD_BANK_TILES, str1[i])),
				"Memory pair is dispalyed in the word bank section");
		}
	}
}
