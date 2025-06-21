package basicSeleniumDoneByMe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlayYTSong {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.findElement(By.name("search_query")).sendKeys("sham hai dhua dhua");
		Thread.sleep(3000);
		List<WebElement> allSugg = driver.findElements(By.xpath("//span[contains(text(), 'sham')]"));
		int count = allSugg.size();
		System.out.println(count);
		allSugg.get(0).click();
		driver.findElement(By.linkText("#VIDEO | शाम है धुंआ धुंआ | #Sanjay Pandey #Neha Raj | Sham Hai Dhuan Dhuan | New Bhojpuri Song 2025")).click();
		
				

	}

}
