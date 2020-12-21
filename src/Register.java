import java.sql.*;
	public class Register extends konek {
	    // deklarasi
	    Connection con;
	    Statement stat;
	    ResultSet rs;
	    String sql;
	    
	    public Register() {
	        //pemanggilan fungsi koneksi database yang sudah kita buat pada class koneksi.java
	        konek DB = new konek();
	        DB.config();
	        con = DB.con;
	        stat = DB.stm;
	    }
	    

	}
