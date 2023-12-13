package com.simpilearn.seleniumtest.webelements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadiobuttonTest {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		setup();
		testradiobuttonExist();
		testRadioButton1Selected();
		testRadioButton2Selected();
		Thread.sleep(2000);
		driver.close();

	}
	public static void setup() {
		String siteurl="file:///D:\\Eclipse_Testing_Wokspace\\Phase1_Seleniumtest_Practice_Project\\static\\form.html";
		String driverpath="drivers/windows/geckodriver.exe";
		System.setProperty("webdriver.geckodriver.driver", driverpath);
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get(siteurl);
	}
	public static void testradiobuttonExist() {
		WebElement male=driver.findElement(By.id("male"));
		WebElement female=driver.findElement(By.id("female"));
	
		if(male.isDisplayed()&&female.isDisplayed()) {
			System.out.println("Test is passed!");
		}else {
			System.out.println("Test is failed!");
		}
		
	}
	public static void testRadioButton1Selected() {
		WebElement male=driver.findElement(By.id("male"));
		male.click();
		if(male.isSelected()) {
			System.out.println("Radio button1 selected test is passed!");
		}else {
			System.out.println("Radio button1 selected test is failed!");
		}
	}
	public static void testRadioButton2Selected() {
		WebElement female=driver.findElement(By.id("female"));
		female.click();
		if(female.isSelected()) {
			System.out.println("Radio button2 selected test is passed!");
		}else {
			System.out.println("Radio button2 selected test is failed!");
		}
	}
	
}
