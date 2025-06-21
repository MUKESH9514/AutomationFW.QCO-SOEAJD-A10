package basicSeleniumDoneByMe;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/mukes/OneDrive/Desktop/seleniumHtml/Naukri.html");
		driver.findElement(By.id("cv")).sendKeys("C:\\LocalDriveE\\New folder\\Automation\\data\\Kaushal_kr_SDET.docx");
//        File f = new File("./data/Kaushal_kr_SDET.docx");
//        String absPath = f.getAbsolutePath();
//        Thread.sleep(4000);
//        driver.findElement(By.id("cv")).sendKeys(absPath);
        
	}

}
