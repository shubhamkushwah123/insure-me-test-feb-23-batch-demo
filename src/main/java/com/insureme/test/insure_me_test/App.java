package com.insureme.test.insure_me_test;

import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	
    	//load driver
    	 //  System.setProperty("webdriver.chrome.driver", "/Users/shubham/Documents/softwares/chrome-driver/chromedriver");
	      
	    WebDriverManager.chromedriver().setup();
    	
    	//setup configuration
	     ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--headless");
	      
	      WebDriver driver = new ChromeDriver(chromeOptions);
	      
	      System.out.println("Scripted Executing");
	        
	      //1. Open the browser and get to the url
	      driver.get("http://18.217.141.224:8081/contact.html");
	      
    	//load application
	      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	//locate element
	      //locate name and enter name
	      driver.findElement(By.id("inputName")).sendKeys("Shubham");
	      
	      
	      //locate phone number and enter phone number
	      driver.findElement(By.id("inputNumber")).sendKeys("9999999999");
	      
	      
	      //locate phone number and enter phone number
	      driver.findElement(By.id("inputMail")).sendKeys("shubham@xyz.com");
	      
	      //locate Message and enter Message
	      driver.findElement(By.id("inputMessage")).sendKeys("shubham@xyz.com");
	      
	      //submit the form
	      driver.findElement(By.id("my-button")).click();
	      
	      //read response
	      String response = driver.findElement(By.id("response")).getText();
	      
	      System.out.println(response);
	
    	//validate response
    	
    	//capture result
	      
	      TakesScreenshot scrShot = ((TakesScreenshot)driver);
	      	
	      	File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
	      	
	      	File destFile = new File("test-report.jpg");
	      	
	      	FileUtils.copyFile(srcFile, destFile);
        
	      driver.quit();
	      
	      

	      
    }
}
