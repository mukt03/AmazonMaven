package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page {
	@FindBy (xpath="//span[text()='Account & Lists']")
	private WebElement accountList;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;
	@FindBy(xpath="//a[@aria-label='Open Menu']")
	private WebElement allTab;
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchButton;
	@FindBy(xpath="//a[@id='icp-nav-flyout']")
	private WebElement language;
	private WebDriver driver;
	private Actions mouseAction;
	private WebDriverWait wait;// we use 
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		mouseAction= new Actions(driver);
		wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	public void moveToAccountandList() {
		
		mouseAction.moveToElement(accountList).build().perform();
	}
   public void writeInsearchbox() {
	   searchBox.sendKeys("phone cover");
   }
   public void clickOnAll() {
	  // WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	   wait.until(ExpectedConditions.visibilityOf(allTab));
	   allTab.click();
   }
	public void clickOnSearchButton() {
		wait.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
	}
	public void clickOnLanguage() {
		language.click();
	}
}
