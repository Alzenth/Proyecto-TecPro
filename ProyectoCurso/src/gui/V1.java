package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNombre;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField txtDNI;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
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
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Nombre: ");
			lblNewLabel.setBounds(10, 15, 81, 22);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(lblNewLabel);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(80, 19, 96, 18);
			contentPane.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			btnNewButton = new JButton("Adicionar");
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBackground(new Color(0, 0, 0));
			btnNewButton.setBounds(31, 91, 112, 29);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPane.add(btnNewButton);
		}
		{
			lblNewLabel_1 = new JLabel("DNI:");
			lblNewLabel_1.setBounds(199, 18, 44, 17);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(lblNewLabel_1);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setBounds(242, 17, 96, 18);
			txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPane.add(txtDNI);
			txtDNI.setColumns(10);
		}
		{
			btnNewButton_1 = new JButton("Eliminar");
			btnNewButton_1.setBackground(new Color(0, 0, 0));
			btnNewButton_1.setBounds(166, 91, 112, 28);
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton_1.addActionListener(this);
			contentPane.add(btnNewButton_1);
		}
		{
			lblNewLabel_2 = new JLabel("Teléfono");
			lblNewLabel_2.setBounds(10, 48, 81, 22);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(lblNewLabel_2);
		}
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(80, 48, 96, 18);
		contentPane.add(textField);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
	}
}
