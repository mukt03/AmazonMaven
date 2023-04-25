package testNg;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNg {
	WebDriver driver;
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		System.out.println("Before Test");
		if(browserName.equals("Chrome")) {
//			ChromeOptions op=new ChromeOptions();
//			op.addArguments("--remote-allow-origins=*");
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MUKTA\\Documents\\velocity testing12 nov\\Selenium\\selenium installation\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		}
		if (browserName.equals("Edge")) {
			 
//			System.setProperty("webdriver.edge.driver", "C:\\Users\\MUKTA\\Documents\\velocity testing12 nov\\Selenium\\selenium installation\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }
  @Test
  public void test1() {
	  System.out.println("test1");
  }
  @Test
  public void test2() {
	  System.out.println("test 2");
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }
  @AfterTest
  public void closeBrowser() {
	  System.out.println("After Test");
	  driver.quit();
  }
  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }
}
