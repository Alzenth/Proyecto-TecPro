package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.VGestionProductos;
import admin.VOpcion;
import arraylist.ArrayCarrito;
import clases.ArregloProducto;
import clases.Intermediario;
import cliente.Vbienvenida;
import cliente.Vcatalogo;
import conexion.ConexionBD;
import constructores.Carrito;
import constructores.Cliente;
import constructores.Empleado;
import constructores.Producto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Vlogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusuario;
	private JButton btnRegis;


	private int intentosFallidos = 0;
	private final int MAX_INTENTOS = 3;
	private final int TIEMPO_BLOQUEO = 15;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vlogin frame = new Vlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JLabel lblUsuario;
	private JLabel lblContra;
	private JLabel lblinicia;
	private JButton btnIngresar;
	/**
	 * Create the frame.
	 */
	public Vlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(224, 99, 97, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(134, 102, 68, 14);
		contentPane.add(lblUsuario);
		
		lblContra = new JLabel("Contraseña");
		lblContra.setBounds(134, 133, 68, 14);
		contentPane.add(lblContra);
		
		lblinicia = new JLabel("Iniciar Sesión");
		lblinicia.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblinicia.setBounds(123, 11, 198, 68);
		contentPane.add(lblinicia);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(175, 161, 96, 23);
		contentPane.add(btnIngresar);
		
		btnRegis = new JButton("Registrarse");
		btnRegis.addActionListener(this);
		btnRegis.setBounds(159, 227, 129, 23);
		contentPane.add(btnRegis);
		
		JLabel lblNewLabel = new JLabel("¿No tienes cuenta?");
		lblNewLabel.setBounds(175, 205, 110, 14); 
		contentPane.add(lblNewLabel);
		{
			txtPassWord = new JPasswordField();
			txtPassWord.setBounds(224, 129, 96, 20);
			contentPane.add(txtPassWord);
		}
		{
			btnNewButton = new JButton("Programadores");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(10, 228, 122, 20);
			contentPane.add(btnNewButton);
		}

	}
	clases.ArregloCliente c = new clases.ArregloCliente();
	clases.ArregloEmpleado em=new clases.ArregloEmpleado();
	private JPasswordField txtPassWord;
	private JButton btnNewButton;
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
		if (e.getSource() == btnRegis) {
			do_btnNewButton_1_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		VRegistro vr= new VRegistro();
		
		vr.setVisible(true);
		dispose();
		
		return;
	}
	
	private void bloquearBoton() {
	    btnIngresar.setEnabled(false);

	    Timer timer = new Timer(TIEMPO_BLOQUEO * 1000, e -> {
	        btnIngresar.setEnabled(true);
	        intentosFallidos = 0; 
	        JOptionPane.showMessageDialog(this,
	                "Ya puedes volver a intentar iniciar sesión.");
	    });

	    timer.setRepeats(false);
	    timer.start();

	    JOptionPane.showMessageDialog(this,
	            "Has alcanzado el máximo de intentos.\n"
	            + "El botón estará deshabilitado durante "
	            + TIEMPO_BLOQUEO + " segundos.");
	}
	
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		
		String usuario = txtusuario.getText();
		char[] password = txtPassWord.getPassword();
		String contr = new String(password);
	    
	    if (usuario.isEmpty() || contr.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "¡Todos los campos deben estar llenos!", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    int dniIngresado = 0;
	    try {
	    	dniIngresado = Integer.parseInt(usuario);
	    }catch (NumberFormatException ex) {
	    	JOptionPane.showMessageDialog(this, "El campo Usuario (DNI) debe contener solo números.", "Error de Formato", JOptionPane.WARNING_MESSAGE);
	        return; 
	    }
	    
	    ConexionBD db = new ConexionBD();
	    Connection conectar = db.conectar();
	    
	    
	    if(conectar != null) {
	    	try {
	    		String sqlAdmin = "SELECT * FROM ADMINISTRADOR WHERE DNI = ? AND CONTRASEÑA = ?";
	            PreparedStatement plantilla = conectar.prepareStatement(sqlAdmin);
	            plantilla.setInt(1, dniIngresado); 
	            plantilla.setString(2, contr);
	            
	            ResultSet tabla_resultado = plantilla.executeQuery();

	            if (tabla_resultado.next()) {
		            Intermediario.dniAdminActual = txtusuario.getText(); //Guardamos el DNI del administrador
	            	JOptionPane.showMessageDialog(this, "¡Bienvenido Administrador!", "Acceso Concedido", JOptionPane.INFORMATION_MESSAGE);
	                
	            	
	        		VGestionProductos gPro = new VGestionProductos();
	        		gPro.setLocationRelativeTo(null); 
	        		gPro.setVisible(true);
	        	    
	        	    this.dispose();
	            } else {
	            	String sqlCliente = "SELECT * FROM CLIENTE WHERE DNI = ? AND CONTRASEÑA = ?";
	            	PreparedStatement plantillaCliente = conectar.prepareStatement(sqlCliente);
	            	plantillaCliente.setInt(1, dniIngresado); 
	            	plantillaCliente.setString(2, contr);
		            
		            ResultSet tabla_resultado_Cliente = plantillaCliente.executeQuery();
		            
		            if(tabla_resultado_Cliente.next()) {
		            	Vbienvenida bienvenida = new Vbienvenida(usuario);
			            Intermediario.dniClienteActual = txtusuario.getText(); //Guardamos el DNI del cliente
			            

			        	ArrayCarrito ac = new ArrayCarrito();
	        			ac.AgregarCarrito();
	        			
	        			String idCarrito = ac.ObtenerIDCarrito(Intermediario.dniClienteActual);
	        			Intermediario.idCarritoActual = idCarrito;
	        			
	        			System.out.println("DNI de Cliente: " + Intermediario.dniClienteActual + "\nCarrito asignado: " + Intermediario.idCarritoActual);
	        			
		            	JOptionPane.showMessageDialog(this, "¡Bienvenido a tu cuenta!", "Acceso Concedido", JOptionPane.INFORMATION_MESSAGE);
	                    
	                    Vcatalogo ventanacatalogo = new Vcatalogo();
	                    ventanacatalogo.setVisible(true);
	                    this.dispose();
		            } else {
		            	intentosFallidos++;

		            	if (intentosFallidos >= MAX_INTENTOS) {
		            	    bloquearBoton();
		            	} else {
		            	    JOptionPane.showMessageDialog(this,
		            	            "DNI o contraseña incorrectos.\n"
		            	            + "Intento " + intentosFallidos + " de " + MAX_INTENTOS + ".",
		            	            "Error de Acceso",
		            	            JOptionPane.ERROR_MESSAGE);
		            	}
		            	
		            	
		            }
		            
		            tabla_resultado_Cliente.close();
		            plantillaCliente.close();
		            
	            }
	            
	            tabla_resultado.close();
	            plantilla.close();
	            conectar.close();
	            
	    		
	    		
	    	}catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "Error de SQL: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    	
	    	
	    	
	    } else {
	        JOptionPane.showMessageDialog(this, "No se pudo conectar a la BD.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		Creadores creadoress = new Creadores();
		creadoress.setVisible(true);
        
		
	}
}
