package phanHoaiBao.bai04;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GiaoDich {
	private String maGD;
	private LocalDate ngayGD;
	private double donGia;
	private int soLuong;
	
	public String getMaGD() {
		return maGD;
	}
	public void setMaGD(String maGD) {
		if(!maGD.trim().equals(""))
			this.maGD = maGD;
		else
			this.maGD="chưa xác định";
	}
	public LocalDate getNgayGD() {
		return ngayGD;
	}
	public void setNgayGD(LocalDate ngayGD) {
		if(ngayGD.isBefore(LocalDate.now()))
			this.ngayGD = ngayGD;
		else
			this.ngayGD=LocalDate.now();
			
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		if(donGia>0)
			this.donGia = donGia;
		else
			this.donGia=0;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		if(soLuong>0)
			this.soLuong = soLuong;
		else
			this.soLuong=0;
	}
	public GiaoDich() {
		maGD="Chưa xác định";
		ngayGD=LocalDate.now();
		donGia=0;
		soLuong=0;
	}
	public GiaoDich(String maGD, LocalDate ngayGD, double donGia, int soLuong) {
		
		setMaGD(maGD);
		setNgayGD(ngayGD);
		setDonGia(donGia);
		setSoLuong(soLuong);
	}
	public double getThanhTien() {
		return donGia*soLuong;
		
	}
	public static String getTieuDe() {
		return String.format("%15s %15s %20s %15s %30s %15s %25s", "Mã Giao dịch","Ngày Giao dịch","Đơn giá","Số lượng","Loại vàng/ Tỉ giá","Loại tiền tệ","Thành tiền");
		
	}
	@Override
	public String toString() {
		DateTimeFormatter tg=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		return String.format("%15s %15s %20s %15d",maGD,tg.format(ngayGD),tien.format(donGia),soLuong);
	}
	
	
	
	

}
