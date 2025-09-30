package phanHoaiBao.bai06CK;

import java.util.ArrayList;
import java.util.Collection;
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
			if(p.getMaPhong().equalsIgnoreCase(phongHoc.getMaPhong()))
				return false;
		}
		ds.add(p);
		return true;
	}
	public PhongHoc timKiem(String ma) {
		for (PhongHoc phongHoc : ds) {
			if(phongHoc.getMaPhong().equalsIgnoreCase(ma))
				return phongHoc;
		}
		return null;
	}
	public List<PhongHoc> layDsPhongDatChuan() {
		
		List<PhongHoc> a=new ArrayList<PhongHoc>();
		
		for (PhongHoc phongHoc : ds) {
			if(phongHoc.kiemTraDatChuan()==true)
				a.add(phongHoc);
		}
		return a;
	}
	public List<PhongHoc> sapXepDsGiamDanTheoDienTich() {
		List<PhongHoc> a =new ArrayList<PhongHoc>(ds);
		Collections.sort(a,new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
				return Double.compare(o2.getDienTich(), o1.getDienTich());
			}
		});
		return a;
	}
	public List<PhongHoc> sapXepTangDanTheoDayNha() {
		List<PhongHoc> a=new ArrayList<PhongHoc>(ds);
		Collections.sort(a, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				
				return o1.getDayNha().compareToIgnoreCase(o2.getDayNha());
			}
		});
		return a;
	}
	public boolean capNhat(String ma,int somay) {
		for (PhongHoc phongHoc : ds) {
			if(phongHoc instanceof PhongMayTinh)
				if(phongHoc.getMaPhong().compareToIgnoreCase(ma)==0)
					((PhongMayTinh) phongHoc).setSoMayTinh(somay);
			return true;
		}
		return false;
	}
	public boolean xoa(String ma) {
		return ds.removeIf(p1 -> p1.getMaPhong().compareToIgnoreCase(ma)==0);
		
	}
	public PhongHoc timPhongDienTichBeNhat() {
		return Collections.min(ds, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.getDienTich(), o2.getDienTich());
			}
		});
	}
	@Override
	public String toString() {
		
		String s="Danh Sách phòng lý thuyết"+"\n";
		s+=PhongLyThuyet.getTieuDe()+"\n";
		for (PhongHoc phongHoc : ds) {
			if(phongHoc instanceof PhongLyThuyet)
				s+=phongHoc+"\n";
		}
		s+="Danh Sách Phòng Máy tính"+"\n";
		s+=PhongMayTinh.getTieuDe()+"\n";
		for (PhongHoc phongHoc : ds) {
			if(phongHoc instanceof PhongMayTinh)
				s+=phongHoc+"\n";
		}
		
		return s;
	}
	
}
