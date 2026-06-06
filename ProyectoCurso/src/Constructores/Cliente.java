package Constructores;

public class Cliente extends Usuario{
	private String nombre;
	private String apellido;
	private String dni;
	private String numero;
	private String correo;
	
	public Cliente(String usuario, String contraseña, String nombre, String apellido, String dni, String numero,
			String correo) {
		super(usuario, contraseña);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.numero = numero;
		this.correo = correo;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
