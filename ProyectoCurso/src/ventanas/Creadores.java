package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Creadores extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JButton btnCerrarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creadores frame = new Creadores();
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
	public Creadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(Creadores.class.getResource("/Fotos/Alexander.png")));
			lblNewLabel.setBounds(10, 85, 103, 129);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon(Creadores.class.getResource("/Fotos/Fabrizio.png")));
			lblNewLabel_1.setBounds(156, 85, 103, 129);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon(Creadores.class.getResource("/Fotos/Arian.png")));
			lblNewLabel_2.setBounds(290, 85, 103, 129);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setIcon(new ImageIcon(Creadores.class.getResource("/Fotos/Luana.png")));
			lblNewLabel_3.setBounds(439, 85, 103, 129);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setIcon(new ImageIcon(Creadores.class.getResource("/Fotos/Jose.png")));
			lblNewLabel_4.setBounds(581, 85, 103, 129);
			contentPane.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("N00432461@upn.pe");
			lblNewLabel_5.setBounds(10, 232, 103, 12);
			contentPane.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("N00422444@upn.pe");
			lblNewLabel_6.setBounds(156, 232, 103, 12);
			contentPane.add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("N00445528@upn.pe");
			lblNewLabel_7.setBounds(290, 232, 103, 12);
			contentPane.add(lblNewLabel_7);
		}
		{
			lblNewLabel_8 = new JLabel("N00460329@upn.pe");
			lblNewLabel_8.setBounds(439, 232, 103, 12);
			contentPane.add(lblNewLabel_8);
		}
		{
			lblNewLabel_9 = new JLabel("N00417196@upn.pe");
			lblNewLabel_9.setBounds(569, 232, 103, 12);
			contentPane.add(lblNewLabel_9);
		}
		{
			lblNewLabel_10 = new JLabel("Desarrollado por:");
			lblNewLabel_10.setBounds(10, 52, 152, 12);
			contentPane.add(lblNewLabel_10);
		}
		{
			lblNewLabel_11 = new JLabel("Inventario en MAKEA.PE Venta de Postres");
			lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblNewLabel_11.setBounds(211, 10, 498, 27);
			contentPane.add(lblNewLabel_11);
		}
		{
			btnCerrarSesion = new JButton("Volver");
			btnCerrarSesion.addActionListener(this);
			btnCerrarSesion.setForeground(Color.WHITE);
			btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnCerrarSesion.setBackground(Color.RED);
			btnCerrarSesion.setBounds(563, 254, 146, 23);
			contentPane.add(btnCerrarSesion);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrarSesion) {
			do_btnCerrarSesion_actionPerformed(e);
		}
	}
	protected void do_btnCerrarSesion_actionPerformed(ActionEvent e) {
		Vlogin vl=new Vlogin();
		vl.setVisible(true);
		dispose();
		return;
	}
}
