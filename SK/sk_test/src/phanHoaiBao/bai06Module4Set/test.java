package phanHoaiBao.bai06Module4Set;

import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DanhSachPhongHoc a=new DanhSachPhongHoc();
		a.them(new PhongLyThuyet("004", "A", 100, 10, false));
		a.them(new PhongLyThuyet("004", "A", 100, 10, true));
		a.them(new PhongMayTinh("002", "B", 100, 1, 10));
		a.them(new PhongThiNghiem("003", "C", 100, 5, "KHMT", 50, true));
//		System.out.println(a.xoa("001"));
		System.out.println(a);
		List<PhongHoc> b=a.sapXepDSTangTheoDayNha();
		for (PhongHoc phongHoc : b) {
			System.out.println(phongHoc);
		}
	}

}
