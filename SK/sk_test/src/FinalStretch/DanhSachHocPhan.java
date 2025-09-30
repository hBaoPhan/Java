package FinalStretch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class DanhSachHocPhan {
	private List<HocPhan> ds;

	public DanhSachHocPhan() {
		ds=new ArrayList<HocPhan>();
	}
	public boolean them(HocPhan hp) {
		for (HocPhan hocPhan : ds) {
			if(hocPhan.getMaSo().equalsIgnoreCase(hp.getMaSo()))
				return false;
		}
		ds.add(hp);
		return true;
	}
	public double tinhTongTienKhenThuong(int thang,int nam) {
		double sum=0;
		for (HocPhan hocPhan : ds) {
			if(hocPhan.getNgayBatDau().getMonthValue()==thang && hocPhan.getNgayBatDau().getYear()==nam)
				sum+=hocPhan.kiemTraKhenThuong();
		}
		return sum;
	}
	public boolean capNhatDiemKetQua(String ma,int diemMoi) {
		for (HocPhan hocPhan : ds) {
			if(hocPhan.getMaSo().compareToIgnoreCase(ma)==0 && hocPhan.getDiemKetQua()==0)
				hocPhan.setDiemKetQua(diemMoi);
			return true;
		}
		return false;
		
	}
	public List<HocPhan> layDsMaGiam() {
		List<HocPhan> a=new ArrayList<HocPhan>(ds);
		Collections.sort(a, new Comparator<HocPhan>() {

			@Override
			public int compare(HocPhan o1, HocPhan o2) {
				// TODO Auto-generated method stub
				return o2.getMaSo().compareToIgnoreCase(o1.getMaSo());
			}
		});
		return a;
	}
	
	public SortedSet<HocPhan> layDsHocVienKhenThuong(int n) {
		SortedSet<HocPhan> a=new TreeSet<HocPhan>();
		List<HocPhan> copy=new ArrayList<HocPhan>(ds);
		Collections.sort(copy, new Comparator<HocPhan>() {

			@Override
			public int compare(HocPhan o1, HocPhan o2) {
				
				return Double.compare(o2.kiemTraKhenThuong(), o2.kiemTraKhenThuong());
			}
		});
		for (int i = 0; i < copy.size(); i++) {
			if(i==n)
			{
				break;
			}
				a.add(copy.get(i));
				
		}
		
		
		return a;
	}
	@Override
	public String toString() {
		String s="Danh sách học Phần trực tuyến"+"\n";
		s+=HocPhanTrucTuyen.getTieuDe()+"\n";
		for (HocPhan hocPhan : ds) {
			if(hocPhan instanceof HocPhanTrucTuyen)
				s+=hocPhan+"\n";
		}
		s+="Danh sách học Phần trực tiếp"+"\n";
		s+=HocPhanTrucTiep.getTieuDe()+"\n";
		for (HocPhan hocPhan : ds) {
			if(hocPhan instanceof HocPhanTrucTiep)
			{
				s+=hocPhan+"\n";
			}
		}
		return s;
	}
	
	
}
