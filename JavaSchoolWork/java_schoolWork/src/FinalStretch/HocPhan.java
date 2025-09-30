package FinalStretch;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HocPhan implements Comparable<HocPhan>{
	private String maSo;
	private String hoTen;
	private double hocPhi;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThuc;
	private double diemMucTieu;
	private double diemKetQua;
	
	public HocPhan() {
		maSo="chưa xác định";
		hoTen="chưa xác định";
		hocPhi=0;
		ngayBatDau=LocalDate.now();
		ngayKetThuc=LocalDate.now();
		diemKetQua=0;
		diemMucTieu=0;
	}

	public HocPhan(String maSo, String hoTen, double hocPhi, LocalDate ngayBatDau, LocalDate ngayKetThuc,
			double diemMucTieu, double diemKetQua) {
		
		setMaSo(maSo);
		setHoTen(hoTen);
		setHocPhi(hocPhi);
		setNgayBatDau(ngayBatDau);
		setNgayKetThuc(ngayKetThuc);
		setDiemKetQua(diemKetQua);
		setDiemMucTieu(diemMucTieu);
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		if(!maSo.trim().equalsIgnoreCase(""))
			this.maSo = maSo;
		else
			this.maSo="chưa xác định";
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		if(!hoTen.trim().equalsIgnoreCase(""))
			this.hoTen = hoTen;
		else
			this.hoTen="chưa xác định";
	}

	public double getHocPhi() {
		return hocPhi;
	}

	public void setHocPhi(double hocPhi) {
		if(hocPhi>0)
			this.hocPhi = hocPhi;
		else
			this.hocPhi=0;
	}

	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		if(ngayBatDau.isAfter(LocalDate.now()))
			this.ngayBatDau = ngayBatDau;
		else
			this.ngayBatDau=LocalDate.now();
	}

	public LocalDate getNgayKetThuc() {
		
		return ngayKetThuc;
	}

	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		if(ngayKetThuc.isAfter(ngayBatDau))
			this.ngayKetThuc = ngayKetThuc;
		else
			this.ngayKetThuc=LocalDate.now();
	}

	public double getDiemMucTieu() {
		return diemMucTieu;
	}

	public void setDiemMucTieu(double diemMucTieu) {
		if(diemMucTieu>0)
			this.diemMucTieu = diemMucTieu;
		else
			this.diemMucTieu=0;
	}

	public double getDiemKetQua() {
		return diemKetQua;
	}

	public void setDiemKetQua(double diemKetQua) {
		if(diemKetQua>0)
			this.diemKetQua = diemKetQua;
		else
			this.diemKetQua=0;
	}
	public double kiemTraKhenThuong() {
		if(diemKetQua>=diemMucTieu)
			return hocPhi*0.2;
		else 
			return 0;
	}
	public static String getTieuDe() {
		return String.format("%15s %15s %15s %15s %15s %15s %15s", "Mã số","Họ tên","Học phí","Ngày bắt đầu","Ngày kết thúc","Điểm mục tiêu","Điểm kết quả");
		
	}
	@Override
	public String toString() {
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		DateTimeFormatter tg=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%15s %15s %15s %15s %15s %15f %15f",maSo,hoTen,tien.format(hocPhi),tg.format(ngayBatDau),tg.format(ngayKetThuc),diemMucTieu,diemKetQua);
	}

	@Override
	public int compareTo(HocPhan o) {
		
		return Double.compare( o.kiemTraKhenThuong(),kiemTraKhenThuong());
	}
	
	
	
	
	

}
