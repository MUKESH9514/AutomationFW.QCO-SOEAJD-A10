package basicSeleniumDoneByMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintHeightWidth {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement emailtbx = driver.findElement(By.id("email"));
		int height=emailtbx.getSize().getHeight();
		int width=emailtbx.getSize().getWidth();
		System.out.println("height = "+ height);
		System.out.println("width= "+ width);
	}

}
