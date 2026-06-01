package gui;

import java.util.ArrayList;

public class ArregloEmpleado {
	Empleado admin=new Empleado("Admin","12345678","pepe","perez","dueño","909090909","pepepez@gmail.com");
	private ArrayList<Empleado> e;
	public ArregloEmpleado() {
		e = new ArrayList<Empleado>();
		e.add(admin);
	}
	public void Adicionar(Empleado x) {
		e.add(x);
	}
	public int Tamaño() {
		return e.size();
	}
	public Empleado Obtener(int x) {
		return e.get(x);
	}
	public Empleado Eliminar(String usuario) {
		for (int i = 0; i <Tamaño(); i++) {
			if (Obtener(i).getUsuario().equals(usuario)) {
				Empleado em=Obtener(i);
	            e.remove(i);
	            return em;
	        }
		}
		return null;
	}
	public Empleado Buscar(String usuario) {
		for (int i = 0; i <Tamaño(); i++) {
			if (Obtener(i).getUsuario().equals(usuario)) {
	            return Obtener(i);
	        }
		}
		return null;
	}
}
