package cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ventanas.Vlogin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vcatalogo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vcatalogo frame = new Vcatalogo();
					frame.setLocationRelativeTo(null);
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
	public Vcatalogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnNewButton = new JButton("Ir a Carrito");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(392, 333, 84, 20);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Cerrar Sesión");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBounds(21, 333, 111, 20);
			contentPane.add(btnNewButton_1);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		
		Vcarrito ventanaCarrito = new Vcarrito();
		ventanaCarrito.setLocationRelativeTo(null); 
		ventanaCarrito.setVisible(true);

		this.dispose(); 
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		Vlogin ventanaLogin = new Vlogin();
	    ventanaLogin.setLocationRelativeTo(null); 
	    ventanaLogin.setVisible(true);
	    
	    
	    this.dispose();
	}
}
