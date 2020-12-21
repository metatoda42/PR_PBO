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
import java.sql.SQLException;


public class GUI extends Register {
	
	

	private JFrame frame;
	private JTextField NIS;
	private JTextField Nama;
	private JTextField Jurusan;
	private final ButtonGroup Jekel = new ButtonGroup();
	private final Action action = new SwingAction();
	String v1, v2, v3, v5;
	char v4;
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();

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
		frame.setBounds(100, 100, 586, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
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
		

		

		
		final TextArea Alamat = new TextArea();
		Alamat.setBounds(134, 140, 343, 141);
		panel_1.add(Alamat);
		
		
		JButton btnSumbit = new JButton("Submit");
		btnSumbit.addActionListener(new ActionListener() {
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSumbit.setAction(action);
		btnSumbit.setBounds(134, 306, 89, 23);
		panel_1.add(btnSumbit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(388, 306, 89, 23);
		panel_1.add(btnClear);
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
}
