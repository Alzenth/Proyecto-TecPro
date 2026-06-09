package Constructores;

public class Producto {
	private String id_prod;
	private String nombre_prod;
	private String categoria_prod;
	private String descripcion_prod;
	
	private int stock_prod;
	
	private String fechaP_prod;
	private String fechaV_prod;
	
	private double precio_prod;
	
	
	public String getFechaP_prod() {
		return fechaP_prod;
	}
	public void setFechaP_prod(String fechaP_prod) {
		this.fechaP_prod = fechaP_prod;
	}
	public String getFechaV_prod() {
		return fechaV_prod;
	}
	public void setFechaV_prod(String fechaV_prod) {
		this.fechaV_prod = fechaV_prod;
	}
	
	public Producto(String id_prod, String nombre_prod, String categoria_prod, String descripcion_prod, int stock_prod, double precio_prod,String fechaP_prod,String fechaV_prod) {
		this.id_prod = id_prod;
		this.nombre_prod = nombre_prod;
		this.categoria_prod = categoria_prod;
		this.descripcion_prod = descripcion_prod;
		this.stock_prod = stock_prod;
		this.precio_prod = precio_prod;
	    this.fechaP_prod = fechaP_prod;
		this.fechaV_prod = fechaV_prod;
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
	public String getCategoria_prod() {
		return categoria_prod;
	}
	public void setCategoria_prod(String categoria_prod) {
		this.categoria_prod = categoria_prod;
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
	public String getDescripcion_prod() {
		return descripcion_prod;
	}
	public void setDescripcion_prod(String descripcion_prod) {
		this.descripcion_prod = descripcion_prod;
	}	
}
