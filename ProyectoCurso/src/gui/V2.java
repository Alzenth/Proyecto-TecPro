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
import javax.swing.JTextField;

public class V2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAgregarProducto;
	private JLabel lblMenu;
	private JTextArea textArea;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JLabel lblConsultaElStock;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JTextField textField_3;
	private ArregloProducto ap = new ArregloProducto();

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
				btnAgregarProducto = new JButton("Registrar producto");
				btnAgregarProducto.addActionListener(this);
				btnAgregarProducto.setForeground(Color.BLACK);
				btnAgregarProducto.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
				btnAgregarProducto.setBackground(Color.LIGHT_GRAY);
				btnAgregarProducto.setBounds(33, 216, 145, 22);
				panel.add(btnAgregarProducto);
			}
			{
				lblMenu = new JLabel("Menú: Registro de productos");
				lblMenu.setFont(new Font("Dubai", Font.BOLD, 14));
				lblMenu.setBounds(0, 0, 219, 22);
				panel.add(lblMenu);
			}
			{
				textArea = new JTextArea();
				textArea.setBackground(Color.WHITE);
				textArea.setBounds(232, 23, 192, 227);
				panel.add(textArea);
			}
			{
				textField = new JTextField();
				textField.setBounds(99, 49, 101, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(99, 89, 101, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(99, 128, 101, 20);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				lblNewLabel = new JLabel("ID Producto:");
				lblNewLabel.setBounds(0, 52, 89, 14);
				panel.add(lblNewLabel);
			}
			{
				lblConsultaElStock = new JLabel("Nombre Producto:");
				lblConsultaElStock.setBounds(0, 88, 89, 14);
				panel.add(lblConsultaElStock);
			}
			{
				lblNewLabel_2 = new JLabel("Stock  Producto:");
				lblNewLabel_2.setBounds(0, 131, 89, 14);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_1 = new JLabel("Precio Producto:");
				lblNewLabel_1.setBounds(0, 178, 89, 14);
				panel.add(lblNewLabel_1);
			}
			{
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(99, 175, 101, 20);
				panel.add(textField_3);
			}
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregarProducto) {
			do_btnAgregarProducto_actionPerformed(e);
		}
	}
	protected void do_btnAgregarProducto_actionPerformed(ActionEvent e) {
		try {
			String id = textField.getText();    
	        String nom = textField_1.getText();   
	        int stock = Integer.parseInt(textField_2.getText()); 
	        double precio = Double.parseDouble(textField_3.getText()); 

	        
	        Producto nuevo = new Producto(id, nom, stock, precio);

	        ap.Adicionar(nuevo);
	        listar();
	        
	        javax.swing.JOptionPane.showMessageDialog(this, "¡Producto registrado correctament!");

	        textField.setText("");
	        textField_1.setText("");
	        textField_2.setText("");
	        textField_3.setText("");
	        textField.requestFocus();
		}catch (Exception ex) {
			javax.swing.JOptionPane.showMessageDialog(this, "Error: Revisa que Stock y Precio esten bien");
		}
	}void listar() {
		
	    textArea.setText(""); 
	    for (int i = 0; i < ap.Tamaño(); i++) {
	        Producto p = ap.Obtener(i); 
	        imprimir("ID: " + p.getId_prod());
	        imprimir("NOMBRE: " + p.getNombre_prod());
	        imprimir("STOCK: " + p.getStock_prod());
	        imprimir("PRECIO: S/. " + p.getPrecio_prod());
	        imprimir("-----------------------------------------");
	    }
	}
	void imprimir(String s) {
	    textArea.append(s + "\n");
	}
	
	
}
