package phanHoaiBao.bai07;

public class Student extends Person{
	private double diemMonHoc1;
	private double diemMonHoc2;
	
	public Student() {
		super();
		diemMonHoc1=0;
		diemMonHoc2=0;
	}
	
	public Student(String hoTen, String diaChi, double diemMonHoc1, double diemMonHoc2) {
		super(hoTen, diaChi);
		setDiemMonHoc1(diemMonHoc1);
		setDiemMonHoc2(diemMonHoc2);
	}
	



	public double getDiemMonHoc1() {
		return diemMonHoc1;
	}

	public void setDiemMonHoc1(double diemMonHoc1) {
		if(diemMonHoc1>0)
			this.diemMonHoc1 = diemMonHoc1;
		else
			this.diemMonHoc1=0;
	}

	public double getDiemMonHoc2() {
		return diemMonHoc2;
	}

	public void setDiemMonHoc2(double diemMonHoc2) {
		if(diemMonHoc2>0)
			this.diemMonHoc2 = diemMonHoc2;
		else
			this.diemMonHoc2=0;
	}
	public double tinhDiemTrungBinh() {
		return (diemMonHoc1+diemMonHoc2)/2;
	}

	@Override
	public String danhGia() {
		if(tinhDiemTrungBinh()>8)
			return "Good";
		else
			return "Bad";
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+String.format("%15f %15f %15f", diemMonHoc1,diemMonHoc2,tinhDiemTrungBinh());
	}
	

}
