package phanHoaiBao.bai06Module4List;

public class PhongMayTinh extends PhongHoc{
	private int soMayTinh;

	
	public PhongMayTinh() {
		super();
		soMayTinh=0;
	}
	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongden, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongden);
		setSoMayTinh(soMayTinh);
	}

	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) {
		if(soMayTinh>0)
			this.soMayTinh = soMayTinh;
		else
			this.soMayTinh=0;
	}
	public static String getTieuDe() {
		return PhongHoc.getTieuDe()+String.format("%15s %15s","Số Máy Tính", "Đạt chuẩn");
	}
	
	@Override
	public String toString() {
		return super.toString()+String.format("%15d %15s", soMayTinh,kiemTraDatChuan()?"Có":"Không");
	}

	@Override
	public boolean kiemTraDatChuan() {
		if(getDienTich()/getSoBongden()>1 && getDienTich()/soMayTinh>1.5)
			return true;
		else
			return false;
	}
	
	
	
	
}
