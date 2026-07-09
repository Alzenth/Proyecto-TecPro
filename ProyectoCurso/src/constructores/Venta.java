package constructores;

import java.sql.Date;

public class Venta {
	private String id_venta; 
	private String id_cliente; 
	private Date fecha_hora;  
	private String metodo_pago; 
	private double igv;
	public Venta(String id_venta, String id_cliente, Date fecha_hora, String metodo_pago, double igv) {
		super();
		this.id_venta = id_venta;
		this.id_cliente = id_cliente;
		this.fecha_hora = fecha_hora;
		this.metodo_pago = metodo_pago;
		this.igv = igv;
	}
	
	
	public String getId_venta() {
		return id_venta;
	}
	public void setId_venta(String id_venta) {
		this.id_venta = id_venta;
	}
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Date getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	public String getMetodo_pago() {
		return metodo_pago;
	}
	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	public double getIgv() {
		return igv;
	}
	public void setIgv(double igv) {
		this.igv = igv;
	}

	
	
}
