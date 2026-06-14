package constructores;

public class Categoria {
	private String id_categoria;
	private String nombre_categoria;
	private String imagen_categoria;
	
	public Categoria(String id_categoria, String nombre_categoria, String imagen_categoria) {
		this.id_categoria = id_categoria;
		this.nombre_categoria = nombre_categoria;
		this.imagen_categoria = imagen_categoria;
	}
	public String getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(String id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombre_categoria() {
		return nombre_categoria;
	}
	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	public String getImagen_categoria() {
		return imagen_categoria;
	}
	public void setImagen_categoria(String imagen_categoria) {
		this.imagen_categoria = imagen_categoria;
	}
}
