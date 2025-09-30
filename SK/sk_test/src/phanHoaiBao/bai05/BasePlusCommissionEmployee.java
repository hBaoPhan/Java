package phanHoaiBao.bai05;

public class BasePlusCommissionEmployee extends CommissionEmployee{
	private double baseSalary;

	public BasePlusCommissionEmployee() {
		super();
		baseSalary=0;
	}

	

	public BasePlusCommissionEmployee(String firstName, String lastName, String sSN, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, sSN, grossSales, commissionRate);
		setBaseSalary(baseSalary);
	}



	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if(baseSalary>0)
			this.baseSalary = baseSalary;
		else
			this.baseSalary=0;
	}
	public double tinhLuong() {
		
		return super.tinhLuong()+baseSalary;
		
	}

	@Override
	public String toString() {
		return "base salaried "+super.toString()+";\nbase salary: "+baseSalary;
	}
	
	
	
	
	

}
