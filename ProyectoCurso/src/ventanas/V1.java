

package ventanas;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ArregloCliente;
import constructores.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNombre;
	private JButton btnAdicionar;
	private JLabel lblNewLabel_1;
	private JTextField txtApellido;
	private JButton btnEliminar;
	private JLabel lblNewLabel_2;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_3;
	private JButton btnReportar;
	private JTextField txtDNI;
	private JLabel lblNewLabel_4;
	private JTextField txtCorreo;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
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
	public V1() {
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 499);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(243, 244, 246));
		contentPane.setBackground(new Color(243, 244, 246));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Nombre: ");
			lblNewLabel.setForeground(new Color(31, 41, 55));
			lblNewLabel.setBounds(10, 19, 81, 22);
			lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			contentPane.add(lblNewLabel);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtNombre.setBackground(new Color(255, 255, 255));
			txtNombre.setBounds(80, 15, 110, 22);
			contentPane.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.addActionListener(this);
			btnAdicionar.setForeground(new Color(255, 255, 255));
			btnAdicionar.setBackground(new Color(37, 99, 235));
			btnAdicionar.setBounds(10, 109, 112, 29);
			btnAdicionar.setFont(new Font("Segoe UI", Font.BOLD, 16));
			contentPane.add(btnAdicionar);
		}
		{
			lblNewLabel_1 = new JLabel("DNI:");
			lblNewLabel_1.setForeground(new Color(31, 41, 55));
			lblNewLabel_1.setBounds(10, 66, 44, 17);
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
			contentPane.add(lblNewLabel_1);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBackground(new Color(255, 255, 255));
			txtApellido.setBounds(296, 15, 110, 22);
			txtApellido.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			contentPane.add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setForeground(new Color(255, 255, 255));
			btnEliminar.setBackground(new Color(220, 38, 38));
			btnEliminar.setBounds(551, 109, 112, 28);
			btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnEliminar.addActionListener(this);
			contentPane.add(btnEliminar);
		}
		{
			lblNewLabel_2 = new JLabel("Teléfono:");
			lblNewLabel_2.setForeground(new Color(31, 41, 55));
			lblNewLabel_2.setBounds(219, 63, 81, 22);
			lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
			contentPane.add(lblNewLabel_2);
		}
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTelefono.setBackground(new Color(255, 255, 255));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(296, 61, 110, 22);
		contentPane.add(txtTelefono);
		{
			lblNewLabel_3 = new JLabel("Apellido:");
			lblNewLabel_3.setForeground(new Color(31, 41, 55));
			lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblNewLabel_3.setBounds(219, 19, 81, 22);
			contentPane.add(lblNewLabel_3);
		}
		{
			btnReportar = new JButton("Reportar");
			btnReportar.addActionListener(this);
			btnReportar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
			btnReportar.setBackground(new Color(229, 231, 235));
			btnReportar.setBounds(198, 109, 112, 28);
			contentPane.add(btnReportar);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setBackground(new Color(255, 255, 255));
			txtDNI.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtDNI.setColumns(10);
			txtDNI.setBounds(80, 61, 110, 22);
			contentPane.add(txtDNI);
		}
		{
			lblNewLabel_4 = new JLabel("Correo:");
			lblNewLabel_4.setForeground(new Color(31, 41, 55));
			lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblNewLabel_4.setBounds(425, 19, 81, 22);
			contentPane.add(lblNewLabel_4);
		}
		{
			txtCorreo = new JTextField();
			txtCorreo.setBackground(new Color(255, 255, 255));
			txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(490, 16, 347, 23);
			contentPane.add(txtCorreo);
		}
		{
			txtS = new JTextArea();
			txtS.setEditable(false);
			txtS.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			txtS.setBounds(20, 148, 989, 304);
			contentPane.add(txtS);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
			btnBuscar.setBackground(new Color(229, 231, 235));
			btnBuscar.setBounds(383, 109, 112, 28);
			contentPane.add(btnBuscar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.setForeground(new Color(255, 255, 255));
			btnModificar.addActionListener(this);
			btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnModificar.setBackground(new Color(37, 99, 235));
			btnModificar.setBounds(725, 109, 112, 28);
			contentPane.add(btnModificar);
		}
		{
			btnModificarHorario = new JButton("Modificar Horario");
			btnModificarHorario.addActionListener(this);
			btnModificarHorario.setForeground(Color.WHITE);
			btnModificarHorario.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnModificarHorario.setBackground(new Color(37, 99, 235));
			btnModificarHorario.setBounds(845, 109, 165, 28);
			contentPane.add(btnModificarHorario);
		}
		Encabezado();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificarHorario) {
			do_btnModificarHorario_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnNewButton_4_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnNewButton_3_actionPerformed(e);
		}
		if (e.getSource() == btnReportar) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnAdicionar) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnNewButton_1_actionPerformed(e);
		}
	}
	void Encabezado() {
		txtS.append("     Nombre\t|   Apellido\t|   DNI\t   |   Teléfono    |\t     Correo\n");
	}
	 
	
	ArregloCliente a = new ArregloCliente();
	private JButton btnBuscar;
	private JButton btnModificar;
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		/*
		if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() ||
	            txtDNI.getText().isEmpty() || txtTelefono.getText().isEmpty() ||
	            txtCorreo.getText().isEmpty()) {

	            JOptionPane.showMessageDialog(null, "Complete todos los campos");
	            limpiartxt();
	            return;
	        }
	    
	    try {
	    
	        Cliente c = a.Buscar(txtDNI.getText());
	        if(c == null) {
	            Cliente es1 = new Cliente(txtDNI.getText(),txtNombre.getText(), txtNombre.getText(),txtApellido.getText(), txtDNI.getText(), 
	                                txtTelefono.getText(), txtCorreo.getText());
	            
	            a.Adicionar(es1);
	          
	            String nombreCompleto = txtNombre.getText().trim();
	            String primerNombre = nombreCompleto.split(" ")[0]; 
	            
	            // 
	            txtS.setText(""); 
	            txtS.append("=========================================================================\n");
	            txtS.append("                  ¡BIENVENIDO(A) A LA TIENDA DE POSTRES!                 \n");
	            txtS.append("=========================================================================\n\n");
	            txtS.append("  Holi " + primerNombre + ", tu cuenta ha sido validada e iniciaste sesión correctamente.\n\n");
	            txtS.append("=========================================================================\n");
	            
	            JOptionPane.showMessageDialog(
	            	    null,
	            	    "Horario de Atención\n\n" +
	            	    "Hora de Ingreso: " + horaIngreso +
	            	    "\nHora de cierre: " + horaSalida);
	            
	            
	            
	            int respuesta = JOptionPane.showConfirmDialog(null, 
	                "¿Deseas ir al catálogo de postres ahora mismo, " + primerNombre + "?", 
	                "Acceso Rápido a Góndola", 
	                JOptionPane.YES_NO_OPTION, 
	                JOptionPane.INFORMATION_MESSAGE);
	            
	            if (respuesta == JOptionPane.YES_OPTION) {
	                JOptionPane.showMessageDialog(null, "Redirigiendo a la Góndola de Postres... ¡Disfruta tu elección!");
	            }
	            
	        } else {
	            JOptionPane.showMessageDialog(null, "EL CLIENTE YA ESTA REGISTRADO");
	        }
	        
	        limpiartxt();
	    
	    } catch (Exception ex) {
	        javax.swing.JOptionPane.showMessageDialog(null, "Ocurrió un error en el registro", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    */
	}
	
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		
		try {
			txtS.setText(""); // limpiar el área
			Encabezado();

			// Recorrer todos los clientes
			for (int i = 0; i < a.Tamaño(); i++) {
				Cliente c = a.Obtener(i);
		
				imprimir(c);
		}
		} catch (Exception ex) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		

	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) { //BOTON ELIMINAR
		/*
		try {
		Cliente c = a.Eliminar(txtDNI.getText());
		if (c!=null) {
			txtS.setText("");
			Encabezado(); 
			for (int i = 0; i < a.Tamaño(); i++) {
			    Cliente cte = a.Obtener(i);
			    txtS.append(cte.getNombre() + "\t" +cte.getApellido() + "\t" +cte.getDni() + "\t" +
			    cte.getNumero() + "\t" +cte.getCorreo() + "\n");
			}
			javax.swing.JOptionPane.showMessageDialog(null, "Cliente eliminado ");
		}
		else javax.swing.JOptionPane.showMessageDialog(null, "No se encontró el cliente a eliminar ");
		}catch (Exception ex) {
			javax.swing.JOptionPane.showMessageDialog(null, "Cliente eliminado", "Error",JOptionPane.ERROR_MESSAGE);
		}
		*/
		
	}
	
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e)  {
		/*
		txtS.setText("");
		Encabezado();

	    Cliente c = a.Buscar(txtDNI.getText());

	    if(c != null) {
	        
	        txtS.append(c.getNombre()+"\t"+c.getApellido()+"\t"+c.getDni()+
	                    "\t"+c.getNumero()+"\t"+c.getCorreo());

	        javax.swing.JOptionPane.showMessageDialog(null, "Se encontró el cliente ");
	    } else {
	    	javax.swing.JOptionPane.showMessageDialog(null, "Cliente no encontrado ");
	    	
	    }
	    */
	}
	protected void do_btnNewButton_4_actionPerformed(ActionEvent e) {
		/*
		Cliente c = a.Buscar(txtDNI.getText());
		if (c != null) {
			c.setNombre(txtNombre.getText());
			c.setApellido(txtApellido.getText());
			c.setCorreo(txtCorreo.getText());;
			c.setNumero(txtTelefono.getText());
			}
		else javax.swing.JOptionPane.showMessageDialog(null, "No se encontró el cliente a modificar ");
		*/
		}
	//Sobrecarga de métodos
	void imprimir(String s) {
	    txtS.append(s + "\n");
	}
	void imprimir(Cliente cte) {
		/*
		try {
		 txtS.append(cte.getNombre() + "\t" +cte.getApellido() + "\t" +cte.getDni() + "\t" +
				    cte.getNumero() + "\t" +cte.getCorreo() + "\n");
		}catch (Exception ex) {
			javax.swing.JOptionPane.showMessageDialog(null, "Cliente eliminado", "Error",JOptionPane.ERROR_MESSAGE);
		}
		*/
	}
	void limpiartxt() 
	{
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
		txtCorreo.setText("");
		txtTelefono.setText("");
	}
	public static String horaIngreso = "08:00";
	public static String horaSalida = "18:00";
	private JButton btnModificarHorario;
	
	protected void do_btnModificarHorario_actionPerformed(ActionEvent e) {
		Vmodihorario ventana = new Vmodihorario();
		ventana.setVisible(true);
		
	}
	
}
	


