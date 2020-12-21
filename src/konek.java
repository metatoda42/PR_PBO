import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class konek {
    Connection con;
    Statement stm;
   // jdbc:mysql://localhost/db
    public void config(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi1 gagal "+e.getMessage());
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost/sekolah?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi2 gagal "+e.getMessage());
        }
        try {
            stm = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi3 gagal "+e.getMessage());
        }
    }
}