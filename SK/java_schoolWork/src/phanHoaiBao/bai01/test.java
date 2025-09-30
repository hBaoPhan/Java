package phanHoaiBao.bai01;

import java.text.DecimalFormat;

public class test {

	public static void main(String[] args) {
		ChuyenXe xe1 = new ChuyenXeNoiThanh("001", "Nguyễn Văn A", "71A-34567", 100000, "46", 100);
//		System.out.println(xe1);
		ChuyenXe xe2 = new ChuyenXeNgoaiThanh("002", "Nguyễn Văn B", "72A-76543", 500000, "Vũng Tàu", 600);
//		System.out.println(xe2);

		ChuyenXe[] ds = new ChuyenXe[2];
		ds[0] = xe1;
		ds[1] = xe2;
		
		System.out.println(ChuyenXe.getTieuDe());
		xuatMang(ds);
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
	
		System.out.println("Tổng doanh thu của tất cả các chuyến xe: " + tien.format(tinhTongDoanhThu(ds)));
		System.out.println("Tổng doanh thu của chuyến xe nội thành: " + tien.format(tinhTongDoanhThuCXNoiThanh(ds)));
		System.out.println("Tổng doanh thu của chuyến xe ngoại thành: " + tien.format(tinhTongDoanhThuCXNgoaiThanh(ds)));
		
		
		
		
		
	}
	public static void xuatMang(ChuyenXe[] ds) {
		for (ChuyenXe chuyenXe : ds) {
			System.out.println(chuyenXe);
		}
		
	}
	public static double tinhTongDoanhThu(ChuyenXe[] ds) {
		double s=0;
		for (ChuyenXe chuyenXe : ds) {
			s+=chuyenXe.getDoanhThu();
		}
		return s;
		
	}
	public static double tinhTongDoanhThuCXNoiThanh(ChuyenXe[] ds) {
		double s=0;
		for (ChuyenXe chuyenXe : ds) {
			if(chuyenXe instanceof ChuyenXeNoiThanh)
				s+=chuyenXe.getDoanhThu();
		}
		return s;
		
	}
	public static double tinhTongDoanhThuCXNgoaiThanh(ChuyenXe[] ds) {
		double s=0;
		for (ChuyenXe chuyenXe : ds) {
			if(chuyenXe instanceof ChuyenXeNgoaiThanh)
				s+=chuyenXe.getDoanhThu();
		}
		return s;
		
	}
	

}
