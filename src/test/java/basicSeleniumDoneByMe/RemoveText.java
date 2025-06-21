package basicSeleniumDoneByMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoveText {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensourcebilling.org/");
		driver.findElement(By.name("email-633")).clear();
//		Thread.sleep(10000);
//		driver.close();
		

	}

}
