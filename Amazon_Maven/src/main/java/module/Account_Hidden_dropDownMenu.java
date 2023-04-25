package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_Hidden_dropDownMenu {

	@FindBy (xpath="//span[text()='Sign in']")
	private WebElement signIn;
	@FindBy (xpath="//a[@id='nav-item-signout']//span")
	private WebElement signOut;
	
	public Account_Hidden_dropDownMenu(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn(){
		signIn.click();
	}
	public void clickSignOut() {
		signOut.click();
	}
}
