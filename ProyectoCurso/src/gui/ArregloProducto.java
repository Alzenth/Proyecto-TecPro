package gui;

import java.util.ArrayList;

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
}
