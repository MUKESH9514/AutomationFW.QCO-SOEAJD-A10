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

public class AddLowestPriceProtuctToCartTest {
	
	@Test
	
	public void tc_003_addLowestPriceProductToCart() throws IOException
	 {
		
		//Create Object of all utilities
				SeleniumUtility sUtil = new SeleniumUtility();
				FileUtility fUtil = new FileUtility();
				
				//Read the data from Property file
				
				String URL = fUtil.readDataFromPropertyFile("url");
				String USERNAME = fUtil.readDataFromPropertyFile("username");
				String PASSWORD = fUtil.readDataFromPropertyFile("password");
				
				String SORTOPTION = fUtil.readDataFromExcelFile("Products", 7, 2);
				String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 7, 3);
				
				// launch the browser
				WebDriver driver = new EdgeDriver();
				sUtil.maximizeWindow(driver);
				sUtil.addImplicitlyWait(driver);
				
				//Launch the App
				driver.get(URL);
				 
				//Login To App
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
							
        		InventoryPage ip = new InventoryPage(driver);
        		String productAdded = ip.clickOnSortedProduct(driver, PRODUCTNAME, SORTOPTION);
        		
        		InventoryItemPage iip = new InventoryItemPage(driver);
        		iip.clickOnAddToCartBtn();
        		
        		ip.clickOnCartContainer();
        		System.out.println("Hi-----");
        		
        		//Validate in the cart Page
        		CartPage cp = new CartPage(driver);
        		String productInCart = cp.getItemName();
        		
        		if (productInCart.equals(productAdded)) {
        			System.out.println("PASS");
        			System.out.println(productInCart);
					
				} else {
					System.out.println("FAIL");

				}
        		
        		//logout of APP
        		ip.logoutOfApp();
	
		
	}
	

}
