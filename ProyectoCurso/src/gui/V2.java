package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class V2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnStock;
	private JButton btnAgregarProducto;
	private JLabel lblMenu;
	private JButton btnEditarProductos;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V2 frame = new V2();
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
	public V2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaption);
			panel.setBounds(0, 0, 434, 261);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				btnStock = new JButton("Verificar stock");
				btnStock.addActionListener(this);
				btnStock.setForeground(Color.BLACK);
				btnStock.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
				btnStock.setBackground(new Color(204, 153, 0));
				btnStock.setBounds(0, 124, 160, 29);
				panel.add(btnStock);
			}
			{
				btnAgregarProducto = new JButton("Agregar producto");
				btnAgregarProducto.setForeground(Color.BLACK);
				btnAgregarProducto.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
				btnAgregarProducto.setBackground(new Color(204, 153, 0));
				btnAgregarProducto.setBounds(0, 71, 160, 29);
				panel.add(btnAgregarProducto);
			}
			{
				lblMenu = new JLabel("Menu");
				lblMenu.setFont(new Font("Dubai", Font.BOLD, 24));
				lblMenu.setBounds(0, 11, 81, 22);
				panel.add(lblMenu);
			}
			{
				btnEditarProductos = new JButton("Editar productos");
				btnEditarProductos.setForeground(Color.BLACK);
				btnEditarProductos.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
				btnEditarProductos.setBackground(new Color(204, 153, 0));
				btnEditarProductos.setBounds(0, 177, 160, 29);
				panel.add(btnEditarProductos);
			}
			{
				textArea = new JTextArea();
				textArea.setBackground(Color.LIGHT_GRAY);
				textArea.setBounds(210, 23, 214, 227);
				panel.add(textArea);
			}
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStock) {
			do_btnStock_actionPerformed(e);
		}
	}
	protected void do_btnStock_actionPerformed(ActionEvent e) {
	}
}
