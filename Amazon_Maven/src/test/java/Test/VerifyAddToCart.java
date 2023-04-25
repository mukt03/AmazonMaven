package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyAddToCart {
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName ) {
		if(browserName.equals("Chrome")) {
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MUKTA\\Documents\\velocity testing12 nov\\Selenium\\selenium installation\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		}
		if (browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\MUKTA\\Documents\\velocity testing12 nov\\Selenium\\selenium installation\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
			
		}
	}
	@BeforeClass
	public void beforeClass() {
		
	}
    @BeforeMethod
    public void beforeMethod() {
    	
    }
	@Test
	public void verifyAddToCart() {
		
	}
	@Test
	public void verifyBuyNow1() {
		
	}
	@AfterMethod
	public void verifyBuyNow(){
		
		
	}
	@AfterClass
	public void afterClass() {
		
	}
	@AfterTest
	  public void closeBrowser() {
		  System.out.println("After Test");
		  driver.quit();
	  }
	
}
