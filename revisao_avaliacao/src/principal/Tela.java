package principal;

import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1304, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(25, 52, 59, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(25, 73, 206, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(25, 131, 206, 26);
		contentPane.add(formattedTextField);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(25, 110, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setVerifyInputWhenFocusTarget(false);
		table.setUpdateSelectionOnSort(false);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.GRAY);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(11), "Paulo", "789.632.125-89"},
			},
			new String[] {
				"Cod", "Nome", "CPF"
			}
		));
		table.setBounds(601, 392, 495, -254);
		contentPane.add(table);
		
	}
}
