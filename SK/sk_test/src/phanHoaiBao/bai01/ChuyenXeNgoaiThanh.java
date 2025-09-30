package phanHoaiBao.bai01;

public class ChuyenXeNgoaiThanh extends ChuyenXe{
	private String noiDen;
	private int soNgayDiDuoc;
	public ChuyenXeNgoaiThanh() {
		super();
		noiDen="chua xac dinh";
		soNgayDiDuoc=0;
	}
	public ChuyenXeNgoaiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu,String noiDen, int soNgayDiDuoc) {
		super(maSoChuyen,hoTenTaiXe,soXe,doanhThu);
		setNoiDen(noiDen);
		setSoNgayDiDuoc(soNgayDiDuoc);
	}
	public String getNoiDen() {
		return noiDen;
	}
	public void setNoiDen(String noiDen) {
		if(!noiDen.trim().equalsIgnoreCase(""))
			this.noiDen = noiDen;
		else {
			this.noiDen="chưa xác định";
		}
	}
	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}
	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		if(soNgayDiDuoc>0)
			this.soNgayDiDuoc = soNgayDiDuoc;
		else {
			this.soNgayDiDuoc=0;
		}
	}
	@Override
	public String toString() {
		return super.toString()+String.format("%20s %35d", noiDen,soNgayDiDuoc);
	}
	
	
	
	
	
	
	
	

}
