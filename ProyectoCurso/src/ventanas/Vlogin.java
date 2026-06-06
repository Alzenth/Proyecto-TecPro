package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.ArregloCliente;
import Clases.ArregloEmpleado;
import Constructores.Cliente;
import Constructores.Empleado;
import admin.VGestionProductos;
import cliente.Vbienvenida;
import cliente.Vcatalogo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vlogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusuario;
	private JTextField txtcontra;
	private JButton btnRegis;

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
	private JLabel lblcrea;
	private JLabel lblinicia;
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
	private JButton btnRegis2;
	private JButton btnIngresar;
	private JLabel lbltextcuen;
	private JLabel lblcontra2;
	private JTextField txtcont2;
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
		txtusuario.setBounds(224, 99, 86, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(134, 102, 68, 14);
		contentPane.add(lblUsuario);
		
		txtcontra = new JTextField();
		txtcontra.setBounds(224, 130, 86, 20);
		contentPane.add(txtcontra);
		txtcontra.setColumns(10);
		
		lblContra = new JLabel("Contraseña");
		lblContra.setBounds(134, 133, 68, 14);
		contentPane.add(lblContra);
		
		lblinicia = new JLabel("Iniciar Sesión");
		lblinicia.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblinicia.setBounds(123, 11, 198, 68);
		contentPane.add(lblinicia);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(174, 162, 96, 23);
		contentPane.add(btnIngresar);
		
		lbltextcuen = new JLabel("¿No tienes cuenta?");
		lbltextcuen.setBounds(172, 196, 116, 14);
		contentPane.add(lbltextcuen);
		
		btnRegis = new JButton("Registrarse");
		btnRegis.addActionListener(this);
		btnRegis.setBounds(159, 221, 129, 23);
		contentPane.add(btnRegis);
		
		lblcrea = new JLabel("Crea tu cuenta");
		lblcrea.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblcrea.setBounds(112, 26, 224, 39);
		contentPane.add(lblcrea);
		
		lblnombra = new JLabel("Nombre");
		lblnombra.setBounds(0, 93, 46, 14);
		contentPane.add(lblnombra);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(50, 90, 86, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(201, 90, 86, 20);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		lblapellido = new JLabel("Apellido");
		lblapellido.setBounds(148, 93, 54, 14);
		contentPane.add(lblapellido);
		
		txtdni = new JTextField();
		txtdni.setBounds(320, 90, 86, 20);
		contentPane.add(txtdni);
		txtdni.setColumns(10);
		
		lbldni = new JLabel("Dni");
		lbldni.setBounds(296, 93, 25, 14);
		contentPane.add(lbldni);
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(234, 130, 172, 20);
		contentPane.add(txtcorreo);
		txtcorreo.setColumns(10);
		
		lblcorreo = new JLabel("Correo");
		lblcorreo.setBounds(178, 133, 46, 14);
		contentPane.add(lblcorreo);
		
		lbltele = new JLabel("Teléfono");
		lbltele.setBounds(0, 132, 52, 14);
		contentPane.add(lbltele);
		
		txttele = new JTextField();
		txttele.setBounds(50, 130, 86, 20);
		contentPane.add(txttele);
		txttele.setColumns(10);
		
		btnRegis2 = new JButton("Registrarse");
		btnRegis2.addActionListener(this);
		btnRegis2.setBounds(159, 192, 129, 23);
		contentPane.add(btnRegis2);
		
		lblcontra2 = new JLabel("Contraseña");
		lblcontra2.setBounds(0, 166, 79, 14);
		contentPane.add(lblcontra2);
		
		txtcont2 = new JTextField();
		txtcont2.setBounds(78, 163, 86, 20);
		contentPane.add(txtcont2);
		txtcont2.setColumns(10);
		
		lblcrea.setVisible(false);
		lblnombra.setVisible(false);
		txtnombre.setVisible(false);

		lblapellido.setVisible(false);
		txtapellido.setVisible(false);

		lbldni.setVisible(false);
		txtdni.setVisible(false);

		lblcorreo.setVisible(false);
		txtcorreo.setVisible(false);

		lbltele.setVisible(false);
		txttele.setVisible(false);
		
		lblcontra2.setVisible(false);
		txtcont2.setVisible(false);

		btnRegis2.setVisible(false);

	}
	ArregloCliente c = new ArregloCliente();
	ArregloEmpleado em=new ArregloEmpleado();
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
		if (e.getSource() == btnRegis2) {
			do_btnRegis2_actionPerformed(e);
		}
		if (e.getSource() == btnRegis) {
			do_btnNewButton_1_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		txtcontra.setVisible(false);
		txtusuario.setVisible(false);
		lblContra.setVisible(false);
		lblUsuario.setVisible(false);
		lblinicia.setVisible(false);
		btnRegis.setVisible(false);
		lbltextcuen.setVisible(false);
		btnIngresar.setVisible(false);
		
		lblcrea.setVisible(true);
	    lblnombra.setVisible(true);
	    txtnombre.setVisible(true);

	    lblapellido.setVisible(true);
	    txtapellido.setVisible(true);

	    lbldni.setVisible(true);
	    txtdni.setVisible(true);

	    lblcorreo.setVisible(true);
	    txtcorreo.setVisible(true);
	    lblcontra2.setVisible(true);
		txtcont2.setVisible(true);

	    lbltele.setVisible(true);
	    txttele.setVisible(true);

	    btnRegis2.setVisible(true);

	}
	protected void do_btnRegis2_actionPerformed(ActionEvent e) {
		
		String nom=txtnombre.getText();
		String ape=txtapellido.getText();
		String dni=txtdni.getText();
		String tel=txttele.getText();
		String cor=txtcorreo.getText();
		String contra=txtcont2.getText();
		
		if (txtnombre.getText().isEmpty() || txtapellido.getText().isEmpty() || txtdni.getText().isEmpty() ||txttele.getText().isEmpty() ||
			txtcorreo.getText().isEmpty() ||txtcont2.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Complete todos los campos");
		}
		else if (dni.length() != 8) {JOptionPane.showMessageDialog(null,"El DNI debe tener 8 dígitos");}
		else if (verificardni(dni)==true) {JOptionPane.showMessageDialog(null,"El DNI solo debe contener números");}
		else if (tel.length() != 9) {JOptionPane.showMessageDialog(null,"El teléfono debe tener 9 dígitos");}
		else if (verificartelef(tel)==true) {JOptionPane.showMessageDialog(null,"El teléfono solo debe contener números");}		
		else if(contra.length() < 6) {
		    JOptionPane.showMessageDialog(null,"La contraseña debe tener al menos 6 caracteres");
		}
		else {
			
		Cliente sec=new Cliente(dni,contra,nom,ape,dni,tel,cor);
		c.Adicionar(sec);
		JOptionPane.showMessageDialog(null,"Su cuenta ha sido creada correctamente \nUsuario: "+dni);
		txtcontra.setVisible(true);
		txtusuario.setVisible(true);
		lblContra.setVisible(true);
		lblUsuario.setVisible(true);
		lblinicia.setVisible(true);
		btnRegis.setVisible(true);
		lbltextcuen.setVisible(true);
		btnIngresar.setVisible(true);

		lblcrea.setVisible(false);
		lblnombra.setVisible(false);
		txtnombre.setVisible(false);

		lblapellido.setVisible(false);
		txtapellido.setVisible(false);

		lbldni.setVisible(false);
		txtdni.setVisible(false);

		lblcorreo.setVisible(false);
		txtcorreo.setVisible(false);

		lbltele.setVisible(false);
		txttele.setVisible(false);

		btnRegis2.setVisible(false);
		lblcontra2.setVisible(false);
		txtcont2.setVisible(false);
		}
}
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		
		String usuario = txtusuario.getText();
	    String contr = txtcontra.getText();
	    
	    
	    

	    if (txtusuario.getText().isEmpty()||txtcontra.getText().isEmpty())
	    {
	    	JOptionPane.showMessageDialog(null,"Todos los campos deben estar llenos!");
	    }
	    else {
	    	

	        Cliente cli = c.Buscar(usuario);

	        if (cli != null && cli.getContraseña().equals(contr)) {
	        		Vcatalogo cat = new Vcatalogo();
	        		cat.setLocationRelativeTo(null);
	        		cat.setVisible(true);
	        		this.dispose();
	        		
	        		
	        		
	        		
	            Vbienvenida vc = new Vbienvenida(cli.getNombre());
	            vc.setLocationRelativeTo(this);
	            vc.setVisible(true);
	            
	            return;
	        }

	        Empleado emp = em.Buscar(usuario);

	        if (emp != null && emp.getContraseña().equals(contr)) {

	            VGestionProductos ve = new VGestionProductos();
	            ve.setVisible(true);
	            dispose();
	            return;
	        }
	        JOptionPane.showMessageDialog(null, "DNI o contraseña incorrectos!");
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
	void LimpiarTxt() {
		txtnombre.setText("");
		txtapellido.setText("");
		txtdni.setText("");
		txttele.setText("");
		txtcorreo.setText("");
		txtcont2.setText("");
	}
}
