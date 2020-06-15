package gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sendemail {
	static WebDriver driver;

//WebDriverWait wait = new  WebDriverWait(driver, 10);
	public void invokeBrowser(String link) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Redirection\\redds24\\Desktop\\WP-Extension\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(link);
	}

	public void opengmail(String search) {
		WebElement textBox = driver.findElement(By.name("q"));
		textBox.sendKeys(search);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class = 'sbl1']/span"), search));
		List<WebElement> autosuggesttext = driver.findElements(By.xpath("//div[@class = 'sbl1']/span"));
		boolean exist = false;
		for (WebElement a : autosuggesttext) {

			if (a.getText().contentEquals("gmail")) {

				exist = true;
				a.click();
				break;
			}

		}
		if (!exist) {

			System.out.println("Unable to find search related to the search element");
		}
		driver.findElement(By.xpath("//div[@class='r']/a/h3")).click();
		driver.findElement(By.xpath("//li[@class = 'h-c-header__nav-li g-mail-nav-links'][2]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void login(String uid, String pswd) {

		// switch tabs
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs_windows.get(1));

		driver.findElement(By.name("identifier")).sendKeys(uid);
		driver.findElement(By.id("identifierNext")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		sendemail obj = new sendemail();
		String link = "http://www.google.com";
		String search = "gmail";
		String uid = "laharigj27@gmail.com";
		String pswd = "juice2722";
		obj.invokeBrowser(link);
		obj.opengmail(search);
		obj.login(uid, pswd);
		driver.close();
	}

}
