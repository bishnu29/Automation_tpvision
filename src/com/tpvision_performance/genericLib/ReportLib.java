package com.tpvision_performance.genericLib;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Sandeep Surendran
 *
 */





public class ReportLib {
	
	/**
	 * 
	 * @param fileName
	 * @throws IOException
	 * @description
	 *                         The  takeScreenShot() method is used to get the Screenshot at runtime
	 *                         takeScreenShot() uses one parameter i.e String fileName
	 */   
	
	
	static WebDriver driver;
	
	
	public static  String  captureScreenshot(String fileName) {
		
	  try{
		  
	               TakesScreenshot ts = (TakesScreenshot)driver;
					File source = ts.getScreenshotAs(OutputType.FILE);
					
					/*     Create a new File    */
					String  dest = "C:\\Users\\sandeep\\workspace\\tpvision_performance\\screenshots\\"+fileName+".png";
					File destinationFile  = new File(dest);
					
					/*Copy ScreenShot to new File using Apache API */
					FileUtils.copyFile(source, destinationFile);
					System.out.println("Screenshot Taken");
					return dest;
					
		
		
		
		}catch(Exception e){
			
			System.out.println("Exception While taking Screenshot"+e.getMessage());
			return e.getMessage();
			
		}
	
	
	}
}
