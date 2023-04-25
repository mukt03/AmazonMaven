package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	@FindBy (xpath="//input[@id='add-to-cart-button']")
private WebElement addToCart;
	@FindBy(xpath="//input[@id='buy-now-button']")
	private WebElement buyNow;
	@FindBy (xpath="//span[@id=\"attach-sidesheet-checkout-button\"]//span//input")
	   private WebElement proceedToCheckOut;
@FindBy(xpath="//div[@id=\"attachDisplayAddBaseAlert\"]//div//h4")
private WebElement addedToCart;
@FindBy(xpath="//span[@id=\"attach-sidesheet-view-cart-button\"]//span//input")
private WebElement cart;
@FindBy (xpath="//span[@id='productTitle']")
private WebElement productTitle;
	private WebDriver driver;
	private JavascriptExecutor javascriptExecutor;
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		javascriptExecutor= (JavascriptExecutor)driver;
	}
	public void clickOnAddToCart() {
		
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",addToCart);
		//amazonsChoice.click();
		javascriptExecutor.executeScript("arguments[0].click();", addToCart);
	}
	 public void clickProceedToCheckout() {
		   proceedToCheckOut.click();
	   }
	 public String getTextAddedTocart() {
		String textOfAddedtoCart= addedToCart.getText();
		return textOfAddedtoCart;
	 }
	 public void clickOnCart() {
		 cart.click();
	 }
	 public String textofProductTitle() {
		 String title=productTitle.getText();
		 return title;
	 }
	 public void clickBuyNow() {
		 buyNow.click();
	 }
}
