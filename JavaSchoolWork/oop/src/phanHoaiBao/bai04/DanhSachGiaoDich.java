package phanHoaiBao.bai04;

import java.util.Arrays;

public class DanhSachGiaoDich {
	private GiaoDich[] list;
	private int count;
	
	public DanhSachGiaoDich(int n) {
		
		list= new GiaoDich[n];
		count = 0;
	}
	public boolean them(GiaoDich a) {
		if(count<list.length) {
			list[count++]=a;
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		String s="";
		s+=GiaoDich.getTieuDe()+"\n";
		for (int i = 0; i < count; i++) {
			s+=list[i]+"\n";
		}
		return s;
	}
	public int tinhTongSoLuongGiaoDichVang() {
		int sum=0;
		for (int i = 0; i < count; i++) {
			if(list[i] instanceof GiaoDichVang)
				sum+=list[i].getSoLuong();		
			}
		return sum;
	}
	public int tinhTongSoLuongGiaoDichTienTe() {
		int sum=0;
		for (int i = 0; i < count; i++) {
			if(list[i] instanceof GiaoDichTienTe)
				sum+=list[i].getSoLuong();		
			}
		return sum;
	}
	public double tinhTBThanhTienGDTienTe() {
		double sum=0;
		double count=0;
		for (int i = 0; i < this.count; i++) {
			if(list[i] instanceof GiaoDichTienTe)
				sum+=list[i].getThanhTien();
				count++;			
			}
		return sum/count;
		
	}
	public DanhSachGiaoDich getDsGiaoDichDonGiaTren1Ty() {
		DanhSachGiaoDich ds=new DanhSachGiaoDich(count);
		for (int i = 0; i < count; i++) {
			if(list[i].getDonGia()>1000000000) {
				ds.them(list[i]);
			}
		}
		return ds;
		
	}
	
	
	

}
