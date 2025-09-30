package phanHoaiBao.bai07;

public class test {
	public static void main(String[] args) {
//		System.out.println(Person.getTieuDe());
//		Person p1=new Customer("Bao", "GGGG", "Bao", 6,"Good");
//		System.out.println(p1);
		
		Management ds=new Management(10);
		ds.them(new Customer("Bao", "GGGG", "Bao", 6,"Good"));
		ds.them(new Student("A", "1/2/3 ABC", 10, 10));
		ds.them(new Employee("Hung", "AAAA", 10000));
		ds.them(new Employee("Cuong", "AAAA", 10000));
		
		System.out.println(ds);
		ds.xoa("Cuong");
		System.out.println(Person.getTieuDe());
		Person[] a=ds.sapXepTheoHoTen();
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
