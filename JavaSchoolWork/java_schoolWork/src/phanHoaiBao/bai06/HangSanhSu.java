package phanHoaiBao.bai06;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangSanhSu extends HangHoa{
	private String nhaSanXuat;
	private LocalDate ngayNhapKho;
	
	
	
	public HangSanhSu(String maHang, String tenHang, double donGia, double soLuongTon, String nhaSanXuat,
			LocalDate ngayNhapKho) {
		super(maHang, tenHang, donGia, soLuongTon);
		setNhaSanXuat(nhaSanXuat);
		setNgayNhapKho(ngayNhapKho);
	}
	public String getNhaSanXuat() {
		return nhaSanXuat;
	}
	public void setNhaSanXuat(String nhaSanXuat) {
		if(!nhaSanXuat.trim().equals(""))
			this.nhaSanXuat = nhaSanXuat;
		else
			this.nhaSanXuat="chưa xác định";
	}
	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}
	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		if(ngayNhapKho.isBefore(LocalDate.now()))
			this.ngayNhapKho = ngayNhapKho;
		else
			this.ngayNhapKho=LocalDate.now();
	}
	@Override
	public String danhGiaMucDoBanBuon() {
		if(getSoLuongTon()>50 && Duration.between(ngayNhapKho, LocalDate.now()).toDays()>10)
			return "bán chậm";
		else
			return "không đánh giá";
	}

	@Override
	public double tinhTienVAT() {
		
		return getDonGia()*0.1;
	}
	public static String getTieuDe() {
		return HangHoa.getTieuDe()+String.format("%20s %20s","Nhà sản xuất","Ngày nhập kho");
	}
	@Override
	public String toString() {
		DateTimeFormatter tg=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return super.toString()+String.format("%20s %20s", nhaSanXuat,tg.format(ngayNhapKho));
	}
	
	

}
