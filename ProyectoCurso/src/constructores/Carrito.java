package constructores;

public class Carrito {
	private String id_carrito, id_cliente;
	private double monto_total;
	private int cantidad_productos;
	public Carrito(String id_carrito, String id_cliente, double monto_total, int cantidad_productos) {
		this.id_carrito = id_carrito;
		this.id_cliente = id_cliente;
		this.monto_total = monto_total;
		this.cantidad_productos = cantidad_productos;
	}
	public String getId_carrito() {
		return id_carrito;
	}
	public void setId_carrito(String id_carrito	) {
		this.id_carrito = id_carrito;
	}
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public double getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(double monto_total) {
		this.monto_total = monto_total;
	}
	public int getCantidad_productos() {
		return cantidad_productos;
	}
	public void setCantidad_productos(int cantidad_productos) {
		this.cantidad_productos = cantidad_productos;
	}
	
}
