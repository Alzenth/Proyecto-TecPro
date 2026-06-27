package cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class Vistaproducto extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JButton okButton_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Vistaproducto dialog = new Vistaproducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Vistaproducto() {
		setBounds(100, 100, 626, 525);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("(Imagen del postre)");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(28, 56, 231, 158);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(408, 56, 53, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Precio:");
		lblNewLabel_1_1.setBounds(408, 88, 53, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Categoria:");
		lblNewLabel_1_1_1.setBounds(408, 128, 53, 14);
		contentPanel.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(486, 56, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(486, 88, 86, 20);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(486, 125, 86, 20);
		contentPanel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Descripcion:");
		lblNewLabel_1_1_1_1.setBounds(10, 264, 86, 14);
		contentPanel.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(10, 289, 440, 86);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Cantidad:");
		lblNewLabel_1_1_1_2.setBounds(10, 401, 86, 14);
		contentPanel.add(lblNewLabel_1_1_1_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(106, 398, 30, 20);
		contentPanel.add(spinner);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Stock");
		lblNewLabel_1_1_1_3.setBounds(408, 168, 53, 14);
		contentPanel.add(lblNewLabel_1_1_1_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(486, 165, 86, 20);
		contentPanel.add(textField_4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				{
					okButton_1 = new JButton("AGREGAR AL CARRITO");
					okButton_1.setActionCommand("OK");
					buttonPane.add(okButton_1);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			do_cancelButton_actionPerformed(e);
		}
		if (e.getSource() == okButton) {
			do_okButton_actionPerformed(e);
		}
	}
	protected void do_okButton_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		dispose();
	}
}
