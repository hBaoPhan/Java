package phanHoaiBao.bai05;

import java.text.DecimalFormat;

public class HourlyEmployee extends Employee{
	private double wage;
	private double hours;
	
	
	public HourlyEmployee() {
		super();
		wage=0;
		hours=0;
	}
	public HourlyEmployee(String firstName, String lastName, String sSN, double wage, double hours) {
		super(firstName, lastName, sSN);
		setWage(wage);
		setHours(hours);
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		if(wage>0)
			this.wage = wage;
		else
			this.wage=0;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		if(hours>0)
			this.hours = hours;
		else
			this.hours=0;
	}
	@Override
	public double tinhLuong() {
		if(hours<=40)
			return wage*hours;
		else 
			return 40*wage+(hours-40)*wage*1.5;
		
	}
	@Override
	public String toString() {
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		return "hourly employee: "+super.toString()+"\nhourly wage: "+tien.format(wage)+"; hours worked: "+hours+"\nLương: "+tinhLuong();
	}
	
	
	

}
