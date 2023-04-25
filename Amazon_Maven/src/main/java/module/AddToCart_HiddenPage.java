package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart_HiddenPage {
   @FindBy (xpath="(//input[@aria-labelledby='attach-sidesheet-checkout-button-announce'])[1]")
   private WebElement proceedToCheckOut;
   
   public AddToCart_HiddenPage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
   }
	   public void clickProceedToCheckout() {
		   proceedToCheckOut.click();
	   }
   }



