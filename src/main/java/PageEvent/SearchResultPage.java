package PageEvent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.AbstractComponents;

public class SearchResultPage extends AbstractComponents{
	
	WebDriver driver;

	public SearchResultPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	
	@FindBy(xpath ="//div[@data-component-type='s-search-result']")
	List<WebElement> ProductList;
	
	public ProductPage SelectSearchedItem()
	{

		WebElement Product = ProductList.stream().filter(s->s.findElement(By.cssSelector("h2")).getText().equals("Miracle-Gro Indoor Potting Mix, 16 qt.")).findFirst().orElse(null);
		Product.findElement(By.cssSelector("a")).click();
		ProductPage productPage =new ProductPage(driver);
		return productPage;
	}

}





