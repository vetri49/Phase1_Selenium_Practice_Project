package com.simpilearn.seleniumtest.booking;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BookingTest {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		String siteurl="https://www.tripadvisor.com";
		String driverpath="drivers/windows/geckodriver.exe";
		System.setProperty("webdriver.geckodriver.driver", driverpath);
		driver=new FirefoxDriver();
		driver.get(siteurl);
		Thread.sleep(2000);
		searchbarTest();
	
		linkTest();
		driver.close();
		
		

	}
	public static void searchbarTest() {
		String expectedTitle="Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test is passed!");
		}else {
			System.out.println("Test is failed!");
		}
		takeScreenshot("homepage.png");
		System.out.println("Expected Title is : "+expectedTitle);
		
		System.out.println("Actual title is : "+driver.getTitle());
		
	}
	public static void linkTest() {
		WebElement link=driver.findElement(By.xpath("//*[@id=\"lithium-root\"]/main/div[3]/div[1]/button[4]"));
		link.click();
		String expectedTitle="Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Link Test is passed!");
		}else {
			System.out.println("Test is failed!");
		}
		takeScreenshot("linkTest.png");
		System.out.println("Expected Title is : "+actualTitle);
		
		System.out.println("Actual Title is : "+driver.getTitle());
		
	}
	public static void takeScreenshot(String fileName) {
       TakesScreenshot tsc = (TakesScreenshot) driver ;
		File src = tsc.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("screenshot-outputs\\"+fileName));
		} catch (IOException e) {
			e.printStackTrace();
	}
	

}
}