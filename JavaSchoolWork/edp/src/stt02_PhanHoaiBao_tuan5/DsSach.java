package stt02_PhanHoaiBao_tuan5;

import java.util.ArrayList;

public class DsSach {
	private ArrayList<Sach> ds;

	public DsSach() {
		ds=new ArrayList<Sach>();
	}
	public void napDuLieuTuFile() {
		ds=LuuTru.docTuFile();
	}
	public boolean them(Sach sach) {
		if(ds.contains(sach))
			return false;
		ds.add(sach);
		return true;
		
	}
	public boolean xoa(int index) {
		if(index>=0 && index<ds.size()) {
			ds.remove(index);
			return true;
		}
		return false;
		
		
	}
	public Sach tim(String ma) {
		for (Sach sach : ds) {
			if(sach.getMaSach().equalsIgnoreCase(ma))
				return sach;
		}
		return null;
		
	}
	public int getSize() {
		return ds.size();
		
	}
	public Sach getElemAt(int index) {
		return ds.get(index);
		
	}
	@Override
	public String toString() {
		String s="";
		for (Sach sach : ds) {
			s+=sach+"\n";
		}
		return s;
	}
	public boolean updateSach(Sach newB) {
		for (int i = 0; i < ds.size(); i++) {
			if(ds.get(i).getMaSach().equals(newB.getMaSach()))
				ds.set(i, newB);
				return true;
			
		}
		return false;
		
	}
	
	
	

}
