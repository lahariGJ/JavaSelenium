package com.google.search;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Google {
	WebDriver driver;

	public void InvokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Redirection\\redds24\\Desktop\\WP-Extension\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://google.com");
			search();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void search() {
		WebElement textBox = driver.findElement(By.name("q"));
		textBox.sendKeys("test");
		textBox.sendKeys(Keys.ENTER);
		List<WebElement> results = driver.findElements(By.xpath("//div[@class='r']/a/h3"));

		for (WebElement a : results) {
			String s = "";

			if (a.getText().toLowerCase().contains("test")) {
				s = "yes ";
			} else

			{
				s = "no ";

			}

			System.out.print(s);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Google obj = new Google();
		obj.InvokeBrowser();

	}

}
