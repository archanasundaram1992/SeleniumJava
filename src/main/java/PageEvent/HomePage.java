package PageEvent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AbstractComponents;


public class HomePage extends AbstractComponents{

	WebDriver driver;

	public HomePage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy (css =".s-suggestion-container div:nth-child(1)")
	List<WebElement> ddList;
	

	@FindBy(css=".autocomplete-results-container")
	WebElement searchResultsBox;
	
	
	public SearchResultPage ClickItemInSearchBox()
	{
		searchBox.click();
		searchBox.sendKeys("potting soil");
		//wait till element visiblility
		waitForVisibilityOfEle(searchResultsBox);
		
		//.s-suggestion-container div
		try {
				WebElement ItemFromDD = ddList.stream().filter(s->s.getText().equalsIgnoreCase("potting soil indoor plants")).findFirst().orElse(null);		
				ItemFromDD.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebElement ItemFromDD = ddList.stream().filter(s->s.getText().equalsIgnoreCase("potting soil indoor plants")).findFirst().orElse(null);			
			ItemFromDD.click();
		}
		SearchResultPage searchResultPage =new SearchResultPage(driver);
		return searchResultPage;
		
	}

}
