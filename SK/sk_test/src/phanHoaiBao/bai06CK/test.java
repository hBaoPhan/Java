package phanHoaiBao.bai06CK;

import java.util.List;

public class test {

	public static void main(String[] args) {
		DanhSachPhongHoc ds=new DanhSachPhongHoc();
		ds.them(new PhongLyThuyet("001","V", 40, 4, true));
		ds.them(new PhongMayTinh("002", "E", 30, 5, 34));
		ds.them(new PhongMayTinh("003", "B", 20, 10, 10));
//		ds.xoa("002");
		System.out.println(ds);
//		System.out.println(ds.timKiem("001"));
//		List<PhongHoc> a=ds.sapXepTangDanTheoDayNha();
//		for (PhongHoc phongHoc : a) {
//			System.out.println(phongHoc);
//		}
		PhongHoc a=ds.timPhongDienTichBeNhat();
		System.out.println(a);

	}

}
