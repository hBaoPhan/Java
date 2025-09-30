package FinalStretch;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedSet;

public class test {

	public static void main(String[] args) {
		DanhSachHocPhan a=new DanhSachHocPhan();

		a.them(new HocPhanTrucTuyen("001", "PHBD", 100, LocalDate.of(2025, 1, 1), LocalDate.of(2026, 10, 10), 100, 500, "www.teams.com"));
		a.them(new HocPhanTrucTuyen("002", "PHA", 100, LocalDate.of(2025, 1, 1), LocalDate.of(2026, 10, 10), 100, 400, "www.teams.com"));
		a.them(new HocPhanTrucTiep("003", "PHC", 100, LocalDate.of(2025, 1, 1), LocalDate.of(2026, 10, 10), 100, 0, "12 NVB", "1-3"));
		a.them(new HocPhanTrucTiep("004", "PHB", 100, LocalDate.of(2025, 1, 1), LocalDate.of(2026, 10, 10), 100, 150, "12 NVB", "1-3"));
		a.them(new HocPhanTrucTuyen("005", "PHBD", 100, LocalDate.of(2025, 1, 1), LocalDate.of(2026, 10, 10), 100, 2000, "www.teams.com"));
		a.them(new HocPhanTrucTuyen("006", "PHA", 100, LocalDate.of(2025, 1, 1), LocalDate.of(2026, 10, 10), 100, 200, "www.teams.com"));
		
		System.out.println(a);
		SortedSet<HocPhan> dsKhenThuong=a.layDsHocVienKhenThuong(5);
		for (HocPhan hocPhan : dsKhenThuong) {
			System.out.println(hocPhan);
		}
//		List<HocPhan> b=a.layDsMaGiam();
//		for (HocPhan hocPhan : b) {
//			System.out.println(hocPhan);
//		}
		
		
		
		
		
	}

}
