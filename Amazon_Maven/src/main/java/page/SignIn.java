package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

	@FindBy(xpath="//input[@name='email']")
	private WebElement emailOrPhoneNo;
	@FindBy (xpath="//input[@type='submit']")
	private WebElement continueButton;
	@FindBy (xpath="//input[@name='password']")
	private WebElement password;
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement signInButton;
	public SignIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void sendEmailOrPhoneNo(){
		emailOrPhoneNo.sendKeys("8427962040");
	}
	public void clickContinue() {
		continueButton.click();
	}
	public void enterPassword() {
		password.sendKeys("mittuuspc@31");
	}
	public void clickSignInButton() {
		signInButton.click();
	}
}
