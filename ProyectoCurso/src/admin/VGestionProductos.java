package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arraylist.ArrayProducto;
import clases.ArregloProducto;
import constructores.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;

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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VGestionProductos extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAgregarProducto;
	private JLabel lblMenu;
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
		setBounds(100, 100, 1140, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaption);
			panel.setBounds(0, 0, 1126, 545);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				btnAgregarProducto = new JButton("Registrar producto");
				btnAgregarProducto.addActionListener(this);
				btnAgregarProducto.setForeground(Color.BLACK);
				btnAgregarProducto.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
				btnAgregarProducto.setBackground(Color.LIGHT_GRAY);
				btnAgregarProducto.setBounds(949, 19, 145, 20);
				panel.add(btnAgregarProducto);
			}
			{
				lblMenu = new JLabel("Menú: Gestión de productos");
				lblMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
				lblMenu.setBounds(10, 0, 267, 29);
				panel.add(lblMenu);
			}
			{
				txtIdProducto = new JTextField();
				txtIdProducto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				txtIdProducto.setBounds(156, 35, 121, 20);
				panel.add(txtIdProducto);
				txtIdProducto.setColumns(10);
			}
			{
				txtNombreProducto = new JTextField();
				txtNombreProducto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				txtNombreProducto.setBounds(156, 65, 121, 20);
				panel.add(txtNombreProducto);
				txtNombreProducto.setColumns(10);

			}
			}
			{
				txtStockProducto = new JTextField();
				txtStockProducto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				txtStockProducto.setBounds(810, 19, 101, 20);
				panel.add(txtStockProducto);
				txtStockProducto.setColumns(10);
			}
			{
				lblNewLabel = new JLabel("ID Producto:");
				lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				lblNewLabel.setBounds(20, 38, 111, 14);
				panel.add(lblNewLabel);
			}
			{
				lblConsultaElStock = new JLabel("Nombre Producto:");
				lblConsultaElStock.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				lblConsultaElStock.setBounds(20, 68, 126, 14);
				panel.add(lblConsultaElStock);
			}
			{
				lblNewLabel_2 = new JLabel("Stock  Producto:");
				lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				lblNewLabel_2.setBounds(674, 22, 237, 14);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_1 = new JLabel("Precio Producto:");
				lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				lblNewLabel_1.setBounds(674, 49, 111, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txtPrecioProducto = new JTextField();
				txtPrecioProducto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				txtPrecioProducto.setColumns(10);
				txtPrecioProducto.setBounds(810, 46, 101, 20);
				panel.add(txtPrecioProducto);
			}
			{
				cbBoxCategoria = new JComboBox();
				cbBoxCategoria.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				cbBoxCategoria.setBounds(156, 99, 121, 20);
				panel.add(cbBoxCategoria);
			}
			{
				lblNewLabel_3 = new JLabel("Categoría Producto:");
				lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				lblNewLabel_3.setBounds(20, 102, 126, 14);
				panel.add(lblNewLabel_3);
			}
			{
				btnRemoverProducto = new JButton("Remover producto");
				btnRemoverProducto.addActionListener(this);
				btnRemoverProducto.setForeground(Color.BLACK);
				btnRemoverProducto.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
				btnRemoverProducto.setBackground(Color.LIGHT_GRAY);
				btnRemoverProducto.setBounds(949, 49, 145, 20);
				panel.add(btnRemoverProducto);				
			}
			
	

	cbBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una categoría", "Chocotejas", "Cuchareables"}));
	
	cbBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			
			
		}
	});	    
		
		btnCargarProductos = new JButton("Cargar Productos");
		btnCargarProductos.addActionListener(this);
		btnCargarProductos.setBackground(Color.LIGHT_GRAY);
		btnCargarProductos.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		btnCargarProductos.setBounds(210, 499, 145, 20);
		panel.add(btnCargarProductos);
		
		btnDescargarProductos = new JButton("Descargar Productos");
		btnDescargarProductos.addActionListener(this);
		btnDescargarProductos.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		btnDescargarProductos.setBackground(Color.LIGHT_GRAY);
		btnDescargarProductos.setBounds(30, 499, 145, 20);
		panel.add(btnDescargarProductos);
		{
			lblNewLabel_4 = new JLabel("Fecha Producción:");
			lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(674, 80, 111, 14);
			panel.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 =new JLabel("Fecha Vencimiento:");
			lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			lblNewLabel_5.setBounds(674, 112, 111, 14);
			panel.add(lblNewLabel_5);
		}
		{
			txtFechaProduccion = new JTextField();
			txtFechaProduccion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			txtFechaProduccion.setBounds(810, 77, 101, 20);
			panel.add(txtFechaProduccion);
			txtFechaProduccion.setColumns(10);
		}
		{
			txtFechaVencimiento = new JTextField();
			txtFechaVencimiento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			txtFechaVencimiento.setColumns(10);
			txtFechaVencimiento.setBounds(810, 109, 101, 20);
			panel.add(txtFechaVencimiento);
		}
		{
			btnNewButton = new JButton("Regresar");
			btnNewButton.addActionListener(this);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton.setBackground(Color.RED);
			btnNewButton.setBounds(934, 498, 146, 23);
			panel.add(btnNewButton);
		}
		{
			lblNewLabel_6 = new JLabel("Descripción Producto:");
			lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			lblNewLabel_6.setBounds(322, 22, 126, 14);
			panel.add(lblNewLabel_6);
		}
		{
			
			txtDescripcionProducto = new JTextArea();
			txtDescripcionProducto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			txtDescripcionProducto.setLineWrap(true); 
			txtDescripcionProducto.setWrapStyleWord(true);

			
			JScrollPane scrollDescripcion = new JScrollPane(txtDescripcionProducto);
			scrollDescripcion.setBounds(322, 47, 296, 72);
			panel.add(scrollDescripcion);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(this);
			scrollPane.setBounds(20, 139, 1096, 343);
			panel.add(scrollPane);
			{
				tbTable = new JTable();
				tbTable.addMouseListener(this);
				scrollPane.setViewportView(tbTable);
			}
		}
		{
			btnModificarProducto = new JButton("Modificar producto");
			btnModificarProducto.addActionListener(this);
			btnModificarProducto.setForeground(Color.BLACK);
			btnModificarProducto.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
			btnModificarProducto.setBackground(Color.LIGHT_GRAY);
			btnModificarProducto.setBounds(949, 79, 145, 20);
			panel.add(btnModificarProducto);
		}
		{
			btnConsultarProducto = new JButton("Consultar producto");
			btnConsultarProducto.addActionListener(this);
			btnConsultarProducto.setForeground(Color.BLACK);
			btnConsultarProducto.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
			btnConsultarProducto.setBackground(Color.LIGHT_GRAY);
			btnConsultarProducto.setBounds(949, 109, 145, 20);
			panel.add(btnConsultarProducto);
		}
		{
			btnCargarImagen = new JButton("Cargar Imagen");
			btnCargarImagen.addActionListener(this);
			btnCargarImagen.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
			btnCargarImagen.setBackground(Color.LIGHT_GRAY);
			btnCargarImagen.setBounds(387, 500, 145, 20);
			panel.add(btnCargarImagen);
		}
		
		Listar("");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				txtIdProducto.requestFocus();
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCargarImagen) {
			do_btnCargarImagen_actionPerformed(e);
		}
		if (e.getSource() == btnModificarProducto) {
			do_btnModificarProducto_actionPerformed(e);
		}
		if (e.getSource() == btnConsultarProducto) {
			do_btnConsultarProducto_actionPerformed(e);
		}
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
	private JTextArea txtDescripcionProducto;
	private JScrollPane scrollPane;
	private JTable tbTable;
	private JButton btnModificarProducto;
	private JButton btnConsultarProducto;
	private JButton btnCargarImagen;
	
	protected void do_btnAgregarProducto_actionPerformed(ActionEvent e) {
		try {
			
			String id = txtIdProducto.getText();    
	        String nom = txtNombreProducto.getText();   
	        String cat = cbBoxCategoria.getSelectedItem().toString();
	        String desc = txtDescripcionProducto.getText();   

	        int stock = Integer.parseInt(txtStockProducto.getText()); 
	        double precio = Double.parseDouble(txtPrecioProducto.getText()); 
	        
	        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	        formatoFecha.setLenient(false);
	        
	        java.util.Date utilFechaP = formatoFecha.parse(txtFechaProduccion.getText());
	        java.util.Date utilFechaV = formatoFecha.parse(txtFechaVencimiento.getText());
	        
	        Date fechaP = new Date(utilFechaP.getTime());
	        Date fechaV = new Date(utilFechaV.getTime());
	        
	        
	        
	        if (!cat.equals("Seleccione una categoría")) {
	        	if (stock >=0) {
	        		if(precio >= 0) {
	        			Producto nuevo = new Producto(id, nom, cat,  desc, stock,precio, fechaP, fechaV );
				        
				        ArrayProducto bdProducto = new ArrayProducto();
			            bdProducto.Insertar(nuevo);
				        
				        Listar("");
				        
				        txtIdProducto.setText("");
				        txtNombreProducto.setText("");
				        cbBoxCategoria.setSelectedItem(0);
				        cbBoxCategoria.setSelectedItem("");
				        txtStockProducto.setText("");
				        txtDescripcionProducto.setText("");
				        txtPrecioProducto.setText("");
				        txtFechaProduccion.setText("");
				        txtFechaVencimiento.setText("");
				        txtIdProducto.requestFocus();
				        
				        if(stock <= 5){
				            JOptionPane.showMessageDialog(null,"Queda poco stock del producto: " + id );
				            }
				        JOptionPane.showMessageDialog(this, "¡Producto registrado correctamente!");
				        
	        		}else MensajeEmergente("Ingrese un precio valido");
	        		
	        	}else MensajeEmergente("Debe ingresar un Stock válido");
	        	
	        	
	        } else MensajeEmergente("Seleccione una categoría válida");
	        
	        
	        }catch (Exception ex) {
			MensajeEmergente("Error: Revisa los campos");
			}
	}

	
	
	void MensajeEmergente(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	

	
	protected void do_btnRemoverProducto_actionPerformed(ActionEvent e) {
		try {
			ArrayProducto eli = new ArrayProducto();
			eli.Eliminar(txtIdProducto.getText());
			Listar("");
			}catch (Exception ex) {
				MensajeEmergente("Error al eliminar producto!");
			}
		}
	
	public void Listar(String cod) {
		DefaultTableModel modelo = new DefaultTableModel();
		ArrayProducto pro = new ArrayProducto();
		ArrayList<Producto> lista = new ArrayList<Producto>();
		if (cod.length() == 0) 
			lista = pro.Listar_Productos_En_Tabla();
		else 
			lista= pro.Consultar_Producto(cod);
		
		modelo.setRowCount(lista.size());
		Iterator it = lista.iterator();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Categoría");
		modelo.addColumn("Descripción");	
		modelo.addColumn("Stock");
		modelo.addColumn("Precio");
		modelo.addColumn("Fecha de Producción");
		modelo.addColumn("Fecha de Expiración");
		int i=0;
		while (it.hasNext()) {
			Object obj = it.next();
			Producto prod= (Producto)obj;
			modelo.setValueAt(prod.getId_prod(), i, 0);
			modelo.setValueAt(prod.getNombre_prod(), i, 1);
			modelo.setValueAt(prod.getCategoria_prod(), i, 2);
			modelo.setValueAt(prod.getDescripcion_prod(), i, 3);
			modelo.setValueAt(prod.getStock_prod(), i, 4);
			modelo.setValueAt(prod.getPrecio_prod(), i, 5);
			modelo.setValueAt(prod.getFechaP_prod(), i, 6);
			modelo.setValueAt(prod.getFechaV_prod(), i, 7);
			
			i++;
			
			
		}
		tbTable.setModel(modelo);
		
		
		tbTable.getColumnModel().getColumn(0).setPreferredWidth(45);   
		tbTable.getColumnModel().getColumn(1).setPreferredWidth(180);  
		tbTable.getColumnModel().getColumn(2).setPreferredWidth(85);   
		tbTable.getColumnModel().getColumn(3).setPreferredWidth(470);  
		tbTable.getColumnModel().getColumn(4).setPreferredWidth(40);   
		tbTable.getColumnModel().getColumn(5).setPreferredWidth(40);   
		tbTable.getColumnModel().getColumn(6).setPreferredWidth(90);   
		tbTable.getColumnModel().getColumn(7).setPreferredWidth(90);   
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
                        
                        
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd"); // Ajustar según como se guarde
                        java.util.Date utilFechaP = formatoFecha.parse(datos[6]);
                        java.util.Date utilFechaV = formatoFecha.parse(datos[7]);
                        
                        java.sql.Date fechaP = new java.sql.Date(utilFechaP.getTime());
                        java.sql.Date fechaV = new java.sql.Date(utilFechaV.getTime());

                        Producto p = new Producto(id, nombre, categoria, desc, stock, precio, fechaP,fechaV);
                        ap.Adicionar(p);
                    }
                }
				lector.close();
				
				
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
					           p.getPrecio_prod()+ ","+
					           p.getFechaP_prod() + "," + 
					           p.getFechaV_prod() 
					           );
					
					           
					
				}
				imprimidor.close();
				MensajeEmergente("¡Productos guardados exitosamente en \n" + archivo.getName() +  "!");
			}
			
		}catch (Exception ex) {
			
			MensajeEmergente("Error al descargar los productos: "+ex.getMessage());
		}
		
		
	}
	
		
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		VOpcion opcion  = new VOpcion();
		opcion.setLocationRelativeTo(null); 
		opcion.setVisible(true);
		dispose();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbTable) {
			do_tbTable_mouseClicked(e);
		}
		if (e.getSource() == scrollPane) {
			do_scrollPane_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_scrollPane_mouseClicked(MouseEvent e) {
		
		
	}
	protected void do_btnConsultarProducto_actionPerformed(ActionEvent e) {
	    
	    String id = txtIdProducto.getText().trim();
	    String categoria = cbBoxCategoria.getSelectedItem().toString();

	    
	    ArrayProducto bd = new ArrayProducto();
	    ArrayList<Producto> lista = new ArrayList<Producto>();

	    
	    if (!id.isEmpty()) {
	        
	        lista = bd.Consultar_Producto(id);
	        
	        if (lista.isEmpty()) {
	            MensajeEmergente("No se encontró ningún producto con el ID: " + id);
	        }
	    } 
	    else if (!categoria.equals("Seleccione una categoría")) {
	        
	        lista = bd.Listador_Categoria(categoria);
	    } 
	    else {
	        
	        lista = bd.Listar_Productos_En_Tabla();
	    }

	    
	    DefaultTableModel modelo = new DefaultTableModel();
	    modelo.setRowCount(lista.size());
	    
	    modelo.addColumn("Código");
	    modelo.addColumn("Nombre");
	    modelo.addColumn("Categoría");
	    modelo.addColumn("Descripción");    
	    modelo.addColumn("Stock");
	    modelo.addColumn("Precio");
	    modelo.addColumn("Fecha de Producción");
	    modelo.addColumn("Fecha de Expiración");

	    int i = 0;
	    for (Producto prod : lista) {
	        modelo.setValueAt(prod.getId_prod(), i, 0);
	        modelo.setValueAt(prod.getNombre_prod(), i, 1);
	        modelo.setValueAt(prod.getCategoria_prod(), i, 2);
	        modelo.setValueAt(prod.getDescripcion_prod(), i, 3);
	        modelo.setValueAt(prod.getStock_prod(), i, 4);
	        modelo.setValueAt(prod.getPrecio_prod(), i, 5);
	        modelo.setValueAt(prod.getFechaP_prod(), i, 6);
	        modelo.setValueAt(prod.getFechaV_prod(), i, 7);
	        i++;
	    }
	    
	    tbTable.setModel(modelo);
	    tbTable.getColumnModel().getColumn(0).setPreferredWidth(45);   
		tbTable.getColumnModel().getColumn(1).setPreferredWidth(180);  
		tbTable.getColumnModel().getColumn(2).setPreferredWidth(85);   
		tbTable.getColumnModel().getColumn(3).setPreferredWidth(470);  
		tbTable.getColumnModel().getColumn(4).setPreferredWidth(40);   
		tbTable.getColumnModel().getColumn(5).setPreferredWidth(40);   
		tbTable.getColumnModel().getColumn(6).setPreferredWidth(90);   
		tbTable.getColumnModel().getColumn(7).setPreferredWidth(90); 
	    
	}
	protected void do_tbTable_mouseClicked(MouseEvent e) {

		int fila =tbTable.getSelectedRow();
		
		txtIdProducto.setText(String.valueOf(tbTable.getValueAt(fila, 0)));
		txtNombreProducto.setText(String.valueOf(tbTable.getValueAt(fila, 1)));
		cbBoxCategoria.setSelectedItem((String.valueOf(tbTable.getValueAt(fila, 2))));
		txtDescripcionProducto.setText(String.valueOf(tbTable.getValueAt(fila, 3)));
		txtStockProducto.setText(String.valueOf(tbTable.getValueAt(fila, 4)));
		txtPrecioProducto.setText(String.valueOf(tbTable.getValueAt(fila, 5)));
		txtFechaProduccion.setText(String.valueOf(tbTable.getValueAt(fila, 6)));
		txtFechaVencimiento.setText(String.valueOf(tbTable.getValueAt(fila, 7)));
		
		try {
			SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
			
			String fechaPStr = String.valueOf(tbTable.getValueAt(fila, 6));
			String fechaVStr = String.valueOf(tbTable.getValueAt(fila, 7));
			
			
			if (fechaPStr.contains("-")) {
				txtFechaProduccion.setText(formatoSalida.format(formatoEntrada.parse(fechaPStr)));
			} else {
				
				txtFechaProduccion.setText(fechaPStr);
			}
			
			
			if (fechaVStr.contains("-")) {
				txtFechaVencimiento.setText(formatoSalida.format(formatoEntrada.parse(fechaVStr)));
			} else {
				txtFechaVencimiento.setText(fechaVStr);
			}
			
		} catch (Exception ex) {
			
			txtFechaProduccion.setText(String.valueOf(tbTable.getValueAt(fila, 6)));
			txtFechaVencimiento.setText(String.valueOf(tbTable.getValueAt(fila, 7)));
		}
		
		
		
		
	}
	protected void do_btnModificarProducto_actionPerformed(ActionEvent e) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.setLenient(false); 

			
			java.util.Date utilFechaP = formatoFecha.parse(txtFechaProduccion.getText());
			java.util.Date utilFechaV = formatoFecha.parse(txtFechaVencimiento.getText());

			
			java.sql.Date fechaP = new java.sql.Date(utilFechaP.getTime());
			java.sql.Date fechaV = new java.sql.Date(utilFechaV.getTime());
			
			Producto pro = new Producto(
					txtIdProducto.getText(),
					txtNombreProducto.getText(), 
					cbBoxCategoria.getSelectedItem().toString(), 
					txtDescripcionProducto.getText(),
					Integer.parseInt(txtStockProducto.getText()),
					Double.parseDouble(txtPrecioProducto.getText()),
					fechaP, fechaV
					);
			
			
				ArrayProducto m = new ArrayProducto();
				m.Editar(pro);
				Listar("");
			
			
			if (cbBoxCategoria.getSelectedItem().toString().equals("Seleccione una categoría")) {
				MensajeEmergente("Por favor, seleccione una categoría válida.");
				return; 
			}
			if (Integer.parseInt(txtStockProducto.getText()) <= 0) {
				MensajeEmergente("Debe ingresar un Stock válido.");
				return;
			}
			if (Double.parseDouble(txtPrecioProducto.getText())< 0) {
				MensajeEmergente("Ingrese un precio válido.");
				return;
			}
        		
			MensajeEmergente("¡Producto modificado correctamente!");
			txtIdProducto.setText("");
			txtNombreProducto.setText("");
			cbBoxCategoria.setSelectedItem(0);
			txtDescripcionProducto.setText("");
			txtStockProducto.setText("");
			txtPrecioProducto.setText("");
			txtFechaProduccion.setText("");
			txtFechaVencimiento.setText("");
			

			
		} catch (Exception e2) {
			
			MensajeEmergente("Sucedio un error"  + e2 + "\nIntentelo nuevamente");
		}
	}
	protected void do_btnCargarImagen_actionPerformed(ActionEvent e) {
	    
	    if(txtIdProducto.getText().trim().isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Seleccione o ingrese un ID de producto primero.");
	        return;
	    }

	    JFileChooser chooser = new JFileChooser();
	    chooser.setFileFilter(new FileNameExtensionFilter("Imágenes (PNG, JPG, JPEG)", "png", "jpg", "jpeg"));
	    int opcion = chooser.showOpenDialog(this);

	    if(opcion == JFileChooser.APPROVE_OPTION){
	        try {
	            File origen = chooser.getSelectedFile();
	            File carpeta = new File("imagenes"); 

	            if(!carpeta.exists()) {
	                carpeta.mkdir();
	            }

	            String id = txtIdProducto.getText().trim();
	            
	            String extension = origen.getName().substring(origen.getName().lastIndexOf(".")).toLowerCase();

	            File destino = new File(carpeta, id + extension);
	            
	            Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
	            
	            JOptionPane.showMessageDialog(this, "¡Imagen guardada correctamente para el producto " + id + "!");
	        } catch(Exception ex){
	            JOptionPane.showMessageDialog(this, "Error al guardar la imagen: " + ex.getMessage());
	        }
	    }
	}
}
