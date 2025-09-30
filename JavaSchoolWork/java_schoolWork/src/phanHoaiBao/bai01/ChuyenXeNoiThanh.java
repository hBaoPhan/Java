package phanHoaiBao.bai01;

public class ChuyenXeNoiThanh extends ChuyenXe{
	private String soTuyen;
	private double soKmDiDuoc;
	public ChuyenXeNoiThanh() {
		super();
		soTuyen = "0";
		soKmDiDuoc = 0;
		
	}

	public ChuyenXeNoiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu, String soTuyen,double soKmDiDuoc) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		setSoTuyen(soTuyen);
		setSoKmDiDuoc(soKmDiDuoc);
	}

	public String getSoTuyen() {
		return soTuyen;
	}
	public void setSoTuyen(String soTuyen) {
		if(!soTuyen.trim().equalsIgnoreCase(""))
			this.soTuyen = soTuyen;
		else {
			this.soTuyen="0";
		}
	}
	public double getSoKmDiDuoc() {
		return soKmDiDuoc;
	}
	public void setSoKmDiDuoc(double soKmDiDuoc) {
		if(soKmDiDuoc>0)
			this.soKmDiDuoc = soKmDiDuoc;
		else {
			this.soKmDiDuoc=0;
		}
	}
	@Override
	public String toString() {
		return super.toString()+String.format("%20s %35f", soTuyen,soKmDiDuoc);
	}
	
	
	
	
	
	
	

}
