package basicSeleniumDoneByMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintFirstSelectedoptionFromCheckPost {
	

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/mukes/OneDrive/Desktop/seleniumHtml/Hotel.html");
		WebElement checkPostlistBox = driver.findElement(By.id("cp"));
		Select s = new Select(checkPostlistBox);
		 String text = s.getFirstSelectedOption().getText();
		 System.out.println(text);
		 driver.close();
        
		
	}

}
