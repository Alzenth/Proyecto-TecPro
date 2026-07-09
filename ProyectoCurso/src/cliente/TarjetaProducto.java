package cliente;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import arraylist.ArrayDetalle_Carrito;
import clases.Intermediario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.sql.Date;

import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;

public class TarjetaProducto extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel lblTitulo;
    private JLabel lblDescripcion;
    private JLabel lblPrecio;
    private JButton btnAñadir_a_Carrito;
    private JLabel lblImagen;
    private JLabel lblId;
    private JLabel lblFecha_exp;
    private JLabel lblNewLabel;

    public TarjetaProducto(String id, String titulo, String descripcion, String precio, String fechaVencimiento) {
        
        
        if (id != null) {
            id = id.trim();
        }

        setBorder(new LineBorder(new Color(16, 95, 106), 3, true));
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        
        this.setPreferredSize(new Dimension(392, 155));

        lblTitulo = new JLabel("<html><body style='width: 180px;'>" + titulo + "</body></html>");
        lblTitulo.setForeground(new Color(44, 44, 44));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(131, 10, 239, 36);
        add(lblTitulo);

        lblDescripcion = new JLabel("<html><body style='width: 210px;'>" + descripcion + "</body></html>");
        lblDescripcion.setForeground(new Color(44, 44, 44));
        lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDescripcion.setBounds(131, 44, 239, 73);
        add(lblDescripcion);

        lblPrecio = new JLabel(precio);
        lblPrecio.setForeground(new Color(44, 44, 44));
        lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblPrecio.setBounds(178, 121, 55, 22);
        add(lblPrecio);

        btnAñadir_a_Carrito = new JButton("Añadir");
        btnAñadir_a_Carrito.addActionListener(this);
        btnAñadir_a_Carrito.setForeground(new Color(16, 95, 106));
        btnAñadir_a_Carrito.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnAñadir_a_Carrito.setBounds(284, 123, 86, 22); 
        add(btnAñadir_a_Carrito);

        lblImagen = new JLabel("");
        lblImagen.setIcon(null);
        lblImagen.setOpaque(true); 
        lblImagen.setBackground(new Color(188, 201, 205));
        lblImagen.setBounds(21, 10, 100, 100);
        lblImagen.setHorizontalAlignment(JLabel.CENTER); 
        lblImagen.setVerticalAlignment(JLabel.CENTER);   
        add(lblImagen);
        {
        	lblId = new JLabel(""+id);
        	lblId.setBounds(47, 111, 44, 12);
        	add(lblId);
        }
        {
        	lblFecha_exp = new JLabel(fechaVencimiento);
        	lblFecha_exp.setBounds(57, 131, 70, 12);
        	add(lblFecha_exp);
        }
        
        lblNewLabel = new JLabel("Vence:");
        lblNewLabel.setBounds(10, 131, 44, 12);
        add(lblNewLabel);
        
        File carpeta = new File("imagenes");

        
        String[] extensiones = {
                ".png", ".jpg", ".jpeg",
                ".PNG", ".JPG", ".JPEG"
        };

        for(String ext: extensiones){
            File imagen = new File(carpeta, id + ext);
            if(imagen.exists()){
                ImageIcon icon = new ImageIcon(imagen.getAbsolutePath());
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(img));
                break;
            }
        }
        
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                CentrarContenido();
                }
            });
        
    }
    private void CentrarContenido() {
        int ancho = getWidth();

        int inicioX = (ancho - 420) / 2;

        lblImagen.setBounds(inicioX + 20, 10, 100, 100);
        lblTitulo.setBounds(inicioX + 131, 10, 239, 36);
        lblDescripcion.setBounds(inicioX + 131, 44, 300, 73);
        lblPrecio.setBounds(inicioX + 178, 121, 55, 22);
        btnAñadir_a_Carrito.setBounds(inicioX + 284, 123, 86, 22);
        lblId.setBounds(inicioX + 47, 111, 44, 12);
        lblNewLabel.setBounds(inicioX + 10, 131, 44, 12);
        lblFecha_exp.setBounds(inicioX + 57, 131, 70, 12);
    }
    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir_a_Carrito) {
			do_btnAñadir_a_Carrito_actionPerformed(e);
		}
	}
	//Añadir:
	protected void do_btnAñadir_a_Carrito_actionPerformed(ActionEvent e) {
		ArrayDetalle_Carrito adc = new ArrayDetalle_Carrito();
		adc.Agregar_Detalle_a_Carrito(Intermediario.idCarritoActual, lblId.getText(), 1);
	}
}