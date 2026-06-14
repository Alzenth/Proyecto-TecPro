package cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Intermediario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vbienvenida extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblTexto;

	/**
	 * Launch the application.
	 */
	Intermediario i = new Intermediario();
	private JButton okButton;
	
	public static void main(String[] args) {
		try {
			Vbienvenida dialog = new Vbienvenida(Intermediario.cliente_actual.getNombre());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Vbienvenida(String nombreUsuario) {
		setBounds(100, 100, 550, 253);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("¡BIENVENIDO(A) A LA TIENDA DE POSTRES!");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(75, 21, 412, 76);
			contentPanel.add(lblNewLabel);
		}
		{
			lblTexto = new JLabel("");
			lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTexto.setBounds(118, 87, 325, 76);
			contentPanel.add(lblTexto);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Aceptar");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
			}
			
			lblTexto.setText("<html><div style='text-align: center;'>Hola <b>" + nombreUsuario + 
					"</b>, tu cuenta ha sido validada e iniciaste sesión correctamente.</div></html>");
			
		}
		
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			do_okButton_actionPerformed(e);
		}
	}
	protected void do_okButton_actionPerformed(ActionEvent e) {
		dispose();
	
	}
}
