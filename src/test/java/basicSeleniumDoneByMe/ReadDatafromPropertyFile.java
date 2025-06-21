package basicSeleniumDoneByMe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDatafromPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\mukes\\OneDrive\\Desktop\\seleniumHtml\\commondata.property");
		Properties p = new Properties();
		p.load(fis);
		String url =p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		System.out.println(url+"  ===>  "+un+"   ====>  "+pw);
		
	}

}
