package FinalStretch;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class HocPhanTrucTiep extends HocPhan {
	private String diaChi;
	private String ngayGioHoc;
	public HocPhanTrucTiep() {
		super();
		diaChi="chưa xác định";
		ngayGioHoc="chưa xác định";
	}
	public HocPhanTrucTiep(String maSo, String hoTen, double hocPhi, LocalDate ngayBatDau, LocalDate ngayKetThuc,
			double diemMucTieu, double diemKetQua, String diaChi, String ngayGioHoc) {
		super(maSo, hoTen, hocPhi, ngayBatDau, ngayKetThuc, diemMucTieu, diemKetQua);
		this.diaChi = diaChi;
		this.ngayGioHoc = ngayGioHoc;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		if(!diaChi.trim().equalsIgnoreCase(""))
			this.diaChi = diaChi;
		else
			this.diaChi="chưa xác định";
	}
	public String getNgayGioHoc() {
		return ngayGioHoc;
	}
	public void setNgayGioHoc(String ngayGioHoc) {
		if(!ngayGioHoc.trim().equalsIgnoreCase(""))
			this.ngayGioHoc = ngayGioHoc;
		else
			this.ngayGioHoc="chưa xác định";
	}
	public static String getTieuDe() {
		return HocPhan.getTieuDe()+String.format("%15s %15s %15s","Địa chỉ","Ngày giờ học","Khen Thưởng" );
		
	}
	@Override
	public String toString() {
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		return super.toString()+String.format("%15s %15s %15s", diaChi,ngayGioHoc,tien.format(super.kiemTraKhenThuong()));
	}
	
	
	
	
	
}
