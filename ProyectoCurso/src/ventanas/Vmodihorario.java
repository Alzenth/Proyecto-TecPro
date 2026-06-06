package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vmodihorario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtingreso;
	private JLabel lblNuevaHoraDe;
	private JTextField txtCierre;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vmodihorario frame = new Vmodihorario();
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
	public Vmodihorario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Nueva hora de ingreso:");
			lblNewLabel.setBounds(10, 11, 124, 14);
			contentPane.add(lblNewLabel);
		}
		{
			txtingreso = new JTextField();
			txtingreso.setBounds(136, 8, 117, 20);
			contentPane.add(txtingreso);
			txtingreso.setColumns(10);
		}
		{
			lblNuevaHoraDe = new JLabel("Nueva hora de cierre:");
			lblNuevaHoraDe.setBounds(10, 60, 124, 14);
			contentPane.add(lblNuevaHoraDe);
		}
		{
			txtCierre = new JTextField();
			txtCierre.setColumns(10);
			txtCierre.setBounds(136, 57, 117, 20);
			contentPane.add(txtCierre);
		}
		{
			btnNewButton = new JButton("Guardar");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(81, 94, 89, 23);
			contentPane.add(btnNewButton);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		V1.horaIngreso = txtingreso.getText();
		V1.horaSalida = txtCierre.getText();

		dispose();
	}
}
