package phanHoaiBao.bai07;

public class Employee extends Person {
	private double heSoluong;
	
	

	public Employee() {
		super();
		heSoluong=0;
	}
	
	public Employee(String hoTen, String diaChi, double heSoluong) {
		super(hoTen, diaChi);
		setHeSoluong(heSoluong);
	}
	public double getHeSoluong() {
		return heSoluong;
	}

	public void setHeSoluong(double heSoluong) {
		if(heSoluong>0)
			this.heSoluong = heSoluong;
		else
			this.heSoluong=0;
	}
	private double tinhLuong() {
		return heSoluong*1000;
	}
	
	

	@Override
	public String danhGia() {
		if(tinhLuong()>5000)
			return "Good";
		else
			return "Bad";
	}

	@Override
	public String toString() {
		return super.toString()+String.format("%15s %15s %15s %15f %15f"," "," "," ", heSoluong,tinhLuong());
	}
	
	

}
