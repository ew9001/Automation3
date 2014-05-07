package com.trihonda.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class RequestQuote  {
	static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	Sheet s; 	
	WebDriver driver;
	
	String folder = "";
	String name="Y://TrHondaTestNG1/RequestQuote" + timeStamp + "/" + "hondacar.png";
	String local=(new java.io.File("").getAbsolutePath());
	String data="" + local + "/" + "infoqa.xls";
	 @Test(groups = {"first"})
	    @Parameters({"param"})
	    public void testMe(String param) {
	
	        System.out.println("Wow you ripped it: " + param);
	        driver = new FirefoxDriver();
			//((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
			driver.manage().window().maximize();
			try {
	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        String folder = "";
	    	String name="Y://TrHondaTestNG1/RequestQuote" + timeStamp + "/" + "hondacar.png";
	    	String local=(new java.io.File("").getAbsolutePath());
	    	String data="" + local + "/" + "infoqa.xls";
	    	System.out.println("Data path is : " + data);
	        
	    	FileInputStream fi = null;
			try {
				fi = new FileInputStream(data);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Workbook w = null;
			try {
				w = Workbook.getWorkbook(fi);
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s = w.getSheet(0);
			for(int row=1; row <=s.getRows();row++) {
				String urlname = s.getCell(0, row).getContents();
				System.out.println("Data path is : " + urlname);
		
				driver.get(urlname);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("div.no-offer-callout-details > a.request-button.blue-button > span")).click();
			    driver.findElement(By.id("fname")).clear();
			    driver.findElement(By.id("fname")).sendKeys("TestFirst");
			    driver.findElement(By.id("lname")).clear();
			    driver.findElement(By.id("lname")).sendKeys("TestLast");
			    driver.findElement(By.id("email")).clear();
			    driver.findElement(By.id("email")).sendKeys("donotreply@pkt.com");
			    driver.findElement(By.id("zipcode")).clear();
			    driver.findElement(By.id("zipcode")).sendKeys("11413");
			    driver.findElement(By.id("phone")).clear();
			    driver.findElement(By.id("phone")).sendKeys("2122222222");
			    driver.findElement(By.cssSelector("div.button > button.blue-button")).click();
			    File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    try {
					FileUtils.copyFile(scrFile1, new File(name));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println("Inside Name function?");
			    System.out.println(name);
			    System.out.println("My Lolal is: ");
			    System.out.println(new java.io.File("").getAbsolutePath());
		    	System.out.println(RequestQuote.class.getClassLoader().getResource("").getPath());
		    	Reporter.log("<a href='"+ local+"/" + name + "'> <img src='"+ local+"/"+ name + " ' height='100' width='100'/>" + "<a href='"+ urlname+"'>'"+ urlname+"'</a> " + " </a>");
			}
			System.out.println("I'm finished running tes test?");
			driver.quit();
			  try {
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        
	    }
	 

	 
	 
	
	 
	 
}
