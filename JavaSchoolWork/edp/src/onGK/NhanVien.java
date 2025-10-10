package onGK;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable{ 
	private String ma;
	private String hoTen;
	private int tuoi;
	private double luong;
	private boolean gioiTinh;
	public NhanVien(String ma, String hoTen, int tuoi, double luong, boolean gioiTinh) {
		super();
		this.ma = ma;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.luong = luong;
		this.gioiTinh = gioiTinh;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	@Override
	public String toString() {
		return "NhanVien [ma=" + ma + ", hoTen=" + hoTen + ", tuoi=" + tuoi + ", luong=" + luong + ", gioiTinh="
				+ gioiTinh + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ma);
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
		return Objects.equals(ma, other.ma);
	}
	
	
	

}
