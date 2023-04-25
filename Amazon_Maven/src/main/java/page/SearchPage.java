package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	@FindBy(xpath="//*[@id=\"B084TKZFCB-amazons-choice-label\"]/span/span[1]")
	private WebElement amazonsChoice;
	private WebDriver driver;
	private JavascriptExecutor js;
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		js= (JavascriptExecutor)driver;
	}
	
	public void scrollAndClickAmazonsChoice() {
		
		js.executeScript("arguments[0].scrollIntoView(true);",amazonsChoice);
		amazonsChoice.click();
	}
}
