package phanHoaiBao.bai06;

public abstract class HangHoa{
	private String maHang;
	private String tenHang;
	private double donGia;
	private double soLuongTon;
	public HangHoa() {
		super();
		maHang="chưa xác định";
		tenHang="xxx";
		donGia=0;
		soLuongTon=0;
	}
	public HangHoa(String maHang, String tenHang, double donGia, double soLuongTon) {
		setMaHang(maHang);
		setTenHang(tenHang);
		setDonGia(donGia);
		setSoLuongTon(soLuongTon);
	}
	public String getMaHang() {
		return maHang;
	}
	private void setMaHang(String maHang) {
		if(!maHang.trim().equals(""))
			this.maHang = maHang;
		else
			this.maHang="chưa xác định";
	}
	
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		if(!tenHang.trim().equals(""))
			this.tenHang = tenHang;
		else
			this.tenHang="chưa xác định";
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		if(donGia>=0)
			this.donGia = donGia;
		else
			this.donGia=0;
	}
	public double getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(double soLuongTon) {
		if(soLuongTon>=0)
			this.soLuongTon = soLuongTon;
		else
			this.soLuongTon=0;
	}
	public static String getTieuDe() {
		return String.format("%15s %15s %15s %15s ", "Mã Hàng","Tên hàng","Đơn giá","Số lượng tồn");
	}
	@Override
	public String toString() {
		return String.format("%15s %15s %15f %15f", maHang,tenHang,donGia,soLuongTon);
	}
	public abstract String danhGiaMucDoBanBuon() ;
	
	public abstract double tinhTienVAT();
	

}
