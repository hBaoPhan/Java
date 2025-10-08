package stt02_PhanHoaiBao_tuan5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class LuuTru {
	
	private static final String FILENAME = "data/dulieu.txt";

	public static ArrayList<Sach> docTuFile() {
		ArrayList<Sach> ds=new ArrayList<Sach>();
		BufferedReader br=null;
		try {
			if(new File(FILENAME).exists()) 
				br=new BufferedReader(new FileReader(FILENAME));
				br.readLine();
				while(br.ready()) {
					String line=br.readLine();
					if(line!=null && !line.trim().equals("")) {
						String[] a= line.split(";");
						Sach s=new Sach(a[0], a[1], a[2], 
								Integer.parseInt(a[3]), a[4], 
								Integer.parseInt(a[5]), 
								Double.parseDouble(a[6]),a[7]);
						ds.add(s);
					}
					
				}
				br.close();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
		
	}
	public static void ghiXuongFile(DsSach ds) {
		BufferedWriter bw;
		try {
			bw =new BufferedWriter(new FileWriter(FILENAME));
			bw.write("MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN\n");
			for (int i = 0; i < ds.getSize(); i++) {
				bw.write(ds.getElemAt(i).toString()+"\n");
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
