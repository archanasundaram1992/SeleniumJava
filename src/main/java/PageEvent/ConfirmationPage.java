package PageEvent;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="(//div/ h4)[2]")
	WebElement orderConfirmationMessage;
	
	public void CheckConfirmationMessage()
	{
		assertTrue(orderConfirmationMessage.getText().contains("Order placed, thanks!"));
	}

}
