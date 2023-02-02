package PageEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AbstractComponents;

public class ProductPage extends AbstractComponents{

	WebDriver driver;
	public ProductPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id = "add-to-cart-button")
	WebElement addToCartButton;
	
	public CartPage ClickAddToCartButton()
	{
		addToCartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	
	
	
	

}
