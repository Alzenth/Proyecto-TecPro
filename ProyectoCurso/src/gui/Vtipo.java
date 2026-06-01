package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vtipo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vtipo frame = new Vtipo();
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
	public Vtipo() {
		setTitle("BIENVENIDO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Desea ingresar como");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			lblNewLabel.setBounds(108, 30, 200, 51);
			contentPane.add(lblNewLabel);
		}
		{
			btnNewButton = new JButton("Administrador");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(10, 129, 116, 23);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Cliente");
			btnNewButton_1.setBounds(286, 129, 116, 23);
			contentPane.add(btnNewButton_1);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		V1 V = new V1();
		V.setVisible(true);
		dispose();
	}
}
