package onGK01;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable{
	private String ma;
	private String hoTen;
	private int tuoi;
	private String phongBan;
	private double tienLuong;
	public NhanVien(String ma, String hoTen, int tuoi, String phongBan, double tienLuong) {
		super();
		this.ma = ma;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.phongBan = phongBan;
		this.tienLuong = tienLuong;
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
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public double getTienLuong() {
		return tienLuong;
	}
	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
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
