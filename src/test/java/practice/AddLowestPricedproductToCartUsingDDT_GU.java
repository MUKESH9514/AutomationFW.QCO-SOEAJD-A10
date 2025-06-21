package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddLowestPricedproductToCartUsingDDT_GU {

	public static void main(String[] args) throws IOException, InterruptedException {

		// create Object of all utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();

		// read required data from properties file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		// read data from excel file
		String SORTOPTION = fUtil.readDataFromExcelFile("Products", 7, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 7, 3);
		
		System.out.println(SORTOPTION+"====>"+PRODUCTNAME);

		// launch the browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		// load the apps
		driver.get(URL);
		//Login to App directly
		
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
		// (or)Login to app using POM
		
		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		
		//(or)
		lp.loginToApp(USERNAME, PASSWORD);

		// sort the page for lowest price
		WebElement prodSort = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		//sUtil.handleDropDown(SORTOPTION, prodSort);
		sUtil.handleDropDown(SORTOPTION, prodSort);
		Thread.sleep(2000);

		// click on the lowest priced prod
		WebElement product = driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']"));
		String productToBeAdded = product.getText();
		product.click();

		// Add to cart
		driver.findElement(By.id("add-to-cart")).click();
		// navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		// Validate
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (productToBeAdded.equals(productInCart)) {
			System.out.println("PASS");
			System.out.println(productInCart);

		} else {
			System.out.println("FAIL");

		}

		driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		driver.findElement(By.xpath("//a[.='Logout']")).click();

	}

}
