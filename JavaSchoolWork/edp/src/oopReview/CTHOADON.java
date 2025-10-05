package oopReview;

public class CTHOADON {
	private int soLuong;
	private SANPHAM sanPham;
	
	public CTHOADON(int soLuong, SANPHAM sanPham) {
		super();
		this.soLuong = soLuong;
		this.sanPham = sanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public SANPHAM getSanPham() {
		return sanPham;
	}
	public void setSanPham(SANPHAM sanPham) {
		this.sanPham = sanPham;
	}
	public double tinhTong() {
		return sanPham.getGia()*soLuong;
	}
	public static String getTieuDe() {
		return SANPHAM.getTieuDe()+String.format("%10s %20s", "Số Lương","Thành Tiền");
		
	}
	@Override
	public String toString() {
		String s=CTHOADON.getTieuDe()+"\n";
		s+=String.format("%s %10d %20f", sanPham,soLuong,tinhTong());
		return s;
	}
	
	
}
