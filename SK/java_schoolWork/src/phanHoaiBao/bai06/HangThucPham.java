package phanHoaiBao.bai06;

import java.time.LocalDate;import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa{
	private String nhaCungCap;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;
	
	
	
	public HangThucPham(String maHang, String tenHang, double donGia, double soLuongTon, String nhaCungCap,
			LocalDate ngaySanXuat, LocalDate ngayHetHan) {
		super(maHang, tenHang, donGia, soLuongTon);
		setNhaCungCap(nhaCungCap);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}
	
	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		if(!nhaCungCap.trim().equals(""))
			this.nhaCungCap = nhaCungCap;
		else
			this.nhaCungCap="chưa xác định";
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if(ngaySanXuat.isBefore(LocalDate.now()))
			this.ngaySanXuat = ngaySanXuat;
		else
			this.ngaySanXuat=LocalDate.now();
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if(ngayHetHan.isAfter(ngaySanXuat))
			this.ngayHetHan = ngayHetHan;
		else
			this.ngayHetHan=LocalDate.now();
	}

	@Override
	public String danhGiaMucDoBanBuon() {
		if(getSoLuongTon()>0 && ngayHetHan.isBefore(LocalDate.now()))
			return "khó bán";
		else
			return "không đánh giá";
	}
	@Override
	public double tinhTienVAT() {
		
		return getDonGia()*0.05;
	}
	public static String getTieuDe() {	
		return HangHoa.getTieuDe()+String.format("%20s %20s %20s","Nhà Cung cấp","Ngày sản xuất","Ngày hết hạn");
	}
	@Override
	public String toString() {
		DateTimeFormatter tg=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return super.toString()+String.format("%20s %20s %20s",nhaCungCap,tg.format(ngaySanXuat),tg.format(ngayHetHan));
	}
	
}
