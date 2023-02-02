package Utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;

	//class="autocomplete-results-container"

	
	public AbstractComponents(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="nav-cart")
	WebElement cartButton;

	public void waitForVisibilityOfEle(WebElement searchResultsBox)
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchResultsBox));
	}
	
	public void GoToCartPage()
	{
		cartButton.click();
	}
	
	public void scroll(String command)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript(command);
	}
}
