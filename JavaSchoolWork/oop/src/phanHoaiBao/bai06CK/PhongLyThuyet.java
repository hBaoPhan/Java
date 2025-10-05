package phanHoaiBao.bai06CK;

public class PhongLyThuyet extends PhongHoc {
	private boolean coMayChieu;

	public PhongLyThuyet() {
		super();
		coMayChieu=false;
	}

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		setCoMayChieu(coMayChieu);
	}

	public boolean isCoMayChieu() {
		return coMayChieu;
	}

	public void setCoMayChieu(boolean coMayChieu) {
		if(coMayChieu==false)
			this.coMayChieu = false;
		else
			this.coMayChieu= true;
	}
	public boolean kiemTraDatChuan() {
		if(super.kiemTraDatChuan() && coMayChieu)
			return true;
		else
			return false;
	}
	public static String getTieuDe() {
		return PhongHoc.getTieuDe()+String.format("%15s %15s", "Máy chiếu","Đạt chuẩn");
	}

	@Override
	public String toString() {
		return super.toString()+String.format("%15s %15s", coMayChieu ? "Có" : "Không",kiemTraDatChuan() ? "Đạt":"Không");
	}
	
	
	
	
	
}
