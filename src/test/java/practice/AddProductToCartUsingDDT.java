package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCartUsingDDT {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Read Required data
		// Property file - common Data

		// Open the doc in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

		// Create the Object of Properties Class- java.util

		Properties p = new Properties();

		// Load file input stream to Properties file
		p.load(fis);

		// read the data using Keys

		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//Read Test data from Excel File
		//Open the document in Java readable format
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//create WorkBook
		Workbook wb = WorkbookFactory.create(fise);
		
		//Navigate to sheet
		
		Sheet sh = wb.getSheet("Products");
		
		//Navigate to row
		
		Row rw = sh.getRow(1);
		
		//Navigate to cell
		
		Cell cl = rw.getCell(2);
		//capture the data inside the cell
		String PRODUCTNAME = cl.getStringCellValue();
		//System.out.println(PRODUCTNAME);

		// Launch the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load the application
		driver.get(URL);

		// Login to application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();

		// Click on the product - dynamic xpath
		String productToBeAdded = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).getText();
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
		
		//
		
		
		

		// Add product to cart
		driver.findElement(By.id("add-to-cart")).click();
		


		// Navigate to cart
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

		// Validate for product
		String productInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

		if (productInCart.equals(productToBeAdded)) {
			System.out.println("PASS");
			System.out.println(productInCart);
		} else {
			System.out.println("FAIL");
		}
		
		

		// Logout the application

		//driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		//driver.findElement(By.id("logout_sidebar_link")).click();

	}

}
