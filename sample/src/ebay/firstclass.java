package ebay;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstclass {

	static WebDriver driver;

	public void method(WebDriver driver, String link, String search, String book1, String book2) {

		ebay obj = new ebay();

		obj.invokeBrowser(link, driver);
		obj.search(search, driver);
		obj.AddToCart(book1, driver);
		obj.search(search, driver);
		obj.AddToCart(book2, driver);
		obj.ExporttoExcel(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Properties prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Redirection\\redds24\\Desktop\\WP-Extension\\Lahari\\eclipse-workspace\\sample\\config.properties");
			prop.load(ip);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String link = prop.getProperty("link");
		String search = prop.getProperty("search");
		String book1 = prop.getProperty("book1");
		String book2 = prop.getProperty("book2");

		firstclass fc = new firstclass();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Redirection\\redds24\\Desktop\\WP-Extension\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		fc.method(driver, link, search, book1, book2);
		driver.close();
	}

}
