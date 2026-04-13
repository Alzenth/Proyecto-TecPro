package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNombre;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField txtApellido;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_2;
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
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Nombre: ");
			lblNewLabel.setBounds(10, 19, 81, 22);
			lblNewLabel.setFont(new Font("Dubai", Font.BOLD, 14));
			contentPane.add(lblNewLabel);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBackground(Color.YELLOW);
			txtNombre.setBounds(80, 19, 96, 18);
			contentPane.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			btnNewButton = new JButton("Adicionar");
			btnNewButton.addActionListener(this);
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBackground(Color.GREEN);
			btnNewButton.setBounds(10, 91, 112, 29);
			btnNewButton.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
			contentPane.add(btnNewButton);
		}
		{
			lblNewLabel_1 = new JLabel("DNI:");
			lblNewLabel_1.setBounds(200, 51, 44, 17);
			lblNewLabel_1.setFont(new Font("Dubai", Font.BOLD, 14));
			contentPane.add(lblNewLabel_1);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBackground(Color.YELLOW);
			txtApellido.setBounds(266, 17, 96, 18);
			txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPane.add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			btnNewButton_1 = new JButton("Eliminar");
			btnNewButton_1.setBackground(Color.GREEN);
			btnNewButton_1.setBounds(254, 91, 112, 28);
			btnNewButton_1.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
			btnNewButton_1.addActionListener(this);
			contentPane.add(btnNewButton_1);
		}
		{
			lblNewLabel_2 = new JLabel("Teléfono:");
			lblNewLabel_2.setBounds(10, 48, 81, 22);
			lblNewLabel_2.setFont(new Font("Dubai", Font.BOLD, 14));
			contentPane.add(lblNewLabel_2);
		}
		
		txtTelefono = new JTextField();
		txtTelefono.setBackground(Color.LIGHT_GRAY);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(80, 48, 96, 18);
		contentPane.add(txtTelefono);
		{
			lblNewLabel_3 = new JLabel("Apellido:");
			lblNewLabel_3.setFont(new Font("Dubai", Font.BOLD, 14));
			lblNewLabel_3.setBounds(200, 15, 81, 22);
			contentPane.add(lblNewLabel_3);
		}
		{
			btnNewButton_2 = new JButton("Reportar");
			btnNewButton_2.addActionListener(this);
			btnNewButton_2.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
			btnNewButton_2.setBackground(Color.GREEN);
			btnNewButton_2.setBounds(132, 91, 112, 28);
			contentPane.add(btnNewButton_2);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setBackground(Color.LIGHT_GRAY);
			txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtDNI.setColumns(10);
			txtDNI.setBounds(266, 51, 96, 18);
			contentPane.add(txtDNI);
		}
		{
			lblNewLabel_4 = new JLabel("Correo:");
			lblNewLabel_4.setFont(new Font("Dubai", Font.BOLD, 14));
			lblNewLabel_4.setBounds(387, 15, 81, 22);
			contentPane.add(lblNewLabel_4);
		}
		{
			txtCorreo = new JTextField();
			txtCorreo.setBackground(Color.YELLOW);
			txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(445, 18, 96, 18);
			contentPane.add(txtCorreo);
		}
		{
			txtS = new JTextArea();
			txtS.setBounds(20, 130, 547, 208);
			contentPane.add(txtS);
		}
		{
			btnNewButton_3 = new JButton("Buscar");
			btnNewButton_3.addActionListener(this);
			btnNewButton_3.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
			btnNewButton_3.setBackground(Color.GREEN);
			btnNewButton_3.setBounds(387, 91, 112, 28);
			contentPane.add(btnNewButton_3);
		}
		Listado();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_3) {
			do_btnNewButton_3_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
	}
	void Listado() { 
		Imprimir(" Nombre\t|   Apellido\t|   DNI\t|   Teléfono\t|   Correo");
		for (int i = 0; i < a.Tamaño(); i++) {
			Imprimir(a.Obtener(i).getNombre()+"\t| "+a.Obtener(i).getApellido()
			+"\t| "+a.Obtener(i).getDni()+"\t| "+a.Obtener(i).getNumero()+
			"\t| "+a.Obtener(i).getCorreo());
		}
	}
	void Imprimir (String s) {
		txtS.append(s + "\n");
	}
	
	Arreglo a = new Arreglo();
	private JButton btnNewButton_3;
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
        Cliente c = a.Buscar(txtDNI.getText());
        if(c==null) {
            Cliente es1=new Cliente(txtNombre.getText(),txtApellido.getText(), txtDNI.getText(), 
                    txtTelefono.getText(), txtCorreo.getText());
            a.Adicionar(es1);
            }
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		Cliente c = a.Eliminar(txtDNI.getText());
		if (c!=null) {
			txtS.setText("");
			txtS.append("Nombre\tApellido\tDni\tNumero\tCorreo\n");
			
			javax.swing.JOptionPane.showMessageDialog(null, "Cliente eliminado ");
			
			for (int i = 0; i < a.Tamaño(); i++) {
			    Cliente cte = a.Obtener(i);
			    txtS.append(cte.getNombre() + "\t" +cte.getApellido() + "\t" +cte.getDni() + "\t" +
			    cte.getNumero() + "\t" +cte.getCorreo() + "\n");
			}
		}
		else javax.swing.JOptionPane.showMessageDialog(null, "No se encontró el cliente a eliminar ");
	}
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e)  {
		txtS.setText("");

	    Cliente c = a.Buscar(txtDNI.getText());

	    if(c != null) {
	        txtS.append("Nombre\tApellido\tDni\tNumero\tCorreo\n");
	        txtS.append(c.getNombre()+"\t"+c.getApellido()+"\t"+c.getDni()+
	                    "\t"+c.getNumero()+"\t"+c.getCorreo());

	        javax.swing.JOptionPane.showMessageDialog(null, "Se encontró el cliente ");
	    } else {
	        txtS.setText("Cliente no encontrado ");
	    }
	}
			
		
	
		}
	

