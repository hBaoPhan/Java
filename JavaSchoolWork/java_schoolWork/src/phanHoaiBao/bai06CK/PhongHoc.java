package phanHoaiBao.bai06CK;

public class PhongHoc {
	private String maPhong;
	private String dayNha;
	private double dienTich;
	private int soBongDen;
	
	public PhongHoc() {
		maPhong="chưa xác định";
		dayNha="chưa xác định";
		dienTich=0;
		soBongDen=0;
	}

	public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
		setMaPhong(maPhong);
		setDayNha(dayNha);
		setDienTich(dienTich);
		setSoBongDen(soBongDen);
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		if(!maPhong.trim().equals(""))
			this.maPhong = maPhong;
		else
			this.maPhong="chưa xác định";
	}

	public String getDayNha() {
		return dayNha;
	}

	public void setDayNha(String dayNha) {
		if(!dayNha.trim().equals(""))
			this.dayNha = dayNha;
		else
			this.dayNha="chưa xác định";
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		if(dienTich>0)
			this.dienTich = dienTich;
		else
			this.dienTich=0;
	}

	public int getSoBongDen() {
		return soBongDen;
	}

	public void setSoBongDen(int soBongDen) {
		if(soBongDen>0)
			this.soBongDen = soBongDen;
		else
			this.soBongDen=0;
	}
	public boolean kiemTraDatChuan() {
		if(dienTich/soBongDen<=10)
			return true;
		else
			return false;
	}
	public static String getTieuDe() {
		return String.format("%15s %15s %15s %15s", "Mã Phòng","Dãy Nhà","Diện tích","Số bóng đèn");	
	}

	@Override
	public String toString() {
		return String.format("%15s %15s %15f %15d", maPhong,dayNha,dienTich,soBongDen);
	}
	
	
	
	
}
