package phanHoaiBao.bai03;

import java.text.DecimalFormat;
import java.util.Arrays;

public class DanhSachSach {
	private Sach[] list;
	private int count;
	
	
	public DanhSachSach(int n) {
		list = new Sach[n];
		count=0;
		
	}
	public boolean them(Sach a) {
		if(count<list.length ) {
			list[count++]=a;
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		String s="";
		s+=Sach.getTieuDe()+"\n";
		for (int i = 0; i < count; i++) {
			s+=list[i]+"\n";
		}
		return s;
	}
	public  double tinhTongThanhTienSachGiaoKhoa() {
		double s=0;
		for (Sach sach : list) {
			if(sach instanceof SachGiaoKhoa)
				s+=sach.getThanhTien();
		}
		return s;
	}
	public double tinhTongThanhTienSachThamKhao() {
		double s=0;
		for (Sach sach : list) {
			if(sach instanceof SachThamKhao)
				s+=sach.getThanhTien();
		}
		return s;
	}
	public DanhSachSach timSachGiaoKhoaTheoNhaXuatBan(String nxb) {
		DanhSachSach a=new DanhSachSach(list.length);
		for (int i = 0; i < this.count; i++) {
			if(list[i] instanceof SachGiaoKhoa)
				if (list[i].getNhaXuatBan().equalsIgnoreCase(nxb) ) {
					a.them(list[i]);
				}
		}
		return a;
		
		
	}
	public double timThanhTienCaoNhat() {
		
		double max= list[0].getThanhTien();
		for (int i = 0; i < count; i++) {
			if(list[i].getThanhTien()>max)
				max=list[i].getThanhTien();
			
		}
		return max;
		
	}
	
	
	

}
