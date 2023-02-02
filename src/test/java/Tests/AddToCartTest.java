package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.BaseTestAmazon;
import PageEvent.CartPage;
import PageEvent.CheckoutPage;
import PageEvent.ConfirmationPage;
import PageEvent.HomePage;
import PageEvent.LoginPage;
import PageEvent.ProductPage;
import PageEvent.SearchResultPage;

public class AddToCartTest extends BaseTestAmazon{

	
	@Test(dataProvider ="getData" )
	public static void AddToCart(HashMap<String, String> credentials)
	{

		/******* LANDINGPAGE *********/
		//Click sign in button
		LoginPage loginPage = launchingPage.GoToSignInPage();

		/******* LOGINPAGE *********/
		//SignIn to the account
		
		HomePage homePage= loginPage.logIn(credentials.get("email"), credentials.get("password"));
		
		/******* HOMEPAGE *********/
		//Search for the Product
		
		SearchResultPage searchResultPage = homePage.ClickItemInSearchBox();
		
		/******* PRODUCTCATLOG PAGE *********/		
		//Click on the desired Product
		
		ProductPage productPage = searchResultPage.SelectSearchedItem();
		
		/******* PRODUCT PAGE *********/	
		//Click Add to cart button
		
		CartPage cartPage =productPage.ClickAddToCartButton();

		
		//Click on cart button
		productPage.GoToCartPage();
		
		
		/******* CART PAGE *********/		
		CheckoutPage checkoutPage = cartPage.ClickProceedToCheckoutButton();
		
		
		/******* CHECKOUT PAGE *********/	
		ConfirmationPage confirmationPage = checkoutPage.PlaceOrder();

		/******* CONFIRMATION PAGE *********/	
		confirmationPage.CheckConfirmationMessage();

		
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\PlaceOrder.json");
		
		return new Object[][] {{data.get(0)}};
		
	}
}
