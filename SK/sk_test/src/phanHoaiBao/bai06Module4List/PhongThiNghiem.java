package phanHoaiBao.bai06Module4List;

public class PhongThiNghiem extends PhongHoc{
	private String chuyenNganh;
	private int sucChua;
	private boolean coBonRua;
	
	
	public PhongThiNghiem() {
		super();
		chuyenNganh="chưa xác định";
		sucChua=0;
		coBonRua=false;
	}
	

	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongden, String chuyenNganh,
			int sucChua, boolean coBonRua) {
		super(maPhong, dayNha, dienTich, soBongden);
		setChuyenNganh(chuyenNganh);
		setSucChua(sucChua);
		setCoBonRua(coBonRua);
	}
	
	public String getChuyenNganh() {
		return chuyenNganh;
	}


	public void setChuyenNganh(String chuyenNganh) {
		if(!chuyenNganh.trim().equals(""))
			this.chuyenNganh = chuyenNganh;
		else
			this.chuyenNganh="chưa xác định";
	}


	public int getSucChua() {
		return sucChua;
	}


	public void setSucChua(int sucChua) {
		if(sucChua>0)
			this.sucChua = sucChua;
		else
			this.sucChua=0;
	}


	public boolean getCoBonRua() {
		return coBonRua;
	}


	public void setCoBonRua(boolean coBonRua) {
		if(coBonRua==false)
			this.coBonRua = false;
		else
			this.coBonRua=true;
	}
	public static String getTieuDe() {
		return PhongHoc.getTieuDe()+String.format("%15s %15s %15s %15s", "Chuyên Ngành","Sức chứa","Bồn rữa","Đạt chuẩn");
	}
	public String toString() {
		return super.toString()+String.format("%15s %15d %15s %15s",chuyenNganh,sucChua,coBonRua?"Có":"Không",kiemTraDatChuan()?"Có":"Không");
	}
	@Override
	public boolean kiemTraDatChuan() {
		if(getDienTich()/getSoBongden()>1 && coBonRua==true)
			return true;
		else
			return false;
	}
	
	
}
