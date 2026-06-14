package clases;

import java.util.ArrayList;

import constructores.Cliente;


public class ArregloCliente {
	private ArrayList<Cliente> c;
	public ArregloCliente() {
		c = new ArrayList<Cliente>();
		
		
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
	public Cliente Buscar(String dato) {
		for (int i = 0; i <Tamaño(); i++) {
			if (Obtener(i).getDni().equals(dato)) {
	            return Obtener(i);
	        }
		}
		return null;
	}

}



