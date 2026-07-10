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
import javax.swing.SwingConstants;

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
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;

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

	public Creadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Creadores.class.getResource("/Fotos/Alexander.png")));
			lblNewLabel.setBounds(39, 85, 103, 129);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Creadores.class.getResource("/Fotos/Fabrizio.png")));
			lblNewLabel_1.setBounds(226, 85, 103, 129);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(Creadores.class.getResource("/Fotos/Arian.png")));
			lblNewLabel_2.setBounds(397, 85, 103, 129);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(Creadores.class.getResource("/Fotos/Luana.png")));
			lblNewLabel_3.setBounds(563, 85, 103, 129);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Creadores.class.getResource("/Fotos/Jose.png")));
			lblNewLabel_4.setBounds(734, 85, 103, 129);
			contentPane.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("N00432461@upn.pe");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(15, 232, 150, 12);
			contentPane.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("N00422444@upn.pe");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6.setBounds(202, 232, 150, 12);
			contentPane.add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("N00445528@upn.pe");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setBounds(373, 232, 150, 12);
			contentPane.add(lblNewLabel_7);
		}
		{
			lblNewLabel_8 = new JLabel("N00460329@upn.pe");
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setBounds(539, 232, 150, 12);
			contentPane.add(lblNewLabel_8);
		}
		{
			lblNewLabel_9 = new JLabel("N00417196@upn.pe");
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_9.setBounds(710, 232, 150, 12);
			contentPane.add(lblNewLabel_9);
		}
		{
			lblNewLabel_10 = new JLabel("Desarrollado por:");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_10.setBounds(20, 52, 198, 23);
			contentPane.add(lblNewLabel_10);
		}
		{
			lblNewLabel_11 = new JLabel("Inventario en MAKEA.PE Venta de Postres");
			lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
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
			btnCerrarSesion.setBounds(714, 314, 146, 23);
			contentPane.add(btnCerrarSesion);
		}
		{
			lblNewLabel_12 = new JLabel("<html><center>Bejar Centurión, Alexander Miguel</center></html>");
			lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_12.setBounds(15, 254, 150, 37);
			contentPane.add(lblNewLabel_12);
		}
		{
			lblNewLabel_13 = new JLabel("<html><center>Camacho Campoverde, Angello Fabrizio</center></html>");
			lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_13.setBounds(202, 254, 150, 37);
			contentPane.add(lblNewLabel_13);
		}
		{
			lblNewLabel_14 = new JLabel("<html><center>Vizcacho Amesquita Arian Fabrizio</center></html>");
			lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_14.setBounds(373, 254, 150, 37);
			contentPane.add(lblNewLabel_14);
		}
		{
			lblNewLabel_15 = new JLabel("<html><center>Pinedo Olivera, Luana Shenia</center></html>");
			lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_15.setBounds(539, 254, 150, 37);
			contentPane.add(lblNewLabel_15);
		}
		{
			lblNewLabel_16 = new JLabel("<html><center>Mejias Romero, Jose Daniel</center></html>");
			lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_16.setBounds(710, 254, 150, 37);
			contentPane.add(lblNewLabel_16);
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