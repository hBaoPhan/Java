package phanHoaiBao.bai06Module4List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachPhongHoc {
	private List<PhongHoc> ds;

	public DanhSachPhongHoc() {
		ds=new ArrayList<PhongHoc>();
	}
	public boolean them(PhongHoc p) {
		for (PhongHoc phongHoc : ds) {
			if(phongHoc.getMaPhong().compareToIgnoreCase(p.getMaPhong())==0) {
				return false;
			}
		}
		ds.add(p);
		return true;
	}
	public PhongHoc timKiem(String ma) {
		for (PhongHoc phongHoc : ds) {
			if(phongHoc.getMaPhong().compareToIgnoreCase(ma)==0)
				return phongHoc;
		}
		return null;
		
	}
	@Override
	public String toString() {
		String s="Danh Sách Phòng Lý Thuyết"+"\n";
		s+=PhongLyThuyet.getTieuDe()+"\n";
		for (PhongHoc phongHoc : ds) {
			if(phongHoc instanceof PhongLyThuyet)
				s+=phongHoc+"\n";
		}
		s+="Danh Sách Phòng Máy Tính"+"\n";
		s+=PhongMayTinh.getTieuDe()+"\n";
		for (PhongHoc phongHoc : ds) {
			if(phongHoc instanceof PhongMayTinh)
				s+=phongHoc+"\n";
		}
		s+="Danh Sách Phòng Thí Nghiệm"+"\n";
		s+=PhongThiNghiem.getTieuDe()+"\n";
		for (PhongHoc phongHoc : ds) {
			if(phongHoc instanceof PhongThiNghiem)
				s+=phongHoc +"\n";
		}
		return s;	
	}
	public List<PhongHoc> layDsCacPhongDatChuan() {
		List<PhongHoc> a=new ArrayList<PhongHoc>();
		for (PhongHoc phongHoc : a) {
			if(phongHoc.kiemTraDatChuan()==true)
				a.add(phongHoc);
		}
		return a;
	}
	public List<PhongHoc> sapXepDSTangTheoDayNha() {
		List<PhongHoc> a=new ArrayList<PhongHoc>(ds);
		Collections.sort(a, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				
				return o1.getDayNha().compareToIgnoreCase(o2.getDayNha());
			}
		});
		return a;
	}
	public List<PhongHoc> sapXepDsTangTheoSoBongDen() {
		List<PhongHoc> a=new ArrayList<PhongHoc>(ds);
		Collections.sort(a, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.getSoBongden(), o2.getSoBongden());
			}
		});
		return a; 
	}
	public boolean capNhatSoMayTinh(String ma,int soMay) {
		for (PhongHoc phongHoc : ds) {
				if(phongHoc.getMaPhong().compareToIgnoreCase(ma)==0) {
					((PhongMayTinh) phongHoc).setSoMayTinh(soMay);
					return true;
				}
					
		}
		return false;
	}
	public boolean xoa(String ma) {
		return ds.removeIf(sv -> sv.getMaPhong().compareToIgnoreCase(ma)==0);
	}
	
	
	
	
	
	
	
}
