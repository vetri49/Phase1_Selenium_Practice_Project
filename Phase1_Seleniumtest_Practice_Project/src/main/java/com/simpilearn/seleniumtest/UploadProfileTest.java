package com.simpilearn.seleniumtest;

	import java.io.IOException;
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;



	public class UploadProfileTest {
		static WebDriver driver;
		static WebDriverWait wait;
		public static void main(String[] args) throws InterruptedException, IOException {
			setup();
			login();
			Thread.sleep(1000);
			uploadProfile();

		}
		public static void setup() {
			String siteurl="https://github.com/login";
			String driverpath="drivers/windows/geckodriver.exe";
			System.setProperty("webdriver.geckodriver.driver", driverpath);
			driver=new FirefoxDriver();
			wait=new WebDriverWait(driver,Duration.ofSeconds(40));
			driver.get(siteurl);
			
		}
		public static void login() {
			driver.findElement(By.id("login_field")).sendKeys(Login.username);
			driver.findElement(By.id("password")).sendKeys(Login.password);
			driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[13]")).submit();
		}
		public static void uploadProfile() throws InterruptedException, IOException {
			String siteurl="https://github.com/settings/profile";
			driver.get(siteurl);
			driver.findElement(By.xpath("//*[@id=\"settings-frame\"]/div[2]/div[2]/dl/dd/div/details/summary/div")).click();
			driver.findElement(By.xpath("//*[@id=\"settings-frame\"]/div[2]/div[2]/dl/dd/div/details/details-menu/label")).click();
			Thread.sleep(3000);
			
	       Runtime.getRuntime().exec("autoit\\upload-profile.exe");
	       System.out.println("fuck");
	      Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"avatar-crop-form\"]/div[2]/button")).click();
			driver.close();
			
			

	}

}
