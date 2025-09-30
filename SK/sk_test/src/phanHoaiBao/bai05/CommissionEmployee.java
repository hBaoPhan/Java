package phanHoaiBao.bai05;

public class CommissionEmployee extends Employee{
	private double grossSales;
	private double commissionRate;
	
	
	
	public CommissionEmployee() {
		super();
		grossSales=0;
		commissionRate=0;
	}
	
	public CommissionEmployee(String firstName, String lastName, String sSN, double grossSales, double commissionRate) {
		super(firstName, lastName, sSN);
		setGrossSales(grossSales);
		setCommissionRate(commissionRate);
	}
	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		if(grossSales>0)
			this.grossSales = grossSales;
		else
			this.grossSales=0;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		if(commissionRate>0)
			this.commissionRate = commissionRate;
		else
			this.commissionRate=0;
	}

	@Override
	public double tinhLuong() {
		
		return commissionRate*grossSales;
		
	}

	@Override
	public String toString() {
		return "commission employee: "+super.toString()+"\ngross sales: "+grossSales+";\ncommission rate: "+commissionRate+"\nLương: "+tinhLuong();
	}
	
	
	
}
