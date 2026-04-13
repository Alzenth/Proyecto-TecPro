package gui;

import java.util.ArrayList;

public class Arreglo {
	private ArrayList<Cliente> c;
	public Arreglo() {
		c = new ArrayList<Cliente>();
		Adicionar(new Cliente("Luis", "Salazar", "98765432", "987456123", "luissalazar@gmail.com"));
		
	}
	
	public void Adicionar(Cliente x) {
		c.add(x);
	}
	public int Tamaño() {
		return c.size();
	}
	public Cliente Obtener(int x) {
		return c.get(x);
	}
	public Cliente Eliminar(String dni) {
		for (int i = 0; i <Tamaño(); i++) {
			if (Obtener(i).getDni().equals(dni)) {
				Cliente e=Obtener(i);
	            c.remove(i);
	            return e;
	        }
		}
		return null;
	}
	public Cliente Buscar(String dni) {
		for (int i = 0; i <Tamaño(); i++) {
			if (Obtener(i).getDni().equals(dni)) {
	            return Obtener(i);
	        }
		}
		return null;
	}
}



