package phanHoaiBao.bai05;

public class test {

	public static void main(String[] args) {
		Employee e1=new SalariedEmployee("Bảo", "Phan", "123456", 200000) ;
		Employee e2=new HourlyEmployee("A", "Phan", "123456", 20000,5) ;
		Employee e3=new CommissionEmployee("B", "Nguyễn", "123456", 20000,50) ;
		Employee e4=new BasePlusCommissionEmployee("B", "Nguyễn", "123456", 20000,60,500000);
//		System.out.println(e4);
		Employee[] ds=new Employee[4];
		ds[0]=e1;
		ds[1]=e2;
		ds[2]=e3;
		ds[3]=e4;
//		System.out.println(ds[0]);
		xuatMang(ds);
		

	}
	public static void xuatMang(Employee[] ds) {

		for (int i = 0; i < ds.length; i++) {	
		
			System.out.println(ds[i]+"\n");
		}
		
	}
}


