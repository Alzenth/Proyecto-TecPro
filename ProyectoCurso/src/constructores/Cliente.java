package constructores;

public class Cliente{
	
	private String nombres;
	private String apellidos;
	private String dni;
	private String contraseña;
	private String correo;
	private String numero;
	public Cliente( String nombres, String apellidos, String dni, String contraseña, String correo,
			String numero) {
		
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.contraseña = contraseña;
		this.correo = correo;
		this.numero = numero;
	}
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	

}
