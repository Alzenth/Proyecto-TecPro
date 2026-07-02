package cliente;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Dimension;

public class TarjetaProducto extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel lblTitulo;
    private JLabel lblDescripcion;
    private JLabel lblPrecio;
    private JButton btnNewButton;
    private JLabel lblImagen;

    /**
     * Create the panel.
     */
    public TarjetaProducto(String titulo, String descripcion, String precio) {
        
        setBorder(new LineBorder(new Color(16, 95, 106), 3, true));
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        
        this.setPreferredSize(new Dimension(380, 130));

        
        lblTitulo = new JLabel(titulo);
        lblTitulo.setForeground(new Color(44, 44, 44));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setBounds(142, 10, 228, 22);
        add(lblTitulo);

       
        lblDescripcion = new JLabel("<html><body style='width: 210px;'>" + descripcion + "</body></html>");
        lblDescripcion.setForeground(new Color(44, 44, 44));
        lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblDescripcion.setBounds(142, 32, 228, 42);
        add(lblDescripcion);

        
        lblPrecio = new JLabel(precio);
        lblPrecio.setForeground(new Color(44, 44, 44));
        lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblPrecio.setBounds(142, 84, 77, 22);
        add(lblPrecio);

        
        btnNewButton = new JButton("Añadir");
        btnNewButton.setForeground(new Color(16, 95, 106));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton.setBounds(280, 84, 85, 25); 
        add(btnNewButton);

        
        lblImagen = new JLabel("");
        lblImagen.setOpaque(true); 
        lblImagen.setBackground(new Color(188, 201, 205));
        lblImagen.setBounds(21, 10, 100, 96);
        add(lblImagen);
        
        
    }
}