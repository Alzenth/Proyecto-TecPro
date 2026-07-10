package cliente;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import arraylist.ArrayDetalle_Carrito;
import clases.ArrayDetalle_Venta;
import clases.Intermediario;
import conexion.ConexionBD;
import constructores.Detalle_Carrito;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Vcarrito extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable tbTable;
	private JLabel lblNewLabel;
	private JButton btnRemoverProducto;
	private JButton btnNewButton_1;
	private JSpinner spCantidadRemover;

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

	public Vcarrito() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		{
			btnNewButton = new JButton("Volver al Catálogo");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(557, 287, 128, 20);
			contentPane.add(btnNewButton);
		}
		
		btnNewButton_1 = new JButton("Comprar");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(10, 286, 89, 23);
		contentPane.add(btnNewButton_1);
		
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 43, 675, 225);
			contentPane.add(scrollPane);
			{
				tbTable = new JTable();
				tbTable.setFont(new Font("Segoe UI", Font.PLAIN, 10));
				scrollPane.setViewportView(tbTable);
				{
					lblNewLabel = new JLabel("Productos Seleccionados:");
					lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
					lblNewLabel.setBounds(10, 10, 198, 23);
					contentPane.add(lblNewLabel);
				}
				{
					btnRemoverProducto = new JButton("Remover producto");
					btnRemoverProducto.addActionListener(this);
					btnRemoverProducto.setForeground(Color.BLACK);
					btnRemoverProducto.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
					btnRemoverProducto.setBackground(Color.LIGHT_GRAY);
					btnRemoverProducto.setBounds(542, 13, 145, 20);
					contentPane.add(btnRemoverProducto);
				}
				{
					spCantidadRemover = new JSpinner();
					spCantidadRemover.setBounds(493, 5, 43, 28);
					
					spCantidadRemover.setModel(new SpinnerNumberModel(1, 1, 999, 1));
					JTextField txtSpinner = ((JSpinner.DefaultEditor) spCantidadRemover.getEditor()).getTextField();
					txtSpinner.setEditable(false);
					txtSpinner.setFocusable(false); 
					
					contentPane.add(spCantidadRemover);
				}
				tbTable.addMouseListener(this);
			}
		}
		Listar(Intermediario.idCarritoActual);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnRemoverProducto) {
			do_btnRemoverProducto_actionPerformed(e);
		}
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

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbTable) {
			do_table_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	protected void do_table_mouseClicked(MouseEvent e) {
	}
	ConexionBD db = new ConexionBD();
	private String ObtenerIdPorNombre(String nombre) {
		String id = "";
		try {
			
			Connection cnx = db.conectar();
			PreparedStatement pst = cnx.prepareStatement("SELECT ID_PRODUCTO FROM PRODUCTO WHERE NOMBRE = ?");
			pst.setString(1, nombre);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				id = rs.getString("ID_PRODUCTO");
			}
		} catch (Exception e) {
			System.out.println("Error al obtener ID del producto: " + e);
		}
		return id;
	}

	protected void do_btnRemoverProducto_actionPerformed(ActionEvent e) {
	    int cantidadARemover = (Integer) spCantidadRemover.getValue();

	    if (cantidadARemover < 1) {
	        JOptionPane.showMessageDialog(this, 
	            "La cantidad a remover debe ser igual o mayor a 1.", 
	            "Cantidad inválida", 
	            JOptionPane.WARNING_MESSAGE);
	        return; 
	    }

	    int filaSeleccionada = tbTable.getSelectedRow(); 
	    
	    if (filaSeleccionada == -1) {
	        JOptionPane.showMessageDialog(this, 
	            "Por favor, seleccione un producto de la tabla para remover.", 
	            "Selección requerida", 
	            JOptionPane.WARNING_MESSAGE);
	        return; 
	    }

	    String nombreProducto = tbTable.getValueAt(filaSeleccionada, 0).toString().trim();
	    
	    String idProductoReal = ObtenerIdPorNombre(nombreProducto);
	    
	    if (idProductoReal.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Error: No se pudo localizar el ID del producto en la base de datos.", "Error Interno", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    ArrayDetalle_Carrito adc = new ArrayDetalle_Carrito();
	    adc.Remover_Cantidad_Carrito(Intermediario.idCarritoActual, idProductoReal, cantidadARemover);
	    
	    JOptionPane.showMessageDialog(this, 
	        "Se removieron " + cantidadARemover + " unidades del producto.", 
	        "Actualización exitosa", 
	        JOptionPane.INFORMATION_MESSAGE);
	        
	    Listar(Intermediario.idCarritoActual);
	}

	void MensajeEmergente(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	public void Listar(String cod) {
		DefaultTableModel modelo = new DefaultTableModel();
		ArrayDetalle_Carrito adc = new ArrayDetalle_Carrito();
		ArrayList<Detalle_Carrito> lista = new ArrayList<Detalle_Carrito>();
		lista = adc.Mostrar_En_Carrito();
		
		modelo.setRowCount(lista.size());
		Iterator<Detalle_Carrito> it = lista.iterator();
		
		modelo.addColumn("Producto");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio Unitario");	
		modelo.addColumn("Subtotal");
		
		int i=0;
		while (it.hasNext()) {
			Detalle_Carrito dcar = it.next();
			
			modelo.setValueAt(dcar.getNombreProducto(), i, 0);
			modelo.setValueAt(dcar.getCantidad(), i, 1);
			modelo.setValueAt(dcar.getPrecioUnitario(), i, 2);
			modelo.setValueAt(dcar.getSubtotal(), i, 3);
			
			i++;
		}
		tbTable.setModel(modelo);
		
		tbTable.getColumnModel().getColumn(0).setPreferredWidth(85); 
		tbTable.getColumnModel().getColumn(1).setPreferredWidth(280);  
		tbTable.getColumnModel().getColumn(2).setPreferredWidth(85);   
		tbTable.getColumnModel().getColumn(3).setPreferredWidth(85);
		
		tbTable.revalidate();
		tbTable.repaint();
	}

	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		ArrayDetalle_Venta adv = new ArrayDetalle_Venta();
		
		String miTicket = adv.Procesar_Venta_Final();
		
		if (miTicket != null) {
		    JOptionPane.showMessageDialog(this, "¡Compra exitosa! Su ticket es: " + miTicket);
		    this.dispose();
		} else {
		    JOptionPane.showMessageDialog(this, "Hubo un error al procesar la compra.");
		}
	}
}