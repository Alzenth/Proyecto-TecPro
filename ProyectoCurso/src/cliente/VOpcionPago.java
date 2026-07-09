package cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import conexion.ConexionBD;

public class VOpcionPago extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextArea txtBoleta;
    private JButton btnDescargarPDF;
    private JButton btnCerrar;
    
    private String idVentaActual;
    private String textoBoletaGenerada;

    public VOpcionPago(String idVenta) {
        this.idVentaActual = idVenta; 
        
        setTitle("Comprobante de Pago - MAKEA");
        setBounds(100, 100, 450, 600);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        
        txtBoleta = new JTextArea();
        txtBoleta.setEditable(false);
        
        txtBoleta.setFont(new Font("Monospaced", Font.PLAIN, 12)); 
        scrollPane.setViewportView(txtBoleta);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        btnDescargarPDF = new JButton("Descargar PDF");
        btnDescargarPDF.addActionListener(this);
        buttonPane.add(btnDescargarPDF);
        
        btnCerrar = new JButton("Finalizar y Salir");
        btnCerrar.addActionListener(this);
        buttonPane.add(btnCerrar);
        
        textoBoletaGenerada = generarBoletaImpresa(idVentaActual);
        txtBoleta.setText(textoBoletaGenerada);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDescargarPDF) {
            do_btnDescargarPDF_actionPerformed(e);
        }
        if (e.getSource() == btnCerrar) {
            do_btnCerrar_actionPerformed(e);
        }
    }

    protected void do_btnDescargarPDF_actionPerformed(ActionEvent e) {
        descargarBoletaPDF(textoBoletaGenerada, idVentaActual);
    }

    protected void do_btnCerrar_actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "¡Gracias por su compra en MAKEA!");
        this.dispose(); 
    }
    
    private String generarBoletaImpresa(String idVenta) {
        StringBuilder boleta = new StringBuilder();
        
        
        ConexionBD db = new ConexionBD();
        Connection cnx = db.conectar(); 
        
        if (cnx != null) {
            try {
                CallableStatement csta = cnx.prepareCall("{CALL SP_Mostrar_Detalle_Venta(?)}");
                csta.setString(1, idVenta);
                ResultSet rs = csta.executeQuery();
                
                if (rs.next()) {
                    
                    double opGravada = rs.getDouble("OpGravada");
                    double igv = rs.getDouble("IGV");
                    double total = rs.getDouble("Total");

                    boleta.append("               MAKEA S.A.C.\n");
                    boleta.append("             RUC: 20123456789\n");
                    boleta.append("      AV. LOS POSTRES 1650 - LIMA\n");
                    boleta.append("----------------------------------------\n");
                    
                    boleta.append("BOLETA DE VENTA ELECTRONICA: B001-").append(rs.getString("Ticket")).append("\n");
                    boleta.append("FECHA DE EMISION: ").append(rs.getString("Fecha")).append("\n");
                    boleta.append("CLIENTE:\n");
                    boleta.append("TIPODOC: DNI ").append(rs.getString("DNI")).append("\n");
                    boleta.append("CLIENTE: ").append(rs.getString("Cliente")).append("\n");
                    boleta.append("----------------------------------------\n");
                    
                    
                    do {
                        int cant = rs.getInt("Cantidad");
                        String prod = rs.getString("Producto");
                        double subtotal = rs.getDouble("Subtotal");
                        
                        
                        if (prod.length() > 25) {
                            prod = prod.substring(0, 25);
                        }
                        
                        String lineaProducto = String.format("%-2d %-26s %8.2f\n", cant, prod, subtotal);
                        boleta.append(lineaProducto);
                        
                    } while (rs.next());
                    
                    boleta.append("----------------------------------------\n");
                    
                    
                    boleta.append(String.format("%-30s %8.2f\n", "OP. GRAVADA", opGravada));
                    boleta.append(String.format("%-30s %8.2f\n", "I.G.V. (18%)", igv));
                    boleta.append(String.format("%-27s S/ %8.2f\n", "IMPORTE TOTAL", total));
                    boleta.append(String.format("%-30s %8.2f\n", "VUELTO", 0.00));
                    
                    boleta.append("----------------------------------------\n");
                    boleta.append("Representación impresa de la Boleta de\n");
                    boleta.append("Venta Electrónica. Gracias por comprar\n");
                    boleta.append("              en MAKEA.\n");
                    
                } else {
                    boleta.append("No se encontró el detalle de la venta.");
                }
                
                
                rs.close();
                csta.close();
                cnx.close(); 
                
            } catch (Exception e) {
                System.out.println("Error al generar boleta: " + e.getMessage());
            }
        }
        return boleta.toString();
    }
    
    private void descargarBoletaPDF(String textoBoleta, String idVenta) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Comprobante PDF");
        
        fileChooser.setSelectedFile(new File("Boleta_MAKEA_" + idVenta + ".pdf"));
        
        int userSelection = fileChooser.showSaveDialog(this);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File archivoGuardar = fileChooser.getSelectedFile();
            
            try {
                Document documento = new Document();
                PdfWriter.getInstance(documento, new FileOutputStream(archivoGuardar));
                documento.open();
                
                
                com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 11);
                Paragraph parrafo = new Paragraph(textoBoleta, font);
                
                documento.add(parrafo);
                documento.close();
                
                JOptionPane.showMessageDialog(this, "¡Comprobante PDF guardado con éxito!\nRuta: " + archivoGuardar.getAbsolutePath(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}