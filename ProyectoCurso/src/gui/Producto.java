package gui;

public class Producto {
	private String id_prod;
	private String nombre_prod;
	private int stock_prod;
	private double precio_prod;
	public Producto(String id_prod, String nombre_prod, int stock_prod, double precio_prod) {
		this.id_prod = id_prod;
		this.nombre_prod = nombre_prod;
		this.stock_prod = stock_prod;
		this.precio_prod = precio_prod;
	}
	public String getId_prod() {
		return id_prod;
	}
	public void setId_prod(String id_prod) {
		this.id_prod = id_prod;
	}
	public String getNombre_prod() {
		return nombre_prod;
	}
	public void setNombre_prod(String nombre_prod) {
		this.nombre_prod = nombre_prod;
	}
	public int getStock_prod() {
		return stock_prod;
	}
	public void setStock_prod(int stock_prod) {
		this.stock_prod = stock_prod;
	}
	public double getPrecio_prod() {
		return precio_prod;
	}
	public void setPrecio_prod(double precio_prod) {
		this.precio_prod = precio_prod;
	}
}
