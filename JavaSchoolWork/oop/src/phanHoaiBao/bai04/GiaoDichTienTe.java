package phanHoaiBao.bai04;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GiaoDichTienTe extends GiaoDich{
	private double tiGia;
	private String loaiTienTe;
	
	public GiaoDichTienTe() {
		super();
		tiGia=0;
		loaiTienTe="chưa xác định";
	}

	public GiaoDichTienTe(String maGD, LocalDate ngayGD, double donGia, int soLuong, double tiGia, String loaiTienTe) {
		super(maGD, ngayGD, donGia, soLuong);
		setTiGia(tiGia);
		setLoaiTienTe(loaiTienTe);
	}

	public double getTiGia() {
		return tiGia;
	}

	public void setTiGia(double tiGia) {
		if(tiGia>0)
			this.tiGia = tiGia;
		else
			this.tiGia=0;
	}

	public String getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(String loaiTienTe) {
		if(loaiTienTe.equalsIgnoreCase("VN") || loaiTienTe.equalsIgnoreCase("USD") || loaiTienTe.equalsIgnoreCase("Euro"))
			this.loaiTienTe = loaiTienTe;
		else
			this.loaiTienTe="chưa xác định";
	}
	public double getThanhTien() {
		if(loaiTienTe.equalsIgnoreCase("VN"))
			return super.getThanhTien();
		else if(loaiTienTe.equalsIgnoreCase("USD") || loaiTienTe.equalsIgnoreCase("Euro"))
			return super.getThanhTien()*tiGia;
		else
			return 0;
		
	}

	@Override
	public String toString() {
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		return super.toString()+String.format("%30s %15s %25s", tiGia,loaiTienTe,tien.format(getThanhTien()));
	}
	
	
	
}
