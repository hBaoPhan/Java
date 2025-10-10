package onGK;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachNhanVien implements Serializable{ 
	private ArrayList<NhanVien> ds;

	public DanhSachNhanVien() {
		ds=new ArrayList<NhanVien>();
	}
	public boolean them(NhanVien nv) {
		if(ds.contains(nv))
			return false;
		ds.add(nv);
		return true;
		
	}
	
	public boolean xoa(int index) {
		if(index>=0 && index<ds.size()) {
			ds.remove(index);
			return true;
		}
		return false;
		
		
	}
	

	public boolean sua(NhanVien nv) {
		for (int i = 0; i < ds.size(); i++) {
			if(ds.get(i).getMa().equals(nv.getMa())) {
				ds.set(i, nv);
				return true;
			}
			
		}
		return false;
		
	}
	public int tim(String ma) {
		for (int i = 0; i < ds.size(); i++) {
			if(ds.get(i).getMa().equalsIgnoreCase(ma))
				return i;
			
		}
		return -1;
		
	}
	public int getSize() {
		return ds.size();
		
	}
	public NhanVien getElemAt(int index) {
		return ds.get(index);
		
	}
	@Override
	public String toString() {
		String s="";
		for (NhanVien nhanVien : ds) {
			s+=nhanVien+"\n";
		}
		// TODO Auto-generated method stub
		return s;
	}

}
