package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage {
	
	@FindBy (xpath="//input[@aria-labelledby='orderSummaryPrimaryActionBtn-announce']")
	private WebElement useAddress;
	//adress radio button//*[@id="address-list"]/div/div[1]/div/fieldset[1]/div[1]/span/div/label/input
   public AddressPage(WebDriver driver) {
	   
   }
}
