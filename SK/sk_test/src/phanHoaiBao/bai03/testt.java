package phanHoaiBao.bai03;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		DanhSachSach ds=new DanhSachSach(10);
		ds.them(sach1);
		ds.them(sach2);
		ds.them(sach3);
		ds.them(sach4);
		ds.them(sach5);
		ds.them(sach6);
		int opt;
		do {
		System.out.println("Chọn chức năng:");
		System.out.println("1. Hiển thị Danh sách sách:");
		System.out.println("2. Thêm sách:");
		System.out.println("3. Tính tổng thành tiền sách giáo khoa:");
		System.out.println("4. Tính tổng thành tiền sách tham khảo:");
		System.out.println("5. Hiển thị danh sách sách giáo khoa theo nhà xuất bản:");
		System.out.println("6. Tính tổng thành tiền cao nhất:");
		System.out.println("0. Thoát");
		Scanner nhap=new Scanner(System.in);
		opt=nhap.nextInt();		
		switch(opt) {
		case 1:
			System.out.println(ds);
			break;
		case 2:
			int a=1;
			do {
			System.out.println("Bạn muốn thêm sách gì?");
			System.out.println("1. Sách giáo khoa");
			System.out.println("2. Sách giáo tham khảo");
			a=nhap.nextInt();
			
			
			if(a==1) {
				System.out.println("Nhập mã sách:");
				nhap.nextLine();
				String maSach=nhap.nextLine();
				System.out.print("Nhập ngày tháng năm (dd/MM/yyyy):\n");
				String ngay = nhap.nextLine();
				DateTimeFormatter dinhDangNgay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate ngayNhap = LocalDate.parse(ngay, dinhDangNgay);
				System.out.println("Nhập đơn giá:\n");
				double donGia=nhap.nextDouble();
				System.out.println("Nhập số lượng:\n");
				int soLuong=nhap.nextInt();
				nhap.nextLine();
				System.out.println("Nhập nhà xuất bản");
				String nhaXuatBan=nhap.nextLine();
				System.out.println("Nhập tình trạng (cũ=false) (mới=true)");
				boolean tinhTrang=nhap.nextBoolean();
				if(ds.them(new SachGiaoKhoa(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, tinhTrang)))
					System.out.println("Thêm sách thành công");
				else {
						System.out.println("Thêm sách không thành công");
					}
				
			
			}
			else if(a==2) {
				System.out.println("Nhập mã sách:");
				nhap.nextLine();
				String maSach=nhap.nextLine();
				System.out.print("Nhập ngày tháng năm (dd/MM/yyyy):\n");
				String ngay = nhap.nextLine();
				DateTimeFormatter dinhDangNgay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate ngayNhap = LocalDate.parse(ngay, dinhDangNgay);
				System.out.println("Nhập đơn giá:\n");
				double donGia=nhap.nextDouble();
				System.out.println("Nhập số lượng:\n");
				int soLuong=nhap.nextInt();
				nhap.nextLine();
				System.out.println("Nhập nhà xuất bản");
				String nhaXuatBan=nhap.nextLine();
				System.out.println("Nhập thuế");
				double thue=nhap.nextDouble();	
				if(ds.them(new SachThamKhao(maSach, ngayNhap, donGia, soLuong,nhaXuatBan, thue)))
					System.out.println("Thêm sách thành công");
				else {
					System.out.println("Thêm sách không thành công");
				}
				}
			}
			while(a!=1 && a!=2);
			break;
		case 3:
			DecimalFormat tien= new DecimalFormat("#,###.00VND");
			System.out.println("Tổng tiền của sách giáo khoa: " + tien.format(ds.tinhTongThanhTienSachGiaoKhoa()));
			break;
		case 4:
			tien= new DecimalFormat("#,###.00VND");
			System.out.println("Tổng tiền của sách tham khảo: " + tien.format(ds.tinhTongThanhTienSachThamKhao()));
			break;
		case 5:
			System.out.println("Nhập tên nhà xuất bản:");
			nhap.nextLine();
			String k=nhap.nextLine();
			System.out.println(ds.timSachGiaoKhoaTheoNhaXuatBan(k));
			break;
		case 6:
			tien= new DecimalFormat("#,###.00VND");
			System.out.println("Thành tiền lớn nhất: "+tien.format(ds.timThanhTienCaoNhat()));
			break;
			
		}
		}while(opt>=1 && opt<=6);
	

	}
}
