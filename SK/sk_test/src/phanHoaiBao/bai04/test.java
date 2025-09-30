package phanHoaiBao.bai04;

import java.text.DecimalFormat;
import java.time.LocalDate;
//Tính tổng số lượng cho từng loại. 
//Tính trung bình thành tiền của giao dịch tiền tệ. 
//Lấy các giao dịch có đơn giá > 1 tỷ. 
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		GiaoDich gd1=new GiaoDichVang("001", LocalDate.of(2025, 01, 01), 1000, 10,"9999");
//		GiaoDich gd2=new GiaoDichTienTe("001", LocalDate.of(2025, 01, 01), 1000, 10,100,"USD");
//		System.out.println(GiaoDich.getTieuDe());
//		System.out.println(gd2);
		DanhSachGiaoDich ds=new DanhSachGiaoDich(10);
		ds.them(new GiaoDichVang("001", LocalDate.of(2025, 01, 01), 1230000000, 20,"9999"));
		ds.them(new GiaoDichVang("002", LocalDate.of(2025, 10, 02), 55000, 20,"999"));
		ds.them(new GiaoDichVang("003", LocalDate.of(2025, 01, 01), 3000, 10,"18k"));
		ds.them(new GiaoDichTienTe("004", LocalDate.of(2025, 01, 01), 1000, 10,100,"USD"));
		ds.them(new GiaoDichTienTe("005", LocalDate.of(2025, 01, 01), 1500000000, 10,200,"Euro"));
		ds.them(new GiaoDichTienTe("006", LocalDate.of(2024, 10, 02), 1000, 10,200,"VN"));
		
		
		System.out.println(ds);
		System.out.println("Tổng số lượng giao dịch Vàng: "+ds.tinhTongSoLuongGiaoDichVang());
		System.out.println("Tổng số lượng giao dịch Tiền tệ: "+ds.tinhTongSoLuongGiaoDichTienTe());
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		System.out.println("Trung bình thành tiền giao dịch tiền tệ: "+tien.format(ds.tinhTBThanhTienGDTienTe()));
		DanhSachGiaoDich ds2=ds.getDsGiaoDichDonGiaTren1Ty();
		System.out.println("Danh sách giao dịch đơn giá trên 1 tỷ");
		System.out.println(ds2);
	}

}
