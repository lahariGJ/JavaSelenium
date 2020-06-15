package ebay;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ebay {

	public void invokeBrowser(String link, WebDriver driver) {

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		System.out.println(link);
		driver.get(link);
	}

	public void search(String search, WebDriver driver) {
		driver.findElement(By.id("gh-ac")).sendKeys(search);
		driver.findElement(By.id("gh-btn")).click();

	}

	public void AddToCart(String book1, WebDriver driver) {

		List<WebElement> books = driver.findElements(By.xpath("//a[@class='s-item__link']"));
		for (WebElement a : books) {

			if (a.getText().contains(book1)) {
				a.click();
				driver.findElement(By.id("atcRedesignId_btn")).click();
				driver.findElement(By.xpath("//span[text() = 'Go to cart']")).click();
				break;
			}
		}

	}

	public void ExporttoExcel(WebDriver driver) {
		WebElement amount = driver.findElement(By.xpath("//div[@class= 'val-col total-row']/span/span/span"));
		File file = new File("C:\\Users\\Redirection\\redds24\\Desktop\\WP-Extension\\Lahari\\Output.xlsx");
		XSSFWorkbook Wb = new XSSFWorkbook();
		XSSFSheet sh = Wb.createSheet("First Sheet");
		sh.createRow(0).createCell(0).setCellValue("Total");
		sh.getRow(0).createCell(1).setCellValue(amount.getText());

		try {
			FileOutputStream fos = new FileOutputStream(file);
			Wb.write(fos);
			Wb.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
