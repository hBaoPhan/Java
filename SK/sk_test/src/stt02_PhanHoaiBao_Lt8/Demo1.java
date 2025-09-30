package stt02_PhanHoaiBao_Lt8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 {

	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream("src/stt02_PhanHoaiBao_Lt8/test.png");
			fos = new FileOutputStream("src/stt02_PhanHoaiBao_Lt8/test_copy.png");
			int c;
			while ((c=fis.read()) != -1) {
				fos.write(c);
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}

	}

}
