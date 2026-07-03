package cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arraylist.ArrayProducto;
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
		try {
			ArrayProducto eli = new ArrayProducto();
			eli.Eliminar(txtIdProducto.getText());
			Listar("");
			}catch (Exception ex) {
				MensajeEmergente("Error al eliminar producto!");
			}
	}
	void MensajeEmergente(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	public void Listar(String cod) {
		DefaultTableModel modelo = new DefaultTableModel();
		ArrayProducto pro = new ArrayProducto();
		ArrayList<Producto> lista = new ArrayList<Producto>();
		if (cod.length() == 0) 
			lista = pro.Listar_Productos_En_Tabla();
		else 
			lista= pro.Consultar_Producto(cod);
		
		modelo.setRowCount(lista.size());
		Iterator it = lista.iterator();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Categoría");
		modelo.addColumn("Descripción");	
		modelo.addColumn("Stock");
		modelo.addColumn("Precio");
		modelo.addColumn("Fecha de Producción");
		modelo.addColumn("Fecha de Expiración");
		int i=0;
		while (it.hasNext()) {
			Object obj = it.next();
			Producto prod= (Producto)obj;
			modelo.setValueAt(prod.getId_prod(), i, 0);
			modelo.setValueAt(prod.getNombre_prod(), i, 1);
			modelo.setValueAt(prod.getCategoria_prod(), i, 2);
			modelo.setValueAt(prod.getDescripcion_prod(), i, 3);
			modelo.setValueAt(prod.getStock_prod(), i, 4);
			modelo.setValueAt(prod.getPrecio_prod(), i, 5);
			modelo.setValueAt(prod.getFechaP_prod(), i, 6);
			modelo.setValueAt(prod.getFechaV_prod(), i, 7);
			
			i++;
			
			
		}
		tbTable.setModel(modelo);
		
		
		tbTable.getColumnModel().getColumn(0).setPreferredWidth(45);   
		tbTable.getColumnModel().getColumn(1).setPreferredWidth(180);  
		tbTable.getColumnModel().getColumn(2).setPreferredWidth(85);   
		tbTable.getColumnModel().getColumn(3).setPreferredWidth(470);  
		tbTable.getColumnModel().getColumn(4).setPreferredWidth(40);   
		tbTable.getColumnModel().getColumn(5).setPreferredWidth(40);   
		tbTable.getColumnModel().getColumn(6).setPreferredWidth(90);   
		tbTable.getColumnModel().getColumn(7).setPreferredWidth(90); 
		
		
	}
}
