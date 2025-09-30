package phanHoaiBao.bai03;

import java.text.DecimalFormat;
import java.time.LocalDate;
/**
 * tinhTrang false là sách cũ
 * tinhTrang true là sách mới
 */
public class SachGiaoKhoa extends Sach{
	private boolean tinhTrang;

	public boolean getTinhTrang() {
		return tinhTrang;
	}


	public void setTinhTrang(boolean tinhTrang) {
		if(tinhTrang==false || tinhTrang==true)
			this.tinhTrang = tinhTrang;
		else
			this.tinhTrang=false;
	}

	public SachGiaoKhoa() {
		super();
		tinhTrang=false;
	}

	
	public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan,
			boolean tinhTrang) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		setTinhTrang(tinhTrang);
	}

	@Override
	public double getThanhTien() {
		if(tinhTrang==true) {
			return super.getThanhTien();
		}
		return super.getThanhTien()*0.5;
	}

	@Override
	public String toString() {
		DecimalFormat tien=new DecimalFormat("#,###.00VND");
		String d="mới";
		if(tinhTrang==false) {
			d="cũ";
		}		
		return super.toString()+String.format("%15s %15s", d,tien.format(getThanhTien()));
	}
	
	
	

}
