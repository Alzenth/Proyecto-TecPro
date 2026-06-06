package Constructores;

public class Empleado extends Usuario{
	private String nombre, apellido, cargo, telefono, correo;

	public Empleado(String usuario, String contraseña, String nombre, String apellido, String cargo, String telefono,
			String correo) {
		super(usuario, contraseña);
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.telefono = telefono;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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
	
	}
	
