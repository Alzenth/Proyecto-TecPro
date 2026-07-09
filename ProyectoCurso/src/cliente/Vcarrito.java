package cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arraylist.ArrayDetalle_Carrito;
import arraylist.ArrayProducto;
import clases.Intermediario;
import constructores.Detalle_Carrito;
import constructores.Producto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class Vcarrito extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable tbTable;
	private JLabel lblNewLabel;
	private JButton btnRemoverProducto;
	private JTextField txtIdProducto;

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
		
		JButton btnNewButton_1 = new JButton("Comprar");
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
					txtIdProducto = new JTextField();
					txtIdProducto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
					txtIdProducto.setColumns(10);
					txtIdProducto.setBounds(218, 12, 34, 20);
					contentPane.add(txtIdProducto);
				}
				tbTable.addMouseListener(this);
			}
		}
		
		txtIdProducto.setVisible(false);

	}

	public void actionPerformed(ActionEvent e) {
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
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		
	
	
	}
	protected void do_btnRemoverProducto_actionPerformed(ActionEvent e) {

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
		Iterator it = lista.iterator();
		
		
		modelo.addColumn("Código");
		modelo.addColumn("Producto");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio Unitario");	
		modelo.addColumn("Subtotal");
		int i=0;
		while (it.hasNext()) {
			Object obj = it.next();
			Detalle_Carrito dcar= (Detalle_Carrito)obj;
			modelo.setValueAt(dcar.getIdDetalleCarrito(), i, 0);
			modelo.setValueAt(dcar.getNombreProducto(), i, 1);
			modelo.setValueAt(dcar.getCantidad(), i, 2);
			modelo.setValueAt(dcar.getPrecioUnitario(), i, 3);
			modelo.setValueAt(dcar.getSubtotal(), i, 4);
			
			i++;
			
			
		}
		tbTable.setModel(modelo);
		
		
		tbTable.getColumnModel().getColumn(0).setPreferredWidth(45);   
		tbTable.getColumnModel().getColumn(1).setPreferredWidth(280);  
		tbTable.getColumnModel().getColumn(2).setPreferredWidth(85);   
		tbTable.getColumnModel().getColumn(3).setPreferredWidth(85);  
		tbTable.getColumnModel().getColumn(4).setPreferredWidth(85);   
		
	}
}
