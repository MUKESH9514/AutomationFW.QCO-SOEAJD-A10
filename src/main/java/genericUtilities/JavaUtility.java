package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mukes
 * This class consists of generic methods related to Java
 */

public class JavaUtility {
	
	/**
	 * This method will capture system date and return the date to caller
	 * Used to name screenshots and reports
	 * @return
	 */
	
	public String getSystemDataInformat() {
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = f.format(d);
		return date;
		
	}

}
