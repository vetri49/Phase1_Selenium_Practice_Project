package com.simpilearn.seleniumtest.webelements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TimePickerTest {
	static WebDriver driver;
	public static void main(String[] args) {
		setup();
		timePickerTest();
		

		
	}
	public static void setup() {
		String siteurl="file:///D:\\Eclipse_Testing_Wokspace\\Phase1_Seleniumtest_Practice_Project\\static\\form.html";
		String driverpath="drivers/windows/geckodriver.exe";
		System.setProperty("webdriver.geckodriver.driver", driverpath);
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get(siteurl);
	}

	public static void timePickerTest() {
		WebElement timeinput=driver.findElement(By.id("time"));
		timeinput.sendKeys("12122023");
		timeinput.sendKeys(Keys.TAB);
		timeinput.sendKeys("06:00:00 PM");
	}

}
