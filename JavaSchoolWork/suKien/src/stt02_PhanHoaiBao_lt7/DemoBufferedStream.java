package stt02_PhanHoaiBao_lt7;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class DemoBufferedStream {
	private final String[] dsTenSV = {"An","Lan","Hoa","Hoàng","Nga","Tâm"};
	private final float[] DSDiemGK = {7,8.5f,9,10,4.5f,6};
	private final float[] DSDiemCK = {5,5.5f,6.5f,10,6,4.5f};
	public void writeTo(String fileName) throws FileNotFoundException {
		PrintWriter out=null;
		try {
			out=new PrintWriter(new BufferedOutputStream(new FileOutputStream(fileName)),true);
			for (int i = 0; i < dsTenSV.length; i++) {
				out.println(String.format("%-10s %-10s %-10s", dsTenSV[i]+";",DSDiemGK[i]+";",DSDiemCK[i]+";"));
			}
		} finally {
			if(out!=null) out.close();
		}
		
	}
	

}
