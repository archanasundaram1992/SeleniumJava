package PageEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AbstractComponents;

public class LoginPage extends AbstractComponents{
	
	WebDriver driver;
	public LoginPage(WebDriver driver)		//constructor method

	{
		super(driver);
		this.driver = driver;		//Assigns driver value with the driver value passed in this method
		PageFactory.initElements(driver, this);			//pass the driver value to @Findby(pagefactory)
		
		
	}
	@FindBy (id="ap_email")
	WebElement emailWE;
	
	@FindBy(css=".a-button-input")
	WebElement continueButton;
	
	@FindBy(id="ap_password")
	WebElement passwordWE;
	
	@FindBy(className = "a-button-input")
	WebElement submit;
	
	public HomePage logIn(String email, String password)
	{
		emailWE.sendKeys(email);
		continueButton.click();
		passwordWE.sendKeys(password);
		submit.click();
		HomePage homePage =new HomePage(driver);
		return homePage;
	}
	

}
