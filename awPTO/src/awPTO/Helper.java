package awPTO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Helper {
	
	private String 	line;

	public Helper(String filePath) {
		try (
			    InputStream fis = new FileInputStream(filePath);
			    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			    BufferedReader br = new BufferedReader(isr);
			) {
			    while ((line = br.readLine()) != null) {
			        System.out.println(line);
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public String getLine() {
		return line;
	}
	
	

}
