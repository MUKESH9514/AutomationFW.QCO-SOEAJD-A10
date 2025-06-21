package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddProductToCartTest {
	
	@Test
	public void tc_001_addProductToCart() throws IOException  {
		
		//Create Object of all utilities
		SeleniumUtility sUtil = new SeleniumUtility();
		FileUtility fUtil = new FileUtility();
		
		//Read the data from Property file
		
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 1, 2);
		
		// launch the browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		//Launch the App
		driver.get(URL);
		 
		//Login To App
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Click On Product
		
		InventoryPage ip = new InventoryPage(driver);
		String productAdded = ip.clickOnProduct(driver, PRODUCTNAME); 
		
		//Add Product to CArt
		InventoryItemPage iip= new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();
		
		//Navigate to cart
		ip.clickOnCartContainer();
		
		//Validate in the cart Page
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();
		
		if (productInCart.equals(productAdded)) {
			System.out.println("Pass");
			System.out.println(productInCart);
			
		} else {
			System.out.println("Fail");

		}
		
		//logout of APP
		ip.logoutOfApp();
	
	}

}
