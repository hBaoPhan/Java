package phanHoaiBao.bai02;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import phanHoaiBao.bai01.ChuyenXe;
import phanHoaiBao.bai01.ChuyenXeNgoaiThanh;
import phanHoaiBao.bai01.ChuyenXeNoiThanh;

public class testt {

	public static void main(String[] args) {
		Sach sach1 = new SachGiaoKhoa("001", LocalDate.of(2025, 10, 02), 1000, 10, "Phan Hoài Bảo", false);
		Sach sach2 = new SachGiaoKhoa("002", LocalDate.of(2025, 02, 10), 1000, 10, "Phan Hoài Bảo", true);
		Sach sach3 = new SachGiaoKhoa("003", LocalDate.of(2025, 02, 10), 2000, 10, "Nguyen Van A", false);
		Sach sach4 = new SachThamKhao("004", LocalDate.of(2025, 12, 12), 3000, 10, "Nguyen Van A", 2000);
		Sach sach5 = new SachThamKhao("005", LocalDate.of(2025, 12, 12), 4000, 10, "Nguyen Van B", 3000);
		Sach sach6 = new SachThamKhao("006", LocalDate.of(2025, 12, 12), 5000, 10, "Phan Hoài Bảo", 4000);
//		System.out.println(sach1);
//		System.out.println(sach4.getThanhTien());
		Sach[] ds = new Sach[6];
		ds[0] = sach1;
		ds[1] = sach2;
		ds[2] = sach3;
		ds[3] = sach4;
		ds[4] = sach5;
		ds[5] = sach6;

		System.out.println(Sach.getTieuDe());
		xuatMang(ds);
		

		System.out.println("Tổng tiền của sách giáo khoa: " + tinhTongTienSachGiaoKhoa(ds));
		System.out.println("Tổng tiền của sách tham khảo: " + tinhTongTienSachThamKhao(ds));

		System.out.println("Nhập tên nhà xuất bản:");
		Scanner nhap = new Scanner(System.in);
		String k = nhap.nextLine();
		Sach[] a=getDsSachTheoNXK(ds, k);
		System.out.println(Sach.getTieuDe());
		xuatMang(a);
		System.out.println("Thành tiền cao nhất: "+timThanhTienCaoNhat(ds));
		
		

	}
	public static void xuatMang(Sach[] ds) {
		for (Sach sach : ds) {
			System.out.println(sach);
		}
		
	}
	public static double tinhTongTienSachGiaoKhoa(Sach[] ds) {
		double s=0;
		for (Sach sach : ds) {
			if(sach instanceof SachGiaoKhoa)
				s+=sach.getThanhTien();
		}
		return s;
	}
	public static double tinhTongTienSachThamKhao(Sach[] ds) {
		double s=0;
		for (Sach sach : ds) {
			if(sach instanceof SachThamKhao)
				s+=sach.getThanhTien();
		}
		return s;
	}
	public static Sach[] getDsSachTheoNXK(Sach[] ds,String nxb) {
		Sach[] a=new Sach[ds.length];
		int count=0;
		for (int i = 0; i < ds.length; i++) {
			if(ds[i] instanceof SachGiaoKhoa)
				if (ds[i].getNhaXuatBan().equalsIgnoreCase(nxb) ) {
					a[count++]=ds[i];
				}
		}
		return Arrays.copyOf(a, count);
		
		
	}
	public static double timThanhTienCaoNhat(Sach[] ds) {
		double max= ds[0].getThanhTien();
		for (int i = 0; i < ds.length; i++) {
			if(ds[i].getThanhTien()>max)
				max=ds[i].getThanhTien();
			
		}
		return max;
		
	}

}
