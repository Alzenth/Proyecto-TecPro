package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ArregloProducto;
import constructores.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class VGestionProductos extends JFrame implements ActionListener {

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
	private JButton btnCargarProductos;
	private JButton btnDescargarProductos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VGestionProductos frame = new VGestionProductos();
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
	public VGestionProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaption);
			panel.setBounds(0, 0, 792, 469);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				btnAgregarProducto = new JButton("Registrar producto");
				btnAgregarProducto.addActionListener(this);
				btnAgregarProducto.setForeground(Color.BLACK);
				btnAgregarProducto.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
				btnAgregarProducto.setBackground(Color.LIGHT_GRAY);
				btnAgregarProducto.setBounds(65, 307, 145, 20);
				panel.add(btnAgregarProducto);
			}
			{
				lblMenu = new JLabel("Menú: Gestión de productos");
				lblMenu.setFont(new Font("Dubai", Font.BOLD, 14));
				lblMenu.setBounds(10, 0, 219, 22);
				panel.add(lblMenu);
			}
			{
				txtS = new JTextArea();
				txtS.setEditable(false);
				txtS.setBackground(Color.WHITE);
				txtS.setBounds(322, 23, 460, 396);
				panel.add(txtS);
			}
			{
				txtIdProducto = new JTextField();
				txtIdProducto.setBounds(155, 48, 101, 20);
				panel.add(txtIdProducto);
				txtIdProducto.setColumns(10);
			}
			{
				txtNombreProducto = new JTextField();
				txtNombreProducto.setBounds(155, 69, 101, 20);
				panel.add(txtNombreProducto);
				txtNombreProducto.setColumns(10);
				txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
						calcularPrecioPorTamañoYTopping();
					}
				});
			}
			}
			{
				txtStockProducto = new JTextField();
				txtStockProducto.setBounds(155, 190, 101, 20);
				panel.add(txtStockProducto);
				txtStockProducto.setColumns(10);
			}
			{
				lblNewLabel = new JLabel("ID Producto:");
				lblNewLabel.setBounds(19, 51, 111, 14);
				panel.add(lblNewLabel);
			}
			{
				lblConsultaElStock = new JLabel("Nombre Producto:");
				lblConsultaElStock.setBounds(19, 72, 111, 14);
				panel.add(lblConsultaElStock);
			}
			{
				lblNewLabel_2 = new JLabel("Stock  Producto:");
				lblNewLabel_2.setBounds(19, 193, 111, 14);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_1 = new JLabel("Precio Producto:");
				lblNewLabel_1.setBounds(19, 220, 111, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txtPrecioProducto = new JTextField();
				txtPrecioProducto.setColumns(10);
				txtPrecioProducto.setBounds(155, 217, 101, 20);
				panel.add(txtPrecioProducto);
			}
			{
				cbBoxCategoria = new JComboBox();
				cbBoxCategoria.setBounds(155, 93, 101, 20);
				panel.add(cbBoxCategoria);
			}
			{
				lblNewLabel_3 = new JLabel("Categoría Producto:");
				lblNewLabel_3.setBounds(19, 96, 111, 14);
				panel.add(lblNewLabel_3);
			}
			{
				btnRemoverProducto = new JButton("Remover producto");
				btnRemoverProducto.addActionListener(this);
				btnRemoverProducto.setForeground(Color.BLACK);
				btnRemoverProducto.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
				btnRemoverProducto.setBackground(Color.LIGHT_GRAY);
				btnRemoverProducto.setBounds(65, 339, 145, 20);
				panel.add(btnRemoverProducto);				
			}
			
	

	cbBoxCategoria.setModel(new DefaultComboBoxModel<>(new String[] {
		"Seleccione Tamaño", "Personal", "Familiar"
	}));
	
	cbBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			calcularPrecioPorTamañoYTopping();
		}
	});	    
		
		btnCargarProductos = new JButton("Cargar Productos");
		btnCargarProductos.addActionListener(this);
		btnCargarProductos.setBackground(Color.LIGHT_GRAY);
		btnCargarProductos.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		btnCargarProductos.setBounds(65, 399, 145, 20);
		panel.add(btnCargarProductos);
		
		btnDescargarProductos = new JButton("Descargar Productos");
		btnDescargarProductos.addActionListener(this);
		btnDescargarProductos.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		btnDescargarProductos.setBackground(Color.LIGHT_GRAY);
		btnDescargarProductos.setBounds(65, 369, 145, 20);
		panel.add(btnDescargarProductos);
		{
			lblNewLabel_4 = new JLabel("Fecha Producción:");
			lblNewLabel_4.setBounds(19, 255, 111, 14);
			panel.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 =new JLabel("Fecha Vencimiento:");
			lblNewLabel_5.setBounds(19, 283, 111, 14);
			panel.add(lblNewLabel_5);
		}
		{
			txtFechaProduccion = new JTextField();
			txtFechaProduccion.setBounds(155, 248, 101, 20);
			panel.add(txtFechaProduccion);
			txtFechaProduccion.setColumns(10);
		}
		{
			txtFechaVencimiento = new JTextField();
			txtFechaVencimiento.setColumns(10);
			txtFechaVencimiento.setBounds(155, 280, 101, 20);
			panel.add(txtFechaVencimiento);
		}
		{
			btnNewButton = new JButton("Regresar");
			btnNewButton.addActionListener(this);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton.setBackground(Color.RED);
			btnNewButton.setBounds(636, 429, 146, 23);
			panel.add(btnNewButton);
		}
		{
			lblNewLabel_6 = new JLabel("Descripción Producto:");
			lblNewLabel_6.setBounds(19, 126, 111, 14);
			panel.add(lblNewLabel_6);
		}
		{
			txtDescripcionProducto = new JTextField();
			txtDescripcionProducto.setColumns(10);
			txtDescripcionProducto.setBounds(155, 123, 101, 57);
			panel.add(txtDescripcionProducto);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnDescargarProductos) {
			do_btnDescargarProductos_actionPerformed(e);
		}
		if (e.getSource() == btnCargarProductos) {
			do_btnCargarProductos_actionPerformed(e);
		}
		if (e.getSource() == btnRemoverProducto) {
			do_btnRemoverProducto_actionPerformed(e);
		}
		if (e.getSource() == btnAgregarProducto) {
			do_btnAgregarProducto_actionPerformed(e);
		}
	}
	
	ArregloProducto listado = new ArregloProducto();
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtFechaProduccion;
	private JTextField txtFechaVencimiento;
	private JButton btnNewButton;
	private JLabel lblNewLabel_6;
	private JTextField txtDescripcionProducto;
	
	protected void do_btnAgregarProducto_actionPerformed(ActionEvent e) {
		try {
			String id = txtIdProducto.getText();    
	        String nom = txtNombreProducto.getText();   
	        String cat = cbBoxCategoria.getSelectedItem().toString();
	        String desc = txtDescripcionProducto.getText();   

	        int stock = Integer.parseInt(txtStockProducto.getText()); 
	        String fechaP=txtFechaProduccion.getText();
	        String fechaV=txtFechaVencimiento.getText();
	        double precio = Double.parseDouble(txtPrecioProducto.getText()); 

	        
	        Producto nuevo = new Producto(id, nom, cat, desc, stock, precio,fechaP,fechaV);

	        ap.Adicionar(nuevo);
	        listar();
	        
	        javax.swing.JOptionPane.showMessageDialog(this, "¡Producto registrado correctamente!");

	        txtIdProducto.setText("");
	        txtNombreProducto.setText("");
	        cbBoxCategoria.setSelectedItem("N/A");
	        txtStockProducto.setText("");
	        txtPrecioProducto.setText("");
	        txtFechaProduccion.setText("");
	        txtFechaVencimiento.setText("");
	        txtIdProducto.requestFocus();
	        
	        if(stock <= 5){
	            JOptionPane.showMessageDialog(null,
	                "⚠ Queda poco stock del producto: " + id );}
	       
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
		    imprimir("FECHA PRODUCCION:  " + p.getFechaP_prod());
		    imprimir("FECHA VENCIMIENTO:  " + p.getFechaV_prod());
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
		try {
			String id=txtIdProducto.getText().trim();
			if (id.isEmpty())
				MensajeEmergente("¡Inserte el id del producto a eliminar!");
			else {
				Producto pro=ap.Eliminar(id);
				if (pro!=null) {
					listar();
					MensajeEmergente("¡Producto eliminado correctamente!");
					txtIdProducto.setText("");
					txtIdProducto.requestFocus();
					}
				else MensajeEmergente("¡No se encontro el producto!");
				}
			}catch (Exception ex) {
				MensajeEmergente("Error al eliminar producto!");
			}
		}
	protected void do_btnCargarProductos_actionPerformed(ActionEvent e) {
		
		try {
			
			JFileChooser archivo_elegido = new JFileChooser();
			archivo_elegido.setDialogTitle("Seleccionar archivo de productos");
			int seleccionado = archivo_elegido.showOpenDialog(this);
			if (seleccionado == JFileChooser.APPROVE_OPTION) {
				File archivo = archivo_elegido.getSelectedFile();
				BufferedReader lector = new BufferedReader(new FileReader(archivo));
				String linea;
				
				ap = new ArregloProducto();
				
				while ((linea = lector.readLine()) != null) {
					String[] datos = linea.split(",");
					
					if (datos.length == 8) {
						String id = datos[0];
						String nombre = datos[1];
						String categoria = datos[2];
						String desc = datos[3];
						int stock = Integer.parseInt(datos[4]);
						double precio = Double.parseDouble(datos[5]);
						String fechaP = datos[6];
						String fechaV = datos[7];
						
						Producto p = new Producto(id, nombre, categoria, desc, stock, precio, fechaP, fechaV);
						ap.Adicionar(p);
					}
					
					
				}
				lector.close();
				
				listar();
				MensajeEmergente("¡Productos cargados exitosamente!");
			
			}
			
		
		}catch (Exception ex) {
			MensajeEmergente("Error al cargar los productos,su archivo debe ser de formato texto intente nuevamente!");
		}
		
	}
	

	protected void do_btnDescargarProductos_actionPerformed(ActionEvent e) {
		
		if (ap.Tamaño() == 0) {
			MensajeEmergente("¡El inventario está vacío! No hay productos para descargar.");
			return;
		}
		try {
			JFileChooser archivo_elegido = new JFileChooser();
			archivo_elegido.setDialogTitle("Guardar inventario de productos");
			int seleccionado = archivo_elegido.showSaveDialog(this);
			
			if (seleccionado == JFileChooser.APPROVE_OPTION) {
				File archivo = archivo_elegido.getSelectedFile();
				
				if (!archivo.getName().toLowerCase().endsWith(".txt")) {
					archivo = new File(archivo.getAbsolutePath() + ".txt");
					
				}
				
				PrintWriter imprimidor = new PrintWriter(new FileWriter(archivo));
				
				for (int i =0;i < ap.Tamaño(); i++) {
					Producto p = ap.Obtener(i);
					imprimidor.println(p.getId_prod() + "," + 
					           p.getNombre_prod() + "," + 
					           p.getCategoria_prod() + "," + 
					           p.getDescripcion_prod() + "," + 
					           p.getStock_prod() + "," + 
					           p.getFechaP_prod() + "," + 
					           p.getFechaV_prod() + "," + 
					           p.getPrecio_prod());
					
					           
					
				}
				imprimidor.close();
				MensajeEmergente("¡Productos guardados exitosamente en \n" + archivo.getName() +  "!");
			}
			
		}catch (Exception ex) {
			//MensajeEmergente("Error al cargar los productos!");
			MensajeEmergente("Error al descargar los productos: "+ex.getMessage());
		}
		
		
	}
	
		void calcularPrecioPorTamañoYTopping() {
			String tamaño = cbBoxCategoria.getSelectedItem().toString();
			double precioBase = 0.0;
			double costoToppings = 0.0;
			
			
			if (tamaño.equals("Personal")) {
				precioBase = 15.00;
			} else if (tamaño.equals("Familiar")) {
				precioBase = 35.00;
			}
			
			
			if (!txtNombreProducto.getText().trim().isEmpty()) {
				costoToppings = 4.50; 
			}
			
			double precioFinal = precioBase + costoToppings;
			
			if (precioFinal > 0) {
				txtPrecioProducto.setText(String.valueOf(precioFinal));
				
				txtS.setText("");
				txtS.append("=====================================\n");
				txtS.append("       DETALLE DE POSTRE ARMADO      \n");
				txtS.append("=====================================\n");
				txtS.append(" Tamaño elegido: " + tamaño + " (S/. " + precioBase + ")\n");
				if (costoToppings > 0) {
					txtS.append(" Toppings Extras: Activado (S/. " + costoToppings + ")\n");
				}
				txtS.append("-------------------------------------\n");
				txtS.append(" PRECIO TOTAL ACTUALIZADO: S/. " + precioFinal + "\n");
				txtS.append("=====================================\n");
			} else {
				txtPrecioProducto.setText("");
			}
		}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		VOpcion opcion  = new VOpcion();
		opcion.setLocationRelativeTo(null); 
		opcion.setVisible(true);
		dispose();
	}
	}
