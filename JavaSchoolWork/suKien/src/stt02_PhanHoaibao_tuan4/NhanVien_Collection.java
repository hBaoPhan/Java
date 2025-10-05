package stt02_PhanHoaibao_tuan4;

import java.io.Serializable;
import java.util.ArrayList;

public class NhanVien_Collection implements Serializable{
	private ArrayList<NhanVien> dsNV;

	public NhanVien_Collection() {
		dsNV=new ArrayList<NhanVien>();
	}
    public boolean themNhanVien(NhanVien nv) {
    	if(dsNV.contains(nv))
    		return false;
    	dsNV.add(nv);
    	return true;
	}
    public ArrayList<NhanVien> getDsNV() {
    	return dsNV;	
	}
	public void setDsNV(ArrayList<NhanVien> dsNV) {
		this.dsNV=dsNV;
	}
	public NhanVien getElementAt(int index) {
		if(index<0|| index>=dsNV.size())
			return null;
		return dsNV.get(index);
	}
	public int getSize() {
		return dsNV.size();
	}
	public boolean xoaNhanVien(String ma) {
		for (NhanVien nhanVien : dsNV) {
			if(nhanVien.getMaNV().equals(ma))
				dsNV.remove(nhanVien);
				return true;
		}
		return false;
	}
	public NhanVien timKiem(String ma) {
		for (NhanVien nhanVien : dsNV) {
			if(nhanVien.getMaNV().equals(ma))
				return nhanVien;
		}
		return null;
	
		
	}
	
}
