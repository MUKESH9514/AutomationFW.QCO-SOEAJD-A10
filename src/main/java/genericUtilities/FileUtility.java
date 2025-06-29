package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * This class consists of generic methods related to Files
 * @author mukes
 * 
 */

public class FileUtility {
	
	/**
	 * This method read the data from property file and return the value to
	 * caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
	
	/**
	 * This method reads the data from Excel and return the value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcelFile(String sheetName, int rowNo, int celNo) throws EncryptedDocumentException, IOException{
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
	   String celValue = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
	   return celValue;
	   
		
	}
	
	
	

}
