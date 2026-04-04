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
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;

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
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 350);
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Nombre: ");
			lblNewLabel.setBounds(10, 19, 81, 22);
			lblNewLabel.setFont(new Font("Dubai", Font.BOLD, 14));
			contentPane.add(lblNewLabel);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBackground(Color.YELLOW);
			txtNombre.setBounds(80, 19, 96, 18);
			contentPane.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			btnNewButton = new JButton("Adicionar");
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBackground(Color.GREEN);
			btnNewButton.setBounds(10, 91, 112, 29);
			btnNewButton.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
			contentPane.add(btnNewButton);
		}
		{
			lblNewLabel_1 = new JLabel("DNI:");
			lblNewLabel_1.setBounds(200, 51, 44, 17);
			lblNewLabel_1.setFont(new Font("Dubai", Font.BOLD, 14));
			contentPane.add(lblNewLabel_1);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setBackground(Color.YELLOW);
			txtDNI.setBounds(266, 17, 96, 18);
			txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPane.add(txtDNI);
			txtDNI.setColumns(10);
		}
		{
			btnNewButton_1 = new JButton("Eliminar");
			btnNewButton_1.setBackground(Color.GREEN);
			btnNewButton_1.setBounds(254, 91, 112, 28);
			btnNewButton_1.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
			btnNewButton_1.addActionListener(this);
			contentPane.add(btnNewButton_1);
		}
		{
			lblNewLabel_2 = new JLabel("Teléfono:");
			lblNewLabel_2.setBounds(10, 48, 81, 22);
			lblNewLabel_2.setFont(new Font("Dubai", Font.BOLD, 14));
			contentPane.add(lblNewLabel_2);
		}
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setColumns(10);
		textField.setBounds(80, 48, 96, 18);
		contentPane.add(textField);
		{
			lblNewLabel_3 = new JLabel("Apellido:");
			lblNewLabel_3.setFont(new Font("Dubai", Font.BOLD, 14));
			lblNewLabel_3.setBounds(200, 15, 81, 22);
			contentPane.add(lblNewLabel_3);
		}
		{
			btnNewButton_2 = new JButton("Reportar");
			btnNewButton_2.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
			btnNewButton_2.setBackground(Color.GREEN);
			btnNewButton_2.setBounds(132, 91, 112, 28);
			contentPane.add(btnNewButton_2);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBackground(Color.LIGHT_GRAY);
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_1.setColumns(10);
			textField_1.setBounds(266, 51, 96, 18);
			contentPane.add(textField_1);
		}
		{
			lblNewLabel_4 = new JLabel("Correo:");
			lblNewLabel_4.setFont(new Font("Dubai", Font.BOLD, 14));
			lblNewLabel_4.setBounds(387, 15, 81, 22);
			contentPane.add(lblNewLabel_4);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBackground(Color.YELLOW);
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_2.setColumns(10);
			textField_2.setBounds(445, 18, 96, 18);
			contentPane.add(textField_2);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
	}
}
