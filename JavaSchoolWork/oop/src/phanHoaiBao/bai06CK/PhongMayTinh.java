package phanHoaiBao.bai06CK;

public class PhongMayTinh extends PhongHoc {
	private int soMayTinh;

	public PhongMayTinh(int soMayTinh) {
		super();
		this.soMayTinh = 0;
	}

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
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
	public boolean kiemTraDatChuan() {
		if(super.kiemTraDatChuan() && getDienTich()/soMayTinh<=1.5)
			return true;
		else
			return false;
	}
	public static String getTieuDe() {
		return PhongHoc.getTieuDe()+String.format("%15s %15s", "Số máy tính","Đạt chuẩn");
	}

	@Override
	public String toString() { 
		return super.toString()+String.format("%15d %15s", soMayTinh,kiemTraDatChuan() ? "Đạt":"Không");
	}
	
	
	
}
