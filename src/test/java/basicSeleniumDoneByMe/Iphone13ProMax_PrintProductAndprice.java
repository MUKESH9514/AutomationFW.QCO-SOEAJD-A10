package basicSeleniumDoneByMe;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iphone13ProMax_PrintProductAndprice {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("iphone 13 promax");
		List<WebElement> allsugg = driver.findElements(By.xpath("//div[text()='iphone 13 promax']"));

		int count = allsugg.size();
		System.out.println(count);
//		for (int i = 0; i < count; i++) {
//			String text = allsugg.get(i).getText();
//
//		}
		allsugg.get(0).click();
		List<WebElement> prdtName = driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone')]"));
		List<WebElement> prdtPrice = driver.findElements(By.xpath(
				"//span[contains(text(),'Apple iPhone')]/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]"));
		int count1 = prdtPrice.size();
		for (int i = 0; i < count1; i++) {
			String text1 = prdtName.get(i).getText();
			String text2 = prdtPrice.get(i).getText();
			System.out.println(text1 + " -----------------> " + text2);

		}

	}

}
