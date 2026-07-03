package constructores;

public class Detalle_Carrito {
	private String id_detalle_carrito;
	private Producto pro;
	private int cantidad;
	public Detalle_Carrito(String id_detalle_carrito, Producto pro, int cantidad) {
		
		this.id_detalle_carrito = id_detalle_carrito;
		this.pro = pro;
		this.cantidad = cantidad;
	}
	public String getId_detalle_carrito() {
		return id_detalle_carrito;
	}
	public void setId_detalle_carrito(String id_detalle_carrito) {
		this.id_detalle_carrito = id_detalle_carrito;
	}
	public Producto getPro() {
		return pro;
	}
	public void setPro(Producto pro) {
		this.pro = pro;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void Agregar_a_Carrito() {
		
	}
	
	
	
}
