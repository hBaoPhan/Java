package phanHoaiBao.bai05;

import java.text.DecimalFormat;

public class SalariedEmployee extends Employee{
	private double weeklySalary;
	
	
	
	

	public SalariedEmployee() {
		super();
		weeklySalary=0;
	}
	public SalariedEmployee(String firstName, String lastName, String sSN, double weeklySalary) {
		super(firstName, lastName, sSN);
		setWeeklySalary(weeklySalary);
	}
	
	public double getWeeklySalary() {
		return weeklySalary;
	}
	public void setWeeklySalary(double weeklySalary) {
		if(weeklySalary>0)
			this.weeklySalary = weeklySalary;
		else
			this.weeklySalary=0;
	}
	@Override
	public double tinhLuong() {
		return weeklySalary;
	}
	@Override
	public String toString() {
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		return "salaried employee: "+super.toString()+"\nweekly salary: "+tien.format(weeklySalary)+"\nLương: "+tinhLuong();
	}
	
	
	

}
