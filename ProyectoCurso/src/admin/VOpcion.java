package admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ventanas.Vlogin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VOpcion extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnNewButton;
	private JButton btnGestionProductos;
	private JButton btnGestionPedidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VOpcion dialog = new VOpcion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VOpcion() {
		setTitle("Seleccione lo que quiere hacer:");
		setBounds(100, 100, 317, 290);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnGestionProductos = new JButton("Gestión de Productos");
			btnGestionProductos.addActionListener(this);
			btnGestionProductos.setBounds(58, 38, 182, 33);
			contentPanel.add(btnGestionProductos);
		}
		{
			btnNewButton = new JButton("Cerrar Sesión");
			btnNewButton.addActionListener(this);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton.setBackground(Color.RED);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBounds(81, 189, 146, 23);
			contentPanel.add(btnNewButton);
		}
		{
			btnGestionPedidos = new JButton("Gestión de Pedidos");
			btnGestionPedidos.addActionListener(this);
			btnGestionPedidos.setBounds(58, 95, 182, 41);
			contentPanel.add(btnGestionPedidos);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGestionPedidos) {
			do_btnGestionPedidos_actionPerformed(e);
		}
		if (e.getSource() == btnGestionProductos) {
			do_btnGestionProductos_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_2_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		Vlogin ventanaLogin = new Vlogin();
	    ventanaLogin.setLocationRelativeTo(null); 
	    ventanaLogin.setVisible(true);
	    
	    
	    this.dispose();
		
	}
	protected void do_btnGestionProductos_actionPerformed(ActionEvent e) {
		VGestionProductos gPro = new VGestionProductos();
		gPro.setLocationRelativeTo(null); 
		gPro.setVisible(true);
	    
	    
	    this.dispose();
	}
	protected void do_btnGestionPedidos_actionPerformed(ActionEvent e) {
		VGestionPedidos gPed = new VGestionPedidos();
		gPed.setLocationRelativeTo(null); 
		gPed.setVisible(true);
	    this.dispose();
	}
}
