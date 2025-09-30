package phanHoaiBao.bai06;

import java.util.Arrays;
import java.util.Comparator;

public class DanhSachHangHoa  {
	private HangHoa[] dsHangHoa;
	private int count;
	
	public DanhSachHangHoa(int n) {
		
		this.dsHangHoa = new HangHoa[n];
		this.count = 0;
	}
	public boolean them(HangHoa a) {
		if(count<dsHangHoa.length) {
			dsHangHoa[count++]=a;
			return true;
		}
		else {
			return false;
		}
		
	}
	public HangHoa timKiemTheoMa(String ma) {
		for (int i = 0; i < count; i++) {
			if(dsHangHoa[i].getMaHang().compareTo(ma)==0) {
				return dsHangHoa[i];
			}
		}
		return null;
		
	}
	public HangHoa[] sapXepTheoTenTang() {
		HangHoa[] a=Arrays.copyOf(dsHangHoa, count);
		
		Arrays.sort(a,new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				// TODO Auto-generated method stub
				return o1.getTenHang().compareToIgnoreCase(o2.getTenHang());
			}
			
		});
		return a;
		
	}
	public HangHoa[] sapXepTheoSoLuongTonGiam() {
		HangHoa[] a=Arrays.copyOf(dsHangHoa, count);
		
		Arrays.sort(a,new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				// TODO Auto-generated method stub
				return Double.compare(o2.getSoLuongTon(), o1.getSoLuongTon()) ;
			}
			
		});
		return a;
		
	}
	public DanhSachHangHoa layDsHangThucPhamKhoBan() {
		DanhSachHangHoa a=new DanhSachHangHoa(count);
		for (int i = 0; i < count; i++) {
			if(dsHangHoa[i] instanceof HangThucPham)
				if(dsHangHoa[i].danhGiaMucDoBanBuon().compareToIgnoreCase("khó bán")==0)
					a.them(dsHangHoa[i]);
		}
		return a;
	}
	public boolean xoaTheoMa(String ma) {
		int viTri=0;
		for (int i = 0; i < count; i++) {
			if(dsHangHoa[i].getMaHang().compareToIgnoreCase(ma)==0) {
				viTri=i;
			}
		}
		for (int i = viTri; i < count; i++) {
			dsHangHoa[i]=dsHangHoa[i+1];
			
		}
		this.count--;
		return true;
		
		
	}
	public boolean suaDonGia(String ma,double dongia) {
		for (int i = 0; i < count; i++) {
			if(dsHangHoa[i].getMaHang().compareToIgnoreCase(ma)==0) {
				dsHangHoa[i].setDonGia(dongia);
				return true;
			}
		}
		return false;
	}
	public DanhSachHangHoa layDsHangThucPham() {
		DanhSachHangHoa a=new DanhSachHangHoa(count);
		for (int i = 0; i < count; i++) {
			if(dsHangHoa[i] instanceof HangThucPham)
				a.them(dsHangHoa[i]);
		}
		return a;
	}
	
	
	@Override
	public String toString() {
		String s=HangThucPham.getTieuDe()+"\n";
		for (int i = 0; i < count; i++) {
			if(dsHangHoa[i] instanceof HangThucPham) {
				s+=dsHangHoa[i]+"\n";
			}	
		}
		s+=HangSanhSu.getTieuDe()+"\n";
		for (int i = 0; i < count; i++) {
			if(dsHangHoa[i] instanceof HangSanhSu) {
				s+=dsHangHoa[i]+"\n";
			}
		}
		s+=HangDienMay.getTieuDe()+"\n";
		for (int i = 0; i < count; i++) {
			if(dsHangHoa[i] instanceof HangDienMay)
				s+=dsHangHoa[i]+"\n";
		}
		return s;
	}
	
	
	

}
