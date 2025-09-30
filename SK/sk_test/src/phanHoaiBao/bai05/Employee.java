package phanHoaiBao.bai05;

public abstract class Employee {
	private String firstName;
	private String lastName;
	private String SSN;
	public Employee() {
		firstName="chưa xác định";
		lastName="chưa xác định";
		SSN="chưa xác định";
		
	}
	public Employee(String firstName, String lastName, String sSN) {
		
		setFirstName(firstName);
		setLastName(lastName);
		setSSN(sSN);
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(!firstName.trim().equals(""))
			this.firstName = firstName;
		else
			this.firstName="chưa xác định";
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(!lastName.trim().equals(""))
			this.lastName = lastName;
		else
			this.lastName="chưa xác định";
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		if(!sSN.trim().equals(""))
			SSN = sSN;
		else
			this.SSN="chưa xác định";
	}
	
	public abstract double tinhLuong();
	@Override
	public String toString() {
		return String.format("%s %s\nSocial security number: %s", firstName,lastName,SSN);
	}
	

}
