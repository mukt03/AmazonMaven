package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	@FindBy(xpath="//span[@class='a-truncate-cut']")
    private WebElement productName;
	@FindBy(xpath="(//input[@data-action='delete'])[1]")
	private WebElement delete;
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String getproductName() {
		
		String NameOfProduct=productName.getText();
		
		return NameOfProduct;
		}
	public void deleteCartItem() {
		delete.click();
	}
	}
	

