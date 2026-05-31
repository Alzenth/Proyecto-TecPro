package gui;

import java.awt.BorderLayout;
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
import java.util.Random; // Para simular la generación aleatoria de números

public class DetalleProducto extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField txtCodigoUnico; 
	private JButton btnCatalogarProducto;

	public DetalleProducto(Producto p) {
		
		setBounds(100, 100, 450, 370); 
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
		
		
		JLabel lblCodigo = new JLabel("Cod. Pedido:");
		lblCodigo.setFont(new Font("Dubai", Font.PLAIN, 24));
		lblCodigo.setBounds(30, 185, 120, 25);
		contentPanel.add(lblCodigo);

		txtCodigoUnico = new JTextField();
		txtCodigoUnico.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCodigoUnico.setBounds(145, 185, 200, 25);
		txtCodigoUnico.setEditable(false);
		contentPanel.add(txtCodigoUnico);
		
		txtCodigoUnico.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorAdded(javax.swing.event.AncestorEvent event) {
				txtCodigoUnicoAncestorAdded();
			}
			public void ancestorRemoved(javax.swing.event.AncestorEvent event) {}
			public void ancestorMoved(javax.swing.event.AncestorEvent event) {}
		});

		
		btnCatalogarProducto = new JButton("Catalogar Pedido");
		btnCatalogarProducto.setFont(new Font("Dubai", Font.PLAIN, 14));
		btnCatalogarProducto.setBounds(145, 225, 200, 30);
		btnCatalogarProducto.addActionListener(this);
		contentPanel.add(btnCatalogarProducto);
		


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
				cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Dubai", Font.PLAIN, 20));
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	

	private void txtCodigoUnicoAncestorAdded() {
		Random rand = new Random();
		int numeroAleatorio = rand.nextInt(900) + 100; 
		txtCodigoUnico.setText(String.valueOf(numeroAleatorio));
	}

	
	private void btnCatalogarProductoActionPerformed() {
		String codigoActual = txtCodigoUnico.getText();
		
		if (!codigoActual.isEmpty() && !codigoActual.contains("POSTRE-")) {
			String codigoAlfanumerico = "POSTRE-" + codigoActual;
			txtCodigoUnico.setText(codigoAlfanumerico);
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnCatalogarProducto) {
			btnCatalogarProductoActionPerformed();
		}
		
		if (e.getSource() == okButton || e.getSource() == cancelButton) {
			dispose();
		}
	}
}