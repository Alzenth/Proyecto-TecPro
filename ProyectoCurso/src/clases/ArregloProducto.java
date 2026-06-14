package clases;

import java.util.ArrayList;

import constructores.Producto;

public class ArregloProducto {
	private ArrayList<Producto> p;
	public ArregloProducto() {
		p=new ArrayList<Producto>();
	}
	
public void Adicionar(Producto x) {
		p.add(x);
	}
	public int Tamaño() {
		return p.size();
	}
	public Producto Obtener(int i) {
	    return p.get(i);
	}
	public Producto Eliminar(String dni) {
		for (int i = 0; i <Tamaño(); i++) {
			if (Obtener(i).getId_prod().equals(dni)) {
				Producto e=Obtener(i);
	            p.remove(i);
	            return e;
	        }
		}
		return null;
	}
}
