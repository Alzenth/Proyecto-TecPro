package Clases;


import java.awt.BorderLayout;
import Constructores.Producto;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class DetalleProducto extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;

	
	public DetalleProducto(Producto p) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Dubai", Font.PLAIN, 27));
		lblId.setBounds(30, 20, 80, 25);
		contentPanel.add(lblId);

		JTextField txtId = new JTextField(p.getId_prod());
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(145, 20, 200, 25);
		txtId.setEditable(false); 
		contentPanel.add(txtId);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Dubai", Font.PLAIN, 27));
		lblNombre.setBounds(30, 60, 105, 25);
		contentPanel.add(lblNombre);

		JTextField txtNombre = new JTextField(p.getNombre_prod());
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(145, 56, 200, 25);
		txtNombre.setEditable(false);
		contentPanel.add(txtNombre);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Dubai", Font.PLAIN, 27));
		lblStock.setBounds(30, 100, 80, 25);
		contentPanel.add(lblStock);

		JTextField txtStock = new JTextField(String.valueOf(p.getStock_prod()));
		txtStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtStock.setBounds(145, 92, 200, 25);
		txtStock.setEditable(false);
		contentPanel.add(txtStock);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Dubai", Font.PLAIN, 27));
		lblPrecio.setBounds(30, 140, 80, 25);
		contentPanel.add(lblPrecio);

		JTextField txtPrecio = new JTextField(String.valueOf(p.getPrecio_prod()));
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrecio.setBounds(145, 140, 200, 25);
		txtPrecio.setEditable(false);
		contentPanel.add(txtPrecio);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setFont(new Font("Dubai", Font.PLAIN, 20));
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton || e.getSource() == cancelButton) {
			dispose();
		}
	}
}
