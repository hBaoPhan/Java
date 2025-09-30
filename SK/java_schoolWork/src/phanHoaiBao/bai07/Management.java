package phanHoaiBao.bai07;

import java.util.Arrays;
import java.util.Comparator;

public class Management {
	private Person[] ds;
	private int count;
	
	public Management(int n) {
		ds=new Person[n];
		count=0;
	}
	public boolean them(Person p) {
		if(count<ds.length)
		{
			ds[count++]=p;
			return true;
		}
		return false;
	}
	private int timKiem(String hoten) {
		for (int i = 0; i < count; i++) {
			if(ds[i].getHoTen().compareTo(hoten)==0) {
				return i;
			}
		}
		return -1;
	}
	public boolean xoa(String hoten) {
		int viTri=timKiem(hoten);
		for (int i = viTri; i < count; i++) {
			ds[i]=ds[i+1];
		}
		count--;
		return true;
	}
	public Person[] sapXepTheoHoTen() {
		Person[] a=Arrays.copyOf(ds, count);
		Arrays.sort(a,new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				
				return o1.getHoTen().compareToIgnoreCase(o2.getHoTen());
			}
		});
		return a;
	}
	@Override
	public String toString() {
		String s=Person.getTieuDe()+"\n";
		for (int i = 0; i < count; i++) {
			s+=ds[i]+"\n";
		}
		return s;
	}
	

}
