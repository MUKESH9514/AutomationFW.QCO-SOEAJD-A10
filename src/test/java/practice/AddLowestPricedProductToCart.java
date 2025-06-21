package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddLowestPricedProductToCart {
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String SORTOPTION = wb.getSheet("Products").getRow(7).getCell(2).getStringCellValue();
		String PRODUCTNAME = wb.getSheet("Products").getRow(7).getCell(3).getStringCellValue();
		System.out.println(SORTOPTION+"===>"+PRODUCTNAME);
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		//sort the price
		WebElement prodSort = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select sel = new Select(prodSort);
		sel.selectByVisibleText(SORTOPTION);
		
		Thread.sleep(2000);
		
		//click on the lowest priced prod
		WebElement product = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String productToBeAdded = product.getText();
		product.click();
		
		//Add to cart
		driver.findElement(By.id("add-to-cart")).click();
		//navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		//Validate
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
