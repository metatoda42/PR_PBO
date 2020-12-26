import java.sql.*;
	public class Register extends konek {
	    // deklarasi
	    static Connection con;
	    Statement stat;
	    static ResultSet rs;
	    static String sql;
	    
	    public Register() {
	        //pemanggilan fungsi koneksi database yang sudah kita buat pada class koneksi.java
	        konek DB = new konek();
	        DB.config();
	        con = DB.con;
	        stat = DB.stm;
	    }
	    

	}
