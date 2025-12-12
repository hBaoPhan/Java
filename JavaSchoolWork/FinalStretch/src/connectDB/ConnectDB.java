package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static ConnectDB instance=new ConnectDB();
	public static Connection con=null;
	
	public static ConnectDB getInstance() {
		return instance;
	}
	public static Connection getCon() {
		return con;
		
	}
	public void connect() throws SQLException {
		String sql="jdbc:sqlserver://localhost:1433;databaseName=QLNVIEN";
		String user="sa";
		String pwd="sapassword";
		con=DriverManager.getConnection(sql,user,pwd);
	}
	public void disConnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
