package phanHoaiBao.bai06;

import java.time.LocalDate;

public class test {

	public static void main(String[] args) {
	 DanhSachHangHoa a=new DanhSachHangHoa(10);
	 a.them(new HangSanhSu("001", "Sanh", 100, 20, "Bao", LocalDate.of(2024, 10, 02)));
	 a.them(new HangDienMay("002", "Anh", 100.0, 70, 44.0,43.0));
	 a.them(new HangThucPham("003", "Hanh", 100.0, 80, "Bao",LocalDate.of(2024, 10, 02),LocalDate.of(2024, 10, 02)));
	 
	 System.out.println(a);
//	 System.out.println(a);
	 
	 HangHoa[] b=a.sapXepTheoSoLuongTonGiam();
	 for (HangHoa hangHoa : b) {
		System.out.println(hangHoa);
	}
//	 System.out.println(a.layDsHangThucPhamKhoBan());
//	 System.out.println(a.xoaTheoMa("001"));
//	 System.out.println(a.suaDonGia("002", 600000));
//	 System.out.println(a);
	 
	 
	 
	 
	}

}
