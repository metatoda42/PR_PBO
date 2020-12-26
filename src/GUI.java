import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import javax.swing.JTextPane;


public class GUI extends Register {
	
	

	private JFrame frame;
	private JTextField NIS;
	private JTextField Nama;
	private JTextField Jurusan;
	JPanel panel = new JPanel();
	static JPanel panel_1 = new JPanel();
	private final ButtonGroup Jekel = new ButtonGroup();
	
	String v1, v2, v3, v5;
	char v4;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	
	JTextPane DataJekel = new JTextPane();
	JTextPane DataAlamat = new JTextPane();
	JTextPane DataJurusan = new JTextPane();
	JTextPane DataNama = new JTextPane();
	JTextPane DataNIS = new JTextPane();
	JTable table = new JTable();
	final TextArea Alamat = new TextArea();
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 962, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblAplikasiFormMahasiswa = new JLabel("Aplikasi Form Mahasiswa");
		lblAplikasiFormMahasiswa.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblAplikasiFormMahasiswa);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNama = new JLabel("NIS");
		lblNama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNama.setBounds(10, 11, 44, 22);
		panel_1.add(lblNama);
		
		NIS = new JTextField();
		NIS.setBounds(134, 14, 343, 20);
		panel_1.add(NIS);
		NIS.setColumns(10);
		
		JLabel lblNama_1 = new JLabel("Nama");
		lblNama_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNama_1.setBounds(10, 44, 44, 22);
		panel_1.add(lblNama_1);
		
		Nama = new JTextField();
		Nama.setColumns(10);
		Nama.setBounds(134, 47, 343, 20);
		panel_1.add(Nama);
		
		JLabel lblJenisKelamin = new JLabel("Jenis Kelamin");
		lblJenisKelamin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJenisKelamin.setBounds(10, 77, 81, 22);
		panel_1.add(lblJenisKelamin);
		
		JLabel lblJurusan = new JLabel("Jurusan");
		lblJurusan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJurusan.setBounds(10, 110, 81, 22);
		panel_1.add(lblJurusan);
		
		Jurusan = new JTextField();
		Jurusan.setColumns(10);
		Jurusan.setBounds(134, 113, 343, 20);
		panel_1.add(Jurusan);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlamat.setBounds(10, 143, 81, 22);
		panel_1.add(lblAlamat);
		
		JRadioButton L = new JRadioButton("Laki-Laki");
		L.setAction(action_1);
		L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		L.setBounds(134, 77, 147, 23);
		panel_1.add(L);
		
		JRadioButton P = new JRadioButton("Perempuan");
		P.setAction(action_2);
		P.setFont(new Font("Tahoma", Font.PLAIN, 15));
		P.setBounds(283, 77, 147, 23);
		panel_1.add(P);
	    
		Jekel.add(L);
		Jekel.add(P);
		

		

		

		Alamat.setBounds(134, 140, 343, 141);
		panel_1.add(Alamat);
		
		
		JButton btnSumbit = new JButton("Submit");
		btnSumbit.setAction(action);
		btnSumbit.setBounds(134, 306, 89, 23);
		panel_1.add(btnSumbit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(388, 306, 89, 23);
		panel_1.add(btnClear);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(action_3);
		btnNewButton.setBounds(692, 0, 89, 23);
		panel_1.add(btnNewButton);
		
		
		
		String[][] kolom = new String[20][5];
		String[] v = new String[5];
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ResultSet resultSet = null;
		try {
			resultSet = stmt.executeQuery("SELECT * FROM `siswa`");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		java.sql.ResultSetMetaData rsmd = null;
		try {
			rsmd = resultSet.getMetaData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int columnsNumber = 0;
		try {
			columnsNumber = rsmd.getColumnCount();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			int j=1;
			while (resultSet.next()) {
			    for (int i = 1; i <= columnsNumber; i++) {
			        kolom[j-1][i-1]=resultSet.getString(i);
			        
			     // System.out.print(columnValue + " " + kolom[j-1][i-1]);
			        v[i-1]=rsmd.getColumnName(i);
			    }
			    j++;
			    
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String isiteks1 = "";
		String isiteks2 = "";
		String isiteks3 = "";
		String isiteks4 = "";
		String isiteks5 = "";
		for(int i=0; i<10; i++) {
			if(kolom[i][0]==null)break;
			isiteks1 += kolom[i][0] + "\n";
			if(kolom[i][1]==null)break;
			isiteks2 += kolom[i][1] + "\n";
			if(kolom[i][2]==null)break;
			isiteks3 += kolom[i][2] + "\n";
			if(kolom[i][3]==null)break;
			isiteks4 += kolom[i][3] + "\n";
			if(kolom[i][4]==null)break;
			isiteks5 += kolom[i][4] + "\n";
	}
		
		
		DataNIS.setFont(new Font("Tahoma", Font.PLAIN, 9));
		DataNIS.setEditable(false);
		DataNIS.setText(isiteks1);
		DataNIS.setBounds(487, 44, 74, 252);
		panel_1.add(DataNIS);
		
		
		DataNama.setFont(new Font("Tahoma", Font.PLAIN, 9));
		DataNama.setEditable(false);
		DataNama.setText(isiteks2);
		DataNama.setBounds(571, 44, 95, 252);
		panel_1.add(DataNama);
		
		
		DataJurusan.setFont(new Font("Tahoma", Font.PLAIN, 9));
		DataJurusan.setEditable(false);
		DataJurusan.setText(isiteks3);
		DataJurusan.setBounds(676, 44, 95, 252);
		panel_1.add(DataJurusan);
		
		
		DataJekel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		DataJekel.setText(isiteks4);
		DataJekel.setBounds(781, 44, 17, 252);
		panel_1.add(DataJekel);
		
		
		DataAlamat.setFont(new Font("Tahoma", Font.PLAIN, 9));
		DataAlamat.setText(isiteks5);
		DataAlamat.setBounds(808, 44, 128, 252);
		panel_1.add(DataAlamat);
		
		JLabel lblNis = new JLabel("NIS");
		lblNis.setBounds(515, 30, 17, 14);
		panel_1.add(lblNis);
		
		JLabel lblNama_2 = new JLabel("Nama");
		lblNama_2.setBounds(605, 30, 33, 14);
		panel_1.add(lblNama_2);
		
		JLabel lblJurusan_1 = new JLabel("Jurusan");
		lblJurusan_1.setBounds(702, 30, 46, 14);
		panel_1.add(lblJurusan_1);
		
		JLabel lblJekel = new JLabel("Jekel");
		lblJekel.setBounds(781, 30, 33, 14);
		panel_1.add(lblJekel);
		
		JLabel lblAlamat_1 = new JLabel("Alamat");
		lblAlamat_1.setBounds(850, 30, 46, 14);
		panel_1.add(lblAlamat_1);
		
		showdb.show();
		
	}
	public static class showdb extends GUI{
		static String[][] kolom = new String[20][5];
		
		static String[] v = new String[5];
		
		public static void show() {

		}
		
	}
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			v1=NIS.getText();
			v2=Nama.getText();
			v3=Jurusan.getText();
			v5=Alamat.getText();
			
			sql="INSERT INTO `siswa` (`NIS`, `Nama`, `Jurusan`, `JK`, `Alamat`) VALUES ('"+v1+"', '"+v2+"', '"+v3+"', '"+v4+"', '"+v5+"')";
			
			java.sql.PreparedStatement pst;
			try {
				pst = con.prepareStatement(sql);
				pst.execute();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "Laki-Laki");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			v4='L';
		}
	}
	private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_2() {
			putValue(NAME, "Perempuan");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			v4='P';
		}
	}
	private class SwingAction_3 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_3() {
			putValue(NAME, "Refresh");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String[][] kolom = new String[20][5];
			String[] v = new String[5];
			Statement stmt = null;
			

			try {
				stmt = con.createStatement();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ResultSet resultSet = null;
			try {
				resultSet = stmt.executeQuery("SELECT * FROM `siswa`");
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			java.sql.ResultSetMetaData rsmd = null;
			try {
				rsmd = resultSet.getMetaData();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int columnsNumber = 0;
			try {
				columnsNumber = rsmd.getColumnCount();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				int j=1;
				while (resultSet.next()) {
				    for (int i = 1; i <= columnsNumber; i++) {
				        kolom[j-1][i-1]=resultSet.getString(i);
				        
				     // System.out.print(columnValue + " " + kolom[j-1][i-1]);
				        v[i-1]=rsmd.getColumnName(i);
				    }
				    j++;
				    
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String isiteks1 = "";
			String isiteks2 = "";
			String isiteks3 = "";
			String isiteks4 = "";
			String isiteks5 = "";
			for(int i=0; i<10; i++) {
				if(kolom[i][0]==null)break;
				isiteks1 += kolom[i][0] + "\n";
				if(kolom[i][1]==null)break;
				isiteks2 += kolom[i][1] + "\n";
				if(kolom[i][2]==null)break;
				isiteks3 += kolom[i][2] + "\n";
				if(kolom[i][3]==null)break;
				isiteks4 += kolom[i][3] + "\n";
				if(kolom[i][4]==null)break;
				isiteks5 += kolom[i][4] + "\n";
		}
			

			DataNIS.setText(isiteks1);			
			DataNama.setText(isiteks2);
			DataJurusan.setText(isiteks3);
			DataJekel.setText(isiteks4);
			DataAlamat.setText(isiteks5);

			
		}
	}
}
