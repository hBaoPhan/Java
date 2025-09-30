package stt02_PhanHoaibao_tuan4;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {
	private String maNV;
	private String hoNV;
	private String tenNV;
	private int tuoi;
	private boolean phai;
	private double luong;
	public NhanVien(String maNV, String hoNV, String tenNV,boolean phai, int tuoi, double luong) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.phai = phai;
		this.tuoi = tuoi;
		this.luong = luong;
	}
	public String getHoNV() {
		return hoNV;
	}
	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public boolean getPhai() {
		return phai;
	}
	
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	public String getMaNV() {
		return maNV;
	}
	
	
}
