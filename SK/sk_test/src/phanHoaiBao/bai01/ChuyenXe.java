package phanHoaiBao.bai01;

import java.text.DecimalFormat;

public class ChuyenXe {
	private String maSoChuyen;
	private String hoTenTaiXe;
	private String soXe;
	private double doanhThu;
	
	
	public ChuyenXe() {
		maSoChuyen="000";
		hoTenTaiXe="chua xac dinh";
		soXe="chua xac dinh";
		doanhThu=0;
		
	}
	
	public ChuyenXe(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu) {
		
		setMaSoChuyen(maSoChuyen);
		setHoTenTaiXe(hoTenTaiXe);
		setSoXe(soXe);
		setDoanhThu(doanhThu);
	}
	public String getMaSoChuyen() {
		return maSoChuyen;
	}
	public void setMaSoChuyen(String maSoChuyen) {
		if(!maSoChuyen.trim().equalsIgnoreCase(""))
			this.maSoChuyen = maSoChuyen;
		else
			this.maSoChuyen="000";
	}
	public String getHoTenTaiXe() {
		return hoTenTaiXe;
	}
	public void setHoTenTaiXe(String hoTenTaiXe) {
		if(!hoTenTaiXe.trim().equalsIgnoreCase(""))
			this.hoTenTaiXe = hoTenTaiXe;
		else {
			this.hoTenTaiXe="chưa xác định";
		}
	}
	public String getSoXe() {
		return soXe;
	}
	public void setSoXe(String soXe) {
		if(!soXe.trim().equalsIgnoreCase(""))
			this.soXe = soXe;
		else {
			this.soXe="00000";
		}
	}
	public double getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(double doanhThu) {
		if(doanhThu>0)
			this.doanhThu = doanhThu;
		else {
			this.doanhThu=0;
		}
	}
	public static String getTieuDe() {
		return String.format("%15s %15s %15s %15s %20s %35s", "Mã Số Chuyến","Họ Tên Tài xế","Số Xe","Doanh thu","Số Tuyến/Nơi đến","Số Km đi dược/ Số ngày đi được");
	}
	@Override
	public String toString() {
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		return String.format("%15s %15s %15s %15s", maSoChuyen,hoTenTaiXe,soXe,tien.format(doanhThu));
	}
	
	
	
	
	
	

}
