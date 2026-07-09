package cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import arraylist.ArrayProducto;
import clases.Intermediario;
import constructores.Producto;
import ventanas.Vlogin;

public class Vcatalogo extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnIr_a_Carrito;
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
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        contentPane.setLayout(new BorderLayout(10, 10)); 
        setContentPane(contentPane);
        
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setOpaque(false);

        
        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panelFiltros.setOpaque(false);
        
        JLabel lblNewLabel_1 = new JLabel("CATÁLOGO");
        lblNewLabel_1.setForeground(new Color(16, 95, 106));
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 29));
        
        JLabel lblNewLabel_2 = new JLabel("Seleccione un tipo de producto:");
        lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        cmbBox = new JComboBox<String>();
        cmbBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione una categoría", "Chocotejas", "Cuchareables"}));
        cmbBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        cmbBox.addActionListener(this); 
        
        panelFiltros.add(lblNewLabel_1);
        panelFiltros.add(lblNewLabel_2);
        panelFiltros.add(cmbBox);

        
        JPanel panelSalir = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panelSalir.setOpaque(false);
        
        btnNewButton_1 = new JButton("Cerrar Sesión");
        btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(16, 95, 106));
        btnNewButton_1.addActionListener(this);
        panelSalir.add(btnNewButton_1);

        
        panelSuperior.add(panelFiltros, BorderLayout.WEST);
        panelSuperior.add(panelSalir, BorderLayout.EAST);
        contentPane.add(panelSuperior, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 15, 15)); 
        panel.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelInferior.setOpaque(false);
        
        btnIr_a_Carrito = new JButton("Ir a Carrito");
        btnIr_a_Carrito.setForeground(new Color(255, 255, 255));
        btnIr_a_Carrito.setBackground(new Color(255, 104, 83));
        btnIr_a_Carrito.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnIr_a_Carrito.addActionListener(this);
        
        panelInferior.add(btnIr_a_Carrito);
        contentPane.add(panelInferior, BorderLayout.SOUTH);

        cargarCatalogo();
    }
    
    public void cargarCatalogo() {
        panel.removeAll();
        String cat = cmbBox.getSelectedItem().toString();
        
        ArrayProducto ap = new ArrayProducto();
        ArrayList<Producto> lista = ap.ListarPorCatalogo(cat);
        
        for (Producto p : lista) {
            panel.add(new TarjetaProducto(
                    p.getId_prod(),
                    p.getNombre_prod(),
                    p.getDescripcion_prod(),
                    "S/ " + p.getPrecio_prod(),
                    fecha_Exp(p.getFechaV_prod()) 
            ));
        }
        
        panel.revalidate();
        panel.repaint();
    }

    public String fecha_Exp(java.util.Date fecha) {
        if (fecha == null) {
            return "Sin fecha"; 
        }
        java.text.SimpleDateFormat formatoFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fecha);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewButton_1) {
            do_btnNewButton_1_actionPerformed(e);
        } else if (e.getSource() == btnIr_a_Carrito) {
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