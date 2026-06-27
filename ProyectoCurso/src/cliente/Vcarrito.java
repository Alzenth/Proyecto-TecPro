package cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vcarrito extends JFrame implements ActionListener {

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
					Vcarrito frame = new Vcarrito();
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
	public Vcarrito() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnNewButton = new JButton("Volver al Catálogo");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(557, 352, 128, 20);
			contentPane.add(btnNewButton);
		}
		
		JButton btnNewButton_1 = new JButton("Comprar");
		btnNewButton_1.setBounds(10, 351, 89, 23);
		contentPane.add(btnNewButton_1);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		
		Vcatalogo ventanaCatalogo = new Vcatalogo();
		ventanaCatalogo.setLocationRelativeTo(null);
		ventanaCatalogo.setVisible(true);

		this.dispose(); 
	}
}
