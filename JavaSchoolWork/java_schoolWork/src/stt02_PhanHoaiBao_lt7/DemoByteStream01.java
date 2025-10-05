package stt02_PhanHoaiBao_lt7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoByteStream01 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("data/input.txt");
			fos = new FileOutputStream("src/stt02_PhanHoaiBao_Lt8/output.txt");
			int data = -1;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fos.close();
			fis.close();

			byte[] data1 = new byte[16];
			int nob = -1;
			while ((nob = fis.read(data1)) != -1) {
				fos.write(data1, 0, nob);
			}
			System.out.println("Xong");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}

		}

	}
}

