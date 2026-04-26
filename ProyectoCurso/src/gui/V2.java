package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class V2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAgregarProducto;
	private JLabel lblMenu;
	private JTextArea txtS;
	private JTextField txtIdProducto;
	private JTextField txtNombreProducto;
	private JTextField txtStockProducto;
	private JLabel lblNewLabel;
	private JLabel lblConsultaElStock;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JTextField txtPrecioProducto;
	private ArregloProducto ap = new ArregloProducto();
	private JComboBox cbBoxCategoria;
	private JLabel lblNewLabel_3;
	private JButton btnRemoverProducto;

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
		setBounds(100, 100, 645, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaption);
			panel.setBounds(0, 0, 631, 410);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				btnAgregarProducto = new JButton("Registrar producto");
				btnAgregarProducto.addActionListener(this);
				btnAgregarProducto.setForeground(Color.BLACK);
				btnAgregarProducto.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
				btnAgregarProducto.setBackground(Color.LIGHT_GRAY);
				btnAgregarProducto.setBounds(33, 259, 145, 22);
				panel.add(btnAgregarProducto);
			}
			{
				lblMenu = new JLabel("Menú: Registro de productos");
				lblMenu.setFont(new Font("Dubai", Font.BOLD, 14));
				lblMenu.setBounds(0, 0, 219, 22);
				panel.add(lblMenu);
			}
			{
				txtS = new JTextArea();
				txtS.setBackground(Color.WHITE);
				txtS.setBounds(232, 23, 389, 377);
				panel.add(txtS);
			}
			{
				txtIdProducto = new JTextField();
				txtIdProducto.setBounds(99, 49, 101, 20);
				panel.add(txtIdProducto);
				txtIdProducto.setColumns(10);
			}
			{
				txtNombreProducto = new JTextField();
				txtNombreProducto.setBounds(99, 89, 101, 20);
				panel.add(txtNombreProducto);
				txtNombreProducto.setColumns(10);
			}
			{
				txtStockProducto = new JTextField();
				txtStockProducto.setBounds(99, 171, 101, 20);
				panel.add(txtStockProducto);
				txtStockProducto.setColumns(10);
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
				lblNewLabel_2.setBounds(0, 174, 89, 14);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_1 = new JLabel("Precio Producto:");
				lblNewLabel_1.setBounds(0, 221, 89, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txtPrecioProducto = new JTextField();
				txtPrecioProducto.setColumns(10);
				txtPrecioProducto.setBounds(99, 218, 101, 20);
				panel.add(txtPrecioProducto);
			}
			{
				cbBoxCategoria = new JComboBox();
				cbBoxCategoria.setBounds(99, 131, 101, 20);
				panel.add(cbBoxCategoria);
			}
			{
				lblNewLabel_3 = new JLabel("Categoría Producto");
				lblNewLabel_3.setBounds(0, 134, 89, 14);
				panel.add(lblNewLabel_3);
			}
			{
				btnRemoverProducto = new JButton("Remover producto");
				btnRemoverProducto.addActionListener(this);
				btnRemoverProducto.setForeground(Color.BLACK);
				btnRemoverProducto.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
				btnRemoverProducto.setBackground(Color.LIGHT_GRAY);
				btnRemoverProducto.setBounds(33, 291, 145, 22);
				panel.add(btnRemoverProducto);				
			}
		}
		cbBoxCategoria.setModel(new DefaultComboBoxModel<>(new String[] {
			    "N/A", "Cat1", "Cat2", "Cat3", "Cat4"
			}));
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRemoverProducto) {
			do_btnRemoverProducto_actionPerformed(e);
		}
		if (e.getSource() == btnAgregarProducto) {
			do_btnAgregarProducto_actionPerformed(e);
		}
	}
	protected void do_btnAgregarProducto_actionPerformed(ActionEvent e) {
		try {
			String id = txtIdProducto.getText();    
	        String nom = txtNombreProducto.getText();   
	        String cat = cbBoxCategoria.getSelectedItem().toString();
	        int stock = Integer.parseInt(txtStockProducto.getText()); 
	        double precio = Double.parseDouble(txtPrecioProducto.getText()); 

	        
	        Producto nuevo = new Producto(id, nom, cat, stock, precio);

	        ap.Adicionar(nuevo);
	        listar();
	        
	        javax.swing.JOptionPane.showMessageDialog(this, "¡Producto registrado correctament!");

	        txtIdProducto.setText("");
	        txtNombreProducto.setText("");
	        cbBoxCategoria.setSelectedItem("N/A");
	        txtStockProducto.setText("");
	        txtPrecioProducto.setText("");
	        txtIdProducto.requestFocus();
	        }catch (Exception ex) {
			MensajeEmergente("Error: Revisa los campos");
			}
	}
	//sobrecarga de métodos
		void imprimir(String s) {
		    txtS.append(s + "\n");
		}
		void imprimir(Producto p) {
		    imprimir("ID: " + p.getId_prod());
		    imprimir("NOMBRE: " + p.getNombre_prod());
		    imprimir("CATEGORÍA: " + p.getCategoria_prod());
		    imprimir("STOCK: " + p.getStock_prod());
		    imprimir("PRECIO: S/. " + p.getPrecio_prod());
		    imprimir("----------------------");
		}	
	void listar() {
		
	    txtS.setText(""); 
	    for (int i = 0; i < ap.Tamaño(); i++) {
	        imprimir(ap.Obtener(i));
	        }
	}
	
	void MensajeEmergente(String s) {
		javax.swing.JOptionPane.showMessageDialog(this, s);
	}
	protected void do_btnRemoverProducto_actionPerformed(ActionEvent e) {
	}
}
