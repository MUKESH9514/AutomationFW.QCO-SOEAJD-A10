package basicSeleniumDoneByMe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	static {
		System.setProperty("webdriver/chrome/driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.vtiger.com/");
		WebElement companyTab = driver.findElement(By.cssSelector("a[id='companyDropdown']"));
		Actions a = new Actions(driver);
		a.moveToElement(companyTab).perform();
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		String phNo = driver.findElement(By.xpath("//p[contains(text(), 'Bengaluru')]/../p[2]")).getText();
		System.out.println(phNo);
		driver.close();
		
		
	}

}
