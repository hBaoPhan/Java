package phanHoaiBao.bai07;

public class Customer extends Person {
	private String tenCongty;
	private double triGiaHoaDon;
	private String danhGia;
	
	
	public Customer() {
		super();
		tenCongty="chưa xác định";
		triGiaHoaDon=0;
		danhGia="chưa xác định";
	}
	
	public Customer(String hoTen, String diaChi, String tenCongty, double triGiaHoaDon, String danhGia) {
		super(hoTen, diaChi);
		setTenCongty(tenCongty);
		setTriGiaHoaDon(triGiaHoaDon);
		setDanhGia(danhGia);
	}
	
	public String getTenCongty() {
		return tenCongty;
	}

	public void setTenCongty(String tenCongty) {
		if(!tenCongty.trim().equals(""))
			this.tenCongty = tenCongty;
		else
			this.tenCongty="chưa xác định";
	}

	public double getTriGiaHoaDon() {
		return triGiaHoaDon;
	}

	public void setTriGiaHoaDon(double triGiaHoaDon) {
		if(triGiaHoaDon>0)
			this.triGiaHoaDon = triGiaHoaDon;
		else
			this.triGiaHoaDon=0;
	}

	public String getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(String danhGia) {
		if(!danhGia.trim().equals(""))
			this.danhGia = danhGia;
		else
			this.danhGia="String";
	}

	@Override
	public String danhGia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return super.toString() +String.format("%15s %15s %15s %15s %15s %15s %15f %15s", " "," "," "," "," ",tenCongty,triGiaHoaDon,danhGia);
	}
	
	

}
