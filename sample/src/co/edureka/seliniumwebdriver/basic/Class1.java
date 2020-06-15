package co.edureka.seliniumwebdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1 {
WebDriver driver;

public void invokeBrowser() {
	try {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Redirection\\redds24\\Desktop\\WP-Extension\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://www.edureka.co");
		search();
	} catch (Exception e) {
				e.printStackTrace();
	}
 }

public void search() {
	//try {
	driver.findElement(By.className("search_inp")).sendKeys("Java");
		//WebElement abc = driver.findElement(By.id("search-inp3"));
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		//abc.sendKeys("Java");
		//driver.findElement(By.id("search-inp3")).sendKeys("Java");
//	} catch (InterruptedException e) {
		
	//	e.printStackTrace();
	//}
}
	public static void main(String[] args) {
	
  Class1 obj = new Class1();
  obj.invokeBrowser();
	}

}
