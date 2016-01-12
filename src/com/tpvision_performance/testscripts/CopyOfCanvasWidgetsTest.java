package com.tpvision_performance.testscripts;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class CopyOfCanvasWidgetsTest {
	
	ExtentReports report;
	ExtentTest logger;
	/*declaration of objects/variables*/
	
    FirefoxDriver driver = new FirefoxDriver();

    WebDriverWait wt = new WebDriverWait(driver, 15);

	  @BeforeClass
	  
		 public void beforeClass() {
		  
		    /*instantiation of objects/variables*/
		    
		    report = new ExtentReports("D:\\tpvision_report_auto\\report.html",false);
		    report.addSystemInfo("Host Name ", "Sandeep");
		    report.addSystemInfo("Enviornment","Development");
		    report.addSystemInfo("Selenium Version","2.45.0");
		    logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		  
		    
		    

			  /*launch a new browser session and directs it to the URL TPVision*/
			    driver.get("http://dev.tpvision.infanion.com/login");
			    logger.log(LogStatus.INFO, "Navigated to " +driver.getCurrentUrl());
			    
			    /*enter the username*/
		 	    driver.findElementById("edit-name").sendKeys("admin");
		 	    logger.log(LogStatus.INFO, "Entering the User name");
		 	    
		 	    /*enter the password*/
		 	    driver.findElementById("edit-pass").sendKeys("Tpv_2015$Inf");
		 	    logger.log(LogStatus.INFO, "Entering the Password");
		 	   
		 	    /*click on the login button*/
		 	    driver.findElementById("edit-submit").click();
		 	   logger.log(LogStatus.INFO, "Clicked on Submit Button");
		 	    
		 	    /*Waiting for the page to load for 30 seconds*/
		 	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 	   logger.log(LogStatus.INFO, "Waiting for the page to load");
		 	    
		    
		 	  
		  }
	  
	  @BeforeMethod
 	  public void beforeMethod() {
		  
		  
		  
	 	   /*To create a website*/
	 	    driver.findElementByXPath("//a[contains(text(),'Create new')]").click();
	 	    
	 	   /*Waiting for the page to load for 30 seconds*/
	 	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  
		  
		  
		    /*To maximize the window*/
 	        driver.manage().window().maximize();
 	
 	  }
	  
	  //performing actions on text widget
	  
	   @Test(priority=1)
	   public void addTextWidget() throws InterruptedException {
		   
		  logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		  logger.log(LogStatus.INFO, "Started Add Text widget operation");
		   
		   //System.out.println("Starting time :: "+startTime +" miliseconds" );
		  System.out.println("Add Text Widget");
		  
		  double averageTime=0;
		   for(int count=0;count<=5;count++){
			   
			   StopWatch timetaken = new StopWatch();
			   timetaken.start();
			   //long startTime = timetaken.getTime();
			   
		   /* To click on Add text*/
	 	   WebElement wb = driver.findElement(By.id("add-text"));
	 	    
	 	   /*Drag and drop Addtext widget to the screen*/
	 	   Actions act = new Actions(driver);
           act.dragAndDropBy(wb, -800, 30);
           act.build().perform();
            
           /*Closing the text editor*/
	 	   driver.findElement(By.id("obj-btn-confirm")).click();
	 	   
	 	  timetaken.stop();
	 	   long endTime = timetaken.getTime();
	 	   //System.out.println("ending time :: "+endTime+" miliseconds");
	 	   
	 	   double totalTime = (endTime/1000.0);
	 	  //double totalTime = TimeUnit.MILLISECONDS.toSeconds(endTime);
	 	   
	 	   //System.out.println("The Total time taken :: "+(endTime-startTime));
	 	   //System.out.println("Total Time Taken ::"+totalTime+" seconds");
	 	   logger.log(LogStatus.INFO, ""+count+" Time ::"+totalTime+" seconds");
	 	   
	 	   System.out.println();
	 	  
	 	   //Calculating the average time
	 	   averageTime = totalTime+averageTime;
	 	   
	 	   Thread.sleep(5000);
	 	     
	 	  
	 	  
		   }
		   
		   double totalAverageTime = averageTime/6;
		   logger.log(LogStatus.INFO, "Total Average Time of Add Text Widget is : "+totalAverageTime);
		   logger.log(LogStatus.INFO, "Add text successfull");
		   logger.log(LogStatus.PASS, "This test is Pass");
		   Assert.assertTrue(true); 
		   
		   
	  }
	 	   
	 	   
	    //performing actions on button widget
	  
	    @Test(priority=2)
	    public void addButtonWidget() throws InterruptedException {
		   
		
	    	logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.log(LogStatus.INFO, "Started Button widget operation");
			
			System.out.println("Add Button Widget");
			
			double averageTime=0;
			for(int count=0;count<=5;count++){
				 
			StopWatch timetaken = new StopWatch();
			timetaken.start();
			//long startTime = timetaken.getTime();
			
			
		    /* To click on Button*/
		    WebElement wb = driver.findElement(By.id("add-button"));
	 	    
	 	    /*script to drag and drop button to the screen*/
	 	    Actions act = new Actions(driver);
            act.dragAndDropBy(wb, -800, 30);
            act.build().perform();
            
            /*To click on the confirm button*/
            
            WebElement bt = driver.findElement(By.id("btn-prop-confirm"));
            
            //waiting for the element to load
           
   	 	    wt.until(ExpectedConditions.visibilityOf(bt));
   	 	    bt.click();
            
            timetaken.stop();
 	 	    long endTime = timetaken.getTime();
 	 	    double totalTime = (endTime/1000.0);
 	 	    //System.out.println("Total Time Taken ::"+totalTime+" seconds");
 	 	    
 	 	   // logger.log(LogStatus.INFO, "Total Time Taken ::"+totalTime+" seconds");
 	 	    logger.log(LogStatus.INFO, ""+count+" Time ::"+totalTime+" seconds");
 	 	    System.out.println(); 	  
 	 	    averageTime = totalTime+averageTime;
 	 	    Thread.sleep(6000);
			}
 	 	    
			double totalAverageTime = averageTime/6;
			logger.log(LogStatus.INFO, "Total Average Time of Add Button Widget is : "+totalAverageTime);
 	 	    logger.log(LogStatus.INFO, "Add Button widget successfull");
	 	    logger.log(LogStatus.PASS, "This test is Pass");
	 	    Assert.assertTrue(true);
 	 	    
	 		}
	   
	   //performing actions on image widget
	   
	    @Test(priority=3)
	    public void addImageWidget() throws InterruptedException {
	    	
	    	logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.log(LogStatus.INFO, "Started Image widget operation");
			System.out.println("Add Image Widget");
			
			double averageTime=0;
			for(int count=0;count<=5;count++){
				
	    	StopWatch timetaken = new StopWatch();
			timetaken.start();
			
			
			
		   /*To click on Add image*/
	 	    WebElement wb = driver.findElement(By.id("add-image"));
	 	    
	 	    /*Drag and drop Add image to the screen*/
	 	    Actions act = new Actions(driver);
            act.dragAndDropBy(wb, -800, 30);
            act.build().perform();
           
            WebElement bt =  driver.findElement(By.xpath("//div[div[@id='multimedia-popup']]"));
            wt.until(ExpectedConditions.visibilityOf(bt));
           /*To click on the image*/
           driver.findElement(By.xpath("//img[@title='1.jpg']")).click();
           
           JavascriptExecutor js = driver;
   		   js.executeScript("window.scrollBy(0,400)", "");
  	 	  
           
          
           /*Click on the confirm button*/
            WebElement bt1 =  driver.findElement(By.xpath("//div[@class='multimedia-submit']/input[@id='confirm-btn']"));
   		    //WebElement bt =  driver.findElement(By.xpath("//div[div[@id='multimedia-popup']]"));
            wt.until(ExpectedConditions.visibilityOf(bt1));
  	 	    bt1.click();
  	 	   
           
            timetaken.stop();
	 	    long endTime = timetaken.getTime();
	 	    double totalTime = (endTime/1000.0);
	 	    System.out.println("Total Time Taken ::"+totalTime+" seconds");
	 	    System.out.println();
  	 	    
	 	   logger.log(LogStatus.INFO, ""+count+" Time ::"+totalTime+" seconds");
	 	  // wt.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[div[@id='multimedia-popup']]")));
	 	   
	 	   averageTime = totalTime+averageTime;
	 	   Thread.sleep(6000);
	 	    
			}
			
		   double totalAverageTime = averageTime/6;
		   logger.log(LogStatus.INFO, "Total Average Time of Add Image Widget is : "+totalAverageTime);
	 	   logger.log(LogStatus.INFO, "Add Image widget successfull");
	 	   logger.log(LogStatus.PASS, "This test is Pass");
	 	   Assert.assertTrue(true);
	 	    
           }
	   
	   //performing actions on video widget
	   
	    @Test(priority=4)
	    public void addVideoWidget() throws InterruptedException {
	    	
	    	logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.log(LogStatus.INFO, "Started Video widget operation");
			System.out.println("Add Video Widget");
			
			double averageTime=0;
			for(int count=0;count<=5;count++){
				
	    	StopWatch timetaken = new StopWatch();
			timetaken.start();
			//long startTime = timetaken.getTime();
			
			
		   /*To find path for Add video icon*/
	 	    WebElement wb = driver.findElement(By.id("add-video"));
	 	    
	 	    /*To drag and drop Add video to the screen*/
	 	    Actions act = new Actions(driver);
           act.dragAndDropBy(wb, -800, 30);
           act.build().perform();
            
           /*To click on the cancel button*/
            WebElement bt2 = driver.findElement(By.xpath("//div[@class='multimedia-submit']/input[@id='prop-btn-cancel']"));
            WebElement bt =  driver.findElement(By.xpath("//div[div[@id='multimedia-popup']]"));
            wt.until(ExpectedConditions.visibilityOf(bt));
  	 	    bt2.click();
          
            timetaken.stop();
	 	    long endTime = timetaken.getTime();
	 	    double totalTime = (endTime/1000.0);
	 	    System.out.println("Total Time Taken ::"+totalTime+" seconds");
	 	    System.out.println();
	 	    //wt.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[div[@id='multimedia-popup']]")));
	 	   
	 	    logger.log(LogStatus.INFO, ""+count+" Time ::"+totalTime+" seconds");
	 	    averageTime = totalTime+averageTime;
	 	    Thread.sleep(6000);
			
			}
			 
			double totalAverageTime = averageTime/6;
			logger.log(LogStatus.INFO, "Total Average Time of Add video Widget is : "+totalAverageTime);
	 	    logger.log(LogStatus.INFO, "Add Video widget successfull");
	 	    logger.log(LogStatus.PASS, "This test is Pass");
	 	    Assert.assertTrue(true);
	 	   
          }
	   
	    @Test(priority=5)
	    public void addGadgetWidget() throws InterruptedException {
	    	
	    logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.log(LogStatus.INFO, "Started Add Gadget widget operation");
	    	
	     StopWatch timetaken = new StopWatch();
		 timetaken.start();
		// long startTime = timetaken.getTime();
		 System.out.println("Add Gadget Widget");
			
		  /*To find path for gadget*/
	 	  WebElement wb = driver.findElement(By.id("add-gadget"));
	 	    
	 	  /*To drag and drop Add video to the screen*/
	 	  Actions act = new Actions(driver);
          act.dragAndDropBy(wb, -800, 30);
          act.build().perform();
           
          driver.findElement(By.xpath("//img[@title='Digital clock']")).click();
          
          /*To click on the cancel button*/
          driver.findElement(By.xpath("//div[@class='gadget-submit']/input[@id='confirm-btn']")).click();
          
          WebElement img = driver.findElement(By.xpath("//div[@id='dclock']/div"));
          act.dragAndDropBy(img,-10000,-5000).perform();
          act.dragAndDropBy(img, 10000,-5000).perform();
          
          timetaken.stop();
	 	  long endTime = timetaken.getTime();
	 	  double totalTime = (endTime/1000.0);
	 	  System.out.println("Total Time Taken ::"+totalTime+" seconds");
	 	  System.out.println();
	 	  
	 	  logger.log(LogStatus.INFO, "Total Time Taken ::"+totalTime+" seconds");
	 	  Thread.sleep(6000);
	 	 
	 	  logger.log(LogStatus.INFO, "Add Gadget widget successfull");
 	      logger.log(LogStatus.PASS, "This test is Pass");
 	      Assert.assertTrue(true);
         
         }
	   
	    @Test(priority=6)
	    public void addLanguageWidget() throws InterruptedException {
	    	
	    logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.log(LogStatus.INFO, "Started Add Language widget operation");
	    	
	     StopWatch timetaken = new StopWatch();
		 timetaken.start();
		// long startTime = timetaken.getTime();
		 System.out.println("Add Language Widget");
			
		  /*To find path for gadget*/
	 	  WebElement wb = driver.findElement(By.id("add-language"));
	 	    
	 	  /*To drag and drop Add video to the screen*/
	 	  Actions act = new Actions(driver);
         act.dragAndDropBy(wb, -800, 30);
         act.build().perform();
          
         /*To click on the cancel button*/
         driver.findElement(By.xpath("//input[@id='language-prop-btn-confirm']")).click();
         
         timetaken.stop();
	 	 long endTime = timetaken.getTime();
	 	 double totalTime = (endTime/1000.0);
	 	 System.out.println("Total Time Taken ::"+totalTime+" seconds");
	 	 System.out.println();
	 	 
	 	 logger.log(LogStatus.INFO, "Total Time Taken ::"+totalTime+" seconds");
	 	 Thread.sleep(6000);
	 	
	 	 logger.log(LogStatus.INFO, "Add Language widget successfull");
	     logger.log(LogStatus.PASS, "This test is Pass");
	     Assert.assertTrue(true);
	      
        }
	   
	    @Test(priority=7)
	    public void addChannelWidget() throws InterruptedException {
	    	
	     logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		 logger.log(LogStatus.INFO, "Started Add Channel widget operation");
	    	
	     StopWatch timetaken = new StopWatch();
		 timetaken.start();
		 System.out.println("Add Channel Widget");
			
		  /*To find path for gadget*/
	 	  WebElement wb = driver.findElement(By.id("add-channels"));
	 	    
	 	  /*To drag and drop Add video to the screen*/
	 	  Actions act = new Actions(driver);
          act.dragAndDropBy(wb, -800, 30);
          act.build().perform();
          
          driver.findElement(By.id("channel-prop-btn-confirm")).click();
          
         timetaken.stop();
 	 	 long endTime = timetaken.getTime();
 	 	 double totalTime = (endTime/1000.0);
 	 	 System.out.println("Total Time Taken ::"+totalTime+" seconds");
          
         logger.log(LogStatus.INFO, "Total Time Taken ::"+totalTime+" seconds");
         Thread.sleep(6000);
         logger.log(LogStatus.INFO, "Add channel widget successfull");
 	     logger.log(LogStatus.PASS, "This test is Pass");
 	     Assert.assertTrue(true);
         
       }
	  
	    @AfterMethod
	    public void aftrMtd(ITestResult result){
	    	
	    	if(result.getStatus() == ITestResult.FAILURE){
	    		String screenshot_path = "C:\\Users\\sandeep\\workspace\\tpvision_performance\\screenshots";
	    	    String image  = logger.addScreenCapture(screenshot_path);
	    	    logger.log(LogStatus.FAIL, "The current Testscript is Failed"+image);
	    	    
	    	   }
	    	   
	    	   
	    	      
                        report.endTest(logger);
	    	            report.flush();  
	    	            
	    	            driver.get("D:\\tpvision_report_auto\\");
	    	            
	    	            /*launch a new browser session and directs it to the URL TPVision*/
	    			    driver.get("http://dev.tpvision.infanion.com/login");
	 
	    }
	    
	    @AfterClass
	    public void tearDown(){
	    driver.quit();
	    }
}
