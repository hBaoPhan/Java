package FinalStretch;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class HocPhanTrucTuyen extends HocPhan{
	private String linkHoc;

	public HocPhanTrucTuyen() {
		super();
		linkHoc="chưa xác định";
		
	}

	public HocPhanTrucTuyen(String maSo, String hoTen, double hocPhi, LocalDate ngayBatDau, LocalDate ngayKetThuc,
			double diemMucTieu, double diemKetQua, String linkHoc) {
		super(maSo, hoTen, hocPhi, ngayBatDau, ngayKetThuc, diemMucTieu, diemKetQua);
		setLinkHoc(linkHoc);
	}

	public String getLinkHoc() {
		return linkHoc;
	}

	public void setLinkHoc(String linkHoc) {
		if(!linkHoc.trim().equalsIgnoreCase(""))
			this.linkHoc = linkHoc;
		else
			this.linkHoc="chưa xác định";
	}
	public static String getTieuDe() {
		return HocPhan.getTieuDe()+String.format("%15s %15s","Link Học","Khen thưởng" );
	}
	public double kiemTraKhenThuong() {
//		if(getDiemKetQua()==getDiemMucTieu())
//			return getHocPhi()*0.2;
		if(getDiemKetQua()>=getDiemMucTieu())
			
			return (getHocPhi()*0.2)+(((getDiemKetQua()-getDiemMucTieu())/100)*(getHocPhi()*0.1));
		else
			return 0;
			
	}
	@Override
	public String toString() {
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		return super.toString() + String.format("%15s %15s", linkHoc,tien.format(kiemTraKhenThuong()));
	}
	
	
}
