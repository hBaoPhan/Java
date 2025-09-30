package oopReview;

public class SANPHAM {
	private String ma;
	private String ten;
	private double gia;
	
	public SANPHAM(String ma, String ten, double gia) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.gia = gia;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}
	public static String getTieuDe() {
		return String.format("%5s %30s","Tên Hàng","Đơn giá");
	}
	@Override
	public String toString() {
		return String.format("%5s %30s",ten,gia);
	}
	
	
	

}
