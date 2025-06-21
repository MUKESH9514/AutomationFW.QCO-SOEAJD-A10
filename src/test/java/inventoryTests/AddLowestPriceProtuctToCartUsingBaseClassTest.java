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

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddLowestPriceProtuctToCartUsingBaseClassTest extends BaseClass {

	@Test(groups = "RegressionSuite")

	public void tc_003_addLowestPriceProductToCart() throws IOException {

		String SORTOPTION = fUtil.readDataFromExcelFile("Products", 7, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 7, 3);

		InventoryPage ip = new InventoryPage(driver);
		String productAdded = ip.clickOnSortedProduct(driver, PRODUCTNAME, SORTOPTION);

		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		ip.clickOnCartContainer();

		// Validate in the cart Page
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();
		Assert.assertEquals(productInCart, productAdded);
		System.out.println(productInCart);

	}

	@Test
	public void sample() {
		
		System.out.println("Sample");

	}

}
