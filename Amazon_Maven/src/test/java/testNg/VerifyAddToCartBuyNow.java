package testNg;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import module.Account_Hidden_dropDownMenu;
import page.Home_Page;
import page.ProductPage;
import page.SearchPage;
import page.SelectAddressPayment_Page;
import page.ShoppingCartPage;
import page.SignIn;

public class VerifyAddToCartBuyNow {
	WebDriver driver;
	ProductPage productPage;
	SearchPage searchPage;
	Home_Page homePage;
	Account_Hidden_dropDownMenu accountDropDown;
	SignIn signIn;
	ShoppingCartPage shoppingCart;
	SelectAddressPayment_Page adressNpayment;
	SoftAssert asser;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
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
			
	          EdgeDriver webDriver = new EdgeDriver(); 
			System.setProperty("webdriver.edge.driver", "C:\\Users\\MUKTA\\Documents\\velocity testing12 nov\\Selenium\\selenium installation\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
			
		}
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	@BeforeClass
	public void launchBrowser() {
		
	}
    @BeforeMethod
    public void gotoProductPage() {
    	driver.navigate().to("https://www.amazon.in");
    	
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	homePage= new Home_Page(driver);
        homePage.moveToAccountandList();
        accountDropDown= new Account_Hidden_dropDownMenu(driver);
        accountDropDown.clickSignIn();
        signIn=new SignIn(driver);
        signIn.sendEmailOrPhoneNo();
        signIn.clickContinue();
        
        signIn.enterPassword();
      signIn.clickSignInButton();
      homePage.writeInsearchbox();
      homePage.clickOnSearchButton();
      searchPage=new SearchPage(driver);
      searchPage.scrollAndClickAmazonsChoice();
      productPage= new ProductPage(driver);
		asser=new SoftAssert();

    }
	@Test 
	public void verifyAddToCart() {
		//ProductPage productPage= new ProductPage(driver);
		productPage.clickOnAddToCart();
		
		String actualText=productPage.getTextAddedTocart();
		System.out.println(actualText);
		String expectedText="Added to Cart";
		//asser.assertEquals(actualText, expectedText,"Added to Cart text not verified");
	/*	if (actualText.equals(expectedText))
		{
			System.out.println("Added to cart Text verified");
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("Added to Cart text not verified");
			System.out.println("FAILED");
		}*/
		productPage.clickOnCart();
		shoppingCart=new ShoppingCartPage(driver);
		String productName=shoppingCart.getproductName();
		String actualName="CEDO Samsung M31 / F41 / M31 Prime Flip Cover | Leather Finish | Inside Pockets & Inbuilt Stand | Shockproof Wallet Style Magnetic Closure Back Cover Case for Samsung Galaxy M31 / F41 / M31 Prime (Blue)";
		shoppingCart.deleteCartItem();
		
		//asser.assertEquals(actualName, productName, "product not added to cart");
		homePage= new Home_Page(driver);
        homePage.moveToAccountandList();
		asser.assertAll();
	}
	@Test
	public void verifyBuyNowPageNoptionsDisplayed() {
		
		productPage.clickBuyNow();
		adressNpayment=new SelectAddressPayment_Page(driver);
		//SoftAssert asser=new SoftAssert();
		asser.assertEquals(driver.getCurrentUrl(),"https://www.amazon.in/gp/buy/payselect/handlers/display.html?_from=cheetah", "Payment page not dispayed");
		asser.assertEquals(adressNpayment.getCheckoutheading(), "Checkout","Checkout heading verified");
       asser.assertEquals(adressNpayment.selectAdresisDisplayed(), true, "Select Address is not displayed");
       asser.assertEquals(adressNpayment.selectPaymentisDisplayed(), true, "Select Payment is not displayed");
       asser.assertEquals(adressNpayment.itemsAndDeliveryisDisplayed(), true, "Items and delivery is not displayed");
	driver.navigate().back();
       asser.assertAll();
	}
	@AfterMethod
	public void signOutAmazon() throws InterruptedException{
		homePage= new Home_Page(driver);
        homePage.moveToAccountandList();
		accountDropDown= new Account_Hidden_dropDownMenu(driver);
	Thread.sleep(2000);
		accountDropDown.clickSignOut();
	}
	@AfterClass
	public void closeBroswer() {
		
	}
	@AfterTest
	public void closeBrowsers()
	{
		driver.quit();
	}
	
	
}
