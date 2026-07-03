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

import arraylist.ArrayCliente;
import conexion.ConexionBD;
import constructores.Cliente;

import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

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
		
		lblnombra = new JLabel("Nombres:");
		lblnombra.setBounds(50, 101, 69, 14);
		contentPane.add(lblnombra);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(129, 98, 174, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(129, 124, 174, 20);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		lblapellido = new JLabel("Apellidos:");
		lblapellido.setBounds(50, 127, 65, 14);
		contentPane.add(lblapellido);
		
		txtdni = new JTextField();
		txtdni.setBounds(129, 149, 174, 20);
		contentPane.add(txtdni);
		txtdni.setColumns(10);
		
		lbldni = new JLabel("Dni");
		lbldni.setBounds(50, 151, 34, 14);
		contentPane.add(lbldni);
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(129, 200, 174, 20);
		contentPane.add(txtcorreo);
		txtcorreo.setColumns(10);
		
		lblcorreo = new JLabel("Correo");
		lblcorreo.setBounds(50, 202, 46, 14);
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
		{
			txtPassWord = new JPasswordField();
			txtPassWord.setBounds(129, 225, 174, 18);
			contentPane.add(txtPassWord);
		}
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
	private JPasswordField txtPassWord;
	
	
	
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
	    try {
	    
	    String nom = txtnombre.getText().trim();
	    String ape = txtapellido.getText().trim();
	    String dni = txtdni.getText().trim();
	    String tel = txttele.getText().trim();
	    String cor = txtcorreo.getText().trim();
	    char[] password = txtPassWord.getPassword();
		String contr = new String(password);

		if (dni.length() == 8) {
			if (tel.length() == 9) {
				if (contr.length() == 8) {
					
					Cliente cli = new Cliente( nom,ape , dni,contr,cor, tel);
			        
			        ArrayCliente bdCliente = new ArrayCliente();
			        bdCliente.Insertar(cli);
			        
			        JOptionPane.showMessageDialog(this, "¡Usted se registro correctamente!");
			        Vlogin ventanaLogin = new Vlogin();
			        ventanaLogin.setLocationRelativeTo(null); 
			        ventanaLogin.setVisible(true);
			        this.dispose();
			        
				} else MensajeEmergente("¡Ingrese una contraseña válida de 8 dígitos!");
			} else MensajeEmergente("¡Ingrese un número telefónico válido!");
		} else MensajeEmergente("¡Ingrese un dni válido!");
	    
		
	 }catch (Exception ex) {
			MensajeEmergente("Error: Revisa los campos");
			}
	}
	
	void MensajeEmergente(String s) {
		JOptionPane.showMessageDialog(this, s);
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
