package basicSeleniumDoneByMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectListBox {
	

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/mukes/OneDrive/Desktop/seleniumHtml/Hotel.html");
		WebElement mtrlistBox = driver.findElement(By.id("mtr"));
		Select s = new Select(mtrlistBox);
		s.selectByIndex(0);
		s.selectByValue("d");
		s.selectByVisibleText("vada");
	}
}
