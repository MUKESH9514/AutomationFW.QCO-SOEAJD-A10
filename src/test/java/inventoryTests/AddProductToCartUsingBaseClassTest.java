package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;


@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartUsingBaseClassTest extends BaseClass {
	
	
	@Test (groups = "SmokeSuite")
	public void tc_001_addProductToCart() throws IOException  {
		
		
		// Read the data from Excel
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 1, 2);
	
		//Click On Product
		
		InventoryPage ip = new InventoryPage(driver);
		String productAdded = ip.clickOnProduct(driver, PRODUCTNAME); 
		Assert.fail();
		
		//Add Product to CArt
		InventoryItemPage iip= new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();
		
		//Navigate to cart
		ip.clickOnCartContainer();
		
		//Validate in the cart Page
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();		
		Assert.assertEquals(productInCart, productAdded);
		System.out.println(productInCart);
		
	
	}
	

}
