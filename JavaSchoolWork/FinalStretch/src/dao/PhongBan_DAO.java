package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;
import gui.PhongBan;

public class PhongBan_DAO {
	public ArrayList<PhongBan> getAllPhongBan() {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getCon();
		PreparedStatement stmt=null;
		ArrayList<PhongBan> ds= new ArrayList<PhongBan>();
		String sql="Select * From PhongBan";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				
				ds.add(new PhongBan(ma, ten));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}

}
