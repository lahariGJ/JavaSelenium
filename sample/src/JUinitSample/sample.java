package JUinitSample;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import samplejson.JUnitTestReporter;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class sample  extends JUnitTestReporter {

	private static WebDriver driver;
	  private static StringBuilder output = new StringBuilder("");
	  
	@BeforeClass
	public static void setUp() {
		// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Redirection\\redds24\\Desktop\\WP-Extension\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	
    @Test 
    public void thirdTest() {
    	System.out.println("1");
        output.append("b");
    }
 
    @Test 
    public void secondTest() {
    	System.out.println("2");
        output.append("c");
    }
	
	@Test
    public void firstTest() {
		System.out.println("3");
        output.append("a");
    }

	@AfterClass
	public static void close() {
		System.out.println(output.toString());
		//assertEquals(output.toString(), "cab");
		driver.quit();
	}

}
