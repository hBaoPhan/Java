package stt02_PhanHoaiBao_lt7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyLine {

	public static void main(String[] args) throws IOException {
		FileWriter out=null;
		Scanner in=null;
		try {
			in=new Scanner(new FileReader("src/stt02_PhanHoaiBao_Lt8/output.txt"));
			out=new FileWriter("data/dest.txt");
			String line=null;
			while (in.hasNextLine()) {
				out.write(line+"\n");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(in!=null) in.close();
			if(out!=null) out.close();
		}
		

	}

}
