package PageEvent;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AbstractComponents;

public class CheckoutPage extends AbstractComponents{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {

		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	//pp-TtPfDT-90

	@FindBy(xpath ="//span[contains(text(),'Use this payment method')[1]")
	WebElement useThisPaymentButton;
	
	
	@FindBy(name = "placeYourOrder1")
	WebElement placeOrder;
	
	public ConfirmationPage PlaceOrder()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		waitForVisibilityOfEle(placeOrder);
		placeOrder.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
	
	
}
