package phanHoaiBao.bai02;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class SachThamKhao extends Sach{
	private double thue;

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		if(thue>0)
			this.thue = thue;
		else {
			this.thue=0;
		}
	}

	public SachThamKhao() {
		super();
		thue=0;
	}

	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan,double thue) {
		super(maSach, ngayNhap,donGia,soLuong,nhaXuatBan);
		this.thue = thue;
	}
	@Override
	public double getThanhTien() {
		return super.getThanhTien()+thue;
		
	}

	@Override
	public String toString() {
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		return super.toString()+String.format("%15f %15s", thue,tien.format(getThanhTien()));
	}
	

	

}
