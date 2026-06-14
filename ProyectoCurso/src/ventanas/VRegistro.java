package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import conexion.ConexionBD;

import java.awt.event.ActionEvent;

public class VRegistro extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRegistro frame = new VRegistro();
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
	private JLabel lblcrea;
	private JLabel lblnombra;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JLabel lblapellido;
	private JTextField txtdni;
	private JLabel lbldni;
	private JTextField txtcorreo;
	private JLabel lblcorreo;
	private JLabel lbltele;
	private JTextField txttele;
	private JLabel lblcontra2;
	private JTextField txtcont2;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	
	public VRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblcrea = new JLabel("Crea tu cuenta");
		lblcrea.setBounds(107, 33, 224, 39);
		lblcrea.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(lblcrea);
		
		lblnombra = new JLabel("Nombre");
		lblnombra.setBounds(50, 101, 46, 14);
		contentPane.add(lblnombra);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(129, 98, 174, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(129, 124, 174, 20);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		lblapellido = new JLabel("Apellido");
		lblapellido.setBounds(50, 127, 54, 14);
		contentPane.add(lblapellido);
		
		txtdni = new JTextField();
		txtdni.setBounds(129, 149, 174, 20);
		contentPane.add(txtdni);
		txtdni.setColumns(10);
		
		lbldni = new JLabel("Dni");
		lbldni.setBounds(60, 152, 25, 14);
		contentPane.add(lbldni);
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(129, 200, 174, 20);
		contentPane.add(txtcorreo);
		txtcorreo.setColumns(10);
		
		lblcorreo = new JLabel("Correo");
		lblcorreo.setBounds(60, 203, 46, 14);
		contentPane.add(lblcorreo);
		
		lbltele = new JLabel("Teléfono");
		lbltele.setBounds(50, 179, 59, 14);
		contentPane.add(lbltele);
		
		txttele = new JTextField();
		txttele.setBounds(129, 176, 174, 20);
		contentPane.add(txttele);
		txttele.setColumns(10);
		
		lblcontra2 = new JLabel("Contraseña");
		lblcontra2.setBounds(50, 227, 79, 14);
		contentPane.add(lblcontra2);
		
		txtcont2 = new JTextField();
		txtcont2.setBounds(129, 224, 174, 20);
		contentPane.add(txtcont2);
		txtcont2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("¿Tienes cuenta?");
		lblNewLabel.setBounds(176, 313, 114, 14);
		contentPane.add(lblNewLabel);
		{
			btnNewButton_1 = new JButton("Iniciar sesión");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBounds(156, 338, 122, 35);
			contentPane.add(btnNewButton_1);
		}
		
		btnNewButton_2 = new JButton("Crear cuenta");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(156, 255, 122, 35);
		contentPane.add(btnNewButton_2);
	}
	public boolean verificardni(String dni) {
		for(int i = 0; i < dni.length(); i++) {
		    if(!Character.isDigit(dni.charAt(i))) {
		        return true;
		        }
	}
		return false;
}
	public boolean verificartelef(String telef) {
		for(int i = 0; i < telef.length(); i++) {
		    if(!Character.isDigit(telef.charAt(i))) {
		        return true;
		        }
	}
		return false;
}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		Vlogin vl=new Vlogin();
		vl.setVisible(true);
		dispose();
		return;
	}

	clases.ArregloCliente c=new clases.ArregloCliente();
	private JButton btnNewButton_2;
	
	
	
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
	    
	    String nom = txtnombre.getText().trim();
	    String ape = txtapellido.getText().trim();
	    String dniTexto = txtdni.getText().trim();
	    String tel = txttele.getText().trim();
	    String cor = txtcorreo.getText().trim();
	    String contra = txtcont2.getText().trim();


	    if (nom.isEmpty() || ape.isEmpty() || dniTexto.isEmpty() || tel.isEmpty() || cor.isEmpty() || contra.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Complete todos los campos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
	        return; 
	    } 
	    else if (dniTexto.length() != 8) {
	        JOptionPane.showMessageDialog(this, "El DNI debe tener 8 dígitos", "Error de Formato", JOptionPane.WARNING_MESSAGE);
	        return;
	    } 
	    else if (verificardni(dniTexto)) {
	        JOptionPane.showMessageDialog(this, "El DNI solo debe contener números", "Error de Formato", JOptionPane.WARNING_MESSAGE);
	        return;
	    } 
	    else if (tel.length() != 9) {
	        JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos", "Error de Formato", JOptionPane.WARNING_MESSAGE);
	        return;
	    } 
	    else if (verificartelef(tel)) {
	        JOptionPane.showMessageDialog(this, "El teléfono solo debe contener números", "Error de Formato", JOptionPane.WARNING_MESSAGE);
	        return;
	    } 
	    else if (contra.length() < 8) {
	        JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 6 caracteres", "Seguridad", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    
	    int dni = Integer.parseInt(dniTexto);
	    
	    
	    ConexionBD db = new ConexionBD();
	    Connection conectar = db.conectar();
	    
	    if (conectar != null) {
	        try {
	            String sql = "INSERT INTO CLIENTE (NOMBRES, APELLIDOS, EMAIL, CONTRASEÑA, DNI, FECHA_NACIMIENTO, TELEFONO) "
	                       + "VALUES (?, ?, ?, ?, ?, '2000-01-01', ?)";
	            PreparedStatement plantilla= conectar.prepareStatement(sql);
	            
	            plantilla.setString(1, nom);
	            plantilla.setString(2, ape);
	            plantilla.setString(3, cor);
	            plantilla.setString(4, contra);
	            plantilla.setInt(5, dni);
	            plantilla.setString(6, tel);
	            
	            int filas_Afectadas = plantilla.executeUpdate();
	            
	            if (filas_Afectadas > 0) {
	                JOptionPane.showMessageDialog(this, "¡Cuenta creada exitosamente!\nTu usuario es: " + dni, "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
	                
	                
	                txtnombre.setText("");
	                txtapellido.setText("");
	                txtcorreo.setText("");
	                txtcont2.setText("");
	                txttele.setText("");
	                txtdni.setText("");
	            }
	            
	            plantilla.close();
	            conectar.close();
	            
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "Error al registrar en la BD: " + ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
	    }
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
	}
}
