package stt02_PhanHoaiBao_lt7;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFrom {
		public void readFrom(String fileName) throws FileNotFoundException {
			Scanner in=null;
			try {
				in=new Scanner(new BufferedInputStream(new FileInputStream(fileName)));
				String line=null;
				while (in.hasNextLine()) {
					line=in.nextLine();
					String[] cols=line.split(";");
					float diemGK=Float.parseFloat(cols[1]);
					float diemCK=Float.parseFloat(cols[2]);
					float diemTB=(diemGK+diemCK)/2;
					System.out.println(String.format("%-25s %-10s", line+";",diemTB));
				}
				
			} finally {
				if(in!=null) in.close();
			}
			
			
		}
}
