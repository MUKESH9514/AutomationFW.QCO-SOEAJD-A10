package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCart {
	
	public static void main(String[] args) {
		
		//Launch the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//Load the application
		driver.get("https://www.saucedemo.com/");
				
		//Login to application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		
		//Click on the product - Jacket
		String productToBeAdded = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).getText();
		driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).click();
		
		
		//Add product to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Navigate to cart
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		//Validate for product
		String productInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		
		if(productInCart.equals(productToBeAdded)) {
			System.out.println("PASS");
			System.out.println(productInCart);
		}
		else {
			System.out.println("FAIL");
		}
			
		// Logout the application
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		
	}

}
