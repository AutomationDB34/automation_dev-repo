package com.page.module.ll.level1activities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.page.locators.ll.level1activites.SoundLibraryLocators;
import com.testng.Assert;

public class SoundLibrary extends CommonFunctionalities implements SoundLibraryLocators{
	
	private WebDriver driver;
	private LLData llData = new LLData();
	
	public SoundLibrary(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/*
	 * Purpose of this method is to verify if new Sound library modal is displayed or not and close the modal if displayed
	 * */
	public void verifyNewSoundLibModal(LLData llData){
		
		isElementPresent(NEW_SOUND_LIB_MODAL);
		safeClickUsingSikuli(llData.SOUNDLIBRARY_IMAGE, "New Sound Library nodal close" , LONGWAIT);
	}
	
	/*
	 * Purpose of this method is to verify the consonants and vowels unlocked and check the count
	 * */
	public void checkSoundLibrary(){
		
		//click the Consonants tab in the Sound library
		safeClick(CONSONANTS_TAB);
		
		// get the  count of the Consonants unlocked
		List<WebElement> consonants_count = LocatorWebElements(UNLOCKED_CCONSONANTS_CARDS);
		int countC = consonants_count.size();
				
		System.out.println("Number of consonants unlocked are: " +  consonants_count.size());
		Assert.assertEquals(consonants_count.size(), 4, "Number of consonants unlocked are not as expected");
		
		String consonantssounds= driver.findElement(SOUNDS_UNLOCKED).getText();
		System.out.println("consonants sound:" + consonantssounds);
		
		String consonantsspellings= driver.findElement(SPELLINGS_UNLOCKED).getText();
		System.out.println("consonants spellings: "+ consonantsspellings);
		
		String soundsC = consonantssounds.substring(9, 11);
		System.out.println(soundsC);
		
		//Verify the consonants unlocked count with the count displayed in the sound library header 
		if(soundsC.contains(Integer.toString(countC)))
		{
			
			System.out.println("Consonants Sound cards unlocked are matching with the sounds count dispalyed in the top of the Sound library modal, which is equal to " + soundsC );
		}
		
		//click the Vowels tab in the Sound library
		safeClick(VOWELS_TAB);
		
		// get the count of the Vowels unlocked
		List<WebElement> vowels_count = LocatorWebElements(UNLOCKED_VOWEL_CARDS);
		int countV = vowels_count.size();
		System.out.println("Number of vowels unlocked are " +  vowels_count.size());
		
		String vowelssounds= driver.findElement(SOUNDS_UNLOCKED).getText();
		System.out.println("consonants sound:" + vowelssounds);
		
		String vowelsspellings= driver.findElement(SPELLINGS_UNLOCKED).getText();
		System.out.println("consonants spellings: "+ vowelsspellings);
		
		String soundsV = vowelssounds.substring(9, 11);
		System.out.println(soundsV);
		
		//Verify the vowels unlocked count with the count displayed in the sound library header 
		if(soundsV.contains(Integer.toString(countV))){
			
			System.out.println(" Vowels Sound cards unlocked are matching with the sounds count dispalyed in the top of the Sound library modal, which is equal to " + soundsV );
		}
	
	}
}
