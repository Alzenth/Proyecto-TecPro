package cliente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arraylist.ArrayProducto;
import constructores.Producto;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import ventanas.Vlogin;

public class Vcatalogo extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    
    
    private JPanel panel;
    private JComboBox<String> cmbBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Vcatalogo frame = new Vcatalogo();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Vcatalogo() {
        setForeground(new Color(227, 214, 196));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 880, 441);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(238, 230, 219));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        btnNewButton = new JButton("Ir a Carrito");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(255, 104, 83));
        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(718, 365, 138, 29);
        contentPane.add(btnNewButton);
        
        btnNewButton_1 = new JButton("Cerrar Sesión");
        btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(16, 95, 106));
        btnNewButton_1.addActionListener(this);
        btnNewButton_1.setBounds(707, 13, 138, 29);
        contentPane.add(btnNewButton_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 84, 835, 271);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane); 
        
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 15, 15));
        scrollPane.setViewportView(panel);
        
        
        cmbBox = new JComboBox<String>();
        cmbBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione una categoría", "Chocotejas", "Cuchareables"}));
        cmbBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        cmbBox.setBounds(240, 53, 154, 22);
        cmbBox.addActionListener(this); 
        contentPane.add(cmbBox);
        
        JLabel lblNewLabel_1 = new JLabel("CATÁLOGO");
        lblNewLabel_1.setForeground(new Color(16, 95, 106));
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 29));
        lblNewLabel_1.setBounds(21, 0, 161, 42);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Seleccione un tipo de producto:");
        lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(21, 52, 209, 22);
        contentPane.add(lblNewLabel_2);

        cargarCatalogo();
    }
    
    
    public void cargarCatalogo() {
        panel.removeAll();
        String cat = cmbBox.getSelectedItem().toString();
        
        
        ArrayProducto ap = new ArrayProducto();
        
        ArrayList<Producto> lista = ap.ListarPorCatalogo(cat);
        
        
        for (Producto p : lista) {
            panel.add(new TarjetaProducto(
                p.getNombre_prod(), 
                p.getDescripcion_prod(), 
                "S/ " + p.getPrecio_prod()
            ));
        }
        
        panel.revalidate();
        panel.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewButton_1) {
            do_btnNewButton_1_actionPerformed(e);
        } else if (e.getSource() == btnNewButton) {
            do_btnNewButton_actionPerformed(e);
        } else if (e.getSource() == cmbBox) {
            
            cargarCatalogo();
        }
    }
    
    protected void do_btnNewButton_actionPerformed(ActionEvent e) {
        Vcarrito ventanacarrito = new Vcarrito();
        ventanacarrito.setLocationRelativeTo(null); 
        ventanacarrito.setVisible(true);
        this.dispose(); 
    }
    
    protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
        Vlogin ventanaLogin = new Vlogin();
        ventanaLogin.setLocationRelativeTo(null); 
        ventanaLogin.setVisible(true);
        this.dispose();
    }
}