package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VGestionPedidos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VGestionPedidos frame = new VGestionPedidos();
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
	public VGestionPedidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnNewButton = new JButton("Regresar");
			btnNewButton.addActionListener(this);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton.setBackground(Color.RED);
			btnNewButton.setBounds(280, 218, 146, 23);
			contentPane.add(btnNewButton);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		VOpcion opcion  = new VOpcion();
		opcion.setLocationRelativeTo(null); 
		opcion.setVisible(true);
		dispose();
	}
}
