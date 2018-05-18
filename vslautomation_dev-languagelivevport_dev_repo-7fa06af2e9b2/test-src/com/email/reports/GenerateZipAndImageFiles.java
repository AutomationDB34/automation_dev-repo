package com.email.reports;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.base.BrowserProvider;
public class GenerateZipAndImageFiles {


	public static String RESULT_FILENAME = "Reports.png";
	public static String ZIP_Filename = "TestResults.zip";
	static WebDriver driver;
	static String sInputDirectoryToZip = System.getProperty("user.dir")
			+ "\\Automation Reports\\LatestResults";
	static String sOutputDirectory = System.getProperty("user.dir")
			+ "\\Target\\TestResults.zip";
	static String htmlFile = System.getProperty("user.dir")
			+ "\\Automation Reports\\LatestResults\\html\\index.html";
	static String newFile = System.getProperty("user.dir")
			+ "\\Automation Reports\\LatestResults\\html\\";

	/**
	 * This method is to add Zip file along with Image.
	 * @throws IOException
	 */
	public void addZipAndImage() throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream(sOutputDirectory);
			ZipOutputStream zos = new ZipOutputStream(fos);
			// level - the compression level (0-9)
			zos.setLevel(9);

			System.out.println("Begin to compress folder : "
					+ sInputDirectoryToZip + " to " + sOutputDirectory);
			addFolder(zos, sInputDirectoryToZip, sInputDirectoryToZip);
			zos.close();
			System.out.println("Zipped Successfully");
			BrowserProvider browserProvider = new BrowserProvider();
			driver = browserProvider.getBrowserInstance("chrome").init();
			System.out.println(htmlFile);
			System.out.println(newFile);
			driver.get(htmlFile);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(newFile+RESULT_FILENAME));
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is to add Folder.
	 * @param zos
	 * @param folderName
	 * @param baseFolderName
	 * @throws Exception
	 */
	private static void addFolder(ZipOutputStream zos, String folderName,
			String baseFolderName) throws Exception {
		File f = new File(folderName);
		if (f.exists()) {
			if (f.isDirectory()) {
				if (!folderName.equalsIgnoreCase(baseFolderName)) {
					String entryName = folderName.substring(
							baseFolderName.length() + 1, folderName.length())
							+ File.separatorChar;
					System.out.println("Adding folder entry " + entryName);
					ZipEntry ze = new ZipEntry(entryName);
					zos.putNextEntry(ze);
				}
				File f2[] = f.listFiles();
				for (int i = 0; i < f2.length; i++) 
				{
					if(!(f2[i].toString()).contains("Videos"))
					
						addFolder(zos, f2[i].getAbsolutePath(), baseFolderName);
					
				}
			} else {

				//Sathish: Changed ON:15-02-2017:  New feature in Google email .JS files also will not be allowed 
				//https://support.google.com/mail/?p=BlockedMessage
				String exten = getFileExtension(f);
				if(!exten.equalsIgnoreCase("js"))
				{
					// add file
					// extract the relative name for entry purpose
					String entryName = folderName.substring(
							baseFolderName.length() + 1, folderName.length());
					System.out.print("Adding file entry " + entryName + "...");
					ZipEntry ze = new ZipEntry(entryName);
					zos.putNextEntry(ze);

					FileInputStream in = new FileInputStream(folderName);
					int len;
					byte buffer[] = new byte[1024];
					while ((len = in.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
					in.close();
					zos.closeEntry();
					System.out.println("OK!");
				}
			}
		} else {
			System.out.println("File or directory not found " + folderName);
		}
	}


	/**
	 * fINDS THE EXTENSION OF A FILE
	 * @param file
	 * @return
	 */

	private static String getFileExtension(File file) {
		String name = file.getName();
		try {
			return name.substring(name.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}
}

