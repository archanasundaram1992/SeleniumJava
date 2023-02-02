package PageEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AbstractComponents;

public class LaunchingPage extends AbstractComponents{

	
	WebDriver driver;
	
	
	public LaunchingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//nav-link-accountList
	
	@FindBy (id="nav-link-accountList")
	WebElement SignIn;
	
	public LoginPage GoToSignInPage()
	{
		SignIn.click();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
		
	}
}
