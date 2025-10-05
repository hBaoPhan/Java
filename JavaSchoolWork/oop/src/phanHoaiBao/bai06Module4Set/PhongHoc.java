package phanHoaiBao.bai06Module4Set;

import java.util.Objects;

public abstract class PhongHoc{
	private String maPhong;
	private String dayNha;
	private double dienTich;
	private int soBongden;
	
	public PhongHoc() {
		super();
	}
	public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongden) {
		super();
		setMaPhong(maPhong);
		setDayNha(dayNha);
		setDienTich(dienTich);
		setSoBongden(soBongden);
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		if(!maPhong.trim().equals(""))
			this.maPhong = maPhong;
		else
			this.maPhong="chưa xác định";
	}
	public String getDayNha() {
		return dayNha;
	}
	public void setDayNha(String dayNha) {
		if(!dayNha.trim().equals(""))
			this.dayNha = dayNha;
		else
			this.dayNha="chưa xác định";
	}	
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		if(dienTich>0)
			this.dienTich = dienTich;
		else
			this.dienTich=0;
	}
	public int getSoBongden() {
		return soBongden;
	}
	public void setSoBongden(int soBongden) {
		if(soBongden>0)
			this.soBongden = soBongden;
		else
			this.soBongden=0;
	}
	public abstract boolean kiemTraDatChuan();
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHoc other = (PhongHoc) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	public static String getTieuDe() {
		return String.format("%15s %15s %15s %15s","Mã Phòng","Dãy Nhà","Diện tích","Số bóng đèn");
		
	}
	@Override
	public String toString() {
		return String.format("%15s %15s %15f %15d", maPhong,dayNha,dienTich,soBongden);
	}
	
	
	
	
	
}
