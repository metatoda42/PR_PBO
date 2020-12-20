import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new SwingAction();

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
		
		textField = new JTextField();
		textField.setBounds(134, 14, 343, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNama_1 = new JLabel("Nama");
		lblNama_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNama_1.setBounds(10, 44, 44, 22);
		panel_1.add(lblNama_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 47, 343, 20);
		panel_1.add(textField_1);
		
		JLabel lblJenisKelamin = new JLabel("Jenis Kelamin");
		lblJenisKelamin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJenisKelamin.setBounds(10, 77, 81, 22);
		panel_1.add(lblJenisKelamin);
		
		JLabel lblJurusan = new JLabel("Jurusan");
		lblJurusan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJurusan.setBounds(10, 110, 81, 22);
		panel_1.add(lblJurusan);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(134, 113, 343, 20);
		panel_1.add(textField_3);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlamat.setBounds(10, 143, 81, 22);
		panel_1.add(lblAlamat);
		
		JRadioButton L = new JRadioButton("Laki-Laki");
		L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup.add(L);
		L.setBounds(134, 77, 147, 23);
		panel_1.add(L);
		
		JRadioButton P = new JRadioButton("Perempuan");
		P.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup.add(P);
		P.setBounds(283, 77, 147, 23);
		panel_1.add(P);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(134, 140, 343, 141);
		panel_1.add(textArea);
		
		JButton btnSumbit = new JButton("Submit");
		btnSumbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		public SwingAction() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
