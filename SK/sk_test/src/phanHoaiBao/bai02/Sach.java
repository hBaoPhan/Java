package phanHoaiBao.bai02;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Sach {
	private String maSach;
	private LocalDate ngayNhap;
	private double donGia;
	private int soLuong;
	private String nhaXuatBan;
	public Sach() {
		super();
		maSach="000";
		ngayNhap=LocalDate.now();
		donGia=0;
		soLuong=0;
		nhaXuatBan="chua xac dinh";
	}
	public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super();
		setMaSach(maSach);
		setNgayNhap(ngayNhap);
		setDonGia(donGia);
		setSoLuong(soLuong);
		setNhaXuatBan(nhaXuatBan);
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		if(!maSach.trim().equalsIgnoreCase(""))
			this.maSach = maSach;
		else {
			this.maSach="000";
		}
	}
	public LocalDate getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(LocalDate ngayNhap) {
		if(ngayNhap.isBefore(LocalDate.now()))
			this.ngayNhap = ngayNhap;
		else {
			this.ngayNhap=LocalDate.now();		
			}
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		if(donGia>0)
			this.donGia = donGia;
		else {
			this.donGia=0;
		}
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		if(soLuong>0)
			this.soLuong = soLuong;
		else {
			this.soLuong=0;
		}
	}
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		if(!nhaXuatBan.trim().equalsIgnoreCase(""))
			this.nhaXuatBan = nhaXuatBan;
		else {
			this.nhaXuatBan=" chưa xác định";
		}
	}
	public double getThanhTien() {
		return soLuong*donGia;
	}
	public static String getTieuDe() {
		return String.format("%15s %15s %15s %15s %15s %15s %15s", "Mã sách","Ngày Nhập","Đơn Giá","Số Lượng","Nhà Xuất bản","Tình Trạng/Thuế","Thành Tiền");
		
	}
	@Override
	public String toString() {
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		DateTimeFormatter tg=DateTimeFormatter.ofPattern("dd/MM/yy");
		return String.format("%15s %15s %15s %15d %15s", maSach,tg.format(ngayNhap),tien.format(donGia),soLuong,nhaXuatBan);
	}
	
	

}
