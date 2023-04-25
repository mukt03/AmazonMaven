package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectAddressPayment_Page {

	@FindBy (xpath="//div[@id='header']//div//div[3]//h1")
	private WebElement checkoutHeading;
	@FindBy (xpath="(//h3[@data-testid])[2]")
	private WebElement selectAddress;
	@FindBy (xpath="(//h3[@data-testid])[3]")
	private WebElement selectPaymentMethod;
	@FindBy (xpath="(//h3[@data-testid])[4]")
	private WebElement itemsAndDelivery;
	//private WebDriver driver;
	public SelectAddressPayment_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		//this.driver=driver;
		
	}
	public String getCheckoutheading() {
	return(checkoutHeading.getText());	
	}
	public boolean selectAdresisDisplayed() {
		return(selectAddress.isDisplayed());
	}
	public void clickselectAdres() {
		selectAddress.click();
	}
	public boolean selectPaymentisDisplayed() {
		return(selectPaymentMethod.isDisplayed());
	}
	public boolean itemsAndDeliveryisDisplayed() {
		return(itemsAndDelivery.isDisplayed());
	}
}
