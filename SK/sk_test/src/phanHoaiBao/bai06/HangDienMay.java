package phanHoaiBao.bai06;

public class HangDienMay extends HangHoa{
	private double thoiGianBaoHanh;
	private double congSuat;

	public HangDienMay(String maHang, String tenHang, double donGia, double soLuongTon, double thoiGianBaoHanh,
			double congSuat) {
		super(maHang, tenHang, donGia, soLuongTon);
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.congSuat = congSuat;
	}


	public double getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}


	public void setThoiGianBaoHanh(double thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}


	public double getCongSuat() {
		return congSuat;
	}


	public void setCongSuat(double congSuat) {
		this.congSuat = congSuat;
	}


	@Override
	public String danhGiaMucDoBanBuon() {
		if(getSoLuongTon()<3)
			return "bán được";
		else
			return "không đánh giá";
	}


	@Override
	public double tinhTienVAT() {
		
		return getDonGia()*0.1;
	}
	
	public static String getTieuDe() {
		return HangHoa.getTieuDe()+String.format("%20s %20s", "Thời gian bảo hành","Công suất");
		
	}

	@Override
	public String toString() {
		return super.toString()+String.format("%20f %20f",thoiGianBaoHanh,congSuat);
	}


	
	

}
