package com.google.search;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//Env variable
//Implicit and explicit wait - no threads
//create more variables

public class linkclick {
	WebDriver driver;

	public void InvokeBrowser(String link, String search, String result) {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Redirection\\redds24\\Desktop\\WP-Extension\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(link);
			search(search, result);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void search(String search,String result) {
		try {
			WebElement textBox = driver.findElement(By.name("q"));
			textBox.sendKeys(search);
			Thread.sleep(1000);
			WebDriverWait wait = new  WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class = 'sbl1']/span"), search));
			List<WebElement> autosuggesttext = driver.findElements(By.xpath("//div[@class = 'sbl1']/span"));
			boolean exist = false;
			for (WebElement a : autosuggesttext) {

				if (a.getText().contentEquals("facebook")) {

					exist = true;
					a.click();
					break;
				}

				
			}
			if (!exist) {
				
				System.out.println("Unable to find search related to the search element");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.close();
			// use esc key and google search button
			/*
			 * textBox.sendKeys("facebook"); Thread.sleep(1500);
			 * textBox.sendKeys(Keys.ESCAPE); Thread.sleep(1500); driver.findElement(By.
			 * xpath("//div[@class=\"FPdoLc tfB0Bf\"]//input[@value = \"Google Search\"]")).
			 * click();
			 */

			// click first link of search results
			// driver.findElement(By.xpath("//div[@class='r']/a/h3")).click();

			// click last link of search results
			/*
			 * List<WebElement> results
			 * =driver.findElements(By.xpath("//div[@class='r']/a/h3"));
			 * results.get(results.size()-1).click();
			 */

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String link = "http://www.google.com";
		String search = "faceb";
		String result = "facebook";
		linkclick obj = new linkclick();
		obj.InvokeBrowser(link, search, result);

	}

}
