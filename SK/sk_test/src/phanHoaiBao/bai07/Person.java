package phanHoaiBao.bai07;

public abstract class Person {
	private String hoTen;
	private String diaChi;
	public Person() {
		hoTen="chưa xác định";
		diaChi="chưa xác định";
	}
	public Person(String hoTen, String diaChi) {
		super();
		setHoTen(hoTen);
		setDiaChi(diaChi);
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		if(!hoTen.trim().equals(""))
			this.hoTen = hoTen;
		else
			this.hoTen="chua xác định";
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		if(!diaChi.trim().equals(""))
			this.diaChi = diaChi;
		else
			this.diaChi="chưa xác định";
	}
	public static String getTieuDe() {
		return String.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s", "Họ Tên","Địa Chỉ","Điểm Môn học 1","Điểm Môn học 2","Điểm Trung Bình","Hệ Số Lương","Lương","Tên Công Ty","Trị Giá hóa Đơn","Đánh giá");
		
	}
	public abstract String danhGia();
	@Override
	public String toString() {
		return String.format("%15s %15s",hoTen, diaChi);
	}
	
	

}
