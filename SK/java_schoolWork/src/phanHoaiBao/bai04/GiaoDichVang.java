package phanHoaiBao.bai04;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GiaoDichVang extends GiaoDich{
	private String loaiVang;

	public GiaoDichVang() {
		super();
		loaiVang="chưa xác định";
	}


	public GiaoDichVang(String maGD, LocalDate ngayGD, double donGia, int soLuong, String loaiVang) {
		super(maGD, ngayGD, donGia, soLuong);
		setLoaiVang(loaiVang);
	}
	
	public String getLoaiVang() {
		return loaiVang;
	}

	public void setLoaiVang(String loaiVang) {
		if(!loaiVang.trim().equals(""))
			this.loaiVang = loaiVang;
		else
			this.loaiVang="Chưa xác định";
	}

	
	public double getThanhTien() {
		return super.getThanhTien();
		
	}

	@Override
	public String toString() {
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		return super.toString()+String.format("%30s %15s %25s", loaiVang,"",tien.format(getThanhTien()));
	}
	
	

	
	
	
	
}
