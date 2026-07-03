package constructores;

public class Empleado {
	private String nombre, apellido, telefono, correo;
	private Boolean esAdministrador;
	public Empleado(String usuario, String contraseña, String nombre, String apellido, String telefono, String correo,
			Boolean esAdministrador) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
		this.esAdministrador = esAdministrador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Boolean getEsAdministrador() {
		return esAdministrador;
	}
	public void setEsAdministrador(Boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}

	
	
}	
